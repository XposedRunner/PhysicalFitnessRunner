package com.amap.api.mapcore.util;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: CustomStyleTextureRequest */
public class OO00o00 extends o0O00O0o<String, O000000o> {

    /* compiled from: CustomStyleTextureRequest */
    public static class O000000o {
        public byte[] O000000o;
        public int O00000Oo = -1;
    }

    public OO00o00(Context context, String str) {
        super(context, str);
        this.O00000o = "/map/styles";
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public O000000o O00000Oo(byte[] bArr) throws o0OoO00O {
        O000000o o000000o = new O000000o();
        o000000o.O000000o = bArr;
        return o000000o;
    }

    public void O000000o(String str) {
        this.O00000o = str;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O00000Oo */
    public O000000o O00000o0(String str) throws o0OoO00O {
        return null;
    }

    public Map<String, String> getParams() {
        Map hashMap = new HashMap(16);
        hashMap.put("key", o0O0O0Oo.O00000oo(this.O00000o0));
        hashMap.put("output", "bin");
        String O000000o = o0O0OOOo.O000000o();
        String O000000o2 = o0O0OOOo.O000000o(this.O00000o0, O000000o, o0OOOO00.O00000o0(hashMap));
        hashMap.put(DeviceInfo.TAG_TIMESTAMPS, O000000o);
        hashMap.put("scode", O000000o2);
        return hashMap;
    }

    public Map<String, String> getRequestHead() {
        o0OO0o00 O00000oO = OOo000.O00000oO();
        String O00000Oo = O00000oO != null ? O00000oO.O00000Oo() : null;
        HashMap hashMap = new HashMap(16);
        hashMap.put("User-Agent", bu.O00000o0);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{O00000Oo, "3dmap"}));
        hashMap.put("x-INFO", o0O0OOOo.O000000o(this.O00000o0));
        hashMap.put("key", o0O0O0Oo.O00000oo(this.O00000o0));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public String getURL() {
        return this.O00000o;
    }
}
