package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes2.dex */
public class SplashActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getSupportActionBar().hide();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() { // from class: com.example.myapplication.SplashActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashActivity.this.m5431lambda$onCreate$0$comexamplemyapplicationSplashActivity(view);
            }
        });
    }

    /* renamed from: lambda$onCreate$0$com-example-myapplication-SplashActivity, reason: not valid java name */
    /* synthetic */ void m5431lambda$onCreate$0$comexamplemyapplicationSplashActivity(View view) {
        goToMainActivity();
    }

    void goToMainActivity() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}
