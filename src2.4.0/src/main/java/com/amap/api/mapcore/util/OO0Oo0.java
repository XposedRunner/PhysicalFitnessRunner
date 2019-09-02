package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: AndroidAssets */
public class OO0Oo0 {
    static OO0Oo0 O00000Oo;
    Context O000000o;

    private OO0Oo0(Context context) {
        this.O000000o = context;
    }

    public static String O000000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream O00000Oo = O00000Oo.O00000Oo(str);
        if (O00000Oo == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(O00000Oo, "utf-8"));
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) {
                    break;
                }
                stringBuilder.append(str);
                stringBuilder.append(10);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void O000000o(Context context) {
        O00000Oo = new OO0Oo0(context);
    }

    public InputStream O00000Oo(String str) {
        try {
            return this.O000000o.getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
