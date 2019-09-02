package com.umeng.socialize.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.dplus.cache.O00000o;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import defpackage.ce;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONObject;

/* compiled from: SocializeUtils */
public class O0000Oo0 {
    protected static final String O000000o = "SocializeUtils";
    public static Set<Uri> O00000Oo = new HashSet();
    private static Pattern O00000o;
    private static final char[] O00000o0 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static int O00000oO;

    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Bundle O000000o(String str) {
        try {
            URL url = new URL(str);
            Bundle O00000Oo = O00000Oo(url.getQuery());
            O00000Oo.putAll(O00000Oo(url.getRef()));
            return O00000Oo;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static Bundle O000000o(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, (String) map.get(str));
        }
        return bundle;
    }

    public static String O000000o(Context context) {
        if (context == null) {
            return "";
        }
        String str = ce.O0000o0;
        if (TextUtils.isEmpty(str)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    Object obj = applicationInfo.metaData.get("UMENG_APPKEY");
                    if (obj != null) {
                        str = obj.toString();
                    }
                }
            } catch (Exception e) {
                O0000O0o.O000000o(e);
            }
        }
        return str;
    }

    public static Map<String, String> O000000o(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return null;
        }
        Set<String> keySet = bundle.keySet();
        HashMap hashMap = new HashMap();
        for (String str : keySet) {
            if (str.equals("com.sina.weibo.intent.extra.USER_ICON")) {
                hashMap.put("icon_url", bundle.getString(str));
            }
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public static void O000000o(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Exception e) {
                O0000O0o.O000000o(e);
            }
        }
    }

    public static void O000000o(Context context, String str) throws Exception {
        if (Config.isJumptoAppStore) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("market://details?id=");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        }
    }

    public static boolean O000000o() {
        File O000000o = O00000o.O000000o("s_e");
        File O000000o2 = O00000o.O000000o("auth");
        File O000000o3 = O00000o.O000000o("userinfo");
        File O000000o4 = O00000o.O000000o("dau");
        File O000000o5 = O00000o.O000000o("stats");
        return ((O000000o == null || O000000o.listFiles() == null || O000000o.listFiles().length <= 0) && ((O000000o2 == null || O000000o2.listFiles() == null || O000000o2.listFiles().length <= 0) && ((O000000o3 == null || O000000o3.listFiles() == null || O000000o3.listFiles().length <= 0) && ((O000000o4 == null || O000000o4.listFiles() == null || O000000o4.listFiles().length <= 0) && (O000000o5 == null || O000000o5.listFiles() == null || O000000o5.listFiles().length <= 0))))) ? false : true;
    }

    public static boolean O000000o(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(System.currentTimeMillis()));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date(j));
        return instance2.get(1) == instance.get(1) && instance2.get(6) - instance.get(6) == 0;
    }

    public static boolean O000000o(byte[] bArr) {
        return bArr != null && bArr.length > 0;
    }

    public static byte[] O000000o(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e) {
            O0000O0o.O000000o(e);
            return null;
        } catch (IOException e2) {
            O0000O0o.O000000o(e2);
            return null;
        }
    }

    public static Uri O00000Oo(Context context, String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        try {
            String insertImage = Media.insertImage(context.getContentResolver(), str, "umeng_social_shareimg", null);
            return TextUtils.isEmpty(insertImage) ? null : Uri.parse(insertImage);
        } catch (Throwable th) {
            O0000O0o.O000000o(th);
            return null;
        }
    }

    public static Bundle O00000Oo(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }

    public static String O00000Oo(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            bArr = instance.digest();
            char[] cArr = new char[32];
            int i = 0;
            int i2 = 0;
            while (i < 16) {
                byte b = bArr[i];
                int i3 = i2 + 1;
                cArr[i2] = O00000o0[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = O00000o0[b & 15];
                i++;
            }
            return new String(cArr);
        } catch (Exception e) {
            O0000O0o.O000000o(e);
            return null;
        }
    }

    private static Pattern O00000Oo() {
        if (O00000o == null) {
            O00000o = Pattern.compile("[^\\x00-\\xff]");
        }
        return O00000o;
    }

    public static void O00000Oo(Dialog dialog) {
        if (dialog != null) {
            try {
                if (!dialog.isShowing()) {
                    dialog.show();
                }
            } catch (Exception e) {
                O0000O0o.O000000o(e);
            }
        }
    }

    public static int[] O00000Oo(Context context) {
        return context == null ? new int[2] : new int[]{580, 350};
    }

    public static Map<String, String> O00000o(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.get(str2));
                stringBuilder.append("");
                hashMap.put(str2, stringBuilder.toString());
            }
        } catch (Exception e) {
            O0000O0o.O000000o(e);
        }
        return hashMap;
    }

    public static int O00000o0(String str) {
        str = str.trim();
        int i = 0;
        while (O00000Oo().matcher(str).find()) {
            i++;
        }
        int length = str.length() - i;
        return length % 2 != 0 ? i + ((length + 1) / 2) : i + (length / 2);
    }

    public static boolean O00000o0(Context context) {
        if (context != null && ce.O00000oo) {
            if (O00000oO == 0) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                if (width <= height) {
                    height = width;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                O00000oO = (int) ((((float) height) / displayMetrics.density) + 0.5f);
            }
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3 && O00000oO >= 550) {
                return true;
            }
        }
        return false;
    }

    public static String O00000oO(String str) {
        try {
            return O00000Oo(str.getBytes());
        } catch (Exception e) {
            O0000O0o.O000000o(e);
            return null;
        }
    }
}
