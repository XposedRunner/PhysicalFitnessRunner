package com.zjwh.android_wh_physicalfitness.ui.run;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.MapView;
import com.bumptech.glide.load.resource.bitmap.O0000O0o;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DueRunningPerson;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00000o;
import com.zjwh.android_wh_physicalfitness.utils.O0000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O000Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0OO;
import com.zjwh.map.gaode.O00oOooO;
import com.zjwh.sw.map.O00000o0;
import com.zjwh.sw.map.entity.SWFixedPoint;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.O00O0o;
import defpackage.O00Oo;
import defpackage.je;
import defpackage.la;
import defpackage.lq;
import defpackage.lz;
import defpackage.oO00OOOo;
import defpackage.oOo000Oo;
import defpackage.ooOOO0Oo;
import java.util.ArrayList;
import java.util.List;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427455)
public class BaseRunFragment extends BaseFragment implements O00000Oo {
    public static final String O000000o = "BaseRunFragment";
    public static final int O00000oo = 1000;
    @ViewInject(2131297011)
    private ImageButton O0000O0o;
    @ViewInject(2131297017)
    private ImageView O0000OOo;
    @ViewInject(2131297352)
    private TextView O0000Oo;
    @ViewInject(2131297018)
    private TextView O0000Oo0;
    @ViewInject(2131297424)
    private TextView O0000OoO;
    @ViewInject(2131297408)
    private TextView O0000Ooo;
    private BaseRunActivity O0000o;
    @ViewInject(2131296749)
    private View O0000o0;
    @ViewInject(2131297317)
    private TextView O0000o00;
    @ViewInject(2131296847)
    private MapView O0000o0O;
    private lq O0000o0o;
    private AnimatorSet O0000oO;
    private Animator O0000oO0;
    private AnimatorSet O0000oOO;
    private AnimatorSet O0000oOo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.BaseRunFragment$2 */
    class AnonymousClass2 implements lz {
        final /* synthetic */ boolean O000000o;

        AnonymousClass2(boolean z) {
            this.O000000o = z;
        }

        public View O000000o(int i, String str) {
            CharSequence string;
            View inflate = LayoutInflater.from(BaseRunFragment.this.getActivity()).inflate(R.layout.layout_infowindow, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_address);
            if (!this.O000000o) {
                switch (i) {
                    case 1:
                        string = BaseRunFragment.this.getString(R.string.txt_assess_point);
                        break;
                    case 2:
                        string = BaseRunFragment.this.getString(R.string.txt_end_point);
                        break;
                    default:
                        string = BaseRunFragment.this.getString(R.string.txt_normal_point);
                        break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("下一个点位：");
            stringBuilder.append(i);
            stringBuilder.append("号点");
            string = stringBuilder.toString();
            textView.setText(string);
            textView2.setText(str);
            return i == O00000o0.O000O0OO ? null : inflate;
        }
    }

    static {
        C.i(16777360);
    }

    @Event({2131297011, 2131297025, 2131297026, 2131297024})
    private void clickEvent(View view) {
        int id = view.getId();
        if (id != R.id.run_change_page) {
            switch (id) {
                case R.id.run_map_fix /*2131297024*/:
                    this.O0000oOo = O00000o.O00000Oo(view);
                    if (!this.O0000o.O0000oO()) {
                        this.O0000o.O0000oOO();
                    }
                    AutoFixActivity.O000000o(getActivity());
                    return;
                case R.id.run_map_location /*2131297025*/:
                    this.O0000oO = O00000o.O00000Oo(view);
                    O00000Oo();
                    return;
                case R.id.run_map_tip /*2131297026*/:
                    this.O0000oOO = O00000o.O00000Oo(view);
                    this.O0000o.O0000oO0();
                    return;
                default:
                    return;
            }
        }
        this.O0000o.O00000oO(2);
    }

    public native void O000000o(double d, double d2);

    public void O000000o(double d, double d2, float f) {
        if (O0000Ooo() && this.O0000o0o != null) {
            this.O0000o0o.O000000o(d, d2, f);
        }
    }

    public native void O000000o(int i, boolean z);

    /* Access modifiers changed, original: protected */
    public void O000000o(final DueRunningPerson dueRunningPerson) {
        if (O0000Ooo()) {
            try {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_end_point, null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_offline);
                int i = dueRunningPerson.getSex() == 0 ? R.drawable.default_round_female : R.drawable.default_round_male;
                imageView2.setVisibility(dueRunningPerson.getStatus() == 1 ? 8 : 0);
                O00O0o O00000o = O00Oo.O00000o0(getContext()).O000000o(TextUtils.isEmpty(dueRunningPerson.getIcon()) ? Integer.valueOf(i) : dueRunningPerson.getIcon()).O0000Oo().O0000O0o(i).O00000oO(i);
                O0000O0o[] o0000O0oArr = new O0000O0o[1];
                o0000O0oArr[0] = dueRunningPerson.getStatus() == 1 ? new la(getContext()) : new O000Oo0(getContext());
                O00000o.O000000o(o0000O0oArr).O00000Oo((ooOOO0Oo) new oOo000Oo(imageView) {
                    public void O000000o(Bitmap bitmap, oO00OOOo oo00oooo) {
                        super.O000000o((Object) bitmap, oo00oooo);
                        bitmap = O0000Oo.O00000Oo(this.O00000Oo);
                        if (bitmap != null) {
                            try {
                                BaseRunFragment.this.O0000o0o.O000000o(bitmap, new SWLatLng(-1.0d, -1.0d, dueRunningPerson.getLat(), dueRunningPerson.getLon()));
                            } catch (com.zjwh.sw.map.O00000o e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o(SWLatLng sWLatLng) {
        if (O0000Ooo()) {
            try {
                if (this.O0000o0o != null) {
                    this.O0000o0o.O000000o(sWLatLng);
                }
            } catch (com.zjwh.sw.map.O00000o e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o(SWLatLng sWLatLng, SWLatLng sWLatLng2, double d, int i, double d2, double d3, int i2) {
        if (O0000Ooo()) {
            try {
                if (this.O0000o0o != null) {
                    this.O0000o0o.O000000o(sWLatLng, sWLatLng2, d, i, d2, d3, i2);
                }
            } catch (com.zjwh.sw.map.O00000o e) {
                e.printStackTrace();
            }
        }
    }

    public native void O000000o(String str);

    /* Access modifiers changed, original: protected */
    public void O000000o(List<FivePoint> list, SWLatLng sWLatLng, int i) {
        if (O0000Ooo() && this.O0000o0o != null) {
            try {
                List arrayList = new ArrayList();
                for (FivePoint fivePoint : list) {
                    SWFixedPoint sWFixedPoint = r5;
                    SWFixedPoint sWFixedPoint2 = new SWFixedPoint(fivePoint.getLat(), fivePoint.getLon(), -1.0d, -1.0d, fivePoint.getIsFixed(), fivePoint.getPosition(), fivePoint.getIsPass(), fivePoint.getPointName());
                    arrayList.add(sWFixedPoint);
                }
                this.O0000o0o.O000000o(arrayList, sWLatLng, i);
                String str = (String) O00O0Oo0.O00000o0(je.O00000Oo, "");
                if (!TextUtils.isEmpty(str)) {
                    com.zjwh.android_wh_physicalfitness.utils.O00000o0.O00000Oo(str);
                }
            } catch (com.zjwh.sw.map.O00000o e) {
                e.printStackTrace();
            }
        }
    }

    public native void O000000o(boolean z);

    /* Access modifiers changed, original: protected */
    public void O00000Oo() {
        if (O0000Ooo() && this.O0000o != null) {
            SWLatLng O0000Ooo = this.O0000o.O0000o0().O0000Ooo();
            if (O0000Ooo != null) {
                O000000o(O0000Ooo.getGLat(), O0000Ooo.getGLon());
            }
        }
    }

    public native void O00000Oo(int i, int i2);

    public native void O00000Oo(int i, boolean z);

    public native void O00000Oo(boolean z);

    public native void O00000o(String str);

    public native void O00000o0();

    public native void O00000oO(String str);

    public native void onAttach(Context context);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.O00000oO = false;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    public native void onPause();

    public native void onResume();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000Oo.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Impact.ttf"));
        O00Oo0OO.O000000o(getActivity(), this.O0000O0o);
        O00Oo0OO.O000000o(getActivity(), this.O0000OOo);
        O00Oo0OO.O000000o(getActivity(), this.O0000Oo0);
        if (O00Oo0.O0000Ooo()) {
            this.O0000o0o = new O00oOooO(this.O0000o0O, O00Oo0.O0000o0o());
        } else {
            this.O0000o0o = new O00oOooO(this.O0000o0O);
        }
        this.O0000o0o.O00000Oo(bundle);
    }
}
