package binus.beectf.portal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public class OTP extends AppCompatActivity {
    private String generatedOTP;
    private EditText otpEditText;
    private Button verifyButton;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.otp_activity);
        this.otpEditText = (EditText) findViewById(R.id.otpEditText);
        this.verifyButton = (Button) findViewById(R.id.verifyButton);
        this.generatedOTP = generateOTP();
        this.verifyButton.setOnClickListener(new View.OnClickListener() { // from class: binus.beectf.portal.OTP.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OTP.this.otpEditText.getText().toString().equals(OTP.this.generatedOTP)) {
                    OTP.this.startActivity(new Intent(OTP.this, (Class<?>) QueenNest.class));
                } else {
                    OTP.this.finishAffinity();
                }
            }
        });
    }

    private String generateOTP() {
        return String.valueOf(new SecureRandom().nextInt(900000) + 100000);
    }
}
