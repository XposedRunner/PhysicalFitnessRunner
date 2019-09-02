package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.TopicBean;
import java.util.List;

/* compiled from: FindTopicAdapter */
/* renamed from: fb */
public class fb extends Adapter {
    private List<TopicBean> O000000o;
    private boolean O00000Oo;
    private in<TopicBean> O00000o0;

    /* compiled from: FindTopicAdapter */
    /* renamed from: fb$1 */
    class 1 implements OnClickListener {
        final /* synthetic */ ViewHolder O000000o;
        final /* synthetic */ TopicBean O00000Oo;
        final /* synthetic */ fb O00000o0;

        1(fb fbVar, ViewHolder viewHolder, TopicBean topicBean) {
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: FindTopicAdapter */
    /* renamed from: fb$O000000o */
    private static abstract class O000000o extends ViewHolder {
        public O000000o(View view) {
        }

        public abstract void O000000o(TopicBean topicBean);
    }

    /* compiled from: FindTopicAdapter */
    /* renamed from: fb$O00000Oo */
    private static class O00000Oo extends O000000o {
        private ImageView O000000o;
        private TextView O00000Oo;
        private ImageView O00000o;
        private TextView O00000o0;

        public O00000Oo(View view) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(TopicBean topicBean) {
        }
    }

    public void O000000o() {
    }

    public void O000000o(in<TopicBean> inVar) {
    }

    public void O000000o(List<TopicBean> list) {
    }

    public int getItemCount() {
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }
}
