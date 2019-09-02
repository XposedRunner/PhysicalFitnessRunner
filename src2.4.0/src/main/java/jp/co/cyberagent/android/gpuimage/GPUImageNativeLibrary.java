package jp.co.cyberagent.android.gpuimage;

public class GPUImageNativeLibrary {
    static {
        System.loadLibrary("gpuimage-library");
    }

    public static native void YUVtoARBG(byte[] bArr, int i, int i2, int[] iArr);

    public static native void YUVtoRBGA(byte[] bArr, int i, int i2, int[] iArr);
}
