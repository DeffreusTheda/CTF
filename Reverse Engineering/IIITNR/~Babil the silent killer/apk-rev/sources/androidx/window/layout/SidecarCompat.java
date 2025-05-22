package androidx.window.layout;

import a0.q;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    private ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    private final SidecarAdapter sidecarAdapter;
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final IBinder getActivityWindowToken$window_release(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.Companion.parse(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface) {
            i.e(callbackInterface, "callbackInterface");
            this.callbackInterface = callbackInterface;
            this.lock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo newLayout) {
            i.e(activity, "activity");
            i.e(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (i.a(newLayout, this.activityWindowLayoutInfo.get(activity))) {
                    return;
                }
                this.activityWindowLayoutInfo.put(activity, newLayout);
                reentrantLock.unlock();
                this.callbackInterface.onWindowLayoutChanged(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock;
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback callbackInterface) {
            i.e(sidecarAdapter, "sidecarAdapter");
            i.e(callbackInterface, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter;
            this.callbackInterface = callbackInterface;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap<>();
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            i.e(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, newDeviceState)) {
                    return;
                }
                this.lastDeviceState = newDeviceState;
                this.callbackInterface.onDeviceStateChanged(newDeviceState);
                q qVar = q.f22a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            i.e(token, "token");
            i.e(newLayout, "newLayout");
            synchronized (this.lock) {
                if (this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(token), newLayout)) {
                    return;
                }
                this.mActivityWindowLayoutInfo.put(token, newLayout);
                this.callbackInterface.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            i.e(sidecarCompat, "sidecarCompat");
            i.e(activity, "activity");
            this.sidecarCompat = sidecarCompat;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            i.e(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            if (activity == null || activityWindowToken$window_release == null) {
                return;
            }
            this.sidecarCompat.register(activityWindowToken$window_release, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            i.e(view, "view");
        }
    }

    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat this$0) {
            i.e(this$0, "this$0");
            this.this$0 = this$0;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecar;
            i.e(newDeviceState, "newDeviceState");
            Collection<Activity> values = this.this$0.windowListenerRegisteredContexts.values();
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : values) {
                IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (activityWindowToken$window_release != null && (sidecar = sidecarCompat.getSidecar()) != null) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = sidecarCompat.extensionCallback;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, newDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            i.e(windowToken, "windowToken");
            i.e(newLayout, "newLayout");
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(windowToken);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            SidecarDeviceState deviceState = sidecar == null ? null : sidecar.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = sidecarAdapter.translate(newLayout, deviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.this$0.extensionCallback;
            if (extensionCallbackInterface == null) {
                return;
            }
            extensionCallbackInterface.onWindowLayoutChanged(activity, translate);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(SidecarProvider.getSidecarImpl(context.getApplicationContext()), new SidecarAdapter());
        i.e(context, "context");
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        i.e(sidecarAdapter, "sidecarAdapter");
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    private final void registerConfigurationChangeListener(final Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            ComponentCallbacks componentCallbacks = new ComponentCallbacks() { // from class: androidx.window.layout.SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration newConfig) {
                    i.e(newConfig, "newConfig");
                    ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = SidecarCompat.this.extensionCallback;
                    if (extensionCallbackInterface == null) {
                        return;
                    }
                    Activity activity2 = activity;
                    extensionCallbackInterface.onWindowLayoutChanged(activity2, SidecarCompat.this.getWindowLayoutInfo(activity2));
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }
            };
            this.componentCallbackMap.put(activity, componentCallbacks);
            activity.registerComponentCallbacks(componentCallbacks);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    public final WindowLayoutInfo getWindowLayoutInfo(Activity activity) {
        i.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return new WindowLayoutInfo(b0.i.b());
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        SidecarAdapter sidecarAdapter = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.translate(windowLayoutInfo, deviceState);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(Activity activity) {
        i.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(Activity activity) {
        SidecarInterface sidecarInterface;
        i.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
        }
        unregisterComponentCallback(activity);
        boolean z2 = this.windowListenerRegisteredContexts.size() == 1;
        this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
        if (!z2 || (sidecarInterface = this.sidecar) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final void register(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        i.e(windowToken, "windowToken");
        i.e(activity, "activity");
        this.windowListenerRegisteredContexts.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback) {
        i.e(extensionCallback, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallback);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6 A[Catch: all -> 0x019a, TRY_LEAVE, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00aa A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0176 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0082 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0182 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0059 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018e A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0020 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:21:0x005d, B:23:0x0065, B:28:0x0086, B:30:0x008e, B:35:0x00ae, B:37:0x00b6, B:40:0x00bc, B:41:0x00f2, B:43:0x010e, B:47:0x0112, B:49:0x0141, B:53:0x014a, B:54:0x0151, B:55:0x0152, B:56:0x0159, B:58:0x00bf, B:60:0x00ea, B:62:0x015a, B:63:0x0161, B:64:0x0162, B:65:0x0169, B:66:0x016a, B:67:0x0175, B:68:0x00aa, B:69:0x0094, B:72:0x009b, B:73:0x0176, B:74:0x0181, B:75:0x0082, B:76:0x006b, B:79:0x0072, B:80:0x0182, B:81:0x018d, B:82:0x0059, B:83:0x0042, B:86:0x0049, B:87:0x0039, B:88:0x0031, B:89:0x018e, B:90:0x0199, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #2 }] */
    @Override // androidx.window.layout.ExtensionInterfaceCompat
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean validateExtensionInterface() {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }
}
