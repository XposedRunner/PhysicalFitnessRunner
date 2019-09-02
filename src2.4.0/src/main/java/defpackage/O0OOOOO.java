package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.File;
import java.io.InputStream;

/* compiled from: MediaStoreThumbFetcher */
/* renamed from: O0OOOOO */
public class O0OOOOO implements O0Oo0o0<InputStream> {
    private static final String O000000o = "MediaStoreThumbFetcher";
    private static final int O00000Oo = 512;
    private static final O0000O0o O00000o = new O0000O0o();
    private static final int O00000o0 = 384;
    private final Context O00000oO;
    private final Uri O00000oo;
    private final O0Oo0o0<InputStream> O0000O0o;
    private final int O0000OOo;
    private final O0000O0o O0000Oo;
    private final int O0000Oo0;
    private InputStream O0000OoO;

    /* compiled from: MediaStoreThumbFetcher */
    /* renamed from: O0OOOOO$O000000o */
    static class O000000o {
        O000000o() {
        }

        public File O000000o(String str) {
            return null;
        }

        public boolean O000000o(File file) {
            return false;
        }

        public long O00000Oo(File file) {
            return 0;
        }
    }

    /* compiled from: MediaStoreThumbFetcher */
    /* renamed from: O0OOOOO$O00000o0 */
    interface O00000o0 {
        Cursor O000000o(Context context, Uri uri);
    }

    /* compiled from: MediaStoreThumbFetcher */
    /* renamed from: O0OOOOO$O00000Oo */
    static class O00000Oo implements O00000o0 {
        private static final String[] O000000o = new String[]{"_data"};
        private static final String O00000Oo = "kind = 1 AND image_id = ?";

        O00000Oo() {
        }

        public Cursor O000000o(Context context, Uri uri) {
            return null;
        }
    }

    /* compiled from: MediaStoreThumbFetcher */
    /* renamed from: O0OOOOO$O00000o */
    static class O00000o {
        private static final O000000o O000000o = new O000000o();
        private final O000000o O00000Oo;
        private O00000o0 O00000o0;

        public O00000o(O000000o o000000o, O00000o0 o00000o0) {
        }

        public O00000o(O00000o0 o00000o0) {
        }

        private Uri O000000o(Cursor cursor) {
            return null;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:3:0x0002
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public int O000000o(android.content.Context r6, android.net.Uri r7) {
            /*
            r5 = this;
            r0 = 0;
            return r0;	 Catch:{ IOException -> 0x001d, all -> 0x001a }
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.O0OOOOO$O00000o.O000000o(android.content.Context, android.net.Uri):int");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0002
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public java.io.InputStream O00000Oo(android.content.Context r3, android.net.Uri r4) throws java.io.FileNotFoundException {
            /*
            r2 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.O0OOOOO$O00000o.O00000Oo(android.content.Context, android.net.Uri):java.io.InputStream");
        }
    }

    /* compiled from: MediaStoreThumbFetcher */
    /* renamed from: O0OOOOO$O0000O0o */
    static class O0000O0o {
        O0000O0o() {
        }

        public O00000o O000000o(Uri uri, int i, int i2) {
            return null;
        }
    }

    /* compiled from: MediaStoreThumbFetcher */
    /* renamed from: O0OOOOO$O0000OOo */
    static class O0000OOo implements O00000o0 {
        private static final String[] O000000o = new String[]{"_data"};
        private static final String O00000Oo = "kind = 1 AND video_id = ?";

        O0000OOo() {
        }

        public Cursor O000000o(Context context, Uri uri) {
            return null;
        }
    }

    public O0OOOOO(Context context, Uri uri, O0Oo0o0<InputStream> o0Oo0o0, int i, int i2) {
    }

    O0OOOOO(Context context, Uri uri, O0Oo0o0<InputStream> o0Oo0o0, int i, int i2, O0000O0o o0000O0o) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:3:0x0002
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private java.io.InputStream O000000o(defpackage.O0OOOOO.O00000o r5) {
        /*
        r4 = this;
        r0 = 0;	 Catch:{ FileNotFoundException -> 0x0009 }
        return r0;	 Catch:{ FileNotFoundException -> 0x0009 }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.O0OOOOO.O000000o(O0OOOOO$O00000o):java.io.InputStream");
    }

    private static boolean O00000o(Uri uri) {
        return false;
    }

    private static boolean O00000o0(Uri uri) {
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void O000000o() {
        /*
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.O0OOOOO.O000000o():void");
    }

    public InputStream O00000Oo(O00o0000 o00o0000) throws Exception {
        return null;
    }

    public String O00000Oo() {
        return null;
    }

    public void O00000o0() {
    }
}
