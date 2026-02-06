package binus.beectf.portal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import binus.beectf.portal.R;

/* loaded from: classes.dex */
public final class LoginActivityBinding implements ViewBinding {
    public final Button loginButton;
    public final EditText password;
    public final TextView registerText;
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final EditText username;

    private LoginActivityBinding(ConstraintLayout constraintLayout, Button button, EditText editText, TextView textView, TextView textView2, EditText editText2) {
        this.rootView = constraintLayout;
        this.loginButton = button;
        this.password = editText;
        this.registerText = textView;
        this.textView = textView2;
        this.username = editText2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LoginActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LoginActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.login_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LoginActivityBinding bind(View view) {
        int i = R.id.loginButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.password;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.registerText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.textView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.username;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText2 != null) {
                            return new LoginActivityBinding((ConstraintLayout) view, button, editText, textView, textView2, editText2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
