package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;
import com.zjwh.android_wh_physicalfitness.entity.music.MusicClassifyBean;
import defpackage.hq.O000000o;
import defpackage.hq.O00000Oo;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: MusicClassifyPImpl */
/* renamed from: ka */
public class ka extends iu<O00000Oo> implements O000000o {
    public static final long O000000o = -2;
    private String O00000Oo;
    private ArrayList<MusicClassifyBean> O00000o;
    private LinkedHashMap<String, String[]> O00000oO;

    /* compiled from: MusicClassifyPImpl */
    /* renamed from: ka$1 */
    class 1 implements IDataCallBack<CategoryList> {
        final /* synthetic */ ka O000000o;

        1(ka kaVar) {
        }

        public void O000000o(@Nullable CategoryList categoryList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    public ka(O00000Oo o00000Oo, Context context) {
    }

    private void O000000o(Context context) {
    }

    public void O000000o() {
    }

    public void O000000o(Bundle bundle) {
    }

    public String O00000Oo() {
        return null;
    }

    public void O00000Oo(Bundle bundle) {
    }
}
