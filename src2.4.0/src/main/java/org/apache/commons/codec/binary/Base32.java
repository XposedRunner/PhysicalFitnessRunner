package org.apache.commons.codec.binary;

import com.umeng.commonsdk.proguard.ap;
import jp.co.cyberagent.android.gpuimage.O000000o;

public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = new byte[]{ap.k, (byte) 10};
    private static final byte[] DECODE_TABLE = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, ap.k, ap.l, ap.m, ap.n, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25};
    private static final byte[] ENCODE_TABLE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55};
    private static final byte[] HEX_DECODE_TABLE = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 10, (byte) 11, (byte) 12, ap.k, ap.l, ap.m, ap.n, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32};
    private static final byte[] HEX_ENCODE_TABLE = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86};
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        super(5, 8, i, bArr == null ? 0 : bArr.length);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        StringBuilder stringBuilder;
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("lineLength ");
            stringBuilder.append(i);
            stringBuilder.append(" > 0, but lineSeparator is null");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            stringBuilder = new StringBuilder();
            stringBuilder.append("lineSeparator must not contain Base32 characters: [");
            stringBuilder.append(newStringUtf8);
            stringBuilder.append("]");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            this.encodeSize = 8 + bArr.length;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        }
        this.decodeSize = this.encodeSize - 1;
    }

    public Base32(boolean z) {
        this(0, null, z);
    }

    /* Access modifiers changed, original: 0000 */
    public void decode(byte[] bArr, int i, int i2, Context context) {
        int i3 = i2;
        Context context2 = context;
        if (!context2.eof) {
            int i4 = 1;
            if (i3 < 0) {
                context2.eof = true;
            }
            int i5 = 0;
            int i6 = i;
            while (i5 < i3) {
                int i7 = i6 + 1;
                byte b = bArr[i6];
                if (b == (byte) 61) {
                    context2.eof = i4;
                    break;
                }
                int i8;
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context2);
                if (b >= (byte) 0 && b < this.decodeTable.length) {
                    b = this.decodeTable[b];
                    if (b >= (byte) 0) {
                        context2.modulus = (context2.modulus + i4) % 8;
                        i8 = i5;
                        context2.lbitWorkArea = (context2.lbitWorkArea << 5) + ((long) b);
                        if (context2.modulus == 0) {
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) ((int) ((context2.lbitWorkArea >> 32) & 255));
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) ((int) ((context2.lbitWorkArea >> 24) & 255));
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) ((int) (context2.lbitWorkArea & 255));
                        }
                        i5 = i8 + 1;
                        i6 = i7;
                        i4 = 1;
                    }
                }
                i8 = i5;
                i5 = i8 + 1;
                i6 = i7;
                i4 = 1;
            }
            if (context2.eof && context2.modulus >= 2) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context2);
                switch (context2.modulus) {
                    case 2:
                        i5 = context2.pos;
                        context2.pos = i5 + 1;
                        ensureBufferSize2[i5] = (byte) ((int) ((context2.lbitWorkArea >> 2) & 255));
                        break;
                    case 3:
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 7) & 255));
                        break;
                    case 4:
                        context2.lbitWorkArea >>= 4;
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) (context2.lbitWorkArea & 255));
                        break;
                    case 5:
                        context2.lbitWorkArea >>= 1;
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) (context2.lbitWorkArea & 255));
                        break;
                    case 6:
                        context2.lbitWorkArea >>= 6;
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) (context2.lbitWorkArea & 255));
                        break;
                    case 7:
                        context2.lbitWorkArea >>= 3;
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 24) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 16) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) ((context2.lbitWorkArea >> 8) & 255));
                        i4 = context2.pos;
                        context2.pos = i4 + 1;
                        ensureBufferSize2[i4] = (byte) ((int) (context2.lbitWorkArea & 255));
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Impossible modulus ");
                        stringBuilder.append(context2.modulus);
                        throw new IllegalStateException(stringBuilder.toString());
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void encode(byte[] bArr, int i, int i2, Context context) {
        int i3 = i2;
        Context context2 = context;
        if (!context2.eof) {
            int i4 = 1;
            int i5;
            int i6;
            if (i3 < 0) {
                context2.eof = true;
                if (context2.modulus != 0 || this.lineLength != 0) {
                    byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context2);
                    i5 = context2.pos;
                    switch (context2.modulus) {
                        case 0:
                            break;
                        case 1:
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 3)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea << 2)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            break;
                        case 2:
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea >> 11)) & 31];
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea >> 6)) & 31];
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea >> 1)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea << 4)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            break;
                        case 3:
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea >> 19)) & 31];
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea >> 14)) & 31];
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea >> 9)) & 31];
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea >> 4)) & 31];
                            i6 = context2.pos;
                            context2.pos = i6 + 1;
                            ensureBufferSize[i6] = this.encodeTable[((int) (context2.lbitWorkArea << 1)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            break;
                        case 4:
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 27)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 22)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 17)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 12)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 7)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 2)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = this.encodeTable[((int) (context2.lbitWorkArea << 3)) & 31];
                            i4 = context2.pos;
                            context2.pos = i4 + 1;
                            ensureBufferSize[i4] = (byte) 61;
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Impossible modulus ");
                            stringBuilder.append(context2.modulus);
                            throw new IllegalStateException(stringBuilder.toString());
                    }
                    context2.currentLinePos += context2.pos - i5;
                    if (this.lineLength > 0 && context2.currentLinePos > 0) {
                        System.arraycopy(this.lineSeparator, 0, ensureBufferSize, context2.pos, this.lineSeparator.length);
                        context2.pos += this.lineSeparator.length;
                    }
                } else {
                    return;
                }
            }
            i6 = i;
            i5 = 0;
            while (i5 < i3) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context2);
                context2.modulus = (context2.modulus + i4) % 5;
                int i7 = i6 + 1;
                i6 = bArr[i6];
                if (i6 < 0) {
                    i6 += O000000o.O00000oO;
                }
                int i8 = i5;
                context2.lbitWorkArea = (context2.lbitWorkArea << 8) + ((long) i6);
                if (context2.modulus == 0) {
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 35)) & 31];
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 30)) & 31];
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 25)) & 31];
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 20)) & 31];
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 15)) & 31];
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 10)) & 31];
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) (context2.lbitWorkArea >> 5)) & 31];
                    i4 = context2.pos;
                    context2.pos = i4 + 1;
                    ensureBufferSize2[i4] = this.encodeTable[((int) context2.lbitWorkArea) & 31];
                    context2.currentLinePos += 8;
                    if (this.lineLength > 0 && this.lineLength <= context2.currentLinePos) {
                        System.arraycopy(this.lineSeparator, 0, ensureBufferSize2, context2.pos, this.lineSeparator.length);
                        context2.pos += this.lineSeparator.length;
                        context2.currentLinePos = 0;
                    }
                }
                i5 = i8 + 1;
                i6 = i7;
                i4 = 1;
            }
        }
    }

    public boolean isInAlphabet(byte b) {
        return b >= (byte) 0 && b < this.decodeTable.length && this.decodeTable[b] != (byte) -1;
    }
}
