package com.geetest.sdk;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: GT3Tls12SocketFactory */
public final class O0OOOOO extends SSLSocketFactory {
    private static final String[] O00000Oo = new String[]{"TLSv1.1", "TLSv1.2"};
    final SSLSocketFactory O000000o;

    public O0OOOOO(SSLSocketFactory sSLSocketFactory) {
        this.O000000o = sSLSocketFactory;
    }

    private static Socket O000000o(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(O00000Oo);
        }
        return socket;
    }

    public final Socket createSocket(String str, int i) {
        return O000000o(this.O000000o.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return O000000o(this.O000000o.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return O000000o(this.O000000o.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return O000000o(this.O000000o.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return O000000o(this.O000000o.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.O000000o.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.O000000o.getSupportedCipherSuites();
    }
}
