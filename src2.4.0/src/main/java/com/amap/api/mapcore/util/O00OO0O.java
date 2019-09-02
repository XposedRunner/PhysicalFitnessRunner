package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: OfflineMapRemoveTask */
public class O00OO0O {
    private Context O000000o;

    public O00OO0O(Context context) {
        this.O000000o = context;
    }

    private boolean O000000o(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String O00000Oo = OOo000.O00000Oo(context);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo);
            stringBuilder.append(str2);
            stringBuilder.append(str);
            stringBuilder.append(".dat");
            File file = new File(stringBuilder.toString());
            if (!file.exists() || O00o.O00000Oo(file)) {
                try {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(O00000Oo);
                    stringBuilder2.append(str2);
                    O00o.O00000Oo(stringBuilder2.toString());
                    O00o.O00000Oo(str, context);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            O00o.O000000o("deleteDownload delete some thing wrong!");
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e22) {
            e22.printStackTrace();
            return false;
        }
    }

    private boolean O00000Oo(bf bfVar) {
        if (bfVar == null) {
            return false;
        }
        String pinyin = bfVar.getPinyin();
        boolean O000000o = O000000o(pinyin, this.O000000o, "vmap/");
        if (pinyin.equals("quanguogaiyaotu")) {
            pinyin = "quanguo";
        }
        boolean z = true;
        boolean z2 = O000000o(pinyin, this.O000000o, "map/") || O000000o;
        if (!(O00000Oo(O00o.O00000o0(bfVar.getUrl()), this.O000000o, "map/") || z2)) {
            z = false;
        }
        if (z) {
            bfVar.O0000Oo0();
            return z;
        }
        bfVar.O0000OOo();
        return false;
    }

    private boolean O00000Oo(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String O000000o = OOo000.O000000o(context);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o);
            stringBuilder.append(str2);
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            if (!file.exists() || O00o.O00000Oo(file)) {
                try {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(O000000o);
                    stringBuilder2.append(str2);
                    O00o.O00000Oo(stringBuilder2.toString());
                    O00o.O00000Oo(str, context);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            O00o.O000000o("deleteDownload delete some thing wrong!");
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e22) {
            e22.printStackTrace();
            return false;
        }
    }

    public void O000000o(bf bfVar) {
        O00000Oo(bfVar);
    }
}
