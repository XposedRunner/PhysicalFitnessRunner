package defpackage;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import com.zjwh.android_wh_physicalfitness.entity.database.MusicHistoryBean;
import defpackage.ht.O000000o;
import defpackage.ht.O00000Oo;
import java.util.List;

/* compiled from: MusicPurchasedPImpl */
/* renamed from: kd */
public class kd extends iu<O00000Oo> implements O000000o {
    private List<MusicHistoryBean> O000000o;

    /* compiled from: MusicPurchasedPImpl */
    /* renamed from: kd$1 */
    class 1 extends fw<MusicHistoryBean> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ kd O00000Oo;

        /* compiled from: MusicPurchasedPImpl */
        /* renamed from: kd$1$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ MusicHistoryBean O000000o;
            final /* synthetic */ 1 O00000Oo;

            1(1 1, MusicHistoryBean musicHistoryBean) {
            }

            public void onClick(View view) {
            }
        }

        1(kd kdVar, Context context, int i, List list, Context context2) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, MusicHistoryBean musicHistoryBean, int i) {
        }
    }

    /* compiled from: MusicPurchasedPImpl */
    /* renamed from: kd$2 */
    class 2 implements IDataCallBack<AlbumList> {
        final /* synthetic */ kd O000000o;

        2(kd kdVar) {
        }

        public void O000000o(@Nullable AlbumList albumList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    public kd(O00000Oo o00000Oo) {
    }

    public fw<MusicHistoryBean> O000000o(Context context) {
        return null;
    }

    public void O00000Oo(Context context) {
    }

    public void O00000o(Context context) {
    }

    public void O00000o0(Context context) {
    }
}
