package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.rank.CheatReportImageBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CheatReportAdapter */
/* renamed from: dy */
public class dy extends Adapter<O00000Oo> {
    private List<CheatReportImageBean> O000000o = new ArrayList();
    private O00000o O00000Oo;

    /* compiled from: CheatReportAdapter */
    /* renamed from: dy$O00000o */
    public interface O00000o {
        void O000000o(int i);

        void O000000o(int i, int i2);
    }

    /* compiled from: CheatReportAdapter */
    /* renamed from: dy$O00000Oo */
    public abstract class O00000Oo extends ViewHolder {
        O00000Oo(View view) {
            super(view);
        }

        public abstract void O000000o(CheatReportImageBean cheatReportImageBean);
    }

    /* compiled from: CheatReportAdapter */
    /* renamed from: dy$O000000o */
    private class O000000o extends O00000Oo {
        private ImageView O00000o;
        private ImageView O00000o0;

        O000000o(View view) {
            super(view);
            this.O00000o0 = (ImageView) view.findViewById(R.id.imageView);
            this.O00000o = (ImageView) view.findViewById(R.id.ivDelete);
        }

        public void O000000o(CheatReportImageBean cheatReportImageBean) {
            this.O00000o.setVisibility(8);
            this.O00000o0.setImageResource(R.drawable.cheat_report_image_add);
        }
    }

    /* compiled from: CheatReportAdapter */
    /* renamed from: dy$O00000o0 */
    private class O00000o0 extends O00000Oo {
        private ImageView O00000o;
        private ImageView O00000o0;

        O00000o0(View view) {
            super(view);
            this.O00000o0 = (ImageView) view.findViewById(R.id.imageView);
            this.O00000o = (ImageView) view.findViewById(R.id.ivDelete);
        }

        public void O000000o(CheatReportImageBean cheatReportImageBean) {
            this.O00000o.setVisibility(0);
            if (TextUtils.isEmpty(cheatReportImageBean.getImageUrl())) {
                this.O00000o0.setImageResource(R.color.window_background);
            } else {
                O00Oo.O00000o0(this.itemView.getContext()).O000000o(cheatReportImageBean.getImageUrl()).O00000oO(R.color.window_background).O0000O0o((int) R.color.window_background).O000000o(this.O00000o0);
            }
        }
    }

    public dy(O00000o o00000o) {
        this.O00000Oo = o00000o;
    }

    /* renamed from: O000000o */
    public O00000Oo onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i != 2 ? new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cheat_report_image_item, viewGroup, false)) : new O00000o0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cheat_report_image_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O00000Oo o00000Oo, int i) {
        final CheatReportImageBean cheatReportImageBean = (CheatReportImageBean) this.O000000o.get(i);
        o00000Oo.O000000o(cheatReportImageBean);
        if (o00000Oo instanceof O00000o0) {
            ((O00000o0) o00000Oo).O00000o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int adapterPosition = o00000Oo.getAdapterPosition();
                    dy.this.O000000o.remove(adapterPosition);
                    dy.this.notifyItemRemoved(adapterPosition);
                    if (((CheatReportImageBean) dy.this.O000000o.get(dy.this.O000000o.size() - 1)).getViewType() != 1) {
                        dy.this.O000000o.add(new CheatReportImageBean(1));
                    }
                    if (dy.this.O00000Oo != null) {
                        dy.this.O00000Oo.O000000o(adapterPosition);
                    }
                }
            });
        } else {
            ((O000000o) o00000Oo).O00000o0.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int adapterPosition = o00000Oo.getAdapterPosition();
                    if (dy.this.O00000Oo != null) {
                        dy.this.O00000Oo.O000000o(cheatReportImageBean.getViewType(), adapterPosition);
                    }
                }
            });
        }
    }

    public void O000000o(String str) {
        this.O000000o.add(this.O000000o.size() > 0 ? this.O000000o.size() - 1 : 0, TextUtils.isEmpty(str) ? new CheatReportImageBean(1) : new CheatReportImageBean(2, str));
        if (this.O000000o.size() > 4) {
            this.O000000o.remove(4);
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public int getItemViewType(int i) {
        return ((CheatReportImageBean) this.O000000o.get(i)).getViewType();
    }
}
