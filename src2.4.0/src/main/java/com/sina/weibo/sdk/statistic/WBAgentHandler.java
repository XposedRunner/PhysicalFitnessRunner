package com.sina.weibo.sdk.statistic;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

class WBAgentHandler {
    private static int MAX_CACHE_SIZE = 5;
    private static CopyOnWriteArrayList<PageLog> mActivePages;
    private static WBAgentHandler mInstance;
    private static Timer mLogTimer;
    private static Map<String, PageLog> mPages;
    private static Timer mTimer;

    private WBAgentHandler() {
        mActivePages = new CopyOnWriteArrayList();
        mPages = new HashMap();
        LogUtil.i(WBAgent.TAG, "init handler");
    }

    private void checkAppStatus(Context context) {
        if (isBackground(context)) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    private void checkNewSession(Context context, long j) {
        if (PageLog.isNewSession(context, j)) {
            PageLog pageLog = new PageLog(context);
            pageLog.setType(LogType.SESSION_END);
            PageLog pageLog2 = new PageLog(context, j);
            pageLog2.setType(LogType.SESSION_START);
            synchronized (mActivePages) {
                if (pageLog.getEndTime() > 0) {
                    mActivePages.add(pageLog);
                } else {
                    LogUtil.d(WBAgent.TAG, "is a new install");
                }
                mActivePages.add(pageLog2);
            }
            String str = WBAgent.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("last session--- starttime:");
            stringBuilder.append(pageLog.getStartTime());
            stringBuilder.append(" ,endtime:");
            stringBuilder.append(pageLog.getEndTime());
            LogUtil.d(str, stringBuilder.toString());
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("is a new session--- starttime:");
            stringBuilder.append(pageLog2.getStartTime());
            LogUtil.d(str, stringBuilder.toString());
            return;
        }
        LogUtil.i(WBAgent.TAG, "is not a new session");
    }

    private void closeTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public static synchronized WBAgentHandler getInstance() {
        WBAgentHandler wBAgentHandler;
        synchronized (WBAgentHandler.class) {
            if (mInstance == null) {
                mInstance = new WBAgentHandler();
            }
            wBAgentHandler = mInstance;
        }
        return wBAgentHandler;
    }

    private synchronized String getLogsInMemory() {
        String str;
        str = "";
        if (mActivePages.size() > 0) {
            String pageLogs;
            synchronized (mActivePages) {
                pageLogs = LogBuilder.getPageLogs(mActivePages);
                mActivePages.clear();
            }
            str = pageLogs;
        }
        return str;
    }

    private boolean isBackground(Context context) {
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                String str;
                StringBuilder stringBuilder;
                if (runningAppProcessInfo.importance == SecExceptionCode.SEC_ERROR_DYN_ENC) {
                    str = WBAgent.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("后台:");
                    stringBuilder.append(runningAppProcessInfo.processName);
                    LogUtil.i(str, stringBuilder.toString());
                    return true;
                }
                str = WBAgent.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("前台:");
                stringBuilder.append(runningAppProcessInfo.processName);
                LogUtil.i(str, stringBuilder.toString());
                return false;
            }
        }
        return false;
    }

    public static boolean isFirstStartBoolean(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(WBConstants.THIRD_APP_IS_FIRST, 0);
        boolean z = sharedPreferences.getBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, true);
        if (z) {
            Editor edit = sharedPreferences.edit();
            edit.putBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, false);
            edit.commit();
        }
        return z;
    }

    private synchronized void saveActivePages(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        final String pageLogs = LogBuilder.getPageLogs(copyOnWriteArrayList);
        WBAgentExecutor.execute(new Runnable() {
            public void run() {
                LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), pageLogs, true);
            }
        });
    }

    private Timer timerTask(final Context context, long j, long j2) {
        Timer timer = new Timer();
        AnonymousClass3 anonymousClass3 = new TimerTask() {
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        };
        if (j2 == 0) {
            timer.schedule(anonymousClass3, j);
        } else {
            timer.schedule(anonymousClass3, j, j2);
        }
        return timer;
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        EventLog eventLog = new EventLog(str, str2, map);
        eventLog.setType(LogType.EVENT);
        synchronized (mActivePages) {
            mActivePages.add(eventLog);
        }
        if (map == null) {
            String str3 = WBAgent.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event--- page:");
            stringBuilder.append(str);
            stringBuilder.append(" ,event name:");
            stringBuilder.append(str2);
            LogUtil.d(str3, stringBuilder.toString());
        } else {
            String str4 = WBAgent.TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("event--- page:");
            stringBuilder2.append(str);
            stringBuilder2.append(" ,event name:");
            stringBuilder2.append(str2);
            stringBuilder2.append(" ,extend:");
            stringBuilder2.append(map.toString());
            LogUtil.d(str4, stringBuilder2.toString());
        }
        if (mActivePages.size() >= MAX_CACHE_SIZE) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    public void onKillProcess() {
        LogUtil.i(WBAgent.TAG, "save applogs and close timer and shutdown thread executor");
        synchronized (mActivePages) {
            saveActivePages(mActivePages);
        }
        mInstance = null;
        closeTimer();
        WBAgentExecutor.shutDownExecutor();
    }

    public void onPageEnd(String str) {
        if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
            if (mPages.containsKey(str)) {
                PageLog pageLog = (PageLog) mPages.get(str);
                pageLog.setDuration(System.currentTimeMillis() - pageLog.getStartTime());
                synchronized (mActivePages) {
                    mActivePages.add(pageLog);
                }
                synchronized (mPages) {
                    mPages.remove(str);
                }
                String str2 = WBAgent.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(", ");
                stringBuilder.append(pageLog.getStartTime() / 1000);
                stringBuilder.append(", ");
                stringBuilder.append(pageLog.getDuration() / 1000);
                LogUtil.d(str2, stringBuilder.toString());
            } else {
                LogUtil.e(WBAgent.TAG, "please call onPageStart before onPageEnd");
            }
            if (mActivePages.size() >= MAX_CACHE_SIZE) {
                synchronized (mActivePages) {
                    saveActivePages(mActivePages);
                    mActivePages.clear();
                }
            }
        }
    }

    public void onPageStart(String str) {
        if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
            PageLog pageLog = new PageLog(str);
            pageLog.setType(LogType.FRAGMENT);
            synchronized (mPages) {
                mPages.put(str, pageLog);
            }
            String str2 = WBAgent.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(", ");
            stringBuilder.append(pageLog.getStartTime() / 1000);
            LogUtil.d(str2, stringBuilder.toString());
        }
    }

    public void onPause(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        String str = WBAgent.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update last page endtime:");
        stringBuilder.append(currentTimeMillis / 1000);
        LogUtil.i(str, stringBuilder.toString());
        PageLog.updateSession(context, null, Long.valueOf(0), Long.valueOf(currentTimeMillis));
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            if (mPages.containsKey(name)) {
                PageLog pageLog = (PageLog) mPages.get(name);
                pageLog.setDuration(currentTimeMillis - pageLog.getStartTime());
                synchronized (mActivePages) {
                    mActivePages.add(pageLog);
                }
                synchronized (mPages) {
                    mPages.remove(name);
                }
                String str2 = WBAgent.TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(name);
                stringBuilder2.append(", ");
                stringBuilder2.append(pageLog.getStartTime() / 1000);
                stringBuilder2.append(", ");
                stringBuilder2.append(pageLog.getDuration() / 1000);
                LogUtil.d(str2, stringBuilder2.toString());
            } else {
                LogUtil.e(WBAgent.TAG, "please call onResume before onPause");
            }
            if (mActivePages.size() >= MAX_CACHE_SIZE) {
                synchronized (mActivePages) {
                    saveActivePages(mActivePages);
                    mActivePages.clear();
                }
            }
        }
        checkAppStatus(context);
    }

    public void onResume(Context context) {
        if (LogReport.getPackageName() == null) {
            LogReport.setPackageName(context.getPackageName());
        }
        if (mTimer == null) {
            mTimer = timerTask(context, 500, StatisticConfig.getUploadInterval());
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        checkNewSession(context, currentTimeMillis);
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            PageLog pageLog = new PageLog(name, currentTimeMillis);
            pageLog.setType(LogType.ACTIVITY);
            synchronized (mPages) {
                mPages.put(name, pageLog);
            }
        }
        String str = WBAgent.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(", ");
        stringBuilder.append(currentTimeMillis / 1000);
        LogUtil.d(str, stringBuilder.toString());
    }

    public void onStop(Context context) {
        checkAppStatus(context);
    }

    public void registerApptoAd(final Context context, final String str, Map<String, String> map) {
        try {
            final AdEventLog adEventLog = new AdEventLog();
            adEventLog.setType(LogType.APP_AD_START);
            if (isFirstStartBoolean(context)) {
                adEventLog.setmEvent_id("1");
            }
            adEventLog.setmImei(MD5.hexdigest(AidTask.getImei(context)));
            adEventLog.setmStart_time(System.currentTimeMillis());
            adEventLog.setmExtend(map);
            String aid = Utility.getAid(context, str);
            if (TextUtils.isEmpty(aid)) {
                AnonymousClass4 anonymousClass4 = new TimerTask() {
                    public void run() {
                        adEventLog.setmAid(Utility.getAid(context, str));
                        WBAgentHandler.this.uploadAdlog(context, adEventLog);
                    }
                };
                mLogTimer = new Timer();
                mLogTimer.schedule(anonymousClass4, 5000);
                return;
            }
            adEventLog.setmAid(aid);
            uploadAdlog(context, adEventLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadAdlog(final Context context, AdEventLog adEventLog) {
        mActivePages.add(adEventLog);
        WBAgentExecutor.execute(new Runnable() {
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        });
    }

    public void uploadAppLogs(final Context context) {
        long currentTimeMillis = System.currentTimeMillis() - LogReport.getTime(context);
        if (LogReport.getTime(context) <= 0 || currentTimeMillis >= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            WBAgentExecutor.execute(new Runnable() {
                public void run() {
                    LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
                }
            });
            return;
        }
        timerTask(context, StatisticConfig.MIN_UPLOAD_INTERVAL - currentTimeMillis, 0);
    }
}
