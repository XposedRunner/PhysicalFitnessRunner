package com.google.zxing.qrcode.decoder;

import android.support.v4.media.TransportMediator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.location.BDLocation;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

public final class Version {
    private static final Version[] VERSIONS = buildVersions();
    private static final int[] VERSION_DECODE_INFO = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private final int[] alignmentPatternCenters;
    private final ECBlocks[] ecBlocks;
    private final int totalCodewords;
    private final int versionNumber;

    public static final class ECB {
        private final int count;
        private final int dataCodewords;

        ECB(int i, int i2) {
            this.count = i;
            this.dataCodewords = i2;
        }

        public int getCount() {
            return this.count;
        }

        public int getDataCodewords() {
            return this.dataCodewords;
        }
    }

    public static final class ECBlocks {
        private final ECB[] ecBlocks;
        private final int ecCodewordsPerBlock;

        ECBlocks(int i, ECB... ecbArr) {
            this.ecCodewordsPerBlock = i;
            this.ecBlocks = ecbArr;
        }

        public ECB[] getECBlocks() {
            return this.ecBlocks;
        }

        public int getECCodewordsPerBlock() {
            return this.ecCodewordsPerBlock;
        }

        public int getNumBlocks() {
            ECB[] ecbArr = this.ecBlocks;
            int i = 0;
            int i2 = 0;
            while (i < ecbArr.length) {
                i2 += ecbArr[i].getCount();
                i++;
            }
            return i2;
        }

        public int getTotalECCodewords() {
            return this.ecCodewordsPerBlock * getNumBlocks();
        }
    }

    private Version(int i, int[] iArr, ECBlocks... eCBlocksArr) {
        this.versionNumber = i;
        this.alignmentPatternCenters = iArr;
        this.ecBlocks = eCBlocksArr;
        i = 0;
        int eCCodewordsPerBlock = eCBlocksArr[0].getECCodewordsPerBlock();
        ECB[] eCBlocks = eCBlocksArr[0].getECBlocks();
        int length = eCBlocks.length;
        int i2 = 0;
        while (i < length) {
            ECB ecb = eCBlocks[i];
            i2 += ecb.getCount() * (ecb.getDataCodewords() + eCCodewordsPerBlock);
            i++;
        }
        this.totalCodewords = i2;
    }

    private static Version[] buildVersions() {
        r0 = new Version[40];
        int[] iArr = new int[0];
        ECBlocks[] eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(7, new ECB(1, 19));
        eCBlocksArr[1] = new ECBlocks(10, new ECB(1, 16));
        eCBlocksArr[2] = new ECBlocks(13, new ECB(1, 13));
        eCBlocksArr[3] = new ECBlocks(17, new ECB(1, 9));
        r0[0] = new Version(1, iArr, eCBlocksArr);
        iArr = new int[]{6, 18};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(10, new ECB(1, 34));
        eCBlocksArr[1] = new ECBlocks(16, new ECB(1, 28));
        eCBlocksArr[2] = new ECBlocks(22, new ECB(1, 22));
        eCBlocksArr[3] = new ECBlocks(28, new ECB(1, 16));
        r0[1] = new Version(2, iArr, eCBlocksArr);
        iArr = new int[]{6, 22};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(15, new ECB(1, 55));
        eCBlocksArr[1] = new ECBlocks(26, new ECB(1, 44));
        eCBlocksArr[2] = new ECBlocks(18, new ECB(2, 17));
        eCBlocksArr[3] = new ECBlocks(22, new ECB(2, 13));
        r0[2] = new Version(3, iArr, eCBlocksArr);
        iArr = new int[]{6, 26};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(20, new ECB(1, 80));
        eCBlocksArr[1] = new ECBlocks(18, new ECB(2, 32));
        eCBlocksArr[2] = new ECBlocks(26, new ECB(2, 24));
        eCBlocksArr[3] = new ECBlocks(16, new ECB(4, 9));
        r0[3] = new Version(4, iArr, eCBlocksArr);
        iArr = new int[]{6, 30};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(26, new ECB(1, 108));
        eCBlocksArr[1] = new ECBlocks(24, new ECB(2, 43));
        eCBlocksArr[2] = new ECBlocks(18, new ECB(2, 15), new ECB(2, 16));
        eCBlocksArr[3] = new ECBlocks(22, new ECB(2, 11), new ECB(2, 12));
        r0[4] = new Version(5, iArr, eCBlocksArr);
        iArr = new int[]{6, 34};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(18, new ECB(2, 68));
        eCBlocksArr[1] = new ECBlocks(16, new ECB(4, 27));
        eCBlocksArr[2] = new ECBlocks(24, new ECB(4, 19));
        eCBlocksArr[3] = new ECBlocks(28, new ECB(4, 15));
        r0[5] = new Version(6, iArr, eCBlocksArr);
        iArr = new int[]{6, 22, 38};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(20, new ECB(2, 78));
        eCBlocksArr[1] = new ECBlocks(18, new ECB(4, 31));
        eCBlocksArr[2] = new ECBlocks(18, new ECB(2, 14), new ECB(4, 15));
        eCBlocksArr[3] = new ECBlocks(26, new ECB(4, 13), new ECB(1, 14));
        r0[6] = new Version(7, iArr, eCBlocksArr);
        iArr = new int[]{6, 24, 42};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(24, new ECB(2, 97));
        eCBlocksArr[1] = new ECBlocks(22, new ECB(2, 38), new ECB(2, 39));
        eCBlocksArr[2] = new ECBlocks(22, new ECB(4, 18), new ECB(2, 19));
        eCBlocksArr[3] = new ECBlocks(26, new ECB(4, 14), new ECB(2, 15));
        r0[7] = new Version(8, iArr, eCBlocksArr);
        iArr = new int[]{6, 26, 46};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(30, new ECB(2, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT));
        eCBlocksArr[1] = new ECBlocks(22, new ECB(3, 36), new ECB(2, 37));
        eCBlocksArr[2] = new ECBlocks(20, new ECB(4, 16), new ECB(4, 17));
        eCBlocksArr[3] = new ECBlocks(24, new ECB(4, 12), new ECB(4, 13));
        r0[8] = new Version(9, iArr, eCBlocksArr);
        iArr = new int[]{6, 28, 50};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(18, new ECB(2, 68), new ECB(2, 69));
        eCBlocksArr[1] = new ECBlocks(26, new ECB(4, 43), new ECB(1, 44));
        eCBlocksArr[2] = new ECBlocks(24, new ECB(6, 19), new ECB(2, 20));
        eCBlocksArr[3] = new ECBlocks(28, new ECB(6, 15), new ECB(2, 16));
        r0[9] = new Version(10, iArr, eCBlocksArr);
        iArr = new int[]{6, 30, 54};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(20, new ECB(4, 81));
        eCBlocksArr[1] = new ECBlocks(30, new ECB(1, 50), new ECB(4, 51));
        eCBlocksArr[2] = new ECBlocks(28, new ECB(4, 22), new ECB(4, 23));
        eCBlocksArr[3] = new ECBlocks(24, new ECB(3, 12), new ECB(8, 13));
        r0[10] = new Version(11, iArr, eCBlocksArr);
        iArr = new int[]{6, 32, 58};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(24, new ECB(2, 92), new ECB(2, 93));
        eCBlocksArr[1] = new ECBlocks(22, new ECB(6, 36), new ECB(2, 37));
        eCBlocksArr[2] = new ECBlocks(26, new ECB(4, 20), new ECB(6, 21));
        eCBlocksArr[3] = new ECBlocks(28, new ECB(7, 14), new ECB(4, 15));
        r0[11] = new Version(12, iArr, eCBlocksArr);
        iArr = new int[]{6, 34, 62};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(26, new ECB(4, 107));
        eCBlocksArr[1] = new ECBlocks(22, new ECB(8, 37), new ECB(1, 38));
        eCBlocksArr[2] = new ECBlocks(24, new ECB(8, 20), new ECB(4, 21));
        eCBlocksArr[3] = new ECBlocks(22, new ECB(12, 11), new ECB(4, 12));
        r0[12] = new Version(13, iArr, eCBlocksArr);
        iArr = new int[]{6, 26, 46, 66};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(30, new ECB(3, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED), new ECB(1, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT));
        eCBlocksArr[1] = new ECBlocks(24, new ECB(4, 40), new ECB(5, 41));
        eCBlocksArr[2] = new ECBlocks(20, new ECB(11, 16), new ECB(5, 17));
        eCBlocksArr[3] = new ECBlocks(24, new ECB(11, 12), new ECB(5, 13));
        r0[13] = new Version(14, iArr, eCBlocksArr);
        iArr = new int[]{6, 26, 48, 70};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(22, new ECB(5, 87), new ECB(1, 88));
        eCBlocksArr[1] = new ECBlocks(24, new ECB(5, 41), new ECB(5, 42));
        eCBlocksArr[2] = new ECBlocks(30, new ECB(5, 24), new ECB(7, 25));
        eCBlocksArr[3] = new ECBlocks(24, new ECB(11, 12), new ECB(7, 13));
        r0[14] = new Version(15, iArr, eCBlocksArr);
        iArr = new int[]{6, 26, 50, 74};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(24, new ECB(5, 98), new ECB(1, 99));
        eCBlocksArr[1] = new ECBlocks(28, new ECB(7, 45), new ECB(3, 46));
        eCBlocksArr[2] = new ECBlocks(24, new ECB(15, 19), new ECB(2, 20));
        eCBlocksArr[3] = new ECBlocks(30, new ECB(3, 15), new ECB(13, 16));
        r0[15] = new Version(16, iArr, eCBlocksArr);
        iArr = new int[]{6, 30, 54, 78};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(28, new ECB(1, 107), new ECB(5, 108));
        eCBlocksArr[1] = new ECBlocks(28, new ECB(10, 46), new ECB(1, 47));
        eCBlocksArr[2] = new ECBlocks(28, new ECB(1, 22), new ECB(15, 23));
        eCBlocksArr[3] = new ECBlocks(28, new ECB(2, 14), new ECB(17, 15));
        r0[16] = new Version(17, iArr, eCBlocksArr);
        iArr = new int[]{6, 30, 56, 82};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(30, new ECB(5, GlMapUtil.DEVICE_DISPLAY_DPI_LOW), new ECB(1, SecExceptionCode.SEC_ERROR_INIT_DATA_FILE_MISMATCH));
        eCBlocksArr[1] = new ECBlocks(26, new ECB(9, 43), new ECB(4, 44));
        eCBlocksArr[2] = new ECBlocks(28, new ECB(17, 22), new ECB(1, 23));
        eCBlocksArr[3] = new ECBlocks(28, new ECB(2, 14), new ECB(19, 15));
        r0[17] = new Version(18, iArr, eCBlocksArr);
        iArr = new int[]{6, 30, 58, 86};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(28, new ECB(3, 113), new ECB(4, 114));
        eCBlocksArr[1] = new ECBlocks(26, new ECB(3, 44), new ECB(11, 45));
        eCBlocksArr[2] = new ECBlocks(26, new ECB(17, 21), new ECB(4, 22));
        eCBlocksArr[3] = new ECBlocks(26, new ECB(9, 13), new ECB(16, 14));
        r0[18] = new Version(19, iArr, eCBlocksArr);
        iArr = new int[]{6, 34, 62, 90};
        eCBlocksArr = new ECBlocks[4];
        eCBlocksArr[0] = new ECBlocks(28, new ECB(3, 107), new ECB(5, 108));
        eCBlocksArr[1] = new ECBlocks(26, new ECB(3, 41), new ECB(13, 42));
        eCBlocksArr[2] = new ECBlocks(30, new ECB(15, 24), new ECB(5, 25));
        eCBlocksArr[3] = new ECBlocks(28, new ECB(15, 15), new ECB(10, 16));
        r0[19] = new Version(20, iArr, eCBlocksArr);
        int[] iArr2 = new int[]{6, 28, 50, 72, 94};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(28, new ECB(4, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT), new ECB(4, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET));
        r3[1] = new ECBlocks(26, new ECB(17, 42));
        r3[2] = new ECBlocks(28, new ECB(17, 22), new ECB(6, 23));
        r3[3] = new ECBlocks(30, new ECB(19, 16), new ECB(6, 17));
        r0[20] = new Version(21, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(28, new ECB(2, 111), new ECB(7, 112));
        r3[1] = new ECBlocks(28, new ECB(17, 46));
        r3[2] = new ECBlocks(30, new ECB(7, 24), new ECB(16, 25));
        r3[3] = new ECBlocks(24, new ECB(34, 13));
        r0[21] = new Version(22, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102};
        r6 = new ECBlocks[4];
        r6[0] = new ECBlocks(30, new ECB(4, SecExceptionCode.SEC_ERROR_INIT_DATA_FILE_MISMATCH), new ECB(5, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE));
        r6[1] = new ECBlocks(28, new ECB(4, 47), new ECB(14, 48));
        r6[2] = new ECBlocks(30, new ECB(11, 24), new ECB(14, 25));
        r6[3] = new ECBlocks(30, new ECB(16, 15), new ECB(14, 16));
        r0[22] = new Version(23, iArr2, r6);
        iArr2 = new int[]{6, 28, 54, 80, 106};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(6, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET), new ECB(4, SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM));
        r3[1] = new ECBlocks(28, new ECB(6, 45), new ECB(14, 46));
        r3[2] = new ECBlocks(30, new ECB(11, 24), new ECB(16, 25));
        r3[3] = new ECBlocks(30, new ECB(30, 16), new ECB(2, 17));
        r0[23] = new Version(24, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(26, new ECB(8, 106), new ECB(4, 107));
        r3[1] = new ECBlocks(28, new ECB(8, 47), new ECB(13, 48));
        r3[2] = new ECBlocks(30, new ECB(7, 24), new ECB(22, 25));
        r3[3] = new ECBlocks(30, new ECB(22, 15), new ECB(13, 16));
        r0[24] = new Version(25, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(28, new ECB(10, 114), new ECB(2, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED));
        r3[1] = new ECBlocks(28, new ECB(19, 46), new ECB(4, 47));
        r3[2] = new ECBlocks(28, new ECB(28, 22), new ECB(6, 23));
        r3[3] = new ECBlocks(30, new ECB(33, 16), new ECB(4, 17));
        r0[25] = new Version(26, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(8, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE), new ECB(4, SecExceptionCode.SEC_ERROR_INIT_INCORRECT_DATA_FILE));
        r3[1] = new ECBlocks(28, new ECB(22, 45), new ECB(3, 46));
        r3[2] = new ECBlocks(30, new ECB(8, 23), new ECB(26, 24));
        r3[3] = new ECBlocks(30, new ECB(12, 15), new ECB(28, 16));
        r0[26] = new Version(27, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(3, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET), new ECB(10, SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM));
        r3[1] = new ECBlocks(28, new ECB(3, 45), new ECB(23, 46));
        r3[2] = new ECBlocks(30, new ECB(4, 24), new ECB(31, 25));
        r3[3] = new ECBlocks(30, new ECB(11, 15), new ECB(31, 16));
        r0[27] = new Version(28, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, TransportMediator.KEYCODE_MEDIA_PLAY};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(7, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT), new ECB(7, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET));
        r3[1] = new ECBlocks(28, new ECB(21, 45), new ECB(7, 46));
        r3[2] = new ECBlocks(30, new ECB(1, 23), new ECB(37, 24));
        r3[3] = new ECBlocks(30, new ECB(19, 15), new ECB(26, 16));
        r0[28] = new Version(29, iArr2, r3);
        iArr2 = new int[]{6, 26, 52, 78, 104, TransportMediator.KEYCODE_MEDIA_RECORD};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(5, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED), new ECB(10, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT));
        r3[1] = new ECBlocks(28, new ECB(19, 47), new ECB(10, 48));
        r3[2] = new ECBlocks(30, new ECB(15, 24), new ECB(25, 25));
        r3[3] = new ECBlocks(30, new ECB(23, 15), new ECB(25, 16));
        r0[29] = new Version(30, iArr2, r3);
        iArr2 = new int[]{6, 30, 56, 82, 108, 134};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(13, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED), new ECB(3, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT));
        r3[1] = new ECBlocks(28, new ECB(2, 46), new ECB(29, 47));
        r3[2] = new ECBlocks(30, new ECB(42, 24), new ECB(1, 25));
        r3[3] = new ECBlocks(30, new ECB(23, 15), new ECB(28, 16));
        r0[30] = new Version(31, iArr2, r3);
        iArr2 = new int[]{6, 34, 60, 86, 112, 138};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(17, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED));
        r3[1] = new ECBlocks(28, new ECB(10, 46), new ECB(23, 47));
        r3[2] = new ECBlocks(30, new ECB(10, 24), new ECB(35, 25));
        r3[3] = new ECBlocks(30, new ECB(19, 15), new ECB(35, 16));
        r0[31] = new Version(32, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114, 142};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(17, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED), new ECB(1, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT));
        r3[1] = new ECBlocks(28, new ECB(14, 46), new ECB(21, 47));
        r3[2] = new ECBlocks(30, new ECB(29, 24), new ECB(19, 25));
        r3[3] = new ECBlocks(30, new ECB(11, 15), new ECB(46, 16));
        r0[32] = new Version(33, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM, 146};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(13, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED), new ECB(6, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT));
        r3[1] = new ECBlocks(28, new ECB(14, 46), new ECB(23, 47));
        r3[2] = new ECBlocks(30, new ECB(44, 24), new ECB(7, 25));
        r3[3] = new ECBlocks(30, new ECB(59, 16), new ECB(1, 17));
        r0[33] = new Version(34, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, TransportMediator.KEYCODE_MEDIA_PLAY, SecExceptionCode.SEC_ERROR_INIT_NO_ANNOTATION};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(12, SecExceptionCode.SEC_ERROR_INIT_DATA_FILE_MISMATCH), new ECB(7, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE));
        r3[1] = new ECBlocks(28, new ECB(12, 47), new ECB(26, 48));
        r3[2] = new ECBlocks(30, new ECB(39, 24), new ECB(14, 25));
        r3[3] = new ECBlocks(30, new ECB(22, 15), new ECB(41, 16));
        r0[34] = new Version(35, iArr2, r3);
        iArr2 = new int[]{6, 24, 50, 76, 102, 128, 154};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(6, SecExceptionCode.SEC_ERROR_INIT_DATA_FILE_MISMATCH), new ECB(14, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE));
        r3[1] = new ECBlocks(28, new ECB(6, 47), new ECB(34, 48));
        r3[2] = new ECBlocks(30, new ECB(46, 24), new ECB(10, 25));
        r3[3] = new ECBlocks(30, new ECB(2, 15), new ECB(64, 16));
        r0[35] = new Version(36, iArr2, r3);
        iArr2 = new int[]{6, 28, 54, 80, 106, 132, 158};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(17, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE), new ECB(4, SecExceptionCode.SEC_ERROR_INIT_INCORRECT_DATA_FILE));
        r3[1] = new ECBlocks(28, new ECB(29, 46), new ECB(14, 47));
        r3[2] = new ECBlocks(30, new ECB(49, 24), new ECB(10, 25));
        r3[3] = new ECBlocks(30, new ECB(24, 15), new ECB(46, 16));
        r0[36] = new Version(37, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110, 136, BDLocation.TypeServerDecryptError};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(4, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE), new ECB(18, SecExceptionCode.SEC_ERROR_INIT_INCORRECT_DATA_FILE));
        r3[1] = new ECBlocks(28, new ECB(13, 46), new ECB(32, 47));
        r3[2] = new ECBlocks(30, new ECB(48, 24), new ECB(14, 25));
        r3[3] = new ECBlocks(30, new ECB(42, 15), new ECB(32, 16));
        r0[37] = new Version(38, iArr2, r3);
        iArr2 = new int[]{6, 26, 54, 82, 110, 138, 166};
        r3 = new ECBlocks[4];
        r3[0] = new ECBlocks(30, new ECB(20, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET), new ECB(4, SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM));
        r3[1] = new ECBlocks(28, new ECB(40, 47), new ECB(7, 48));
        r3[2] = new ECBlocks(30, new ECB(43, 24), new ECB(22, 25));
        r3[3] = new ECBlocks(30, new ECB(10, 15), new ECB(67, 16));
        r0[38] = new Version(39, iArr2, r3);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        r4 = new ECBlocks[4];
        r4[0] = new ECBlocks(30, new ECB(19, SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM), new ECB(6, SecExceptionCode.SEC_ERROR_SET_GLOBAL_USER_DATA));
        r4[1] = new ECBlocks(28, new ECB(18, 47), new ECB(31, 48));
        r4[2] = new ECBlocks(30, new ECB(34, 24), new ECB(34, 25));
        r4[3] = new ECBlocks(30, new ECB(20, 15), new ECB(61, 16));
        r0[39] = new Version(40, iArr, r4);
        return r0;
    }

    static Version decodeVersionInformation(int i) {
        int i2 = 0;
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i4 = 0;
        while (i2 < VERSION_DECODE_INFO.length) {
            int i5 = VERSION_DECODE_INFO[i2];
            if (i5 == i) {
                return getVersionForNumber(i2 + 7);
            }
            i5 = FormatInformation.numBitsDiffering(i, i5);
            if (i5 < i3) {
                i4 = i2 + 7;
                i3 = i5;
            }
            i2++;
        }
        return i3 <= 3 ? getVersionForNumber(i4) : null;
    }

    public static Version getProvisionalVersionForDimension(int i) throws FormatException {
        if (i % 4 != 1) {
            throw FormatException.getFormatInstance();
        }
        try {
            return getVersionForNumber((i - 17) / 4);
        } catch (IllegalArgumentException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static Version getVersionForNumber(int i) {
        if (i >= 1 && i <= 40) {
            return VERSIONS[i - 1];
        }
        throw new IllegalArgumentException();
    }

    /* Access modifiers changed, original: 0000 */
    public BitMatrix buildFunctionPattern() {
        int dimensionForVersion = getDimensionForVersion();
        BitMatrix bitMatrix = new BitMatrix(dimensionForVersion);
        bitMatrix.setRegion(0, 0, 9, 9);
        int i = dimensionForVersion - 8;
        bitMatrix.setRegion(i, 0, 8, 9);
        bitMatrix.setRegion(0, i, 9, 8);
        i = this.alignmentPatternCenters.length;
        int i2 = 0;
        while (i2 < i) {
            int i3 = this.alignmentPatternCenters[i2] - 2;
            int i4 = 0;
            while (i4 < i) {
                if (!((i2 == 0 && (i4 == 0 || i4 == i - 1)) || (i2 == i - 1 && i4 == 0))) {
                    bitMatrix.setRegion(this.alignmentPatternCenters[i4] - 2, i3, 5, 5);
                }
                i4++;
            }
            i2++;
        }
        i = dimensionForVersion - 17;
        bitMatrix.setRegion(6, 9, 1, i);
        bitMatrix.setRegion(9, 6, i, 1);
        if (this.versionNumber > 6) {
            dimensionForVersion -= 11;
            bitMatrix.setRegion(dimensionForVersion, 0, 3, 6);
            bitMatrix.setRegion(0, dimensionForVersion, 6, 3);
        }
        return bitMatrix;
    }

    public int[] getAlignmentPatternCenters() {
        return this.alignmentPatternCenters;
    }

    public int getDimensionForVersion() {
        return 17 + (4 * this.versionNumber);
    }

    public ECBlocks getECBlocksForLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.ecBlocks[errorCorrectionLevel.ordinal()];
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }
}
