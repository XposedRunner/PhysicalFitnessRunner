package defpackage;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: SmartDict */
/* renamed from: af */
public class af {
    private static final String O00000Oo = "Ă";
    private final String O000000o = MessageDigestAlgorithms.MD5;
    private Set<Object> O00000o = new HashSet();
    private MessageDigest O00000o0;
    private boolean O00000oO;

    public af(boolean z, String str) {
        int i = 0;
        this.O00000oO = false;
        this.O00000oO = z;
        try {
            this.O00000o0 = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (str == null) {
            return;
        }
        if (z) {
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                while (i < decode.length / 4) {
                    int i2 = 4 * i;
                    this.O00000o.add(Integer.valueOf(((((decode[i2 + 0] & 255) << 24) + ((decode[i2 + 1] & 255) << 16)) + ((decode[i2 + 2] & 255) << 8)) + (decode[i2 + 3] & 255)));
                    i++;
                }
                return;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return;
            }
        }
        String[] split = str.split(O00000Oo);
        int length = split.length;
        while (i < length) {
            this.O00000o.add(split[i]);
            i++;
        }
    }

    private Integer O00000o0(String str) {
        try {
            this.O00000o0.update(str.getBytes());
            byte[] digest = this.O00000o0.digest();
            return Integer.valueOf(((((digest[0] & 255) << 24) + ((digest[1] & 255) << 16)) + ((digest[2] & 255) << 8)) + (digest[3] & 255));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void O000000o() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object append : this.O00000o) {
            stringBuilder.append(append);
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public boolean O000000o(String str) {
        return this.O00000oO ? this.O00000o.contains(O00000o0(str)) : this.O00000o.contains(str);
    }

    public void O00000Oo(String str) {
        if (this.O00000oO) {
            this.O00000o.add(O00000o0(str));
        } else {
            this.O00000o.add(str);
        }
    }

    public String toString() {
        if (this.O00000oO) {
            byte[] bArr = new byte[(this.O00000o.size() * 4)];
            int i = 0;
            for (Integer intValue : this.O00000o) {
                int intValue2 = intValue.intValue();
                int i2 = i + 1;
                bArr[i] = (byte) ((-16777216 & intValue2) >> 24);
                i = i2 + 1;
                bArr[i2] = (byte) ((16711680 & intValue2) >> 16);
                i2 = i + 1;
                bArr[i] = (byte) ((65280 & intValue2) >> 8);
                i = i2 + 1;
                bArr[i2] = (byte) (intValue2 & 255);
            }
            return new String(Base64.encode(bArr, 0));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object next : this.O00000o) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(O00000Oo);
            }
            stringBuilder.append(next.toString());
        }
        return stringBuilder.toString();
    }
}
