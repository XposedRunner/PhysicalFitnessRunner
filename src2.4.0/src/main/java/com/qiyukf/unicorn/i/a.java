package com.qiyukf.unicorn.i;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.Instrumentation.ActivityResult;
import android.app.UiAutomation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.TestLooperManager;
import android.view.KeyEvent;
import android.view.MotionEvent;

public final class a extends Instrumentation {
    private Instrumentation a;

    public a(Instrumentation instrumentation) {
        this.a = instrumentation;
    }

    @TargetApi(26)
    public final TestLooperManager acquireLooperManager(Looper looper) {
        return this.a.acquireLooperManager(looper);
    }

    public final ActivityMonitor addMonitor(IntentFilter intentFilter, ActivityResult activityResult, boolean z) {
        return this.a.addMonitor(intentFilter, activityResult, z);
    }

    public final ActivityMonitor addMonitor(String str, ActivityResult activityResult, boolean z) {
        return this.a.addMonitor(str, activityResult, z);
    }

    public final void addMonitor(ActivityMonitor activityMonitor) {
        this.a.addMonitor(activityMonitor);
    }

    @TargetApi(26)
    public final void addResults(Bundle bundle) {
        this.a.addResults(bundle);
    }

    public final void callActivityOnCreate(Activity activity, Bundle bundle) {
        this.a.callActivityOnCreate(activity, bundle);
    }

    @TargetApi(21)
    public final void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.a.callActivityOnCreate(activity, bundle, persistableBundle);
    }

    public final void callActivityOnDestroy(Activity activity) {
        this.a.callActivityOnDestroy(activity);
    }

    public final void callActivityOnNewIntent(Activity activity, Intent intent) {
        this.a.callActivityOnNewIntent(activity, intent);
    }

    public final void callActivityOnPause(Activity activity) {
        this.a.callActivityOnPause(activity);
        a.a.b(activity);
    }

    public final void callActivityOnPostCreate(Activity activity, Bundle bundle) {
        this.a.callActivityOnPostCreate(activity, bundle);
    }

    @TargetApi(21)
    public final void callActivityOnPostCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.a.callActivityOnPostCreate(activity, bundle, persistableBundle);
    }

    public final void callActivityOnRestart(Activity activity) {
        this.a.callActivityOnRestart(activity);
    }

    public final void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
        this.a.callActivityOnRestoreInstanceState(activity, bundle);
    }

    @TargetApi(21)
    public final void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.a.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
    }

    public final void callActivityOnResume(Activity activity) {
        this.a.callActivityOnResume(activity);
        a.a.a(activity);
    }

    public final void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
        this.a.callActivityOnSaveInstanceState(activity, bundle);
    }

    @TargetApi(21)
    public final void callActivityOnSaveInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.a.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
    }

    public final void callActivityOnStart(Activity activity) {
        this.a.callActivityOnStart(activity);
    }

    public final void callActivityOnStop(Activity activity) {
        this.a.callActivityOnStop(activity);
    }

    public final void callActivityOnUserLeaving(Activity activity) {
        this.a.callActivityOnUserLeaving(activity);
    }

    public final void callApplicationOnCreate(Application application) {
        this.a.callApplicationOnCreate(application);
    }

    public final boolean checkMonitorHit(ActivityMonitor activityMonitor, int i) {
        return this.a.checkMonitorHit(activityMonitor, i);
    }

    public final void endPerformanceSnapshot() {
        this.a.endPerformanceSnapshot();
    }

    public final void finish(int i, Bundle bundle) {
        this.a.finish(i, bundle);
    }

    public final Bundle getAllocCounts() {
        return this.a.getAllocCounts();
    }

    public final Bundle getBinderCounts() {
        return this.a.getBinderCounts();
    }

    public final ComponentName getComponentName() {
        return this.a.getComponentName();
    }

    public final Context getContext() {
        return this.a.getContext();
    }

    @TargetApi(26)
    public final String getProcessName() {
        return this.a.getProcessName();
    }

    public final Context getTargetContext() {
        return this.a.getTargetContext();
    }

    @TargetApi(18)
    public final UiAutomation getUiAutomation() {
        return this.a.getUiAutomation();
    }

    @TargetApi(24)
    public final UiAutomation getUiAutomation(int i) {
        return this.a.getUiAutomation(i);
    }

    public final boolean invokeContextMenuAction(Activity activity, int i, int i2) {
        return this.a.invokeContextMenuAction(activity, i, i2);
    }

    public final boolean invokeMenuActionSync(Activity activity, int i, int i2) {
        return this.a.invokeMenuActionSync(activity, i, i2);
    }

    public final boolean isProfiling() {
        return this.a.isProfiling();
    }

    public final Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) {
        return this.a.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    public final Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        return this.a.newActivity(classLoader, str, intent);
    }

    public final Application newApplication(ClassLoader classLoader, String str, Context context) {
        return this.a.newApplication(classLoader, str, context);
    }

    public final void onCreate(Bundle bundle) {
        this.a.onCreate(bundle);
    }

    public final void onDestroy() {
        this.a.onDestroy();
    }

    public final boolean onException(Object obj, Throwable th) {
        return this.a.onException(obj, th);
    }

    public final void onStart() {
        this.a.onStart();
    }

    public final void removeMonitor(ActivityMonitor activityMonitor) {
        this.a.removeMonitor(activityMonitor);
    }

    public final void runOnMainSync(Runnable runnable) {
        this.a.runOnMainSync(runnable);
    }

    public final void sendCharacterSync(int i) {
        this.a.sendCharacterSync(i);
    }

    public final void sendKeyDownUpSync(int i) {
        this.a.sendKeyDownUpSync(i);
    }

    public final void sendKeySync(KeyEvent keyEvent) {
        this.a.sendKeySync(keyEvent);
    }

    public final void sendPointerSync(MotionEvent motionEvent) {
        this.a.sendPointerSync(motionEvent);
    }

    public final void sendStatus(int i, Bundle bundle) {
        this.a.sendStatus(i, bundle);
    }

    public final void sendStringSync(String str) {
        this.a.sendStringSync(str);
    }

    public final void sendTrackballEventSync(MotionEvent motionEvent) {
        this.a.sendTrackballEventSync(motionEvent);
    }

    public final void setAutomaticPerformanceSnapshots() {
        this.a.setAutomaticPerformanceSnapshots();
    }

    public final void setInTouchMode(boolean z) {
        this.a.setInTouchMode(z);
    }

    public final void start() {
        this.a.start();
    }

    public final Activity startActivitySync(Intent intent) {
        return this.a.startActivitySync(intent);
    }

    public final void startAllocCounting() {
        this.a.startAllocCounting();
    }

    public final void startPerformanceSnapshot() {
        this.a.startPerformanceSnapshot();
    }

    public final void startProfiling() {
        this.a.startProfiling();
    }

    public final void stopAllocCounting() {
        this.a.stopAllocCounting();
    }

    public final void stopProfiling() {
        this.a.stopProfiling();
    }

    public final void waitForIdle(Runnable runnable) {
        this.a.waitForIdle(runnable);
    }

    public final void waitForIdleSync() {
        this.a.waitForIdleSync();
    }

    public final Activity waitForMonitor(ActivityMonitor activityMonitor) {
        return this.a.waitForMonitor(activityMonitor);
    }

    public final Activity waitForMonitorWithTimeout(ActivityMonitor activityMonitor, long j) {
        return this.a.waitForMonitorWithTimeout(activityMonitor, j);
    }
}
