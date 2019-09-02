package com.bumptech.glide.load.resource.bitmap;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ImageHeaderParser {
    private static final String O000000o = "ImageHeaderParser";
    private static final int O00000Oo = 4671814;
    private static final int O00000o = 65496;
    private static final int O00000o0 = -1991225785;
    private static final int O00000oO = 19789;
    private static final int O00000oo = 18761;
    private static final String O0000O0o = "Exif\u0000\u0000";
    private static final byte[] O0000OOo;
    private static final int O0000Oo = 217;
    private static final int O0000Oo0 = 218;
    private static final int O0000OoO = 255;
    private static final int O0000Ooo = 225;
    private static final int[] O0000o0 = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int O0000o00 = 274;
    private final O00000Oo O0000o0O;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);
        
        private final boolean O000000o;

        private ImageType(boolean z) {
            this.O000000o = z;
        }

        public boolean hasAlpha() {
            return this.O000000o;
        }
    }

    private static class O000000o {
        private final ByteBuffer O000000o;

        public O000000o(byte[] bArr) {
            this.O000000o = ByteBuffer.wrap(bArr);
            this.O000000o.order(ByteOrder.BIG_ENDIAN);
        }

        public int O000000o() {
            return this.O000000o.array().length;
        }

        public int O000000o(int i) {
            return this.O000000o.getInt(i);
        }

        public void O000000o(ByteOrder byteOrder) {
            this.O000000o.order(byteOrder);
        }

        public short O00000Oo(int i) {
            return this.O000000o.getShort(i);
        }
    }

    private static class O00000Oo {
        private final InputStream O000000o;

        public O00000Oo(InputStream inputStream) {
            this.O000000o = inputStream;
        }

        public int O000000o() throws IOException {
            return ((this.O000000o.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.O000000o.read() & 255);
        }

        public int O000000o(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.O000000o.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public long O000000o(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.O000000o.skip(j2);
                if (skip <= 0) {
                    if (this.O000000o.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        public short O00000Oo() throws IOException {
            return (short) (this.O000000o.read() & 255);
        }

        public int O00000o0() throws IOException {
            return this.O000000o.read();
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = O0000O0o.getBytes(HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException unused) {
        }
        O0000OOo = bArr;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.O0000o0O = new O00000Oo(inputStream);
    }

    private static int O000000o(int i, int i2) {
        return (i + 2) + (12 * i2);
    }

    private static int O000000o(O000000o o000000o) {
        ByteOrder byteOrder;
        int length = O0000O0o.length();
        short O00000Oo = o000000o.O00000Oo(length);
        if (O00000Oo == (short) 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (O00000Oo == (short) 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(O000000o, 3)) {
                String str = O000000o;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown endianness = ");
                stringBuilder.append(O00000Oo);
                Log.d(str, stringBuilder.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        o000000o.O000000o(byteOrder);
        int O000000o = o000000o.O000000o(length + 4) + length;
        short O00000Oo2 = o000000o.O00000Oo(O000000o);
        for (short s = (short) 0; s < O00000Oo2; s++) {
            int O000000o2 = O000000o(O000000o, s);
            short O00000Oo3 = o000000o.O00000Oo(O000000o2);
            if (O00000Oo3 == (short) 274) {
                short O00000Oo4 = o000000o.O00000Oo(O000000o2 + 2);
                String str2;
                StringBuilder stringBuilder2;
                if (O00000Oo4 >= (short) 1 && O00000Oo4 <= (short) 12) {
                    int O000000o3 = o000000o.O000000o(O000000o2 + 4);
                    if (O000000o3 >= 0) {
                        if (Log.isLoggable(O000000o, 3)) {
                            String str3 = O000000o;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Got tagIndex=");
                            stringBuilder3.append(s);
                            stringBuilder3.append(" tagType=");
                            stringBuilder3.append(O00000Oo3);
                            stringBuilder3.append(" formatCode=");
                            stringBuilder3.append(O00000Oo4);
                            stringBuilder3.append(" componentCount=");
                            stringBuilder3.append(O000000o3);
                            Log.d(str3, stringBuilder3.toString());
                        }
                        O000000o3 += O0000o0[O00000Oo4];
                        if (O000000o3 <= 4) {
                            O000000o2 += 8;
                            if (O000000o2 < 0 || O000000o2 > o000000o.O000000o()) {
                                if (Log.isLoggable(O000000o, 3)) {
                                    String str4 = O000000o;
                                    StringBuilder stringBuilder4 = new StringBuilder();
                                    stringBuilder4.append("Illegal tagValueOffset=");
                                    stringBuilder4.append(O000000o2);
                                    stringBuilder4.append(" tagType=");
                                    stringBuilder4.append(O00000Oo3);
                                    Log.d(str4, stringBuilder4.toString());
                                }
                            } else if (O000000o3 >= 0 && O000000o3 + O000000o2 <= o000000o.O000000o()) {
                                return o000000o.O00000Oo(O000000o2);
                            } else {
                                if (Log.isLoggable(O000000o, 3)) {
                                    str2 = O000000o;
                                    StringBuilder stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("Illegal number of bytes for TI tag data tagType=");
                                    stringBuilder5.append(O00000Oo3);
                                    Log.d(str2, stringBuilder5.toString());
                                }
                            }
                        } else if (Log.isLoggable(O000000o, 3)) {
                            str2 = O000000o;
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            stringBuilder2.append(O00000Oo4);
                            Log.d(str2, stringBuilder2.toString());
                        }
                    } else if (Log.isLoggable(O000000o, 3)) {
                        Log.d(O000000o, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(O000000o, 3)) {
                    str2 = O000000o;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Got invalid format code=");
                    stringBuilder2.append(O00000Oo4);
                    Log.d(str2, stringBuilder2.toString());
                }
            }
        }
        return -1;
    }

    private static boolean O000000o(int i) {
        return (i & O00000o) == O00000o || i == O00000oO || i == O00000oo;
    }

    private byte[] O00000o() throws IOException {
        long O000000o;
        short O00000Oo;
        int O000000o2;
        String str;
        StringBuilder stringBuilder;
        long j;
        do {
            O00000Oo = this.O0000o0O.O00000Oo();
            if (O00000Oo != (short) 255) {
                if (Log.isLoggable(O000000o, 3)) {
                    String str2 = O000000o;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Unknown segmentId=");
                    stringBuilder2.append(O00000Oo);
                    Log.d(str2, stringBuilder2.toString());
                }
                return null;
            }
            O00000Oo = this.O0000o0O.O00000Oo();
            if (O00000Oo == (short) 218) {
                return null;
            }
            if (O00000Oo == (short) 217) {
                if (Log.isLoggable(O000000o, 3)) {
                    Log.d(O000000o, "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            O000000o2 = this.O0000o0O.O000000o() - 2;
            if (O00000Oo != (short) 225) {
                j = (long) O000000o2;
                O000000o = this.O0000o0O.O000000o(j);
            } else {
                byte[] bArr = new byte[O000000o2];
                int O000000o3 = this.O0000o0O.O000000o(bArr);
                if (O000000o3 == O000000o2) {
                    return bArr;
                }
                if (Log.isLoggable(O000000o, 3)) {
                    str = O000000o;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to read segment data, type: ");
                    stringBuilder.append(O00000Oo);
                    stringBuilder.append(", length: ");
                    stringBuilder.append(O000000o2);
                    stringBuilder.append(", actually read: ");
                    stringBuilder.append(O000000o3);
                    Log.d(str, stringBuilder.toString());
                }
                return null;
            }
        } while (O000000o == j);
        if (Log.isLoggable(O000000o, 3)) {
            str = O000000o;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to skip enough data, type: ");
            stringBuilder.append(O00000Oo);
            stringBuilder.append(", wanted to skip: ");
            stringBuilder.append(O000000o2);
            stringBuilder.append(", but actually skipped: ");
            stringBuilder.append(O000000o);
            Log.d(str, stringBuilder.toString());
        }
        return null;
    }

    public boolean O000000o() throws IOException {
        return O00000Oo().hasAlpha();
    }

    public ImageType O00000Oo() throws IOException {
        int O000000o = this.O0000o0O.O000000o();
        if (O000000o == O00000o) {
            return ImageType.JPEG;
        }
        O000000o = ((O000000o << 16) & SupportMenu.CATEGORY_MASK) | (this.O0000o0O.O000000o() & SupportMenu.USER_MASK);
        if (O000000o != O00000o0) {
            return (O000000o >> 8) == O00000Oo ? ImageType.GIF : ImageType.UNKNOWN;
        } else {
            this.O0000o0O.O000000o(21);
            return this.O0000o0O.O00000o0() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        }
    }

    public int O00000o0() throws IOException {
        if (!O000000o(this.O0000o0O.O000000o())) {
            return -1;
        }
        byte[] O00000o = O00000o();
        Object obj = null;
        Object obj2 = (O00000o == null || O00000o.length <= O0000OOo.length) ? null : 1;
        if (obj2 != null) {
            for (int i = 0; i < O0000OOo.length; i++) {
                if (O00000o[i] != O0000OOo[i]) {
                    break;
                }
            }
        }
        obj = obj2;
        return obj != null ? O000000o(new O000000o(O00000o)) : -1;
    }
}
