package com.google.zxing.aztec;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;

public final class AztecReader implements Reader {
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083  */
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap r6, java.util.Map<com.google.zxing.DecodeHintType, ?> r7) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
        r5 = this;
        r0 = new com.google.zxing.aztec.detector.Detector;
        r6 = r6.getBlackMatrix();
        r0.<init>(r6);
        r6 = 0;
        r1 = 0;
        r2 = r0.detect(r6);	 Catch:{ NotFoundException -> 0x002b, FormatException -> 0x0025 }
        r3 = r2.getPoints();	 Catch:{ NotFoundException -> 0x002b, FormatException -> 0x0025 }
        r4 = new com.google.zxing.aztec.decoder.Decoder;	 Catch:{ NotFoundException -> 0x0023, FormatException -> 0x0021 }
        r4.<init>();	 Catch:{ NotFoundException -> 0x0023, FormatException -> 0x0021 }
        r2 = r4.decode(r2);	 Catch:{ NotFoundException -> 0x0023, FormatException -> 0x0021 }
        r4 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x002f;
    L_0x0021:
        r2 = move-exception;
        goto L_0x0027;
    L_0x0023:
        r2 = move-exception;
        goto L_0x002d;
    L_0x0025:
        r2 = move-exception;
        r3 = r1;
    L_0x0027:
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x002f;
    L_0x002b:
        r2 = move-exception;
        r3 = r1;
    L_0x002d:
        r4 = r3;
        r3 = r1;
    L_0x002f:
        if (r1 != 0) goto L_0x004c;
    L_0x0031:
        r1 = 1;
        r0 = r0.detect(r1);	 Catch:{ FormatException | NotFoundException -> 0x0044, FormatException | NotFoundException -> 0x0044 }
        r4 = r0.getPoints();	 Catch:{ FormatException | NotFoundException -> 0x0044, FormatException | NotFoundException -> 0x0044 }
        r1 = new com.google.zxing.aztec.decoder.Decoder;	 Catch:{ FormatException | NotFoundException -> 0x0044, FormatException | NotFoundException -> 0x0044 }
        r1.<init>();	 Catch:{ FormatException | NotFoundException -> 0x0044, FormatException | NotFoundException -> 0x0044 }
        r1 = r1.decode(r0);	 Catch:{ FormatException | NotFoundException -> 0x0044, FormatException | NotFoundException -> 0x0044 }
        goto L_0x004c;
    L_0x0044:
        r6 = move-exception;
        if (r2 == 0) goto L_0x0048;
    L_0x0047:
        throw r2;
    L_0x0048:
        if (r3 == 0) goto L_0x004b;
    L_0x004a:
        throw r3;
    L_0x004b:
        throw r6;
    L_0x004c:
        if (r7 == 0) goto L_0x0063;
    L_0x004e:
        r0 = com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK;
        r7 = r7.get(r0);
        r7 = (com.google.zxing.ResultPointCallback) r7;
        if (r7 == 0) goto L_0x0063;
    L_0x0058:
        r0 = r4.length;
    L_0x0059:
        if (r6 >= r0) goto L_0x0063;
    L_0x005b:
        r2 = r4[r6];
        r7.foundPossibleResultPoint(r2);
        r6 = r6 + 1;
        goto L_0x0059;
    L_0x0063:
        r6 = new com.google.zxing.Result;
        r7 = r1.getText();
        r0 = r1.getRawBytes();
        r2 = com.google.zxing.BarcodeFormat.AZTEC;
        r6.<init>(r7, r0, r4, r2);
        r7 = r1.getByteSegments();
        if (r7 == 0) goto L_0x007d;
    L_0x0078:
        r0 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS;
        r6.putMetadata(r0, r7);
    L_0x007d:
        r7 = r1.getECLevel();
        if (r7 == 0) goto L_0x0088;
    L_0x0083:
        r0 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL;
        r6.putMetadata(r0, r7);
    L_0x0088:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecReader.decode(com.google.zxing.BinaryBitmap, java.util.Map):com.google.zxing.Result");
    }

    public void reset() {
    }
}
