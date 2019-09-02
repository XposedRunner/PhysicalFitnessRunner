package com.yalantis.ucrop.util;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;

    private static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short getInt16(int i) {
            return this.data.getShort(i);
        }

        public int getInt32(int i) {
            return this.data.getInt(i);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    private interface Reader {
        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j) throws IOException;
    }

    private static class StreamReader implements Reader {
        private final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        public int getUInt16() throws IOException {
            return ((this.is.read() << 8) & 65280) | (this.is.read() & ImageHeaderParser.SEGMENT_START_ID);
        }

        public short getUInt8() throws IOException {
            return (short) (this.is.read() & ImageHeaderParser.SEGMENT_START_ID);
        }

        public int read(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.is.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.is.skip(j2);
                if (skip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new StreamReader(inputStream);
    }

    private static int calcTagOffset(int i, int i2) {
        return (i + 2) + (12 * i2);
    }

    public static void copyExif(ExifInterface exifInterface, int i, int i2, String str) {
        r0 = new String[22];
        int i3 = 0;
        r0[0] = "FNumber";
        r0[1] = "DateTime";
        r0[2] = "DateTimeDigitized";
        r0[3] = "ExposureTime";
        r0[4] = "Flash";
        r0[5] = "FocalLength";
        r0[6] = "GPSAltitude";
        r0[7] = "GPSAltitudeRef";
        r0[8] = "GPSDateStamp";
        r0[9] = "GPSLatitude";
        r0[10] = "GPSLatitudeRef";
        r0[11] = "GPSLongitude";
        r0[12] = "GPSLongitudeRef";
        r0[13] = "GPSProcessingMethod";
        r0[14] = "GPSTimeStamp";
        r0[15] = "ISOSpeedRatings";
        r0[16] = "Make";
        r0[17] = "Model";
        r0[18] = "SubSecTime";
        r0[19] = "SubSecTimeDigitized";
        r0[20] = "SubSecTimeOriginal";
        r0[21] = "WhiteBalance";
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            int length = r0.length;
            while (i3 < length) {
                String str2 = r0[i3];
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
                i3++;
            }
            exifInterface2.setAttribute("ImageWidth", String.valueOf(i));
            exifInterface2.setAttribute("ImageLength", String.valueOf(i2));
            exifInterface2.setAttribute("Orientation", "0");
            exifInterface2.saveAttributes();
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        boolean z = bArr != null && i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (!z) {
            return z;
        }
        for (int i2 = 0; i2 < JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length; i2++) {
            if (bArr[i2] != JPEG_EXIF_SEGMENT_PREAMBLE_BYTES[i2]) {
                return false;
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength() throws IOException {
        long skip;
        short uInt8;
        int uInt16;
        long j;
        do {
            uInt8 = this.reader.getUInt8();
            if (uInt8 != (short) 255) {
                if (Log.isLoggable(TAG, 3)) {
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown segmentId=");
                    stringBuilder.append(uInt8);
                    Log.d(str, stringBuilder.toString());
                }
                return -1;
            }
            uInt8 = this.reader.getUInt8();
            if (uInt8 == (short) 218) {
                return -1;
            }
            if (uInt8 == (short) 217) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = this.reader.getUInt16() - 2;
            if (uInt8 == (short) 225) {
                return uInt16;
            }
            j = (long) uInt16;
            skip = this.reader.skip(j);
        } while (skip == j);
        if (Log.isLoggable(TAG, 3)) {
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to skip enough data, type: ");
            stringBuilder2.append(uInt8);
            stringBuilder2.append(", wanted to skip: ");
            stringBuilder2.append(uInt16);
            stringBuilder2.append(", but actually skipped: ");
            stringBuilder2.append(skip);
            Log.d(str2, stringBuilder2.toString());
        }
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        int length = JPEG_EXIF_SEGMENT_PREAMBLE.length();
        short int16 = randomAccessReader.getInt16(length);
        if (int16 == (short) 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (int16 == (short) 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(TAG, 3)) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown endianness = ");
                stringBuilder.append(int16);
                Log.d(str, stringBuilder.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(length + 4) + length;
        short int162 = randomAccessReader.getInt16(int32);
        for (short s = (short) 0; s < int162; s++) {
            int calcTagOffset = calcTagOffset(int32, s);
            short int163 = randomAccessReader.getInt16(calcTagOffset);
            if (int163 == (short) 274) {
                short int164 = randomAccessReader.getInt16(calcTagOffset + 2);
                String str2;
                StringBuilder stringBuilder2;
                if (int164 >= (short) 1 && int164 <= (short) 12) {
                    int int322 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int322 >= 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            String str3 = TAG;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Got tagIndex=");
                            stringBuilder3.append(s);
                            stringBuilder3.append(" tagType=");
                            stringBuilder3.append(int163);
                            stringBuilder3.append(" formatCode=");
                            stringBuilder3.append(int164);
                            stringBuilder3.append(" componentCount=");
                            stringBuilder3.append(int322);
                            Log.d(str3, stringBuilder3.toString());
                        }
                        int322 += BYTES_PER_FORMAT[int164];
                        if (int322 <= 4) {
                            calcTagOffset += 8;
                            if (calcTagOffset < 0 || calcTagOffset > randomAccessReader.length()) {
                                if (Log.isLoggable(TAG, 3)) {
                                    String str4 = TAG;
                                    StringBuilder stringBuilder4 = new StringBuilder();
                                    stringBuilder4.append("Illegal tagValueOffset=");
                                    stringBuilder4.append(calcTagOffset);
                                    stringBuilder4.append(" tagType=");
                                    stringBuilder4.append(int163);
                                    Log.d(str4, stringBuilder4.toString());
                                }
                            } else if (int322 >= 0 && int322 + calcTagOffset <= randomAccessReader.length()) {
                                return randomAccessReader.getInt16(calcTagOffset);
                            } else {
                                if (Log.isLoggable(TAG, 3)) {
                                    str2 = TAG;
                                    StringBuilder stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("Illegal number of bytes for TI tag data tagType=");
                                    stringBuilder5.append(int163);
                                    Log.d(str2, stringBuilder5.toString());
                                }
                            }
                        } else if (Log.isLoggable(TAG, 3)) {
                            str2 = TAG;
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            stringBuilder2.append(int164);
                            Log.d(str2, stringBuilder2.toString());
                        }
                    } else if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    str2 = TAG;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Got invalid format code = ");
                    stringBuilder2.append(int164);
                    Log.d(str2, stringBuilder2.toString());
                }
            }
        }
        return -1;
    }

    private int parseExifSegment(byte[] bArr, int i) throws IOException {
        int read = this.reader.read(bArr, i);
        if (read != i) {
            if (Log.isLoggable(TAG, 3)) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to read exif segment data, length: ");
                stringBuilder.append(i);
                stringBuilder.append(", actually read: ");
                stringBuilder.append(read);
                Log.d(str, stringBuilder.toString());
            }
            return -1;
        } else if (hasJpegExifPreamble(bArr, i)) {
            return parseExifSegment(new RandomAccessReader(bArr, i));
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public int getOrientation() throws IOException {
        int uInt16 = this.reader.getUInt16();
        if (handles(uInt16)) {
            uInt16 = moveToExifSegmentAndGetLength();
            if (uInt16 != -1) {
                return parseExifSegment(new byte[uInt16], uInt16);
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        if (Log.isLoggable(TAG, 3)) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parser doesn't handle magic number: ");
            stringBuilder.append(uInt16);
            Log.d(str, stringBuilder.toString());
        }
        return -1;
    }
}
