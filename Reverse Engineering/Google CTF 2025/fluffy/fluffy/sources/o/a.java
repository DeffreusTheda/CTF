package O;

import E.d;
import K.k;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final PackageManager f316a;

    /* renamed from: b, reason: collision with root package name */
    public d f317b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f318c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f319d = new HashMap();

    public a(B.a aVar) {
        this.f316a = (PackageManager) aVar.f4c;
        aVar.f5d = this;
    }

    public final void a(String str, String str2, boolean z2, k kVar) {
        if (this.f317b == null) {
            kVar.a("error", "Plugin not bound to an Activity", null);
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            kVar.a("error", "Android version not supported", null);
            return;
        }
        HashMap hashMap = this.f318c;
        if (hashMap == null) {
            kVar.a("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) hashMap.get(str);
        if (resolveInfo == null) {
            kVar.a("error", "Text processing activity not found", null);
            return;
        }
        int hashCode = kVar.hashCode();
        this.f319d.put(Integer.valueOf(hashCode), kVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z2);
        this.f317b.f145a.startActivityForResult(intent, hashCode);
    }

    public final HashMap b() {
        List<ResolveInfo> queryIntentActivities;
        PackageManager.ResolveInfoFlags of;
        HashMap hashMap = this.f318c;
        PackageManager packageManager = this.f316a;
        if (hashMap == null) {
            this.f318c = new HashMap();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
                if (i2 >= 33) {
                    of = PackageManager.ResolveInfoFlags.of(0L);
                    queryIntentActivities = packageManager.queryIntentActivities(type, of);
                } else {
                    queryIntentActivities = packageManager.queryIntentActivities(type, 0);
                }
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    String str = resolveInfo.activityInfo.name;
                    resolveInfo.loadLabel(packageManager).toString();
                    this.f318c.put(str, resolveInfo);
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        for (String str2 : this.f318c.keySet()) {
            hashMap2.put(str2, ((ResolveInfo) this.f318c.get(str2)).loadLabel(packageManager).toString());
        }
        return hashMap2;
    }
}
