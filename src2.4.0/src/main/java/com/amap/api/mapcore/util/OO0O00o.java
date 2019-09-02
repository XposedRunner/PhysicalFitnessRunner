package com.amap.api.mapcore.util;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.FileUtil;

/* compiled from: CustomStyleTextureTask */
public class OO0O00o implements Runnable {
    private Context O000000o;
    private OO00o00 O00000Oo;
    private O000000o O00000o;
    private OO0OOOO O00000o0;

    /* compiled from: CustomStyleTextureTask */
    public interface O000000o {
        void O000000o(String str, OO0OOOO oo0oooo);
    }

    public OO0O00o(Context context) {
        this.O000000o = context;
        if (this.O00000Oo == null) {
            this.O00000Oo = new OO00o00(this.O000000o, "");
        }
    }

    private String O000000o(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    private void O000000o(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    public void O000000o() {
        this.O000000o = null;
        if (this.O00000Oo != null) {
            this.O00000Oo = null;
        }
    }

    public void O000000o(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public void O000000o(OO0OOOO oo0oooo) {
        this.O00000o0 = oo0oooo;
    }

    public void O000000o(String str) {
        if (this.O00000Oo != null) {
            this.O00000Oo.O000000o(str);
        }
    }

    public void O00000Oo() {
        OOOo000.O000000o().O000000o(this);
    }

    public void run() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.O00000Oo != null) {
                    com.amap.api.mapcore.util.OO00o00.O000000o o000000o = (com.amap.api.mapcore.util.OO00o00.O000000o) this.O00000Oo.O000000o();
                    String str = null;
                    if (!(o000000o == null || o000000o.O000000o == null)) {
                        str = O000000o(this.O000000o);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                        stringBuilder.append("custom_texture_data");
                        str = stringBuilder.toString();
                        O000000o(str, o000000o.O000000o);
                    }
                    if (this.O00000o != null) {
                        this.O00000o.O000000o(str, this.O00000o0);
                    }
                }
                ooOOOOoo.O000000o(this.O000000o, OOo000.O00000oO());
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
