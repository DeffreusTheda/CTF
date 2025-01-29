import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Solve {
  private static final byte[] IV = "SecretofTheBees!".getBytes(StandardCharsets.UTF_8);
  
  public static void main(String[] args) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec("Keyfrombeekeyper".getBytes(StandardCharsets.UTF_8), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(IV));

      byte[] decoded = cipher.doFinal(Base64.getDecoder().decode("tQsCnPDSC6Uy9iNIDN04XQ6b1QOLc9AmidT1rjM8WfI="));

      System.out.println(new String(decoded, StandardCharsets.UTF_8));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
