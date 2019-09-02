package com.google.zxing.common;

import android.support.v4.media.TransportMediator;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset().name();
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        boolean z = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
        ASSUME_SHIFT_JIS = z;
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte[] bArr2 = bArr;
        Map<DecodeHintType, ?> map2 = map;
        if (map2 != null) {
            String str = (String) map2.get(DecodeHintType.CHARACTER_SET);
            if (str != null) {
                return str;
            }
        }
        int i = 0;
        int length = bArr2.length;
        int i2 = (bArr2.length > 3 && bArr2[0] == (byte) -17 && bArr2[1] == (byte) -69 && bArr2[2] == (byte) -65) ? 1 : 0;
        int i3 = 1;
        int i4 = i3;
        int i5 = i4;
        int i6 = 0;
        int i7 = i6;
        int i8 = i7;
        int i9 = i8;
        int i10 = i9;
        int i11 = i10;
        int i12 = i11;
        int i13 = i12;
        int i14 = i13;
        int i15 = i14;
        int i16 = i15;
        while (i7 < length && (i3 != 0 || i4 != 0 || i5 != 0)) {
            int i17 = bArr2[i7] & 255;
            if (i5 != 0) {
                if (i8 > 0) {
                    if ((i17 & 128) != 0) {
                        i8--;
                    }
                } else if ((i17 & 128) != 0) {
                    if ((i17 & 64) != 0) {
                        i8++;
                        if ((i17 & 32) == 0) {
                            i10++;
                        } else {
                            i8++;
                            if ((i17 & 16) == 0) {
                                i11++;
                            } else {
                                i8++;
                                if ((i17 & 8) == 0) {
                                    i12++;
                                }
                            }
                        }
                    }
                }
                i5 = 0;
            }
            if (i3 != 0) {
                if (i17 > TransportMediator.KEYCODE_MEDIA_PAUSE && i17 < GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL) {
                    i3 = 0;
                } else if (i17 > 159 && (i17 < 192 || i17 == 215 || i17 == 247)) {
                    i14++;
                }
            }
            if (i4 != 0) {
                if (i9 > 0) {
                    if (i17 >= 64 && i17 != TransportMediator.KEYCODE_MEDIA_PAUSE && i17 <= 252) {
                        i9--;
                    }
                } else if (!(i17 == 128 || i17 == GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL || i17 > 239)) {
                    int i18;
                    if (i17 > GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL && i17 < 224) {
                        i6++;
                        i18 = i15 + 1;
                        if (i18 > i13) {
                            i13 = i18;
                            i15 = i13;
                        } else {
                            i15 = i18;
                        }
                    } else if (i17 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                        i9++;
                        i18 = i16 + 1;
                        if (i18 > i) {
                            i = i18;
                            i16 = i;
                        } else {
                            i16 = i18;
                        }
                        i15 = 0;
                    } else {
                        i15 = 0;
                    }
                    i16 = 0;
                }
                i4 = 0;
            }
            i7++;
            bArr2 = bArr;
        }
        if (i5 != 0 && i8 > 0) {
            i5 = 0;
        }
        int i19 = (i4 == 0 || i9 <= 0) ? i4 : 0;
        if (i5 != 0 && (i2 != 0 || (i10 + i11) + i12 > 0)) {
            return UTF8;
        }
        if (i19 != 0 && (ASSUME_SHIFT_JIS || i13 >= 3 || i >= 3)) {
            return SHIFT_JIS;
        }
        if (i3 == 0 || i19 == 0) {
            return i3 != 0 ? ISO88591 : i19 != 0 ? SHIFT_JIS : i5 != 0 ? UTF8 : PLATFORM_DEFAULT_ENCODING;
        } else {
            String str2 = (!(i13 == 2 && i6 == 2) && i14 * 10 < length) ? ISO88591 : SHIFT_JIS;
            return str2;
        }
    }
}
