package n;

import android.content.pm.PackageInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final B.b f1063a = new B.b(8);

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1064b = {112, 114, 111, 0};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f1065c = {112, 114, 109, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f1066d = {48, 49, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f1067e = {48, 49, 48, 0};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f1068f = {48, 48, 57, 0};

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f1069g = {48, 48, 53, 0};

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f1070h = {48, 48, 49, 0};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f1071i = {48, 48, 49, 0};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f1072j = {48, 48, 50, 0};

    public static byte[] a(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static byte[] b(d[] dVarArr, byte[] bArr) {
        int i2 = 0;
        for (d dVar : dVarArr) {
            i2 += ((((dVar.f1059g * 2) + 7) & (-8)) / 8) + (dVar.f1057e * 2) + d(dVar.f1053a, dVar.f1054b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + dVar.f1058f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        if (Arrays.equals(bArr, f1068f)) {
            for (d dVar2 : dVarArr) {
                p(byteArrayOutputStream, dVar2, d(dVar2.f1053a, dVar2.f1054b, bArr));
                r(byteArrayOutputStream, dVar2);
                int[] iArr = dVar2.f1060h;
                int length = iArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = iArr[i3];
                    u(byteArrayOutputStream, i5 - i4);
                    i3++;
                    i4 = i5;
                }
                q(byteArrayOutputStream, dVar2);
            }
        } else {
            for (d dVar3 : dVarArr) {
                p(byteArrayOutputStream, dVar3, d(dVar3.f1053a, dVar3.f1054b, bArr));
            }
            for (d dVar4 : dVarArr) {
                r(byteArrayOutputStream, dVar4);
                int[] iArr2 = dVar4.f1060h;
                int length2 = iArr2.length;
                int i6 = 0;
                int i7 = 0;
                while (i6 < length2) {
                    int i8 = iArr2[i6];
                    u(byteArrayOutputStream, i8 - i7);
                    i6++;
                    i7 = i8;
                }
                q(byteArrayOutputStream, dVar4);
            }
        }
        if (byteArrayOutputStream.size() == i2) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i2);
    }

    public static boolean c(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z2 = true;
        for (File file2 : listFiles) {
            z2 = c(file2) && z2;
        }
        return z2;
    }

    public static String d(String str, String str2, byte[] bArr) {
        byte[] bArr2 = f1070h;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = f1069g;
        String str3 = (equals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            return "!".equals(str3) ? str2.replace(":", "!") : ":".equals(str3) ? str2.replace("!", ":") : str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return "!".equals(str3) ? str2.replace(":", "!") : ":".equals(str3) ? str2.replace("!", ":") : str2;
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append((Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!");
        sb.append(str2);
        return sb.toString();
    }

    public static void e(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] f(InputStream inputStream, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read < 0) {
                throw new IllegalStateException("Not enough bytes to read: " + i2);
            }
            i3 += read;
        }
        return bArr;
    }

    public static int[] g(ByteArrayInputStream byteArrayInputStream, int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += (int) m(byteArrayInputStream, 2);
            iArr[i4] = i3;
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r0.finished() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] h(java.io.FileInputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L2e
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2e
            r3 = 0
            r4 = 0
            r5 = 0
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            if (r4 >= r9) goto L57
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L2e
            if (r6 < 0) goto L3b
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L2e
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.lang.Throwable -> L2e java.util.zip.DataFormatException -> L30
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            goto L8a
        L30:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L3b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L57:
            if (r4 != r9) goto L6b
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L63
            r0.end()
            return r1
        L63:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            r8.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L8a:
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n.h.h(java.io.FileInputStream, int, int):byte[]");
    }

    public static d[] i(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, d[] dVarArr) {
        byte[] bArr3 = f1071i;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, f1072j)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int m = (int) m(fileInputStream, 2);
            byte[] h2 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(h2);
            try {
                d[] k2 = k(byteArrayInputStream, bArr2, m, dVarArr);
                byteArrayInputStream.close();
                return k2;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(f1066d, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int m2 = (int) m(fileInputStream, 1);
        byte[] h3 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(h3);
        try {
            d[] j2 = j(byteArrayInputStream2, m2, dVarArr);
            byteArrayInputStream2.close();
            return j2;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static d[] j(ByteArrayInputStream byteArrayInputStream, int i2, d[] dVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new d[0];
        }
        if (i2 != dVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i2];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int m = (int) m(byteArrayInputStream, 2);
            iArr[i3] = (int) m(byteArrayInputStream, 2);
            strArr[i3] = new String(f(byteArrayInputStream, m), StandardCharsets.UTF_8);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            d dVar = dVarArr[i4];
            if (!dVar.f1054b.equals(strArr[i4])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i5 = iArr[i4];
            dVar.f1057e = i5;
            dVar.f1060h = g(byteArrayInputStream, i5);
        }
        return dVarArr;
    }

    public static d[] k(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i2, d[] dVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new d[0];
        }
        if (i2 != dVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            m(byteArrayInputStream, 2);
            String str = new String(f(byteArrayInputStream, (int) m(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long m = m(byteArrayInputStream, 4);
            int m2 = (int) m(byteArrayInputStream, 2);
            d dVar = null;
            if (dVarArr.length > 0) {
                int indexOf = str.indexOf("!");
                if (indexOf < 0) {
                    indexOf = str.indexOf(":");
                }
                String substring = indexOf > 0 ? str.substring(indexOf + 1) : str;
                int i4 = 0;
                while (true) {
                    if (i4 >= dVarArr.length) {
                        break;
                    }
                    if (dVarArr[i4].f1054b.equals(substring)) {
                        dVar = dVarArr[i4];
                        break;
                    }
                    i4++;
                }
            }
            if (dVar == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            dVar.f1056d = m;
            int[] g2 = g(byteArrayInputStream, m2);
            if (Arrays.equals(bArr, f1070h)) {
                dVar.f1057e = m2;
                dVar.f1060h = g2;
            }
        }
        return dVarArr;
    }

    public static d[] l(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (!Arrays.equals(bArr, f1067e)) {
            throw new IllegalStateException("Unsupported version");
        }
        int m = (int) m(fileInputStream, 1);
        byte[] h2 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(h2);
        try {
            d[] n2 = n(byteArrayInputStream, str, m);
            byteArrayInputStream.close();
            return n2;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long m(InputStream inputStream, int i2) {
        byte[] f2 = f(inputStream, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 += (f2[i3] & 255) << (i3 * 8);
        }
        return j2;
    }

    public static d[] n(ByteArrayInputStream byteArrayInputStream, String str, int i2) {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int m = (int) m(byteArrayInputStream, 2);
            int m2 = (int) m(byteArrayInputStream, 2);
            dVarArr[i3] = new d(str, new String(f(byteArrayInputStream, m), StandardCharsets.UTF_8), m(byteArrayInputStream, 4), m2, (int) m(byteArrayInputStream, 4), (int) m(byteArrayInputStream, 4), new int[m2], new TreeMap());
        }
        for (int i4 = 0; i4 < i2; i4++) {
            d dVar = dVarArr[i4];
            int available = byteArrayInputStream.available() - dVar.f1058f;
            int i5 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = dVar.f1061i;
                if (available2 <= available) {
                    break;
                }
                i5 += (int) m(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(i5), 1);
                for (int m3 = (int) m(byteArrayInputStream, 2); m3 > 0; m3--) {
                    m(byteArrayInputStream, 2);
                    int m4 = (int) m(byteArrayInputStream, 1);
                    if (m4 != 6 && m4 != 7) {
                        while (m4 > 0) {
                            m(byteArrayInputStream, 1);
                            for (int m5 = (int) m(byteArrayInputStream, 1); m5 > 0; m5--) {
                                m(byteArrayInputStream, 2);
                            }
                            m4--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != available) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            dVar.f1060h = g(byteArrayInputStream, dVar.f1057e);
            int i6 = dVar.f1059g;
            BitSet valueOf = BitSet.valueOf(f(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = valueOf.get(i7) ? 2 : 0;
                if (valueOf.get(i7 + i6)) {
                    i8 |= 4;
                }
                if (i8 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i7));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i7), Integer.valueOf(i8 | num.intValue()));
                }
            }
        }
        return dVarArr;
    }

    /* JADX WARN: Finally extract failed */
    public static boolean o(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, d[] dVarArr) {
        long j2;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f1066d;
        int i2 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = f1067e;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] b2 = b(dVarArr, bArr3);
                t(byteArrayOutputStream, dVarArr.length, 1);
                t(byteArrayOutputStream, b2.length, 4);
                byte[] a2 = a(b2);
                t(byteArrayOutputStream, a2.length, 4);
                byteArrayOutputStream.write(a2);
                return true;
            }
            byte[] bArr4 = f1069g;
            if (Arrays.equals(bArr, bArr4)) {
                t(byteArrayOutputStream, dVarArr.length, 1);
                for (d dVar : dVarArr) {
                    int size = dVar.f1061i.size() * 4;
                    String d2 = d(dVar.f1053a, dVar.f1054b, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    u(byteArrayOutputStream, d2.getBytes(charset).length);
                    u(byteArrayOutputStream, dVar.f1060h.length);
                    t(byteArrayOutputStream, size, 4);
                    t(byteArrayOutputStream, dVar.f1055c, 4);
                    byteArrayOutputStream.write(d2.getBytes(charset));
                    Iterator it = dVar.f1061i.keySet().iterator();
                    while (it.hasNext()) {
                        u(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        u(byteArrayOutputStream, 0);
                    }
                    for (int i3 : dVar.f1060h) {
                        u(byteArrayOutputStream, i3);
                    }
                }
                return true;
            }
            byte[] bArr5 = f1068f;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] b3 = b(dVarArr, bArr5);
                t(byteArrayOutputStream, dVarArr.length, 1);
                t(byteArrayOutputStream, b3.length, 4);
                byte[] a3 = a(b3);
                t(byteArrayOutputStream, a3.length, 4);
                byteArrayOutputStream.write(a3);
                return true;
            }
            byte[] bArr6 = f1070h;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            u(byteArrayOutputStream, dVarArr.length);
            for (d dVar2 : dVarArr) {
                String d3 = d(dVar2.f1053a, dVar2.f1054b, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                u(byteArrayOutputStream, d3.getBytes(charset2).length);
                TreeMap treeMap = dVar2.f1061i;
                u(byteArrayOutputStream, treeMap.size());
                u(byteArrayOutputStream, dVar2.f1060h.length);
                t(byteArrayOutputStream, dVar2.f1055c, 4);
                byteArrayOutputStream.write(d3.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    u(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i4 : dVar2.f1060h) {
                    u(byteArrayOutputStream, i4);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            u(byteArrayOutputStream2, dVarArr.length);
            int i5 = 2;
            int i6 = 2;
            for (d dVar3 : dVarArr) {
                t(byteArrayOutputStream2, dVar3.f1055c, 4);
                t(byteArrayOutputStream2, dVar3.f1056d, 4);
                t(byteArrayOutputStream2, dVar3.f1059g, 4);
                String d4 = d(dVar3.f1053a, dVar3.f1054b, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = d4.getBytes(charset3).length;
                u(byteArrayOutputStream2, length2);
                i6 = i6 + 14 + length2;
                byteArrayOutputStream2.write(d4.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i6 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            }
            r rVar = new r(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(rVar);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i7 = 0;
            int i8 = 0;
            while (i7 < dVarArr.length) {
                try {
                    d dVar4 = dVarArr[i7];
                    u(byteArrayOutputStream3, i7);
                    u(byteArrayOutputStream3, dVar4.f1057e);
                    i8 = i8 + 4 + (dVar4.f1057e * 2);
                    int[] iArr = dVar4.f1060h;
                    int length3 = iArr.length;
                    int i9 = 0;
                    while (i2 < length3) {
                        int i10 = iArr[i2];
                        u(byteArrayOutputStream3, i10 - i9);
                        i2++;
                        i9 = i10;
                    }
                    i7++;
                    i2 = 0;
                } catch (Throwable th) {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i8 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
            }
            r rVar2 = new r(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(rVar2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i11 = 0;
            int i12 = 0;
            while (i11 < dVarArr.length) {
                try {
                    d dVar5 = dVarArr[i11];
                    Iterator it3 = dVar5.f1061i.entrySet().iterator();
                    int i13 = 0;
                    while (it3.hasNext()) {
                        i13 |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        q(byteArrayOutputStream4, dVar5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            r(byteArrayOutputStream4, dVar5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            u(byteArrayOutputStream3, i11);
                            int length4 = byteArray3.length + i5 + byteArray4.length;
                            int i14 = i12 + 6;
                            ArrayList arrayList4 = arrayList3;
                            t(byteArrayOutputStream3, length4, 4);
                            u(byteArrayOutputStream3, i13);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i12 = i14 + length4;
                            i11++;
                            arrayList3 = arrayList4;
                            i5 = 2;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i12 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i12 + ", does not match actual size " + byteArray5.length);
            }
            r rVar3 = new r(4, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(rVar3);
            long j3 = 4;
            long size2 = j3 + j3 + 4 + (arrayList2.size() * 16);
            t(byteArrayOutputStream, arrayList2.size(), 4);
            int i15 = 0;
            while (i15 < arrayList2.size()) {
                r rVar4 = (r) arrayList2.get(i15);
                int i16 = rVar4.f1085a;
                if (i16 == 1) {
                    j2 = 0;
                } else if (i16 == 2) {
                    j2 = 1;
                } else if (i16 == 3) {
                    j2 = 2;
                } else if (i16 == 4) {
                    j2 = 3;
                } else {
                    if (i16 != 5) {
                        throw null;
                    }
                    j2 = 4;
                }
                t(byteArrayOutputStream, j2, 4);
                t(byteArrayOutputStream, size2, 4);
                byte[] bArr7 = rVar4.f1086b;
                if (rVar4.f1087c) {
                    long length5 = bArr7.length;
                    byte[] a4 = a(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(a4);
                    t(byteArrayOutputStream, a4.length, 4);
                    t(byteArrayOutputStream, length5, 4);
                    length = a4.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    t(byteArrayOutputStream, bArr7.length, 4);
                    t(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += length;
                i15++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i17 = 0; i17 < arrayList6.size(); i17++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i17));
            }
            return true;
        } catch (Throwable th3) {
            try {
                byteArrayOutputStream2.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static void p(ByteArrayOutputStream byteArrayOutputStream, d dVar, String str) {
        Charset charset = StandardCharsets.UTF_8;
        u(byteArrayOutputStream, str.getBytes(charset).length);
        u(byteArrayOutputStream, dVar.f1057e);
        t(byteArrayOutputStream, dVar.f1058f, 4);
        t(byteArrayOutputStream, dVar.f1055c, 4);
        t(byteArrayOutputStream, dVar.f1059g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void q(ByteArrayOutputStream byteArrayOutputStream, d dVar) {
        byte[] bArr = new byte[(((dVar.f1059g * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : dVar.f1061i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                int i2 = intValue / 8;
                bArr[i2] = (byte) (bArr[i2] | (1 << (intValue % 8)));
            }
            if ((intValue2 & 4) != 0) {
                int i3 = intValue + dVar.f1059g;
                int i4 = i3 / 8;
                bArr[i4] = (byte) ((1 << (i3 % 8)) | bArr[i4]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void r(ByteArrayOutputStream byteArrayOutputStream, d dVar) {
        int i2 = 0;
        for (Map.Entry entry : dVar.f1061i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                u(byteArrayOutputStream, intValue - i2);
                u(byteArrayOutputStream, 0);
                i2 = intValue;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ca, code lost:
    
        if (r5 == null) goto L131;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void s(android.content.Context r19, java.util.concurrent.Executor r20, n.g r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.h.s(android.content.Context, java.util.concurrent.Executor, n.g, boolean):void");
    }

    public static void t(ByteArrayOutputStream byteArrayOutputStream, long j2, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((j2 >> (i3 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void u(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        t(byteArrayOutputStream, i2, 2);
    }
}
