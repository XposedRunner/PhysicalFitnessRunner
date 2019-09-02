package cn.jpush.android.api;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.a;
import cn.jpush.android.d.f;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class DefaultPushNotificationBuilder implements PushNotificationBuilder {
    private static final String DEFAULT_NOTIFICATION_CHANNEL_ID = "JPush";
    private static final String DEFAULT_NOTIFICATION_CHANNEL_NAME = "Notification";
    private static final String TAG = "DefaultPushNotificationBuilder";
    private static boolean hasCreateNotificationChannel;

    /* Access modifiers changed, original: 0000 */
    public RemoteViews buildContentView(String str, String str2) {
        return null;
    }

    public Notification buildNotification(Map<String, String> map) {
        Map<String, String> map2 = map;
        if (a.e == null) {
            return null;
        }
        String str = a.d;
        String str2 = "";
        CharSequence charSequence = "";
        CharSequence charSequence2 = "";
        CharSequence charSequence3 = "";
        CharSequence charSequence4 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (map2.containsKey(JPushInterface.EXTRA_ALERT)) {
            str2 = (String) map2.get(JPushInterface.EXTRA_ALERT);
        }
        if (TextUtils.isEmpty(str2)) {
            f.c(TAG, "No notification content to show. Give up.");
            return null;
        }
        if (map2.containsKey("cn.jpush.android.NOTIFICATION_TARGET_PKGNAME")) {
            str6 = (String) map2.get("cn.jpush.android.NOTIFICATION_TARGET_PKGNAME");
        }
        if (map2.containsKey("cn.jpush.android.NOTIFICATION_SMALL_ICON")) {
            str3 = (String) map2.get("cn.jpush.android.NOTIFICATION_SMALL_ICON");
        }
        if (map2.containsKey(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON)) {
            str4 = (String) map2.get(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON);
        }
        if (map2.containsKey("cn.jpush.android.NOTIFICATION_SOURCE")) {
            str5 = (String) map2.get("cn.jpush.android.NOTIFICATION_SOURCE");
        }
        if (map2.containsKey(JPushInterface.EXTRA_NOTIFICATION_TITLE)) {
            str = (String) map2.get(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        }
        if (map2.containsKey(JPushInterface.EXTRA_BIG_TEXT)) {
            charSequence = (String) map2.get(JPushInterface.EXTRA_BIG_TEXT);
        }
        if (map2.containsKey(JPushInterface.EXTRA_INBOX)) {
            charSequence2 = (String) map2.get(JPushInterface.EXTRA_INBOX);
        }
        int parseInt = map2.containsKey(JPushInterface.EXTRA_NOTI_PRIORITY) ? Integer.parseInt((String) map2.get(JPushInterface.EXTRA_NOTI_PRIORITY)) : 0;
        if (map2.containsKey(JPushInterface.EXTRA_NOTI_CATEGORY)) {
            charSequence3 = (String) map2.get(JPushInterface.EXTRA_NOTI_CATEGORY);
        }
        if (map2.containsKey(JPushInterface.EXTRA_BIG_PIC_PATH)) {
            charSequence4 = (String) map2.get(JPushInterface.EXTRA_BIG_PIC_PATH);
        }
        int parseInt2 = map2.containsKey(JPushInterface.EXTRA_ALERT_TYPE) ? Integer.parseInt((String) map2.get(JPushInterface.EXTRA_ALERT_TYPE)) : -1;
        if (parseInt2 < -1 || parseInt2 > 7) {
            parseInt2 = -1;
        }
        RemoteViews buildContentView = buildContentView(str2, str);
        if (VERSION.SDK_INT >= 11) {
            Builder builder = new Builder(a.e);
            builder.setContentTitle(str).setContentText(str2).setTicker(str2);
            if (!c.a(a.e, str5, str6, str3, builder)) {
                return null;
            }
            c.a(a.e, str4, builder);
            if (VERSION.SDK_INT >= 17) {
                builder.setShowWhen(true);
            }
            c.a(builder, DEFAULT_NOTIFICATION_CHANNEL_ID, DEFAULT_NOTIFICATION_CHANNEL_NAME, parseInt, parseInt2);
            if (VERSION.SDK_INT >= 16) {
                if (!TextUtils.isEmpty(charSequence)) {
                    BigTextStyle bigTextStyle = new BigTextStyle();
                    bigTextStyle.bigText(charSequence);
                    builder.setStyle(bigTextStyle);
                }
                if (!TextUtils.isEmpty(charSequence2)) {
                    InboxStyle inboxStyle = new InboxStyle();
                    try {
                        TreeMap treeMap = new TreeMap();
                        JSONObject jSONObject = new JSONObject(charSequence2);
                        Iterator keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            str3 = (String) keys.next();
                            treeMap.put(str3, jSONObject.optString(str3));
                        }
                        for (String addLine : treeMap.values()) {
                            inboxStyle.addLine(addLine);
                        }
                        StringBuilder stringBuilder = new StringBuilder(" + ");
                        stringBuilder.append(jSONObject.length());
                        stringBuilder.append(" new messages");
                        inboxStyle.setSummaryText(stringBuilder.toString());
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        String str7 = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder("Set inbox style error: ");
                        stringBuilder2.append(th2.getMessage());
                        f.d(str7, stringBuilder2.toString());
                    }
                    builder.setStyle(inboxStyle);
                }
                if (!TextUtils.isEmpty(charSequence4)) {
                    try {
                        BigPictureStyle bigPictureStyle = new BigPictureStyle();
                        bigPictureStyle.bigPicture(BitmapFactory.decodeFile(charSequence4));
                        builder.setStyle(bigPictureStyle);
                    } catch (OutOfMemoryError e) {
                        OutOfMemoryError outOfMemoryError = e;
                        f.c(TAG, "Create bitmap failed caused by OutOfMemoryError.");
                        outOfMemoryError.printStackTrace();
                    } catch (Exception e2) {
                        Exception exception = e2;
                        f.c(TAG, "Create big picture style failed.");
                        exception.printStackTrace();
                    }
                }
                if (parseInt != 0) {
                    if (parseInt == 1) {
                        builder.setPriority(1);
                    } else {
                        int i = 2;
                        if (parseInt != 2) {
                            i = -1;
                            if (parseInt != -1) {
                                i = -2;
                                if (parseInt != -2) {
                                    i = 0;
                                }
                            }
                        }
                        builder.setPriority(i);
                    }
                }
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (VERSION.SDK_INT >= 21) {
                        try {
                            Class.forName("android.app.Notification$Builder").getDeclaredMethod("setCategory", new Class[]{String.class}).invoke(builder, new Object[]{charSequence3});
                        } catch (ClassNotFoundException e3) {
                            e3.printStackTrace();
                        } catch (NoSuchMethodException e4) {
                            e4.printStackTrace();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    } else {
                        f.c(TAG, "Device rom SDK < 21, can not set notification category!");
                    }
                }
            }
            if (buildContentView != null) {
                builder.setContent(buildContentView);
            }
            builder.setDefaults(parseInt2);
            return getNotification(builder);
        }
        Context context = a.e;
        Notification notification = new Notification(c.a(), str2, System.currentTimeMillis());
        resetNotificationParams(notification);
        notification.defaults = parseInt2;
        if (str == null) {
            str = a.d;
        }
        if (buildContentView != null) {
            notification.contentView = buildContentView;
            return notification;
        }
        c.a(notification, a.e, str, str2, null);
        return notification;
    }

    public String getDeveloperArg0() {
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public Notification getNotification(Builder builder) {
        try {
            return VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        } catch (Throwable th) {
            f.c(TAG, "Build notification error:", th);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void resetNotificationParams(Notification notification) {
    }

    public String toString() {
        return "";
    }
}
