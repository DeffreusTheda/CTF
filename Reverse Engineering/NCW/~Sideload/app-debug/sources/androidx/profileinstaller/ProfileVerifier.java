package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final String TAG = "ProfileVerifier";
    private static final ResolvableFuture<CompilationStatus> sFuture = ResolvableFuture.create();
    private static final Object SYNC_OBJ = new Object();
    private static CompilationStatus sCompilationStatus = null;

    private ProfileVerifier() {
    }

    public static CompilationStatus writeProfileVerification(Context context) {
        return writeProfileVerification(context, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:24|25|26|(3:71|72|73)(1:28)|29|(2:31|(12:36|(1:41)|(1:64)(2:47|(7:49|50|(2:58|59)|54|55|56|57))|63|50|(1:52)|58|59|54|55|56|57))(1:70)|(1:68)(1:69)|(2:39|41)|(1:43)|64|63|50|(0)|58|59|54|55|56|57) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f0, code lost:
    
        r8 = androidx.profileinstaller.ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5 A[Catch: all -> 0x0112, TRY_LEAVE, TryCatch #0 {, blocks: (B:93:0x000c, B:95:0x0010, B:9:0x0012, B:11:0x0019, B:14:0x0021, B:19:0x0048, B:25:0x006c, B:26:0x0071, B:72:0x0084, B:31:0x009a, B:33:0x00a2, B:36:0x00a7, B:43:0x00bf, B:47:0x00c6, B:50:0x00d1, B:52:0x00e5, B:55:0x00f6, B:56:0x00fa, B:59:0x00eb, B:77:0x0090, B:78:0x0094, B:82:0x00fd, B:83:0x0108, B:89:0x010a, B:90:0x0110), top: B:92:0x000c, inners: #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static androidx.profileinstaller.ProfileVerifier.CompilationStatus writeProfileVerification(android.content.Context r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.ProfileVerifier.writeProfileVerification(android.content.Context, boolean):androidx.profileinstaller.ProfileVerifier$CompilationStatus");
    }

    private static CompilationStatus setCompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile) {
        CompilationStatus compilationStatus = new CompilationStatus(resultCode, hasReferenceProfile, hasCurrentProfile);
        sCompilationStatus = compilationStatus;
        sFuture.set(compilationStatus);
        return sCompilationStatus;
    }

    private static long getPackageLastUpdateTime(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getPackageInfo(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int schema, int resultCode, long packageLastUpdateTime, long installedCurrentProfileSize) {
            this.mSchema = schema;
            this.mResultCode = resultCode;
            this.mPackageLastUpdateTime = packageLastUpdateTime;
            this.mInstalledCurrentProfileSize = installedCurrentProfileSize;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || !(o instanceof Cache)) {
                return false;
            }
            Cache cacheFile = (Cache) o;
            if (this.mResultCode == cacheFile.mResultCode && this.mPackageLastUpdateTime == cacheFile.mPackageLastUpdateTime && this.mSchema == cacheFile.mSchema && this.mInstalledCurrentProfileSize == cacheFile.mInstalledCurrentProfileSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize));
        }

        void writeOnFile(File file) throws IOException {
            file.delete();
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            try {
                dos.writeInt(this.mSchema);
                dos.writeInt(this.mResultCode);
                dos.writeLong(this.mPackageLastUpdateTime);
                dos.writeLong(this.mInstalledCurrentProfileSize);
                dos.close();
            } catch (Throwable th) {
                try {
                    dos.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        static Cache readFromFile(File file) throws IOException {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dis.readInt(), dis.readInt(), dis.readLong(), dis.readLong());
                dis.close();
                return cache;
            } catch (Throwable th) {
                try {
                    dis.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile) {
            this.mResultCode = resultCode;
            this.mHasCurrentProfile = hasCurrentProfile;
            this.mHasReferenceProfile = hasReferenceProfile;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static PackageInfo getPackageInfo(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }
}
