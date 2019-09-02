package defpackage;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SportMoodMatchBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o00.O0000O0o;
import java.io.File;
import java.util.List;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;

/* compiled from: DynamicPublishHelper */
/* renamed from: jn */
public class jn {

    /* compiled from: DynamicPublishHelper */
    /* renamed from: jn$1 */
    static class 1 implements O0000O0o {
        final /* synthetic */ List O000000o;
        final /* synthetic */ Context O00000Oo;
        final /* synthetic */ int O00000o;
        final /* synthetic */ int O00000o0;
        final /* synthetic */ String O00000oO;
        final /* synthetic */ int O00000oo;
        final /* synthetic */ String O0000O0o;
        final /* synthetic */ float O0000OOo;
        final /* synthetic */ O000000o O0000Oo0;

        /* compiled from: DynamicPublishHelper */
        /* renamed from: jn$1$1 */
        class 1 implements MyCallback<String> {
            final /* synthetic */ 1 O000000o;

            /* compiled from: DynamicPublishHelper */
            /* renamed from: jn$1$1$1 */
            class 1 extends TypeToken<List<Integer>> {
                final /* synthetic */ 1 O000000o;

                1(1 1) {
                }
            }

            1(1 1) {
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

        1(List list, Context context, int i, int i2, String str, int i3, String str2, float f, O000000o o000000o) {
        }

        public void O000000o() {
        }

        public void O000000o(List<File> list) {
        }
    }

    /* compiled from: DynamicPublishHelper */
    /* renamed from: jn$2 */
    static class 2 implements MyCallback<String> {
        final /* synthetic */ O000000o O000000o;

        2(O000000o o000000o) {
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

    /* compiled from: DynamicPublishHelper */
    /* renamed from: jn$3 */
    static class 3 implements MyCallback<String> {
        final /* synthetic */ O000000o O000000o;

        3(O000000o o000000o) {
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

    /* compiled from: DynamicPublishHelper */
    /* renamed from: jn$O000000o */
    public interface O000000o {
        void O000000o();

        void O000000o(ResponseError responseError);

        void O000000o(SportMoodMatchBean sportMoodMatchBean);

        void O00000Oo();

        void O00000Oo(ResponseError responseError);

        void O00000o0();
    }

    public static List<Cancelable> O000000o(Context context, List<String> list, String str, String str2, int i, int i2, float f, int i3, O000000o o000000o) {
        return null;
    }

    private static Cancelable O00000Oo(Context context, String str, List<Integer> list, float f, int i, O000000o o000000o) {
        return null;
    }

    private static Cancelable O00000Oo(Context context, String str, List<Integer> list, int i, String str2, float f, O000000o o000000o) {
        return null;
    }
}
