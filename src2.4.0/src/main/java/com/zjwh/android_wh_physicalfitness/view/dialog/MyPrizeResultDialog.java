package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.PrizeListActivity;
import com.zjwh.android_wh_physicalfitness.entity.DrawWinBean;
import s.h.e.l.l.C;

public class MyPrizeResultDialog extends DialogFragment {
    public static final String O000000o = "draw_result";
    private DrawWinBean O00000Oo;

    static {
        C.i(16777376);
    }

    public static native MyPrizeResultDialog O000000o(DrawWinBean drawWinBean);

    private native void O000000o(Bundle bundle);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        setStyle(2, R.style.BaseDialog);
        setCancelable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().setCanceledOnTouchOutside(false);
        return layoutInflater.inflate(R.layout.dialog_prize_result, viewGroup, false);
    }

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_cancel);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_prize);
        TextView textView = (TextView) view.findViewById(R.id.tv_prize_detail);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MyPrizeResultDialog.this.dismiss();
            }
        });
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MyPrizeResultDialog.this.isAdded() && !MyPrizeResultDialog.this.isDetached()) {
                    MyPrizeResultDialog.this.dismiss();
                    if (MyPrizeResultDialog.this.O00000Oo != null && MyPrizeResultDialog.this.O00000Oo.isGetPrize()) {
                        PrizeListActivity.O000000o(MyPrizeResultDialog.this.getActivity());
                    }
                }
            }
        });
        if (this.O00000Oo != null) {
            imageView2.setImageResource(this.O00000Oo.isGetPrize() ? R.drawable.congratulate : R.drawable.gift_dialog_sorry_icon);
            textView.setText(this.O00000Oo.isGetPrize() ? "查看奖励详情" : "我知道了");
        }
    }
}
