package jp.co.cyberagent.android.gpuimage;

/* compiled from: Rotation */
public enum O0o0000 {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    public static O0o0000 O000000o(int i) {
        if (i == 0) {
            return NORMAL;
        }
        if (i == 90) {
            return ROTATION_90;
        }
        if (i == 180) {
            return ROTATION_180;
        }
        if (i == 270) {
            return ROTATION_270;
        }
        if (i == 360) {
            return NORMAL;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public int O000000o() {
        switch (this) {
            case NORMAL:
                return 0;
            case ROTATION_90:
                return 90;
            case ROTATION_180:
                return 180;
            case ROTATION_270:
                return 270;
            default:
                throw new IllegalStateException("Unknown Rotation!");
        }
    }
}
