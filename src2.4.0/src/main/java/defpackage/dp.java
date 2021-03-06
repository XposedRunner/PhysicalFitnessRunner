package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.database.TopicTagBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AddTopicTagAdapter */
/* renamed from: dp */
public class dp extends Adapter {
    private List<TopicTagBean> O000000o = new ArrayList();
    private O00000o0 O00000Oo;

    /* compiled from: AddTopicTagAdapter */
    /* renamed from: dp$O00000o0 */
    public interface O00000o0 {
        void O000000o(TopicTagBean topicTagBean);
    }

    /* compiled from: AddTopicTagAdapter */
    /* renamed from: dp$O000000o */
    private static class O000000o extends ViewHolder {
        private TextView O000000o;

        O000000o(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    /* compiled from: AddTopicTagAdapter */
    /* renamed from: dp$O00000Oo */
    private static class O00000Oo extends ViewHolder {
        private TextView O000000o;
        private View O00000Oo;

        O00000Oo(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_current_school);
            this.O00000Oo = view.findViewById(R.id.current_line);
        }
    }

    public void O000000o(O00000o0 o00000o0) {
        this.O00000Oo = o00000o0;
    }

    public void O000000o(List<TopicTagBean> list) {
        if (list != null) {
            this.O000000o.clear();
            this.O000000o.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void O00000Oo(List<TopicTagBean> list) {
        if (list != null) {
            this.O000000o.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public int getItemViewType(int i) {
        return ((TopicTagBean) this.O000000o.get(i)).getViewType();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final TopicTagBean topicTagBean = (TopicTagBean) this.O000000o.get(i);
        if (viewHolder instanceof O000000o) {
            ((O000000o) viewHolder).O000000o.setText(topicTagBean.getTopicTitle());
        } else if (viewHolder instanceof O00000Oo) {
            int i2 = 1;
            int i3 = 0;
            if (((TopicTagBean) this.O000000o.get(i - 1)).getViewType() != 2) {
                i2 = 0;
            }
            O00000Oo o00000Oo = (O00000Oo) viewHolder;
            o00000Oo.O000000o.setText(topicTagBean.getTopicTitle());
            View O00000Oo = o00000Oo.O00000Oo;
            if (i2 == 0) {
                i3 = 8;
            }
            O00000Oo.setVisibility(i3);
            viewHolder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (dp.this.O00000Oo != null) {
                        dp.this.O00000Oo.O000000o(topicTagBean);
                    }
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i != 2 ? new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.change_school_title_layout, viewGroup, false)) : new O00000Oo(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_campus_item, viewGroup, false));
    }
}
