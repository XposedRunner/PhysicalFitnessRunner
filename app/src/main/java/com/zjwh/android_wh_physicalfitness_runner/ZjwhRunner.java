package com.zjwh.android_wh_physicalfitness_runner;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.support.annotation.Keep;
import android.util.Log;

import net.androidwing.hotxposed.HotXposed;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

@Keep
public class ZjwhRunner implements IXposedHookLoadPackage, IXposedHookZygoteInit {

    public static final String ZJWH_PACKAGE_NAME = "com.zjwh.android_wh_physicalfitness";
    public static final String MODULE_PACKAGE_NAME = ZJWH_PACKAGE_NAME + "_runner";
    public static final String MODULE_LOADED_PATH = null;
    public static PackageInfo modulePackageInfo;
    public static ApplicationInfo moduleApplicationInfo;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (ZjwhRunner.ZJWH_PACKAGE_NAME.equals(loadPackageParam.packageName)) {
            ZjwhRunner.log("> foundLoadPackageParam: " + loadPackageParam.packageName);
            ZjwhRunner.log(" > hookRelease");
            XposedHook.hookLoadPackageParam(loadPackageParam);
        }

    }

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        Field field = ZjwhRunner.class.getDeclaredField("MODULE_LOADED_PATH");
        field.setAccessible(!field.isAccessible());
        field.set(null, startupParam.modulePath);
        field.setAccessible(!field.isAccessible());
        ZjwhRunner.log("Module init done.");
    }

    public static void log(String log) {
        XposedBridge.log("[zjwh_runner] " + log);
    }


}
