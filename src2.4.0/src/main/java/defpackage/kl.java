package defpackage;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.geetest.deepknow.listener.DPJudgementListener;
import com.zjwh.android_wh_physicalfitness.entity.BlurDialogMsg;
import com.zjwh.android_wh_physicalfitness.entity.GetDrawChanceBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.UploadFormatEntity;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.entity.database.MyLocation;
import com.zjwh.android_wh_physicalfitness.entity.database.SpeedPerTenSec;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;
import com.zjwh.android_wh_physicalfitness.entity.database.StepsPerTenSec;
import com.zjwh.android_wh_physicalfitness.service.RunLocationService;
import com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o00;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.ia.O000000o;
import defpackage.ia.O00000Oo;
import java.util.List;
import java.util.Map;
import org.xutils.DbManager;
import org.xutils.common.Callback.CancelledException;
import org.xutils.ex.DbException;

/* compiled from: BaseRunPImpl */
/* renamed from: kl */
public abstract class kl<T extends O00000Oo> extends iu<T> implements O0000O0o, O000000o {
    public static final String O000000o = "action_daemon_weak";
    public static final int O00000Oo = 1000;
    private static final String O000OO = "save_total_step";
    private static final String O000OOOo = "save_total_time";
    private static final String O000OOo = "save_pass_enough";
    private static final String O000OOo0 = "save_dis_enough";
    private static final String O000OOoO = "save_asses_pass";
    private static final String O000OOoo = "save_runec";
    boolean O00000o;
    protected Context O00000oO;
    public RunLocationService O00000oo;
    List<FivePoint> O0000O0o;
    DbManager O0000OOo;
    String O0000Oo;
    SportRecord O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    SWLatLng O0000o;
    boolean O0000o0;
    int O0000o00;
    long O0000o0O;
    double O0000o0o;
    long O0000oO;
    int O0000oO0;
    int O0000oOO;
    int O0000oOo;
    int O0000oo;
    int O0000oo0;
    protected int O0000ooO;
    boolean O0000ooo;
    boolean O000O00o;
    boolean O000O0OO;
    boolean O000O0Oo;
    double O000O0o;
    double O000O0o0;
    int O000O0oO;
    int O000O0oo;
    int O000OO00;
    long O000OO0o;
    private MyLocation O000Oo0;
    private int O000Oo00;
    private boolean O000Oo0O;
    private boolean O000Oo0o;
    private boolean O000OoO;
    private boolean O000OoO0;
    private long O000OoOO;
    private long O000OoOo;
    private List<StepsPerTenSec> O000Ooo;
    private boolean O000Ooo0;
    private List<SpeedPerTenSec> O000OooO;
    private GetDrawChanceBean O000Oooo;
    private boolean O000o;
    private double O000o0;
    private int O000o00;
    private int O000o000;
    private int O000o00O;
    private int O000o00o;
    private float O000o0O;
    private double O000o0O0;
    private float O000o0OO;
    private float O000o0Oo;
    private int O000o0o;
    private float O000o0o0;
    private boolean O000o0oo;
    private jb O000oO0;
    private SWLatLng O000oO00;
    private ServiceConnection O000oO0O;
    private boolean O00O0Oo;
    boolean O00oOoOo;
    boolean O00oOooO;
    boolean O00oOooo;

    /* compiled from: BaseRunPImpl */
    /* renamed from: kl$1 */
    class 1 extends BroadcastReceiver {
        final /* synthetic */ kl O000000o;

        1(kl klVar) {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }

    /* compiled from: BaseRunPImpl */
    /* renamed from: kl$2 */
    class 2 implements ServiceConnection {
        final /* synthetic */ kl O000000o;

        2(kl klVar) {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: BaseRunPImpl */
    /* renamed from: kl$3 */
    class 3 extends O00O0o00<gj> {
        final /* synthetic */ kl O000000o;

        /* compiled from: BaseRunPImpl */
        /* renamed from: kl$3$1 */
        class 1 implements MyCallback<String> {
            final /* synthetic */ 3 O000000o;

            /* compiled from: BaseRunPImpl */
            /* renamed from: kl$3$1$1 */
            class 1 implements DPJudgementListener {
                final /* synthetic */ 1 O000000o;

                1(1 1) {
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
                public void onDeepKnowResult(org.json.JSONObject r4) {
                    /*
                    r3 = this;
                    return;	 Catch:{ JSONException -> 0x0028 }
                    */
                    throw new UnsupportedOperationException("Method not decompiled: defpackage.kl$3$1$1.onDeepKnowResult(org.json.JSONObject):void");
                }

                public void onError(String str, String str2) {
                }
            }

            1(3 3) {
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

        3(kl klVar) {
        }

        public gj O000000o() throws Exception {
            return null;
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(gj gjVar) throws Exception {
        }

        public /* synthetic */ Object call() throws Exception {
            return null;
        }

        /* Access modifiers changed, original: protected */
        public void onException(Exception exception) throws RuntimeException {
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ void onSuccess(Object obj) throws Exception {
        }

        /* Access modifiers changed, original: protected */
        public void onThrowable(Throwable th) throws RuntimeException {
        }
    }

    /* compiled from: BaseRunPImpl */
    /* renamed from: kl$4 */
    class 4 implements jb.O000000o {
        final /* synthetic */ kl O000000o;

        4(kl klVar) {
        }

        public void O000000o() {
        }

        public void O00000Oo() {
        }
    }

    /* compiled from: BaseRunPImpl */
    /* renamed from: kl$5 */
    class 5 implements MyCallback<String> {
        final /* synthetic */ kl O000000o;

        5(kl klVar) {
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

    kl(Context context) {
    }

    private void O000000o(Context context) {
    }

    static /* synthetic */ void O0000Oo0(kl klVar) {
    }

    private String O0000oo() {
        return null;
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
    private synchronized void O0000ooO() {
        /*
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O0000ooO():void");
    }

    private void O0000ooo() {
    }

    private Map<String, String> O00oOooO() {
        return null;
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
    private void O00oOooo() {
        /*
        r14 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O00oOooo():void");
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void O000000o() {
        /*
        r2 = this;
        return;	 Catch:{ Exception -> 0x001d }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O000000o():void");
    }

    public void O000000o(double d) {
    }

    public void O000000o(double d, double d2, double d3, double d4, float f) {
    }

    public void O000000o(int i, float f) {
    }

    public void O000000o(int i, boolean z, int i2) {
    }

    public void O000000o(long j) {
    }

    public void O000000o(long j, boolean z) {
    }

    public void O000000o(Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(GetDrawChanceBean getDrawChanceBean) {
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
    public void O000000o(com.zjwh.android_wh_physicalfitness.entity.database.MyLocation r19) {
        /*
        r18 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O000000o(com.zjwh.android_wh_physicalfitness.entity.database.MyLocation):void");
    }

    public void O000000o(boolean z) {
    }

    public void O000000o(boolean z, boolean z2) {
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public boolean O000000o(int r2) {
        /*
        r1 = this;
        r0 = 0;	 Catch:{ Exception -> 0x0015 }
        return r0;	 Catch:{ Exception -> 0x0015 }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O000000o(int):boolean");
    }

    public void O00000Oo() {
    }

    public void O00000Oo(double d) {
    }

    public void O00000Oo(int i) {
    }

    public void O00000Oo(long j) {
    }

    public void O00000Oo(Bundle bundle) {
    }

    public void O00000o() {
    }

    public void O00000o(int i) {
    }

    public void O00000o0(int i) {
    }

    public abstract void O00000o0(boolean z);

    public boolean O00000o0() {
        return false;
    }

    public void O00000oO() {
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
    public synchronized void O00000oo() {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O00000oo():void");
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
    public synchronized void O0000O0o() {
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O0000O0o():void");
    }

    public void O0000OOo() {
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
    public void O0000Oo() {
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O0000Oo():void");
    }

    public void O0000Oo0() {
    }

    public void O0000OoO() {
    }

    public SWLatLng O0000Ooo() {
        return null;
    }

    public boolean O0000o() {
        return false;
    }

    public boolean O0000o0() {
        return false;
    }

    public void O0000o00() {
    }

    public boolean O0000o0O() {
        return false;
    }

    public boolean O0000o0o() {
        return false;
    }

    public BlurDialogMsg O0000oO() {
        return null;
    }

    public boolean O0000oO0() {
        return false;
    }

    public BroadcastReceiver O0000oOO() {
        return null;
    }

    public void O0000oOo() {
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
    public void O0000oo0() {
        /*
        r5 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O0000oo0():void");
    }

    public abstract void O000O0Oo();

    /* Access modifiers changed, original: 0000 */
    public SportRecord O000O0o() {
        return null;
    }

    public abstract String O000O0o0() throws Exception;

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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    boolean O000O0oO() {
        /*
        r4 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O000O0oO():boolean");
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    protected boolean O000O0oo() {
        /*
        r22 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kl.O000O0oo():boolean");
    }

    public void O000OO() {
    }

    /* Access modifiers changed, original: 0000 */
    public UploadFormatEntity O000OO00() throws Exception {
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000OO0o() throws DbException {
    }

    public abstract void O00oOoOo();
}
