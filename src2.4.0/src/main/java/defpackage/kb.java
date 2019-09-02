package defpackage;

import android.content.Context;
import android.support.annotation.Nullable;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;
import com.ximalaya.ting.android.opensdk.model.ranks.RankList;
import com.zjwh.android_wh_physicalfitness.entity.BannerBean;
import com.zjwh.android_wh_physicalfitness.entity.music.MusicClassifyBean;
import com.zjwh.android_wh_physicalfitness.utils.O0000OOo;
import defpackage.hs.O000000o;
import defpackage.hs.O00000Oo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MusicMainPImpl */
/* renamed from: kb */
public class kb extends iu<O00000Oo> implements O000000o {
    public static final long O000000o = -2;
    public static final long O00000Oo = -3;
    private O0000OOo.O000000o O00000o;
    private ArrayList<MusicClassifyBean> O00000oO;
    private ArrayList<MusicClassifyBean> O00000oo;
    private List<BannerBean> O0000O0o;
    private boolean O0000OOo;
    private int O0000Oo;
    private boolean O0000Oo0;
    private String O0000OoO;

    /* compiled from: MusicMainPImpl */
    /* renamed from: kb$1 */
    class 1 implements IDataCallBack<AlbumList> {
        final /* synthetic */ kb O000000o;

        1(kb kbVar) {
        }

        public void O000000o(@Nullable AlbumList albumList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    /* compiled from: MusicMainPImpl */
    /* renamed from: kb$2 */
    class 2 implements IDataCallBack<CategoryList> {
        final /* synthetic */ kb O000000o;

        2(kb kbVar) {
        }

        public void O000000o(@Nullable CategoryList categoryList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    /* compiled from: MusicMainPImpl */
    /* renamed from: kb$3 */
    class 3 implements IDataCallBack<RankList> {
        final /* synthetic */ kb O000000o;

        3(kb kbVar) {
        }

        public void O000000o(@Nullable RankList rankList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    /* compiled from: MusicMainPImpl */
    /* renamed from: kb$4 */
    class 4 implements O0000OOo.O000000o {
        final /* synthetic */ kb O000000o;

        4(kb kbVar) {
        }

        public void O000000o() {
        }

        public void O000000o(List<BannerBean> list) {
        }
    }

    public kb(O00000Oo o00000Oo, Context context) {
    }

    private void O00000Oo(Context context) {
    }

    private void O00000o() {
    }

    private void O00000o0() {
    }

    private void O00000o0(Context context) {
    }

    public void O000000o() {
    }

    public void O000000o(Context context) {
    }

    public void O00000Oo() {
    }

    public void O0000OoO() {
    }
}
