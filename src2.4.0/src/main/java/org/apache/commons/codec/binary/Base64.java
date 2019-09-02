package org.apache.commons.codec.binary;

import com.umeng.commonsdk.proguard.ap;
import java.math.BigInteger;
import jp.co.cyberagent.android.gpuimage.O000000o;

public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR = new byte[]{ap.k, (byte) 10};
    private static final byte[] DECODE_TABLE = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) 62, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, ap.k, ap.l, ap.m, ap.n, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51};
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base64() {
        this(0);
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.decodeTable = DECODE_TABLE;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lineSeparator must not contain base64 characters: [");
            stringBuilder.append(newStringUtf8);
            stringBuilder.append("]");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i > 0) {
            this.encodeSize = 4 + bArr.length;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i)) {
            return base64.encode(bArr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Input array too big, the output array would be bigger (");
        stringBuilder.append(encodedLength);
        stringBuilder.append(") than the specified maximum size of ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        return b == (byte) 61 || (b >= (byte) 0 && b < DECODE_TABLE.length && DECODE_TABLE[b] != (byte) -1);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public static boolean isBase64(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            if (!isBase64(bArr[i]) && !BaseNCodec.isWhiteSpace(bArr[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] toByteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return toByteArray;
        }
        int i = 0;
        int length = toByteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
            i = 1;
        }
        bitLength /= 8;
        int i2 = bitLength - length;
        byte[] bArr = new byte[bitLength];
        System.arraycopy(toByteArray, i, bArr, i2, length);
        return bArr;
    }

    /* Access modifiers changed, original: 0000 */
    public void decode(byte[] bArr, int i, int i2, Context context) {
        if (!context.eof) {
            if (i2 < 0) {
                context.eof = true;
            }
            int i3 = 0;
            while (i3 < i2) {
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                int i4 = i + 1;
                byte b = bArr[i];
                if (b == (byte) 61) {
                    context.eof = true;
                    break;
                }
                if (b >= (byte) 0 && b < DECODE_TABLE.length) {
                    b = DECODE_TABLE[b];
                    if (b >= (byte) 0) {
                        context.modulus = (context.modulus + 1) % 4;
                        context.ibitWorkArea = (context.ibitWorkArea << 6) + b;
                        if (context.modulus == 0) {
                            i = context.pos;
                            context.pos = i + 1;
                            ensureBufferSize[i] = (byte) ((context.ibitWorkArea >> 16) & 255);
                            i = context.pos;
                            context.pos = i + 1;
                            ensureBufferSize[i] = (byte) ((context.ibitWorkArea >> 8) & 255);
                            i = context.pos;
                            context.pos = i + 1;
                            ensureBufferSize[i] = (byte) (context.ibitWorkArea & 255);
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (context.eof && context.modulus != 0) {
                bArr = ensureBufferSize(this.decodeSize, context);
                switch (context.modulus) {
                    case 1:
                        break;
                    case 2:
                        context.ibitWorkArea >>= 4;
                        i = context.pos;
                        context.pos = i + 1;
                        bArr[i] = (byte) (context.ibitWorkArea & 255);
                        break;
                    case 3:
                        context.ibitWorkArea >>= 2;
                        i = context.pos;
                        context.pos = i + 1;
                        bArr[i] = (byte) ((context.ibitWorkArea >> 8) & 255);
                        i = context.pos;
                        context.pos = i + 1;
                        bArr[i] = (byte) (context.ibitWorkArea & 255);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Impossible modulus ");
                        stringBuilder.append(context.modulus);
                        throw new IllegalStateException(stringBuilder.toString());
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void encode(byte[] bArr, int i, int i2, Context context) {
        if (!context.eof) {
            if (i2 < 0) {
                context.eof = true;
                if (context.modulus != 0 || this.lineLength != 0) {
                    bArr = ensureBufferSize(this.encodeSize, context);
                    i = context.pos;
                    switch (context.modulus) {
                        case 0:
                            break;
                        case 1:
                            i2 = context.pos;
                            context.pos = i2 + 1;
                            bArr[i2] = this.encodeTable[(context.ibitWorkArea >> 2) & 63];
                            i2 = context.pos;
                            context.pos = i2 + 1;
                            bArr[i2] = this.encodeTable[(context.ibitWorkArea << 4) & 63];
                            if (this.encodeTable == STANDARD_ENCODE_TABLE) {
                                i2 = context.pos;
                                context.pos = i2 + 1;
                                bArr[i2] = (byte) 61;
                                i2 = context.pos;
                                context.pos = i2 + 1;
                                bArr[i2] = (byte) 61;
                                break;
                            }
                            break;
                        case 2:
                            i2 = context.pos;
                            context.pos = i2 + 1;
                            bArr[i2] = this.encodeTable[(context.ibitWorkArea >> 10) & 63];
                            i2 = context.pos;
                            context.pos = i2 + 1;
                            bArr[i2] = this.encodeTable[(context.ibitWorkArea >> 4) & 63];
                            i2 = context.pos;
                            context.pos = i2 + 1;
                            bArr[i2] = this.encodeTable[(context.ibitWorkArea << 2) & 63];
                            if (this.encodeTable == STANDARD_ENCODE_TABLE) {
                                i2 = context.pos;
                                context.pos = i2 + 1;
                                bArr[i2] = (byte) 61;
                                break;
                            }
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Impossible modulus ");
                            stringBuilder.append(context.modulus);
                            throw new IllegalStateException(stringBuilder.toString());
                    }
                    context.currentLinePos += context.pos - i;
                    if (this.lineLength > 0 && context.currentLinePos > 0) {
                        System.arraycopy(this.lineSeparator, 0, bArr, context.pos, this.lineSeparator.length);
                        context.pos += this.lineSeparator.length;
                    }
                } else {
                    return;
                }
            }
            int i3 = i;
            i = 0;
            while (i < i2) {
                byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                context.modulus = (context.modulus + 1) % 3;
                int i4 = i3 + 1;
                i3 = bArr[i3];
                if (i3 < 0) {
                    i3 += O000000o.O00000oO;
                }
                context.ibitWorkArea = (context.ibitWorkArea << 8) + i3;
                if (context.modulus == 0) {
                    i3 = context.pos;
                    context.pos = i3 + 1;
                    ensureBufferSize[i3] = this.encodeTable[(context.ibitWorkArea >> 18) & 63];
                    i3 = context.pos;
                    context.pos = i3 + 1;
                    ensureBufferSize[i3] = this.encodeTable[(context.ibitWorkArea >> 12) & 63];
                    i3 = context.pos;
                    context.pos = i3 + 1;
                    ensureBufferSize[i3] = this.encodeTable[(context.ibitWorkArea >> 6) & 63];
                    i3 = context.pos;
                    context.pos = i3 + 1;
                    ensureBufferSize[i3] = this.encodeTable[context.ibitWorkArea & 63];
                    context.currentLinePos += 4;
                    if (this.lineLength > 0 && this.lineLength <= context.currentLinePos) {
                        System.arraycopy(this.lineSeparator, 0, ensureBufferSize, context.pos, this.lineSeparator.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i++;
                i3 = i4;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean isInAlphabet(byte b) {
        return b >= (byte) 0 && b < this.decodeTable.length && this.decodeTable[b] != (byte) -1;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }
}
