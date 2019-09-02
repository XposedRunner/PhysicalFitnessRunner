package com.qiyukf.unicorn.j;

import android.os.Handler;
import com.qiyukf.nim.uikit.b;
import com.qiyukf.nimlib.i.f;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.d.s;
import com.qiyukf.unicorn.f.a.e.k;
import com.qiyukf.unicorn.h.c;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {

    public interface a {
        void a(int i);

        void a(JSONArray jSONArray);
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x0152 A:{Catch:{ JSONException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014f A:{Catch:{ JSONException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0181 A:{Catch:{ JSONException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0169 A:{Catch:{ JSONException -> 0x0187 }} */
    /* JADX WARNING: Missing block: B:49:0x00b4, code skipped:
            r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.custom;
     */
    public static com.qiyukf.nimlib.i.a a(org.json.JSONObject r5) {
        /*
        r0 = new com.qiyukf.nimlib.i.a;	 Catch:{ JSONException -> 0x0187 }
        r0.<init>();	 Catch:{ JSONException -> 0x0187 }
        r1 = "id";
        r1 = com.qiyukf.basesdk.c.b.c(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        r0.b(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = "type";
        r1 = com.qiyukf.basesdk.c.b.e(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        if (r1 != 0) goto L_0x001a;
    L_0x0016:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.text;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x00c5;
    L_0x001a:
        r2 = -1;
        r3 = r1.hashCode();	 Catch:{ JSONException -> 0x0187 }
        switch(r3) {
            case -1550589943: goto L_0x00a3;
            case -1349088399: goto L_0x0098;
            case -786304394: goto L_0x008d;
            case 3600: goto L_0x0083;
            case 102264: goto L_0x0078;
            case 114843: goto L_0x006e;
            case 3143036: goto L_0x0064;
            case 3556653: goto L_0x005a;
            case 35379135: goto L_0x0050;
            case 93166550: goto L_0x0046;
            case 100313435: goto L_0x003b;
            case 112202875: goto L_0x0030;
            case 923828588: goto L_0x0024;
            default: goto L_0x0022;
        };	 Catch:{ JSONException -> 0x0187 }
    L_0x0022:
        goto L_0x00ad;
    L_0x0024:
        r3 = "cnotify";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x002c:
        r2 = 12;
        goto L_0x00ad;
    L_0x0030:
        r3 = "video";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0038:
        r2 = 5;
        goto L_0x00ad;
    L_0x003b:
        r3 = "image";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0043:
        r2 = 1;
        goto L_0x00ad;
    L_0x0046:
        r3 = "audio";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x004e:
        r2 = 2;
        goto L_0x00ad;
    L_0x0050:
        r3 = "workflow";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0058:
        r2 = 7;
        goto L_0x00ad;
    L_0x005a:
        r3 = "text";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0062:
        r2 = 0;
        goto L_0x00ad;
    L_0x0064:
        r3 = "file";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x006c:
        r2 = 3;
        goto L_0x00ad;
    L_0x006e:
        r3 = "tip";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0076:
        r2 = 4;
        goto L_0x00ad;
    L_0x0078:
        r3 = "gfw";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0080:
        r2 = 10;
        goto L_0x00ad;
    L_0x0083:
        r3 = "qa";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x008b:
        r2 = 6;
        goto L_0x00ad;
    L_0x008d:
        r3 = "ainvalid";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0095:
        r2 = 11;
        goto L_0x00ad;
    L_0x0098:
        r3 = "custom";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x00a0:
        r2 = 8;
        goto L_0x00ad;
    L_0x00a3:
        r3 = "richtext";
        r1 = r1.equals(r3);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x00ad;
    L_0x00ab:
        r2 = 9;
    L_0x00ad:
        switch(r2) {
            case 0: goto L_0x0016;
            case 1: goto L_0x00c3;
            case 2: goto L_0x00c0;
            case 3: goto L_0x00bd;
            case 4: goto L_0x00ba;
            case 5: goto L_0x00b7;
            case 6: goto L_0x00b4;
            case 7: goto L_0x00b4;
            case 8: goto L_0x00b4;
            case 9: goto L_0x00b4;
            case 10: goto L_0x00b4;
            case 11: goto L_0x00b1;
            case 12: goto L_0x00b1;
            default: goto L_0x00b0;
        };	 Catch:{ JSONException -> 0x0187 }
    L_0x00b0:
        goto L_0x00b4;
    L_0x00b1:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.notification;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x00c5;
    L_0x00b4:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.custom;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x00c5;
    L_0x00b7:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.video;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x00c5;
    L_0x00ba:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.tips;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x00c5;
    L_0x00bd:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.file;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x00c5;
    L_0x00c0:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.audio;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x00c5;
    L_0x00c3:
        r1 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.image;	 Catch:{ JSONException -> 0x0187 }
    L_0x00c5:
        r1 = r1.getValue();	 Catch:{ JSONException -> 0x0187 }
        r0.a(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.success;	 Catch:{ JSONException -> 0x0187 }
        r0.setStatus(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = "ext";
        r1 = com.qiyukf.basesdk.c.b.e(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        r0.setExt(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = "content";
        r1 = com.qiyukf.basesdk.c.b.e(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        r2 = r0.getMsgType();	 Catch:{ JSONException -> 0x0187 }
        r3 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.text;	 Catch:{ JSONException -> 0x0187 }
        if (r2 == r3) goto L_0x0132;
    L_0x00e8:
        r2 = r0.getMsgType();	 Catch:{ JSONException -> 0x0187 }
        r3 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.notification;	 Catch:{ JSONException -> 0x0187 }
        if (r2 == r3) goto L_0x0132;
    L_0x00f0:
        r2 = r0.getMsgType();	 Catch:{ JSONException -> 0x0187 }
        r3 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.tips;	 Catch:{ JSONException -> 0x0187 }
        if (r2 != r3) goto L_0x00f9;
    L_0x00f8:
        goto L_0x0132;
    L_0x00f9:
        r0.c(r1);	 Catch:{ JSONException -> 0x0187 }
        r2 = com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum.def;	 Catch:{ JSONException -> 0x0187 }
        r0.setAttachStatus(r2);	 Catch:{ JSONException -> 0x0187 }
        r2 = r0.getMsgType();	 Catch:{ JSONException -> 0x0187 }
        r3 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.audio;	 Catch:{ JSONException -> 0x0187 }
        if (r2 != r3) goto L_0x0135;
    L_0x0109:
        r2 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.read;	 Catch:{ JSONException -> 0x0187 }
        r0.setStatus(r2);	 Catch:{ JSONException -> 0x0187 }
        r1 = com.qiyukf.basesdk.c.b.a(r1);	 Catch:{ JSONException -> 0x0187 }
        r2 = "tt";
        r2 = r1.has(r2);	 Catch:{ JSONException -> 0x0187 }
        if (r2 == 0) goto L_0x0135;
    L_0x011a:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0187 }
        r2.<init>();	 Catch:{ JSONException -> 0x0187 }
        r3 = "content";
        r4 = "tt";
        r1 = r1.get(r4);	 Catch:{ JSONException -> 0x0187 }
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = r2.toString();	 Catch:{ JSONException -> 0x0187 }
        r0.setExt(r1);	 Catch:{ JSONException -> 0x0187 }
        goto L_0x0135;
    L_0x0132:
        r0.setContent(r1);	 Catch:{ JSONException -> 0x0187 }
    L_0x0135:
        r1 = "time";
        r1 = com.qiyukf.basesdk.c.b.c(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        r0.setTime(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = "msgIdClient";
        r1 = com.qiyukf.basesdk.c.b.e(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        r0.a(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = "fromUser";
        r1 = com.qiyukf.basesdk.c.b.b(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        if (r1 != 0) goto L_0x0152;
    L_0x014f:
        r1 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.In;	 Catch:{ JSONException -> 0x0187 }
        goto L_0x0154;
    L_0x0152:
        r1 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.Out;	 Catch:{ JSONException -> 0x0187 }
    L_0x0154:
        r0.setDirect(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = "-1";
        r0.b(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Ysf;	 Catch:{ JSONException -> 0x0187 }
        r0.a(r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = r0.getDirect();	 Catch:{ JSONException -> 0x0187 }
        r2 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.In;	 Catch:{ JSONException -> 0x0187 }
        if (r1 != r2) goto L_0x0181;
    L_0x0169:
        r1 = "kefu";
        r5 = com.qiyukf.basesdk.c.b.f(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        r1 = "imid";
        r1 = com.qiyukf.basesdk.c.b.e(r5, r1);	 Catch:{ JSONException -> 0x0187 }
        if (r1 == 0) goto L_0x0186;
    L_0x0177:
        r1 = "imid";
        r5 = com.qiyukf.basesdk.c.b.e(r5, r1);	 Catch:{ JSONException -> 0x0187 }
    L_0x017d:
        r0.setFromAccount(r5);	 Catch:{ JSONException -> 0x0187 }
        return r0;
    L_0x0181:
        r5 = com.qiyukf.nimlib.b.b();	 Catch:{ JSONException -> 0x0187 }
        goto L_0x017d;
    L_0x0186:
        return r0;
    L_0x0187:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.j.g.a(org.json.JSONObject):com.qiyukf.nimlib.i.a");
    }

    public static void a() {
        c.a(new k(), c.a(), false);
    }

    public static void a(final s sVar) {
        new Thread(new Runnable() {
            public final void run() {
                Throwable e;
                StringBuilder stringBuilder;
                String str = "/webapi/sdk/user/message/history";
                s sVar = sVar;
                HashMap hashMap = new HashMap();
                hashMap.put(WBConstants.SSO_APP_KEY, d.d());
                hashMap.put("fromAccount", b.b());
                hashMap.put("accessToken", sVar.a());
                hashMap.put("beginTime", String.valueOf(System.currentTimeMillis() - 604800000));
                hashMap.put("endTime", String.valueOf(System.currentTimeMillis()));
                hashMap.put("limit", String.valueOf("20"));
                AnonymousClass1 anonymousClass1 = new a() {
                    public final void a(int i) {
                        com.qiyukf.basesdk.a.a.a("请求未读消息接口失败 code 为：", String.valueOf(i));
                    }

                    public final void a(JSONArray jSONArray) {
                        com.qiyukf.unicorn.b.b.a(Boolean.valueOf(true));
                        List arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(g.a(com.qiyukf.basesdk.c.b.b(jSONArray, i)));
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            com.qiyukf.nimlib.i.a aVar = (com.qiyukf.nimlib.i.a) it.next();
                            if (f.b(aVar.getUuid()) != 0 || (aVar.getUuid().contains("#") && f.b(aVar.getUuid().substring(aVar.getUuid().indexOf("#") + 1)) != 0)) {
                                it.remove();
                            }
                        }
                        if (arrayList.size() != 0) {
                            f.a(arrayList);
                            com.qiyukf.nimlib.e.b.a(arrayList);
                        }
                    }
                };
                String a;
                try {
                    a = com.qiyukf.unicorn.f.b.a.a(str, hashMap);
                    com.qiyukf.basesdk.a.a.a("服务端返回未读消息的 json", a);
                    JSONObject a2 = com.qiyukf.basesdk.c.b.a(a);
                    if (a2.getInt(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE) == 200) {
                        anonymousClass1.a(a2.getJSONArray("result"));
                    } else {
                        anonymousClass1.a(a2.getInt(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE));
                    }
                } catch (com.qiyukf.unicorn.f.b.b e2) {
                    e = e2;
                    a = "YSFHttpClient.httpGet失败";
                    stringBuilder = new StringBuilder("请求 url 为");
                    stringBuilder.append(str);
                    com.qiyukf.basesdk.a.a.a(a, stringBuilder.toString(), e);
                } catch (JSONException e3) {
                    e = e3;
                    a = "解析未读消息 json 失败";
                    stringBuilder = new StringBuilder("请求 url 为");
                    stringBuilder.append(str);
                    com.qiyukf.basesdk.a.a.a(a, stringBuilder.toString(), e);
                }
            }
        }).start();
    }

    public static synchronized void a(Boolean bool) {
        synchronized (g.class) {
            com.qiyukf.unicorn.b.b.a(Boolean.valueOf(false));
            a();
            if (bool.booleanValue()) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        if (!com.qiyukf.unicorn.b.b.j().booleanValue()) {
                            g.a();
                        }
                    }
                }, 5000);
            }
        }
    }
}
