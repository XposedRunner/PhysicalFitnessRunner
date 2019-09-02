package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.trustRootIndex = trustRootIndex;
    }

    private boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        int i = 0;
        int i2 = 0;
        while (i < 9) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate findByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(findByIssuerAndSignature)) {
                    arrayList.add(findByIssuerAndSignature);
                }
                if (verifySignature(findByIssuerAndSignature, findByIssuerAndSignature)) {
                    return arrayList;
                }
                i2 = 1;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    findByIssuerAndSignature = (X509Certificate) it.next();
                    if (verifySignature(x509Certificate, findByIssuerAndSignature)) {
                        it.remove();
                        arrayList.add(findByIssuerAndSignature);
                    }
                }
                if (i2 != 0) {
                    return arrayList;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to find a trusted cert that signed ");
                stringBuilder.append(x509Certificate);
                throw new SSLPeerUnverifiedException(stringBuilder.toString());
            }
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Certificate chain too long: ");
        stringBuilder2.append(arrayList);
        throw new SSLPeerUnverifiedException(stringBuilder2.toString());
    }
}
