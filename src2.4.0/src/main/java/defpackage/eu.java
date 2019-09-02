package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.School;
import java.util.List;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/* compiled from: SchoolListStickyAdapter */
/* renamed from: eu */
public class eu extends BaseAdapter implements StickyListHeadersAdapter {
    private final Context O000000o;
    private List<School> O00000Oo;
    private LayoutInflater O00000o0;

    /* compiled from: SchoolListStickyAdapter */
    /* renamed from: eu$O000000o */
    class O000000o {
        TextView O000000o;

        O000000o() {
        }
    }

    /* compiled from: SchoolListStickyAdapter */
    /* renamed from: eu$O00000Oo */
    class O00000Oo {
        TextView O000000o;

        O00000Oo() {
        }
    }

    public eu(Context context, List<School> list) {
        this.O000000o = context;
        this.O00000o0 = LayoutInflater.from(context);
        this.O00000Oo = list;
    }

    /* renamed from: O000000o */
    public School getItem(int i) {
        return i < this.O00000Oo.size() ? (School) this.O00000Oo.get(i) : null;
    }

    public int getCount() {
        return this.O00000Oo == null ? 0 : this.O00000Oo.size();
    }

    public long getHeaderId(int i) {
        return (long) ((School) this.O00000Oo.get(i)).getFirstLetter().charAt(0);
    }

    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        View inflate;
        if (view == null) {
            o000000o = new O000000o();
            inflate = this.O00000o0.inflate(R.layout.item_school_alpha, viewGroup, false);
            o000000o.O000000o = (TextView) inflate;
            inflate.setTag(o000000o);
        } else {
            inflate = view;
            o000000o = (O000000o) view.getTag();
        }
        o000000o.O000000o.setText(((School) this.O00000Oo.get(i)).getFirstLetter());
        return inflate;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        O00000Oo o00000Oo;
        View inflate;
        if (view == null) {
            o00000Oo = new O00000Oo();
            inflate = this.O00000o0.inflate(R.layout.item_school, viewGroup, false);
            o00000Oo.O000000o = (TextView) inflate.findViewById(R.id.school_name);
            inflate.setTag(o00000Oo);
        } else {
            inflate = view;
            o00000Oo = (O00000Oo) view.getTag();
        }
        o00000Oo.O000000o.setText(((School) this.O00000Oo.get(i)).getName());
        return inflate;
    }
}
