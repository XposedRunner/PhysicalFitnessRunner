package com.google.zxing.aztec.decoder;

import cn.jiguang.net.HttpUtils;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.tencent.connect.common.Constants;
import java.util.Arrays;

public final class Decoder {
    private static final String[] DIGIT_TABLE = new String[]{"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = new String[]{"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = new String[]{"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", HttpUtils.PARAMETERS_SEPARATOR, "'", "(", ")", "*", "+", ",", "-", ".", HttpUtils.PATHS_SEPARATOR, ":", ";", "<", HttpUtils.EQUAL_SIGN, ">", HttpUtils.URL_AND_PARA_SEPARATOR, "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = new String[]{"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private AztecDetectorResult ddata;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int i2 = length - nbDatablocks;
        int[] iArr = new int[length];
        int length2 = zArr.length % i;
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = readCode(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, i2);
            int i4 = (1 << i) - 1;
            length = 0;
            i3 = length;
            while (length < nbDatablocks) {
                i2 = iArr[length];
                if (i2 == 0 || i2 == i4) {
                    throw FormatException.getFormatInstance();
                }
                if (i2 == 1 || i2 == i4 - 1) {
                    i3++;
                }
                length++;
            }
            boolean[] zArr2 = new boolean[((nbDatablocks * i) - i3)];
            i3 = 0;
            i2 = i3;
            while (i3 < nbDatablocks) {
                length2 = iArr[i3];
                if (length2 == 1 || length2 == i4 - 1) {
                    Arrays.fill(zArr2, i2, (i2 + i) - 1, length2 > 1);
                    i2 += i - 1;
                } else {
                    int i5 = i - 1;
                    while (i5 >= 0) {
                        int i6 = i2 + 1;
                        zArr2[i2] = ((1 << i5) & length2) != 0;
                        i5--;
                        i2 = i6;
                    }
                }
                i3++;
            }
            return zArr2;
        } catch (ReedSolomonException e) {
            throw FormatException.getFormatInstance(e);
        }
    }

    private static String getCharacter(Table table, int i) {
        switch (table) {
            case UPPER:
                return UPPER_TABLE[i];
            case LOWER:
                return LOWER_TABLE[i];
            case MIXED:
                return MIXED_TABLE[i];
            case PUNCT:
                return PUNCT_TABLE[i];
            case DIGIT:
                return DIGIT_TABLE[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder stringBuilder = new StringBuilder(20);
        int i = 0;
        while (i < length) {
            int i2;
            if (table2 != Table.BINARY) {
                i2 = table2 == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int readCode = readCode(zArr, i, i2);
                i += i2;
                String character = getCharacter(table2, readCode);
                if (character.startsWith("CTRL_")) {
                    Table table3 = getTable(character.charAt(5));
                    if (character.charAt(6) == 'L') {
                        table = table3;
                    } else {
                        table2 = table3;
                    }
                } else {
                    stringBuilder.append(character);
                }
            } else if (length - i < 5) {
                break;
            } else {
                int readCode2 = readCode(zArr, i, 5);
                i += 5;
                if (readCode2 == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    readCode2 = readCode(zArr, i, 11) + 31;
                    i += 11;
                }
                i2 = i;
                for (i = 0; i < readCode2; i++) {
                    if (length - i2 < 8) {
                        i = length;
                        break;
                    }
                    stringBuilder.append((char) readCode(zArr, i2, 8));
                    i2 += 8;
                }
                i = i2;
            }
            table2 = table;
        }
        return stringBuilder.toString();
    }

    private static Table getTable(char c) {
        if (c == 'B') {
            return Table.BINARY;
        }
        if (c == 'D') {
            return Table.DIGIT;
        }
        if (c == 'P') {
            return Table.PUNCT;
        }
        switch (c) {
            case 'L':
                return Table.LOWER;
            case 'M':
                return Table.MIXED;
            default:
                return Table.UPPER;
        }
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (16 * i)) * i;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        return new DecoderResult(null, getEncodedData(correctBits(extractBits(aztecDetectorResult.getBits()))), null, null);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean[] extractBits(BitMatrix bitMatrix) {
        int i;
        int i2;
        int i3;
        int i4;
        BitMatrix bitMatrix2 = bitMatrix;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i5 = (isCompact ? 11 : 14) + (nbLayers * 4);
        int[] iArr = new int[i5];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i6 = 2;
        if (isCompact) {
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
        } else {
            i2 = i5 / 2;
            i = ((i5 + 1) + (((i2 - 1) / 15) * 2)) / 2;
            for (i3 = 0; i3 < i2; i3++) {
                i4 = (i3 / 15) + i3;
                iArr[(i2 - i3) - 1] = (i - i4) - 1;
                iArr[i2 + i3] = (i4 + i) + 1;
            }
        }
        i = 0;
        i2 = 0;
        while (i < nbLayers) {
            i4 = isCompact ? ((nbLayers - i) * 4) + 9 : ((nbLayers - i) * 4) + 12;
            int i7 = i * 2;
            int i8 = (i5 - 1) - i7;
            int i9 = 0;
            while (i9 < i4) {
                int i10 = i9 * 2;
                int i11 = 0;
                for (i6 = 
/*
Method generation error in method: com.google.zxing.aztec.decoder.Decoder.extractBits(com.google.zxing.common.BitMatrix):boolean[], dex: 
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r8_2 'i6' int) = (r8_1 'i6' int), (r8_12 'i6' int) binds: {(r8_1 'i6' int)=B:20:0x0066, (r8_12 'i6' int)=B:25:0x00c2} in method: com.google.zxing.aztec.decoder.Decoder.extractBits(com.google.zxing.common.BitMatrix):boolean[], dex: 
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:185)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 25 more

*/
}
