package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DrawWinBean;
import com.zjwh.android_wh_physicalfitness.entity.PrizeListBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O00000o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import defpackage.ec;
import defpackage.ec.O00000Oo;
import defpackage.gf;
import java.io.UnsupportedEncodingException;
import org.xutils.common.util.DensityUtil;
import s.h.e.l.l.C;

public class MyDrawWinDialog extends DialogFragment implements O00000Oo {
    public static final String O000000o = "draw_win";
    private DrawWinBean O00000Oo;
    private O000000o O00000o;
    private TextView O00000o0;
    private boolean O00000oO;

    public interface O000000o {
        void O000000o();
    }

    static {
        C.i(16777375);
    }

    public static native MyDrawWinDialog O000000o(DrawWinBean drawWinBean);

    private native void O000000o(Bundle bundle);

    public void O000000o(PrizeListBean prizeListBean) {
        if (prizeListBean != null && !TextUtils.isEmpty(prizeListBean.getDefinedUrl())) {
            Context context = getContext();
            String str = com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o.O00000o0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(gf.O000o00O);
            stringBuilder.append(prizeListBean.getPrizeName());
            O00Oo00o.O000000o(context, str, stringBuilder.toString());
            String definedUrl = prizeListBean.getDefinedUrl();
            try {
                if (!TextUtils.isEmpty(prizeListBean.getDefinedUrl())) {
                    definedUrl = O00000o0.O000000o(prizeListBean.getDefinedUrl());
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            O000o0.O000000o(getActivity(), definedUrl);
        }
    }

    public void O000000o(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public native void O000000o(boolean z);

    public native void O00000Oo(boolean z);

    public native void onActivityCreated(Bundle bundle);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        setStyle(2, R.style.BaseDialog);
        setCancelable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_prize_win, viewGroup, false);
    }

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_cancel);
        this.O00000o0 = (TextView) view.findViewById(R.id.tvDrawAgain);
        int i = 0;
        this.O00000o0.setVisibility(this.O00000oO ? 0 : 8);
        this.O00000o0.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MyDrawWinDialog.this.O00000o != null) {
                    MyDrawWinDialog.this.O00000o.O000000o();
                }
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MyDrawWinDialog.this.isResumed()) {
                    MyDrawWinDialog.this.dismiss();
                } else {
                    MyDrawWinDialog.this.dismissAllowingStateLoss();
                }
                O00Oo00o.O000000o(MyDrawWinDialog.this.getContext(), com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o.O00000o0, O00Oo00o.O00000o0.O00000o0);
                O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOo0, "close_bztk"));
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ec ecVar = new ec(this);
        recyclerView.addItemDecoration(new com.zjwh.android_wh_physicalfitness.view.O000000o(DensityUtil.dip2px(10.0f)));
        if (!(this.O00000Oo == null || this.O00000Oo.getPrizeList() == null || this.O00000Oo.getPrizeList().size() <= 0)) {
            ecVar.O000000o(this.O00000Oo.getPrizeList());
        }
        recyclerView.setAdapter(ecVar);
        while (i < this.O00000Oo.getPrizeList().size()) {
            PrizeListBean prizeListBean = (PrizeListBean) this.O00000Oo.getPrizeList().get(i);
            if (!TextUtils.isEmpty(prizeListBean.getAdExposingCodes())) {
                O00000o0.O00000Oo(prizeListBean.getAdExposingCodes());
            }
            Context context = getContext();
            String str = com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o.O00000o0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(gf.O000o00);
            stringBuilder.append(prizeListBean.getPrizeName());
            O00Oo00o.O000000o(context, str, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(gf.O000o00);
            stringBuilder.append(prizeListBean.getPrizeName());
            O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOo0, stringBuilder.toString()));
            i++;
        }
    }
}
