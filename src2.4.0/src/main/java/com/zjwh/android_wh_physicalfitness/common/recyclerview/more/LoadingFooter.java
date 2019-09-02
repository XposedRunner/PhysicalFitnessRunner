package com.zjwh.android_wh_physicalfitness.common.recyclerview.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.zjwh.android_wh_physicalfitness.R;

public class LoadingFooter extends RelativeLayout {
    protected O000000o O000000o = O000000o.Normal;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;

    public enum O000000o {
        Normal,
        TheEnd,
        Loading,
        NetWorkError
    }

    public LoadingFooter(Context context) {
        super(context);
        O000000o(context);
    }

    public LoadingFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public LoadingFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    public void O000000o(Context context) {
        inflate(context, R.layout.load_more_footer, this);
        setOnClickListener(null);
        O000000o(O000000o.Normal, true);
    }

    public void O000000o(O000000o o000000o, boolean z) {
        if (this.O000000o != o000000o) {
            this.O000000o = o000000o;
            int i = 0;
            View view;
            switch (o000000o) {
                case Normal:
                    setOnClickListener(null);
                    if (this.O00000Oo != null) {
                        this.O00000Oo.setVisibility(8);
                    }
                    if (this.O00000o != null) {
                        this.O00000o.setVisibility(8);
                    }
                    if (this.O00000o0 != null) {
                        this.O00000o0.setVisibility(8);
                        break;
                    }
                    break;
                case Loading:
                    setOnClickListener(null);
                    if (this.O00000o != null) {
                        this.O00000o.setVisibility(8);
                    }
                    if (this.O00000o0 != null) {
                        this.O00000o0.setVisibility(8);
                    }
                    if (this.O00000Oo == null) {
                        this.O00000Oo = ((ViewStub) findViewById(R.id.loading_viewstub)).inflate();
                    } else {
                        this.O00000Oo.setVisibility(0);
                    }
                    view = this.O00000Oo;
                    if (!z) {
                        i = 8;
                    }
                    view.setVisibility(i);
                    break;
                case TheEnd:
                    setOnClickListener(null);
                    if (this.O00000Oo != null) {
                        this.O00000Oo.setVisibility(8);
                    }
                    if (this.O00000o0 != null) {
                        this.O00000o0.setVisibility(8);
                    }
                    if (this.O00000o == null) {
                        this.O00000o = ((ViewStub) findViewById(R.id.end_viewstub)).inflate();
                    } else {
                        this.O00000o.setVisibility(0);
                    }
                    view = this.O00000o;
                    if (!z) {
                        i = 8;
                    }
                    view.setVisibility(i);
                    break;
                case NetWorkError:
                    if (this.O00000Oo != null) {
                        this.O00000Oo.setVisibility(8);
                    }
                    if (this.O00000o != null) {
                        this.O00000o.setVisibility(8);
                    }
                    if (this.O00000o0 == null) {
                        this.O00000o0 = ((ViewStub) findViewById(R.id.network_error_viewstub)).inflate();
                    } else {
                        this.O00000o0.setVisibility(0);
                    }
                    view = this.O00000o0;
                    if (!z) {
                        i = 8;
                    }
                    view.setVisibility(i);
                    break;
            }
        }
    }

    public O000000o getState() {
        return this.O000000o;
    }

    public void setState(O000000o o000000o) {
        O000000o(o000000o, true);
    }
}
