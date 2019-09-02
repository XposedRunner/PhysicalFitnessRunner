package com.baidu.location.indoor.mapversion.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.location.Jni;
import com.baidu.location.indoor.mapversion.IndoorJni;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class a {
    private c a;
    private d b;
    private ExecutorService c;
    private File d;
    private boolean e;

    private class a implements Runnable {
        public d a;
        public String b;

        private a() {
            this.b = null;
        }

        /* synthetic */ a(a aVar, b bVar) {
            this();
        }

        public void run() {
            if (!(this.b == null || this.a == null)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    jSONObject.put("manufacturer", Build.MANUFACTURER);
                    jSONObject.put("product", Build.PRODUCT);
                    jSONObject.put("brand", Build.BRAND);
                    jSONObject.put("model", Build.MODEL);
                    jSONObject.put("gravity", String.format(Locale.CHINESE, "%.5f,%.5f,%.5f", new Object[]{Float.valueOf(this.a.e[0]), Float.valueOf(this.a.e[1]), Float.valueOf(this.a.e[2])}));
                    jSONObject.put("fov", this.a.d);
                    jSONObject.put("bid", this.a.g);
                    Object obj = "";
                    if (com.baidu.location.g.b.a().b != null) {
                        obj = com.baidu.location.g.b.a().b;
                    }
                    jSONObject.put("cu", obj);
                    IndoorJni.a(this.a.c, a.this.d);
                    File file = new File(a.this.d, "compress.jpg");
                    String a = a.this.c(file.getAbsolutePath());
                    if (a != null) {
                        jSONObject.put("image", a);
                        file.delete();
                        a.this.b(this.a.c);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setRequestMethod(Constants.HTTP_POST);
                        httpURLConnection.addRequestProperty("Content-Type", "application/json;charset=UTF-8");
                        httpURLConnection.setRequestProperty("Accept", "application/json");
                        httpURLConnection.getOutputStream().write(jSONObject.toString().getBytes());
                        httpURLConnection.disconnect();
                        a.this.e = false;
                        return;
                    }
                } catch (Error | Exception unused) {
                } catch (Throwable th) {
                    a.this.e = false;
                }
            }
            a.this.e = false;
        }
    }

    private class b extends com.baidu.location.g.e {
        public d a;
        private boolean c;

        b() {
            this.c = false;
            this.c = false;
        }

        private void b() {
            if (a.this.a != null) {
                e eVar = new e();
                if (a.this.b != null) {
                    eVar.i = a.this.b.b();
                }
                eVar.a = "param not enough";
                a.this.a.a(false, eVar);
            }
        }

        private String c() {
            float[] d = this.a.e;
            if (d == null || this.a.c == null) {
                return null;
            }
            this.a.b = BitmapFactory.decodeFile(this.a.c);
            if (this.a.b == null) {
                return null;
            }
            String a = IndoorJni.a(a.this.d, this.a.b, this.a.d, d);
            if (a == null) {
                return null;
            }
            try {
                if (!this.a.b.isRecycled()) {
                    this.a.b.recycle();
                }
            } catch (Error e) {
                e.printStackTrace();
            }
            a = a.this.c(a);
            if (a == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(com.baidu.location.g.b.a().a(true));
            stringBuilder.append("&bid=");
            stringBuilder.append(this.a.g);
            stringBuilder.append("&data_type=vps");
            stringBuilder.append("&coor=gcj02");
            if (!(this.a.f == null || this.a.f.equalsIgnoreCase(""))) {
                stringBuilder.append("&code=");
                stringBuilder.append(this.a.f);
            }
            stringBuilder.append("&img=");
            stringBuilder.append(a);
            return stringBuilder.toString();
        }

        public void a() {
            String c = c();
            if (c == null) {
                b();
                this.c = true;
                return;
            }
            c = Jni.encodeTp4(c);
            this.k = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c);
            stringBuilder.append("|tp=4");
            this.k.put("vps", stringBuilder.toString());
        }

        public void a(boolean z) {
            if (!this.c) {
                e eVar;
                if (!z || this.j == null) {
                    eVar = null;
                } else {
                    eVar = new e();
                    if (a.this.b != null) {
                        eVar.i = a.this.b.b();
                    }
                    try {
                        z = eVar.a(new JSONObject(this.j));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (a.this.a != null) {
                    a.this.a.a(z, eVar);
                }
                if (eVar != null) {
                    if (eVar.j <= 0 || a.this.e || z) {
                        a.this.b(this.a.c);
                    } else if (!TextUtils.isEmpty(eVar.k)) {
                        a aVar = new a(a.this, null);
                        aVar.b = eVar.k;
                        aVar.a = this.a;
                        a.this.e = true;
                        a.this.c.execute(aVar);
                    }
                }
            }
        }
    }

    public interface c {
        void a(boolean z, e eVar);
    }

    public static class d {
        private boolean a = false;
        private Bitmap b;
        private String c;
        private double d;
        private float[] e;
        private String f;
        private String g;

        public d a(double d) {
            this.d = d;
            return this;
        }

        public d a(String str) {
            this.c = str;
            return this;
        }

        public d a(boolean z) {
            this.a = z;
            return this;
        }

        public d a(float[] fArr) {
            this.e = (float[]) fArr.clone();
            return this;
        }

        public d b(String str) {
            this.g = str;
            return this;
        }

        public d c(String str) {
            this.f = str;
            return this;
        }
    }

    public static class e {
        public String a;
        public String b;
        public String c;
        public String d;
        public double e;
        public double f;
        public double g;
        public String h;
        public String i;
        public int j = 0;
        public String k;

        public boolean a(JSONObject jSONObject) {
            this.b = jSONObject.optString("bldg");
            this.c = jSONObject.optString("floor");
            this.d = jSONObject.optString("bldgid");
            String optString = jSONObject.optString("indoor");
            JSONObject optJSONObject = jSONObject.optJSONObject("extra");
            if (optJSONObject != null) {
                this.j = optJSONObject.optInt("rpfg");
                this.k = optJSONObject.optString("rpurl");
                if (this.k != null) {
                    this.k = new String(Base64.decode(this.k, 0));
                }
            }
            if (!(optString == null || optString.equalsIgnoreCase("0"))) {
                optString = jSONObject.optString("radius");
                if (optString != null) {
                    this.g = Double.valueOf(optString).doubleValue();
                    jSONObject = jSONObject.optJSONObject("point");
                    if (jSONObject != null) {
                        optString = jSONObject.optString("x");
                        String optString2 = jSONObject.optString("y");
                        if (!(optString.equals("-1.000000") && optString2.equals("-1.000000"))) {
                            this.a = "";
                            this.f = Double.valueOf(optString).doubleValue();
                            this.e = Double.valueOf(optString2).doubleValue();
                            if (optJSONObject != null) {
                                this.h = optJSONObject.optString(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE);
                            }
                            return true;
                        }
                    }
                }
            }
            this.a = "定位失败";
            return false;
        }
    }

    private void a(String str) {
        e eVar = new e();
        eVar.a = str;
        if (this.b != null) {
            eVar.i = this.b.b();
        }
        if (this.a != null) {
            this.a.a(false, eVar);
        }
    }

    private boolean a(String str, String str2) {
        if (this.b == null || !this.b.a()) {
            return false;
        }
        c cVar = null;
        if (this.b != null) {
            cVar = this.b.a(str, str2);
        }
        if (cVar == null) {
            return false;
        }
        e eVar = new e();
        eVar.b = cVar.a();
        eVar.d = cVar.b();
        eVar.c = cVar.d();
        eVar.f = cVar.e();
        eVar.e = cVar.f();
        eVar.h = str2;
        if (this.b != null) {
            eVar.i = this.b.b();
        }
        if (this.a != null) {
            this.a.a(true, eVar);
        }
        return true;
    }

    private void b(d dVar) {
        b bVar = new b();
        bVar.a = dVar;
        bVar.c("https://loc.map.baidu.com/ios_indoorloc");
    }

    private void b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(d dVar) {
        if (dVar.g == null) {
            a("no bid");
            return;
        }
        this.b.a(dVar.g);
        if (dVar.f == null || dVar.a || !a(dVar.g, dVar.f)) {
            b(dVar);
        }
    }
}
