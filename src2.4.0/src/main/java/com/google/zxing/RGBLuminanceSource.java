package com.google.zxing;

public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2);
        this.dataWidth = i;
        this.dataHeight = i2;
        this.left = 0;
        this.top = 0;
        this.luminances = new byte[(i * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + i5;
                int i7 = iArr[i6];
                int i8 = (i7 >> 16) & 255;
                int i9 = (i7 >> 8) & 255;
                i7 &= 255;
                if (i8 == i9 && i9 == i7) {
                    this.luminances[i6] = (byte) i8;
                } else {
                    this.luminances[i6] = (byte) (((i8 + (2 * i9)) + i7) / 4);
                }
            }
        }
    }

    private RGBLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.luminances = bArr;
        this.dataWidth = i;
        this.dataHeight = i2;
        this.left = i3;
        this.top = i4;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i, this.top + i2, i3, i4);
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.dataWidth && height == this.dataHeight) {
            return this.luminances;
        }
        int i = width * height;
        byte[] bArr = new byte[i];
        int i2 = (this.top * this.dataWidth) + this.left;
        int i3 = 0;
        if (width == this.dataWidth) {
            System.arraycopy(this.luminances, i2, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.luminances;
        while (i3 < height) {
            System.arraycopy(bArr2, i2, bArr, i3 * width, width);
            i2 += this.dataWidth;
            i3++;
        }
        return bArr;
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested row is outside the image: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Object bArr2;
        int width = getWidth();
        if (bArr2 == null || bArr2.length < width) {
            bArr2 = new byte[width];
        }
        System.arraycopy(this.luminances, ((i + this.top) * this.dataWidth) + this.left, bArr2, 0, width);
        return bArr2;
    }

    public boolean isCropSupported() {
        return true;
    }
}
