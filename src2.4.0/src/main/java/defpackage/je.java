package defpackage;

import android.content.Context;
import android.content.Intent;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ChatNewMessageBean.OnChatMessageGetSuccessListener;
import com.zjwh.android_wh_physicalfitness.entity.MainBottomItemBean;
import com.zjwh.android_wh_physicalfitness.entity.MessageNewBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hb.O000000o;
import java.io.File;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.ProgressCallback;

/* compiled from: MainActivityPImpl */
/* renamed from: je */
public class je extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "run_point_res_url";
    public static final String O00000Oo = "run_point_res_ad_code";
    private static final int O00000o = 0;
    private static final int O00000oO = 1;
    private static final int O00000oo = 2;
    private kf O0000O0o;
    private Context O0000OOo;
    private int O0000Oo;
    private DbManager O0000Oo0;

    /* compiled from: MainActivityPImpl */
    /* renamed from: je$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ je O000000o;

        1(je jeVar) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
        }

        public void onFinished() {
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
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void onSuccess(java.lang.String r4) {
            /*
            r3 = this;
            return;	 Catch:{ Exception -> 0x0043 }
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.je$1.onSuccess(java.lang.String):void");
        }
    }

    /* compiled from: MainActivityPImpl */
    /* renamed from: je$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ je O000000o;

        /* compiled from: MainActivityPImpl */
        /* renamed from: je$2$1 */
        class 1 extends TypeToken<List<MessageNewBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(je jeVar) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
        }

        public void onFinished() {
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
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void onSuccess(java.lang.String r8) {
            /*
            r7 = this;
            return;	 Catch:{ Exception -> 0x008e }
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.je$2.onSuccess(java.lang.String):void");
        }
    }

    /* compiled from: MainActivityPImpl */
    /* renamed from: je$3 */
    class 3 implements MyCallback<String> {
        final /* synthetic */ je O000000o;

        3(je jeVar) {
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

    /* compiled from: MainActivityPImpl */
    /* renamed from: je$4 */
    class 4 implements MyCallback<String> {
        final /* synthetic */ je O000000o;

        /* compiled from: MainActivityPImpl */
        /* renamed from: je$4$1 */
        class 1 extends TypeToken<List<MainBottomItemBean>> {
            final /* synthetic */ 4 O000000o;

            1(4 4) {
            }
        }

        4(je jeVar) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
        }

        public void onFinished() {
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
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void onSuccess(java.lang.String r9) {
            /*
            r8 = this;
            return;	 Catch:{ Exception -> 0x00e3 }
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.je$4.onSuccess(java.lang.String):void");
        }
    }

    /* compiled from: MainActivityPImpl */
    /* renamed from: je$5 */
    class 5 implements OnChatMessageGetSuccessListener {
        final /* synthetic */ je O000000o;

        5(je jeVar) {
        }

        public void onSuccess(Cancelable cancelable, int i) {
        }
    }

    /* compiled from: MainActivityPImpl */
    /* renamed from: je$6 */
    class 6 implements MyCallback<String> {
        final /* synthetic */ je O000000o;

        6(je jeVar) {
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

    /* compiled from: MainActivityPImpl */
    /* renamed from: je$7 */
    class 7 implements ProgressCallback<File> {
        final /* synthetic */ String O000000o;
        final /* synthetic */ je O00000Oo;

        7(je jeVar, String str) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(Throwable th, boolean z) {
        }

        public void onFinished() {
        }

        public void onLoading(long j, long j2, boolean z) {
        }

        public void onStarted() {
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
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void onSuccess(java.io.File r3) {
            /*
            r2 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.je$7.onSuccess(java.io.File):void");
        }

        public void onWaiting() {
        }
    }

    public je(O00000Oo o00000Oo, Context context) {
    }

    private int O000000o(String str, String str2) {
        return 0;
    }

    private void O000000o(Context context, MyCallback<String> myCallback) {
    }

    private void O000000o(String str) {
    }

    private void O000000o(String str, ProgressCallback<File> progressCallback) {
    }

    private String O00000Oo(String str) {
        return null;
    }

    static /* synthetic */ void O00000o(je jeVar) {
    }

    private void O00000oo() {
    }

    private void O0000O0o() {
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
    private void O0000OOo() {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.O0000OOo():void");
    }

    private void O0000Oo() {
    }

    private void O0000Oo0() {
    }

    public void O000000o() {
    }

    public void O000000o(int i, int i2, Intent intent) {
    }

    public void O00000Oo() {
    }

    public void O00000o() {
    }

    public void O00000o0() {
    }

    public void O00000oO() {
    }

    public void O0000OoO() {
    }
}
