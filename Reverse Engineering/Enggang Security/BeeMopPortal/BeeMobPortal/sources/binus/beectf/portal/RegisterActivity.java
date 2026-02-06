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
public class RegisterActivity extends AppCompatActivity {
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_USERNAME = "username";
    private static final String PREF_NAME = "MyAppPrefs";
    private TextView loginText;
    private EditText passwordEditText;
    private Button registerButton;
    private SharedPreferences sharedPreferences;
    private EditText usernameEditText;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.regis_activity);
        this.usernameEditText = (EditText) findViewById(R.id.username);
        this.passwordEditText = (EditText) findViewById(R.id.password);
        this.registerButton = (Button) findViewById(R.id.regisButton);
        this.loginText = (TextView) findViewById(R.id.loginText);
        this.sharedPreferences = getSharedPreferences(PREF_NAME, 0);
        this.registerButton.setOnClickListener(new View.OnClickListener() { // from class: binus.beectf.portal.RegisterActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = RegisterActivity.this.usernameEditText.getText().toString();
                String obj2 = RegisterActivity.this.passwordEditText.getText().toString();
                SharedPreferences.Editor edit = RegisterActivity.this.sharedPreferences.edit();
                edit.putString(RegisterActivity.KEY_USERNAME, obj);
                edit.putString(RegisterActivity.KEY_PASSWORD, EncUtils.encryptPassword(RegisterActivity.this, obj2));
                edit.apply();
                Toast.makeText(RegisterActivity.this, "Registration Successful", 0).show();
                RegisterActivity.this.finish();
            }
        });
        this.loginText.setOnClickListener(new View.OnClickListener() { // from class: binus.beectf.portal.RegisterActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, (Class<?>) LoginActivity.class));
            }
        });
    }
}
