package binus.beectf.portal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes.dex */
public class LoginActivity extends AppCompatActivity {
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_USERNAME = "username";
    private static final String PREF_NAME = "MyAppPrefs";
    private Button loginButton;
    private EditText passwordEditText;
    private TextView registerText;
    private SharedPreferences sharedPreferences;
    private EditText usernameEditText;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.login_activity);
        this.usernameEditText = (EditText) findViewById(R.id.username);
        this.passwordEditText = (EditText) findViewById(R.id.password);
        this.loginButton = (Button) findViewById(R.id.loginButton);
        this.registerText = (TextView) findViewById(R.id.registerText);
        this.sharedPreferences = getSharedPreferences(PREF_NAME, 0);
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
        this.registerText.setOnClickListener(new View.OnClickListener() { // from class: binus.beectf.portal.LoginActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, (Class<?>) RegisterActivity.class));
            }
        });
    }
}
