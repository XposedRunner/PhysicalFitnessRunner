package cn.jpush.android.api;

import android.app.Notification.Builder;
import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.c.d;
import cn.jpush.android.service.e;

public abstract class JThirdPlatFormInterface {
    public static final String ACTION_NOTIFICATION_ARRIVED = "action_notification_arrived";
    public static final String ACTION_NOTIFICATION_CLCKED = "action_notification_clicked";
    public static final String ACTION_NOTIFICATION_SHOW = "action_notification_show";
    public static final String ACTION_PLUGIN_PALTFORM_ON_MESSAGING = "intent.plugin.platform.ON_MESSAGING";
    public static final String ACTION_PLUGIN_PALTFORM_REFRESSH_REGID = "intent.plugin.platform.REFRESSH_REGID";
    public static final String ACTION_PLUGIN_PALTFORM_REQUEST_REGID = "intent.plugin.platform.REQUEST_REGID";
    public static final String ACTION_REGISTER_TOKEN = "action_register_token";
    public static final String KEY_DATA = "data";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_NOTI_ID = "noti_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_TOKEN = "token";

    public static void doAction(Context context, String str, Bundle bundle) {
        d.a().a(context, str, bundle);
    }

    public static int getNofiticationID(String str, int i) {
        return c.a(str, i);
    }

    public static void sendActionByJCore(Context context, Bundle bundle, String str) {
        e.a(context, bundle, str);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static void setNotificationChannel(Builder builder, String str, CharSequence charSequence, int i, int i2) {
        c.a(builder, str, charSequence, i, i2);
    }

    public static String toMD5(String str) {
        return cn.jpush.android.d.a.a(str);
    }

    public abstract String getAppId(Context context);

    public abstract String getAppkey(Context context);

    public abstract String getRomName();

    public abstract byte getRomType(Context context);

    public abstract String getToken(Context context);

    public abstract void init(Context context);

    public abstract boolean isNeedClearToken(Context context);

    public abstract boolean isSupport(Context context);

    public boolean needSendToMainProcess() {
        return false;
    }

    public abstract void register(Context context);

    public void resumePush(Context context) {
    }

    public void stopPush(Context context) {
    }
}
