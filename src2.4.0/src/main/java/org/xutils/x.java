package org.xutils;

import android.app.Application;
import android.content.Context;
import org.xutils.DbManager.DaoConfig;
import org.xutils.common.TaskController;
import org.xutils.db.DbManagerImpl;
import org.xutils.http.HttpManagerImpl;
import org.xutils.view.ViewInjectorImpl;

public final class x {

    private static class MockApplication extends Application {
        public MockApplication(Context context) {
            attachBaseContext(context);
        }
    }

    private x() {
    }

    public static Application app() {
        if (Ext.access$100() == null) {
            try {
                Ext.access$102(new MockApplication((Context) Class.forName("com.android.layoutlib.bridge.impl.RenderAction").getDeclaredMethod("getCurrentContext", new Class[0]).invoke(null, new Object[0])));
            } catch (Throwable unused) {
                RuntimeException runtimeException = new RuntimeException("please invoke x.Ext.init(app) on Application#onCreate() and register your Application in manifest.");
            }
        }
        return Ext.access$100();
    }

    public static DbManager getDb(DaoConfig daoConfig) {
        return DbManagerImpl.getInstance(daoConfig);
    }

    public static HttpManager http() {
        if (Ext.access$300() == null) {
            HttpManagerImpl.registerInstance();
        }
        return Ext.access$300();
    }

    public static boolean isDebug() {
        return Ext.access$000();
    }

    public static TaskController task() {
        return Ext.access$200();
    }

    public static ViewInjector view() {
        if (Ext.access$400() == null) {
            ViewInjectorImpl.registerInstance();
        }
        return Ext.access$400();
    }
}
