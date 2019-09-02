package com.geetest.sdk;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseCoder */
public abstract class O00OOo0<T> {
    private static final String O00000o0 = "O00OOo0";
    protected Context O000000o;
    protected byte[] O00000Oo;
    private String O00000o;
    private int O00000oO;
    private String O00000oo;
    private T O0000O0o;
    private Network O0000OOo;
    private String O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO = false;

    public O00OOo0(String str, Context context) {
        this.O00000o = str;
        this.O000000o = context;
    }

    static void O0000OoO() {
        O0OOO00.O000000o("request cancel");
    }

    /* Access modifiers changed, original: protected|final|varargs */
    public final String O000000o(String str, Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O0000Oo);
        stringBuilder.append(" ");
        stringBuilder.append(String.format(str, objArr));
        O0OOO00.O00000Oo();
        return this.O000000o.getString(R.string.gt3_request_net_erroe);
    }

    /* Access modifiers changed, original: protected */
    public JSONObject O000000o() {
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(int i, String str) {
        this.O00000oO = i;
        this.O00000oo = str;
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(O00Oo00o o00Oo00o) {
        if (o00Oo00o != null) {
            try {
                o00Oo00o.O000000o(this.O00000oO, this.O00000oo, this.O0000O0o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void O000000o(String str) {
        this.O0000Oo = str;
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(O00Oo0<String, T> o00Oo0, JSONObject jSONObject) {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void O00000Oo() {
        this.O0000Oo0 = 0;
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo(String str) {
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(str)) {
            O000000o(-2, "response null!");
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.O0000Oo);
            stringBuilder.append(" parse error: response null!");
            O0OOO00.O000000o(stringBuilder.toString());
        } else if (str.startsWith("GT3_Error_Info: ")) {
            O000000o(-2, str.replace("GT3_Error_Info: ", ""));
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.O0000Oo);
            stringBuilder.append(" parse error: response null!");
            O0OOO00.O000000o(stringBuilder.toString());
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.O0000Oo);
            stringBuilder2.append(" response body: ");
            stringBuilder2.append(str);
            O0OOO00.O000000o();
            str = str.replace("(", "").replace(")", "");
            if (TextUtils.isEmpty(str)) {
                O000000o(-2, "decrypt error: ".concat(String.valueOf(str)));
                return;
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.O0000Oo);
            stringBuilder2.append(" parsed response body: ");
            stringBuilder2.append(str);
            O0OOO00.O000000o();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result");
                O00Oo0 o00Oo0 = new O00Oo0();
                if (O000000o(o00Oo0, jSONObject)) {
                    String str2 = (String) o00Oo0.O000000o;
                    Object obj = o00Oo0.O00000Oo;
                    this.O00000oO = optInt;
                    this.O00000oo = str2;
                    this.O0000O0o = obj;
                    return;
                }
                O000000o(-2, (String) o00Oo0.O000000o);
            } catch (JSONException e) {
                e.printStackTrace();
                StringBuilder stringBuilder3 = new StringBuilder("parse json error：");
                stringBuilder3.append(str);
                stringBuilder3.append(" Exception: ");
                stringBuilder3.append(e.toString());
                O000000o(-2, stringBuilder3.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.O0000Oo);
                stringBuilder.append(" parse error: ");
                stringBuilder.append(e.toString());
                O0OOO00.O000000o(stringBuilder.toString());
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void O00000o() {
        this.O0000OoO = true;
    }

    /* Access modifiers changed, original: final */
    public final String O00000o0() {
        return this.O0000Oo;
    }

    /* Access modifiers changed, original: protected|final */
    public final String O00000o0(String str) {
        Object[] objArr = new Object[]{"absent", str};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O0000Oo);
        stringBuilder.append(" ");
        stringBuilder.append(String.format("%s %s", objArr));
        O0OOO00.O00000Oo();
        return this.O000000o.getString(R.string.gt3_request_data_error);
    }

    /* Access modifiers changed, original: final */
    public final byte[] O00000oO() {
        this.O00000Oo = null;
        try {
            JSONObject O000000o = O000000o();
            String jSONObject = O000000o != null ? O000000o.toString() : null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O0000Oo);
            stringBuilder.append(" request body: ");
            stringBuilder.append(jSONObject);
            O0OOO00.O000000o();
            if (this.O0000OoO) {
                byte[] toByteArray;
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.getBytes());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    O0OO0Oo.O000000o(byteArrayInputStream, byteArrayOutputStream);
                    toByteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    O0OOO00.O000000o(e.toString());
                    toByteArray = null;
                }
                if (toByteArray != null) {
                    this.O00000Oo = toByteArray;
                    return this.O00000Oo;
                }
            }
            if (!TextUtils.isEmpty(jSONObject)) {
                this.O00000Oo = jSONObject.getBytes();
                return this.O00000Oo;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oo() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String O0000O0o() {
        return this.O00000o;
    }

    /* Access modifiers changed, original: protected|final */
    public final Context O0000OOo() {
        return this.O000000o;
    }

    /* Access modifiers changed, original: final */
    public final Network O0000Oo() {
        return this.O0000OOo;
    }

    public abstract Map<String, String> O0000Oo0();
}
