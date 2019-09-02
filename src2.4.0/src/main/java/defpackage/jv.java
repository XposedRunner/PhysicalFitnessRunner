package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.BatchAlbumList;
import com.ximalaya.ting.android.opensdk.model.pay.BoughtStatuList;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.music.MusicOrderBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hn.O000000o;
import defpackage.hn.O00000Oo;
import org.xutils.common.Callback.CancelledException;

/* compiled from: AlbumDetailPImpl */
/* renamed from: jv */
public class jv extends iu<O00000Oo> implements O000000o {
    private String O000000o;
    private long O00000Oo;
    private long O00000o;
    private boolean O00000oO;
    private boolean O00000oo;
    private double O0000O0o;
    private int O0000OOo;

    /* compiled from: AlbumDetailPImpl */
    /* renamed from: jv$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ jv O00000Oo;

        /* compiled from: AlbumDetailPImpl */
        /* renamed from: jv$1$1 */
        class 1 implements com.ximalaya.ting.android.xmpayordersdk.O000000o {
            final /* synthetic */ MusicOrderBean O000O0Oo;
            final /* synthetic */ 1 O00oOoOo;

            /* compiled from: AlbumDetailPImpl */
            /* renamed from: jv$1$1$1 */
            class 1 implements IDataCallBack<BoughtStatuList> {
                final /* synthetic */ 1 O000000o;

                1(1 1) {
                }

                public void O000000o(@Nullable BoughtStatuList boughtStatuList) {
                }

                public void onError(int i, String str) {
                }

                public /* synthetic */ void onSuccess(@Nullable Object obj) {
                }
            }

            1(1 1, MusicOrderBean musicOrderBean) {
            }

            public void O000000o(com.ximalaya.ting.android.xmpayordersdk.O00000Oo o00000Oo) {
            }
        }

        1(jv jvVar, Context context) {
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

    /* compiled from: AlbumDetailPImpl */
    /* renamed from: jv$2 */
    class 2 implements IDataCallBack<BoughtStatuList> {
        final /* synthetic */ jv O000000o;

        2(jv jvVar) {
        }

        public void O000000o(@Nullable BoughtStatuList boughtStatuList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    /* compiled from: AlbumDetailPImpl */
    /* renamed from: jv$3 */
    class 3 implements IDataCallBack<BatchAlbumList> {
        final /* synthetic */ jv O000000o;

        3(jv jvVar) {
        }

        public void O000000o(@Nullable BatchAlbumList batchAlbumList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    public jv(O00000Oo o00000Oo) {
    }

    public int O000000o() {
        return 0;
    }

    public void O000000o(Context context) {
    }

    public void O000000o(Bundle bundle) {
    }

    public long O00000Oo() {
        return 0;
    }

    public void O00000Oo(Bundle bundle) {
    }

    public boolean O00000o() {
        return false;
    }

    public long O00000o0() {
        return 0;
    }

    public String O00000oO() {
        return null;
    }

    public void O00000oo() {
    }

    public void O0000O0o() {
    }
}
