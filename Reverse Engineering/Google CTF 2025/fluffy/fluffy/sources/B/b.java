package B;

import D.v;
import K.k;
import L.i;
import L.m;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import n.g;

/* loaded from: classes.dex */
public final class b implements i, g {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6b;

    public /* synthetic */ b(int i2) {
        this.f6b = i2;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a e(Context context, String[] strArr, String str, e eVar) {
        String[] i2 = i(context);
        int length = i2.length;
        int i3 = 0;
        Object[] objArr = 0;
        int i4 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i4 >= length) {
                return null;
            }
            String str2 = i2[i4];
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i5 = i6;
                }
            }
            if (zipFile != null) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i7 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c2 = File.separatorChar;
                            sb.append(c2);
                            sb.append(str3);
                            sb.append(c2);
                            sb.append(str);
                            String sb2 = sb.toString();
                            eVar.getClass();
                            e.g("Looking for %s in APK %s...", sb2, str2);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                a aVar = new a(i3, (boolean) (objArr == true ? 1 : 0));
                                aVar.f4c = zipFile;
                                aVar.f5d = entry;
                                return aVar;
                            }
                        }
                        i7 = i8;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i4++;
        }
    }

    public static String[] f(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c2 = File.separatorChar;
        sb.append(c2);
        sb.append("([^\\");
        sb.append(c2);
        sb.append("]*)");
        sb.append(c2);
        sb.append(str);
        Pattern compile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : i(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static String[] i(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // n.g
    public void a(int i2, Serializable serializable) {
        String str;
        switch (this.f6b) {
            case 8:
                break;
            default:
                switch (i2) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i2 != 6 && i2 != 7 && i2 != 8) {
                    Log.d("ProfileInstaller", str);
                    break;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) serializable);
                    break;
                }
                break;
        }
    }

    @Override // L.i
    public void c(a aVar, k kVar) {
        switch (this.f6b) {
            case 5:
                kVar.c(null);
                break;
            default:
                kVar.c(null);
                break;
        }
    }

    @Override // n.g
    public void d() {
        switch (this.f6b) {
            case 8:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    public b(F.b bVar) {
        this.f6b = 6;
        new e(bVar, "flutter/deferredcomponent", m.f311a).k(new v(6, this));
        a.j().getClass();
        new HashMap();
    }

    private final void g() {
    }

    private final void h(int i2, Serializable serializable) {
    }
}
