package q;

import android.os.Parcel;
import android.os.Parcelable;
import e.C0024a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: q.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0086b {

    /* renamed from: a, reason: collision with root package name */
    public final C0024a f1135a;

    /* renamed from: b, reason: collision with root package name */
    public final C0024a f1136b;

    /* renamed from: c, reason: collision with root package name */
    public final C0024a f1137c;

    public AbstractC0086b(C0024a c0024a, C0024a c0024a2, C0024a c0024a3) {
        this.f1135a = c0024a;
        this.f1136b = c0024a2;
        this.f1137c = c0024a3;
    }

    public abstract C0087c a();

    public final Class b(Class cls) {
        String name = cls.getName();
        C0024a c0024a = this.f1137c;
        Class cls2 = (Class) c0024a.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        c0024a.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) {
        C0024a c0024a = this.f1135a;
        Method method = (Method) c0024a.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC0086b.class.getClassLoader()).getDeclaredMethod("read", AbstractC0086b.class);
        c0024a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method d(Class cls) {
        String name = cls.getName();
        C0024a c0024a = this.f1136b;
        Method method = (Method) c0024a.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class b2 = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = b2.getDeclaredMethod("write", cls, AbstractC0086b.class);
        c0024a.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i2);

    public final Parcelable f(Parcelable parcelable, int i2) {
        if (!e(i2)) {
            return parcelable;
        }
        return ((C0087c) this).f1139e.readParcelable(C0087c.class.getClassLoader());
    }

    public final InterfaceC0088d g() {
        String readString = ((C0087c) this).f1139e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (InterfaceC0088d) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public abstract void h(int i2);

    public final void i(InterfaceC0088d interfaceC0088d) {
        if (interfaceC0088d == null) {
            ((C0087c) this).f1139e.writeString(null);
            return;
        }
        try {
            ((C0087c) this).f1139e.writeString(b(interfaceC0088d.getClass()).getName());
            C0087c a2 = a();
            try {
                d(interfaceC0088d.getClass()).invoke(null, interfaceC0088d, a2);
                int i2 = a2.f1143i;
                if (i2 >= 0) {
                    int i3 = a2.f1138d.get(i2);
                    Parcel parcel = a2.f1139e;
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i3);
                    parcel.writeInt(dataPosition - i3);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
            } catch (InvocationTargetException e5) {
                if (!(e5.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
                }
                throw ((RuntimeException) e5.getCause());
            }
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(interfaceC0088d.getClass().getSimpleName().concat(" does not have a Parcelizer"), e6);
        }
    }
}
