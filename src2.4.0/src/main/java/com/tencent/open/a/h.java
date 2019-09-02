package com.tencent.open.a;

import android.text.format.Time;
import android.util.Log;

/* compiled from: ProGuard */
public final class h {
    public static final h a = new h();

    public final String a(int i) {
        if (i == 4) {
            return "I";
        }
        if (i == 8) {
            return "W";
        }
        if (i == 16) {
            return "E";
        }
        if (i == 32) {
            return "A";
        }
        switch (i) {
            case 1:
                return "V";
            case 2:
                return "D";
            default:
                return "-";
        }
    }

    public String a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(i));
        stringBuilder.append('/');
        stringBuilder.append(time.format("%Y-%m-%d %H:%M:%S"));
        stringBuilder.append('.');
        if (j2 < 10) {
            stringBuilder.append("00");
        } else if (j2 < 100) {
            stringBuilder.append('0');
        }
        stringBuilder.append(j2);
        stringBuilder.append(' ');
        stringBuilder.append('[');
        if (thread == null) {
            stringBuilder.append("N/A");
        } else {
            stringBuilder.append(thread.getName());
        }
        stringBuilder.append(']');
        stringBuilder.append('[');
        stringBuilder.append(str);
        stringBuilder.append(']');
        stringBuilder.append(' ');
        stringBuilder.append(str2);
        stringBuilder.append(10);
        if (th != null) {
            stringBuilder.append("* Exception : \n");
            stringBuilder.append(Log.getStackTraceString(th));
            stringBuilder.append(10);
        }
        return stringBuilder.toString();
    }
}
