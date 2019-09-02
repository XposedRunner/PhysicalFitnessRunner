package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import s.h.e.l.l.C;

public class LotteryDialog extends DialogFragment {
    private ImageView O000000o;
    private TextView O00000Oo;
    private Button O00000o;
    private TextView O00000o0;
    private O000000o O00000oO;
    private ObjectAnimator O00000oo;

    public interface O000000o {
        void O00000oo();
    }

    static {
        C.i(16777374);
    }

    public static native LotteryDialog O000000o();

    public void O000000o(O000000o o000000o) {
        this.O00000oO = o000000o;
    }

    public native void O00000Oo();

    public native void onActivityCreated(Bundle bundle);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.BaseDialog);
        setCancelable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_lottery_dialog, viewGroup, false);
    }

    public native void onDestroy();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_cancel);
        this.O000000o = (ImageView) view.findViewById(R.id.iv_lottery);
        this.O00000Oo = (TextView) view.findViewById(R.id.tv_title);
        this.O00000o0 = (TextView) view.findViewById(R.id.tv_tip);
        this.O00000o = (Button) view.findViewById(R.id.tv_prize_detail);
        this.O00000Oo.setText("恭喜你,获得一次抽奖机会");
        this.O00000Oo.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color_hint));
        this.O00000o0.setText("本次跑步经过的点位发现了一个随机奖品礼盒");
        this.O00000o0.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color_hint));
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (LotteryDialog.this.isAdded() && !LotteryDialog.this.isDetached()) {
                    LotteryDialog.this.dismiss();
                }
            }
        });
        this.O00000o.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LotteryDialog.this.O00000o.setEnabled(false);
                LotteryDialog.this.O00000oo = ObjectAnimator.ofFloat(LotteryDialog.this.O000000o, "rotation", new float[]{CropImageView.DEFAULT_ASPECT_RATIO, -30.0f, CropImageView.DEFAULT_ASPECT_RATIO, 30.0f, CropImageView.DEFAULT_ASPECT_RATIO});
                LotteryDialog.this.O00000oo.setRepeatCount(-1);
                LotteryDialog.this.O00000oo.setInterpolator(new LinearInterpolator());
                LotteryDialog.this.O00000oo.start();
                if (LotteryDialog.this.O00000oO != null) {
                    LotteryDialog.this.O00000oO.O00000oo();
                }
            }
        });
    }
}
