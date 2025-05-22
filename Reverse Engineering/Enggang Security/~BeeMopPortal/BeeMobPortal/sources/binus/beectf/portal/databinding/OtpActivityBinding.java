package binus.beectf.portal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import binus.beectf.portal.R;

/* loaded from: classes.dex */
public final class OtpActivityBinding implements ViewBinding {
    public final EditText otpEditText;
    public final TextView resultTextView;
    private final RelativeLayout rootView;
    public final Button verifyButton;

    private OtpActivityBinding(RelativeLayout relativeLayout, EditText editText, TextView textView, Button button) {
        this.rootView = relativeLayout;
        this.otpEditText = editText;
        this.resultTextView = textView;
        this.verifyButton = button;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OtpActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OtpActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.otp_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OtpActivityBinding bind(View view) {
        int i = R.id.otpEditText;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.resultTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.verifyButton;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    return new OtpActivityBinding((RelativeLayout) view, editText, textView, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
