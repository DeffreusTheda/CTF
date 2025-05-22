package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = new Object();

    private AppLocalesStorageHelper() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0043, code lost:
    
        r1 = r3.getAttributeValue(null, androidx.core.app.AppLocalesStorageHelper.LOCALE_RECORD_ATTRIBUTE_TAG);
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006f: IF  (r2 I:??[int, boolean, OBJECT, ARRAY, byte, short, char] A[D('fis' java.io.FileInputStream)]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:57:0x0077 (LINE:95), block:B:56:0x006f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readLocales(android.content.Context r9) {
        /*
            java.lang.Object r0 = androidx.core.app.AppLocalesStorageHelper.sAppLocaleStorageSync
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r9.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> L78 java.lang.Throwable -> L7b
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
            int r4 = r3.getDepth()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
        L19:
            int r5 = r3.next()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
            r6 = r5
            r7 = 1
            if (r5 == r7) goto L46
            r5 = 3
            if (r6 != r5) goto L2a
            int r7 = r3.getDepth()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
            if (r7 <= r4) goto L46
        L2a:
            if (r6 == r5) goto L19
            r5 = 4
            if (r6 != r5) goto L30
            goto L19
        L30:
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
            java.lang.String r7 = "locales"
            boolean r7 = r5.equals(r7)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
            if (r7 == 0) goto L45
            java.lang.String r7 = "application_locales"
            r8 = 0
            java.lang.String r7 = r3.getAttributeValue(r8, r7)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50 org.xmlpull.v1.XmlPullParserException -> L52
            r1 = r7
            goto L46
        L45:
            goto L19
        L46:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L7b
        L4b:
            goto L61
        L4c:
            r3 = move-exception
            goto L4b
        L4e:
            r3 = move-exception
            goto L6f
        L50:
            r3 = move-exception
            goto L53
        L52:
            r3 = move-exception
        L53:
            java.lang.String r4 = "AppLocalesStorageHelper"
            java.lang.String r5 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r4, r5)     // Catch: java.lang.Throwable -> L4e
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L7b
            goto L4b
        L61:
            boolean r3 = r1.isEmpty()     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L68
            goto L6d
        L68:
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r9.deleteFile(r3)     // Catch: java.lang.Throwable -> L7b
        L6d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7b
            return r1
        L6f:
            if (r2 == 0) goto L76
            r2.close()     // Catch: java.io.IOException -> L75 java.lang.Throwable -> L7b
            goto L76
        L75:
            r4 = move-exception
        L76:
            throw r3     // Catch: java.lang.Throwable -> L7b
        L78:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7b
            return r1
        L7b:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.readLocales(android.content.Context):java.lang.String");
    }

    public static void persistLocales(Context context, String locales) {
        synchronized (sAppLocaleStorageSync) {
            if (locales.equals("")) {
                context.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
                return;
            }
            try {
                FileOutputStream fos = context.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);
                XmlSerializer serializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            serializer.setOutput(fos, null);
                            serializer.startDocument("UTF-8", true);
                            serializer.startTag(null, LOCALE_RECORD_FILE_TAG);
                            serializer.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, locales);
                            serializer.endTag(null, LOCALE_RECORD_FILE_TAG);
                            serializer.endDocument();
                        } catch (IOException e) {
                        }
                    } catch (Exception e2) {
                        Log.w(TAG, "Storing App Locales : Failed to persist app-locales in storage ", e2);
                        if (fos != null) {
                            fos.close();
                        }
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (Throwable th) {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                Log.w(TAG, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", APPLICATION_LOCALES_RECORD_FILE));
            }
        }
    }
}
