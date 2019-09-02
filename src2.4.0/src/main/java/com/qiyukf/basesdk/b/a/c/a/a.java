package com.qiyukf.basesdk.b.a.c.a;

import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class a implements X509TrustManager {
    private static SSLSocketFactory b;
    private X509TrustManager a = null;

    private a() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                this.a = (X509TrustManager) trustManager;
                break;
            }
        }
        if (this.a == null) {
            throw new NoSuchAlgorithmException("no trust manager found");
        }
    }

    public static SSLSocketFactory a() {
        if (b == null) {
            SSLSocketFactory b = b();
            b = b;
            if (b == null) {
                b = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        }
        return b;
    }

    private static SSLSocketFactory b() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{new a()}, null);
            return instance.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.a.checkClientTrusted(x509CertificateArr, str);
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (x509CertificateArr == null || x509CertificateArr.length != 1) {
            this.a.checkServerTrusted(x509CertificateArr, str);
        } else {
            x509CertificateArr[0].checkValidity();
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
