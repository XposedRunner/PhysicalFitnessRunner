package defpackage;

import android.content.Context;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.GT3Listener;
import java.util.Map;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.CommonCallback;

/* compiled from: Gt3Helper */
/* renamed from: jb */
public class jb {
    private GT3GeetestUtils O000000o;
    private GT3ConfigBean O00000Oo;
    private Map<String, String> O00000o0;

    /* compiled from: Gt3Helper */
    /* renamed from: jb$O00000Oo */
    public interface O00000Oo {
        void O000000o(String str);
    }

    /* compiled from: Gt3Helper */
    /* renamed from: jb$1 */
    class 1 extends GT3Listener {
        final /* synthetic */ O000000o O000000o;
        final /* synthetic */ jb O00000Oo;

        /* compiled from: Gt3Helper */
        /* renamed from: jb$1$1 */
        class 1 implements O00000Oo {
            final /* synthetic */ 1 O000000o;

            1(1 1) {
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
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.ProcessClass.process(ProcessClass.java:32)
                	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
                	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
                */
            public void O000000o(java.lang.String r5) {
                /*
                r4 = this;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.jb$1$1.O000000o(java.lang.String):void");
            }
        }

        /* compiled from: Gt3Helper */
        /* renamed from: jb$1$2 */
        class 2 implements O00000Oo {
            final /* synthetic */ 1 O000000o;

            2(1 1) {
            }

            public void O000000o(String str) {
            }
        }

        1(jb jbVar, O000000o o000000o) {
        }

        public void onButtonClick() {
        }

        public void onClosed(int i) {
        }

        public void onDialogResult(String str) {
        }

        public void onFailed(GT3ErrorBean gT3ErrorBean) {
        }

        public void onStatistics(String str) {
        }

        public void onSuccess(String str) {
        }
    }

    /* compiled from: Gt3Helper */
    /* renamed from: jb$2 */
    static class 2 implements CommonCallback<String> {
        final /* synthetic */ O00000Oo O000000o;

        2(O00000Oo o00000Oo) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(Throwable th, boolean z) {
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
        }
    }

    /* compiled from: Gt3Helper */
    /* renamed from: jb$3 */
    static class 3 implements CommonCallback<String> {
        final /* synthetic */ O00000Oo O000000o;

        3(O00000Oo o00000Oo) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(Throwable th, boolean z) {
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
        }
    }

    /* compiled from: Gt3Helper */
    /* renamed from: jb$O000000o */
    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public jb(Context context) {
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
    public static void O000000o(java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3, java.lang.String r4, defpackage.jb.O00000Oo r5) {
        /*
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jb.O000000o(java.lang.String, java.util.Map, java.lang.String, jb$O00000Oo):void");
    }

    public static void O000000o(String str, Map<String, String> map, O00000Oo o00000Oo) {
    }

    public void O000000o() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0001
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
    public void O000000o(java.lang.String r3) {
        /*
        r2 = this;
        return;	 Catch:{ JSONException -> 0x000b }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jb.O000000o(java.lang.String):void");
    }

    public void O000000o(Map<String, String> map) {
    }

    public void O000000o(O000000o o000000o) {
    }

    public void O00000Oo() {
    }

    public void O00000o() {
    }

    public void O00000o0() {
    }

    public void O00000oO() {
    }

    public void O00000oo() {
    }

    public void O0000O0o() {
    }
}
