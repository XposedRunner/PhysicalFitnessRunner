package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.entity.AutoFixBean;
import com.zjwh.android_wh_physicalfitness.entity.AutoFixBean.State;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hy.O000000o;
import defpackage.hy.O00000Oo;
import java.lang.ref.WeakReference;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: AutoFixPImpl */
/* renamed from: kj */
public class kj extends iu<O00000Oo> implements O000000o {
    static final String O000000o = "extra_satellite";
    public static final String O00000Oo = "extra_need_send";
    private O000000o O00000o;
    private Handler O00000oO;
    private Runnable O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private List<Long> O0000Oo;
    private int O0000Oo0;
    private List<AutoFixBean> O0000OoO;
    private boolean O0000Ooo;
    private boolean O0000o0;
    private boolean O0000o00;
    private int O0000o0O;

    /* compiled from: AutoFixPImpl */
    /* renamed from: kj$1 */
    class 1 extends fw<AutoFixBean> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ kj O00000Oo;

        /* compiled from: AutoFixPImpl */
        /* renamed from: kj$1$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ AutoFixBean O000000o;
            final /* synthetic */ 1 O00000Oo;

            1(1 1, AutoFixBean autoFixBean) {
            }

            public void onClick(View view) {
            }
        }

        1(kj kjVar, Context context, int i, List list, Context context2) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, AutoFixBean autoFixBean, int i) {
        }
    }

    /* compiled from: AutoFixPImpl */
    /* renamed from: kj$2 */
    class 2 extends BroadcastReceiver {
        final /* synthetic */ kj O000000o;

        2(kj kjVar) {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }

    /* compiled from: AutoFixPImpl */
    /* renamed from: kj$3 */
    class 3 implements Runnable {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ kj O00000Oo;

        3(kj kjVar, Context context) {
        }

        public void run() {
        }
    }

    /* compiled from: AutoFixPImpl */
    /* renamed from: kj$4 */
    class 4 implements MyCallback<String> {
        final /* synthetic */ long O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ kj O00000o0;

        4(kj kjVar, long j, int i) {
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

    /* compiled from: AutoFixPImpl */
    /* renamed from: kj$5 */
    static /* synthetic */ class 5 {
        static final /* synthetic */ int[] O000000o = new int[State.values().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        static {
            /*
            r0 = com.zjwh.android_wh_physicalfitness.entity.AutoFixBean.State.values();
            r0 = r0.length;
            r0 = new int[r0];
            O000000o = r0;
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.zjwh.android_wh_physicalfitness.entity.AutoFixBean.State.Loading;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.zjwh.android_wh_physicalfitness.entity.AutoFixBean.State.Normal;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.zjwh.android_wh_physicalfitness.entity.AutoFixBean.State.Error;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = com.zjwh.android_wh_physicalfitness.entity.AutoFixBean.State.Jump;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.kj$5.<clinit>():void");
        }
    }

    /* compiled from: AutoFixPImpl */
    /* renamed from: kj$O000000o */
    private class O000000o extends Handler {
        final /* synthetic */ kj O000000o;
        private final WeakReference<kj> O00000Oo;

        O000000o(kj kjVar, kj kjVar2) {
        }

        public void handleMessage(Message message) {
        }
    }

    public kj(O00000Oo o00000Oo) {
    }

    private void O000000o(Context context, int i) {
    }

    private void O000000o(Message message) {
    }

    static /* synthetic */ void O000000o(kj kjVar, Context context, int i) {
    }

    private void O00000o() {
    }

    private void O00000o(Context context) {
    }

    private void O00000oO() {
    }

    private void O00000oO(Context context) {
    }

    private void O00000oo(Context context) {
    }

    public int O000000o() {
        return 0;
    }

    public void O000000o(Context context) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(Context context) {
    }

    public BroadcastReceiver O00000o0() {
        return null;
    }

    public fw<AutoFixBean> O00000o0(Context context) {
        return null;
    }

    public void O0000OoO() {
    }
}
