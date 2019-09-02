package com.zjwh.android_wh_physicalfitness.view.blur;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.BlurDialogItem;
import com.zjwh.android_wh_physicalfitness.entity.BlurDialogMsg;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.List;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427482)
public class BlurDialog extends DialogFragment {
    private static final String O000000o = "extra_dialog_msg";
    @ViewInject(2131297430)
    private TextView O00000Oo;
    @ViewInject(2131297399)
    private TextView O00000o;
    @ViewInject(2131297425)
    private TextView O00000o0;
    @ViewInject(2131297157)
    private View O00000oO;
    @ViewInject(2131297398)
    private TextView O00000oo;
    private O000000o O0000O0o;
    private BlurDialog O0000OOo;
    private O000000o O0000Oo;
    private List<BlurDialogItem> O0000Oo0;
    private BlurDialogMsg O0000OoO;

    public interface O000000o {
        void O0000ooO();
    }

    static {
        C.i(16777372);
    }

    public static native BlurDialog O000000o(BlurDialogMsg blurDialogMsg);

    @Event({2131296679})
    private void cancel(View view) {
        if (view.getId() == R.id.iv_cancel) {
            try {
                this.O0000OOo.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public native void onActivityCreated(Bundle bundle);

    public native void onAttach(Context context);

    public native void onCreate(Bundle bundle);

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDetach();

    public native void onDismiss(DialogInterface dialogInterface);

    public native void onSaveInstanceState(Bundle bundle);

    public native void onStart();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000OoO = (BlurDialogMsg) getArguments().getParcelable(O000000o);
        O00Oo0.O000000o(getActivity(), this.O00000Oo, "fonts/pingfangxi.ttf");
        O00Oo0.O000000o(getActivity(), this.O00000o, "fonts/pingfangxi.ttf");
        O00Oo0.O000000o(getActivity(), this.O00000oo, "fonts/pingfangxi.ttf");
        if (this.O0000OoO != null) {
            this.O00000Oo.setText(this.O0000OoO.getTitle());
            this.O00000Oo.getPaint().setStrokeWidth(0.1f);
            this.O00000o0.setText(this.O0000OoO.getTip());
            if (TextUtils.isEmpty(this.O0000OoO.getValidStep())) {
                this.O00000o.setText(this.O0000OoO.getValidSpeed());
            } else {
                this.O00000o.setText(String.format("%s\n%s", new Object[]{this.O0000OoO.getValidSpeed(), this.O0000OoO.getValidStep()}));
            }
            this.O0000Oo0 = this.O0000OoO.getItems();
        }
        int i = 8;
        if (this.O0000Oo0 == null) {
            this.O00000oO.setVisibility(8);
            this.O00000oo.setVisibility(0);
        } else if (this.O0000Oo0.size() > 0) {
            TextView[] textViewArr = new TextView[]{(TextView) view.findViewById(R.id.tv_tip_one), (TextView) view.findViewById(R.id.tv_tip_two), (TextView) view.findViewById(R.id.tv_tip_three)};
            this.O00000oO.setVisibility(0);
            this.O00000oo.setVisibility(8);
            TextView textView = textViewArr[2];
            if (this.O0000Oo0.size() > 2) {
                i = 0;
            }
            textView.setVisibility(i);
            for (int i2 = 0; i2 < this.O0000Oo0.size(); i2++) {
                BlurDialogItem blurDialogItem = (BlurDialogItem) this.O0000Oo0.get(i2);
                textViewArr[i2].setText(blurDialogItem.getTxt());
                textViewArr[i2].setTextColor(ContextCompat.getColor(view.getContext(), blurDialogItem.getTxtColor() != 0 ? blurDialogItem.getTxtColor() : R.color.white_a20));
                textViewArr[i2].setCompoundDrawablesWithIntrinsicBounds(0, blurDialogItem.getResId(), 0, 0);
            }
        } else {
            this.O00000oO.setVisibility(8);
            this.O00000oo.setVisibility(0);
        }
    }
}
