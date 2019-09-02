package defpackage;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders */
/* renamed from: OOOOo0 */
public final class OOOOo0 implements OOO0o00 {
    private volatile Map<String, String> O00000o;
    private final Map<String, List<OOOO0>> O00000o0;

    /* compiled from: LazyHeaders */
    /* renamed from: OOOOo0$O000000o */
    public static final class O000000o {
        private static final String O000000o = "User-Agent";
        private static final String O00000Oo = System.getProperty("http.agent");
        private static final String O00000o = "identity";
        private static final String O00000o0 = "Accept-Encoding";
        private static final Map<String, List<OOOO0>> O00000oO;
        private boolean O00000oo;
        private Map<String, List<OOOO0>> O0000O0o;
        private boolean O0000OOo;
        private boolean O0000Oo0;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(O00000Oo)) {
                hashMap.put(O000000o, Collections.singletonList(new O00000Oo(O00000Oo)));
            }
            hashMap.put(O00000o0, Collections.singletonList(new O00000Oo(O00000o)));
            O00000oO = Collections.unmodifiableMap(hashMap);
        }

        private List<OOOO0> O000000o(String str) {
            return null;
        }

        private void O00000Oo() {
        }

        private Map<String, List<OOOO0>> O00000o0() {
            return null;
        }

        public O000000o O000000o(String str, OOOO0 oooo0) {
            return null;
        }

        public O000000o O000000o(String str, String str2) {
            return null;
        }

        public OOOOo0 O000000o() {
            return null;
        }

        public O000000o O00000Oo(String str, OOOO0 oooo0) {
            return null;
        }

        public O000000o O00000Oo(String str, String str2) {
            return null;
        }
    }

    /* compiled from: LazyHeaders */
    /* renamed from: OOOOo0$O00000Oo */
    static final class O00000Oo implements OOOO0 {
        private final String O000000o;

        O00000Oo(String str) {
        }

        public String O000000o() {
            return null;
        }

        public boolean equals(Object obj) {
            return false;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return null;
        }
    }

    OOOOo0(Map<String, List<OOOO0>> map) {
    }

    private Map<String, String> O00000Oo() {
        return null;
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
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public java.util.Map<java.lang.String, java.lang.String> O000000o() {
        /*
        r1 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.OOOOo0.O000000o():java.util.Map");
    }

    public boolean equals(Object obj) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return null;
    }
}
