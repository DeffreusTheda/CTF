# BeeMopPortal

###### Author: Gengg.

This mobile portal really makes things easier for me when I'm out, but I forgot all about my account and I never use it again because I can't log in.

**Disclaimer: Chall ini merupakan referensi dari Final BeeCTF Binus🐝.**

## Solution

At `sources/binus/beectf/portal/LoginActivity.java`:
```java
this.loginButton.setOnClickListener(new View.OnClickListener() { // from class: binus.beectf.portal.LoginActivity.1  
    @Override // android.view.View.OnClickListener  
    public void onClick(View view) {  
        String obj = LoginActivity.this.usernameEditText.getText().toString();  
        String obj2 = LoginActivity.this.passwordEditText.getText().toString();  
        String string = LoginActivity.this.sharedPreferences.getString(LoginActivity.KEY_USERNAME, null);  
        String string2 = LoginActivity.this.sharedPreferences.getString(LoginActivity.KEY_PASSWORD, null);  
        if (obj.equals("QueenBee") && EncUtils.encryptPassword(LoginActivity.this, obj2).equals("tQsCnPDSC6Uy9iNIDN04XQ6b1QOLc9AmidT1rjM8WfI=")) {  
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, (Class<?>) OTP.class));  
            return;  
        }  
        if (string == null || string2 == null) {  
            Toast.makeText(LoginActivity.this, "Invalid Credentials", 0).show();  
        } else if (!obj.equals(string) || !EncUtils.encryptPassword(LoginActivity.this, obj2).equals(string2)) {  
            Toast.makeText(LoginActivity.this, "Invalid Credentials", 0).show();  
        } else {  
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, (Class<?>) WorkersNest.class));  
        }  
    }  
});
```

![[Reverse Engineering/Enggang Security/~BeeMopPortal/Screenshot 2024-12-30 at 11.18.51.png]]

We're missing the SecretKeySpec's key, and we can search it with ripgrep:

![[Reverse Engineering/Enggang Security/~BeeMopPortal/Screenshot 2024-12-30 at 11.08.19.png]]

The key is `Keyfrombeekeyper`!

```java
   1   │ import javax.crypto.Cipher;
   2   │ import java.nio.charset.StandardCharsets;
   3   │ import javax.crypto.spec.IvParameterSpec;
   4   │ import java.util.Base64;
   5   │ import javax.crypto.spec.SecretKeySpec;
   6   │ 
   7   │ public class Solve {
   8   │   private static final byte[] IV = "SecretofTheBees!".getBytes(StandardCharsets.UTF_8);
   9   │   
  10   │   public static void main(String[] args) {
  11   │     try {
  12   │       SecretKeySpec secretKeySpec = new SecretKeySpec("Keyfrombeekeyper".getBytes(Standar
       │ dCharsets.UTF_8), "AES");
  13   │       Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
  14   │       cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(IV));
  15   │ 
  16   │       byte[] decoded = cipher.doFinal(Base64.getDecoder().decode("tQsCnPDSC6Uy9iNIDN04XQ6
       │ b1QOLc9AmidT1rjM8WfI="));
  17   │ 
  18   │       System.out.println(new String(decoded, StandardCharsets.UTF_8));
  19   │     } catch (Exception e) {
  20   │       e.printStackTrace();
  21   │     }
  22   │   }
  23   │ }
```

```sh
> javac Solve.java; java Solve 
praise_the_queen
```

Flag: `ENSEC_CTF{praise_the_queen}`