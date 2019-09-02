package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final List<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String pin : strArr) {
                this.pins.add(new Pin(str, pin));
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(Util.immutableList(this.pins), null);
        }
    }

    static final class Pin {
        private static final String WILDCARD = "*.";
        final String canonicalHostname;
        final ByteString hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String str, String str2) {
            StringBuilder stringBuilder;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(str.substring(WILDCARD.length()));
                str = HttpUrl.parse(stringBuilder.toString()).host();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(str);
                str = HttpUrl.parse(stringBuilder.toString()).host();
            }
            this.canonicalHostname = str;
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = ByteString.decodeBase64(str2.substring("sha1/".length()));
            } else if (str2.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                this.hash = ByteString.decodeBase64(str2.substring("sha256/".length()));
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("pins must start with 'sha256/' or 'sha1/': ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (this.hash == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("pins must be base64: ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * (((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode())) + this.hash.hashCode();
        }

        /* Access modifiers changed, original: 0000 */
        public boolean matches(String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            return str.regionMatches(false, str.indexOf(46) + 1, this.canonicalHostname, 0, this.canonicalHostname.length());
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.hashAlgorithm);
            stringBuilder.append(this.hash.base64());
            return stringBuilder.toString();
        }
    }

    private CertificatePinner(List<Pin> list, CertificateChainCleaner certificateChainCleaner) {
        this.pins = list;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sha256/");
            stringBuilder.append(sha256((X509Certificate) certificate).base64());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString sha1(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    static ByteString sha256(X509Certificate x509Certificate) {
        return Util.sha256(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            List list2;
            int i;
            if (this.certificateChainCleaner != null) {
                list2 = this.certificateChainCleaner.clean(list2, str);
            }
            int size = list2.size();
            int i2 = 0;
            for (i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list2.get(i);
                int size2 = findMatchingPins.size();
                Object obj = null;
                Object obj2 = obj;
                for (int i3 = 0; i3 < size2; i3++) {
                    Pin pin = (Pin) findMatchingPins.get(i3);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (obj == null) {
                            obj = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(obj)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Certificate pinning failure!");
            stringBuilder.append("\n  Peer certificate chain:");
            i = list2.size();
            for (int i4 = 0; i4 < i; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list2.get(i4);
                stringBuilder.append("\n    ");
                stringBuilder.append(pin(x509Certificate2));
                stringBuilder.append(": ");
                stringBuilder.append(x509Certificate2.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ");
            stringBuilder.append(str);
            stringBuilder.append(":");
            int size3 = findMatchingPins.size();
            while (i2 < size3) {
                Pin pin2 = (Pin) findMatchingPins.get(i2);
                stringBuilder.append("\n    ");
                stringBuilder.append(pin2);
                i2++;
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }

    /* Access modifiers changed, original: 0000 */
    public List<Pin> findMatchingPins(String str) {
        List emptyList = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    /* Access modifiers changed, original: 0000 */
    public CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner) {
        return this.certificateChainCleaner != certificateChainCleaner ? new CertificatePinner(this.pins, certificateChainCleaner) : this;
    }
}
