package w;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class d implements g<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1396a = new d();

    private d() {
    }

    @Override // w.g
    public Object a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(q.f1416b.a(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e2) {
            throw new IllegalArgumentException("Invalid JSON", e2);
        }
    }

    @Override // w.g
    public ByteBuffer b(Object obj) {
        q qVar;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object a2 = f.a(obj);
        if (a2 instanceof String) {
            qVar = q.f1416b;
            obj2 = JSONObject.quote((String) a2);
        } else {
            qVar = q.f1416b;
            obj2 = a2.toString();
        }
        return qVar.b(obj2);
    }
}
