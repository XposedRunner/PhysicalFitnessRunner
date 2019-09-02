package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            i4 = i3 + i5;
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / moduleSize);
        int round2 = Math.round(((float) (i5 + 1)) / moduleSize);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        } else if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            i5 = (int) (moduleSize / 2.0f);
            i += i5;
            i3 += i5;
            int i6 = (((int) (((float) (round - 1)) * moduleSize)) + i3) - i4;
            if (i6 > 0) {
                if (i6 > i5) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i3 -= i6;
            }
            i4 = (((int) (((float) (round2 - 1)) * moduleSize)) + i) - i2;
            if (i4 > 0) {
                if (i4 > i5) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i -= i4;
            }
            BitMatrix bitMatrix2 = new BitMatrix(round, round2);
            for (i2 = 0; i2 < round2; i2++) {
                i5 = ((int) (((float) i2) * moduleSize)) + i;
                for (i6 = 0; i6 < round; i6++) {
                    if (bitMatrix.get(((int) (((float) i6) * moduleSize)) + i3, i5)) {
                        bitMatrix2.set(i6, i2);
                    }
                }
            }
            return bitMatrix2;
        }
    }

    private static float moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        int i2 = 1;
        int i3 = iArr[1];
        int i4 = 0;
        while (i < width && i3 < height) {
            if (i2 != bitMatrix.get(i, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                i2 ^= 1;
            }
            i++;
            i3++;
        }
        if (i != width && i3 != height) {
            return ((float) (i - iArr[0])) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ResultPoint[] points;
        DecoderResult decoderResult;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            DecoderResult decode = this.decoder.decode(detect.getBits(), (Map) map);
            points = detect.getPoints();
            decoderResult = decode;
        } else {
            decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), (Map) map);
            points = NO_POINTS;
        }
        if (decoderResult.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData) decoderResult.getOther()).applyMirroredCorrection(points);
        }
        Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), points, BarcodeFormat.QR_CODE);
        List byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decoderResult.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResult.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResult.getStructuredAppendParity()));
        }
        return result;
    }

    /* Access modifiers changed, original: protected|final */
    public final Decoder getDecoder() {
        return this.decoder;
    }

    public void reset() {
    }
}
