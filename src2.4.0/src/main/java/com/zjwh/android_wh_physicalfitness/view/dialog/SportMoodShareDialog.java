package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.SportMoodMatchBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.O00000o;
import com.zjwh.android_wh_physicalfitness.utils.O0000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0OO;
import defpackage.O00Oo;
import defpackage.O0O0OO;
import defpackage.gg;
import defpackage.ooooOO00;
import s.h.e.l.l.C;

public class SportMoodShareDialog extends DialogFragment {
    public static final String O000000o = "extra_img_url";
    public static final String O00000Oo = "extra_start_time";
    public static final String O00000o = "extra_total_dis";
    public static final String O00000o0 = "extra_sport_type";
    public static final String O00000oO = "extra_speed";
    public static final String O00000oo = "extra_total_time";
    public static final String O0000O0o = "extra_calories";
    private ViewStub O0000OOo;
    private ViewStub O0000Oo;
    private ViewStub O0000Oo0;
    private View O0000OoO;
    private View O0000Ooo;
    private ImageView O0000o;
    private ImageView O0000o0;
    private View O0000o00;
    private ImageView O0000o0O;
    private TextView O0000o0o;
    private TextView O0000oO;
    private TextView O0000oO0;
    private TextView O0000oOO;
    private AnimatorSet O0000oOo;
    private Animator O0000oo;
    private AnimatorSet O0000oo0;
    private O00000Oo O0000ooO;
    private SportMoodMatchBean O0000ooo;
    private double O000O00o;
    private double O000O0OO;
    private long O000O0Oo;
    private int O000O0o;
    private int O000O0o0;
    private long O00oOoOo;
    private UserInfo O00oOooO;
    private String O00oOooo;

    public interface O00000Oo {
        void O000000o();

        void O000000o(int i, int i2);

        void O000000o(String str);
    }

    private class O000000o implements OnClickListener {
        private String O00000Oo;

        O000000o(String str) {
            this.O00000Oo = str;
        }

        public void onClick(View view) {
            O00Oo0OO.O000000o(view, ClientOSType.ANDROID, this.O00000Oo, new OnClickListener() {
                public void onClick(View view) {
                    SportMoodShareDialog.this.O00000oO();
                }
            });
        }
    }

    static {
        C.i(16777379);
    }

    public static native SportMoodShareDialog O000000o(long j, int i, double d, double d2, long j2, int i2, String str);

    private void O000000o(Bundle bundle) {
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.O000O0Oo = bundle.getLong("extra_start_time");
            this.O000O0o0 = bundle.getInt("extra_sport_type");
            this.O000O00o = bundle.getDouble("extra_total_dis");
            this.O000O0OO = bundle.getDouble("extra_speed");
            this.O00oOoOo = bundle.getLong("extra_total_time");
            this.O000O0o = bundle.getInt("extra_calories");
            this.O00oOooo = bundle.getString(O000000o);
        }
    }

    private native void O000000o(View view);

    private void O00000Oo(final SportMoodMatchBean sportMoodMatchBean) {
        this.O0000Ooo = this.O0000Oo0.inflate();
        ImageView imageView = (ImageView) this.O0000Ooo.findViewById(R.id.ivHead);
        ImageView imageView2 = (ImageView) this.O0000Ooo.findViewById(R.id.ivClose);
        ImageView imageView3 = (ImageView) this.O0000Ooo.findViewById(R.id.ivPhoto);
        this.O0000oO0 = (TextView) this.O0000Ooo.findViewById(R.id.tvSchool);
        this.O0000o = (ImageView) this.O0000Ooo.findViewById(R.id.ivLike);
        this.O0000o0 = (ImageView) this.O0000Ooo.findViewById(R.id.ivIcon);
        this.O0000o0o = (TextView) this.O0000Ooo.findViewById(R.id.tvName);
        this.O0000o0O = (ImageView) this.O0000Ooo.findViewById(R.id.ivLikeIcon);
        imageView.setImageResource(O0000Oo0() == 0 ? R.drawable.sport_mood_female_male_icon : R.drawable.sport_mood_male_female_icon);
        this.O0000o0.setImageResource(R.drawable.share_mood_unknow_icon);
        if (sportMoodMatchBean != null) {
            if (!TextUtils.isEmpty(sportMoodMatchBean.getImgUrl())) {
                O00Oo.O00000o0(getContext()).O000000o(sportMoodMatchBean.getImgUrl()).O0000Oo().O00000Oo((O0O0OO) new ooooOO00(String.valueOf(System.currentTimeMillis()))).O000000o(imageView3);
            }
            this.O0000oO0.setText("运动世界校园");
            if (!TextUtils.isEmpty(sportMoodMatchBean.getNickName())) {
                this.O0000o0o.setText(String.format("%sXX", new Object[]{sportMoodMatchBean.getNickName().substring(0, 1)}));
            }
            this.O0000o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!O00OOo0.O000000o()) {
                        SportMoodShareDialog.this.O0000o.setEnabled(false);
                        SportMoodShareDialog.this.O0000oo = O00000o.O000000o(SportMoodShareDialog.this.O0000o0O);
                        O00Oo00o.O000000o(view.getContext(), com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o.O0000o00, "click_02");
                        if (SportMoodShareDialog.this.O0000ooO != null) {
                            SportMoodShareDialog.this.O0000ooO.O000000o(sportMoodMatchBean.getDynamicUid(), sportMoodMatchBean.getDynamicId());
                        }
                    }
                }
            });
        }
        imageView2.setOnClickListener(new O000000o(getString(R.string.close_match_dialog)));
    }

    private native void O00000oo();

    private void O0000O0o() {
        this.O0000OoO = this.O0000OOo.inflate();
        ImageView imageView = (ImageView) this.O0000OoO.findViewById(R.id.ivHead);
        TextView textView = (TextView) this.O0000OoO.findViewById(R.id.tvDate);
        TextView textView2 = (TextView) this.O0000OoO.findViewById(R.id.tvType);
        TextView textView3 = (TextView) this.O0000OoO.findViewById(R.id.tvDistance);
        TextView textView4 = (TextView) this.O0000OoO.findViewById(R.id.tvSpeed);
        TextView textView5 = (TextView) this.O0000OoO.findViewById(R.id.tvTime);
        TextView textView6 = (TextView) this.O0000OoO.findViewById(R.id.tvCalories);
        TextView textView7 = (TextView) this.O0000OoO.findViewById(R.id.tvTxtDistance);
        ImageView imageView2 = (ImageView) this.O0000OoO.findViewById(R.id.ivClose);
        ImageView imageView3 = (ImageView) this.O0000OoO.findViewById(R.id.ivPhoto);
        this.O0000oOO = (TextView) this.O0000OoO.findViewById(R.id.tvReChoose);
        this.O0000oO = (TextView) this.O0000OoO.findViewById(R.id.tvShare);
        final ConstraintLayout constraintLayout = (ConstraintLayout) this.O0000OoO.findViewById(R.id.shareLayout);
        imageView.setImageResource(O0000Oo0() == 0 ? R.drawable.sport_mood_female_icon : R.drawable.sport_mood_male_icon);
        textView.setShadowLayer(0.5f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ContextCompat.getColor(getContext(), R.color.text_color_label));
        textView2.setShadowLayer(0.5f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ContextCompat.getColor(getContext(), R.color.text_color_label));
        textView3.setShadowLayer(5.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ContextCompat.getColor(getContext(), R.color.text_color_label));
        textView4.setShadowLayer(0.5f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ContextCompat.getColor(getContext(), R.color.text_color_label));
        textView5.setShadowLayer(0.5f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ContextCompat.getColor(getContext(), R.color.text_color_label));
        textView6.setShadowLayer(0.5f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ContextCompat.getColor(getContext(), R.color.text_color_label));
        textView7.setShadowLayer(0.5f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ContextCompat.getColor(getContext(), R.color.text_color_label));
        textView.setText(O000O0o0.O000000o(O000O0o0.O0000o00, this.O000O0Oo));
        CharSequence charSequence = this.O000O0o0 == 3 ? "约定终点" : this.O000O0o0 == 4 ? "自由跑" : "随机终点";
        textView2.setText(charSequence);
        textView3.setText(O00Oo0.O00000o0(this.O000O00o));
        textView4.setText(String.format("配速：%s", new Object[]{O00Oo0.O0000O0o(this.O000O0OO)}));
        textView5.setText(String.format("时长：%s", new Object[]{O00Oo0.O000000o(this.O00oOoOo)}));
        String str = "卡路里：%s";
        Object[] objArr = new Object[1];
        objArr[0] = String.valueOf(this.O000O0o == 0 ? O00Oo0.O000000o((float) this.O000O00o) : this.O000O0o);
        textView6.setText(String.format(str, objArr));
        if (!TextUtils.isEmpty(this.O00oOooo)) {
            O00Oo.O00000o0(getContext()).O000000o(this.O00oOooo).O0000Oo().O00000Oo((O0O0OO) new ooooOO00(String.valueOf(System.currentTimeMillis()))).O000000o(imageView3);
        }
        imageView2.setOnClickListener(new O000000o(getString(R.string.close_share_dialog)));
        this.O0000oOO.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SportMoodShareDialog.this.O0000ooO != null) {
                    SportMoodShareDialog.this.O0000ooO.O000000o();
                }
            }
        });
        this.O0000oO.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!O00OOo0.O000000o()) {
                    SportMoodShareDialog.this.O0000oO.setEnabled(false);
                    SportMoodShareDialog.this.O0000oOO.setEnabled(false);
                    Bitmap O000000o = O0000Oo.O000000o(constraintLayout);
                    if (Environment.getExternalStorageState().equals("mounted")) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(gg.O00000oO);
                        stringBuilder.append(System.currentTimeMillis());
                        stringBuilder.append("img.jpeg");
                        String stringBuilder2 = stringBuilder.toString();
                        if (O000000o != null) {
                            O0000Oo.O000000o(O000000o, stringBuilder2, 100);
                            O000000o.recycle();
                            if (SportMoodShareDialog.this.O0000ooO != null) {
                                SportMoodShareDialog.this.O0000ooO.O000000o(stringBuilder2);
                            }
                        } else {
                            O00Oo00.O000000o("图片为空!");
                        }
                    }
                }
            }
        });
    }

    private native void O0000OOo();

    private native int O0000Oo0();

    public native void O000000o();

    public native void O000000o(SportMoodMatchBean sportMoodMatchBean);

    public void O000000o(O00000Oo o00000Oo) {
        this.O0000ooO = o00000Oo;
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000o();

    public native boolean O00000o0();

    public native void O00000oO();

    public native void onActivityCreated(Bundle bundle);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        this.O00oOooO = O00Oo0.O00000o0();
        setStyle(2, R.style.BaseDialog);
        setCancelable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sport_mood_share, viewGroup, false);
        this.O0000OOo = (ViewStub) inflate.findViewById(R.id.vsRunShare);
        this.O0000Oo0 = (ViewStub) inflate.findViewById(R.id.vsShareMatch);
        this.O0000Oo = (ViewStub) inflate.findViewById(R.id.vsShareMatchError);
        O0000O0o();
        O00000oo();
        return inflate;
    }

    public native void onDestroy();

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("extra_start_time", this.O000O0Oo);
        bundle.putInt("extra_sport_type", this.O000O0o0);
        bundle.putDouble("extra_total_dis", this.O000O00o);
        bundle.putDouble("extra_speed", this.O000O0OO);
        bundle.putLong("extra_total_time", this.O00oOoOo);
        bundle.putInt("extra_calories", this.O000O0o);
        bundle.putString(O000000o, this.O00oOooo);
    }
}
