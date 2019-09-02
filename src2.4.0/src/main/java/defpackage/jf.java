package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ChatListBean;
import com.zjwh.android_wh_physicalfitness.entity.ChatNewMessageBean.OnChatMessageGetSuccessListener;
import com.zjwh.android_wh_physicalfitness.entity.MessageNewBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o00;
import defpackage.hc.O000000o;
import defpackage.hc.O00000Oo;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;

/* compiled from: MessagePIml */
/* renamed from: jf */
public class jf extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "action_chat_message_update";
    public static final int O00000Oo = 10000;
    private List<ChatListBean> O00000o;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private DbManager O0000Oo0;

    /* compiled from: MessagePIml */
    /* renamed from: jf$1 */
    class 1 extends fw<ChatListBean> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ jf O00000Oo;

        /* compiled from: MessagePIml */
        /* renamed from: jf$1$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ ChatFriendBean O000000o;
            final /* synthetic */ 1 O00000Oo;

            1(1 1, ChatFriendBean chatFriendBean) {
            }

            public void onClick(View view) {
            }
        }

        /* compiled from: MessagePIml */
        /* renamed from: jf$1$2 */
        class 2 implements OnClickListener {
            final /* synthetic */ ChatFriendBean O000000o;
            final /* synthetic */ ga O00000Oo;
            final /* synthetic */ 1 O00000o0;

            /* compiled from: MessagePIml */
            /* renamed from: jf$1$2$1 */
            class 1 extends O00O0o00<Void> {
                final /* synthetic */ 2 O000000o;

                1(2 2) {
                }

                public Void O000000o() throws Exception {
                    return null;
                }

                /* Access modifiers changed, original: protected */
                public void O000000o(Void voidR) throws Exception {
                }

                public /* synthetic */ Object call() throws Exception {
                    return null;
                }

                /* Access modifiers changed, original: protected|synthetic */
                public /* synthetic */ void onSuccess(Object obj) throws Exception {
                }

                /* Access modifiers changed, original: protected */
                public void onThrowable(Throwable th) throws RuntimeException {
                }
            }

            2(1 1, ChatFriendBean chatFriendBean, ga gaVar) {
            }

            public void onClick(View view) {
            }
        }

        1(jf jfVar, Context context, int i, List list, Context context2) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, ChatListBean chatListBean, int i) {
        }
    }

    /* compiled from: MessagePIml */
    /* renamed from: jf$2 */
    class 2 extends BroadcastReceiver {
        final /* synthetic */ jf O000000o;

        2(jf jfVar) {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }

    /* compiled from: MessagePIml */
    /* renamed from: jf$3 */
    class 3 extends O00O0o00<List<ChatListBean>> {
        final /* synthetic */ boolean O000000o;
        final /* synthetic */ Context O00000Oo;
        final /* synthetic */ jf O00000o0;

        3(jf jfVar, boolean z, Context context) {
        }

        public List<ChatListBean> O000000o() throws Exception {
            return null;
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(List<ChatListBean> list) throws Exception {
        }

        public /* synthetic */ Object call() throws Exception {
            return null;
        }

        /* Access modifiers changed, original: protected */
        public void onFinally() throws RuntimeException {
        }

        /* Access modifiers changed, original: protected */
        public void onPreExecute() throws Exception {
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ void onSuccess(Object obj) throws Exception {
        }
    }

    /* compiled from: MessagePIml */
    /* renamed from: jf$4 */
    class 4 implements MyCallback<String> {
        final /* synthetic */ jf O000000o;

        /* compiled from: MessagePIml */
        /* renamed from: jf$4$1 */
        class 1 extends TypeToken<List<MessageNewBean>> {
            final /* synthetic */ 4 O000000o;

            1(4 4) {
            }
        }

        4(jf jfVar) {
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

    /* compiled from: MessagePIml */
    /* renamed from: jf$5 */
    class 5 implements MyCallback<String> {
        final /* synthetic */ jf O000000o;

        /* compiled from: MessagePIml */
        /* renamed from: jf$5$1 */
        class 1 extends TypeToken<List<ChatFriendBean>> {
            final /* synthetic */ 5 O000000o;

            1(5 5) {
            }
        }

        5(jf jfVar) {
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
        public void onSuccess(java.lang.String r7) {
            /*
            r6 = this;
            return;	 Catch:{ DbException -> 0x0085 }
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.jf$5.onSuccess(java.lang.String):void");
        }
    }

    /* compiled from: MessagePIml */
    /* renamed from: jf$6 */
    class 6 implements OnChatMessageGetSuccessListener {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ jf O00000Oo;

        6(jf jfVar, Context context) {
        }

        public void onSuccess(Cancelable cancelable, int i) {
        }
    }

    public jf(O00000Oo o00000Oo) {
    }

    private void O00000oO(Context context) {
    }

    private void O00000oo(Context context) {
    }

    private void O0000O0o(Context context) {
    }

    public BroadcastReceiver O000000o() {
        return null;
    }

    public fw<ChatListBean> O000000o(Context context) {
        return null;
    }

    public void O000000o(int i) {
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
    public synchronized void O000000o(android.content.Context r2, boolean r3) {
        /*
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jf.O000000o(android.content.Context, boolean):void");
    }

    public int O00000Oo() {
        return 0;
    }

    public void O00000Oo(int i) {
    }

    public void O00000Oo(Context context) {
    }

    public int O00000o() {
        return 0;
    }

    public void O00000o(int i) {
    }

    public void O00000o(Context context) {
    }

    public int O00000o0() {
        return 0;
    }

    public void O00000o0(int i) {
    }

    public void O00000o0(Context context) {
    }

    public int O00000oO() {
        return 0;
    }

    public void O0000OoO() {
    }
}
