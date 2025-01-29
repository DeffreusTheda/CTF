package n;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f1045a;

    /* renamed from: b, reason: collision with root package name */
    public final g f1046b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f1047c;

    /* renamed from: d, reason: collision with root package name */
    public final File f1048d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1049e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1050f = false;

    /* renamed from: g, reason: collision with root package name */
    public d[] f1051g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f1052h;

    public c(AssetManager assetManager, Executor executor, g gVar, String str, File file) {
        this.f1045a = executor;
        this.f1046b = gVar;
        this.f1049e = str;
        this.f1048d = file;
        int i2 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i2 >= 24 && i2 <= 34) {
            switch (i2) {
                case 24:
                case 25:
                    bArr = h.f1070h;
                    break;
                case 26:
                    bArr = h.f1069g;
                    break;
                case 27:
                    bArr = h.f1068f;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = h.f1067e;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    bArr = h.f1066d;
                    break;
            }
        }
        this.f1047c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f1046b.d();
            }
            return null;
        }
    }

    public final void b(final int i2, final Serializable serializable) {
        this.f1045a.execute(new Runnable() { // from class: n.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.f1046b.a(i2, serializable);
            }
        });
    }
}
