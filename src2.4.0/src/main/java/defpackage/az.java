package defpackage;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: SessionIdGenerateServiceImpl */
/* renamed from: az */
class az implements ay {
    private long O000000o = u.O0000OOo;

    az() {
    }

    public long O000000o() {
        return this.O000000o;
    }

    public String O000000o(Context context) {
        String deviceId = DeviceConfig.getDeviceId(context);
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            throw new RuntimeException("Appkey is null or empty, Please check!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append(appkey);
        stringBuilder.append(deviceId);
        return UMUtils.MD5(stringBuilder.toString());
    }

    public void O000000o(long j) {
        this.O000000o = j;
    }

    public void O000000o(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(aw.O00000o0, str);
            edit.putLong(aw.O00000Oo, 0);
            edit.putLong(aw.O00000oO, currentTimeMillis);
            edit.putLong(aw.O00000oo, 0);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public boolean O000000o(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j == 0 || currentTimeMillis - j >= this.O000000o) && j2 > 0 && currentTimeMillis - j2 > this.O000000o;
    }
}
