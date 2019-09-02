package com.amap.api.mapcore.util;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.MapConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* compiled from: BaseTileProvider */
public class OO0o00 implements TileProvider {
    Random O000000o = new Random();
    private final int O00000Oo;
    private MapConfig O00000o;
    private final int O00000o0;

    /* compiled from: BaseTileProvider */
    class O000000o extends OO0OOo0 {
        private int O00000Oo;
        private int O00000o;
        private int O00000o0;
        private String O00000oO;
        private String O00000oo = "";

        public O000000o(int i, int i2, int i3, String str) {
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = i3;
            this.O00000oO = str;
            this.O00000oo = O00000Oo();
            setProxy(o0OO0OO0.O000000o(cf.O000000o));
            setConnectionTimeout(5000);
            setSoTimeout(50000);
        }

        private String O000000o() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(o0O0O0Oo.O00000oo(cf.O000000o));
            stringBuffer.append("&channel=amapapi");
            if (OOOO0O.O000000o(this.O00000Oo, this.O00000o0, this.O00000o) || this.O00000o < 7) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.O00000o);
                stringBuffer.append("&x=");
                stringBuffer.append(this.O00000Oo);
                stringBuffer.append("&y=");
                stringBuffer.append(this.O00000o0);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            } else if (MapsInitializer.isLoadWorldGridMap()) {
                stringBuffer.append("&x=");
                stringBuffer.append(this.O00000Oo);
                stringBuffer.append("&y=");
                stringBuffer.append(this.O00000o0);
                stringBuffer.append("&z=");
                stringBuffer.append(this.O00000o);
                stringBuffer.append("&ds=0");
                stringBuffer.append("&dpitype=webrd");
                stringBuffer.append("&lang=");
                stringBuffer.append(this.O00000oO);
                stringBuffer.append("&scale=2");
            }
            String stringBuffer2 = stringBuffer.toString();
            String O000000o = O000000o(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            stringBuffer2 = o0O0OOOo.O000000o();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("&ts=");
            stringBuilder.append(stringBuffer2);
            stringBuffer3.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("&scode=");
            stringBuilder.append(o0O0OOOo.O000000o(cf.O000000o, stringBuffer2, O000000o));
            stringBuffer3.append(stringBuilder.toString());
            return stringBuffer3.toString();
        }

        private String O000000o(String str) {
            String[] split = str.split(HttpUtils.PARAMETERS_SEPARATOR);
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String O00000Oo : split) {
                stringBuffer.append(O00000Oo(O00000Oo));
                stringBuffer.append(HttpUtils.PARAMETERS_SEPARATOR);
            }
            String stringBuffer2 = stringBuffer.toString();
            return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
        }

        private String O00000Oo() {
            if (!OOOO0O.O000000o(this.O00000Oo, this.O00000o0, this.O00000o) && this.O00000o >= 7) {
                return MapsInitializer.isLoadWorldGridMap() ? "http://restapi.amap.com/v4/gridmap?" : null;
            } else {
                int nextInt = OO0o00.this.O000000o.nextInt(100000) % 4;
                return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", new Object[]{Integer.valueOf(nextInt + 1)});
            }
        }

        private String O00000Oo(String str) {
            if (str == null) {
                return str;
            }
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                ooOOOOoo.O00000o0(e, "AbstractProtocalHandler", "strReEncoder");
                return "";
            } catch (Exception e2) {
                ooOOOOoo.O00000o0(e2, "AbstractProtocalHandler", "strReEncoderException");
                return "";
            }
        }

        public Map<String, String> getParams() {
            return null;
        }

        public Map<String, String> getRequestHead() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", bu.O00000o0);
            hashtable.put("Accept-Encoding", "gzip");
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"6.8.0", "3dmap"}));
            hashtable.put("x-INFO", o0O0OOOo.O000000o(cf.O000000o));
            hashtable.put("key", o0O0O0Oo.O00000oo(cf.O000000o));
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        public String getURL() {
            if (TextUtils.isEmpty(this.O00000oo)) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O00000oo);
            stringBuilder.append(O000000o());
            return stringBuilder.toString();
        }
    }

    public OO0o00(int i, int i2, MapConfig mapConfig) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = mapConfig;
    }

    private byte[] O000000o(int i, int i2, int i3, String str) throws IOException {
        try {
            return new O000000o(i, i2, i3, str).makeHttpRequest();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Tile getTile(int i, int i2, int i3) {
        Tile obtain;
        try {
            byte[] O000000o = O000000o(i, i2, i3, this.O00000o != null ? this.O00000o.getMapLanguage() : "zh_cn");
            if (O000000o == null) {
                return NO_TILE;
            }
            obtain = Tile.obtain(this.O00000Oo, this.O00000o0, O000000o);
            return obtain;
        } catch (IOException unused) {
            obtain = NO_TILE;
        }
    }

    public int getTileHeight() {
        return this.O00000o0;
    }

    public int getTileWidth() {
        return this.O00000Oo;
    }
}
