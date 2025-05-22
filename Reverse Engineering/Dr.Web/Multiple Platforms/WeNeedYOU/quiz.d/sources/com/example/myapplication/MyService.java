package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes2.dex */
public class MyService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public MyService() {
        new MyReceiver();
        new MyReceiver2();
        new MyReceiver3();
    }
}
