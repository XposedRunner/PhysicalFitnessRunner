package defpackage;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.DiffResult;
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
import com.zjwh.android_wh_physicalfitness.entity.FindDetailBean;
import com.zjwh.android_wh_physicalfitness.utils.O000O0OO;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: ArticleCommentAdapter */
/* renamed from: dr */
public class dr extends Adapter {
    private List<FindDetailBean> O000000o = new ArrayList();
    private int O00000Oo = 0;
    private O00000Oo O00000o0;

    /* compiled from: ArticleCommentAdapter */
    /* renamed from: dr$O00000Oo */
    public interface O00000Oo extends in<FindDetailBean> {
        void O000000o(int i);

        void O000000o(int i, FindDetailBean findDetailBean);
    }

    /* compiled from: ArticleCommentAdapter */
    /* renamed from: dr$O000000o */
    protected static abstract class O000000o extends ViewHolder {
        public O000000o(View view) {
            super(view);
        }

        public abstract void O000000o(FindDetailBean findDetailBean);
    }

    /* compiled from: ArticleCommentAdapter */
    /* renamed from: dr$O00000o0 */
    private static class O00000o0 extends O000000o {
        private TextView O000000o;

        public O00000o0(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.find_detail_comment_title);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(FindDetailBean findDetailBean) {
            this.O000000o.setText(String.format(Locale.getDefault(), "%s%d", new Object[]{findDetailBean.getText(), Integer.valueOf(findDetailBean.getSize())}));
        }
    }

    /* compiled from: ArticleCommentAdapter */
    /* renamed from: dr$O00000o */
    private static class O00000o extends O000000o {
        private ImageView O000000o;
        private TextView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;
        private View O0000O0o;
        private TextView O0000OOo;

        public O00000o(View view) {
            super(view);
            this.O000000o = (ImageView) view.findViewById(R.id.comment_avatar);
            this.O00000Oo = (TextView) view.findViewById(R.id.comment_nickname);
            this.O00000o0 = (TextView) view.findViewById(R.id.comment_sub_title);
            this.O00000oO = (TextView) view.findViewById(R.id.comment_parent);
            this.O00000o = (TextView) view.findViewById(R.id.notice_title);
            this.O00000oo = (TextView) view.findViewById(R.id.comment_like);
            this.O0000O0o = view.findViewById(R.id.comment_show_info_layout);
            this.O0000OOo = (TextView) view.findViewById(R.id.tvTime);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(FindDetailBean findDetailBean) {
            O00Oo0.O000000o(this.itemView.getContext(), findDetailBean.getBean().getAvatarUrl(), this.O000000o, findDetailBean.getBean().getGender());
            this.O00000Oo.setText(findDetailBean.getBean().getNickName());
            if (!TextUtils.isEmpty(findDetailBean.getBean().getUniversity())) {
                this.O00000o0.setText(findDetailBean.getBean().getUniversity());
            }
            this.O0000OOo.setText(O000O0o0.O00000o0(findDetailBean.getBean().getTime()));
            this.O00000o.setText(findDetailBean.getBean().getContent());
            this.O00000oo.setText(findDetailBean.getBean().getLikeCount() <= 0 ? "" : String.valueOf(findDetailBean.getBean().getLikeCount()));
            this.O00000oo.setCompoundDrawablesWithIntrinsicBounds(0, 0, findDetailBean.getBean().getIsLiked() == 1 ? R.drawable.praise_icon : R.drawable.un_praise_icon, 0);
            if (findDetailBean.getBean().getParentComment() != null) {
                if (findDetailBean.getBean().getParentComment().getIsDeleted() == 1) {
                    this.O00000oO.setText(this.itemView.getContext().getString(R.string.comment_parent_deleted));
                } else if (TextUtils.isEmpty(findDetailBean.getBean().getParentComment().getNickName()) || TextUtils.isEmpty(findDetailBean.getBean().getParentComment().getContent())) {
                    this.O00000oO.setText("");
                } else {
                    Context context = this.itemView.getContext();
                    Object[] objArr = new Object[2];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("@");
                    stringBuilder.append(findDetailBean.getBean().getParentComment().getNickName());
                    objArr[0] = stringBuilder.toString();
                    objArr[1] = findDetailBean.getBean().getParentComment().getContent();
                    SpannableString spannableString = new SpannableString(context.getString(R.string.comment_parent, objArr));
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.green)), 0, findDetailBean.getBean().getParentComment().getNickName().length() + 1, 34);
                    this.O00000oO.setText(spannableString);
                }
                this.O00000oO.setVisibility(0);
                return;
            }
            this.O00000oO.setVisibility(8);
        }
    }

    public int O000000o() {
        return this.O00000Oo;
    }

    public void O000000o(FindDetailBean findDetailBean) {
        int size;
        ArrayList<Integer> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(this.O000000o);
        for (size = arrayList2.size() - 1; size >= 0; size--) {
            FindDetailBean findDetailBean2 = (FindDetailBean) arrayList2.get(size);
            if (findDetailBean2.getBean() != null && findDetailBean.getBean().getId() == findDetailBean2.getBean().getId()) {
                arrayList.add(Integer.valueOf(size));
            }
        }
        size = 0;
        for (Integer num : arrayList) {
            arrayList2.remove(num.intValue());
            if (num.intValue() < this.O00000Oo) {
                this.O00000Oo--;
                size = 1;
            }
        }
        findDetailBean = (FindDetailBean) arrayList2.get(this.O00000Oo);
        findDetailBean.setSize(findDetailBean.getSize() - 1);
        if (findDetailBean.getSize() <= 0) {
            arrayList2.remove(this.O00000Oo);
        }
        if (size != 0) {
            findDetailBean = (FindDetailBean) arrayList2.get(0);
            findDetailBean.setSize(findDetailBean.getSize() - 1);
            if (findDetailBean.getSize() <= 0) {
                arrayList2.remove(0);
            }
        }
        DiffResult calculateDiff = DiffUtil.calculateDiff(new O000O0OO(this.O000000o, arrayList2));
        this.O000000o.clear();
        this.O000000o.addAll(arrayList2);
        calculateDiff.dispatchUpdatesTo(this);
    }

    public void O000000o(O00000Oo o00000Oo) {
        this.O00000o0 = o00000Oo;
    }

    public void O000000o(List<FindDetailBean> list) {
        this.O00000Oo = list.size();
        for (int i = 0; i < list.size(); i++) {
            this.O000000o.add(i, list.get(i));
        }
    }

    public void O000000o(List<FindDetailBean> list, boolean z, int i) {
        if (list != null) {
            if (this.O000000o.size() == this.O00000Oo) {
                FindDetailBean findDetailBean = new FindDetailBean();
                findDetailBean.setText("全部评论 ");
                findDetailBean.setSize(i);
                findDetailBean.setViewType(1);
                this.O000000o.add(findDetailBean);
                notifyItemInserted(this.O00000Oo);
            } else {
                ((FindDetailBean) this.O000000o.get(this.O00000Oo)).setSize(i);
                notifyItemChanged(this.O00000Oo);
            }
            if (z) {
                this.O000000o.addAll(list);
                notifyItemRangeInserted(this.O000000o.size() - list.size(), list.size());
            } else {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    this.O000000o.add((this.O00000Oo + i2) + 1, list.get(i2));
                }
                notifyItemRangeInserted(this.O00000Oo + 1, list.size());
            }
        }
    }

    public List<FindDetailBean> O00000Oo() {
        return this.O000000o;
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public int getItemViewType(int i) {
        return ((FindDetailBean) this.O000000o.get(i)).getViewType();
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final FindDetailBean findDetailBean = (FindDetailBean) this.O000000o.get(i);
        ((O000000o) viewHolder).O000000o(findDetailBean);
        if (viewHolder instanceof O00000o) {
            O00000o o00000o = (O00000o) viewHolder;
            o00000o.O00000oo.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (dr.this.O00000o0 != null) {
                        dr.this.O00000o0.O000000o(viewHolder.getAdapterPosition(), findDetailBean);
                    }
                }
            });
            o00000o.O0000O0o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (dr.this.O00000o0 != null) {
                        dr.this.O00000o0.O000000o(findDetailBean.getBean().getUid());
                    }
                }
            });
            viewHolder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (dr.this.O00000o0 != null) {
                        dr.this.O00000o0.O00000Oo(view, viewHolder.getAdapterPosition(), findDetailBean);
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (dr.this.O00000o0 != null) {
                        dr.this.O00000o0.O000000o(view, viewHolder.getAdapterPosition(), findDetailBean);
                    }
                    return true;
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i != 2 ? new O00000o0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.find_detail_item_comment_title, viewGroup, false)) : new O00000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.find_detail_item_comment, viewGroup, false));
    }
}
