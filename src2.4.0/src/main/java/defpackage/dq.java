package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.PhotoUpImageItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.DensityUtil;

/* compiled from: AlbumDetailAdapter */
/* renamed from: dq */
public class dq extends Adapter<O000000o> {
    private List<PhotoUpImageItem> O000000o = new ArrayList();
    private O00000Oo O00000Oo;
    private LayoutParams O00000o;
    private int O00000o0;

    /* compiled from: AlbumDetailAdapter */
    /* renamed from: dq$O000000o */
    class O000000o extends ViewHolder {
        private ImageView O00000Oo;
        private View O00000o0;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (ImageView) view.findViewById(R.id.iv_album_detail);
            this.O00000o0 = view.findViewById(R.id.view);
        }
    }

    /* compiled from: AlbumDetailAdapter */
    /* renamed from: dq$O00000Oo */
    public interface O00000Oo {
        void O000000o(String str);
    }

    public dq(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    private LayoutParams O000000o() {
        if (this.O00000o == null) {
            this.O00000o = new LayoutParams(-1, (DensityUtil.getScreenWidth() - DensityUtil.dip2px(3.0f)) / 4);
        }
        return this.O00000o;
    }

    private void O000000o(int i) {
        if (this.O000000o != null && this.O000000o.size() > this.O00000o0 && this.O000000o.size() > i) {
            ((PhotoUpImageItem) this.O000000o.get(this.O00000o0)).setSelected(false);
            notifyItemChanged(this.O00000o0);
            ((PhotoUpImageItem) this.O000000o.get(i)).setSelected(true);
            notifyItemChanged(i);
            this.O00000o0 = i;
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_detail_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        final PhotoUpImageItem photoUpImageItem = (PhotoUpImageItem) this.O000000o.get(i);
        o000000o.itemView.setLayoutParams(O000000o());
        O00Oo.O00000o0(o000000o.O00000Oo.getContext()).O000000o(new File(photoUpImageItem.getImagePath())).O0000Oo().O000000o(o000000o.O00000Oo);
        o000000o.O00000o0.setVisibility(photoUpImageItem.isSelected() ? 0 : 8);
        o000000o.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dq.this.O000000o(o000000o.getAdapterPosition());
                if (dq.this.O00000Oo != null) {
                    dq.this.O00000Oo.O000000o(photoUpImageItem.getImagePath());
                }
            }
        });
    }

    public void O000000o(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    public void O000000o(List<PhotoUpImageItem> list) {
        this.O00000o0 = 0;
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
