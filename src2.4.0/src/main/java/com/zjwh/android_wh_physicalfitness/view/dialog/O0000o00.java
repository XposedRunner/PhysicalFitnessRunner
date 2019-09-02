package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.view.GPSSearchView;
import org.xutils.common.util.DensityUtil;

/* compiled from: SearchGPSDialog */
public class O0000o00 {
    public static Dialog O000000o(Context context, int i) {
        return O000000o(context, context.getResources().getString(i));
    }

    public static Dialog O000000o(Context context, String str) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.search_gps_dialog, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.dialog_view);
        GPSSearchView gPSSearchView = (GPSSearchView) inflate.findViewById(R.id.img);
        TextView textView = (TextView) inflate.findViewById(R.id.tipTextView);
        gPSSearchView.O000000o();
        textView.setText(str);
        Dialog dialog = new Dialog(context, R.style.loading_dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(linearLayout, new LayoutParams(DensityUtil.dip2px(160.0f), DensityUtil.dip2px(89.0f)));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = CropImageView.DEFAULT_ASPECT_RATIO;
        window.setAttributes(attributes);
        return dialog;
    }
}
