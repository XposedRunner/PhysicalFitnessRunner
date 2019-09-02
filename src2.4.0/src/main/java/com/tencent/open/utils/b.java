package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
public class b {
    private static String c;
    private String a;
    private c b;
    private long d;
    private Handler e;
    private Runnable f = new Runnable() {
        public void run() {
            f.a("AsynLoadImg", "saveFileRunnable:");
            String f = j.f(b.this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("share_qq_");
            stringBuilder.append(f);
            stringBuilder.append(".jpg");
            f = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.c);
            stringBuilder.append(f);
            String stringBuilder2 = stringBuilder.toString();
            File file = new File(stringBuilder2);
            Message obtainMessage = b.this.e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = stringBuilder2;
                stringBuilder = new StringBuilder();
                stringBuilder.append("file exists: time:");
                stringBuilder.append(System.currentTimeMillis() - b.this.d);
                f.a("AsynLoadImg", stringBuilder.toString());
            } else {
                boolean a;
                Bitmap a2 = b.a(b.this.a);
                if (a2 != null) {
                    a = b.this.a(a2, f);
                } else {
                    f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    a = false;
                }
                if (a) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = stringBuilder2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("file not exists: download time:");
                stringBuilder.append(System.currentTimeMillis() - b.this.d);
                f.a("AsynLoadImg", stringBuilder.toString());
            }
            b.this.e.sendMessage(obtainMessage);
        }
    };

    public b(Activity activity) {
        this.e = new Handler(activity.getMainLooper()) {
            public void handleMessage(Message message) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("handleMessage:");
                stringBuilder.append(message.arg1);
                f.a("AsynLoadImg", stringBuilder.toString());
                if (message.arg1 == 0) {
                    b.this.b.a(message.arg1, (String) message.obj);
                } else {
                    b.this.b.a(message.arg1, null);
                }
            }
        };
    }

    public static Bitmap a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getbitmap:");
        stringBuilder.append(str);
        f.a("AsynLoadImg", stringBuilder.toString());
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("image download finished.");
            stringBuilder2.append(str);
            f.a("AsynLoadImg", stringBuilder2.toString());
            return decodeStream;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }

    public void a(String str, c cVar) {
        f.a("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            cVar.a(1, null);
        } else if (j.b()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory());
            stringBuilder.append("/tmp/");
            c = stringBuilder.toString();
            this.d = System.currentTimeMillis();
            this.a = str;
            this.b = cVar;
            new Thread(this.f).start();
        } else {
            cVar.a(2, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071 A:{SYNTHETIC, Splitter:B:25:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c A:{SYNTHETIC, Splitter:B:31:0x007c} */
    public boolean a(android.graphics.Bitmap r6, java.lang.String r7) {
        /*
        r5 = this;
        r0 = c;
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ IOException -> 0x0063 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0063 }
        r3 = r2.exists();	 Catch:{ IOException -> 0x0063 }
        if (r3 != 0) goto L_0x0011;
    L_0x000e:
        r2.mkdir();	 Catch:{ IOException -> 0x0063 }
    L_0x0011:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0063 }
        r2.<init>();	 Catch:{ IOException -> 0x0063 }
        r2.append(r0);	 Catch:{ IOException -> 0x0063 }
        r2.append(r7);	 Catch:{ IOException -> 0x0063 }
        r0 = r2.toString();	 Catch:{ IOException -> 0x0063 }
        r2 = "AsynLoadImg";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0063 }
        r3.<init>();	 Catch:{ IOException -> 0x0063 }
        r4 = "saveFile:";
        r3.append(r4);	 Catch:{ IOException -> 0x0063 }
        r3.append(r7);	 Catch:{ IOException -> 0x0063 }
        r7 = r3.toString();	 Catch:{ IOException -> 0x0063 }
        com.tencent.open.a.f.a(r2, r7);	 Catch:{ IOException -> 0x0063 }
        r7 = new java.io.File;	 Catch:{ IOException -> 0x0063 }
        r7.<init>(r0);	 Catch:{ IOException -> 0x0063 }
        r0 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x0063 }
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0063 }
        r2.<init>(r7);	 Catch:{ IOException -> 0x0063 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0063 }
        r7 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x005e, all -> 0x005b }
        r1 = 80;
        r6.compress(r7, r1, r0);	 Catch:{ IOException -> 0x005e, all -> 0x005b }
        r0.flush();	 Catch:{ IOException -> 0x005e, all -> 0x005b }
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        r0.close();	 Catch:{ IOException -> 0x0055 }
        goto L_0x0059;
    L_0x0055:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0059:
        r6 = 1;
        return r6;
    L_0x005b:
        r6 = move-exception;
        r1 = r0;
        goto L_0x007a;
    L_0x005e:
        r6 = move-exception;
        r1 = r0;
        goto L_0x0064;
    L_0x0061:
        r6 = move-exception;
        goto L_0x007a;
    L_0x0063:
        r6 = move-exception;
    L_0x0064:
        r6.printStackTrace();	 Catch:{ all -> 0x0061 }
        r7 = "AsynLoadImg";
        r0 = "saveFile bmp fail---";
        com.tencent.open.a.f.b(r7, r0, r6);	 Catch:{ all -> 0x0061 }
        r6 = 0;
        if (r1 == 0) goto L_0x0079;
    L_0x0071:
        r1.close();	 Catch:{ IOException -> 0x0075 }
        goto L_0x0079;
    L_0x0075:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0079:
        return r6;
    L_0x007a:
        if (r1 == 0) goto L_0x0084;
    L_0x007c:
        r1.close();	 Catch:{ IOException -> 0x0080 }
        goto L_0x0084;
    L_0x0080:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0084:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.b.a(android.graphics.Bitmap, java.lang.String):boolean");
    }
}
