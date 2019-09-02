package defpackage;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ImageFilterBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TakePhotoFilterAdapter */
/* renamed from: ey */
public class ey extends Adapter<O000000o> {
    private List<ImageFilterBean> O000000o = new ArrayList();
    private O00000Oo O00000Oo;
    private int O00000o0 = 0;

    /* compiled from: TakePhotoFilterAdapter */
    /* renamed from: ey$O000000o */
    static class O000000o extends ViewHolder {
        private TextView O000000o;
        private ImageView O00000Oo;

        public O000000o(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_filter);
            this.O00000Oo = (ImageView) view.findViewById(R.id.iv_filter);
        }
    }

    /* compiled from: TakePhotoFilterAdapter */
    /* renamed from: ey$O00000Oo */
    public interface O00000Oo {
        void O000000o(int i);
    }

    public ey(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    private void O000000o(int i) {
        if (this.O000000o != null && this.O000000o.size() > this.O00000o0 && this.O000000o.size() > i) {
            ((ImageFilterBean) this.O000000o.get(this.O00000o0)).setSelect(false);
            notifyItemChanged(this.O00000o0);
            ((ImageFilterBean) this.O000000o.get(i)).setSelect(true);
            notifyItemChanged(i);
            this.O00000o0 = i;
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_filter_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        Context context;
        int i2;
        ImageFilterBean imageFilterBean = (ImageFilterBean) this.O000000o.get(i);
        o000000o.O000000o.setText(imageFilterBean.getTvFilter());
        TextView O000000o = o000000o.O000000o;
        if (imageFilterBean.isSelect()) {
            context = o000000o.itemView.getContext();
            i2 = R.color.text_color_major;
        } else {
            context = o000000o.itemView.getContext();
            i2 = R.color.text_color_hint;
        }
        O000000o.setTextColor(ContextCompat.getColor(context, i2));
        o000000o.O00000Oo.setImageBitmap(imageFilterBean.getBitmap());
        o000000o.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ey.this.O000000o(o000000o.getAdapterPosition());
                if (ey.this.O00000Oo != null) {
                    ey.this.O00000Oo.O000000o(o000000o.getAdapterPosition());
                }
            }
        });
    }

    public void O000000o(List<ImageFilterBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
