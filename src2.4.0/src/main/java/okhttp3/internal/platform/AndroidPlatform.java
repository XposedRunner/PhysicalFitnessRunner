package okhttp3.internal.platform;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;

class AndroidPlatform extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{x509CertificateArr, "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.sslParametersClass = cls;
        this.setUseSessionTickets = optionalMethod;
        this.setHostname = optionalMethod2;
        this.getAlpnSelectedProtocol = optionalMethod3;
        this.setAlpnProtocols = optionalMethod4;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:5:?, code skipped:
            r1 = java.lang.Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
     */
    /* JADX WARNING: Missing block: B:20:0x0055, code skipped:
            return null;
     */
    public static okhttp3.internal.platform.Platform buildIfSupported() {
        /*
        r0 = 0;
        r1 = "com.android.org.conscrypt.SSLParametersImpl";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0009 }
    L_0x0007:
        r3 = r1;
        goto L_0x0010;
    L_0x0009:
        r1 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0055 }
        goto L_0x0007;
    L_0x0010:
        r4 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "setUseSessionTickets";
        r2 = 1;
        r5 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0055 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r7 = 0;
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r4.<init>(r0, r1, r5);	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "setHostname";
        r6 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0055 }
        r8 = java.lang.String.class;
        r6[r7] = r8;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r5.<init>(r0, r1, r6);	 Catch:{ ClassNotFoundException -> 0x0055 }
        r1 = "android.net.Network";
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x004b }
        r1 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x004b }
        r6 = byte[].class;
        r8 = "getAlpnSelectedProtocol";
        r9 = new java.lang.Class[r7];	 Catch:{ ClassNotFoundException -> 0x004b }
        r1.<init>(r6, r8, r9);	 Catch:{ ClassNotFoundException -> 0x004b }
        r6 = new okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x004c }
        r8 = "setAlpnProtocols";
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x004c }
        r9 = byte[].class;
        r2[r7] = r9;	 Catch:{ ClassNotFoundException -> 0x004c }
        r6.<init>(r0, r8, r2);	 Catch:{ ClassNotFoundException -> 0x004c }
        r7 = r6;
        goto L_0x004d;
    L_0x004b:
        r1 = r0;
    L_0x004c:
        r7 = r0;
    L_0x004d:
        r6 = r1;
        r1 = new okhttp3.internal.platform.AndroidPlatform;	 Catch:{ ClassNotFoundException -> 0x0055 }
        r2 = r1;
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ ClassNotFoundException -> 0x0055 }
        return r1;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.AndroidPlatform.buildIfSupported():okhttp3.internal.platform.Platform");
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sSLSocket, Boolean.valueOf(true));
            this.setHostname.invokeOptionalWithoutCheckedException(sSLSocket, str);
        }
        if (this.setAlpnProtocols != null && this.setAlpnProtocols.isSupported(sSLSocket)) {
            this.setAlpnProtocols.invokeWithoutCheckedException(sSLSocket, Platform.concatLengthPrefixed(list));
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (Util.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String str = null;
        if (this.getAlpnSelectedProtocol == null || !this.getAlpnSelectedProtocol.isSupported(sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sSLSocket, new Object[0]);
        if (bArr != null) {
            str = new String(bArr, Util.UTF_8);
        }
        return str;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        try {
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    public void log(int i, String str, Throwable th) {
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(10);
            stringBuilder.append(Log.getStackTraceString(th));
            str = stringBuilder.toString();
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int min;
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + MAX_LOG_LENGTH);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, this.sslParametersClass, "sslParameters");
        if (readFieldOrNull == null) {
            try {
                readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
    }
}
