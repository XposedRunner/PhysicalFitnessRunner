package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.AppVersion;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000o0;
import defpackage.gj;
import defpackage.gk;
import java.io.File;
import java.lang.ref.WeakReference;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.ProgressCallback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/* compiled from: CheckVersionInfoUtil */
public class O000O00o {
    private static O0000o0 O000000o;
    private static Cancelable O00000Oo;
    private static NotificationManager O00000o;
    private static Builder O00000o0;
    private static O0000o0 O00000oO;
    private static boolean O00000oo;

    public static void O000000o(WeakReference<Activity> weakReference) {
        final Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            HttpUtil.get(MyApplication.O000000o(), new gj(gk.O000000o), new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                }

                public void onFinished() {
                }

                public void onSuccess(String str) {
                    try {
                        AppVersion appVersion = (AppVersion) O000o000.O000000o(str, AppVersion.class);
                        if (appVersion != null) {
                            boolean z = true;
                            if (appVersion.getIsForse() != 1) {
                                z = false;
                            }
                            O000O00o.O00000oo = z;
                            O000O00o.O00000Oo(appVersion, activity);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void O00000Oo(Context context) {
        if (context != null) {
            O00000o = (NotificationManager) context.getSystemService("notification");
            String str = "运动世界校园";
            String str2 = "正在下载";
            O00000o0 = new Builder(context);
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(context, context.getClass()));
            intent.setFlags(270532608);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
            Builder smallIcon = O00000o0.setSmallIcon(R.mipmap.logo);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            smallIcon.setTicker(stringBuilder.toString()).setContentTitle(str).setContentText(str2).setProgress(100, 0, false).setWhen(System.currentTimeMillis()).setContentIntent(activity);
            Notification build = O00000o0.build();
            build.flags = 2;
            O00000o.notify(102, build);
        }
    }

    private static void O00000Oo(Context context, double d, String str) {
        if (context != null) {
            O000000o = new O0000o0(context);
            O0000o0 O000000o = O000000o.O000000o().O000000o(str).O000000o((int) R.string.update_cancel, new OnClickListener() {
                public void onClick(View view) {
                    if (O000O00o.O00000Oo != null) {
                        O000O00o.O00000Oo.cancel();
                    }
                    O00000Oo.O00000oo();
                }
            });
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d);
            stringBuilder.append("M");
            O000000o.O00000o0(stringBuilder.toString()).O000000o(false).O00000Oo(false).O00000Oo();
        }
    }

    private static void O00000Oo(final AppVersion appVersion, final Activity activity) {
        if (activity == null) {
            O00Oo00.O000000o("数据异常！");
        } else if (!activity.isFinishing()) {
            final String string = activity.getString(R.string.find_new, new Object[]{appVersion.getAppVersion()});
            O00000oO = new O0000o0(activity);
            O00000oO.O000000o().O000000o(string).O00000Oo(appVersion.getUpdateMsg());
            if (appVersion.getIsForse() == 1) {
                O0000o0 o0000o0 = O00000oO;
                Object[] objArr = new Object[1];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(appVersion.getPkgSize());
                stringBuilder.append("");
                objArr[0] = stringBuilder.toString();
                o0000o0.O000000o(activity.getString(R.string.update_now_force, objArr), (int) R.color.white, new OnClickListener() {
                    public void onClick(View view) {
                        O000O00o.O00000Oo(appVersion, activity);
                        O000O00o.O00000Oo(activity, appVersion.getPkgSize(), string);
                    }
                }).O000000o(false).O00000Oo(false).O00000Oo();
            } else if (appVersion.getIsForse() == 3) {
                O00000oO.O000000o((int) R.string.upload_later, new OnClickListener() {
                    public void onClick(View view) {
                    }
                }).O00000Oo(R.string.update_now, new OnClickListener() {
                    public void onClick(View view) {
                        O000O00o.O00000oO.O00000o0();
                        O000O00o.O00000Oo(appVersion, activity);
                        O000O00o.O00000Oo(activity);
                    }
                }).O000000o(false).O00000Oo(false).O00000Oo();
            }
        }
    }

    private static void O00000Oo(AppVersion appVersion, final Context context) {
        if (!TextUtils.isEmpty(appVersion.getDownloadUrl())) {
            String O00000o = O00oOooO.O00000o();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O00000o);
            stringBuilder.append("/");
            stringBuilder.append(appVersion.getAppVersion());
            stringBuilder.append(".apk");
            O00000o = stringBuilder.toString();
            RequestParams requestParams = new RequestParams(O00Oo0.O00000o(appVersion.getDownloadUrl()));
            requestParams.setSaveFilePath(O00000o);
            O00000Oo = x.http().get(requestParams, new ProgressCallback<File>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(Throwable th, boolean z) {
                }

                public void onFinished() {
                }

                public void onLoading(long j, long j2, boolean z) {
                    int i = (int) ((j2 * 100) / j);
                    if (!(O000O00o.O00000o0 == null || O000O00o.O00000o == null)) {
                        O000O00o.O00000o0.setProgress(100, i, false);
                        Builder O00000o0 = O000O00o.O00000o0;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("已下载");
                        stringBuilder.append(i);
                        stringBuilder.append("%");
                        O00000o0.setContentText(stringBuilder.toString());
                        O000O00o.O00000o.notify(102, O000O00o.O00000o0.build());
                    }
                    if (O000O00o.O000000o != null) {
                        O000O00o.O000000o.O00000o0(i);
                    }
                }

                public void onStarted() {
                }

                public void onSuccess(File file) {
                    O000O00o.O00000Oo(file, context);
                }

                public void onWaiting() {
                }
            });
        }
    }

    private static void O00000Oo(File file, Context context) {
        if (file.exists() && context != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            if (VERSION.SDK_INT >= 24) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(context.getApplicationContext().getPackageName());
                stringBuilder.append(".fileprovider");
                Uri uriForFile = FileProvider.getUriForFile(context, stringBuilder.toString(), file);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            }
            context.startActivity(intent);
            if (O00000oo) {
                O00000Oo.O00000Oo(context);
            }
        }
    }
}
