package binus.beectf.portal;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes.dex */
public class WorkersNest extends AppCompatActivity {
    private TextView flag;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nest_activity);
        TextView textView = (TextView) findViewById(R.id.Text);
        this.flag = textView;
        textView.setText("Nothing Here, Go Back to Work!!!");
    }
}
