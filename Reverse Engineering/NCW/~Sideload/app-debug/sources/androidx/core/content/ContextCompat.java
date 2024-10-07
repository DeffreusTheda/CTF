package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sSync = new Object();

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }

    protected ContextCompat() {
    }

    public static boolean startActivities(Context context, Intent[] intents) {
        return startActivities(context, intents, null);
    }

    public static boolean startActivities(Context context, Intent[] intents, Bundle options) {
        context.startActivities(intents, options);
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle options) {
        context.startActivity(intent, options);
    }

    public static File getDataDir(Context context) {
        return Api24Impl.getDataDir(context);
    }

    public static File[] getObbDirs(Context context) {
        return context.getObbDirs();
    }

    public static File[] getExternalFilesDirs(Context context, String type) {
        return context.getExternalFilesDirs(type);
    }

    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    public static Drawable getDrawable(Context context, int id) {
        return Api21Impl.getDrawable(context, id);
    }

    public static ColorStateList getColorStateList(Context context, int id) {
        return ResourcesCompat.getColorStateList(context.getResources(), id, context.getTheme());
    }

    public static int getColor(Context context, int id) {
        return Api23Impl.getColor(context, id);
    }

    public static int checkSelfPermission(Context context, String permission) {
        ObjectsCompat.requireNonNull(permission, "permission must be non-null");
        if (Build.VERSION.SDK_INT < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", permission)) {
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return 0;
            }
            return -1;
        }
        return context.checkPermission(permission, Process.myPid(), Process.myUid());
    }

    public static File getNoBackupFilesDir(Context context) {
        return Api21Impl.getNoBackupFilesDir(context);
    }

    public static File getCodeCacheDir(Context context) {
        return Api21Impl.getCodeCacheDir(context);
    }

    private static File createFilesDir(File file) {
        synchronized (sSync) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
            }
            return file;
        }
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        return Api24Impl.createDeviceProtectedStorageContext(context);
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        return Api24Impl.isDeviceProtectedStorage(context);
    }

    public static Executor getMainExecutor(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getMainExecutor(context);
        }
        return ExecutorCompat.create(new Handler(context.getMainLooper()));
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static Display getDisplayOrDefault(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getDisplayOrDefault(context);
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return windowManager.getDefaultDisplay();
    }

    public static <T> T getSystemService(Context context, Class<T> cls) {
        return (T) Api23Impl.getSystemService(context, cls);
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return registerReceiver(context, receiver, filter, null, null, flags);
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        if ((flags & 1) != 0 && (flags & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if ((flags & 1) != 0) {
            flags |= 2;
        }
        if ((flags & 2) == 0 && (flags & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if ((flags & 2) != 0 && (flags & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.registerReceiver(context, receiver, filter, broadcastPermission, scheduler, flags);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.registerReceiver(context, receiver, filter, broadcastPermission, scheduler, flags);
        }
        if ((flags & 4) != 0 && broadcastPermission == null) {
            String permission = obtainAndCheckReceiverPermission(context);
            return context.registerReceiver(receiver, filter, permission, scheduler);
        }
        return context.registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

    public static String getSystemServiceName(Context context, Class<?> serviceClass) {
        return Api23Impl.getSystemServiceName(context, serviceClass);
    }

    public static String getString(Context context, int resId) {
        return getContextForLanguage(context).getString(resId);
    }

    public static Context getContextForLanguage(Context context) {
        LocaleListCompat locales = LocaleManagerCompat.getApplicationLocales(context);
        if (Build.VERSION.SDK_INT <= 32 && !locales.isEmpty()) {
            Configuration newConfig = new Configuration(context.getResources().getConfiguration());
            ConfigurationCompat.setLocales(newConfig, locales);
            return context.createConfigurationContext(newConfig);
        }
        return context;
    }

    public static String getAttributionTag(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getAttributionTag(context);
        }
        return null;
    }

    public static Context createAttributionContext(Context context, String attributionTag) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.createAttributionContext(context, attributionTag);
        }
        return context;
    }

    static String obtainAndCheckReceiverPermission(Context obj) {
        String permission = obj.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(obj, permission) != 0) {
            throw new RuntimeException("Permission " + permission + " is required by your application to receive broadcasts, please add it to your manifest");
        }
        return permission;
    }

    private static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES;

        private LegacyServiceMapHolder() {
        }

        static {
            HashMap<Class<?>, String> hashMap = new HashMap<>();
            SERVICES = hashMap;
            hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
            hashMap.put(UsageStatsManager.class, "usagestats");
            hashMap.put(AppWidgetManager.class, "appwidget");
            hashMap.put(BatteryManager.class, "batterymanager");
            hashMap.put(CameraManager.class, "camera");
            hashMap.put(JobScheduler.class, "jobscheduler");
            hashMap.put(LauncherApps.class, "launcherapps");
            hashMap.put(MediaProjectionManager.class, "media_projection");
            hashMap.put(MediaSessionManager.class, "media_session");
            hashMap.put(RestrictionsManager.class, "restrictions");
            hashMap.put(TelecomManager.class, "telecom");
            hashMap.put(TvInputManager.class, "tv_input");
            hashMap.put(AppOpsManager.class, "appops");
            hashMap.put(CaptioningManager.class, "captioning");
            hashMap.put(ConsumerIrManager.class, "consumer_ir");
            hashMap.put(PrintManager.class, "print");
            hashMap.put(BluetoothManager.class, "bluetooth");
            hashMap.put(DisplayManager.class, "display");
            hashMap.put(UserManager.class, "user");
            hashMap.put(InputManager.class, "input");
            hashMap.put(MediaRouter.class, "media_router");
            hashMap.put(NsdManager.class, "servicediscovery");
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, "account");
            hashMap.put(ActivityManager.class, "activity");
            hashMap.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            hashMap.put(AudioManager.class, "audio");
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, "notification");
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable getDrawable(Context obj, int id) {
            return obj.getDrawable(id);
        }

        static File getNoBackupFilesDir(Context obj) {
            return obj.getNoBackupFilesDir();
        }

        static File getCodeCacheDir(Context obj) {
            return obj.getCodeCacheDir();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getColor(Context obj, int id) {
            return obj.getColor(id);
        }

        static <T> T getSystemService(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String getSystemServiceName(Context obj, Class<?> serviceClass) {
            return obj.getSystemServiceName(serviceClass);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static File getDataDir(Context obj) {
            return obj.getDataDir();
        }

        static Context createDeviceProtectedStorageContext(Context obj) {
            return obj.createDeviceProtectedStorageContext();
        }

        static boolean isDeviceProtectedStorage(Context obj) {
            return obj.isDeviceProtectedStorage();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Intent registerReceiver(Context obj, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
            if ((flags & 4) != 0 && broadcastPermission == null) {
                String permission = ContextCompat.obtainAndCheckReceiverPermission(obj);
                return obj.registerReceiver(receiver, filter, permission, scheduler);
            }
            return obj.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags & 1);
        }

        static ComponentName startForegroundService(Context obj, Intent service) {
            return obj.startForegroundService(service);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Executor getMainExecutor(Context obj) {
            return obj.getMainExecutor();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static String getAttributionTag(Context obj) {
            return obj.getAttributionTag();
        }

        static Display getDisplayOrDefault(Context obj) {
            try {
                return obj.getDisplay();
            } catch (UnsupportedOperationException e) {
                Log.w(ContextCompat.TAG, "The context:" + obj + " is not associated with any display. Return a fallback display instead.");
                return ((DisplayManager) obj.getSystemService(DisplayManager.class)).getDisplay(0);
            }
        }

        static Context createAttributionContext(Context context, String attributionTag) {
            return context.createAttributionContext(attributionTag);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static Intent registerReceiver(Context obj, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
            return obj.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags);
        }
    }
}
