package binus.beectf.portal;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes.dex */
public class QueenNest extends AppCompatActivity {
    public native String stringFromJNI();

    static {
        System.loadLibrary("portal");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.queen_activity);
        ((TextView) findViewById(R.id.flagText)).setText(stringFromJNI());
    }
}
