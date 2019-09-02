package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import org.xutils.common.util.DensityUtil;

/* compiled from: LoadingDialog */
public class O0000Oo0 {
    public static Dialog O000000o(Context context, int i) {
        return O000000o(context, context.getResources().getString(i));
    }

    public static Dialog O000000o(Context context, String str) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.dialog_view);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img);
        TextView textView = (TextView) inflate.findViewById(R.id.tipTextView);
        imageView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.loading));
        textView.setText(str);
        Dialog dialog = new Dialog(context, R.style.loading_dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(linearLayout, new LayoutParams(DensityUtil.dip2px(100.0f), DensityUtil.dip2px(80.0f)));
        return dialog;
    }
}
