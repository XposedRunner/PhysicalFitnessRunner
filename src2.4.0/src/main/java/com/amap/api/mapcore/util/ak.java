package com.amap.api.mapcore.util;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JavaCrashInfoDelegate */
public final class ak {

    /* compiled from: JavaCrashInfoDelegate */
    static class O000000o {
        private String O000000o;
        private String O00000Oo;

        public O000000o(String str, String str2) {
            this.O000000o = str;
            this.O00000Oo = str2;
        }

        public static String O000000o(List<O000000o> list) {
            StringBuffer stringBuffer = new StringBuffer();
            for (O000000o o000000o : list) {
                StringBuilder stringBuilder = new StringBuilder("^");
                stringBuilder.append(o000000o.O000000o);
                stringBuffer.append(stringBuilder.toString());
                stringBuilder = new StringBuilder("^");
                stringBuilder.append(o000000o.O00000Oo);
                stringBuffer.append(stringBuilder.toString());
                stringBuffer.append(HttpUtils.URL_AND_PARA_SEPARATOR);
            }
            return stringBuffer.toString();
        }
    }

    public static String O000000o(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(thread.getId());
        stringBuilder.append(" , ");
        stringBuilder.append(thread.getName());
        stringBuilder.append(" , ");
        stringBuilder.append(thread.getThreadGroup());
        stringBuilder.append(" , ");
        stringBuilder.append(thread.getState());
        return stringBuilder.toString();
    }

    private static String O000000o(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Object append : stackTraceElementArr) {
            stringBuffer.append(append);
            stringBuffer.append("#");
        }
        return stringBuffer.toString();
    }

    public final void O000000o(o0OO0o00 o0oo0o00) {
        ArrayList arrayList = new ArrayList();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            String O000000o = O000000o(thread);
            if (!TextUtils.isEmpty(O000000o)) {
                String O000000o2 = O000000o(thread.getStackTrace());
                if (!TextUtils.isEmpty(O000000o2)) {
                    arrayList.add(new O000000o(O000000o, O000000o2));
                }
            }
        }
        String O000000o3 = O000000o.O000000o(arrayList);
        if (!TextUtils.isEmpty(O000000o3)) {
            ooOOOOoo.O00000Oo(o0oo0o00, O000000o3, "SO_CRASH_CLS_NAME", "SO_CRASH_MHD_NAME");
        }
    }
}
