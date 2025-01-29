package n;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f1078a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1079b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1080c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1081d;

    public p(int i2, int i3, long j2, long j3) {
        this.f1078a = i2;
        this.f1079b = i3;
        this.f1080c = j2;
        this.f1081d = j3;
    }

    public static p a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            p pVar = new p(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return pVar;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f1078a);
            dataOutputStream.writeInt(this.f1079b);
            dataOutputStream.writeLong(this.f1080c);
            dataOutputStream.writeLong(this.f1081d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f1079b == pVar.f1079b && this.f1080c == pVar.f1080c && this.f1078a == pVar.f1078a && this.f1081d == pVar.f1081d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f1079b), Long.valueOf(this.f1080c), Integer.valueOf(this.f1078a), Long.valueOf(this.f1081d));
    }
}
