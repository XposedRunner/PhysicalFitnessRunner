package defpackage;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.HomePageActivity;
import com.zjwh.android_wh_physicalfitness.entity.MessageCommentBean;
import com.zjwh.android_wh_physicalfitness.entity.MessageFansBean;
import com.zjwh.android_wh_physicalfitness.entity.MessageNoticeBean;
import com.zjwh.android_wh_physicalfitness.entity.MessageRootCommentBean;
import com.zjwh.android_wh_physicalfitness.entity.MultiAdapterBean;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageAdapter */
/* renamed from: ei */
public class ei extends Adapter {
    private List<MultiAdapterBean> O000000o = new ArrayList();
    private in<MultiAdapterBean> O00000Oo;

    /* compiled from: MessageAdapter */
    /* renamed from: ei$O0000O0o */
    public interface O0000O0o extends in<MultiAdapterBean> {
        void O000000o(int i);

        void O000000o(int i, MultiAdapterBean multiAdapterBean);

        void O000000o(MessageFansBean messageFansBean, int i);
    }

    /* compiled from: MessageAdapter */
    /* renamed from: ei$O000000o */
    private static abstract class O000000o extends ViewHolder {
        O000000o(View view) {
            super(view);
        }

        public abstract void O000000o(MultiAdapterBean multiAdapterBean);
    }

    /* compiled from: MessageAdapter */
    /* renamed from: ei$O00000Oo */
    private static class O00000Oo extends O000000o {
        private ImageView O000000o;
        private TextView O00000Oo;
        private ImageView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;
        private ImageView O0000O0o;
        private TextView O0000OOo;
        private TextView O0000Oo;
        private TextView O0000Oo0;
        private View O0000OoO;
        private View O0000Ooo;

        O00000Oo(View view) {
            super(view);
            this.O000000o = (ImageView) view.findViewById(R.id.comment_avatar);
            this.O00000Oo = (TextView) view.findViewById(R.id.comment_nickname);
            this.O00000o0 = (TextView) view.findViewById(R.id.comment_sub_title);
            this.O0000Oo = (TextView) view.findViewById(R.id.comment_date);
            this.O00000o = (ImageView) view.findViewById(R.id.comment_new_green);
            this.O00000oO = (TextView) view.findViewById(R.id.comment_content);
            this.O00000oo = (TextView) view.findViewById(R.id.comment_parent);
            this.O0000O0o = (ImageView) view.findViewById(R.id.comment_pic);
            this.O0000OOo = (TextView) view.findViewById(R.id.comment_desc);
            this.O0000Oo0 = (TextView) view.findViewById(R.id.comment_title);
            this.O0000OoO = view.findViewById(R.id.comment_root);
            this.O0000Ooo = view.findViewById(R.id.comment_show_info_layout);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(MultiAdapterBean multiAdapterBean) {
            if (multiAdapterBean != null) {
                MessageCommentBean messageCommentBean = (MessageCommentBean) multiAdapterBean;
                O00Oo0.O000000o(this.itemView.getContext(), messageCommentBean.getAvatarUrl(), this.O000000o, messageCommentBean.getGender());
                this.O00000o.setVisibility(messageCommentBean.isNew() ? 0 : 8);
                messageCommentBean.setNew(false);
                this.O0000Oo0.setVisibility(0);
                this.O0000O0o.setVisibility(0);
                this.O00000Oo.setText(messageCommentBean.getNickName());
                this.O00000o0.setText(messageCommentBean.getUniversity());
                this.O0000Oo.setText(O000O0o0.O00000o0(messageCommentBean.getTime()));
                String string = this.itemView.getContext().getString(R.string.message_comment_deleted);
                String string2 = this.itemView.getContext().getString(R.string.message_like_deleted);
                MessageRootCommentBean root = messageCommentBean.getRoot();
                CharSequence string3 = (root != null && root.getRootType() == 2 && messageCommentBean.getParentComment() == null) ? this.itemView.getContext().getString(R.string.message_comment_you, new Object[]{messageCommentBean.getContent()}) : this.itemView.getContext().getString(R.string.message_reply_you, new Object[]{messageCommentBean.getContent()});
                CharSequence spannableString = new SpannableString(string3);
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.text_color_label)), 0, 5, 34);
                this.O00000oO.setTextColor(ContextCompat.getColor(this.itemView.getContext(), messageCommentBean.getIsDeleted() == 1 ? R.color.text_color_hint : R.color.text_color_major));
                TextView textView = this.O00000oO;
                if (messageCommentBean.getIsDeleted() == 1) {
                    spannableString = string;
                } else if (messageCommentBean.getTabIndex() != 1) {
                    spannableString = messageCommentBean.getContent();
                }
                textView.setText(spannableString);
                if (root != null) {
                    if (TextUtils.isEmpty(root.getThumbUrl())) {
                        this.O0000O0o.setVisibility(8);
                    } else {
                        O00Oo.O00000o0(this.itemView.getContext()).O000000o(root.getThumbUrl()).O000000o(this.O0000O0o);
                    }
                    Context context = this.itemView.getContext();
                    Object[] objArr = new Object[1];
                    objArr[0] = root.getRootType() == 2 ? "动态" : "文章";
                    String string4 = context.getString(R.string.message_root_deleted, objArr);
                    this.O0000OOo.setText(root.getSummary());
                    this.O0000Oo0.setText(root.getTitle());
                    if (root.getIsDeleted() == 1) {
                        this.O00000oO.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.text_color_hint));
                        this.O00000oo.setText(string);
                        this.O0000OOo.setText(string4);
                        if (messageCommentBean.getTabIndex() == 1) {
                            this.O00000oO.setText(string);
                        } else if (messageCommentBean.getTabIndex() == 2) {
                            this.O00000oO.setText(string2);
                        }
                        this.O0000Oo0.setVisibility(8);
                        this.O00000o.setVisibility(8);
                        this.O0000O0o.setVisibility(8);
                    }
                } else {
                    this.O0000OOo.setText("");
                    this.O0000Oo0.setText("");
                    this.O00000oo.setText("");
                    this.O0000Oo0.setVisibility(8);
                    this.O00000o.setVisibility(8);
                    this.O0000O0o.setVisibility(8);
                }
                if (messageCommentBean.getParentComment() != null) {
                    if (messageCommentBean.getParentComment().getNickName() == null) {
                        this.O00000oo.setText(messageCommentBean.getParentComment().getContent());
                    } else {
                        this.O00000oo.setText(this.itemView.getContext().getString(R.string.comment_parent, new Object[]{messageCommentBean.getParentComment().getNickName(), messageCommentBean.getParentComment().getContent()}));
                    }
                    this.O00000oo.setVisibility(0);
                    if (messageCommentBean.getParentComment().getIsDeleted() == 1) {
                        this.O00000oo.setText(string);
                        this.O00000o.setVisibility(8);
                    }
                } else {
                    this.O00000oo.setVisibility(8);
                }
            }
        }
    }

    /* compiled from: MessageAdapter */
    /* renamed from: ei$O00000o0 */
    private static class O00000o0 extends O000000o {
        private ImageView O000000o;
        private TextView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;

        O00000o0(View view) {
            super(view);
            this.O000000o = (ImageView) view.findViewById(R.id.iv_icon);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_name);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_sign);
            this.O00000o = (TextView) view.findViewById(R.id.tv_concern);
            this.O00000oO = (TextView) view.findViewById(R.id.tv_concern_name);
            this.O00000oo = (TextView) view.findViewById(R.id.tv_concern_date);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(MultiAdapterBean multiAdapterBean) {
            if (multiAdapterBean != null) {
                Context context;
                int i;
                MessageFansBean messageFansBean = (MessageFansBean) multiAdapterBean;
                O00Oo0.O000000o(this.itemView.getContext(), messageFansBean.getAvatarUrl(), this.O000000o, messageFansBean.getGender());
                this.O00000Oo.setText(messageFansBean.getName());
                this.O00000o0.setText(messageFansBean.getUniversity());
                this.O00000oo.setText(O000O0o0.O00000o0(messageFansBean.getInterestTime()));
                this.O00000oO.setText(String.format("%s关注了你", new Object[]{messageFansBean.getName()}));
                TextView textView = this.O00000o;
                CharSequence charSequence = messageFansBean.getInterestStatus() == 1 ? "关注" : messageFansBean.getInterestStatus() == 2 ? "已关注" : "相互关注";
                textView.setText(charSequence);
                this.O00000o.setBackgroundResource(messageFansBean.getInterestStatus() == 1 ? R.drawable.concern_bg : R.drawable.no_concern_bg);
                textView = this.O00000o;
                if (messageFansBean.getInterestStatus() == 1) {
                    context = this.itemView.getContext();
                    i = R.color.white;
                } else {
                    context = this.itemView.getContext();
                    i = R.color.text_color_hint;
                }
                textView.setTextColor(ContextCompat.getColor(context, i));
            }
        }
    }

    /* compiled from: MessageAdapter */
    /* renamed from: ei$O00000o */
    private static class O00000o extends O000000o {
        private TextView O000000o;
        private TextView O00000Oo;
        private ImageView O00000o;
        private TextView O00000o0;

        O00000o(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.notice_title);
            this.O00000Oo = (TextView) view.findViewById(R.id.notice_date);
            this.O00000o0 = (TextView) view.findViewById(R.id.notice_desc);
            this.O00000o = (ImageView) view.findViewById(R.id.notice_iv);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(MultiAdapterBean multiAdapterBean) {
            if (multiAdapterBean != null) {
                MessageNoticeBean messageNoticeBean = (MessageNoticeBean) multiAdapterBean;
                this.O000000o.setText(messageNoticeBean.getTitle());
                this.O00000o0.setText(messageNoticeBean.getSummary());
                this.O00000Oo.setText(O000O0o0.O000000o(O000O0o0.O0000OoO, messageNoticeBean.getTime()));
                if (TextUtils.isEmpty(messageNoticeBean.getNotificationImage())) {
                    this.O00000o.setImageResource(R.color.window_background);
                } else {
                    O00Oo.O00000o0(this.itemView.getContext()).O000000o(messageNoticeBean.getNotificationImage()).O00000oO(R.color.window_background).O0000O0o((int) R.color.window_background).O000000o(this.O00000o);
                }
            }
        }
    }

    public List<? extends MultiAdapterBean> O000000o() {
        return this.O000000o;
    }

    public void O000000o(in<MultiAdapterBean> inVar) {
        this.O00000Oo = inVar;
    }

    public void O000000o(List<? extends MultiAdapterBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
    }

    public void O00000Oo(List<? extends MultiAdapterBean> list) {
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public int getItemViewType(int i) {
        return ((MultiAdapterBean) this.O000000o.get(i)).getViewType();
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final MultiAdapterBean multiAdapterBean = (MultiAdapterBean) this.O000000o.get(i);
        ((O000000o) viewHolder).O000000o(multiAdapterBean);
        boolean z = multiAdapterBean instanceof MessageCommentBean;
        if ((z && ((MessageCommentBean) multiAdapterBean).getTabIndex() == 1) || (multiAdapterBean instanceof MessageNoticeBean)) {
            viewHolder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ei.this.O00000Oo != null) {
                        ei.this.O00000Oo.O00000Oo(view, viewHolder.getAdapterPosition(), multiAdapterBean);
                    }
                }
            });
        }
        if (z && ((MessageCommentBean) multiAdapterBean).getTabIndex() == 1) {
            viewHolder.itemView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (ei.this.O00000Oo != null) {
                        ei.this.O00000Oo.O000000o(view, viewHolder.getAdapterPosition(), multiAdapterBean);
                    }
                    return true;
                }
            });
        }
        if (z && (viewHolder instanceof O00000Oo)) {
            ((O00000Oo) viewHolder).O0000Ooo.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ei.this.O00000Oo != null) {
                        ((O0000O0o) ei.this.O00000Oo).O000000o(((MessageCommentBean) multiAdapterBean).getUid());
                    }
                }
            });
        }
        if (viewHolder instanceof O00000Oo) {
            ((O00000Oo) viewHolder).O0000OoO.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ei.this.O00000Oo != null) {
                        ((O0000O0o) ei.this.O00000Oo).O000000o(viewHolder.getAdapterPosition(), multiAdapterBean);
                    }
                }
            });
        }
        if ((multiAdapterBean instanceof MessageFansBean) && (viewHolder instanceof O00000o0)) {
            ((O00000o0) viewHolder).O00000o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ei.this.O00000Oo != null) {
                        ((O0000O0o) ei.this.O00000Oo).O000000o((MessageFansBean) multiAdapterBean, viewHolder.getAdapterPosition());
                    }
                }
            });
            viewHolder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    HomePageActivity.O000000o((Activity) viewHolder.itemView.getContext(), ((MessageFansBean) multiAdapterBean).getUid());
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new O00000Oo(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_comment_item, viewGroup, false));
            case 2:
                return new O00000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_notice_item, viewGroup, false));
            case 3:
                return new O00000o0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_fans_list_item, viewGroup, false));
            default:
                return null;
        }
    }
}
