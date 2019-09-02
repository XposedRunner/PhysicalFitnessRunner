package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.a.i;
import cn.jpush.android.d.b;
import java.util.ArrayList;
import org.json.JSONObject;

public final class g extends b implements Runnable {
    public String Q;
    public int R;
    public int S;
    public int T;
    public ArrayList<String> U;
    public String V;
    public String W;
    public String X;
    private transient Context Y;
    public String a;

    public g() {
        this.U = new ArrayList();
        this.V = "";
        this.W = "";
        this.q = 0;
    }

    public final void a(Context context) {
        this.Y = a.b(context);
        JCoreInterface.asyncExecute(this, new int[0]);
    }

    public final boolean a(JSONObject jSONObject) {
        this.a = jSONObject.optString("e_url", "").trim();
        this.Q = jSONObject.optString("e_title", "").trim();
        if (!(TextUtils.isEmpty(this.a) || i.a(this.a))) {
            StringBuilder stringBuilder = new StringBuilder("http://");
            stringBuilder.append(this.a);
            this.a = stringBuilder.toString();
        }
        this.S = jSONObject.optInt("e_rich_type", 0);
        this.R = jSONObject.optInt("e_jump_mode", 0);
        this.T = jSONObject.optInt("e_show", 0);
        if (3 == this.S || 2 == this.S || 1 == this.S) {
            this.U = b.a(jSONObject.optJSONArray("e_eres"));
        }
        this.V = jSONObject.optString("from_num", "");
        this.W = jSONObject.optString("to_num", "");
        return true;
    }

    /* JADX WARNING: Missing block: B:30:0x00b6, code skipped:
            if (cn.jpush.android.d.c.a(r1, r2) != false) goto L_0x00b8;
     */
    public final void run() {
        /*
        r15 = this;
        r0 = r15.T;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r15.c;
        r1 = r15.a;
        r2 = r15.y;
        r3 = r15.Y;
        r3 = r3.getApplicationContext();
        r4 = 3;
        cn.jiguang.api.JCoreInterface.triggerSceneCheck(r3, r4);
        r3 = r15.S;
        r5 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r7 = 5;
        r8 = 995; // 0x3e3 float:1.394E-42 double:4.916E-321;
        r9 = 4;
        r10 = 0;
        if (r3 != 0) goto L_0x00d6;
    L_0x0020:
        r1 = r15.w;
        if (r1 != r4) goto L_0x00cb;
    L_0x0024:
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 != 0) goto L_0x00cb;
    L_0x002a:
        r1 = "http://";
        r1 = r2.startsWith(r1);
        if (r1 != 0) goto L_0x0060;
    L_0x0032:
        r1 = "https://";
        r1 = r2.startsWith(r1);
        if (r1 == 0) goto L_0x003b;
    L_0x003a:
        goto L_0x0060;
    L_0x003b:
        r1 = r15.Y;
        r3 = "android.permission.READ_EXTERNAL_STORAGE";
        r1 = cn.jpush.android.d.a.b(r1, r3);
        if (r1 == 0) goto L_0x005b;
    L_0x0045:
        r1 = r15.Y;
        r1 = cn.jpush.android.d.c.c(r1, r2);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0055;
    L_0x0051:
        r15.y = r1;
        goto L_0x00cb;
    L_0x0055:
        r1 = "ShowEntity";
        r2 = "Get developer picture failed, show basic notification only.";
        goto L_0x00c8;
    L_0x005b:
        r1 = "ShowEntity";
        r2 = "No permission to read resource from storage, show basic notification only.";
        goto L_0x00c8;
    L_0x0060:
        r1 = r15.Y;
        r3 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r1 = cn.jpush.android.d.a.b(r1, r3);
        if (r1 == 0) goto L_0x00c4;
    L_0x006a:
        r1 = r15.Y;
        r3 = ".jpg";
        r3 = r2.endsWith(r3);
        if (r3 != 0) goto L_0x0080;
    L_0x0074:
        r3 = ".png";
        r3 = r2.endsWith(r3);
        if (r3 == 0) goto L_0x007d;
    L_0x007c:
        goto L_0x0080;
    L_0x007d:
        r1 = "";
        goto L_0x00b8;
    L_0x0080:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r0);
        r4 = ".";
        r4 = r2.lastIndexOf(r4);
        r4 = r2.substring(r4);
        r3.append(r4);
        r3 = r3.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = cn.jpush.android.d.c.b(r1, r0);
        r4.append(r1);
        r4.append(r3);
        r1 = r4.toString();
        r2 = cn.jpush.android.b.a.a(r2, r7, r5, r9);
        if (r2 == 0) goto L_0x007d;
    L_0x00b2:
        r2 = cn.jpush.android.d.c.a(r1, r2);
        if (r2 == 0) goto L_0x007d;
    L_0x00b8:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x00bf;
    L_0x00be:
        goto L_0x0051;
    L_0x00bf:
        r1 = "ShowEntity";
        r2 = "Get network picture failed, show basic notification only.";
        goto L_0x00c8;
    L_0x00c4:
        r1 = "ShowEntity";
        r2 = "No permission to write resource to storage, show basic notification only.";
    L_0x00c8:
        cn.jpush.android.d.f.c(r1, r2);
    L_0x00cb:
        r1 = r15.Y;
        cn.jpush.android.a.e.a(r0, r8, r10, r1);
        r0 = r15.Y;
        cn.jpush.android.api.c.a(r0, r15);
        return;
    L_0x00d6:
        r2 = r15.S;
        if (r9 != r2) goto L_0x00e7;
    L_0x00da:
        r15.X = r1;
        r1 = r15.Y;
        cn.jpush.android.a.e.a(r0, r8, r10, r1);
        r0 = r15.Y;
        cn.jpush.android.api.c.a(r0, r15);
        return;
    L_0x00e7:
        r2 = r15.Y;
        r3 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r2 = cn.jpush.android.d.a.b(r2, r3);
        r3 = 1014; // 0x3f6 float:1.421E-42 double:5.01E-321;
        if (r2 != 0) goto L_0x0100;
    L_0x00f3:
        r1 = "ShowEntity";
        r2 = "Rich-push needs the permission of WRITE_EXTERNAL_STORAGE, please request it.";
        cn.jpush.android.d.f.d(r1, r2);
        r1 = r15.Y;
        cn.jpush.android.a.e.a(r0, r3, r10, r1);
        return;
    L_0x0100:
        r2 = android.text.TextUtils.isEmpty(r1);
        r4 = 1;
        r11 = 0;
        if (r2 != 0) goto L_0x0123;
    L_0x0108:
        r2 = r11;
    L_0x0109:
        if (r2 >= r9) goto L_0x0123;
    L_0x010b:
        r12 = cn.jpush.android.b.a.a(r1, r7, r5);
        if (r12 == 0) goto L_0x0120;
    L_0x0111:
        r13 = r12.getResponseCode();
        r14 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r13 != r14) goto L_0x0120;
    L_0x0119:
        r2 = r12.getResponseBody();
        r5 = r2;
        r2 = r4;
        goto L_0x0125;
    L_0x0120:
        r2 = r2 + 1;
        goto L_0x0109;
    L_0x0123:
        r5 = r10;
        r2 = r11;
    L_0x0125:
        r6 = r15.Y;
        r6 = cn.jpush.android.d.c.b(r6, r0);
        if (r2 == 0) goto L_0x01c3;
    L_0x012d:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r6);
        r2.append(r0);
        r7 = ".html";
        r2.append(r7);
        r2 = r2.toString();
        r7 = "/";
        r7 = r1.lastIndexOf(r7);
        r7 = r7 + r4;
        r1 = r1.substring(r11, r7);
        r7 = r15.U;
        r7 = r7.isEmpty();
        if (r7 != 0) goto L_0x01b9;
    L_0x0154:
        r7 = r15.U;
        r9 = r15.Y;
        r12 = r15.a();
        r7 = cn.jpush.android.data.b.a(r7, r9, r1, r0, r12);
        if (r7 != 0) goto L_0x016d;
    L_0x0162:
        r1 = r15.Y;
        cn.jpush.android.a.e.a(r0, r3, r10, r1);
        r0 = r15.Y;
        cn.jpush.android.api.c.a(r0, r15);
        return;
    L_0x016d:
        r7 = new java.lang.StringBuilder;
        r9 = "img src=\"";
        r7.<init>(r9);
        r7.append(r1);
        r1 = r7.toString();
        r7 = new java.lang.StringBuilder;
        r9 = "img src=\"";
        r7.<init>(r9);
        r7.append(r6);
        r6 = r7.toString();
        r1 = r5.replaceAll(r1, r6);
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 != 0) goto L_0x019a;
    L_0x0193:
        r1 = cn.jpush.android.d.c.a(r2, r1);
        if (r1 == 0) goto L_0x019a;
    L_0x0199:
        goto L_0x019b;
    L_0x019a:
        r4 = r11;
    L_0x019b:
        if (r4 == 0) goto L_0x01b3;
    L_0x019d:
        r1 = new java.lang.StringBuilder;
        r3 = "file://";
        r1.<init>(r3);
        r1.append(r2);
        r1 = r1.toString();
        r15.X = r1;
        r1 = r15.Y;
        cn.jpush.android.a.e.a(r0, r8, r10, r1);
        goto L_0x01bd;
    L_0x01b3:
        r1 = r15.Y;
        cn.jpush.android.a.e.a(r0, r3, r10, r1);
        return;
    L_0x01b9:
        r0 = r15.a;
        r15.X = r0;
    L_0x01bd:
        r0 = r15.Y;
        cn.jpush.android.api.c.a(r0, r15);
        return;
    L_0x01c3:
        r2 = r15.Y;
        cn.jpush.android.a.e.a(r0, r3, r10, r2);
        r2 = 1021; // 0x3fd float:1.431E-42 double:5.044E-321;
        r3 = r15.Y;
        r1 = cn.jpush.android.d.a.a(r3, r1);
        r3 = r15.Y;
        cn.jpush.android.a.e.a(r0, r2, r1, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.g.run():void");
    }
}
