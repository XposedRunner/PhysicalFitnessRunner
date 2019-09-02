package org.xutils;

import android.app.Application;
import javax.net.ssl.HttpsURLConnection;
import org.xutils.common.TaskController;
import org.xutils.common.task.TaskControllerImpl;

public class x$Ext {
    private static Application app;
    private static boolean debug;
    private static HttpManager httpManager;
    private static TaskController taskController;
    private static ViewInjector viewInjector;

    static {
        TaskControllerImpl.registerInstance();
        HttpsURLConnection.setDefaultHostnameVerifier(new 1());
    }

    private x$Ext() {
    }

    public static void init(Application application) {
        if (app == null) {
            app = application;
        }
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static void setHttpManager(HttpManager httpManager) {
        httpManager = httpManager;
    }

    public static void setTaskController(TaskController taskController) {
        if (taskController == null) {
            taskController = taskController;
        }
    }

    public static void setViewInjector(ViewInjector viewInjector) {
        viewInjector = viewInjector;
    }
}
