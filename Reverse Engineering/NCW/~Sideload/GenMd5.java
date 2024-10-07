import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenMd5 {
  public static String md5(String s) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] array = md.digest(s.getBytes());
      StringBuffer sb = new StringBuffer();
      for (byte b : array) {
        sb.append(Integer.toHexString((b & 0xFF) | 256).substring(1, 3));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      return "";
    }
  }
  
  public static void main(String[] args) {
    for (int i = 0; i < 272; ++i) {
      System.out.println("_" + md5(String.valueOf(i)) + ".java");
    }
  //   String directoryPath = "app-debug/resources/assets/";
  //   File directory = new File(directoryPath);
  //   File[] files = directory.listFiles((dir, name) -> name.endsWith(".class"));

  //   if (files == null) {
  //     System.out.println("No .class files found in the specified directory.");
  //     return;
  //   }

  //   // Sort files to ensure consistent order
  //   Arrays.sort(files);

  //   try {
  //     // Create a URLClassLoader to load classes from the directory
  //     URL url = directory.toURI().toURL();
  //     URLClassLoader classLoader = new URLClassLoader(new URL[]{url});

  //     for (char c = 0; c < 272; ++c) {
  //       String className = file.getName().replace(".class", "");
        
  //       try {
  //         // Load the class
  //         file classFile = new File("app-debug/resources/assets/" + + ".dex")
  //         Class<?> clazz = classLoader.loadClass();
          
  //         // Get the check method
  //         Method checkMethod = clazz.getMethod("check", String.class);

  //         // Brute force check for each character
  //         for (char c = 0; c < 256; ++c) {
  //           String str = String.valueOf(c);
  //           Boolean result = (Boolean) checkMethod.invoke(null, str);
  //           if (result) {
  //             System.out.print(c);
  //             break;  // Move to next class after finding the correct character
  //           }
  //         }
  //       } catch (Exception e) {
  //         System.out.println("Error processing class " + className + ": " + e.getMessage());
  //       }
  //     }
  //     System.out.println();  // Print newline after all characters

  //   } catch (Exception e) {
  //     e.printStackTrace();
  //   }
  }
}
