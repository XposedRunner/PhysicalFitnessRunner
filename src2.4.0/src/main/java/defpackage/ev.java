package defpackage;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.School;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/* compiled from: SearchSchoolResultAdapter */
/* renamed from: ev */
public class ev extends BaseAdapter {
    private List<School> O000000o;
    private Context O00000Oo;
    private String O00000o;
    private O000000o O00000o0;

    /* compiled from: SearchSchoolResultAdapter */
    /* renamed from: ev$O000000o */
    static class O000000o {
        @ViewInject(2131297054)
        TextView O000000o;

        O000000o(View view) {
            x.view().inject(this, view);
        }
    }

    public ev(Context context, List<School> list) {
        this.O00000Oo = context;
        this.O000000o = list;
    }

    /* renamed from: O000000o */
    public School getItem(int i) {
        return (School) this.O000000o.get(i);
    }

    public void O000000o(String str) {
        this.O00000o = str;
    }

    public int getCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view == null) {
            view = View.inflate(this.O00000Oo, R.layout.item_school, null);
            o000000o = new O000000o(view);
            view.setTag(o000000o);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        School school = (School) this.O000000o.get(i);
        String name = school.getName();
        if (name == null || !name.contains(this.O00000o)) {
            o000000o.O000000o.setText(school.getName());
        } else {
            i = name.indexOf(this.O00000o);
            int length = this.O00000o.length();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(name.substring(0, i));
            stringBuilder.append("<font color=#00c18b>");
            length += i;
            stringBuilder.append(name.substring(i, length));
            stringBuilder.append("</font>");
            stringBuilder.append(name.substring(length, name.length()));
            o000000o.O000000o.setText(Html.fromHtml(stringBuilder.toString()));
        }
        return view;
    }
}
