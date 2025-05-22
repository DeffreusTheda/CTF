package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.nio.charset.StandardCharsets;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class UnusedActivity extends AppCompatActivity {
    private Context UnusedContext;

    String setStringText() {
        return new String(new byte[]{-48, -105, -48, -76, -48, -66, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -48, -78, -48, -66, 33, 10, 10, -48, -94, -48, -75, -48, -65, -48, -75, -47, ByteCompanionObject.MIN_VALUE, -47, -116, 32, -48, -65, -48, -66, -48, -65, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -48, -79, -47, -125, -48, -71, 32, -48, -67, -48, -80, -48, -71, -47, -126, -48, -72, 32, -48, -79, -48, -80, -48, -73, -47, -125, 32, -48, -76, -48, -80, -48, -67, -48, -67, -47, -117, -47, -123, 32, 34, 111, 117, 116, 66, 100, 46, 100, 98, 34, 32, -48, -78, 32, -47, -124, -48, -80, -48, -71, -48, -69, -48, -80, -47, -123, 32, -48, -65, -47, ByteCompanionObject.MIN_VALUE, -48, -72, -48, -69, -48, -66, -48, -74, -48, -75, -48, -67, -48, -72, -47, -113, 32, 40, 100, 97, 116, 97, 47, 100, 97, 116, 97, 47, 46, 46, 47, 102, 105, 108, 101, 115, 47, 41, 10, 10, -48, -92, -48, -69, -48, -80, -48, -77, 32, -47, -127, -48, -70, -48, -69, -48, -75, -48, -72, -48, -78, -48, -80, -48, -75, -47, -126, -47, -127, -47, -113, 32, -48, -72, -48, -73, 32, -47, -121, -48, -75, -47, -126, -47, -117, -47, ByteCompanionObject.MIN_VALUE, -47, -111, -47, -123, 32, -48, -73, -48, -67, -48, -80, -47, -121, -48, -75, -48, -67, -48, -72, -48, -71, 32, -47, -127, -47, -126, -48, -66, -48, -69, -48, -79, -47, -122, -48, -66, -48, -78, 32, -47, -126, -48, -80, -48, -79, -48, -69, -48, -72, -47, -122, -47, -117, 46, 10, 10, -48, -104, -48, -73, 32, -48, -65, -48, -75, -47, ByteCompanionObject.MIN_VALUE, -48, -78, -48, -66, -48, -77, -48, -66, 32, -47, -127, -47, -126, -48, -66, -48, -69, -48, -79, -47, -122, -48, -80, 32, 40, 99, 111, 108, 111, 109, 110, 49, 41, 32, -48, -67, -47, -125, -48, -74, -48, -67, -48, -66, 32, -48, -78, -48, -73, -47, -113, -47, -126, -47, -116, 32, -47, -127, -47, -126, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -48, -70, -47, -125, 32, -47, -127, 32, -30, -124, -106, 57, 48, 46, 10, 10, -48, -90, -48, -72, -47, -124, -47, ByteCompanionObject.MIN_VALUE, -48, -80, 32, -48, -78, 32, -48, -70, -48, -66, -48, -67, -47, -122, -48, -75, 32, -48, -65, -48, -75, -47, ByteCompanionObject.MIN_VALUE, -48, -78, -48, -66, -48, -71, 32, -47, -121, -48, -80, -47, -127, -47, -126, -48, -72, 32, -47, -124, -48, -69, -48, -80, -48, -77, -48, -80, 32, 45, 32, -48, -67, -48, -66, -48, -68, -48, -75, -47, ByteCompanionObject.MIN_VALUE, 32, -47, -127, -47, -126, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -48, -70, -48, -72, 32, -47, -127, -48, -69, -48, -75, -48, -76, -47, -125, -47, -114, -47, -119, -48, -75, -48, -77, -48, -66, 32, -47, -127, -47, -126, -48, -66, -48, -69, -48, -79, -47, -122, -48, -80, 46, 10, 10, -48, -108, -48, -69, -47, -113, 32, -48, -78, -47, -117, -47, -121, -48, -72, -47, -127, -48, -69, -48, -75, -48, -67, -48, -72, -47, -113, 32, -48, -70, -48, -80, -48, -74, -48, -76, -48, -66, -48, -77, -48, -66, 32, -48, -65, -48, -66, -47, -127, -48, -69, -48, -75, -48, -76, -47, -125, -47, -114, -47, -119, -48, -75, -48, -77, -48, -66, 32, -48, -67, -48, -66, -48, -68, -48, -75, -47, ByteCompanionObject.MIN_VALUE, -48, -80, 32, -47, -127, -47, -126, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -48, -70, -48, -72, 32, -48, -67, -47, -125, -48, -74, -48, -67, -48, -66, 32, -48, -79, -47, ByteCompanionObject.MIN_VALUE, -48, -80, -47, -126, -47, -116, 32, 68, 101, 99, 105, 109, 97, 108, 32, 65, 115, 99, 105, 105, 32, -48, -73, -48, -67, -48, -80, -47, -121, -48, -75, -48, -67, -48, -72, -48, -75, 32, -48, -65, -48, -66, -47, -127, -48, -69, -48, -75, -48, -76, -48, -67, -48, -75, -48, -77, -48, -66, 32, -47, -127, -48, -72, -48, -68, -48, -78, -48, -66, -48, -69, -48, -80, 32, 40, -48, -67, -48, -80, -48, -65, -47, ByteCompanionObject.MIN_VALUE, -48, -72, -48, -68, -48, -75, -47, ByteCompanionObject.MIN_VALUE, 32, 39, 122, 39, 32, Base64.padSymbol, Base64.padSymbol, 32, 49, 50, 50, 44, 32, -47, -127, -48, -69, -48, -75, -48, -76, -48, -66, -48, -78, -48, -80, -47, -126, -48, -75, -48, -69, -47, -116, -48, -67, -48, -66, 32, -48, -72, -48, -73, 32, -47, -127, -48, -69, -48, -75, -48, -76, -47, -125, -47, -114, -47, -119, -48, -75, -48, -77, -48, -66, 32, -47, -127, -47, -126, -48, -66, -48, -69, -48, -79, -47, -122, -48, -80, 32, -48, -67, -47, -125, -48, -74, -48, -67, -48, -66, 32, -48, -78, -48, -73, -47, -113, -47, -126, -47, -116, 32, -47, -127, -47, -126, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -48, -70, -47, -125, 32, 49, 50, 50, 32, -48, -72, 32, -47, -126, 46, -48, -76, 46, 41}, StandardCharsets.UTF_8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Context applicationContext = getApplicationContext();
        super.onCreate(bundle);
        EdgeToEdge.enable(this);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_unused_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() { // from class: com.example.myapplication.UnusedActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return UnusedActivity.lambda$onCreate$0(view, windowInsetsCompat);
            }
        });
        if (MainActivity.getCorrectAnswersCntr() == 9) {
            new qwerasdfasdf(applicationContext);
            this.UnusedContext = getApplicationContext();
            ((TextView) findViewById(R.id.questionTextView)).setText(setStringText());
        }
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }
}
