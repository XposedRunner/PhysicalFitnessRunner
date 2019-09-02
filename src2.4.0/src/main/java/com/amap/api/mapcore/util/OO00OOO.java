package com.amap.api.mapcore.util;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: CustomStyleRequest */
public class OO00OOO extends o0O00O0o<String, O000000o> {
    private String O00000oO;
    private boolean O00000oo;

    /* compiled from: CustomStyleRequest */
    public static class O000000o {
        public byte[] O000000o;
        public int O00000Oo = -1;
    }

    public OO00OOO(Context context, String str) {
        super(context, str);
        this.O00000oo = false;
        this.O00000o = "/map/styles";
    }

    public OO00OOO(Context context, String str, boolean z) {
        super(context, str);
        this.O00000oo = false;
        this.O00000oo = z;
        if (z) {
            this.O00000o = "/sdk/map/styles";
            this.isPostFlag = false;
            return;
        }
        this.O00000o = "/map/styles";
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public O000000o O00000o0(String str) throws o0OoO00O {
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public O000000o O00000Oo(byte[] bArr) throws o0OoO00O {
        O000000o o000000o = new O000000o();
        o000000o.O000000o = bArr;
        if (this.O00000oo && bArr != null) {
            if (bArr.length == 0) {
                o000000o.O000000o = null;
            } else if (o000000o.O000000o.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        o000000o.O000000o = null;
                    }
                } catch (Exception e) {
                    ooOOOOoo.O00000o0(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return o000000o;
    }

    public void O00000Oo(String str) {
        this.O00000oO = str;
    }

    public Map<String, String> getParams() {
        Map hashtable = new Hashtable(16);
        hashtable.put("key", o0O0O0Oo.O00000oo(this.O00000o0));
        if (!this.O00000oo) {
            hashtable.put("output", "bin");
        }
        hashtable.put("styleid", this.O00000oO);
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
