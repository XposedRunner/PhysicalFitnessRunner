package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.support.v4.app.SemesterTipDialog;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener l;
    private String o;
    private int u;
    private String url;

    static class a {
        public OAuthErrCode n;
        public String v;
        public int w;

        a() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:25:0x0065 in {4, 14, 16, 18, 19, 20, 21, 22, 24, 27, 28, 30, 32, 33} preds:[]
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public static com.tencent.mm.opensdk.diffdev.a.f.a b(byte[] r7) {
            /*
            r0 = new com.tencent.mm.opensdk.diffdev.a.f$a;
            r0.<init>();
            if (r7 == 0) goto L_0x008d;
            r1 = r7.length;
            if (r1 != 0) goto L_0x000c;
            goto L_0x008d;
            r1 = 0;
            r2 = 1;
            r3 = new java.lang.String;	 Catch:{ Exception -> 0x007f }
            r4 = "utf-8";	 Catch:{ Exception -> 0x007f }
            r3.<init>(r7, r4);	 Catch:{ Exception -> 0x007f }
            r7 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0066 }
            r7.<init>(r3);	 Catch:{ Exception -> 0x0066 }
            r3 = "wx_errcode";	 Catch:{ Exception -> 0x0066 }
            r3 = r7.getInt(r3);	 Catch:{ Exception -> 0x0066 }
            r0.w = r3;	 Catch:{ Exception -> 0x0066 }
            r3 = "MicroMsg.SDK.NoopingResult";	 Catch:{ Exception -> 0x0066 }
            r4 = "nooping uuidStatusCode = %d";	 Catch:{ Exception -> 0x0066 }
            r5 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0066 }
            r6 = r0.w;	 Catch:{ Exception -> 0x0066 }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0066 }
            r5[r1] = r6;	 Catch:{ Exception -> 0x0066 }
            r4 = java.lang.String.format(r4, r5);	 Catch:{ Exception -> 0x0066 }
            com.tencent.mm.opensdk.utils.Log.d(r3, r4);	 Catch:{ Exception -> 0x0066 }
            r3 = r0.w;	 Catch:{ Exception -> 0x0066 }
            r4 = 408; // 0x198 float:5.72E-43 double:2.016E-321;	 Catch:{ Exception -> 0x0066 }
            if (r3 == r4) goto L_0x0062;	 Catch:{ Exception -> 0x0066 }
            r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Exception -> 0x0066 }
            if (r3 == r4) goto L_0x005f;	 Catch:{ Exception -> 0x0066 }
            switch(r3) {
                case 402: goto L_0x005c;
                case 403: goto L_0x0059;
                case 404: goto L_0x0056;
                case 405: goto L_0x0049;
                default: goto L_0x0044;
            };	 Catch:{ Exception -> 0x0066 }
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0066 }
            r0.n = r7;	 Catch:{ Exception -> 0x0066 }
            return r0;	 Catch:{ Exception -> 0x0066 }
            r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0066 }
            r0.n = r3;	 Catch:{ Exception -> 0x0066 }
            r3 = "wx_code";	 Catch:{ Exception -> 0x0066 }
            r7 = r7.getString(r3);	 Catch:{ Exception -> 0x0066 }
            r0.v = r7;	 Catch:{ Exception -> 0x0066 }
            return r0;	 Catch:{ Exception -> 0x0066 }
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0066 }
            goto L_0x0046;	 Catch:{ Exception -> 0x0066 }
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;	 Catch:{ Exception -> 0x0066 }
            goto L_0x0046;	 Catch:{ Exception -> 0x0066 }
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;	 Catch:{ Exception -> 0x0066 }
            goto L_0x0046;	 Catch:{ Exception -> 0x0066 }
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0066 }
            goto L_0x0046;	 Catch:{ Exception -> 0x0066 }
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0066 }
            goto L_0x0046;
            return r0;
            r7 = move-exception;
            r3 = "MicroMsg.SDK.NoopingResult";
            r4 = "parse json fail, ex = %s";
            r2 = new java.lang.Object[r2];
            r7 = r7.getMessage();
            r2[r1] = r7;
            r7 = java.lang.String.format(r4, r2);
            com.tencent.mm.opensdk.utils.Log.e(r3, r7);
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.n = r7;
            return r0;
            r7 = move-exception;
            r3 = "MicroMsg.SDK.NoopingResult";
            r4 = "parse fail, build String fail, ex = %s";
            r2 = new java.lang.Object[r2];
            r7 = r7.getMessage();
            r2[r1] = r7;
            goto L_0x0073;
            r7 = "MicroMsg.SDK.NoopingResult";
            r1 = "parse fail, buf is null";
            com.tencent.mm.opensdk.utils.Log.e(r7, r1);
            r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            goto L_0x007c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.f$a.b(byte[]):com.tencent.mm.opensdk.diffdev.a.f$a");
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.o = str;
        this.l = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        if (this.o == null || this.o.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            while (!isCancelled()) {
                String str;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.url);
                if (this.u == 0) {
                    str = "";
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("&last=");
                    stringBuilder2.append(this.u);
                    str = stringBuilder2.toString();
                }
                stringBuilder.append(str);
                String stringBuilder3 = stringBuilder.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a = e.a(stringBuilder3, SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG);
                long currentTimeMillis2 = System.currentTimeMillis();
                a b = a.b(a);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{stringBuilder3, b.n.toString(), Integer.valueOf(b.w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
                if (b.n == OAuthErrCode.WechatAuth_Err_OK) {
                    this.u = b.w;
                    if (b.w == g.UUID_SCANED.getCode()) {
                        this.l.onQrcodeScanned();
                    } else if (b.w != g.UUID_KEEP_CONNECT.getCode() && b.w == g.UUID_CONFIRM.getCode()) {
                        if (b.v == null || b.v.length() == 0) {
                            Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                            b.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        return b;
                    }
                }
                Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{b.n.toString(), Integer.valueOf(b.w)}));
                return b;
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.n = oAuthErrCode;
        return aVar;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.l.onAuthFinish(aVar.n, aVar.v);
    }
}
