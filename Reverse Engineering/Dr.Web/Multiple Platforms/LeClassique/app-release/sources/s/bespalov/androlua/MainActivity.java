package s.bespalov.androlua;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.keplerproject.luajava.JavaFunction;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    public LuaState L;
    Button check;
    Handler handler;
    final StringBuilder output = new StringBuilder();
    public EditText password;
    public TextView status;

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readAll(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() { // from class: s.bespalov.androlua.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.lambda$onCreate$0(view, windowInsetsCompat);
            }
        });
        Button button = (Button) findViewById(R.id.checkBtn);
        this.check = button;
        button.setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.passwordInput);
        this.password = editText;
        editText.setOnLongClickListener(this);
        TextView textView = (TextView) findViewById(R.id.outputText);
        this.status = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.handler = new Handler();
        initLua();
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    private void initLua() {
        LuaState newLuaState = LuaStateFactory.newLuaState();
        this.L = newLuaState;
        if (newLuaState == null) {
            Toast.makeText(this, "init lua fail", 1).show();
            return;
        }
        newLuaState.openLibs();
        try {
            this.L.pushJavaObject(this);
            this.L.setGlobal("activity");
            new JavaFunction(this.L) { // from class: s.bespalov.androlua.MainActivity.1
                @Override // org.keplerproject.luajava.JavaFunction
                public int execute() throws LuaException {
                    String luaState;
                    for (int i = 2; i <= this.L.getTop(); i++) {
                        String typeName = this.L.typeName(this.L.type(i));
                        if (typeName.equals("userdata")) {
                            Object javaObject = this.L.toJavaObject(i);
                            luaState = javaObject != null ? javaObject.toString() : null;
                        } else if (typeName.equals("boolean")) {
                            luaState = this.L.toBoolean(i) ? "true" : "false";
                        } else {
                            luaState = this.L.toString(i);
                        }
                        if (luaState != null) {
                            typeName = luaState;
                        }
                        MainActivity.this.output.append(typeName);
                        MainActivity.this.output.append("");
                    }
                    MainActivity.this.output.append("");
                    return 0;
                }
            }.register("print");
            JavaFunction javaFunction = new JavaFunction(this.L) { // from class: s.bespalov.androlua.MainActivity.2
                @Override // org.keplerproject.luajava.JavaFunction
                public int execute() throws LuaException {
                    String luaState = this.L.toString(-1);
                    try {
                        this.L.LloadBuffer(MainActivity.readAll(MainActivity.this.getAssets().open(luaState + ".lua")), luaState);
                        return 1;
                    } catch (Exception e) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        e.printStackTrace(new PrintStream(byteArrayOutputStream));
                        this.L.pushString("Cannot load module " + luaState + ":\n" + byteArrayOutputStream.toString());
                        return 1;
                    }
                }
            };
            this.L.getGlobal("package");
            this.L.getField(-1, "loaders");
            int objLen = this.L.objLen(-1);
            this.L.pushJavaFunction(javaFunction);
            this.L.rawSetI(-2, objLen + 1);
            this.L.pop(1);
            this.L.getField(-1, "path");
            this.L.pushString(";" + (getFilesDir() + "/?.lua"));
            this.L.concat(2);
            this.L.setField(-2, "path");
            this.L.pop(1);
        } catch (Exception unused) {
            this.status.setText("Cannot override print");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        StrictMode.ThreadPolicy build = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(build);
        StrictMode.setThreadPolicy(build);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    String safeEvalLua(String str) {
        try {
            return evalLua(str);
        } catch (LuaException e) {
            return e.getMessage() + "\n";
        }
    }

    String evalLua(String str) throws LuaException {
        this.L.setTop(0);
        int LloadString = this.L.LloadString(str);
        if (LloadString == 0) {
            this.L.getGlobal("debug");
            this.L.getField(-1, "traceback");
            this.L.remove(-2);
            this.L.insert(-2);
            LloadString = this.L.pcall(0, 0, -2);
            if (LloadString == 0) {
                String sb = this.output.toString();
                this.output.setLength(0);
                return sb;
            }
        }
        throw new LuaException(errorReason(LloadString) + ": " + this.L.toString(-1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String format = String.format("ctf = require('import')\nctf.check('%s')\n", this.password.getText().toString());
        this.status.setText("");
        try {
            this.status.append(evalLua(format));
        } catch (LuaException e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private String errorReason(int i) {
        if (i == 1) {
            return "Yield error";
        }
        if (i == 2) {
            return "Runtime error";
        }
        if (i == 3) {
            return "Syntax error";
        }
        if (i == 4) {
            return "Out of memory";
        }
        return "Unknown error " + i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.password.setText("");
        return true;
    }
}
