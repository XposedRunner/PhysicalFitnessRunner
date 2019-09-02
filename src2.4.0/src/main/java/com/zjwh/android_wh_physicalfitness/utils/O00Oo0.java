package com.zjwh.android_wh_physicalfitness.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecurityCipher;
import com.alibaba.wireless.security.jaq.SecuritySignature;
import com.bumptech.glide.load.resource.bitmap.O0000O0o;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.BlurDialogMsg;
import com.zjwh.android_wh_physicalfitness.entity.database.NearBySchoolBean;
import com.zjwh.android_wh_physicalfitness.entity.database.TopicTagBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.ui.run.SportFragment;
import com.zjwh.android_wh_physicalfitness.view.blur.BlurDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.DbManager;
import org.xutils.common.util.DensityUtil;
import org.xutils.common.util.MD5;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;

@SuppressLint({"SimpleDateFormat"})
/* compiled from: Utils */
public class O00Oo0 {
    public static final String O000000o = "running_analyze";
    public static int[] O00000Oo = new int[]{2131231014, 2131231007, 2131231013, 2131231011, 2131231005, 2131231004, 2131231009, 2131231008, 2131231002, 2131231006, 2131231010, 2131231003, 2131231012};
    public static final int O00000o = 1;
    public static final int O00000o0 = 0;
    public static final int O00000oO = 2;
    public static final int O00000oo = 3;
    public static final int O0000O0o = 4;
    public static final int O0000OOo = 5;
    private static int[] O0000Oo = new int[]{2131099844, 2131099848, 2131099847, 2131099843, 2131099842, 2131099837, 2131099838, 2131099839, 2131099822, 2131099823, 2131099824, 2131099825, 2131099826, 2131099827, 2131099828, 2131099829, 2131099830, 2131099831, 2131099832, 2131099833, 2131099834, 2131099835, 2131099836};
    private static DbManager O0000Oo0;
    private static SoundPool O0000OoO;

    public static double O000000o(double d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d + 1.0E-6d);
        stringBuilder.append("");
        return new BigDecimal(stringBuilder.toString()).setScale(2, 4).doubleValue();
    }

    public static int O000000o(float f) {
        float f2;
        UserInfo O00000o0 = O00000o0();
        if (O00000o0 == null) {
            f2 = 50.0f;
        } else if (O00000o0.getWeight() == 0.0f) {
            f2 = (float) (O00000o0.getSex() == 1 ? 60 : 50);
        } else {
            f2 = O00000o0.getWeight();
        }
        return Math.round((f * 1.036f) * f2);
    }

    public static int O000000o(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & ViewCompat.MEASURED_SIZE_MASK);
    }

    public static int O000000o(DbManager dbManager) {
        try {
            UserInfo userInfo = (UserInfo) dbManager.selector(UserInfo.class).orderBy("timestamp", true).findFirst();
            if (userInfo != null) {
                return userInfo.getUid();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Spanned O000000o(Context context, int i, String str, String str2) {
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<font color=\"");
        stringBuilder.append(str2);
        stringBuilder.append("\">");
        stringBuilder.append(str);
        stringBuilder.append("</font>");
        objArr[0] = stringBuilder.toString();
        return Html.fromHtml(context.getString(i, objArr));
    }

    public static String O000000o() {
        try {
            String O0000Oo = O000OO.O0000Oo();
            String O0000OOo = O000OO.O0000OOo();
            String O0000o0o = O000OO.O0000o0o();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O0000Oo);
            stringBuilder.append(O0000OOo);
            stringBuilder.append(O0000o0o);
            return MD5.md5(stringBuilder.toString());
        } catch (Exception unused) {
            return "default000000001";
        }
    }

    public static String O000000o(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loginType", i);
            jSONObject.put("device_model", O000OO.O0000OOo());
            jSONObject.put("os_version", O000OO.O00000o0());
            jSONObject.put("mac_address", O000OO.O0000o0o());
            jSONObject.put("imei", O000OO.O0000Oo());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("uuid", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("smscode", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String O000000o(long j) {
        if (j <= 0) {
            return "00:00:00";
        }
        StringBuilder stringBuilder = new StringBuilder();
        long j2 = j / 3600;
        j %= 3600;
        long j3 = j / 60;
        j %= 60;
        if (j2 < 10) {
            stringBuilder.append("0");
            stringBuilder.append(j2);
            stringBuilder.append(":");
        } else {
            stringBuilder.append(j2);
            stringBuilder.append(":");
        }
        if (j3 < 10) {
            stringBuilder.append("0");
            stringBuilder.append(j3);
            stringBuilder.append(":");
        } else {
            stringBuilder.append(j3);
            stringBuilder.append(":");
        }
        if (j < 10) {
            stringBuilder.append("0");
            stringBuilder.append(j);
        } else {
            stringBuilder.append(j);
        }
        return stringBuilder.toString();
    }

    public static String O000000o(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new SecuritySignature(context).atlasSign(str.replace("https", "http"), context.getString(2131689511));
        } catch (Exception e) {
            e.printStackTrace();
            x.O00000Oo(MyApplication.O000000o(), "atlasSign ali sign error!");
            return null;
        }
    }

    public static String O000000o(String str, int i, int i2) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?x-oss-process=image/resize,m_fill,h_");
        stringBuilder.append(i2);
        stringBuilder.append(",w_");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    private static String O000000o(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int i = 0;
        char[] cArr2 = new char[(bArr.length * 2)];
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            i2 = i3 + 1;
            cArr2[i3] = cArr[b & 15];
            i++;
        }
        return new String(cArr2);
    }

    public static void O000000o(int i) {
        try {
            O0000O0o().deleteById(UserInfo.class, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(int i, String str) {
        gj gjVar = new gj("/api/v8/datacollection/err_log");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i);
            jSONObject.put("uuid", str);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.postOp(MyApplication.O000000o(), gjVar, new 7());
    }

    public static void O000000o(int i, String str, long j) {
        TopicTagBean topicTagBean = new TopicTagBean(i, str, j);
        DbManager O0000O0o = O0000O0o();
        try {
            if (O0000O0o.selector(TopicTagBean.class).where(WhereBuilder.b("topicId", HttpUtils.EQUAL_SIGN, Integer.valueOf(i))).findAll() != null) {
                O0000O0o.delete(TopicTagBean.class, WhereBuilder.b("topicId", HttpUtils.EQUAL_SIGN, Integer.valueOf(i)));
                O0000O0o.save(topicTagBean);
                return;
            }
            O0000O0o.save(topicTagBean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Activity activity) {
        NotificationManager notificationManager = (NotificationManager) activity.getSystemService("notification");
        String str = "运动世界校园";
        String str2 = "正在运行";
        Builder builder = new Builder(activity);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(new ComponentName(activity, activity.getClass()));
        intent.setFlags(270532608);
        PendingIntent activity2 = PendingIntent.getActivity(activity, 0, intent, 0);
        Builder smallIcon = builder.setSmallIcon(2131558419);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        smallIcon.setTicker(stringBuilder.toString()).setContentTitle(str).setContentText(str2).setContentIntent(activity2);
        Notification build = builder.build();
        build.icon = 2131558419;
        build.flags = 2;
        build.defaults = 2;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(str2);
        build.tickerText = stringBuilder2.toString();
        build.when = System.currentTimeMillis();
        if (notificationManager != null) {
            notificationManager.notify(2131689512, build);
        }
    }

    public static void O000000o(Activity activity, int i) {
        O000000o(activity, activity.getString(i));
    }

    public static void O000000o(Activity activity, String str) {
        if (!activity.isFinishing()) {
            oOOOOO0O.O000000o(activity, str, oOOO0OO0.O000000o, 2131296801, new O000000o().O000000o(700).O00000Oo(1500).O00000Oo("#FFFF4438").O000000o("#FFFFFFFF").O00000Oo(DensityUtil.dip2px(20.0f)).O00000o(1).O00000o0(17).O000000o()).O0000o00();
        }
    }

    public static void O000000o(Context context, int i) {
        if (i != 0) {
            int i2 = 2131623940;
            switch (i) {
                case 2:
                    i2 = 2131623942;
                    break;
                case 3:
                    i2 = 2131623941;
                    break;
                case 4:
                    i2 = 2131623939;
                    break;
                case 5:
                    i2 = 2131623937;
                    break;
                case 6:
                    i2 = 2131623938;
                    break;
                case 10:
                    i2 = 2131623947;
                    break;
                case 11:
                    i2 = 2131623945;
                    break;
                case 12:
                    i2 = 2131623946;
                    break;
                case 13:
                    i2 = 2131623944;
                    break;
            }
            try {
                O0000oOO().load(context, i2, 1);
            } catch (Exception e) {
                e.printStackTrace();
                MyApplication O000000o = MyApplication.O000000o();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("跑步音频加载crash --> ");
                stringBuilder.append(O000o000.O000000o(e));
                x.O00000Oo(O000000o, stringBuilder.toString());
            }
        }
    }

    public static void O000000o(Context context, TextView textView) {
        textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Impact.ttf"));
    }

    public static void O000000o(Context context, TextView textView, String str) {
        try {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Context context, String str, int i, ImageView imageView) {
        try {
            O00Oo.O00000o0(context).O000000o(str).O00000o(i).O0000Oo(i).O000000o(new O0000O0o[]{new la(context)}).O000000o(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Context context, String str, ImageView imageView, int i) {
        i = i == 0 ? 2131230877 : 2131230878;
        try {
            if (TextUtils.isEmpty(str)) {
                O00Oo.O00000o0(context).O000000o(Integer.valueOf(i)).O000000o(new O0000O0o[]{new la(context)}).O000000o(imageView);
            } else {
                O00Oo.O00000o0(context).O000000o(str).O00000o(i).O0000Oo(i).O000000o(new O0000O0o[]{new la(context)}).O000000o(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Context context, String str, String str2) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData newPlainText = ClipData.newPlainText(str, str2);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(newPlainText);
        }
    }

    public static void O000000o(AppCompatActivity appCompatActivity, BlurDialogMsg blurDialogMsg) {
        if (!appCompatActivity.isFinishing()) {
            try {
                BlurDialog.O000000o(blurDialogMsg).show(appCompatActivity.getSupportFragmentManager(), "dialog");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void O000000o(View view, String str) {
        if (!TextUtils.isEmpty(str)) {
            ((GradientDrawable) view.getBackground()).setColor(ContextCompat.getColor(view.getContext(), O0000Oo[str.hashCode() % 23]));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(21)
    public static void O000000o(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        if (VERSION.SDK_INT < 17) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        settings.setSavePassword(false);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(2);
        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(false);
        settings.setGeolocationEnabled(true);
        settings.setDatabaseEnabled(true);
        if (VERSION.SDK_INT <= 17) {
            settings.setAppCacheMaxSize(4194304);
            settings.setRenderPriority(RenderPriority.HIGH);
        }
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        webView.setOnTouchListener(new 5());
        webView.setOnLongClickListener(new 6(webView));
    }

    public static void O000000o(UserInfo userInfo) {
        if (userInfo != null) {
            try {
                userInfo.setTimestamp(System.currentTimeMillis());
                O0000O0o().saveOrUpdate(userInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean O000000o(char c) {
        return c == 0 || c == 9 || c == 10 || c == 13 || ((c >= ' ' && c <= 55295) || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535)));
    }

    public static boolean O000000o(Context context) {
        if (O00000Oo(context)) {
            return true;
        }
        new O0000Oo(context).O000000o().O00000Oo(false).O000000o(false).O000000o(2131689766).O00000Oo(2131689745).O000000o(2131689540, null).O00000Oo(2131689774, new 1(context)).O00000Oo();
        return false;
    }

    public static boolean O000000o(MotionEvent motionEvent, Activity activity, boolean z) {
        if (motionEvent.getAction() == 1) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                Object currentFocus2 = activity.getCurrentFocus();
                if (currentFocus2 == null) {
                    currentFocus2 = currentFocus;
                }
                if (currentFocus2.equals(currentFocus)) {
                    Rect rect = new Rect();
                    int[] iArr = new int[2];
                    currentFocus.getLocationOnScreen(iArr);
                    rect.set(iArr[0], iArr[1], iArr[0] + currentFocus.getWidth(), iArr[1] + currentFocus.getHeight());
                    if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        return z;
                    }
                } else if (currentFocus2 instanceof EditText) {
                    return z;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus2.getWindowToken(), 0);
                }
                currentFocus2.clearFocus();
                return z;
            }
        }
        return z;
    }

    public static boolean O000000o(String str) {
        boolean z = false;
        try {
            ActivityManager activityManager = (ActivityManager) MyApplication.O000000o().getSystemService("activity");
            if (activityManager != null) {
                List<RunningServiceInfo> runningServices = activityManager.getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                if (runningServices != null) {
                    if (runningServices.size() > 0) {
                        for (RunningServiceInfo runningServiceInfo : runningServices) {
                            if (runningServiceInfo.service.getClassName().equals(str)) {
                                z = true;
                                break;
                            }
                        }
                    }
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public static String O00000Oo() {
        try {
            return O000OO.O0000OoO().versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    public static String O00000Oo(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    public static String O00000Oo(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str = str.replace("https", "http");
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(context.getString(2131689692));
            return O000000o(instance.digest(stringBuilder.toString().getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O00000Oo(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(str.getBytes("ISO-8859-1")));
        byte[] bArr = new byte[256];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read < 0) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static ArrayList<String> O00000Oo(int i) {
        ArrayList arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        for (i -= 2; i >= -1; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(instance.get(1) - i);
            stringBuilder.append("");
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    public static void O00000Oo(Activity activity) {
        NotificationManager notificationManager = (NotificationManager) activity.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(2131689512);
        }
    }

    public static boolean O00000Oo(Activity activity, String str) {
        if (str.startsWith("zjwh://")) {
            O000o0.O000000o(activity, str);
            return true;
        } else if (!str.startsWith("taobao://") && !str.startsWith("tmall://") && !str.startsWith("tbopen://") && !str.startsWith("weixin://wap/pay?") && !str.startsWith("openapp.jdmobile://")) {
            return false;
        } else {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            try {
                if (activity.getPackageManager().resolveActivity(intent, 65536) != null) {
                    activity.startActivity(intent);
                } else {
                    O00Oo00.O000000o(activity, "未安装相应客户端");
                }
            } catch (Exception e) {
                e.printStackTrace();
                O00Oo00.O000000o(activity, "跳转被拒绝，无法正常跳转");
            }
            return true;
        }
    }

    public static boolean O00000Oo(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isAvailable();
                }
            }
        }
        return false;
    }

    public static String O00000o(double d) {
        return new DecimalFormat("0.0").format(d);
    }

    public static String O00000o(String str) {
        if (str.contains("http")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void O00000o() {
        try {
            UserInfo O00000o0 = O00000o0();
            O00000o0.setLogout(true);
            O000000o(O00000o0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean O00000o(Context context) {
        List O0000Oo = O0000Oo(context);
        for (int i = 0; i < O0000Oo.size(); i++) {
            if (new File((String) O0000Oo.get(i)).exists()) {
                return true;
            }
        }
        return false;
    }

    public static Point O00000o0(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point;
    }

    public static UserInfo O00000o0() {
        try {
            return (UserInfo) O0000O0o().selector(UserInfo.class).orderBy("timestamp", true).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O00000o0(double d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d + 1.0E-6d);
        stringBuilder.append("");
        BigDecimal scale = new BigDecimal(stringBuilder.toString()).setScale(2, 1);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(scale);
        stringBuilder2.append("");
        return stringBuilder2.toString();
    }

    public static boolean O00000o0(int i) {
        return O0000oO0() > ((long) ((i * 1024) * 1024));
    }

    public static boolean O00000o0(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!O000000o(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static double O00000oO(double d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((d / 1000.0d) + 1.0E-6d);
        stringBuilder.append("");
        return new BigDecimal(stringBuilder.toString()).setScale(2, 1).doubleValue();
    }

    public static int O00000oO() {
        UserInfo O00000o0 = O00000o0();
        return O00000o0 != null ? O00000o0.getUid() : -1;
    }

    public static String O00000oO(Context context) {
        String str = "000000";
        String O00000Oo = u.O00000Oo(context);
        return !TextUtils.isEmpty(O00000Oo) ? O00000Oo : str;
    }

    public static double O00000oo(double d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d + 1.0E-6d);
        stringBuilder.append("");
        return new BigDecimal(stringBuilder.toString()).setScale(2, 1).doubleValue();
    }

    public static int O00000oo() {
        UserInfo O00000o0 = O00000o0();
        return O00000o0 != null ? O00000o0.getUnid() : -1;
    }

    public static Activity O00000oo(Context context) {
        return context == null ? null : context instanceof Activity ? (Activity) context : context instanceof ContextWrapper ? O00000oo(((ContextWrapper) context).getBaseContext()) : null;
    }

    private static Bitmap O00000oo(String str) {
        byte[] decode = Base64.decode(str.split(",")[1], 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static int O0000O0o(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            State state = networkInfo.getState();
            if (state != null && (state == State.CONNECTED || state == State.CONNECTING)) {
                return 1;
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return 0;
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 5;
        }
    }

    public static String O0000O0o(double d) {
        int i = (int) d;
        int i2 = (int) ((d - ((double) i)) * 60.0d);
        StringBuilder stringBuilder;
        if (i2 < 10) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("′0");
            stringBuilder.append(i2);
            stringBuilder.append("″");
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("′");
        stringBuilder.append(i2);
        stringBuilder.append("″");
        return stringBuilder.toString();
    }

    public static DbManager O0000O0o() {
        if (O0000Oo0 == null) {
            O0000Oo0 = org.xutils.x.getDb(MyApplication.O000000o().O00000Oo());
        }
        return O0000Oo0;
    }

    public static void O0000OOo() {
        new 3().execute();
    }

    @RequiresApi(api = 17)
    public static boolean O0000OOo(Context context) {
        return Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    public static int O0000Oo() {
        int intValue = ((Integer) O00O0Oo0.O00000o0(SportFragment.O0000OOo, Integer.valueOf(-1))).intValue();
        String str = (String) O00O0Oo0.O00000o0(SportFragment.O0000O0o, "");
        UserInfo O00000o0 = O00000o0();
        if (O00000o0 != null) {
            if (intValue == -1) {
                intValue = O00000o0.getUnid();
            }
            if (TextUtils.isEmpty(str)) {
                str = O00000o0.getCampusName();
            }
        }
        if (intValue == -1) {
            return -1;
        }
        NearBySchoolBean nearBySchoolBean = new NearBySchoolBean(intValue, str);
        DbManager O0000O0o = O0000O0o();
        try {
            if (O0000O0o.selector(NearBySchoolBean.class).where(WhereBuilder.b("unid", HttpUtils.EQUAL_SIGN, Integer.valueOf(nearBySchoolBean.getUnid()))).findAll() != null) {
                O0000O0o.delete(NearBySchoolBean.class, WhereBuilder.b("unid", HttpUtils.EQUAL_SIGN, Integer.valueOf(nearBySchoolBean.getUnid())));
                O0000O0o.save(nearBySchoolBean);
            } else {
                O0000O0o.save(nearBySchoolBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intValue;
    }

    private static List<String> O0000Oo(Context context) {
        List list;
        try {
            String decryptString;
            String str = "";
            try {
                decryptString = new SecurityCipher(context).decryptString((String) O00O0Oo0.O000000o(context, gg.O000O0o, "[]"), context.getString(2131689511));
            } catch (JAQException e) {
                e.printStackTrace();
                decryptString = str;
            }
            list = (List) O000o000.O000000o().fromJson(decryptString, new 4().getType());
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        return (list == null || list.isEmpty()) ? Arrays.asList(gf.O0000oo0) : list;
    }

    public static String O0000Oo0() {
        return UUID.randomUUID().toString();
    }

    public static boolean O0000Oo0(Context context) {
        if (VERSION.SDK_INT < 19) {
            return TextUtils.isEmpty(Secure.getString(context.getContentResolver(), "location_providers_allowed")) ^ 1;
        }
        boolean z = false;
        try {
            if (Secure.getInt(context.getContentResolver(), "location_mode") != 0) {
                z = true;
            }
            return z;
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<NearBySchoolBean> O0000OoO() throws DbException {
        return O0000O0o().selector(NearBySchoolBean.class).orderBy("id", true).limit(3).findAll();
    }

    public static boolean O0000Ooo() {
        return TextUtils.isEmpty((String) O00O0Oo0.O00000o0("run_point_res_url", "")) ^ 1;
    }

    public static long O0000o() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static Map<String, String> O0000o0() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(kz.O000000o("res").getAbsolutePath());
        stringBuilder.append(File.separator);
        String stringBuilder2 = stringBuilder.toString();
        String O0000o00 = O0000o00();
        ArrayMap arrayMap = new ArrayMap();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_must_normal");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        arrayMap.put("img_point_must_normal", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_end");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        arrayMap.put("img_point_end", stringBuilder3.toString());
        return arrayMap;
    }

    public static String O0000o00() {
        return (DensityUtil.getScreenWidth() > 720 ? 1 : null) != null ? "@3x" : "@2x";
    }

    public static Map<String, String> O0000o0O() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(kz.O000000o("res").getAbsolutePath());
        stringBuilder.append(File.separator);
        String stringBuilder2 = stringBuilder.toString();
        String O0000o00 = O0000o00();
        ArrayMap arrayMap = new ArrayMap();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_start");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        arrayMap.put("img_point_start", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_end");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        arrayMap.put("img_point_end", stringBuilder3.toString());
        return arrayMap;
    }

    public static Map<String, String> O0000o0o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(kz.O000000o("res").getAbsolutePath());
        stringBuilder.append(File.separator);
        String stringBuilder2 = stringBuilder.toString();
        String O0000o00 = O0000o00();
        Map O0000o0O = O0000o0O();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_normal");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("img_point_normal", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_normal_pass");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("img_point_normal_pass", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_must_normal");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("img_point_must_normal", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_must_pass");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("img_point_must_pass", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_first_lock");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_first_lock", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_second_lock");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_second_lock", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_third_lock");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_third_lock", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_fourth_lock");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_fourth_lock", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_fifth_lock");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_fifth_lock", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_first");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_first", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_second");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_second", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_third");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_third", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_fourth");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_fourth", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("run_point_fifth");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("run_point_fifth", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_assign_end_normal");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("img_point_assign_end_normal", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("img_point_assign_end_pass");
        stringBuilder3.append(O0000o00);
        stringBuilder3.append(".png");
        O0000o0O.put("img_point_assign_end_pass", stringBuilder3.toString());
        return O0000o0O;
    }

    public static String O0000oO() {
        String str = (String) O00O0Oo0.O00000o0(O000000o, "");
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            long currentTimeMillis = System.currentTimeMillis() - Long.valueOf(split[0]).longValue();
            if (currentTimeMillis < 600000 && currentTimeMillis > 0) {
                return split[1];
            }
        }
        str = O0000Oo0();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(",");
        stringBuilder.append(str);
        O00O0Oo0.O000000o(O000000o, stringBuilder.toString());
        return str;
    }

    public static long O0000oO0() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    private static SoundPool O0000oOO() {
        if (O0000OoO == null) {
            O0000OoO = new SoundPool(1, 1, 5);
            O0000OoO.setOnLoadCompleteListener(new 2());
        }
        return O0000OoO;
    }
}
