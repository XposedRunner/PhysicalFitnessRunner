package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AddPhotoAdapter */
/* renamed from: do */
public class do extends Adapter<O000000o> {
    private List<String> O000000o = new ArrayList();
    private O00000Oo O00000Oo;

    /* compiled from: AddPhotoAdapter */
    /* renamed from: do$O000000o */
    class O000000o extends ViewHolder {
        private ImageView O00000Oo;
        private ImageView O00000o0;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (ImageView) view.findViewById(R.id.iv_img);
            this.O00000o0 = (ImageView) view.findViewById(R.id.iv_remove);
        }
    }

    public do(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_photo_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        String str = (String) this.O000000o.get(i);
        if (str != null) {
            O00Oo.O00000o0(o000000o.itemView.getContext()).O000000o(str).O000000o(o000000o.O00000Oo);
            o000000o.O00000o0.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    do.this.O00000Oo.O000000o(o000000o.getAdapterPosition());
                }
            });
        }
    }

    public void O000000o(List<String> list) {
        if (list != null) {
            this.O000000o.clear();
            this.O000000o.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
