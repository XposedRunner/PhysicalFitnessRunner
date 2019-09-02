package com.google.zxing.qrcode.encoder;

final class MaskUtil {
    private static final int N1 = 3;
    private static final int N2 = 3;
    private static final int N3 = 40;
    private static final int N4 = 10;

    private MaskUtil() {
    }

    static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i = 0;
        int i2 = i;
        while (i < height) {
            int i3 = i2;
            byte b = (byte) -1;
            i2 = 0;
            int i4 = i2;
            while (i2 < width) {
                byte b2 = z ? array[i][i2] : array[i2][i];
                if (b2 == b) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += 3 + (i4 - 5);
                    }
                    i4 = 1;
                    b = b2;
                }
                i2++;
            }
            if (i4 >= 5) {
                i3 += 3 + (i4 - 5);
            }
            i2 = i3;
            i++;
        }
        return i2;
    }

    static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = i;
        while (i < height - 1) {
            int i3 = i2;
            i2 = 0;
            while (i2 < width - 1) {
                byte b = array[i][i2];
                int i4 = i2 + 1;
                if (b == array[i][i4]) {
                    int i5 = i + 1;
                    if (b == array[i5][i2] && b == array[i5][i4]) {
                        i3++;
                    }
                }
                i2 = i4;
            }
            i++;
            i2 = i3;
        }
        return 3 * i2;
    }

    static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = i;
        while (i < height) {
            int i3 = i2;
            i2 = 0;
            while (i2 < width) {
                byte[] bArr = array[i];
                int i4 = i2 + 6;
                if (i4 < width && bArr[i2] == (byte) 1 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 1 && bArr[i2 + 3] == (byte) 1 && bArr[i2 + 4] == (byte) 1 && bArr[i2 + 5] == (byte) 0 && bArr[i4] == (byte) 1 && (isWhiteHorizontal(bArr, i2 - 4, i2) || isWhiteHorizontal(bArr, i2 + 7, i2 + 11))) {
                    i3++;
                }
                int i5 = i + 6;
                if (i5 < height && array[i][i2] == (byte) 1 && array[i + 1][i2] == (byte) 0 && array[i + 2][i2] == (byte) 1 && array[i + 3][i2] == (byte) 1 && array[i + 4][i2] == (byte) 1 && array[i + 5][i2] == (byte) 0 && array[i5][i2] == (byte) 1 && (isWhiteVertical(array, i2, i - 4, i) || isWhiteVertical(array, i2, i + 7, i + 11))) {
                    i3++;
                }
                i2++;
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = i;
        while (i < height) {
            byte[] bArr = array[i];
            int i3 = i2;
            for (i2 = 0; i2 < width; i2++) {
                if (bArr[i2] == (byte) 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i2 * 2) - height2) * 10) / height2) * 10;
    }

    static boolean getDataMaskBit(int i, int i2, int i3) {
        switch (i) {
            case 0:
                i = (i3 + i2) & 1;
                break;
            case 1:
                i = i3 & 1;
                break;
            case 2:
                i = i2 % 3;
                break;
            case 3:
                i = (i3 + i2) % 3;
                break;
            case 4:
                i = ((i3 / 2) + (i2 / 3)) & 1;
                break;
            case 5:
                i3 *= i2;
                i = (i3 & 1) + (i3 % 3);
                break;
            case 6:
                i3 *= i2;
                i = ((i3 & 1) + (i3 % 3)) & 1;
                break;
            case 7:
                i = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid mask pattern: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        return i == 0;
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (i >= 0 && i < bArr.length && bArr[i] == (byte) 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2][i] == (byte) 1) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
