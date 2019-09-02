package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DueRunWait;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.DensityUtil;

/* compiled from: DueRunWaitIconAdapter */
/* renamed from: ee */
public class ee extends BaseAdapter {
    private Context O000000o;
    private List<DueRunWait> O00000Oo = new ArrayList();

    public ee(Context context) {
        this.O000000o = context;
    }

    /* renamed from: O000000o */
    public DueRunWait getItem(int i) {
        return (DueRunWait) this.O00000Oo.get(i);
    }

    public void O000000o(List<DueRunWait> list) {
        this.O00000Oo.clear();
        this.O00000Oo.addAll(list);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.O00000Oo.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.O000000o).inflate(R.layout.layout_due_run_wait_icon_item, viewGroup, false);
        }
        DueRunWait O000000o = getItem(i);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        int dip2px = DensityUtil.dip2px(20.0f);
        int i2 = O000000o.getSex() == 0 ? R.drawable.default_round_female : R.drawable.default_round_male;
        O00Oo.O00000o0(this.O000000o).O000000o(O000000o.getIcon()).O0000O0o(i2).O00000oO(i2).O000000o(new la(this.O000000o)).O00000Oo(dip2px, dip2px).O000000o(imageView);
        return view;
    }
}
