package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.mine.SportConcernFansBean;
import java.util.List;

/* compiled from: SportConcernFansAdapter */
/* renamed from: fj */
public class fj extends Adapter {
    private List<SportConcernFansBean> O000000o;
    private O00000o0 O00000Oo;

    /* compiled from: SportConcernFansAdapter */
    /* renamed from: fj$O00000o0 */
    public interface O00000o0 {
        void O000000o(int i, int i2, SportConcernFansBean sportConcernFansBean);
    }

    /* compiled from: SportConcernFansAdapter */
    /* renamed from: fj$1 */
    class 1 implements OnClickListener {
        final /* synthetic */ SportConcernFansBean O000000o;
        final /* synthetic */ ViewHolder O00000Oo;
        final /* synthetic */ fj O00000o0;

        1(fj fjVar, SportConcernFansBean sportConcernFansBean, ViewHolder viewHolder) {
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: SportConcernFansAdapter */
    /* renamed from: fj$2 */
    class 2 implements OnClickListener {
        final /* synthetic */ ViewHolder O000000o;
        final /* synthetic */ SportConcernFansBean O00000Oo;
        final /* synthetic */ fj O00000o0;

        2(fj fjVar, ViewHolder viewHolder, SportConcernFansBean sportConcernFansBean) {
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: SportConcernFansAdapter */
    /* renamed from: fj$O000000o */
    private static class O000000o extends ViewHolder {
        private TextView O000000o;

        O000000o(View view) {
        }
    }

    /* compiled from: SportConcernFansAdapter */
    /* renamed from: fj$O00000Oo */
    private static class O00000Oo extends ViewHolder {
        private ImageView O000000o;
        private TextView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private View O00000oO;

        O00000Oo(View view) {
        }
    }

    public fj(O00000o0 o00000o0) {
    }

    public void O000000o(List<SportConcernFansBean> list) {
    }

    public int getItemCount() {
        return 0;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }
}
