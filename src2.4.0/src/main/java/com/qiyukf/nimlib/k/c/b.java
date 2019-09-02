package com.qiyukf.nimlib.k.c;

public enum b {
    TYPE_LOG(a.c),
    TYPE_TEMP(a.d),
    TYPE_FILE(a.b),
    TYPE_AUDIO(a.a),
    TYPE_IMAGE(a.e),
    TYPE_VIDEO(a.g),
    TYPE_THUMB_IMAGE(a.f);
    
    private a h;
    private long i;

    enum a {
        public static final a a = null;
        public static final a b = null;
        public static final a c = null;
        public static final a d = null;
        public static final a e = null;
        public static final a f = null;
        public static final a g = null;
        private static final /* synthetic */ a[] i = null;
        private final String h;

        static {
            a = new a("AUDIO_DIRECTORY_NAME", 0, "audio/");
            b = new a("FILE_DIRECTORY_NAME", 1, "file/");
            c = new a("LOG_DIRECTORY_NAME", 2, "log/");
            d = new a("TEMP_DIRECTORY_NAME", 3, "temp/");
            e = new a("IMAGE_DIRECTORY_NAME", 4, "image/");
            f = new a("THUMB_DIRECTORY_NAME", 5, "thumb/");
            g = new a("VIDEO_DIRECTORY_NAME", 6, "video/");
            i = new a[]{a, b, c, d, e, f, g};
        }

        private a(String str, int i, String str2) {
            this.h = str2;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) i.clone();
        }

        public final String a() {
            return this.h;
        }
    }

    private b(a aVar) {
        this(r2, r3, aVar, (byte) 0);
    }

    private b(a aVar, byte b) {
        this.h = aVar;
        this.i = 20971520;
    }

    public final String a() {
        return this.h.a();
    }

    public final long b() {
        return this.i;
    }
}
