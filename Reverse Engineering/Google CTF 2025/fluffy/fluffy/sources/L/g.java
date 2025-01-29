package L;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class g implements h, j {

    /* renamed from: a, reason: collision with root package name */
    public static final g f306a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final g f307b = new g();

    @Override // L.j
    public ByteBuffer a(String str, String str2) {
        JSONArray put = new JSONArray().put("error").put(a.a.A(str)).put(JSONObject.NULL).put(a.a.A(str2));
        if (put == null) {
            return null;
        }
        Object A = a.a.A(put);
        if (A instanceof String) {
            n nVar = n.f313b;
            String quote = JSONObject.quote((String) A);
            nVar.getClass();
            return n.d(quote);
        }
        n nVar2 = n.f313b;
        String obj = A.toString();
        nVar2.getClass();
        return n.d(obj);
    }

    @Override // L.h
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            n.f313b.getClass();
            JSONTokener jSONTokener = new JSONTokener(n.a(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e2) {
            throw new IllegalArgumentException("Invalid JSON", e2);
        }
    }

    @Override // L.h
    public ByteBuffer c(Object obj) {
        if (obj == null) {
            return null;
        }
        Object A = a.a.A(obj);
        if (A instanceof String) {
            n nVar = n.f313b;
            String quote = JSONObject.quote((String) A);
            nVar.getClass();
            return n.d(quote);
        }
        n nVar2 = n.f313b;
        String obj2 = A.toString();
        nVar2.getClass();
        return n.d(obj2);
    }

    @Override // L.j
    public ByteBuffer d(String str, String str2, Object obj) {
        JSONArray put = new JSONArray().put(str).put(a.a.A(str2)).put(a.a.A(obj));
        if (put == null) {
            return null;
        }
        Object A = a.a.A(put);
        if (A instanceof String) {
            n nVar = n.f313b;
            String quote = JSONObject.quote((String) A);
            nVar.getClass();
            return n.d(quote);
        }
        n nVar2 = n.f313b;
        String obj2 = A.toString();
        nVar2.getClass();
        return n.d(obj2);
    }

    @Override // L.j
    public ByteBuffer e(Object obj) {
        JSONArray put = new JSONArray().put(a.a.A(obj));
        if (put == null) {
            return null;
        }
        Object A = a.a.A(put);
        if (A instanceof String) {
            n nVar = n.f313b;
            String quote = JSONObject.quote((String) A);
            nVar.getClass();
            return n.d(quote);
        }
        n nVar2 = n.f313b;
        String obj2 = A.toString();
        nVar2.getClass();
        return n.d(obj2);
    }

    @Override // L.j
    public ByteBuffer f(B.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", (String) aVar.f4c);
            jSONObject.put("args", a.a.A(aVar.f5d));
            Object A = a.a.A(jSONObject);
            if (A instanceof String) {
                n nVar = n.f313b;
                String quote = JSONObject.quote((String) A);
                nVar.getClass();
                return n.d(quote);
            }
            n nVar2 = n.f313b;
            String obj = A.toString();
            nVar2.getClass();
            return n.d(obj);
        } catch (JSONException e2) {
            throw new IllegalArgumentException("Invalid JSON", e2);
        }
    }

    @Override // L.j
    public B.a g(ByteBuffer byteBuffer) {
        Object nextValue;
        Object obj = null;
        try {
            if (byteBuffer == null) {
                nextValue = null;
            } else {
                try {
                    n.f313b.getClass();
                    JSONTokener jSONTokener = new JSONTokener(n.a(byteBuffer));
                    nextValue = jSONTokener.nextValue();
                    if (jSONTokener.more()) {
                        throw new IllegalArgumentException("Invalid JSON");
                    }
                } catch (JSONException e2) {
                    throw new IllegalArgumentException("Invalid JSON", e2);
                }
            }
            if (nextValue instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) nextValue;
                Object obj2 = jSONObject.get("method");
                Object opt = jSONObject.opt("args");
                if (opt != JSONObject.NULL) {
                    obj = opt;
                }
                if (obj2 instanceof String) {
                    return new B.a(obj, (String) obj2);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + nextValue);
        } catch (JSONException e3) {
            throw new IllegalArgumentException("Invalid JSON", e3);
        }
    }

    @Override // L.j
    public Object h(ByteBuffer byteBuffer) {
        Object nextValue;
        Object obj = null;
        if (byteBuffer == null) {
            nextValue = null;
        } else {
            try {
                try {
                    n.f313b.getClass();
                    JSONTokener jSONTokener = new JSONTokener(n.a(byteBuffer));
                    nextValue = jSONTokener.nextValue();
                    if (jSONTokener.more()) {
                        throw new IllegalArgumentException("Invalid JSON");
                    }
                } catch (JSONException e2) {
                    throw new IllegalArgumentException("Invalid JSON", e2);
                }
            } catch (JSONException e3) {
                throw new IllegalArgumentException("Invalid JSON", e3);
            }
        }
        if (nextValue instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) nextValue;
            if (jSONArray.length() == 1) {
                Object opt = jSONArray.opt(0);
                if (opt == JSONObject.NULL) {
                    return null;
                }
                return opt;
            }
            if (jSONArray.length() == 3) {
                Object obj2 = jSONArray.get(0);
                Object opt2 = jSONArray.opt(1);
                Object obj3 = JSONObject.NULL;
                if (opt2 == obj3) {
                    opt2 = null;
                }
                Object opt3 = jSONArray.opt(2);
                if (opt3 != obj3) {
                    obj = opt3;
                }
                if ((obj2 instanceof String) && (opt2 == null || (opt2 instanceof String))) {
                    throw new f((String) obj2, (String) opt2, obj);
                }
            }
        }
        throw new IllegalArgumentException("Invalid envelope: " + nextValue);
    }
}
