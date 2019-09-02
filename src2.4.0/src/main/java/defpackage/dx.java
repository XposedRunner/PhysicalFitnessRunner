package defpackage;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.HomePageActivity;
import com.zjwh.android_wh_physicalfitness.entity.ChatBean;
import com.zjwh.android_wh_physicalfitness.entity.ChatBean.Status;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.DensityUtil;

/* compiled from: ChatAdapter */
/* renamed from: dx */
public class dx extends Adapter<O000000o> {
    private List<ChatBean> O000000o = new ArrayList();
    private String O00000Oo;
    private int O00000o;
    private int O00000o0;
    private UserInfo O00000oO;
    private O00000Oo O00000oo;

    /* compiled from: ChatAdapter */
    /* renamed from: dx$O00000Oo */
    public interface O00000Oo {
        void O000000o(View view, ChatBean chatBean, int i);
    }

    /* compiled from: ChatAdapter */
    /* renamed from: dx$O000000o */
    abstract class O000000o extends ViewHolder {
        O000000o(View view) {
            super(view);
        }

        public abstract void O000000o(ChatBean chatBean, int i);
    }

    /* compiled from: ChatAdapter */
    /* renamed from: dx$O00000o0 */
    private class O00000o0 extends O000000o {
        private ImageView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;

        O00000o0(View view) {
            super(view);
            this.O00000o0 = (TextView) view.findViewById(R.id.chat_message_time);
            this.O00000o = (ImageView) view.findViewById(R.id.chatPicture);
            this.O00000oO = (TextView) view.findViewById(R.id.chatTitle);
            this.O00000oo = (TextView) view.findViewById(R.id.chatMessage);
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(final ChatBean chatBean, int i) {
            this.O00000o0.setText(O000O0o0.O00000oO(chatBean.getTimestamp()));
            this.O00000o0.setVisibility(chatBean.isShowTime() ? 0 : 8);
            this.O00000oO.setText(chatBean.getTitle());
            this.O00000oo.setText(chatBean.getMessage());
            O00Oo.O00000o0(this.itemView.getContext()).O000000o(chatBean.getImageUrl()).O000000o(new lc(this.itemView.getContext())).O000000o(this.O00000o);
            this.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(chatBean.getJumpUrl())) {
                        O000o0.O000000o((Activity) O00000o0.this.itemView.getContext(), chatBean.getJumpUrl());
                    }
                }
            });
        }
    }

    /* compiled from: ChatAdapter */
    /* renamed from: dx$O00000o */
    private class O00000o extends O000000o {
        private ImageView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;

        O00000o(View view) {
            super(view);
            this.O00000o0 = (TextView) view.findViewById(R.id.chat_message_time);
            this.O00000o = (ImageView) view.findViewById(R.id.chatTitleIcon);
            this.O00000oO = (TextView) view.findViewById(R.id.chatTitle);
            this.O00000oo = (TextView) view.findViewById(R.id.chatMessage);
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(final ChatBean chatBean, int i) {
            this.O00000o0.setText(O000O0o0.O00000oO(chatBean.getTimestamp()));
            this.O00000o0.setVisibility(chatBean.isShowTime() ? 0 : 8);
            this.O00000oO.setText(chatBean.getTitle());
            this.O00000oo.setText(chatBean.getMessage());
            O00Oo.O00000o0(this.itemView.getContext()).O000000o(chatBean.getImageUrl()).O000000o(this.O00000o);
            this.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(chatBean.getJumpUrl())) {
                        O000o0.O000000o((Activity) O00000o.this.itemView.getContext(), chatBean.getJumpUrl());
                    }
                }
            });
        }
    }

    /* compiled from: ChatAdapter */
    /* renamed from: dx$O0000O0o */
    private class O0000O0o extends O000000o {
        private TextView O00000o;
        private TextView O00000o0;
        private ImageView O00000oO;
        private ImageView O00000oo;
        private View O0000O0o;
        private ProgressBar O0000OOo;

        public O0000O0o(View view) {
            super(view);
            this.O00000oO = (ImageView) view.findViewById(R.id.chat_message_icon);
            this.O00000o = (TextView) view.findViewById(R.id.chat_message_time);
            this.O00000o0 = (TextView) view.findViewById(R.id.chat_message_content);
            this.O00000oo = (ImageView) view.findViewById(R.id.chat_message_failed);
            this.O0000O0o = view.findViewById(R.id.chat_message_layout);
            this.O0000OOo = (ProgressBar) view.findViewById(R.id.chat_message_loading);
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(final ChatBean chatBean, int i) {
            this.O00000o0.setText(chatBean.getMessage());
            if (chatBean.getViewType() == 4) {
                O00Oo0.O000000o(this.itemView.getContext(), dx.this.O00000oO.getIcon(), this.O00000oO, dx.this.O00000oO.getSex());
            } else {
                O00Oo0.O000000o(this.itemView.getContext(), dx.this.O00000Oo, this.O00000oO, dx.this.O00000o0);
            }
            this.O00000o.setText(O000O0o0.O00000oO(chatBean.getTimestamp()));
            float f = 30.0f;
            ((LayoutParams) this.O00000o.getLayoutParams()).topMargin = DensityUtil.dip2px(i == 0 ? 15.0f : 30.0f);
            int i2 = 8;
            this.O00000oo.setVisibility(chatBean.getStatus() == Status.Failed ? 0 : 8);
            this.O0000OOo.setVisibility(chatBean.getStatus() == Status.Loading ? 0 : 8);
            TextView textView = this.O00000o;
            if (chatBean.isShowTime()) {
                i2 = 0;
            }
            textView.setVisibility(i2);
            ChatBean chatBean2 = i > 0 ? (ChatBean) dx.this.O000000o.get(i - 1) : null;
            LayoutParams layoutParams = (LayoutParams) this.O0000O0o.getLayoutParams();
            if (chatBean2 == null || chatBean2.getViewType() == chatBean.getViewType() || chatBean.isShowTime()) {
                f = 15.0f;
            }
            layoutParams.topMargin = DensityUtil.dip2px(f);
            this.O00000oO.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    HomePageActivity.O000000o((Activity) O0000O0o.this.itemView.getContext(), chatBean.getViewType() == 4 ? dx.this.O00000oO.getUid() : dx.this.O00000o);
                }
            });
            this.O00000oo.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (dx.this.O00000oo != null) {
                        dx.this.O00000oo.O000000o(view, chatBean, O0000O0o.this.getAdapterPosition());
                    }
                }
            });
        }
    }

    public dx(String str, int i, int i2) {
        this.O00000Oo = str;
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = O00Oo0.O00000o0();
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 4) {
            return new O0000O0o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_myself_item, viewGroup, false));
        }
        switch (i) {
            case 1:
                return new O00000o0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_picture_item, viewGroup, false));
            case 2:
                return new O00000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_title_item, viewGroup, false));
            default:
                return new O0000O0o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_other_item, viewGroup, false));
        }
    }

    public void O000000o() {
        if (this.O000000o.size() > 0) {
            this.O000000o.clear();
            notifyDataSetChanged();
        }
    }

    public void O000000o(ChatBean chatBean) {
        this.O000000o.add(chatBean);
        notifyItemInserted(this.O000000o.size() - 1);
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        o000000o.O000000o((ChatBean) this.O000000o.get(i), i);
    }

    public void O000000o(O00000Oo o00000Oo) {
        this.O00000oo = o00000Oo;
    }

    public void O000000o(List<ChatBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public void O00000Oo(List<ChatBean> list) {
        int size = this.O000000o.size();
        this.O000000o.removeAll(list);
        this.O000000o.addAll(list);
        notifyItemRangeInserted(size, this.O000000o.size() - size);
    }

    public void O00000o0(List<ChatBean> list) {
        for (int i = 0; i < list.size(); i++) {
            this.O000000o.add(i, list.get(i));
        }
        notifyItemRangeInserted(0, list.size());
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public int getItemViewType(int i) {
        return ((ChatBean) this.O000000o.get(i)).getViewType();
    }
}
