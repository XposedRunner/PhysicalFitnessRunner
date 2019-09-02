package com.umeng.socialize.shareboard;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SocializeMenuPagerAdapter */
class O0000OOo extends PagerAdapter {
    private List<O00000o[][]> O000000o;
    private Context O00000Oo;
    private O00000o0 O00000o0;

    public O0000OOo(Context context, O00000Oo o00000Oo) {
        this(context, o00000Oo, null);
    }

    public O0000OOo(Context context, O00000Oo o00000Oo, List<O00000o> list) {
        this.O000000o = new ArrayList();
        this.O00000Oo = context;
        this.O00000o0 = new O00000o0(o00000Oo);
        O000000o(list);
    }

    public void O000000o(List<O00000o> list) {
        this.O000000o.clear();
        if (list != null) {
            this.O000000o.addAll(this.O00000o0.O000000o((List) list));
        }
        notifyDataSetChanged();
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View O000000o = this.O00000o0.O000000o(this.O00000Oo, (O00000o[][]) this.O000000o.get(i));
        viewGroup.addView(O000000o);
        return O000000o;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
