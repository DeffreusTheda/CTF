package io.flutter.plugin.editing;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.editing.c;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import v.p;

/* loaded from: classes.dex */
public class b extends BaseInputConnection implements c.b {

    /* renamed from: a, reason: collision with root package name */
    private final View f400a;

    /* renamed from: b, reason: collision with root package name */
    private final int f401b;

    /* renamed from: c, reason: collision with root package name */
    private final p f402c;

    /* renamed from: d, reason: collision with root package name */
    private final c f403d;

    /* renamed from: e, reason: collision with root package name */
    private final EditorInfo f404e;

    /* renamed from: f, reason: collision with root package name */
    private ExtractedTextRequest f405f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f406g;

    /* renamed from: h, reason: collision with root package name */
    private CursorAnchorInfo.Builder f407h;

    /* renamed from: i, reason: collision with root package name */
    private ExtractedText f408i;

    /* renamed from: j, reason: collision with root package name */
    private InputMethodManager f409j;

    /* renamed from: k, reason: collision with root package name */
    private final Layout f410k;

    /* renamed from: l, reason: collision with root package name */
    private io.flutter.plugin.editing.a f411l;

    /* renamed from: m, reason: collision with root package name */
    private final a f412m;

    /* renamed from: n, reason: collision with root package name */
    private int f413n;

    public interface a {
        boolean a(KeyEvent keyEvent);
    }

    public b(View view, int i2, p pVar, a aVar, c cVar, EditorInfo editorInfo) {
        this(view, i2, pVar, aVar, cVar, editorInfo, new FlutterJNI());
    }

    public b(View view, int i2, p pVar, a aVar, c cVar, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f406g = false;
        this.f408i = new ExtractedText();
        this.f413n = 0;
        this.f400a = view;
        this.f401b = i2;
        this.f402c = pVar;
        this.f403d = cVar;
        cVar.a(this);
        this.f404e = editorInfo;
        this.f412m = aVar;
        this.f411l = new io.flutter.plugin.editing.a(flutterJNI);
        this.f410k = new DynamicLayout(cVar, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f409j = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    private boolean b(int i2) {
        if (i2 == 16908319) {
            setSelection(0, this.f403d.length());
            return true;
        }
        if (i2 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f403d);
            int selectionEnd = Selection.getSelectionEnd(this.f403d);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f400a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f403d.subSequence(min, max)));
                this.f403d.delete(min, max);
                setSelection(min, min);
            }
            return true;
        }
        if (i2 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f403d);
            int selectionEnd2 = Selection.getSelectionEnd(this.f403d);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f400a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f403d.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        }
        if (i2 != 16908322) {
            return false;
        }
        ClipData primaryClip = ((ClipboardManager) this.f400a.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip != null) {
            CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f400a.getContext());
            int max2 = Math.max(0, Selection.getSelectionStart(this.f403d));
            int max3 = Math.max(0, Selection.getSelectionEnd(this.f403d));
            int min2 = Math.min(max2, max3);
            int max4 = Math.max(max2, max3);
            if (min2 != max4) {
                this.f403d.delete(min2, max4);
            }
            this.f403d.insert(min2, coerceToText);
            int length = min2 + coerceToText.length();
            setSelection(length, length);
        }
        return true;
    }

    private CursorAnchorInfo c() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.f407h;
        if (builder == null) {
            this.f407h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f407h.setSelectionRange(this.f403d.i(), this.f403d.h());
        int g2 = this.f403d.g();
        int f2 = this.f403d.f();
        if (g2 < 0 || f2 <= g2) {
            this.f407h.setComposingText(-1, "");
        } else {
            this.f407h.setComposingText(g2, this.f403d.toString().subSequence(g2, f2));
        }
        return this.f407h.build();
    }

    private ExtractedText d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.f408i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.f403d.i();
        this.f408i.selectionEnd = this.f403d.h();
        this.f408i.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.f403d.toString() : this.f403d;
        return this.f408i;
    }

    private boolean e(boolean z2, boolean z3) {
        int selectionStart = Selection.getSelectionStart(this.f403d);
        int selectionEnd = Selection.getSelectionEnd(this.f403d);
        boolean z4 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int max = z2 ? Math.max(this.f411l.b(this.f403d, selectionEnd), 0) : Math.min(this.f411l.a(this.f403d, selectionEnd), this.f403d.length());
        if (selectionStart == selectionEnd && !z3) {
            z4 = true;
        }
        if (z4) {
            setSelection(max, max);
        } else {
            setSelection(selectionStart, max);
        }
        return true;
    }

    private boolean g(boolean z2, boolean z3) {
        int selectionStart = Selection.getSelectionStart(this.f403d);
        int selectionEnd = Selection.getSelectionEnd(this.f403d);
        boolean z4 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z3) {
            z4 = true;
        }
        beginBatchEdit();
        if (z4) {
            if (z2) {
                Selection.moveUp(this.f403d, this.f410k);
            } else {
                Selection.moveDown(this.f403d, this.f410k);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f403d);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z2) {
                Selection.extendUp(this.f403d, this.f410k);
            } else {
                Selection.extendDown(this.f403d, this.f410k);
            }
            setSelection(Selection.getSelectionStart(this.f403d), Selection.getSelectionEnd(this.f403d));
        }
        endBatchEdit();
        return true;
    }

    private byte[] h(InputStream inputStream, int i2) {
        int i3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i2];
        while (true) {
            try {
                i3 = inputStream.read(bArr);
            } catch (IOException unused) {
                i3 = -1;
            }
            if (i3 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
    }

    @Override // io.flutter.plugin.editing.c.b
    public void a(boolean z2, boolean z3, boolean z4) {
        this.f409j.updateSelection(this.f400a, this.f403d.i(), this.f403d.h(), this.f403d.g(), this.f403d.f());
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        ExtractedTextRequest extractedTextRequest = this.f405f;
        if (extractedTextRequest != null) {
            this.f409j.updateExtractedText(this.f400a, extractedTextRequest.token, d(extractedTextRequest));
        }
        if (this.f406g) {
            this.f409j.updateCursorAnchorInfo(this.f400a, c());
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f403d.b();
        this.f413n++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i2) {
        return super.clearMetaKeyStates(i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.f403d.l(this);
        while (this.f413n > 0) {
            endBatchEdit();
            this.f413n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    @TargetApi(25)
    public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    Uri contentUri = inputContentInfo.getContentUri();
                    String mimeType = inputContentInfo.getDescription().getMimeType(0);
                    Context context = this.f400a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (openInputStream != null) {
                                byte[] h2 = h(openInputStream, 65536);
                                HashMap hashMap = new HashMap();
                                hashMap.put("mimeType", mimeType);
                                hashMap.put("data", h2);
                                hashMap.put("uri", contentUri.toString());
                                this.f402c.b(this.f401b, hashMap);
                                inputContentInfo.releasePermission();
                                return true;
                            }
                        } catch (FileNotFoundException unused) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i2) {
        return super.commitText(charSequence, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        if (this.f403d.i() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        return super.deleteSurroundingTextInCodePoints(i2, i3);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f413n--;
        this.f403d.d();
        return endBatchEdit;
    }

    public boolean f(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 59 && keyEvent.getKeyCode() != 60)) {
                return false;
            }
            int selectionEnd = Selection.getSelectionEnd(this.f403d);
            setSelection(selectionEnd, selectionEnd);
            return true;
        }
        if (keyEvent.getKeyCode() == 21) {
            return e(true, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 22) {
            return e(false, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 19) {
            return g(true, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 20) {
            return g(false, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
            EditorInfo editorInfo = this.f404e;
            if ((131072 & editorInfo.inputType) == 0) {
                performEditorAction(editorInfo.imeOptions & 255);
                return true;
            }
        }
        int selectionStart = Selection.getSelectionStart(this.f403d);
        int selectionEnd2 = Selection.getSelectionEnd(this.f403d);
        int unicodeChar = keyEvent.getUnicodeChar();
        if (selectionStart < 0 || selectionEnd2 < 0 || unicodeChar == 0) {
            return false;
        }
        int min = Math.min(selectionStart, selectionEnd2);
        int max = Math.max(selectionStart, selectionEnd2);
        beginBatchEdit();
        if (min != max) {
            this.f403d.delete(min, max);
        }
        this.f403d.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
        int i2 = min + 1;
        setSelection(i2, i2);
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.f403d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i2) {
        boolean z2 = (i2 & 1) != 0;
        if (z2 == (this.f405f == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z2 ? "on" : "off");
            j.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f405f = z2 ? extractedTextRequest : null;
        return d(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i2) {
        beginBatchEdit();
        boolean b2 = b(i2);
        endBatchEdit();
        return b2;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i2) {
        if (i2 == 0) {
            this.f402c.o(this.f401b);
        } else if (i2 == 1) {
            this.f402c.g(this.f401b);
        } else if (i2 == 2) {
            this.f402c.f(this.f401b);
        } else if (i2 == 3) {
            this.f402c.l(this.f401b);
        } else if (i2 == 4) {
            this.f402c.m(this.f401b);
        } else if (i2 == 5) {
            this.f402c.h(this.f401b);
        } else if (i2 != 7) {
            this.f402c.e(this.f401b);
        } else {
            this.f402c.j(this.f401b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f402c.i(this.f401b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i2 & 1) != 0) {
            this.f409j.updateCursorAnchorInfo(this.f400a, c());
        }
        boolean z2 = (i2 & 2) != 0;
        if (z2 != this.f406g) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z2 ? "on" : "off");
            j.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f406g = z2;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f412m.a(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i2, int i3) {
        return super.setComposingRegion(i2, i3);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i2) {
        beginBatchEdit();
        boolean commitText = charSequence.length() == 0 ? super.commitText(charSequence, i2) : super.setComposingText(charSequence, i2);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i2, int i3) {
        beginBatchEdit();
        boolean selection = super.setSelection(i2, i3);
        endBatchEdit();
        return selection;
    }
}
