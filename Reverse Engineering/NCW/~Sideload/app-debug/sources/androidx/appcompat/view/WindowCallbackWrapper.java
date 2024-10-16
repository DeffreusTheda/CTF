package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* loaded from: classes.dex */
public class WindowCallbackWrapper implements Window.Callback {
    final Window.Callback mWrapped;

    public WindowCallbackWrapper(Window.Callback wrapped) {
        if (wrapped == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.mWrapped = wrapped;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        return this.mWrapped.dispatchKeyEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return this.mWrapped.dispatchKeyShortcutEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        return this.mWrapped.dispatchTouchEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent event) {
        return this.mWrapped.dispatchTrackballEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        return this.mWrapped.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(event);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int featureId) {
        return this.mWrapped.onCreatePanelView(featureId);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return this.mWrapped.onCreatePanelMenu(featureId, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return this.mWrapped.onPreparePanel(featureId, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int featureId, Menu menu) {
        return this.mWrapped.onMenuOpened(featureId, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return this.mWrapped.onMenuItemSelected(featureId, item);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {
        this.mWrapped.onWindowAttributesChanged(attrs);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        this.mWrapped.onWindowFocusChanged(hasFocus);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int featureId, Menu menu) {
        this.mWrapped.onPanelClosed(featureId, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return Api23Impl.onSearchRequested(this.mWrapped, searchEvent);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mWrapped.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return Api23Impl.onWindowStartingActionMode(this.mWrapped, callback, type);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode mode) {
        this.mWrapped.onActionModeStarted(mode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode mode) {
        this.mWrapped.onActionModeFinished(mode);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, data, menu, deviceId);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean hasCapture) {
        Api26Impl.onPointerCaptureChanged(this.mWrapped, hasCapture);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean onSearchRequested(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        static android.view.ActionMode onWindowStartingActionMode(Window.Callback windowCallback, ActionMode.Callback actionModeCallback, int i) {
            return windowCallback.onWindowStartingActionMode(actionModeCallback, i);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void onProvideKeyboardShortcuts(Window.Callback callback, List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
            callback.onProvideKeyboardShortcuts(data, menu, deviceId);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void onPointerCaptureChanged(Window.Callback callback, boolean hasCapture) {
            callback.onPointerCaptureChanged(hasCapture);
        }
    }
}
