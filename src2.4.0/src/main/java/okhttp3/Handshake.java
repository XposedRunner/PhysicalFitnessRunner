package okhttp3;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake {
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final List<Certificate> peerCertificates;
    private final TlsVersion tlsVersion;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.peerCertificates = list;
        this.localCertificates = list2;
    }

    public static Handshake get(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        Object[] peerCertificates;
        TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List immutableList = peerCertificates != null ? Util.immutableList(peerCertificates) : Collections.emptyList();
        Object[] localCertificates = sSLSession.getLocalCertificates();
        return new Handshake(forJavaName2, forJavaName, immutableList, localCertificates != null ? Util.immutableList(localCertificates) : Collections.emptyList());
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, Util.immutableList((List) list), Util.immutableList((List) list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    public CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (Util.equal(this.cipherSuite, handshake.cipherSuite) && this.cipherSuite.equals(handshake.cipherSuite) && this.peerCertificates.equals(handshake.peerCertificates) && this.localCertificates.equals(handshake.localCertificates)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (31 * (((((527 + (this.tlsVersion != null ? this.tlsVersion.hashCode() : 0)) * 31) + this.cipherSuite.hashCode()) * 31) + this.peerCertificates.hashCode())) + this.localCertificates.hashCode();
    }

    public List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public Principal localPrincipal() {
        return !this.localCertificates.isEmpty() ? ((X509Certificate) this.localCertificates.get(0)).getSubjectX500Principal() : null;
    }

    public List<Certificate> peerCertificates() {
        return this.peerCertificates;
    }

    public Principal peerPrincipal() {
        return !this.peerCertificates.isEmpty() ? ((X509Certificate) this.peerCertificates.get(0)).getSubjectX500Principal() : null;
    }

    public TlsVersion tlsVersion() {
        return this.tlsVersion;
    }
}
