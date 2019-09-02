package defpackage;

import android.content.Context;
import android.content.Intent;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.GT3Listener;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.ha.O000000o;
import defpackage.ha.O00000Oo;
import java.util.Map;
import org.xutils.common.Callback.CancelledException;

/* compiled from: LoginPImpl */
/* renamed from: jd */
public class jd extends iu<O00000Oo> implements O000000o {
    public static final int O000000o = 18001;
    public static final int O00000Oo = 18002;
    public static final int O00000o = 18003;
    public static final int O00000oO = 18010;
    public static final int O00000oo = 18011;
    public static final int O0000O0o = 10504;
    private GT3GeetestUtils O0000OOo;
    private Context O0000Oo;
    private String O0000Oo0;
    private kf O0000OoO;

    /* compiled from: LoginPImpl */
    /* renamed from: jd$1 */
    class 1 extends GT3Listener {
        final /* synthetic */ String O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ jd O00000o;
        final /* synthetic */ GT3ConfigBean O00000o0;

        /* compiled from: LoginPImpl */
        /* renamed from: jd$1$1 */
        class 1 implements jb.O00000Oo {
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
                	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
                	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
                	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
                	at jadx.core.ProcessClass.process(ProcessClass.java:37)
                	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
                	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
                */
            public void O000000o(java.lang.String r5) {
                /*
                r4 = this;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.jd$1$1.O000000o(java.lang.String):void");
            }
        }

        /* compiled from: LoginPImpl */
        /* renamed from: jd$1$2 */
        class 2 implements jb.O00000Oo {
            final /* synthetic */ 1 O000000o;

            2(1 1) {
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
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.ProcessClass.process(ProcessClass.java:32)
                	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
                	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
                	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
                	at jadx.core.ProcessClass.process(ProcessClass.java:37)
                	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
                	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
                */
            public void O000000o(java.lang.String r3) {
                /*
                r2 = this;
                return;	 Catch:{ JSONException -> 0x0018 }
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.jd$1$2.O000000o(java.lang.String):void");
            }
        }

        1(jd jdVar, String str, int i, GT3ConfigBean gT3ConfigBean) {
        }

        public void onApi1Result(String str) {
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

    /* compiled from: LoginPImpl */
    /* renamed from: jd$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ boolean O000000o;
        final /* synthetic */ jd O00000Oo;

        2(jd jdVar, boolean z) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
        }
    }

    public jd(Context context, O00000Oo o00000Oo) {
    }

    private MyCallback<String> O000000o(boolean z) {
        return null;
    }

    private void O000000o(UserInfo userInfo) {
    }

    private Map<String, String> O00000Oo(String str) {
        return null;
    }

    public void O000000o() {
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void O000000o(int r4) {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jd.O000000o(int):void");
    }

    public void O000000o(int i, int i2, Intent intent) {
    }

    public void O000000o(int i, String str) {
    }

    public void O000000o(ResponseError responseError, String str) {
    }

    public void O000000o(String str) {
    }

    public void O0000OoO() {
    }
}
