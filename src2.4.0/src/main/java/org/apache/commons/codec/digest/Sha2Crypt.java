package org.apache.commons.codec.digest;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.Charsets;

public class Sha2Crypt {
    private static final int ROUNDS_DEFAULT = 5000;
    private static final int ROUNDS_MAX = 999999999;
    private static final int ROUNDS_MIN = 1000;
    private static final String ROUNDS_PREFIX = "rounds=";
    private static final Pattern SALT_PATTERN = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");
    private static final int SHA256_BLOCKSIZE = 32;
    static final String SHA256_PREFIX = "$5$";
    private static final int SHA512_BLOCKSIZE = 64;
    static final String SHA512_PREFIX = "$6$";

    public static String sha256Crypt(byte[] bArr) {
        return sha256Crypt(bArr, null);
    }

    public static String sha256Crypt(byte[] bArr, String str) {
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SHA256_PREFIX);
            stringBuilder.append(B64.getRandomSalt(8));
            str = stringBuilder.toString();
        }
        return sha2Crypt(bArr, str, SHA256_PREFIX, 32, MessageDigestAlgorithms.SHA_256);
    }

    private static String sha2Crypt(byte[] bArr, String str, String str2, int i, String str3) {
        byte[] bArr2 = bArr;
        String str4 = str;
        int i2 = i;
        int length = bArr2.length;
        if (str4 == null) {
            throw new IllegalArgumentException("Salt must not be null");
        }
        Matcher matcher = SALT_PATTERN.matcher(str4);
        if (matcher == null || !matcher.find()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid salt value: ");
            stringBuilder.append(str4);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int max;
        int i3;
        byte[] bArr3;
        byte b;
        if (matcher.group(3) != null) {
            max = Math.max(1000, Math.min(ROUNDS_MAX, Integer.parseInt(matcher.group(3))));
            i3 = 1;
        } else {
            max = ROUNDS_DEFAULT;
            i3 = 0;
        }
        String group = matcher.group(4);
        byte[] bytes = group.getBytes(Charsets.UTF_8);
        int length2 = bytes.length;
        MessageDigest digest = DigestUtils.getDigest(str3);
        digest.update(bArr2);
        digest.update(bytes);
        MessageDigest digest2 = DigestUtils.getDigest(str3);
        digest2.update(bArr2);
        digest2.update(bytes);
        digest2.update(bArr2);
        byte[] digest3 = digest2.digest();
        int length3 = bArr2.length;
        while (length3 > i2) {
            digest.update(digest3, 0, i2);
            length3 -= i2;
        }
        digest.update(digest3, 0, length3);
        for (length3 = bArr2.length; length3 > 0; length3 >>= 1) {
            if ((length3 & 1) != 0) {
                digest.update(digest3, 0, i2);
            } else {
                digest.update(bArr2);
            }
        }
        digest3 = digest.digest();
        MessageDigest digest4 = DigestUtils.getDigest(str3);
        for (int i4 = 1; i4 <= length; i4++) {
            digest4.update(bArr2);
        }
        byte[] digest5 = digest4.digest();
        byte[] bArr4 = new byte[length];
        int i5 = 0;
        while (i5 < length - i2) {
            System.arraycopy(digest5, 0, bArr4, i5, i2);
            i5 += i2;
        }
        System.arraycopy(digest5, 0, bArr4, i5, length - i5);
        MessageDigest digest6 = DigestUtils.getDigest(str3);
        for (int i6 = 1; i6 <= 16 + (digest3[0] & 255); i6++) {
            digest6.update(bytes);
        }
        byte[] digest7 = digest6.digest();
        digest5 = new byte[length2];
        int i7 = 0;
        MessageDigest messageDigest = digest;
        while (i7 < length2 - i2) {
            System.arraycopy(digest7, 0, digest5, i7, i2);
            i7 += i2;
        }
        System.arraycopy(digest7, 0, digest5, i7, length2 - i7);
        i7 = 0;
        digest = messageDigest;
        while (i7 <= max - 1) {
            int i8;
            digest = DigestUtils.getDigest(str3);
            int i9 = i7 & 1;
            if (i9 != 0) {
                bArr3 = bytes;
                i8 = 0;
                digest.update(bArr4, 0, length);
            } else {
                bArr3 = bytes;
                i8 = 0;
                digest.update(digest3, 0, i2);
            }
            if (i7 % 3 != 0) {
                digest.update(digest5, i8, length2);
            }
            if (i7 % 7 != 0) {
                digest.update(bArr4, i8, length);
            }
            if (i9 != 0) {
                digest.update(digest3, i8, i2);
            } else {
                digest.update(bArr4, i8, length);
            }
            digest3 = digest.digest();
            i7++;
            bytes = bArr3;
        }
        bArr3 = bytes;
        StringBuilder stringBuilder2 = new StringBuilder(str2);
        if (i3 != 0) {
            stringBuilder2.append(ROUNDS_PREFIX);
            stringBuilder2.append(max);
            stringBuilder2.append("$");
        }
        stringBuilder2.append(group);
        stringBuilder2.append("$");
        if (i2 == 32) {
            B64.b64from24bit(digest3[0], digest3[10], digest3[20], 4, stringBuilder2);
            B64.b64from24bit(digest3[21], digest3[1], digest3[11], 4, stringBuilder2);
            B64.b64from24bit(digest3[12], digest3[22], digest3[2], 4, stringBuilder2);
            B64.b64from24bit(digest3[3], digest3[13], digest3[23], 4, stringBuilder2);
            B64.b64from24bit(digest3[24], digest3[4], digest3[14], 4, stringBuilder2);
            B64.b64from24bit(digest3[15], digest3[25], digest3[5], 4, stringBuilder2);
            B64.b64from24bit(digest3[6], digest3[16], digest3[26], 4, stringBuilder2);
            B64.b64from24bit(digest3[27], digest3[7], digest3[17], 4, stringBuilder2);
            B64.b64from24bit(digest3[18], digest3[28], digest3[8], 4, stringBuilder2);
            B64.b64from24bit(digest3[9], digest3[19], digest3[29], 4, stringBuilder2);
            B64.b64from24bit((byte) 0, digest3[31], digest3[30], 3, stringBuilder2);
            b = (byte) 0;
        } else {
            B64.b64from24bit(digest3[0], digest3[21], digest3[42], 4, stringBuilder2);
            B64.b64from24bit(digest3[22], digest3[43], digest3[1], 4, stringBuilder2);
            B64.b64from24bit(digest3[44], digest3[2], digest3[23], 4, stringBuilder2);
            B64.b64from24bit(digest3[3], digest3[24], digest3[45], 4, stringBuilder2);
            B64.b64from24bit(digest3[25], digest3[46], digest3[4], 4, stringBuilder2);
            B64.b64from24bit(digest3[47], digest3[5], digest3[26], 4, stringBuilder2);
            B64.b64from24bit(digest3[6], digest3[27], digest3[48], 4, stringBuilder2);
            B64.b64from24bit(digest3[28], digest3[49], digest3[7], 4, stringBuilder2);
            B64.b64from24bit(digest3[50], digest3[8], digest3[29], 4, stringBuilder2);
            B64.b64from24bit(digest3[9], digest3[30], digest3[51], 4, stringBuilder2);
            B64.b64from24bit(digest3[31], digest3[52], digest3[10], 4, stringBuilder2);
            B64.b64from24bit(digest3[53], digest3[11], digest3[32], 4, stringBuilder2);
            B64.b64from24bit(digest3[12], digest3[33], digest3[54], 4, stringBuilder2);
            B64.b64from24bit(digest3[34], digest3[55], digest3[13], 4, stringBuilder2);
            B64.b64from24bit(digest3[56], digest3[14], digest3[35], 4, stringBuilder2);
            B64.b64from24bit(digest3[15], digest3[36], digest3[57], 4, stringBuilder2);
            B64.b64from24bit(digest3[37], digest3[58], digest3[16], 4, stringBuilder2);
            B64.b64from24bit(digest3[59], digest3[17], digest3[38], 4, stringBuilder2);
            B64.b64from24bit(digest3[18], digest3[39], digest3[60], 4, stringBuilder2);
            B64.b64from24bit(digest3[40], digest3[61], digest3[19], 4, stringBuilder2);
            B64.b64from24bit(digest3[62], digest3[20], digest3[41], 4, stringBuilder2);
            b = (byte) 0;
            B64.b64from24bit((byte) 0, (byte) 0, digest3[63], 2, stringBuilder2);
        }
        Arrays.fill(digest7, b);
        Arrays.fill(bArr4, b);
        Arrays.fill(digest5, b);
        digest.reset();
        digest6.reset();
        Arrays.fill(bArr2, b);
        Arrays.fill(bArr3, b);
        return stringBuilder2.toString();
    }

    public static String sha512Crypt(byte[] bArr) {
        return sha512Crypt(bArr, null);
    }

    public static String sha512Crypt(byte[] bArr, String str) {
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SHA512_PREFIX);
            stringBuilder.append(B64.getRandomSalt(8));
            str = stringBuilder.toString();
        }
        return sha2Crypt(bArr, str, SHA512_PREFIX, 64, MessageDigestAlgorithms.SHA_512);
    }
}
