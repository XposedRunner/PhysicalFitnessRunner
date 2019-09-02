package com.zjwh.android_wh_physicalfitness.receiver;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.LocalBroadcastManager;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.ChatJPushBean;
import com.zjwh.android_wh_physicalfitness.entity.ChatNewMessageBean;
import com.zjwh.android_wh_physicalfitness.entity.ChatNewMessageBean.OnChatMessageGetSuccessListener;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import com.zjwh.android_wh_physicalfitness.ui.chat.ChatActivity;
import com.zjwh.android_wh_physicalfitness.ui.message.MessageActivity;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00000o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.iv;
import defpackage.jf;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.DbManager;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class JPushReceiver extends BroadcastReceiver {
    private static final String O000000o = "JPush";

    private static String O000000o(Bundle bundle) {
        return "";
    }

    private void O000000o() {
        x.http().get(new RequestParams("http://pv.sohu.com/cityjson?ie=utf-8"), new CommonCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(Throwable th, boolean z) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                try {
                    O00O0Oo0.O000000o(O00000o0.O000000o, new JSONObject(str.substring(str.indexOf("{"), str.indexOf("}") + 1)).optString("cip"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void O000000o(Context context, String str) {
        final DbManager O0000O0o = O00Oo0.O0000O0o();
        final int O00000oO = O00Oo0.O00000oO();
        final String str2 = str;
        final Context context2 = context;
        ChatNewMessageBean.getChatMessageData(context, new OnChatMessageGetSuccessListener() {
            public void onSuccess(Cancelable cancelable, int i) {
                Intent intent;
                ChatJPushBean chatJPushBean = (ChatJPushBean) O000o000.O000000o().fromJson(str2, ChatJPushBean.class);
                Activity O00000Oo = O00000Oo.O00000Oo();
                if (O00000Oo == null || !((O00000Oo instanceof ChatActivity) || (O00000Oo instanceof MessageActivity))) {
                    JPushReceiver.this.O000000o(context2, O0000O0o, O00000oO, chatJPushBean);
                    intent = new Intent("action_new_message");
                    intent.putExtra("extra_new_message", true);
                    LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(intent);
                }
                intent = new Intent(jf.O000000o);
                intent.putExtra(iv.O00000Oo, chatJPushBean.getFromUid());
                intent.putExtra(iv.O00000o, i);
                LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(intent);
            }
        });
    }

    private void O000000o(Context context, DbManager dbManager, int i, ChatJPushBean chatJPushBean) {
        try {
            ChatFriendBean chatFriendBean = ChatFriendBean.getChatFriendBean(dbManager, i, chatJPushBean.getFromUid());
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String string = context.getString(2131689512);
            Builder builder = new Builder(context);
            Intent intent = new Intent(ChatReceiver.O000000o);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_info", chatFriendBean);
            intent.putExtras(bundle);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
            builder.setSmallIcon(R.mipmap.logo).setTicker(string).setContentTitle(string).setContentText(chatJPushBean.getMessage()).setWhen(System.currentTimeMillis()).setContentIntent(broadcast);
            if (VERSION.SDK_INT >= 21) {
                builder.setVisibility(1);
                builder.setFullScreenIntent(broadcast, true);
            }
            Notification build = builder.build();
            build.flags = 16;
            notificationManager.notify(chatJPushBean.getFromUid(), build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if ("cn.jpush.android.intent.REGISTRATION".equals(intent.getAction())) {
                extras.getString("cn.jpush.android.REGISTRATION_ID");
            } else if ("cn.jpush.android.intent.MESSAGE_RECEIVED".equals(intent.getAction())) {
                O000000o(context, extras.getString("cn.jpush.android.MESSAGE"));
            } else if (!"cn.jpush.android.intent.NOTIFICATION_RECEIVED".equals(intent.getAction())) {
                if ("cn.jpush.android.intent.NOTIFICATION_OPENED".equals(intent.getAction())) {
                    try {
                        Activity O00000Oo = O00000Oo.O00000Oo();
                        if (O00000Oo != null) {
                            ((ActivityManager) context.getSystemService("activity")).moveTaskToFront(O00000Oo.getTaskId(), 1);
                            O000o0.O00000Oo(O00000Oo, extras.getString("cn.jpush.android.EXTRA"));
                        } else {
                            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                            intent.setFlags(270532608);
                            Bundle bundle = new Bundle();
                            bundle.putString("data", extras.getString("cn.jpush.android.EXTRA"));
                            intent.putExtras(bundle);
                            context.startActivity(intent);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (!"cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK".equals(intent.getAction()) && "cn.jpush.android.intent.CONNECTION".equals(intent.getAction()) && intent.getBooleanExtra("cn.jpush.android.CONNECTION_CHANGE", false)) {
                    O000000o();
                }
            }
        }
    }
}
