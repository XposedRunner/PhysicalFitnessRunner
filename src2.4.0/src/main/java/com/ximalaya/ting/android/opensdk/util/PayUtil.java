package com.ximalaya.ting.android.opensdk.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.httputil.util.Util;
import com.ximalaya.ting.android.opensdk.model.pay.ObfuscatePlayInfo;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.ximalaya.ting.android.xmpayordersdk.O000000o;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class PayUtil {
    private static final char[] hexString = "0123456789abcdef".toCharArray();
    private static String key0;
    private static String key1;
    private static String name1;

    private static String getAntiLeechUrl(Map<String, String> map) {
        if (map != null) {
            String str = (String) map.remove(DTransferConstants.FILE_ID);
            String str2 = (String) map.remove(DTransferConstants.EP);
            String str3 = (String) map.remove(DTransferConstants.SAMPLE_LENGTH);
            str3 = (String) map.remove("duration");
            String str4 = (String) map.remove(DTransferConstants.API_VERSION);
            if (TextUtils.isEmpty(str)) {
                Logger.log("getAntiLeechUrl specificParams fileId is null");
                return null;
            }
            byte[] decryptByKey2;
            try {
                decryptByKey2 = EncryptUtilForSDK.getInstance().decryptByKey2(Base64.decode(str, 0));
            } catch (Exception e) {
                e.printStackTrace();
                decryptByKey2 = null;
            }
            if (decryptByKey2 == null) {
                return null;
            }
            String trim;
            String str5 = "";
            try {
                trim = new String(decryptByKey2, "UTF-8").trim();
            } catch (UnsupportedEncodingException unused) {
                if (TextUtils.isEmpty(str)) {
                    Logger.log("getAntiLeechUrl specificParams fileId decode fail");
                    return null;
                }
                trim = str5;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("encryptStr xxx result:");
            stringBuilder.append(trim);
            Logger.log(stringBuilder.toString());
            if (TextUtils.isEmpty(str2)) {
                Logger.log("getAntiLeechUrl specificParams no ep");
                return null;
            }
            str = EncryptUtilForSDK.getInstance().decryptRc4ByPublicKey(str2);
            if (TextUtils.isEmpty(str)) {
                Logger.log("getAntiLeechUrl specificParams ep decode fail");
                return null;
            }
            str = str.trim();
            if (TextUtils.isEmpty(str)) {
                Logger.log("getAntiLeechUrl specificParams ep decode fail");
                return null;
            }
            String[] split = str.split("-");
            if (split.length != 4) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("getAntiLeechUrl specificParams ep decode fail length error deEp:");
                stringBuilder2.append(str);
                Logger.log(stringBuilder2.toString());
                return null;
            }
            StringBuilder stringBuilder3 = new StringBuilder("http://");
            map.clear();
            stringBuilder3.append("audio");
            map.put("sign", split[1]);
            stringBuilder3.append(".pay.");
            map.put("buy_key", split[0]);
            stringBuilder3.append("xmcdn.com/");
            map.put("token", split[2]);
            stringBuilder3.append("download/");
            map.put("timestamp", split[3]);
            map.put("duration", str3);
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder3.toString());
            stringBuilder.append(str4);
            stringBuilder.append("/");
            stringBuilder.append(trim);
            String stringBuilder4 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder4);
            stringBuilder.append("?");
            stringBuilder.append(Util.ConvertMap2HttpParams(Util.encoderName(map)));
            String stringBuilder5 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("encryptStr url:");
            stringBuilder3.append(stringBuilder5);
            Logger.log(stringBuilder3.toString());
            return stringBuilder5;
        } else if (ConstantsOpenSdk.isDebug) {
            throw new RuntimeException("getAntiLeechUrl specificParams == null(getAntiLeechUrl func)");
        } else {
            Logger.log("getAntiLeechUrl specificParams == null(getAntiLeechUrl func)");
            return null;
        }
    }

    public static String getKey0() {
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(key0)) {
            String name1 = getName1();
            if (name1 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(name1.substring(0, name1.length() / 2));
                stringBuilder.append("0");
                key0 = stringBuilder.toString();
            }
        }
        PrintStream printStream = System.out;
        stringBuilder = new StringBuilder();
        stringBuilder.append("PayUtil.getKey0   ");
        stringBuilder.append(key0);
        printStream.println(stringBuilder.toString());
        return key0;
    }

    public static String getKey1() {
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(key1)) {
            String name1 = getName1();
            if (name1 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(name1.substring(name1.length() / 2));
                stringBuilder.append(ClientOSType.IOS);
                key1 = stringBuilder.toString();
            }
        }
        PrintStream printStream = System.out;
        stringBuilder = new StringBuilder();
        stringBuilder.append("PayUtil.getKey1   ");
        stringBuilder.append(key1);
        printStream.println(stringBuilder.toString());
        return key1;
    }

    public static String getName1() {
        if (TextUtils.isEmpty(name1)) {
            String appsecret = CommonRequest.getInstanse().getAppsecret();
            if (!TextUtils.isEmpty(appsecret)) {
                StringBuilder stringBuilder = new StringBuilder();
                char[] toCharArray = appsecret.toCharArray();
                for (int i = 0; i < toCharArray.length / 2; i++) {
                    stringBuilder.append(hexString[((char) (toCharArray[i] ^ toCharArray[(toCharArray.length - 1) - i])) % 16]);
                }
                name1 = stringBuilder.toString();
            }
        }
        return name1;
    }

    public static String getPageId(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("pack_id");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static StringBuilder getUrl(ObfuscatePlayInfo obfuscatePlayInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTransferConstants.FILE_ID, obfuscatePlayInfo.getFileId());
        hashMap.put(DTransferConstants.EP, obfuscatePlayInfo.getEp());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obfuscatePlayInfo.getDuration());
        stringBuilder.append("");
        hashMap.put("duration", stringBuilder.toString());
        hashMap.put(DTransferConstants.API_VERSION, obfuscatePlayInfo.getApiVersion());
        String antiLeechUrl = getAntiLeechUrl(hashMap);
        if (TextUtils.isEmpty(antiLeechUrl)) {
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder(antiLeechUrl);
        if (!TextUtils.isEmpty(antiLeechUrl) && obfuscatePlayInfo.getTotalLength() > 0 && antiLeechUrl.contains("preview")) {
            stringBuilder2.append("&totalLength=");
            stringBuilder2.append(obfuscatePlayInfo.getTotalLength());
        }
        stringBuilder2.append("&");
        stringBuilder2.append(XMediaPlayerConstants.IS_CHARGE);
        stringBuilder2.append("=true");
        return stringBuilder2;
    }

    public static void updateTrackInfo(Map<String, String> map, final IDataCallBack<String> iDataCallBack, Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(track.getDataId());
        stringBuilder.append("");
        map.put("track_id", stringBuilder.toString());
        map.put("device", "android");
        CommonRequest.getObfuscatedPlayInfo(map, new IDataCallBack<ObfuscatePlayInfo>() {
            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }

            public void onSuccess(ObfuscatePlayInfo obfuscatePlayInfo) {
                if (obfuscatePlayInfo == null) {
                    onError(O000000o.O0000Ooo, "updateTrackForPlay return result be null");
                    return;
                }
                StringBuilder access$000 = PayUtil.getUrl(obfuscatePlayInfo);
                if (access$000 == null) {
                    onError(O000000o.O0000Ooo, "updateTrackForPlay return result be null");
                } else {
                    iDataCallBack.onSuccess(access$000.toString());
                }
            }
        });
    }

    public static String updateTrackInfoSync(long j) {
        HashMap hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("");
        hashMap.put("track_id", stringBuilder.toString());
        hashMap.put("device", "android");
        return getUrl(CommonRequest.getObfuscatedPlayInfoSync(hashMap)).toString();
    }
}
