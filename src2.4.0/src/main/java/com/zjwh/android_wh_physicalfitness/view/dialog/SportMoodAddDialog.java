package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0OO;
import s.h.e.l.l.C;

public class SportMoodAddDialog extends DialogFragment {
    public static final String O000000o = "SportMoodAddDialog";
    public static final String O00000Oo = "sp_key_show_close_tip";
    public static final String O00000o = "extra_sport_type";
    public static final String O00000o0 = "extra_start_time";
    public static final String O00000oO = "extra_total_dis";
    public static final String O00000oo = "extra_speed";
    public static final String O0000O0o = "extra_total_time";
    public static final String O0000OOo = "extra_calories";
    private long O0000Oo;
    private O000000o O0000Oo0;
    private int O0000OoO;
    private double O0000Ooo;
    private long O0000o0;
    private double O0000o00;
    private int O0000o0O;

    public interface O000000o {
        void O000000o();
    }

    static {
        C.i(16777378);
    }

    public static native SportMoodAddDialog O000000o(long j, int i, double d, double d2, long j2, int i2);

    private void O000000o(Bundle bundle) {
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.O0000Oo = bundle.getLong("extra_start_time");
            this.O0000OoO = bundle.getInt("extra_sport_type");
            this.O0000Ooo = bundle.getDouble("extra_total_dis");
            this.O0000o00 = bundle.getDouble("extra_speed");
            this.O0000o0 = bundle.getLong("extra_total_time");
            this.O0000o0O = bundle.getInt("extra_calories");
        }
    }

    public void O000000o(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    public native void onActivityCreated(Bundle bundle);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        setStyle(2, R.style.BaseDialog);
        setCancelable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sport_mood_add, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tvDate);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tvType);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tvDistance);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tvSpeed);
        TextView textView5 = (TextView) inflate.findViewById(R.id.tvTime);
        TextView textView6 = (TextView) inflate.findViewById(R.id.tvCalories);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ivClose);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ivHead);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.llAddPhoto);
        UserInfo O00000o0 = O00Oo0.O00000o0();
        if (O00000o0 != null) {
            imageView2.setImageResource(O00000o0.getSex() == 0 ? R.drawable.sport_mood_female_icon : R.drawable.sport_mood_male_icon);
        }
        textView.setText(O000O0o0.O000000o(O000O0o0.O0000o00, this.O0000Oo));
        CharSequence charSequence = this.O0000OoO == 3 ? "约定终点" : this.O0000OoO == 4 ? "自由跑" : "随机终点";
        textView2.setText(charSequence);
        textView3.setText(String.format("公里：%s", new Object[]{O00Oo0.O00000o0(this.O0000Ooo)}));
        textView4.setText(String.format("配速：%s", new Object[]{O00Oo0.O0000O0o(this.O0000o00)}));
        textView5.setText(String.format("时长：%s", new Object[]{O00Oo0.O000000o(this.O0000o0)}));
        String str = "卡路里：%s";
        Object[] objArr = new Object[1];
        objArr[0] = String.valueOf(this.O0000o0O == 0 ? O00Oo0.O000000o((float) this.O0000Ooo) : this.O0000o0O);
        textView6.setText(String.format(str, objArr));
        linearLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SportMoodAddDialog.this.O0000Oo0 != null) {
                    SportMoodAddDialog.this.O0000Oo0.O000000o();
                }
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                O00Oo0OO.O000000o(view, ClientOSType.IOS, SportMoodAddDialog.this.getString(R.string.close_share_dialog), new OnClickListener() {
                    public void onClick(View view) {
                        if (SportMoodAddDialog.this.isResumed()) {
                            SportMoodAddDialog.this.dismiss();
                        } else {
                            SportMoodAddDialog.this.dismissAllowingStateLoss();
                        }
                    }
                });
            }
        });
        return inflate;
    }

    public native void onDestroy();

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("extra_start_time", this.O0000Oo);
        bundle.putInt("extra_sport_type", this.O0000OoO);
        bundle.putDouble("extra_total_dis", this.O0000Ooo);
        bundle.putDouble("extra_speed", this.O0000o00);
        bundle.putLong("extra_total_time", this.O0000o0);
        bundle.putInt("extra_calories", this.O0000o0O);
    }
}
