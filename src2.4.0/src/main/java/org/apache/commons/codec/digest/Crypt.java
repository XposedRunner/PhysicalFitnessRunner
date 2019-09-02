package org.apache.commons.codec.digest;

import org.apache.commons.codec.Charsets;

public class Crypt {
    public static String crypt(String str) {
        return crypt(str, null);
    }

    public static String crypt(String str, String str2) {
        return crypt(str.getBytes(Charsets.UTF_8), str2);
    }

    public static String crypt(byte[] bArr) {
        return crypt(bArr, null);
    }

    public static String crypt(byte[] bArr, String str) {
        return str == null ? Sha2Crypt.sha512Crypt(bArr) : str.startsWith("$6$") ? Sha2Crypt.sha512Crypt(bArr, str) : str.startsWith("$5$") ? Sha2Crypt.sha256Crypt(bArr, str) : str.startsWith("$1$") ? Md5Crypt.md5Crypt(bArr, str) : UnixCrypt.crypt(bArr, str);
    }
}
