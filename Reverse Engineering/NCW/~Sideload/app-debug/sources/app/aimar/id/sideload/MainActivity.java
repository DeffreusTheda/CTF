package app.aimar.id.sideload;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* loaded from: classes3.dex */
public class MainActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showInputFlagDialog();
    }

    public void showInputFlagDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("National Cyber Week");
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        layout.setPadding(75, 50, 75, 50);
        TextView textView = new TextView(this);
        textView.setText("Enter the flag:");
        layout.addView(textView);
        final EditText editText = new EditText(this);
        layout.addView(editText);
        builder.setView(layout);
        builder.setCancelable(false);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() { // from class: app.aimar.id.sideload.MainActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.m64lambda$showInputFlagDialog$0$appaimaridsideloadMainActivity(editText, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* renamed from: lambda$showInputFlagDialog$0$app-aimar-id-sideload-MainActivity, reason: not valid java name */
    /* synthetic */ void m64lambda$showInputFlagDialog$0$appaimaridsideloadMainActivity(EditText editText, DialogInterface dialog, int which) {
        String flag = editText.getText().toString();
        if (!checkFlag(flag)) {
            finish();
        }
    }

    public boolean checkFlag(String s) {
        Method method;
        Object[] objArr;
        for (int i = 0; i < s.length(); i++) {
            try {
                InputStream is = getAssets().open(md5(String.valueOf(i)) + ".dex");
                File cacheDir = getCacheDir(); //= resources/assets/
                if (!cacheDir.exists()) {
                    cacheDir.mkdirs();
                }
                File file = new File(cacheDir, md5(String.valueOf(i)) + ".dex");
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream os = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                while (true) {
                    int read = is.read(buffer);
                    if (read == -1) {
                        break;
                    }
                    os.write(buffer, 0, read);
                }
                is.close();
                os.close();
                BaseDexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, getClassLoader());
                Class<?> clazz = classLoader.loadClass("_" + md5(String.valueOf(i)));
                method = clazz.getMethod("check", String.class);
                objArr = new Object[1];
            } catch (Exception e) {
                e = e;
            }
            try {
                objArr[0] = String.valueOf(s.charAt(i));
                if (!((Boolean) method.invoke(null, objArr)).booleanValue()) {
                    return false;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(s.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
