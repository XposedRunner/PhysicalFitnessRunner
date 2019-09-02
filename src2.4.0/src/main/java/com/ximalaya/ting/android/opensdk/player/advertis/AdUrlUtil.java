package com.ximalaya.ting.android.opensdk.player.advertis;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import com.ximalaya.ting.android.player.MD5;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Request;

public class AdUrlUtil {
    private static final String FIRST_OPEN_TIME = "ad_first_open_time";
    public static final int NETWORK_TYPE_MOBILE = 0;
    public static final int NETWORK_TYPE_NONE = -1;
    public static final int NETWORK_TYPE_WIFI = 1;
    private static volatile AdUrlUtil mInstance;
    public static String phoneIp;
    private Map<String, String> adFields = new ConcurrentHashMap();
    private Context mContext;
    final Pattern pattern1 = Pattern.compile("\\{\\w*\\}");
    final Pattern pattern2 = Pattern.compile("\\[\\w*\\]");
    final Pattern pattern3 = Pattern.compile("__\\w*__");

    public interface Callback {
        void execute(String str);
    }

    private AdUrlUtil(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            init();
        }
    }

    private String getFirstInTime() {
        SharedPreferencesUtil instance = SharedPreferencesUtil.getInstance(this.mContext);
        String string = instance.getString(FIRST_OPEN_TIME);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        string = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
        instance.saveString(FIRST_OPEN_TIME, string);
        return string;
    }

    public static AdUrlUtil getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AdUrlUtil.class) {
                if (mInstance == null) {
                    mInstance = new AdUrlUtil(context);
                }
            }
        }
        return mInstance;
    }

    private static String getMobileIp() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && isIP(inetAddress.getHostAddress())) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int getNetType(Context context) {
        if (context == null) {
            return -1;
        }
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused2) {
            activeNetworkInfo = null;
        }
        return (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) ? -1 : activeNetworkInfo.getType() == 1 ? 1 : 0;
    }

    public static String getPhoneIP(Context context) {
        if (!TextUtils.isEmpty(phoneIp)) {
            return phoneIp;
        }
        int netType = getNetType(context);
        if (netType == 0) {
            phoneIp = getMobileIp();
        } else if (netType == 1) {
            phoneIp = getWifiIp(context);
        }
        return TextUtils.isEmpty(phoneIp) ? "192.168.1.1" : phoneIp;
    }

    private static String getWifiIp(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        WifiInfo connectionInfo;
        try {
            connectionInfo = wifiManager.getConnectionInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            connectionInfo = null;
        }
        return connectionInfo == null ? "" : intToIp(connectionInfo.getIpAddress());
    }

    private void initShowTime() {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date(currentTimeMillis));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(currentTimeMillis);
        this.adFields.put("TS", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(currentTimeMillis);
        this.adFields.put("timestamp", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(currentTimeMillis);
        this.adFields.put("clicktime", stringBuilder.toString());
        this.adFields.put("CLICKTIME", format);
        this.adFields.put("IP", getPhoneIP(this.mContext));
    }

    private static String intToIp(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 8) & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 16) & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 24) & 255);
        return stringBuilder.toString();
    }

    private static boolean isIP(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 7 || str.length() > 15) ? false : Pattern.compile("^((\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5]))$").matcher(str).find();
    }

    private String replaceParameter(String str, Pattern pattern, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null) {
                if (group.length() > i && i < group.length() - i) {
                    String toUpperCase = group.substring(i, group.length() - i).toUpperCase();
                    String str2 = (String) this.adFields.get(toUpperCase);
                    if (!TextUtils.isEmpty(str2)) {
                        group = str2;
                    } else if ("IMEI".equals(toUpperCase)) {
                        group = "";
                    }
                }
                matcher.appendReplacement(stringBuffer, group);
            }
        }
        return matcher.appendTail(stringBuffer).toString();
    }

    public String changeParams(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return str;
            }
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.size() <= 0) {
                str = replaceRequestStr(str, false, false);
                return str;
            }
            Builder buildUpon = Uri.parse(replaceRequestStr(parse.buildUpon().clearQuery().build().toString(), false, false)).buildUpon();
            for (String str2 : queryParameterNames) {
                buildUpon.appendQueryParameter(str2, replaceRequestStr(parse.getQueryParameter(str2), false, false));
            }
            str = buildUpon.build().toString();
            return str;
        } catch (Exception e) {
            Logger.e(e);
            str = null;
        }
    }

    public String getApplicationName() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = this.mContext.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(this.mContext.getPackageName(), 0);
            } catch (NameNotFoundException unused) {
            }
        } catch (NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public void init() {
        this.adFields.put("OS", "0");
        if (this.mContext != null) {
            try {
                this.adFields.put("IMEI", MD5.md5(OpenSdkUtils.getIMEIAndNotDefual(this.mContext)));
            } catch (Exception e) {
                this.adFields.put("IMEI", "");
                e.printStackTrace();
            }
            String str = null;
            try {
                str = OpenSdkUtils.getLocalMacAddress(this.mContext);
            } catch (XimalayaException e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                this.adFields.put("MAC1", MD5.md5(str));
                this.adFields.put("MAC", MD5.md5(str.replaceAll(":", "")));
            }
            this.adFields.put("ANDROIDID", MD5.md5(OpenSdkUtils.getAndroidId(this.mContext)));
            this.adFields.put("ANDROIDID1", OpenSdkUtils.getAndroidId(this.mContext));
            try {
                CommonRequest.getInstanse();
                this.adFields.put("UA", CommonRequest.getUserAgent());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.adFields.put("OSVS", CommonRequest.getInstanse().getSdkVersion());
            this.adFields.put("TERM", Build.MODEL);
            this.adFields.put("APPID", "0");
            try {
                str = URLEncoder.encode(getApplicationName(), "UTF-8");
                this.adFields.put("APPNAME", str);
                this.adFields.put("APP", str);
                this.adFields.put("ANAME", str);
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
            this.adFields.put("FIRSTOPENTIME", getFirstInTime());
        }
    }

    public String replaceRequestStr(String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z) {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        str = replaceParameter(replaceParameter(replaceParameter(str, this.pattern1, 1), this.pattern2, 1), this.pattern3, 2).replace(" ", "");
        if (z2) {
            try {
                str = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
        return str;
    }

    public void thirdAdStatRequest(String str) {
        if (!TextUtils.isEmpty(str)) {
            initShowTime();
            BaseCall.getInstanse().doAsync(new Request.Builder().url(replaceRequestStr(str, false, false)).build(), null);
        }
    }
}
