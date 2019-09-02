package defpackage;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* compiled from: BannerAdapter */
/* renamed from: dt */
public class dt extends PagerAdapter {
    private List<ImageView> O000000o;

    public dt(List<ImageView> list) {
        this.O000000o = list;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.removeView((View) this.O000000o.get(i % this.O000000o.size()));
        viewGroup.addView((View) this.O000000o.get(i % this.O000000o.size()));
        return this.O000000o.get(i % this.O000000o.size());
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
