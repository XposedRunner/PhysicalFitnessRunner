package android.support.multidex;

import android.app.Application;
import android.content.Context;
import cn.ijiami.callm.m.Ce;

public class MultiDexApplication extends Application {
    /* Access modifiers changed, original: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public void onCreate() {
        super.onCreate();
        Ce.checkEmulatorIJM(this);
    }
}
