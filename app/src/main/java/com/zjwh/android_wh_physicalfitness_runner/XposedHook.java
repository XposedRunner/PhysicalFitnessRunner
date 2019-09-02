package com.zjwh.android_wh_physicalfitness_runner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.zjwh.android_wh_physicalfitness_runner.MapUtils.getDistance;
import static com.zjwh.android_wh_physicalfitness_runner.MapUtils.nextOffsetLatLng;

public class XposedHook {
    @SuppressLint("UseSparseArrays")
    private static List<Object> sequencePoints = new ArrayList<>();
    private static List<Object> randomPoints = new ArrayList<>();
    //    private static Map<Integer, SWFixedPoint> passedSequencePointHashMap = new HashMap<>();
//    private static Map<SWFixedPoint, Integer> passedRandomPointHashMap = new HashMap<>();

    private static int targetLength;
    private static LatLng start;
    private static LatLng actualLatLng = null;
    private static LatLng currentLatLng = null;
    private static LatLng lastLatLng = null;
    private static LatLng currentVirtualLatLng = null;
    private static LatLng lastVirtualLatLng = null;
    private static float direction = 0.0f;
    private static Emulator emulator;
    private static long intervalTimeMillis = 300;
    private static RouteRandom routeRandom;
    private static boolean runWithHook = false;
    private static boolean runSequence;
    private static int runDistance = 0;
    private static boolean running = false;
//    private static Object coordinateConverter = null;

    //rl_setting
    //com.zjwh.android_wh_physicalfitness:id/run_change_page

    public static void hookLoadPackageParam(final XC_LoadPackage.LoadPackageParam loadPackageParam) {
        XposedHelpers.findAndHookMethod("android.app.Instrumentation", loadPackageParam.classLoader, "newApplication",
                "java.lang.ClassLoader", "java.lang.String",
                "android.content.Context", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        if (((String) param.args[1]).contains("com.zjwh.android_wh_physicalfitness")) {
//                            hookLog((Context) param.args[2]);
                            XposedHelpers.findAndHookMethod(XposedBridge.class, "log", String.class, new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    Log.e("Xposed", (String) param.args[0]);
                                }
                            });
                            hookCheatCheck((java.lang.ClassLoader) param.args[0]);
                            hookClassLoader((java.lang.ClassLoader) param.args[0]);

                        }
                    }
                });
    }

    private static void hookClassLoader(final ClassLoader classLoader) {

//        try {
//            for (final Method declaredMethod : SensorManager.class.getDeclaredMethods()) {
//                if (!Modifier.isAbstract(declaredMethod.getModifiers())
//                        && Modifier.isPublic(declaredMethod.getModifiers())) {
//                    XposedBridge.hookMethod(declaredMethod, new XC_MethodHook() {
//                        @Override
//                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            ZjwhRunner.log("SensorManager." + param.method.getName() + ": " + Arrays.toString(param.args));
//                        }
//                    });
//                }
//            }
//        } catch (Exception e) {
//            ZjwhRunner.log(Log.getStackTraceString(e));
//        }
//
//        try {
//            for (Method method : XposedHelpers.findClass("com.amap.api.location.AMapLocationClient", classLoader).getDeclaredMethods()) {
//                if (!Modifier.isAbstract(method.getModifiers())) {
//                    XposedBridge.hookMethod(method, new XC_MethodHook() {
//                        @Override
//                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            try {
//                                ZjwhRunner.log("AMapLocationClient." + param.method.getName() + ": " + param.getResult());
//                            } catch (Exception e) {
//                                ZjwhRunner.log(Log.getStackTraceString(e));
//                            }
//                        }
//                    });
//                }
//
//            }
//        } catch (Exception e) {
//            ZjwhRunner.log(Log.getStackTraceString(e));
//        }
//

//        try {
//            for (Method method : XposedHelpers.findClass("com.amap.api.location.AMapLocation", classLoader).getDeclaredMethods()) {
//                if (Modifier.isPublic(method.getModifiers())
//                        && !Modifier.isAbstract(method.getModifiers())
//                        && method.getName().startsWith("get")) {
//                    XposedBridge.hookMethod(method, new XC_MethodHook() {
//                        @Override
//                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            try {
//                                ZjwhRunner.log("AMapLocation." + param.method.getName() + ": " + param.getResult());
//                            } catch (Exception e) {
//                                ZjwhRunner.log(Log.getStackTraceString(e));
//                            }
//                        }
//                    });
//                }
//
//            }
//        } catch (Exception e) {
//            ZjwhRunner.log(Log.getStackTraceString(e));
//        }

        XposedHelpers.findAndHookMethod("com.zjwh.android_wh_physicalfitness.application.MyApplication", classLoader, "onCreate", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                final Context context = (Context) param.thisObject;
                final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, final Throwable e) {
                        ZjwhRunner.log(Log.getStackTraceString(e));
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        Set<String> stringSet = sharedPreferences.getStringSet("xr_crash", new HashSet<String>());
                        stringSet = stringSet == null ? new HashSet<String>() : stringSet;
                        for (String xrCrash : stringSet) {
                            if (xrCrash.equalsIgnoreCase(e.getMessage() + " " + e.getStackTrace()[0].toString())) {
                                return;
                            }
                        }
                        stringSet.add(e.getMessage() + " " + e.getStackTrace()[0].toString());
                        sharedPreferences.edit().putStringSet("xr_crash", stringSet).apply();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                StringBuilder stringBuilder = new StringBuilder(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()));
                                try {
                                    PackageManager pm = context.getPackageManager();
                                    PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
                                    if (pi != null) {
                                        stringBuilder.append("zjwhVersion: ").append(pi.versionName == null ? "null" : pi.versionName).append(" ").append(pi.versionCode).append("\n");
                                    }
                                } catch (PackageManager.NameNotFoundException ignored) {
                                }
                                stringBuilder.append("xposedVersion: ").append(XposedBridge.getXposedVersion()).append("\n");
                                stringBuilder.append("runnerVersion: ").append(BuildConfig.VERSION_NAME).append(" ").append(BuildConfig.VERSION_CODE).append("\n");
                                Field[] fields = Build.class.getDeclaredFields();
                                for (Field field : fields) {
                                    try {
                                        field.setAccessible(true);
                                        stringBuilder.append(field.getName()).append(": ").append(field.get(null).toString()).append("\n");
                                    } catch (Exception ignored) {
                                    }
                                }
                                stringBuilder.append("crashInfo: ").append(Log.getStackTraceString(e));
                                Properties properties = new Properties();
                                properties.put("mail.smtp.host", "smtp.mail.com");
                                properties.put("mail.smtp.port", "465");
                                properties.put("mail.smtp.auth", "true");
                                properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                properties.setProperty("mail.smtp.socketFactory.fallback", "false");
                                properties.setProperty("mail.smtp.socketFactory.port", "465");
                                Session sendMailSession = Session.getDefaultInstance(properties, new Authenticator() {
                                    @Override
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return TODO(new PasswordAuthentication("mailsender", "passwd"));//Please update this if you want to get crashes as soon as possible!
                                    }
                                });
                                try {
                                    Message mailMessage = new MimeMessage(sendMailSession);
                                    Address from = new TODO(InternetAddress("mailsender"));//Please update this if you want to get crashes as soon as possible!
                                    mailMessage.setFrom(from);
                                    Address to = new TODO(InternetAddress("mailreceiver"));//Please update this if you want to get crashes as soon as possible!
                                    mailMessage.setRecipient(Message.RecipientType.TO, to);
                                    mailMessage.setSubject("[ZJWH_RUNNER_CRASH] " + DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()));
                                    mailMessage.setSentDate(new Date());
                                    mailMessage.setText(stringBuilder.toString());
                                    Transport.send(mailMessage);
                                } catch (MessagingException ignored) {
                                }
                            }
                        }).start();
                        if (uncaughtExceptionHandler != null) {
                            uncaughtExceptionHandler.uncaughtException(t, e);
                        }
                    }
                });

            }
        });

        XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "onDestroy", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                if (Objects.equals(param.thisObject.getClass().getName(), "com.zjwh.android_wh_physicalfitness.ui.run.RunSequenceActivity")
                        || Objects.equals(param.thisObject.getClass().getName(), "com.zjwh.android_wh_physicalfitness.ui.run.RunRandomActivity")) {
                    if (emulator != null) {
                        emulator.stop();
                        emulator = null;
                    }
                    sequencePoints.clear();
                    randomPoints.clear();
                    start = null;
                    currentLatLng = null;
                    direction = 0.0f;
                    lastLatLng = null;
                    currentVirtualLatLng = null;
                    lastVirtualLatLng = null;
                    routeRandom = null;
                    actualLatLng = null;
                    running = false;
                    runDistance = 0;
//                runWithHook = false;

                }
            }
        });

        XposedHelpers.findAndHookMethod("com.zjwh.android_wh_physicalfitness.entity.RunRuleModel", classLoader, "getMinDistance", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
//                ZjwhRunner.log("RunRuleModel: " + param.thisObject.toString());
                targetLength = (int) param.getResult();
            }
        });


        XposedBridge.hookAllConstructors(XposedHelpers.findClass("com.zjwh.sw.map.entity.SWFixedPoint", classLoader), new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
//                ZjwhRunner.log("SWFixedPoint: " + param.thisObject.toString());
                sequencePoints.add(param.thisObject);
                randomPoints.add(param.thisObject);
            }
        });

        XposedHelpers.findAndHookMethod("android.view.View", classLoader, "setOnClickListener", "android.view.View.OnClickListener", new XC_MethodHook() {
//            private List<String> hookedClasses = new ArrayList<>();

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                final View view = (View) param.thisObject;
                if (view.getId() == view.getContext().getResources().getIdentifier("ivSportStart", "id", view.getContext().getPackageName())) {
                    Object mListenerInfo = XposedHelpers.getObjectField(view, "mListenerInfo");
                    final Object onLongClickListener = XposedHelpers.getObjectField(mListenerInfo, "mOnLongClickListener");
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            boolean originalCallback = false;
                            if (onLongClickListener != null) {
                                originalCallback = (boolean) XposedHelpers.callMethod(onLongClickListener, "onLongClick", "android.view.View", v);
                            }
                            runWithHook = true;
                            Toast.makeText(view.getContext(), "辅助跑步已开启", Toast.LENGTH_LONG).show();
                            view.performClick();
                            return originalCallback;
                        }
                    });
                }

            }
        });

        XposedHelpers.findAndHookMethod("android.widget.TextView", classLoader, "setText", CharSequence.class, "android.widget.TextView.BufferType", boolean.class, int.class, new XC_MethodHook() {

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                if (!runWithHook) {
                    return;
                }

                String string = param.args[0].toString();
                if (string.matches("([+-]?\\d*\\.\\d+)(?![-+0-9\\.])")) {
                    int distance = (int) (Float.parseFloat(string) * 1000);
                    if (emulator != null && distance > runDistance + emulator.getSpeed() * 120) {
                        float speed = (float) (2.0 + 0.8 * Math.random());
                        emulator.setSpeed(speed);
                        intervalTimeMillis = (long) (300 / (speed / 2.8));
                        runDistance = distance;
                    }
//                    ZjwhRunner.log("TextView.setText: " + (Float.parseFloat(string) * 1000));
//                    ZjwhRunner.log("TextView.getId: " + ((TextView) param.thisObject).getId());
                }
                if (string.matches("((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)")) {
                    int seconds = 0;
                    String[] substrings = string.split(":");
                    for (int i = substrings.length - 1; i >= 0; i--) {
                        seconds += Integer.parseInt(substrings[i]) * Math.pow(60, substrings.length - 1 - i);
                    }
                    running = seconds > 3;
//                    ZjwhRunner.log("TextView.setText: " + seconds);
//                    ZjwhRunner.log("TextView.getId: " + ((TextView) param.thisObject).getId());
                }
            }
        });

        XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!((Activity) param.thisObject).getIntent().hasExtra("extra_start_flag")) {
                    return;
                }
                switch (param.thisObject.getClass().getSimpleName()) {
                    case "RunSequenceActivity":
                        ZjwhRunner.log("  > RunSequenceActivity.onCreate");
                        runSequence = true;
                        break;
                    case "RunRandomActivity":
                        ZjwhRunner.log("  > RunRandomActivity.onCreate");
                        runSequence = false;
                        break;
                    default:
                }


            }
        });

//        XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "onResume", new XC_MethodHook() {
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) {
//                if (!Objects.equals(param.thisObject.getClass().getName(), "com.zjwh.android_wh_physicalfitness.activity.MainActivity")) {
//                    return;
//                }
//                sequencePoints.clear();
//                randomPoints.clear();
//                start = null;
//                currentLatLng = null;
//                direction = 0.0f;
//                lastLatLng = null;
//                currentVirtualLatLng = null;
//                lastVirtualLatLng = null;
//                routeRandom = null;
//                actualLatLng = null;
////                runWithHook = false;
//            }
//        });

        XposedHelpers.findAndHookMethod("com.amap.api.location.AMapLocationClientOption", classLoader, "setLocationPurpose", "com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!runWithHook) {
                    return;
                }
                Class clazzAMapLocationMode = XposedHelpers.findClass("com.amap.api.location.AMapLocationClientOption.AMapLocationMode", classLoader);
                param.setResult(XposedHelpers.callMethod(param.thisObject, "setLocationMode", new Class[]{clazzAMapLocationMode}, Enum.valueOf(clazzAMapLocationMode, "Battery_Saving")));
            }
        });

//        XposedHelpers.findAndHookMethod("com.amap.api.location.AMapLocation", classLoader, "getSatellites", new XC_MethodHook() {
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                ZjwhRunner.log("getSatellites: " + param.getResult());
//            }
//        });


//        XposedHelpers.findAndHookMethod("com.amap.api.location.AMapLocationClient", classLoader, "isStarted", XC_MethodReplacement.returnConstant(true));

//        XposedHelpers.findAndHookMethod("com.amap.api.location.AMapLocation",classLoader,"getLocationType",XC_MethodReplacement.returnConstant(1));
//        XposedHelpers.findAndHookMethod("com.amap.api.location.AMapLocation",classLoader,"getProvider",XC_MethodReplacement.returnConstant("gps"));

        XposedHelpers.findAndHookMethod("com.amap.api.location.AMapLocationClient", classLoader, "setLocationListener", "com.amap.api.location.AMapLocationListener", new XC_MethodHook() {
            List<Class> hooked = new ArrayList<>();
            Context context;
            long lastUpdateTimeNanos = System.nanoTime();

            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                if (context == null) {
                    for (Field field : param.thisObject.getClass().getDeclaredFields()) {
                        if (field.getType().equals(Context.class)) {
                            context = ((Context) XposedHelpers.getObjectField(param.thisObject, field.getName())).getApplicationContext();
                            break;
                        }
                    }
                }
                Class clazz = param.args[0].getClass();
//                ZjwhRunner.log("setLocationListener: " + clazz.getName());
                if (hooked.contains(clazz) && clazz.getName().startsWith("com.loc") && clazz.getName().startsWith("com.amap")) {
                    return;
                }
                hooked.add(clazz);

                XposedHelpers.findAndHookMethod(clazz, "onLocationChanged", "com.amap.api.location.AMapLocation", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
//                        for (Method method : param.args[0].getClass().getDeclaredMethods()) {
//                            final Object object = param.args[0];
//                            if (Modifier.isPublic(method.getModifiers())
//                                    && !Modifier.isAbstract(method.getModifiers())
//                                    && method.getName().startsWith("get")) {
//                                XposedBridge.hookMethod(method, new XC_MethodHook() {
//                                    @Override
//                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                                        if (param.thisObject.hashCode() == object.hashCode()) {
//                                            ZjwhRunner.log(param.thisObject + "." + param.method.getName() + ": " + param.getResult());
//                                        }
//                                    }
//                                });
//                            }
//                        }
                        if (!runWithHook) {
                            return;
                        }

                        XposedHelpers.callMethod(param.args[0], "setAccuracy", new Class[]{float.class}, (float) Math.round(10 + 10 * Math.random()));
                        XposedHelpers.callMethod(param.args[0], "setAltitude", new Class[]{double.class}, (double) (50 + 20 * Math.random()));
                        XposedHelpers.callMethod(param.args[0], "setErrorCode", new Class[]{int.class}, 0);
                        XposedHelpers.callMethod(param.args[0], "setErrorInfo", new Class[]{String.class}, "success");
                        XposedHelpers.callMethod(param.args[0], "setMock", new Class[]{boolean.class}, false);
                        XposedHelpers.callMethod(param.args[0], "setLocationType", new Class[]{int.class}, 1);
                        XposedHelpers.callMethod(param.args[0], "setProvider", new Class[]{String.class}, "gps");
                        XposedHelpers.callMethod(param.args[0], "setSatellites", new Class[]{int.class}, (int) Math.round(12 + 4 * Math.random()));
                        XposedHelpers.callMethod(param.args[0], "setGpsAccuracyStatus", new Class[]{int.class}, 1);
                        XposedHelpers.callMethod(param.args[0], "setConScenario", new Class[]{int.class}, -((int) (60 + 39 * Math.random())));
                        actualLatLng = new LatLng((double) XposedHelpers.callMethod(param.args[0], "getLatitude")
                                , (double) XposedHelpers.callMethod(param.args[0], "getLongitude"));
                        if (start == null && running) {
                            if (randomPoints.size() > 0 && !runSequence) {
                                start = actualLatLng;
                                List<RandomRoutePlanner.RoutePoint> routePoints = new ArrayList<>();
                                for (Object object : randomPoints) {
                                    RandomRoutePlanner.RoutePoint routePoint = new RandomRoutePlanner.RoutePoint();
                                    double d = (double) XposedHelpers.callMethod(object, "getBLat");
                                    double d2 = (double) XposedHelpers.callMethod(object, "getBLon");
                                    routePoint.latLng = toGCJ02(new LatLng(d, d2));
                                    routePoint.required = (int) XposedHelpers.callMethod(object, "getIsFixed") == 1;
                                    routePoints.add(routePoint);
                                    ZjwhRunner.log(routePoint.toString());
                                }
                                RandomRoutePlanner.plan(context, start, routePoints, targetLength, new RandomRoutePlanner.OnPlanCompleteListener() {
                                    @Override
                                    public void onComplete(List<LatLng> latLngList) {
                                        Toast.makeText(context, "算路成功，开始跑步", Toast.LENGTH_SHORT).show();
                                        latLngList.add(0, actualLatLng);
                                        emulator = Emulator.create(/*RouteFaker.fakeRoute(latLngList)*/latLngList, 2.5f, new Emulator.Listener() {
                                            @Override
                                            public void onEmulating(Emulator emulator, LatLng latLng, Angle angle, int extra) {
                                                switch (extra) {
                                                    case Emulator.EXTRA_START:
                                                        currentLatLng = latLng;
                                                        lastLatLng = latLng;
                                                        currentVirtualLatLng = latLng;
                                                        lastVirtualLatLng = latLng;
                                                        routeRandom = RouteRandom.create(50, 100, 2, 15);
                                                        break;
                                                    case Emulator.EXTRA_EMULATING:
                                                        lastVirtualLatLng = currentVirtualLatLng;
                                                        currentVirtualLatLng = latLng;
                                                        double random = routeRandom.next(getDistance(lastVirtualLatLng, currentVirtualLatLng));
                                                        currentLatLng = nextOffsetLatLng(latLng, angle, random);
                                                        direction = (float) Angle.elevate(lastLatLng, currentLatLng).deg();
                                                        break;
                                                    case Emulator.EXTRA_STOP:
                                                        Toast.makeText(context, "跑步已结束，请尽快结束此次跑步", Toast.LENGTH_LONG).show();
                                                        break;
                                                }
                                            }
                                        });
                                        emulator.start();
                                    }

                                    @Override
                                    public void onError() {
                                        Toast.makeText(context, "算路失败，请结束跑步尝试更换起始位置并重新开始跑步", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if (sequencePoints.size() > 0 && runSequence) {
                                start = actualLatLng;
                                List<SequenceRoutePlanner.RoutePoint> routePoints = new ArrayList<>();
                                for (Object object : sequencePoints) {
                                    SequenceRoutePlanner.RoutePoint routePoint = new SequenceRoutePlanner.RoutePoint();
                                    double d = (double) XposedHelpers.callMethod(object, "getBLat");
                                    double d2 = (double) XposedHelpers.callMethod(object, "getBLon");
                                    routePoint.latLng = toGCJ02(new LatLng(d, d2));
                                    routePoint.order = (int) XposedHelpers.callMethod(object, "getPosition");
                                    routePoints.add(routePoint);
                                }
                                SequenceRoutePlanner.plan(context, start, routePoints, targetLength, new SequenceRoutePlanner.OnPlanCompleteListener() {
                                    @Override
                                    public void onComplete(List<LatLng> latLngList) {
                                        Toast.makeText(context, "算路成功，开始跑步", Toast.LENGTH_SHORT).show();
                                        latLngList.add(0, actualLatLng);
                                        emulator = Emulator.create(/*RouteFaker.fakeRoute(latLngList)*/latLngList, 2.5f, new Emulator.Listener() {
                                            @Override
                                            public void onEmulating(Emulator emulator, LatLng latLng, Angle angle, int extra) {
                                                switch (extra) {
                                                    case Emulator.EXTRA_START:
                                                        currentLatLng = latLng;
                                                        lastLatLng = latLng;
                                                        currentVirtualLatLng = latLng;
                                                        lastVirtualLatLng = latLng;
                                                        routeRandom = RouteRandom.create(50, 100, 2, 15);
                                                        break;
                                                    case Emulator.EXTRA_EMULATING:
                                                        lastVirtualLatLng = currentVirtualLatLng;
                                                        currentVirtualLatLng = latLng;
                                                        double random = routeRandom.next(getDistance(lastVirtualLatLng, currentVirtualLatLng));
                                                        currentLatLng = nextOffsetLatLng(latLng, angle, random);
                                                        direction = (float) Angle.elevate(lastLatLng, currentLatLng).deg();
                                                        break;
                                                    case Emulator.EXTRA_STOP:
                                                        Toast.makeText(context, "跑步已结束，请尽快结束此次跑步", Toast.LENGTH_LONG).show();
                                                        break;
                                                }
                                            }
                                        });
                                        emulator.start();
                                    }

                                    @Override
                                    public void onError() {
                                        Toast.makeText(context, "算路失败，请结束跑步尝试更换起始位置并重新开始跑步", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                        if (lastLatLng != null && currentLatLng != null) {
                            actualLatLng = lastLatLng;
                        }
                        if (currentLatLng != null) {
                            long time = System.nanoTime() - lastUpdateTimeNanos;
                            lastUpdateTimeNanos += time;
                            XposedHelpers.callMethod(param.args[0], "setSpeed", new Class[]{float.class}, (float) (getDistance(lastLatLng, currentLatLng) / time * 1000000f));
                            XposedHelpers.callMethod(param.args[0], "setLatitude", new Class[]{double.class}, currentLatLng.latitude);
                            XposedHelpers.callMethod(param.args[0], "setLongitude", new Class[]{double.class}, currentLatLng.longitude);
                            XposedHelpers.callMethod(param.args[0], "setBearing", new Class[]{float.class}, direction);
                            lastLatLng = new LatLng(currentLatLng.latitude, currentLatLng.longitude);
                        }
                    }
                });
            }
        });

        XposedHelpers.findAndHookMethod("android.hardware.SensorManager", classLoader, "getSensorList", int.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                List list = (List) param.getResult();
                List<Sensor> sensors = new ArrayList<>();
                for (Object o : list) {
                    if (((Sensor) o).getType() == Sensor.TYPE_STEP_COUNTER || ((Sensor) o).getType() == Sensor.TYPE_STEP_DETECTOR) {
                        continue;
                    }
                    sensors.add((Sensor) o);
                }
                param.setResult(sensors);
            }
        });

        XposedHelpers.findAndHookMethod("android.hardware.SensorManager", classLoader, "getDefaultSensor", int.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                int i = (int) param.args[0];
                if (i == Sensor.TYPE_STEP_COUNTER || i == Sensor.TYPE_STEP_DETECTOR) {
                    param.setResult(null);
                }
            }
        });


        final Class sensorEventQueueClazz = XposedHelpers.findClass("android.hardware.SystemSensorManager$SensorEventQueue", classLoader);
        XposedBridge.hookAllMethods(sensorEventQueueClazz, "dispatchSensorEvent", new XC_MethodHook() {
            private long lastUpdateTimeMillis = 0;
//            private long lastStepCounterUpdateTimeMillis = 0;


            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                if (!runWithHook) {
                    return;
                }

                Object sensorEvents = XposedHelpers.getObjectField(param.thisObject, "mSensorsEvents");
                SensorEvent sensorEvent = (SensorEvent) XposedHelpers.callMethod(sensorEvents, "get", new Class[]{int.class}, param.args[0]);
                if (sensorEvent == null) {
                    return;
                }
                Sensor sensor = sensorEvent.sensor;
                if (sensor != null && sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - lastUpdateTimeMillis > intervalTimeMillis) {
                        lastUpdateTimeMillis = currentTimeMillis;
                        ((float[]) param.args[1])[0] = (float) (10 + 29 * Math.random());
                        ((float[]) param.args[1])[1] = (float) (10 + 29 * Math.random());
                        ((float[]) param.args[1])[2] = (float) (10 + 29 * Math.random());

                    }
                }
                if (sensor != null && sensor.getType() == Sensor.TYPE_ORIENTATION && direction != 0.0f) {
                    ((float[]) param.args[1])[0] = (direction == 0.0f ? ((float[]) param.args[1])[0] : direction);
                    ((float[]) param.args[1])[1] = (float) (-20 + 180 * Math.random());
                    ((float[]) param.args[1])[2] = (float) (30 + 30 * Math.random());
                }
//                if (sensor != null && sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
//                    ZjwhRunner.log("StepCounter: " + ((float[]) param.args[1])[0]);
//                    long currentTimeMillis = System.currentTimeMillis();
//                    if (currentTimeMillis - lastStepCounterUpdateTimeMillis > 500) {
//                        lastStepCounterUpdateTimeMillis = currentTimeMillis;
//                        double random = Math.random();
//                        if (random < 0.25) {
//                            ((float[]) param.args[1])[0] += 1;
//                        } else if (random < 0.75) {
//                            ((float[]) param.args[1])[0] += 2;
//                        } else {
//                            ((float[]) param.args[1])[0] += 3;
//                        }
//                    }
//                }
            }
        });

//        XposedHelpers.findAndHookMethod("android.hardware.SensorManager", classLoader, "registerListener", SensorEventListener.class, Sensor.class, int.class, Handler.class, new XC_MethodHook() {
//            SensorEventListener stepCounterEventListener;
//            Sensor stepCounter;
//            float step = (float) Math.round(10000 * Math.random());
//            private long lastStepCounterUpdateTimeMillis = 0;
//            List<Class> hookedClass = new ArrayList<>();
//
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                if (param.args[1] != null && ((Sensor) param.args[1]).getType() == Sensor.TYPE_ACCELEROMETER) {
//                    Class clazz = param.args[0].getClass();
//                    if (!hookedClass.contains(clazz)) {
//                        hookedClass.add(clazz);
//                        XposedHelpers.findAndHookMethod(clazz, "onSensorChanged", SensorEvent.class, new XC_MethodHook() {
//                            @Override
//                            protected void afterHookedMethod(MethodHookParam param) {
//                                long currentTimeMillis = System.currentTimeMillis();
//                                if (currentTimeMillis - lastStepCounterUpdateTimeMillis > 1000) {
//                                    lastStepCounterUpdateTimeMillis = currentTimeMillis;
//                                    new Thread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            double random = Math.random();
//                                            if (random < 0.25) {
//                                                for (int i = 0; i < 1; i++) {
//                                                    if (stepCounterEventListener != null) {
//                                                        SensorEvent sensorEvent = (SensorEvent) XposedHelpers.newInstance(SensorEvent.class, new Class[]{int.class}, 1);
//                                                        sensorEvent.sensor = stepCounter;
//                                                        sensorEvent.accuracy = 3;
//                                                        sensorEvent.timestamp = System.nanoTime();
//                                                        sensorEvent.values[0] = (step++);
//                                                        stepCounterEventListener.onSensorChanged(sensorEvent);
//                                                        try {
//                                                            Thread.sleep(233);
//                                                        } catch (InterruptedException ignored) {
//                                                        }
//                                                    }
//                                                }
//
//                                            } else if (random < 0.75) {
//                                                for (int i = 0; i < 2; i++) {
//                                                    if (stepCounterEventListener != null) {
//                                                        SensorEvent sensorEvent = (SensorEvent) XposedHelpers.newInstance(SensorEvent.class, new Class[]{int.class}, 1);
//                                                        sensorEvent.sensor = stepCounter;
//                                                        sensorEvent.accuracy = 3;
//                                                        sensorEvent.timestamp = System.nanoTime();
//                                                        sensorEvent.values[0] = (step++);
//                                                        stepCounterEventListener.onSensorChanged(sensorEvent);
//                                                    }
//                                                    try {
//                                                        Thread.sleep(233);
//                                                    } catch (InterruptedException ignored) {
//                                                    }
//                                                }
//                                            } else {
//                                                for (int i = 0; i < 3; i++) {
//                                                    if (stepCounterEventListener != null) {
//                                                        SensorEvent sensorEvent = (SensorEvent) XposedHelpers.newInstance(SensorEvent.class, new Class[]{int.class}, 1);
//                                                        sensorEvent.sensor = stepCounter;
//                                                        sensorEvent.accuracy = 3;
//                                                        sensorEvent.timestamp = System.nanoTime();
//                                                        sensorEvent.values[0] = (step++);
//                                                        stepCounterEventListener.onSensorChanged(sensorEvent);
//                                                    }
//                                                    try {
//                                                        Thread.sleep(233);
//                                                    } catch (InterruptedException ignored) {
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }).start();
//                                }
//                            }
//                        });
//                    }
//
//                }
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                if (param.args[1] != null && ((Sensor) param.args[1]).getType() == Sensor.TYPE_STEP_COUNTER) {
//                    stepCounterEventListener = (SensorEventListener) param.args[0];
//                    stepCounter = (Sensor) param.args[1];
//                    XposedHelpers.callMethod(param.thisObject, "unregisterListener", new Class[]{SensorEventListener.class, Sensor.class}, param.args[0], param.args[1]);
//                }
//            }
//        });

        XposedHelpers.findAndHookMethod("android.hardware.SensorManager", classLoader, "getOrientation", float[].class, float[].class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                if (!runWithHook) {
                    return;
                }
                if (direction != 0.0f) {
                    float[] floats = new float[3];
                    floats[0] = (float) (direction - 5 + 10 * Math.random());
                    floats[1] = (float) (-20 + 180 * Math.random());
                    floats[2] = (float) (30 + 30 * Math.random());
                    param.setResult(floats);
                }
            }
        });


    }

    private static void hookCheatCheck(ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod("java.lang.StackTraceElement", classLoader, "getClassName",
                new XC_MethodHook() {
                    List<String> list = new ArrayList<>();

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        for (String name : Arrays.asList("com.android.internal.os.ZygoteInit",
                                "de.robv.android.xposed.XposedBridge")) {
                            if (name.equals(param.getResult())) {
                                if (!list.contains(param.getResult().toString())) {
                                    ZjwhRunner.log("  > hideStackTraceElement: " + param.getResult().toString());
                                }
                                list.add(param.getResult().toString());
                                param.setResult("com.android.internal.os.OSInit");
                            }
                        }
                    }
                });
        XposedHelpers.findAndHookConstructor("java.io.FileReader", classLoader, "java.lang.String", new XC_MethodHook() {
            List<String> list = new ArrayList<>();

            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                if (((String) param.args[0]).matches("/proc/[0-9]+/maps")
                        || withSemiMatch((String) param.args[0])
                        || withFullMatch((String) param.args[0])) {
                    if (!list.contains(param.args[0].toString())) {
                        ZjwhRunner.log("  > hideFileReader: " + param.args[0].toString());
                    }
                    list.add(param.args[0].toString());
                    param.setThrowable(new FileNotFoundException());
                }
            }
        });
        XposedHelpers.findAndHookMethod("java.lang.reflect.Modifier", classLoader, "isNative",
                int.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(false);
                    }
                });
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
            List<String> list = new ArrayList<>();

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (ZjwhRunner.ZJWH_PACKAGE_NAME.equals(param.args[0])) {
                    return;
                }
                if (ZjwhRunner.MODULE_PACKAGE_NAME.equals(param.args[0])) {
                    ZjwhRunner.modulePackageInfo = (PackageInfo) param.getResult();
                }
                if (withFullMatch((String) param.args[0]) || withSemiMatch((String) param.args[0])) {
                    if (!list.contains(param.args[0].toString())) {
                        ZjwhRunner.log("  > hidePackageInfo: " + param.args[0].toString());
                    }
                    list.add(param.args[0].toString());
                    param.setThrowable(new PackageManager.NameNotFoundException());
                    return;
                }
                if (param.getResultOrThrowable() != null && !(param.getResultOrThrowable() instanceof Throwable)) {
                    PackageInfo packageInfo = (PackageInfo) param.getResultOrThrowable();
                    if (!((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0)) {
                        param.setThrowable(new PackageManager.NameNotFoundException());
                    }
                }
            }
        });
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", classLoader, "getApplicationInfo", String.class, int.class, new XC_MethodHook() {
            List<String> list = new ArrayList<>();

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (ZjwhRunner.ZJWH_PACKAGE_NAME.equals(param.args[0])) {
                    return;
                }
                if (ZjwhRunner.MODULE_PACKAGE_NAME.equals(param.args[0])) {
                    ZjwhRunner.moduleApplicationInfo = (ApplicationInfo) param.getResult();
                }
                if (withFullMatch((String) param.args[0]) || withSemiMatch((String) param.args[0])) {
                    if (!list.contains(param.args[0].toString())) {
                        ZjwhRunner.log("  > hideApplicationInfo: " + param.args[0].toString());
                    }
                    list.add(param.args[0].toString());
                    param.setThrowable(new PackageManager.NameNotFoundException());
                    return;
                }
                if (param.getResultOrThrowable() != null && !(param.getResultOrThrowable() instanceof Throwable)) {
                    ApplicationInfo applicationInfo = (ApplicationInfo) param.getResultOrThrowable();
                    if (!((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0)) {
                        param.setThrowable(new PackageManager.NameNotFoundException());
                    }

                }
            }
        });
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", classLoader, "getInstalledApplications",
                int.class, new XC_MethodHook() {
                    List<String> list = new ArrayList<>();

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        List applicationList = (List) param.getResult();
                        List<ApplicationInfo> resultApplicationList = new ArrayList<>();

                        for (Object object : applicationList) {
                            ApplicationInfo applicationInfo = (ApplicationInfo) object;
                            if (Objects.equals(applicationInfo.packageName, ZjwhRunner.ZJWH_PACKAGE_NAME)) {
                                resultApplicationList.add(applicationInfo);
                            }
                            if (withFullMatch(applicationInfo.packageName)
                                    || withSemiMatch(applicationInfo.packageName)) {
                                if (!list.contains(applicationInfo.packageName)) {
                                    ZjwhRunner.log("  > hideInstalledApplication: " + applicationInfo.packageName);
                                }
                                list.add(applicationInfo.packageName);
                                continue;
                            }
                            if (!((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0)) {
                                continue;
                            }
                            resultApplicationList.add(applicationInfo);
                        }

                        param.setResult(resultApplicationList);
                    }
                });
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", classLoader, "getInstalledPackages",
                int.class, new XC_MethodHook() {
                    List<String> list = new ArrayList<>();

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        List packageInfoList = (List) param.getResult();
                        List<PackageInfo> resultPackageInfoList = new ArrayList<>();

                        for (Object object : packageInfoList) {
                            PackageInfo packageInfo = (PackageInfo) object;
                            if (Objects.equals(packageInfo.packageName, ZjwhRunner.ZJWH_PACKAGE_NAME)) {
                                resultPackageInfoList.add(packageInfo);
                            }
                            if (withFullMatch(packageInfo.packageName)
                                    || withSemiMatch(packageInfo.packageName)) {
                                if (!list.contains(packageInfo.packageName)) {
                                    ZjwhRunner.log("  > hideInstalledPackage: " + packageInfo.packageName);
                                }
                                list.add(packageInfo.packageName);
                                continue;
                            }
                            if (!((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0)) {
                                continue;
                            }
                            resultPackageInfoList.add(packageInfo);
                        }

                        param.setResult(resultPackageInfoList);
                    }
                });

    }

    private static boolean withFullMatch(String packageName) {
        List<String> protectList = Arrays.asList("de.robv.android.xposed.installer", ZjwhRunner.MODULE_PACKAGE_NAME);
        for (String s : protectList) {
            if (s.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean withSemiMatch(String packageName) {
        List<String> protectList = Arrays.asList("xposed", "runner", "fake", "location", "gps",
                "substrate", "mock", "root", "hide", "supersu", "superuser", "hook");
        for (String s : protectList) {
            if (packageName.contains(s)) {
                return true;
            }
        }
        return false;
    }

//    private static LatLng bd2Gd(LatLng latLng) {
//        double x = latLng.longitude - 0.0065, y = latLng.latitude - 0.006;
//        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);
//        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);
//        ZjwhRunner.log("bd2Gd: " + latLng.toString() + " " + new LatLng(z * Math.sin(theta), z * Math.cos(theta)).toString());
//        return new LatLng(z * Math.sin(theta), z * Math.cos(theta));
//    }

    private static LatLng toGCJ02(LatLng latLng) {
        double x = latLng.longitude - 0.0065, y = latLng.latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI * 3000.0 / 180.0);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI * 3000.0 / 180.0);
        double gg_lon = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        ZjwhRunner.log("  > toGCJ02: " + latLng.toString() + " " + new LatLng(gg_lat, gg_lon).toString());
        return new LatLng(gg_lat, gg_lon);
    }
}
