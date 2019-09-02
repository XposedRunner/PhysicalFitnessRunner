package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.zjwh.android_wh_physicalfitness.activity.LoginActivity;
import com.zjwh.android_wh_physicalfitness.activity.MainActivity;
import com.zjwh.android_wh_physicalfitness.service.BluetoothService;
import com.zjwh.android_wh_physicalfitness.ui.music.AlbumDetailActivity;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicClassifyActivity;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicClassifyDetailActivity;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicMainActivity;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicPlayHistoryActivity;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicPurchasedActivity;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicSearchActivity;
import defpackage.x;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: ActivityStack */
public class O00000Oo {
    private static LinkedList<Activity> O000000o = new LinkedList();

    public static void O000000o() {
        O00000o0(AlbumDetailActivity.class);
        O00000o0(MusicClassifyActivity.class);
        O00000o0(MusicClassifyDetailActivity.class);
        O00000o0(MusicMainActivity.class);
        O00000o0(MusicPlayHistoryActivity.class);
        O00000o0(MusicPurchasedActivity.class);
        O00000o0(MusicSearchActivity.class);
    }

    public static void O000000o(Activity activity) {
        if (!O000000o.contains(activity)) {
            O000000o.addFirst(activity);
        }
    }

    public static void O000000o(Context context) {
        if (O000000o != null) {
            int i = 0;
            while (i < O000000o.size()) {
                Activity activity = (Activity) O000000o.get(i);
                if (i != O000000o.size() - 1 || !(activity instanceof LoginActivity)) {
                    activity.finish();
                    i++;
                } else {
                    return;
                }
            }
        }
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    public static void O000000o(Class cls) {
        if (O000000o != null) {
            Iterator it = O000000o.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (activity.getClass().equals(cls)) {
                    int indexOf = O000000o.indexOf(activity);
                    for (int i = 0; i < indexOf; i++) {
                        ((Activity) O000000o.get(i)).finish();
                    }
                    return;
                }
            }
        }
    }

    public static Activity O00000Oo() {
        if (O000000o.size() <= 0) {
            return null;
        }
        Activity activity = (Activity) O000000o.getFirst();
        return activity.isFinishing() ? O000000o.size() > 1 ? (Activity) O000000o.get(1) : null : activity;
    }

    public static void O00000Oo(Activity activity) {
        if (O000000o.contains(activity)) {
            O000000o.remove(activity);
        }
    }

    public static void O00000Oo(Context context) {
        x.O00000o0(context);
        try {
            context.stopService(new Intent(context, BluetoothService.class));
            XmPlayerManager.release();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                activityManager.killBackgroundProcesses(context.getPackageName());
            }
            O00000oo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O00000Oo(Class cls) {
        if (O000000o != null) {
            Iterator it = O000000o.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (activity.getClass().equals(cls)) {
                    int indexOf = O000000o.indexOf(activity);
                    for (int i = 0; i <= indexOf; i++) {
                        ((Activity) O000000o.get(i)).finish();
                    }
                    return;
                }
            }
        }
    }

    public static void O00000o() {
        if (O000000o != null) {
            O000000o.clear();
        }
    }

    public static boolean O00000o(Class cls) {
        if (O000000o != null) {
            Iterator it = O000000o.iterator();
            while (it.hasNext()) {
                if (((Activity) it.next()).getClass().equals(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void O00000o0() {
        if (O000000o != null) {
            while (1 < O000000o.size() && !((Activity) O000000o.get(1)).getClass().equals(MainActivity.class)) {
                ((Activity) O000000o.get(1)).finish();
                O000000o.remove(1);
            }
        }
    }

    public static void O00000o0(Class cls) {
        if (O000000o != null) {
            Iterator it = O000000o.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (activity.getClass().equals(cls)) {
                    int indexOf = O000000o.indexOf(activity);
                    ((Activity) O000000o.get(indexOf)).finish();
                    O000000o.remove(indexOf);
                    return;
                }
            }
        }
    }

    public static void O00000oO() {
        if (O000000o != null) {
            Iterator it = O000000o.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (!(activity instanceof MainActivity)) {
                    activity.finish();
                }
            }
        }
    }

    public static void O00000oo() {
        try {
            Iterator it = O000000o.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (activity != null) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
