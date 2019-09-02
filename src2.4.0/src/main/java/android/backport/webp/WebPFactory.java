package android.backport.webp;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.ByteArrayOutputStream;

public final class WebPFactory {
    private static boolean loadSoLibError = true;

    static {
        try {
            System.loadLibrary("webpbackport");
        } catch (Throwable unused) {
        }
    }

    private WebPFactory() {
    }

    public static boolean available() {
        return loadSoLibError ^ 1;
    }

    public static Bitmap decodeByteArray(byte[] bArr, Options options) {
        return available() ? nativeDecodeByteArray(bArr, options) : BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap decodeFile(String str, Options options) {
        return available() ? nativeDecodeFile(str, options) : BitmapFactory.decodeFile(str, options);
    }

    public static byte[] encodeBitmap(Bitmap bitmap, int i) {
        if (available()) {
            return nativeEncodeBitmap(bitmap, i);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.WEBP, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, Options options);

    private static native Bitmap nativeDecodeFile(String str, Options options);

    private static native byte[] nativeEncodeBitmap(Bitmap bitmap, int i);
}
