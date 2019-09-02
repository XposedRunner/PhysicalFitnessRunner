package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.music.MusicClassifyBean;
import java.util.List;

/* compiled from: MusicClassifyAdapter */
/* renamed from: fn */
public class fn extends Adapter<O000000o> {
    private List<MusicClassifyBean> O000000o;
    private O00000Oo O00000Oo;
    private String O00000o0;

    /* compiled from: MusicClassifyAdapter */
    /* renamed from: fn$O00000Oo */
    public interface O00000Oo {
        void O000000o(long j, String str);
    }

    /* compiled from: MusicClassifyAdapter */
    /* renamed from: fn$1 */
    class 1 implements OnClickListener {
        final /* synthetic */ MusicClassifyBean O000000o;
        final /* synthetic */ fn O00000Oo;

        1(fn fnVar, MusicClassifyBean musicClassifyBean) {
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: MusicClassifyAdapter */
    /* renamed from: fn$O000000o */
    class O000000o extends ViewHolder {
        final /* synthetic */ fn O000000o;
        private TextView O00000Oo;

        public O000000o(fn fnVar, View view) {
        }
    }

    public fn(O00000Oo o00000Oo, String str) {
    }

    public O000000o O000000o(ViewGroup viewGroup, int i) {
        return null;
    }

    public void O000000o(O000000o o000000o, int i) {
    }

    public void O000000o(List<MusicClassifyBean> list) {
    }

    public int getItemCount() {
        return 0;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }
}
