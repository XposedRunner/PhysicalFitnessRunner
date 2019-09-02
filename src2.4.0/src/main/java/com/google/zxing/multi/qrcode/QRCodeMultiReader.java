package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
    private static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];

    private static final class SAComparator implements Serializable, Comparator<Result> {
        private SAComparator() {
        }

        public int compare(Result result, Result result2) {
            int intValue = ((Integer) result.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue();
            int intValue2 = ((Integer) result2.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue();
            return intValue < intValue2 ? -1 : intValue > intValue2 ? 1 : 0;
        }
    }

    private static List<Result> processStructuredAppend(List<Result> list) {
        Result result;
        int i;
        for (Result result2 : list) {
            if (result2.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Result> arrayList2 = new ArrayList();
        for (Result result3 : list) {
            arrayList.add(result3);
            if (result3.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(result3);
            }
        }
        Collections.sort(arrayList2, new SAComparator());
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        int i3 = i2;
        for (Result result4 : arrayList2) {
            stringBuilder.append(result4.getText());
            i2 += result4.getRawBytes().length;
            if (result4.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                for (byte[] length : (Iterable) result4.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)) {
                    i3 += length.length;
                }
            }
        }
        byte[] bArr = new byte[i2];
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        int i5 = i4;
        for (Result result5 : arrayList2) {
            System.arraycopy(result5.getRawBytes(), 0, bArr, i4, result5.getRawBytes().length);
            i4 += result5.getRawBytes().length;
            if (result5.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                for (byte[] bArr3 : (Iterable) result5.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)) {
                    System.arraycopy(bArr3, 0, bArr2, i5, bArr3.length);
                    i5 += bArr3.length;
                }
            }
        }
        result2 = new Result(stringBuilder.toString(), bArr, NO_POINTS, BarcodeFormat.QR_CODE);
        if (i3 > 0) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(bArr2);
            result2.putMetadata(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(result2);
        return arrayList;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        DetectorResult[] detectMulti = new MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map);
        for (DetectorResult detectorResult : detectMulti) {
            try {
                DecoderResult decode = getDecoder().decode(detectorResult.getBits(), (Map) map);
                ResultPoint[] points = detectorResult.getPoints();
                if (decode.getOther() instanceof QRCodeDecoderMetaData) {
                    ((QRCodeDecoderMetaData) decode.getOther()).applyMirroredCorrection(points);
                }
                Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
                List byteSegments = decode.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                String eCLevel = decode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                if (decode.hasStructuredAppend()) {
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decode.getStructuredAppendSequenceNumber()));
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decode.getStructuredAppendParity()));
                }
                arrayList.add(result);
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        List processStructuredAppend = processStructuredAppend(arrayList);
        return (Result[]) processStructuredAppend.toArray(new Result[processStructuredAppend.size()]);
    }
}
