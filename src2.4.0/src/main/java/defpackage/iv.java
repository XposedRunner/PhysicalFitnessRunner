package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.zjwh.android_wh_physicalfitness.entity.ChatBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o00;
import defpackage.go.O000000o;
import defpackage.go.O00000Oo;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.common.Callback.CancelledException;

/* compiled from: ChatPImpl */
/* renamed from: iv */
public class iv extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "extra_info";
    public static final String O00000Oo = "extra_receiver_id";
    public static final String O00000o = "extra_receiver_news";
    private long O00000oO;
    private int O00000oo;
    private ChatBean O0000O0o;
    private ChatFriendBean O0000OOo;
    private int O0000Oo;
    private DbManager O0000Oo0;

    /* compiled from: ChatPImpl */
    /* renamed from: iv$1 */
    class 1 extends BroadcastReceiver {
        final /* synthetic */ iv O000000o;

        1(iv ivVar) {
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
        public void onReceive(android.content.Context r11, android.content.Intent r12) {
            /*
            r10 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.iv$1.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* compiled from: ChatPImpl */
    /* renamed from: iv$2 */
    class 2 extends O00O0o00<List<ChatBean>> {
        final /* synthetic */ iv O000000o;

        2(iv ivVar) {
        }

        public List<ChatBean> O000000o() throws Exception {
            return null;
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(List<ChatBean> list) throws Exception {
        }

        public /* synthetic */ Object call() throws Exception {
            return null;
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ void onSuccess(Object obj) throws Exception {
        }
    }

    /* compiled from: ChatPImpl */
    /* renamed from: iv$3 */
    class 3 implements MyCallback<String> {
        final /* synthetic */ ChatBean O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ iv O00000o0;

        3(iv ivVar, ChatBean chatBean, int i) {
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

    /* compiled from: ChatPImpl */
    /* renamed from: iv$4 */
    class 4 implements MyCallback<String> {
        final /* synthetic */ iv O000000o;

        4(iv ivVar) {
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

    public iv(O00000Oo o00000Oo) {
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
    private void O000000o(long r2, java.lang.String r4, int r5, int r6, java.lang.String r7) {
        /*
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iv.O000000o(long, java.lang.String, int, int, java.lang.String):void");
    }

    static /* synthetic */ void O000000o(iv ivVar, long j, String str, int i, int i2, String str2) {
    }

    public String O000000o() {
        return null;
    }

    public void O000000o(Context context) {
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
    public void O000000o(android.content.Context r5, int r6, com.zjwh.android_wh_physicalfitness.entity.ChatBean r7) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iv.O000000o(android.content.Context, int, com.zjwh.android_wh_physicalfitness.entity.ChatBean):void");
    }

    public void O000000o(Bundle bundle) {
    }

    public void O000000o(String str) {
    }

    public BroadcastReceiver O00000Oo() {
        return null;
    }

    public ChatBean O00000Oo(String str) {
        return null;
    }

    public void O00000Oo(Context context) {
    }

    public void O00000Oo(Bundle bundle) {
    }

    public int O00000o() {
        return 0;
    }

    public int O00000o0() {
        return 0;
    }

    public String O00000oO() {
        return null;
    }

    public String O00000oo() {
        return null;
    }

    public String O0000O0o() {
        return null;
    }

    public String O0000OOo() {
        return null;
    }

    public void O0000Oo0() {
    }
}
