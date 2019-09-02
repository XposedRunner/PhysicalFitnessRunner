package defpackage;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.NoticeListBean;
import com.zjwh.android_wh_physicalfitness.ui.notice.NoticeDetailActivity;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NoticeListAdapter */
/* renamed from: en */
public class en extends Adapter<O000000o> {
    private List<NoticeListBean> O000000o = new ArrayList();

    /* compiled from: NoticeListAdapter */
    /* renamed from: en$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private View O00000oO;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_title);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_author);
            this.O00000o = (TextView) view.findViewById(R.id.tv_time);
            this.O00000oO = view.findViewById(R.id.line);
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notici_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        final NoticeListBean noticeListBean = (NoticeListBean) this.O000000o.get(i);
        if (noticeListBean != null) {
            o000000o.O00000Oo.setText(TextUtils.isEmpty(noticeListBean.getTitle()) ? "" : noticeListBean.getTitle());
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(noticeListBean.getPublisherRole())) {
                stringBuilder.append(noticeListBean.getPublisherRole());
            }
            if (!TextUtils.isEmpty(noticeListBean.getPublisher())) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("  ");
                }
                stringBuilder.append(noticeListBean.getPublisher());
            }
            o000000o.O00000o0.setText(stringBuilder.toString());
            o000000o.O00000o.setText(O000O0o0.O000000o(O000O0o0.O0000OoO, noticeListBean.getPublishDate()));
            o000000o.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    NoticeDetailActivity.O000000o((Activity) o000000o.itemView.getContext(), noticeListBean.getId());
                }
            });
            o000000o.O00000oO.setVisibility(i == getItemCount() + -1 ? 8 : 0);
        }
    }

    public void O000000o(List<NoticeListBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
