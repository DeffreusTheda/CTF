import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Solve {
    // at BeeModPortal/sources/binus/beectf/portal/EncUtils.java:12-24
    private static final byte[] IV = "SecretofTheBees!".getBytes(StandardCharsets.UTF_8);

    public static String decryptPassword() {
        try {
            // at BeeModPortal/resources/res/values/strings.xml:51
            SecretKeySpec secretKeySpec = new SecretKeySpec("Keyfrombeekeyper".getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(IV));
            // at BeeModPortal/sources/binus/beectf/portal/LoginActivity.java:40
            byte[] decodedBytes = Base64.getDecoder().decode("tQsCnPDSC6Uy9iNIDN04XQ6b1QOLc9AmidT1rjM8WfI=");
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(decryptPassword());
    }
}
