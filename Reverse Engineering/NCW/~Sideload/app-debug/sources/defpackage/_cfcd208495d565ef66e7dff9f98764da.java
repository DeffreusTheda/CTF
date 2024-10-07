package defpackage;

import androidx.core.internal.view.SupportMenu;

/* loaded from: assets/cfcd208495d565ef66e7dff9f98764da.dex */
public class _cfcd208495d565ef66e7dff9f98764da {
    public static boolean check(String str) {
        int i = ((new int[]{44771}[0] ^ 19658) ^ SupportMenu.USER_MASK) + 63616;
        int i2 = ((((i & SupportMenu.USER_MASK) >> 8) | (i << 8)) & SupportMenu.USER_MASK) - 56449;
        int i3 = ((((((i2 & SupportMenu.USER_MASK) >> 6) | (i2 << 10)) & SupportMenu.USER_MASK) + 1) ^ SupportMenu.USER_MASK) + 0;
        int i4 = ((((((i3 & SupportMenu.USER_MASK) >> 1) | (i3 << 15)) & SupportMenu.USER_MASK) ^ 0) - 1) ^ 2622;
        int i5 = ((((((i4 & SupportMenu.USER_MASK) >> 3) | (i4 << 13)) & SupportMenu.USER_MASK) ^ 5652) + 1) - 0;
        int i6 = ((((i5 & SupportMenu.USER_MASK) >> 2) | (i5 << 14)) & SupportMenu.USER_MASK) - 1;
        int i7 = (((((((i6 & SupportMenu.USER_MASK) >> 5) | (i6 << 11)) & SupportMenu.USER_MASK) + 24158) ^ SupportMenu.USER_MASK) + 21696) - 0;
        int i8 = (((((((((((i7 & SupportMenu.USER_MASK) >> 8) | (i7 << 8)) & SupportMenu.USER_MASK) - 0) ^ SupportMenu.USER_MASK) - 47842) ^ SupportMenu.USER_MASK) + 19702) ^ 60268) + 1) ^ 0;
        int i9 = ((((((((((((((i8 << 15) | ((i8 & SupportMenu.USER_MASK) >> 1)) & SupportMenu.USER_MASK) - 1) ^ 23536) + 1) ^ 0) + 0) ^ SupportMenu.USER_MASK) + 59566) + 0) ^ 0) - 34270) + 0) ^ 19661;
        return str.equals("" + ((char) (((((((i9 << 7) | ((i9 & SupportMenu.USER_MASK) >> 9)) & SupportMenu.USER_MASK) - 1) ^ 27062) + 0) & SupportMenu.USER_MASK)));
    }
}

public static String md5(String s) {
  MessageDigest md = MessageDigest.getInstance("MD5");
  byte[] array = md.digest(s.getBytes());
  StringBuffer sb = new StringBuffer();
  for (byte b : array) {
    sb.append(Integer.toHexString((int) b & 0xFF | 0x100).substring(1, 3));
  }
  return sb.toString();
}


