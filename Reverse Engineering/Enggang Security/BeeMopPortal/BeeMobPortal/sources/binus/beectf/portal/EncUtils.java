package binus.beectf.portal;

import android.content.Context;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class EncUtils {
    private static final byte[] IV = "SecretofTheBees!".getBytes(StandardCharsets.UTF_8);

    public static String encryptPassword(Context context, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(context.getString(R.string.keystore).getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(IV));
            return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
