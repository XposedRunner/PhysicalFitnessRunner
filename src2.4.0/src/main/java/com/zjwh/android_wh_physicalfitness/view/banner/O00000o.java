package com.zjwh.android_wh_physicalfitness.view.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;

/* compiled from: RunHistorySlideView */
public class O00000o extends O000000o {
    public O00000o(Context context) {
        super(context);
    }

    public View O0000Oo0() {
        View inflate = LayoutInflater.from(O0000O0o()).inflate(R.layout.run_history_slide_view, null);
        O000000o(inflate, (ImageView) inflate.findViewById(R.id.daimajia_slider_image), (TextView) inflate.findViewById(R.id.topic_type));
        return inflate;
    }
}
