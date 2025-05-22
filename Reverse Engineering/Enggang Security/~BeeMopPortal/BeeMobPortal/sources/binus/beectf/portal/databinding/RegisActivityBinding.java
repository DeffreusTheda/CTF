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
public final class RegisActivityBinding implements ViewBinding {
    public final TextView loginText;
    public final EditText password;
    public final Button regisButton;
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final EditText username;

    private RegisActivityBinding(ConstraintLayout constraintLayout, TextView textView, EditText editText, Button button, TextView textView2, EditText editText2) {
        this.rootView = constraintLayout;
        this.loginText = textView;
        this.password = editText;
        this.regisButton = button;
        this.textView = textView2;
        this.username = editText2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RegisActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RegisActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.regis_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegisActivityBinding bind(View view) {
        int i = R.id.loginText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.password;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.regisButton;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.textView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.username;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText2 != null) {
                            return new RegisActivityBinding((ConstraintLayout) view, textView, editText, button, textView2, editText2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
