package com.geetest.deepknow.utils;

import com.bangcle.andJni.JniLib1557756502;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: DPHttpUtils */
public class c {

    /* compiled from: DPHttpUtils */
    private static class a implements X509TrustManager {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            JniLib1557756502.cV(this, x509CertificateArr, str, Integer.valueOf(71));
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            JniLib1557756502.cV(this, x509CertificateArr, str, Integer.valueOf(72));
        }

        public X509Certificate[] getAcceptedIssuers() {
            return (X509Certificate[]) JniLib1557756502.cL(this, Integer.valueOf(73));
        }
    }

    private static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inputStream.close();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static String a(String str, byte[] bArr, int i) {
        return (String) JniLib1557756502.cL(str, bArr, Integer.valueOf(i), Integer.valueOf(74));
    }

    private static URL a(String str) {
        return (URL) JniLib1557756502.cL(str, Integer.valueOf(75));
    }
}
