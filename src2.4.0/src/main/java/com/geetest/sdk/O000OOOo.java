package com.geetest.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebviewHandler */
public class O000OOOo extends O000O0OO {
    private static final String O00000oO = "O000OOOo";

    /* compiled from: WebviewHandler */
    private class O000000o extends O00OOOo {
        private boolean O00000Oo;

        private O000000o() {
            this.O00000Oo = false;
        }

        /* synthetic */ O000000o(O000OOOo o000OOOo, byte b) {
            this();
        }

        public final void O000000o() {
            if (!this.O00000Oo) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "Sensebot");
                    jSONObject.put("sdkVersion", "4.0.7");
                    jSONObject.put("challenge", O000OOOo.this.O00000Oo.O0000O0o().O00000o());
                    jSONObject.put("duration", System.currentTimeMillis() - O000OOOo.this.O00000Oo.O0000OOo());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                O000OOOo.this.O00000Oo.O00000oO().getListener().onDialogReady(jSONObject.toString());
                O000OOOo.this.O00000Oo.O00000oo().O00000Oo();
                if (O000OOOo.this.O00000Oo.O0000Oo() == 2) {
                    com.geetest.sdk.O000000o.O000000o O0000Oo0 = O000OOOo.this.O00000Oo.O0000Oo0();
                    if (O0000Oo0 != null) {
                        O0000Oo0.O00000o();
                    }
                }
                O00O00o0.O0000Oo0("1");
                O000OOOo.this.O00000o(O000OOOo.this.O00000Oo);
            }
        }

        public final void O000000o(String str) {
            try {
                O00O00Oo O0000O0o = O000OOOo.this.O00000Oo.O0000O0o();
                JSONObject jSONObject = new JSONObject(str);
                O0000O0o.O0000O0o(jSONObject.getString("geetest_challenge"));
                O0000O0o.O0000OOo(jSONObject.getString("geetest_validate"));
                O0000O0o.O0000Oo0(jSONObject.getString("geetest_seccode"));
                O000OOOo.this.O000000o.O00000Oo(O000OOOo.this.O00000Oo);
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("webview 解析json错误，错误码，202--->");
                stringBuilder.append(str);
                stringBuilder.append("  Exception: ");
                stringBuilder.append(e.toString());
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder("webview parse json error-->");
                stringBuilder3.append(str);
                stringBuilder3.append("-->");
                stringBuilder3.append(e.toString());
                O000OOOo.O000000o(O000OOOo.this, "202", stringBuilder2, stringBuilder3.toString(), false);
            }
        }

        public final void O000000o(String str, String str2) {
            this.O00000Oo = true;
            O000OOOo o000OOOo = O000OOOo.this;
            StringBuilder stringBuilder = new StringBuilder("webview 回调错误-->");
            stringBuilder.append(str);
            stringBuilder.append("-->");
            stringBuilder.append(str2);
            O000OOOo.O000000o(o000OOOo, str, stringBuilder.toString(), str2, str.startsWith("_"));
            if (!TextUtils.isEmpty(str) && !str.startsWith("_")) {
                O00O00o0.O0000Oo0("0");
                O000OOOo.this.O00000o(O000OOOo.this.O00000Oo);
            }
        }

        public final void O00000Oo() {
            O000OOOo.this.O00000Oo.O00000oo().O00000o();
            if (O000OOOo.this.O00000Oo.O0000Oo() == 2) {
                com.geetest.sdk.O000000o.O000000o O0000Oo0 = O000OOOo.this.O00000Oo.O0000Oo0();
                if (O0000Oo0 != null) {
                    O0000Oo0.O000000o(O00O0o.O0000OoO(), "");
                }
            }
            O000OOOo.this.O00000o.getListener().onClosed(1);
        }
    }

    static /* synthetic */ void O000000o(O000OOOo o000OOOo, String str, String str2, String str3, boolean z) {
        O0OOO00.O000000o(str2);
        O00O000o o00O000o = new O00O000o();
        o00O000o.O00000Oo(str3);
        o00O000o.O000000o(str);
        o00O000o.O000000o(System.currentTimeMillis() - o000OOOo.O00000Oo.O0000OOo());
        o00O000o.O00000o0(o000OOOo.O00000Oo.O0000O0o().O00000o());
        o00O000o.O000000o(z);
        o000OOOo.O00000Oo.O000000o(o00O000o);
        O000O0OO.O00000o0(o000OOOo.O00000Oo);
    }

    public final int O000000o() {
        return 20;
    }

    public final void O000000o(O0O0o00 o0O0o00) {
        o0O0o00.O00000oo().O000000o(o0O0o00.O0000O0o(), new O000000o(this, (byte) 0));
    }
}
