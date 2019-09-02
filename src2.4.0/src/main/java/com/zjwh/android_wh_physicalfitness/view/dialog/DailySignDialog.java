package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DailySignBean;
import defpackage.ex;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import s.h.e.l.l.C;

public class DailySignDialog extends DialogFragment {
    public static final String O000000o = "sign_days";
    private List<DailySignBean> O00000Oo = new ArrayList();
    private int O00000o0;

    static {
        C.i(16777373);
    }

    public static native DailySignDialog O000000o(int i);

    private native void O000000o(Bundle bundle);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        setStyle(2, R.style.ScaleAnimDialog);
        setCancelable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().setCanceledOnTouchOutside(false);
        return layoutInflater.inflate(R.layout.dialog_daily_sign, viewGroup, false);
    }

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
        TextView textView = (TextView) view.findViewById(R.id.tvSignDays);
        TextView textView2 = (TextView) view.findViewById(R.id.tvScores);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DailySignDialog.this.dismiss();
            }
        });
        int i = 1;
        while (true) {
            boolean z = false;
            int i2 = 4;
            if (i >= 5) {
                i = this.O00000o0 < 4 ? this.O00000o0 : 4;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("获得");
                stringBuilder.append(i);
                stringBuilder.append("个积分，继续保持哦~");
                SpannableString spannableString = new SpannableString(stringBuilder.toString());
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.sport_green)), 2, 3, 34);
                textView2.setText(spannableString);
                textView.setText(String.format(Locale.getDefault(), "已连续签到%d天", new Object[]{Integer.valueOf(this.O00000o0)}));
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
                recyclerView.setNestedScrollingEnabled(false);
                ex exVar = new ex();
                recyclerView.setAdapter(exVar);
                exVar.O000000o(this.O00000Oo);
                return;
            } else if (this.O00000o0 >= 1) {
                DailySignBean dailySignBean = new DailySignBean();
                dailySignBean.setDay((((this.O00000o0 - 1) / 4) * 4) + i);
                if ((this.O00000o0 - 1) % 4 >= i - 1) {
                    z = true;
                }
                dailySignBean.setSelected(z);
                if (this.O00000o0 < 4) {
                    i2 = i;
                }
                dailySignBean.setScore(i2);
                this.O00000Oo.add(dailySignBean);
                i++;
            } else {
                return;
            }
        }
    }
}
