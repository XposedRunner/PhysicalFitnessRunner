package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.text.TextUtils;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: DateUtils */
public class O000O0o0 {
    public static final String O000000o = "MM月dd日";
    public static final String O00000Oo = "MM.dd";
    public static final String O00000o = "EEEE";
    public static final String O00000o0 = "MM月dd日 EEEE";
    public static final String O00000oO = "EEEE HH:mm";
    public static final String O00000oo = "MM.dd HH:mm";
    public static final String O0000O0o = "HH:mm:ss";
    public static final String O0000OOo = "HH:mm";
    public static final String O0000Oo = "yyyyMMdd";
    public static final String O0000Oo0 = "mm:ss";
    public static final String O0000OoO = "yyyy.MM.dd";
    public static final String O0000Ooo = "yyyy-MM-dd";
    public static final String O0000o0 = "yyyy-MM-dd HH:mm:ss";
    public static final String O0000o00 = "yyyy.MM.dd HH:mm";

    public static String O000000o(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        long j2 = j / 3600;
        j %= 3600;
        long j3 = j / 60;
        j %= 60;
        if (j2 > 0) {
            stringBuilder.append(O00000Oo(j2));
            stringBuilder.append("小时");
        }
        stringBuilder.append(j3);
        stringBuilder.append("分");
        stringBuilder.append(j);
        stringBuilder.append("秒");
        return stringBuilder.toString();
    }

    public static String O000000o(Context context, long j) {
        if (j == 0) {
            return "";
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - j) / 1000);
        if (currentTimeMillis < 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 60) {
            if (currentTimeMillis / 60 > 15) {
                return "";
            }
            return context.getString(R.string.before_min, new Object[]{Integer.valueOf(currentTimeMillis / 60)});
        } else if (currentTimeMillis < 30) {
            return "刚刚";
        } else {
            return context.getString(R.string.before_second, new Object[]{Integer.valueOf(currentTimeMillis)});
        }
    }

    public static String O000000o(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Date O000000o = O000000o(O0000o0, str);
            int currentTimeMillis = (int) (((System.currentTimeMillis() - O000000o.getTime()) / 1000) / 60);
            if (currentTimeMillis <= 1) {
                return context.getString(R.string.just_now);
            }
            if (currentTimeMillis > 15) {
                return O000000o(O0000OOo, O000000o);
            }
            return context.getString(R.string.before_min, new Object[]{Integer.valueOf(currentTimeMillis)});
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String O000000o(String str, long j) {
        return j <= 0 ? "" : O000000o(str).format(Long.valueOf(j));
    }

    public static String O000000o(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return "";
        }
        try {
            return O000000o(str2, O000000o(str, str3));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String O000000o(String str, Date date) {
        return date == null ? "" : O000000o(str).format(date);
    }

    public static SimpleDateFormat O000000o(String str) {
        return new SimpleDateFormat(str, Locale.CHINA);
    }

    public static Date O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return O000000o(str).parse(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long O00000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        try {
            return O000000o(str).parse(str2).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String O00000Oo(long j) {
        String valueOf = String.valueOf(j);
        if (j >= 10) {
            return valueOf;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }

    public static String O00000Oo(String str) {
        return O000000o(str).format(new Date());
    }

    public static String O00000o(long j) {
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        SimpleDateFormat O000000o = O000000o(O0000OoO);
        int i = instance.get(6);
        int i2 = instance2.get(6);
        int i3 = 1;
        int i4 = ((Math.abs(i - i2) > 7 || i2 <= (instance.get(6) - instance.get(7)) + 1) && instance.get(7) != 1) ? 0 : 1;
        if (instance.get(1) != instance2.get(1)) {
            i3 = 0;
        }
        String format = O000000o.format(instance.getTime());
        instance.add(5, -1);
        String format2 = O000000o.format(instance.getTime());
        String format3 = O000000o.format(date);
        return format.equals(format3) ? O000000o(O0000OOo, date) : format2.equals(format3) ? "昨天" : i4 != 0 ? O000000o(O00000o, date) : i3 != 0 ? O000000o(O00000Oo, date) : O000000o.format(date);
    }

    public static int O00000o0(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.substring(0, 17));
            stringBuilder.append("00");
            return (int) ((System.currentTimeMillis() - O00000Oo(O0000o0, stringBuilder.toString())) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String O00000o0(long j) {
        Date date = new Date(j);
        String str = "刚刚";
        String str2 = "分钟前";
        String str3 = "小时前";
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat O000000o = O000000o(O0000OoO);
        SimpleDateFormat O000000o2 = O000000o(O0000o00);
        if (!O000000o.format(instance.getTime()).equals(O000000o.format(date))) {
            return O000000o2.format(date);
        }
        int timeInMillis = (int) ((instance.getTimeInMillis() - date.getTime()) / O000000o.O00000oo);
        StringBuilder stringBuilder;
        if (timeInMillis == 0) {
            long timeInMillis2 = (instance.getTimeInMillis() - date.getTime()) / O000000o.O00000o;
            if (timeInMillis2 < 1) {
                return str;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(timeInMillis2);
            stringBuilder.append(str2);
            return stringBuilder.toString();
        } else if (timeInMillis >= 3) {
            return O000000o2.format(date);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(timeInMillis);
            stringBuilder.append(str3);
            return stringBuilder.toString();
        }
    }

    public static String O00000oO(long j) {
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        SimpleDateFormat O000000o = O000000o(O0000OoO);
        String format = O000000o.format(instance.getTime());
        String format2 = O000000o.format(date);
        int i = instance.get(6);
        int i2 = instance2.get(6);
        int i3 = 1;
        int i4 = (instance.get(6) - instance.get(7)) + 1;
        if ((Math.abs(i - i2) > 7 || i2 <= i4) && instance.get(7) != 1) {
            i3 = 0;
        }
        return format.equals(format2) ? O000000o(O0000OOo, date) : i3 != 0 ? O000000o(O00000oO, date) : O000000o(O0000o00, date);
    }
}
