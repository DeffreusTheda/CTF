using System;
using System.IO;
using System.Text;
using System.Security.Cryptography;
using System.Runtime.InteropServices;

class Program
{
    // Import the necessary Windows Crypto API functions
    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptAcquireContext(out IntPtr phProv, string pszContainer,
        string pszProvider, uint dwProvType, uint dwFlags);

    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptCreateHash(IntPtr hProv, uint Algid, IntPtr hKey, 
        uint dwFlags, out IntPtr phHash);

    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptHashData(IntPtr hHash, byte[] pbData, uint dataLen,
        uint flags);

    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptDeriveKey(IntPtr hProv, uint Algid, IntPtr hHash,
        uint dwFlags, out IntPtr phKey);

    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptDecrypt(IntPtr hKey, IntPtr hHash, bool Final,
        uint dwFlags, byte[] pbData, ref uint pdwDataLen);

    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptDestroyHash(IntPtr hHash);

    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptDestroyKey(IntPtr hKey);

    [DllImport("advapi32.dll", SetLastError = true)]
    static extern bool CryptReleaseContext(IntPtr hProv, uint dwFlags);

    static void Main(string[] args)
    {
        if (args.Length != 3)
        {
            Console.WriteLine("Usage: decrypt.exe <encrypted_file> <output_file> <key>");
            return;
        }

        string encryptedFile = args[0];
        string outputFile = args[1];
        string key = args[2];

        try
        {
            DecryptFile(encryptedFile, outputFile, key);
            Console.WriteLine("Decryption completed successfully!");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }

    static void DecryptFile(string inputFile, string outputFile, string key)
    {
        // Constants from the original code
        const uint PROV_RSA_AES = 24;
        const uint CALG_SHA_512 = 0x8004;
        const uint CALG_AES_256 = 0x6610;
        const uint CRYPT_NEWKEYSET = 0x8;
        
        IntPtr hProv = IntPtr.Zero;
        IntPtr hHash = IntPtr.Zero;
        IntPtr hKey = IntPtr.Zero;

        try
        {
            // Acquire crypto context
            if (!CryptAcquireContext(out hProv, null, 
                "Microsoft Enhanced Cryptographic Provider v1.0",
                PROV_RSA_AES, 0))
            {
                // If first attempt fails, try to create new key container
                if (!CryptAcquireContext(out hProv, null,
                    "Microsoft Enhanced Cryptographic Provider v1.0",
                    PROV_RSA_AES, CRYPT_NEWKEYSET))
                {
                    throw new Exception("Failed to acquire crypto context");
                }
            }

            // Create hash
            if (!CryptCreateHash(hProv, CALG_SHA_512, IntPtr.Zero, 0, out hHash))
                throw new Exception("Failed to create hash");

            // Hash the key
            byte[] keyBytes = Encoding.ASCII.GetBytes(key);
            if (!CryptHashData(hHash, keyBytes, (uint)keyBytes.Length, 0))
                throw new Exception("Failed to hash data");

            // Derive key
            if (!CryptDeriveKey(hProv, CALG_AES_256, hHash, 0x800000, out hKey))
                throw new Exception("Failed to derive key");

            // Process the file in chunks
            using (FileStream inStream = new FileStream(inputFile, FileMode.Open, FileAccess.Read))
            using (FileStream outStream = new FileStream(outputFile, FileMode.Create))
            {
                byte[] buffer = new byte[1000];
                int bytesRead;
                bool isFinal = false;

                while ((bytesRead = inStream.Read(buffer, 0, buffer.Length)) > 0)
                {
                    isFinal = (bytesRead < buffer.Length);
                    uint dataLen = (uint)bytesRead;

                    if (!CryptDecrypt(hKey, IntPtr.Zero, isFinal, 0, buffer, ref dataLen))
                        throw new Exception("Failed to decrypt data");

                    outStream.Write(buffer, 0, (int)dataLen);
                }
            }
        }
        finally
        {
            // Clean up resources
            if (hHash != IntPtr.Zero)
                CryptDestroyHash(hHash);
            if (hKey != IntPtr.Zero)
                CryptDestroyKey(hKey);
            if (hProv != IntPtr.Zero)
                CryptReleaseContext(hProv, 0);
        }
    }
}