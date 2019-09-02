package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

public final class DataMatrixWriter implements Writer {
    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix byteMatrix) {
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        bitMatrix.clear();
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                if (byteMatrix.get(i, i2) == (byte) 1) {
                    bitMatrix.set(i, i2);
                }
            }
        }
        return bitMatrix;
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i = 0;
        int i2 = i;
        while (i < symbolDataHeight) {
            int i3;
            int i4;
            if (i % symbolInfo.matrixHeight == 0) {
                i3 = 0;
                i4 = i3;
                while (i3 < symbolInfo.getSymbolWidth()) {
                    byteMatrix.set(i4, i2, i3 % 2 == 0);
                    i4++;
                    i3++;
                }
                i2++;
            }
            i3 = 0;
            i4 = i3;
            while (i3 < symbolDataWidth) {
                if (i3 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i4, i2, true);
                    i4++;
                }
                byteMatrix.set(i4, i2, defaultPlacement.getBit(i3, i));
                i4++;
                if (i3 % symbolInfo.matrixWidth == symbolInfo.matrixWidth - 1) {
                    byteMatrix.set(i4, i2, i % 2 == 0);
                    i4++;
                }
                i3++;
            }
            i2++;
            if (i % symbolInfo.matrixHeight == symbolInfo.matrixHeight - 1) {
                i3 = 0;
                i4 = i3;
                while (i3 < symbolInfo.getSymbolWidth()) {
                    byteMatrix.set(i4, i2, true);
                    i4++;
                    i3++;
                }
                i2++;
            }
            i++;
        }
        return convertByteMatrixToBitMatrix(byteMatrix);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can only encode DATA_MATRIX, but got ");
            stringBuilder.append(barcodeFormat);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i < 0 || i2 < 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Requested dimensions are too small: ");
            stringBuilder2.append(i);
            stringBuilder2.append('x');
            stringBuilder2.append(i2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            Dimension dimension;
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            Dimension dimension2 = null;
            if (map != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                dimension = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                if (dimension == null) {
                    dimension = null;
                }
                Dimension dimension3 = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                if (dimension3 != null) {
                    dimension2 = dimension3;
                }
            } else {
                dimension = null;
            }
            str = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension, dimension2);
            SymbolInfo lookup = SymbolInfo.lookup(str.length(), symbolShapeHint, dimension, dimension2, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(str, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            defaultPlacement.place();
            return encodeLowLevel(defaultPlacement, lookup);
        }
    }
}
