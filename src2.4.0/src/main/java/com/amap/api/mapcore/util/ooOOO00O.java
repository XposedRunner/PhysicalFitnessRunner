package com.amap.api.mapcore.util;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AuthRequest */
public class ooOOO00O extends o0O00O0o<String, O000000o> {
    private int[] O00000oO;

    /* compiled from: AuthRequest */
    public static class O000000o {
        public int O000000o = -1;
        public String O00000Oo;
        public boolean O00000o = false;
        public String O00000o0;
    }

    public ooOOO00O(Context context, String str) {
        super(context, str);
        this.O00000oO = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        this.O00000o = "/feedback";
        this.isPostFlag = false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public O000000o O00000o0(String str) throws o0OoO00O {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = -1;
            String str2 = "";
            String str3 = "";
            if (jSONObject.has("errcode")) {
                i = jSONObject.optInt("errcode");
                str2 = jSONObject.optString("errmsg");
                str3 = jSONObject.optString("errdetail");
            }
            O000000o o000000o = new O000000o();
            o000000o.O000000o = i;
            o000000o.O00000Oo = str2;
            o000000o.O00000o0 = str3;
            int i2 = 0;
            o000000o.O00000o = false;
            int[] iArr = this.O00000oO;
            int length = iArr.length;
            while (i2 < length) {
                if (iArr[i2] == i) {
                    o000000o.O00000o = true;
                    break;
                }
                i2++;
            }
            return o000000o;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Map<String, String> getParams() {
        Map hashtable = new Hashtable(16);
        hashtable.put("key", o0O0O0Oo.O00000oo(this.O00000o0));
        hashtable.put("pname", "3dmap");
        String O000000o = o0O0OOOo.O000000o();
        String O000000o2 = o0O0OOOo.O000000o(this.O00000o0, O000000o, o0OOOO00.O00000o0(hashtable));
        hashtable.put(DeviceInfo.TAG_TIMESTAMPS, O000000o);
        hashtable.put("scode", O000000o2);
        return hashtable;
    }

    public Map<String, String> getRequestHead() {
        o0OO0o00 O00000oO = OOo000.O00000oO();
        String O00000Oo = O00000oO != null ? O00000oO.O00000Oo() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", bu.O00000o0);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{O00000Oo, "3dmap"}));
        hashtable.put("x-INFO", o0O0OOOo.O000000o(this.O00000o0));
        hashtable.put("key", o0O0O0Oo.O00000oo(this.O00000o0));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    public String getURL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://restapi.amap.com/v4");
        stringBuilder.append(this.O00000o);
        return stringBuilder.toString();
    }
}
