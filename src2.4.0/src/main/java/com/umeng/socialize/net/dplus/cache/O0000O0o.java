package com.umeng.socialize.net.dplus.cache;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000o00;
import defpackage.bt;
import defpackage.ce;
import defpackage.cu;
import defpackage.cx;
import defpackage.cy;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DplusCacheApi */
public class O0000O0o {
    private static final String O000000o = "DplusCacheApi";
    private HandlerThread O00000Oo;
    private final int O00000o;
    private Handler O00000o0;
    private ArrayList<Integer> O00000oO;
    private ArrayList<Integer> O00000oo;
    private ArrayList<Integer> O0000O0o;
    private ArrayList<Integer> O0000OOo;
    private ArrayList<Integer> O0000Oo0;

    /* compiled from: DplusCacheApi */
    private static class O000000o {
        private static final O0000O0o O000000o = new O0000O0o();

        private O000000o() {
        }
    }

    private O0000O0o() {
        this.O00000o = bt.O000000o;
        this.O00000oO = new ArrayList();
        this.O00000oo = new ArrayList();
        this.O0000O0o = new ArrayList();
        this.O0000OOo = new ArrayList();
        this.O0000Oo0 = new ArrayList();
        this.O00000Oo = new HandlerThread(O000000o, 10);
        this.O00000Oo.start();
        this.O00000o0 = new Handler(this.O00000Oo.getLooper());
    }

    /* synthetic */ O0000O0o(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final O0000O0o O000000o() {
        return O000000o.O000000o;
    }

    public static double O00000Oo() {
        File O000000o = O00000Oo.O000000o(cx.O00000o);
        return (O000000o == null || !O000000o.exists()) ? 0.0d : (double) O000000o.length();
    }

    private static JSONObject O00000o0() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "6.9.4");
        jSONObject.put(cu.O00000Oo, ce.O0000Oo0);
        return jSONObject;
    }

    public JSONObject O000000o(Context context, int i) {
        double O00000Oo = O00000Oo();
        if (O00000Oo >= 5242880.0d) {
            cy.O000000o(O00000Oo.O000000o()).O000000o("stats");
            return null;
        }
        boolean z = 1048576.0d <= O00000Oo + 24576.0d;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray;
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray O000000o = cy.O000000o(context).O000000o("s_e", this.O00000oO, 1047552.0d, z);
            double length = 1024.0d + ((double) O000000o.toString().getBytes().length);
            JSONArray jSONArray2 = O000000o;
            O000000o = cy.O000000o(context).O000000o("auth", this.O00000oo, 1048576.0d - length, z);
            length += (double) O000000o.toString().getBytes().length;
            JSONArray jSONArray3 = O000000o;
            O000000o = cy.O000000o(context).O000000o("userinfo", this.O0000O0o, 1048576.0d - length, z);
            length += (double) O000000o.toString().getBytes().length;
            JSONArray jSONArray4 = O000000o;
            JSONArray O000000o2 = cy.O000000o(context).O000000o("dau", this.O0000OOo, 1048576.0d - length, z);
            length += (double) O000000o2.toString().getBytes().length;
            double O00000Oo2 = O00000Oo();
            if (O000000o2.length() != 0) {
                jSONObject3.put("dau", O000000o2);
            }
            if (jSONArray2.length() != 0) {
                jSONObject3.put("s_e", jSONArray2);
            }
            O000000o = jSONArray3;
            if (O000000o.length() != 0) {
                jSONObject3.put("auth", O000000o);
            }
            if (jSONArray4.length() != 0) {
                jSONObject3.put("userinfo", jSONArray4);
            }
            JSONArray jSONArray5 = new JSONArray();
            if (O00000Oo2 < 524288.0d) {
                if (i != 24583) {
                    jSONArray = O000000o;
                    jSONObject.put("share", jSONObject3);
                    if (jSONArray2.length() == 0 && jSONArray.length() == 0 && jSONArray4.length() == 0 && O000000o2.length() == 0 && jSONArray5.length() == 0) {
                        jSONObject = null;
                    }
                    return (jSONObject != null || ((double) jSONObject.toString().getBytes().length) <= 1048576.0d) ? jSONObject : null;
                }
            }
            double d = 1048576.0d - length;
            jSONArray = O000000o;
            jSONArray5 = cy.O000000o(context).O000000o("stats", this.O0000Oo0, d, z);
            if (jSONArray5.length() != 0) {
                jSONObject3.put("stats", jSONArray5);
            }
            jSONObject.put("share", jSONObject3);
            jSONObject = null;
        } catch (JSONException e) {
            com.umeng.socialize.utils.O0000O0o.O000000o(O0000o00.O00000Oo.O000000o, e);
        }
        if (jSONObject != null) {
        }
    }

    public void O000000o(final Context context) {
        this.O00000o0.post(new Runnable() {
            public void run() {
                if (O0000O0o.this.O00000oO.size() > 0) {
                    cy.O000000o(context).O000000o(O0000O0o.this.O00000oO, "s_e");
                    O0000O0o.this.O00000oO.clear();
                }
                if (O0000O0o.this.O00000oo.size() > 0) {
                    cy.O000000o(context).O000000o(O0000O0o.this.O00000oo, "auth");
                    O0000O0o.this.O00000oo.clear();
                }
                if (O0000O0o.this.O0000OOo.size() > 0) {
                    cy.O000000o(context).O000000o(O0000O0o.this.O0000OOo, "dau");
                    O0000O0o.this.O0000OOo.clear();
                }
                if (O0000O0o.this.O0000O0o.size() > 0) {
                    cy.O000000o(context).O000000o(O0000O0o.this.O0000O0o, "userinfo");
                    O0000O0o.this.O0000O0o.clear();
                }
                if (O0000O0o.this.O0000Oo0.size() > 0) {
                    cy.O000000o(context).O000000o(O0000O0o.this.O0000Oo0, "stats");
                    O0000O0o.this.O0000Oo0.clear();
                }
            }
        });
    }

    public void O000000o(final Context context, final int i, final DplusCacheListener dplusCacheListener) {
        this.O00000o0.post(new Runnable() {
            public void run() {
                double O00000Oo = O0000O0o.O00000Oo();
                if (O00000Oo >= 5242880.0d) {
                    cy.O000000o(O00000Oo.O000000o()).O000000o("stats");
                    return;
                }
                boolean z = 1048576.0d <= O00000Oo + 24576.0d;
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray;
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    JSONArray O000000o = cy.O000000o(context).O000000o("s_e", O0000O0o.this.O00000oO, 1047552.0d, z);
                    double length = 1024.0d + ((double) O000000o.toString().getBytes().length);
                    JSONArray jSONArray2 = O000000o;
                    O000000o = cy.O000000o(context).O000000o("auth", O0000O0o.this.O00000oo, 1048576.0d - length, z);
                    length += (double) O000000o.toString().getBytes().length;
                    JSONArray jSONArray3 = O000000o;
                    O000000o = cy.O000000o(context).O000000o("userinfo", O0000O0o.this.O0000O0o, 1048576.0d - length, z);
                    length += (double) O000000o.toString().getBytes().length;
                    JSONArray jSONArray4 = O000000o;
                    JSONArray O000000o2 = cy.O000000o(context).O000000o("dau", O0000O0o.this.O0000OOo, 1048576.0d - length, z);
                    length += (double) O000000o2.toString().getBytes().length;
                    double O00000Oo2 = O0000O0o.O00000Oo();
                    if (O000000o2.length() != 0) {
                        jSONObject3.put("dau", O000000o2);
                    }
                    if (jSONArray2.length() != 0) {
                        jSONObject3.put("s_e", jSONArray2);
                    }
                    O000000o = jSONArray3;
                    if (O000000o.length() != 0) {
                        jSONObject3.put("auth", O000000o);
                    }
                    if (jSONArray4.length() != 0) {
                        jSONObject3.put("userinfo", jSONArray4);
                    }
                    JSONArray jSONArray5 = new JSONArray();
                    if (O00000Oo2 < 524288.0d) {
                        if (i != ce.O000O0o) {
                            jSONArray = O000000o;
                            jSONObject.put("share", jSONObject3);
                            if (jSONArray2.length() == 0 && jSONArray.length() == 0 && jSONArray4.length() == 0 && O000000o2.length() == 0 && jSONArray5.length() == 0) {
                                jSONObject = null;
                            }
                            if (jSONObject != null && ((double) jSONObject.toString().getBytes().length) > 1048576.0d) {
                                dplusCacheListener.O000000o(null);
                            }
                            dplusCacheListener.O000000o(jSONObject);
                        }
                    }
                    double d = 1048576.0d - length;
                    jSONArray = O000000o;
                    jSONArray5 = cy.O000000o(context).O000000o("stats", O0000O0o.this.O0000Oo0, d, z);
                    if (jSONArray5.length() != 0) {
                        jSONObject3.put("stats", jSONArray5);
                    }
                    jSONObject.put("share", jSONObject3);
                    jSONObject = null;
                } catch (JSONException e) {
                    com.umeng.socialize.utils.O0000O0o.O000000o(O0000o00.O00000Oo.O000000o, e);
                }
                dplusCacheListener.O000000o(null);
                dplusCacheListener.O000000o(jSONObject);
            }
        });
    }

    public void O000000o(Context context, JSONObject jSONObject, int i, DplusCacheListener dplusCacheListener) {
        final int i2 = i;
        final Context context2 = context;
        final JSONObject jSONObject2 = jSONObject;
        final DplusCacheListener dplusCacheListener2 = dplusCacheListener;
        this.O00000o0.post(new Runnable() {
            public void run() {
                switch (i2) {
                    case ce.O00oOooo /*24577*/:
                        cy.O000000o(context2).O00000o(jSONObject2);
                        break;
                    case ce.O000O00o /*24578*/:
                        cy.O000000o(context2).O000000o(jSONObject2);
                        break;
                    case ce.O000O0OO /*24579*/:
                        cy.O000000o(context2).O00000Oo(jSONObject2);
                        break;
                    case ce.O000O0Oo /*24580*/:
                        cy.O000000o(context2).O00000o0(jSONObject2);
                        break;
                    case ce.O00oOoOo /*24581*/:
                    case ce.O000O0o /*24583*/:
                        cy.O000000o(context2).O00000oO(jSONObject2);
                        break;
                    default:
                        cy.O000000o(context2).O00000oO(jSONObject2);
                        break;
                }
                dplusCacheListener2.O000000o(null);
            }
        });
    }

    public void O00000Oo(Context context) {
        if (this.O00000oO.size() > 0) {
            cy.O000000o(context).O000000o(this.O00000oO, "s_e");
            this.O00000oO.clear();
        }
        if (this.O00000oo.size() > 0) {
            cy.O000000o(context).O000000o(this.O00000oo, "auth");
            this.O00000oo.clear();
        }
        if (this.O0000OOo.size() > 0) {
            cy.O000000o(context).O000000o(this.O0000OOo, "dau");
            this.O0000OOo.clear();
        }
        if (this.O0000O0o.size() > 0) {
            cy.O000000o(context).O000000o(this.O0000O0o, "userinfo");
            this.O0000O0o.clear();
        }
        if (this.O0000Oo0.size() > 0) {
            cy.O000000o(context).O000000o(this.O0000Oo0, "stats");
            this.O0000Oo0.clear();
        }
    }

    public void O00000o(Context context) {
        this.O00000o0.post(new Runnable() {
            public void run() {
                cy.O000000o(O00000Oo.O000000o()).O000000o("stats");
            }
        });
    }

    public void O00000o0(Context context) {
        cy.O000000o(O00000Oo.O000000o()).O000000o("stats");
    }
}
