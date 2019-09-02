package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import cn.jpush.android.a;

public class BasicPushNotificationBuilder extends DefaultPushNotificationBuilder {
    protected Context a;
    public String developerArg0 = "developerArg0";
    public int notificationDefaults = -2;
    public int notificationFlags = 16;
    public int statusBarDrawable = a.b;

    public BasicPushNotificationBuilder(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        this.a = context;
    }

    static PushNotificationBuilder a(String str) {
        String[] split = str.split("_____");
        Object obj = split[0];
        BasicPushNotificationBuilder basicPushNotificationBuilder = "basic".equals(obj) ? new BasicPushNotificationBuilder(a.e) : "custom".equals(obj) ? new CustomPushNotificationBuilder(a.e) : new BasicPushNotificationBuilder(a.e);
        basicPushNotificationBuilder.a(split);
        return basicPushNotificationBuilder;
    }

    /* Access modifiers changed, original: 0000 */
    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.notificationDefaults);
        stringBuilder.append("_____");
        stringBuilder.append(this.notificationFlags);
        stringBuilder.append("_____");
        stringBuilder.append(this.statusBarDrawable);
        stringBuilder.append("_____");
        stringBuilder.append(this.developerArg0);
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String[] strArr) {
        this.notificationDefaults = Integer.parseInt(strArr[1]);
        this.notificationFlags = Integer.parseInt(strArr[2]);
        this.statusBarDrawable = Integer.parseInt(strArr[3]);
        if (5 == strArr.length) {
            this.developerArg0 = strArr[4];
        }
    }

    public String getDeveloperArg0() {
        return this.developerArg0;
    }

    /* Access modifiers changed, original: 0000 */
    @TargetApi(11)
    public Notification getNotification(Builder builder) {
        if (this.notificationDefaults != -2) {
            builder.setDefaults(this.notificationDefaults);
        }
        builder.setSmallIcon(this.statusBarDrawable);
        Notification build = VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        build.flags = 1 | this.notificationFlags;
        return build;
    }

    /* Access modifiers changed, original: 0000 */
    public void resetNotificationParams(Notification notification) {
        notification.defaults = this.notificationDefaults;
        notification.flags = this.notificationFlags;
        notification.icon = this.statusBarDrawable;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("basic_____");
        stringBuilder.append(a());
        return stringBuilder.toString();
    }
}
