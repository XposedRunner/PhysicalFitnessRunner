package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ActivitiesBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O00000o0;
import java.util.List;

/* compiled from: ActivitiesAdapter */
/* renamed from: ez */
public class ez extends fw<ActivitiesBean> {
    private Context O000000o;
    private List<ActivitiesBean> O00000Oo;
    private boolean O0000OoO;

    public ez(Context context, int i, List<ActivitiesBean> list) {
        super(context, i, list);
        this.O000000o = context;
        this.O00000Oo = list;
    }

    public void O000000o() {
        if (this.O0000OoO && this.O00000Oo != null) {
            for (ActivitiesBean newAdd : this.O00000Oo) {
                newAdd.setNewAdd(false);
            }
            notifyDataSetChanged();
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(final ga gaVar, final ActivitiesBean activitiesBean, int i) {
        Context context = this.O000000o;
        int i2 = activitiesBean.getActivityStatus() == 3 ? R.string.activities_over : activitiesBean.getActivityStatus() == 2 ? R.string.activities_processing : R.string.activities_to_be_done;
        gaVar.O000000o((int) R.id.activity_state, context.getString(i2));
        i = activitiesBean.getActivityStatus() == 3 ? R.drawable.find_activity_state_over : activitiesBean.getActivityStatus() == 2 ? R.drawable.find_activity_state_processing : R.drawable.find_activity_state_to_be_done;
        gaVar.O00000o(R.id.activity_state, i);
        if (TextUtils.isEmpty(activitiesBean.getBigImageUrl())) {
            ((ImageView) gaVar.O000000o(R.id.activity_iv)).setImageResource(R.color.window_background);
        } else {
            O00Oo.O00000o0(this.O000000o).O000000o(activitiesBean.getBigImageUrl()).O00000oO(R.color.window_background).O0000O0o((int) R.color.window_background).O000000o(new ld(gaVar.itemView.getContext())).O000000o((ImageView) gaVar.O000000o(R.id.activity_iv));
        }
        gaVar.O000000o((int) R.id.ivActivityNew, activitiesBean.isNewAdd());
        gaVar.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                O000o0.O000000o(O00Oo0.O00000oo(ez.this.O000000o), activitiesBean.getActivityUrl());
                ez.this.O000000o();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(gf.O000o00O);
                stringBuilder.append(activitiesBean.getActivityId());
                O00OO0O.O000000o(new PvDataInfoV29(10004, stringBuilder.toString()));
                Context O000000o = ez.this.O000000o;
                String str = O000000o.O0000Oo0;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(O00000o0.O00000Oo);
                stringBuilder2.append(gaVar.getAdapterPosition());
                stringBuilder2.append("_");
                stringBuilder2.append(activitiesBean.getActivityId());
                O00Oo00o.O000000o(O000000o, str, stringBuilder2.toString());
            }
        });
        if (!this.O0000OoO) {
            this.O0000OoO = activitiesBean.isNewAdd();
        }
    }
}
