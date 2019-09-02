package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.qf.qrcode.R;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicProgressEvt;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicStatusEvt;
import com.zjwh.android_wh_physicalfitness.ui.music.AlbumDetailActivity;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicMainActivity;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O00Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import org.greenrobot.eventbus.O00000o0;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.common.util.DensityUtil;
import s.h.e.l.l.C;

public class MusicPlayerDialog extends DialogFragment implements OnClickListener {
    public static final String O000000o = "MusicPlayerDialog";
    public static final String O00000Oo = "extra_announcer_name";
    public static final String O00000o = "extra_duration";
    public static final String O00000o0 = "extra_position";
    public static final String O00000oO = "extra_paid";
    public static final String O00000oo = "extra_count";
    private ImageButton O0000O0o;
    private SeekBar O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private String O0000OoO;
    private String O0000Ooo;
    private long O0000o;
    private int O0000o0;
    private String O0000o00;
    private int O0000o0O;
    private long O0000o0o;
    private boolean O0000oO0;

    static {
        C.i(52);
    }

    public static native MusicPlayerDialog O000000o(String str, String str2, long j, String str3, int i, int i2, boolean z, long j2);

    private native void O000000o();

    private void O000000o(Bundle bundle) {
        if (bundle != null) {
            this.O0000OoO = bundle.getString(O00O00Oo.O000000o, "");
            this.O0000Ooo = bundle.getString(O00O00Oo.O00000Oo, "");
            this.O0000o0o = bundle.getLong("extra_album_id", -1);
            this.O0000o00 = bundle.getString(O00000Oo, "");
            this.O0000o0 = bundle.getInt(O00000o0, 0);
            this.O0000o0O = bundle.getInt(O00000o, 0);
            this.O0000oO0 = bundle.getBoolean("extra_paid", false);
            this.O0000o = bundle.getLong(O00000oo, 0);
        }
    }

    public void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            switch (view.getId()) {
                case 2131296352:
                    O00O00Oo.O000000o().O0000O0o();
                    dismiss();
                    break;
                case 2131296353:
                    MusicMainActivity.O000000o(getActivity());
                    dismiss();
                    break;
                case 2131296354:
                    O000000o();
                    O00O00Oo.O000000o().O00000oO();
                    break;
                case 2131296356:
                    O00O00Oo.O000000o().O00000o();
                    break;
                case 2131296357:
                    O000000o();
                    O00O00Oo.O000000o().O00000oo();
                    break;
                case 2131296651:
                    AlbumDetailActivity.O000000o(getActivity(), this.O0000o0o, this.O0000o00, this.O0000oO0, this.O0000o);
                    dismiss();
                    break;
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2131755014);
        if (bundle == null) {
            bundle = getArguments();
        }
        O000000o(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        O00000o0.O000000o().O000000o(this);
        return layoutInflater.inflate(2131427598, viewGroup, false);
    }

    public native void onDestroy();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MusicProgressEvt musicProgressEvt) {
        if (musicProgressEvt != null) {
            this.O0000Oo0.setText(musicProgressEvt.getCurrPo() > 0 ? O000O0o0.O000000o("mm:ss", (long) musicProgressEvt.getCurrPo()) : "00:00");
            this.O0000Oo.setText(O000O0o0.O000000o("mm:ss", (long) musicProgressEvt.getDuration()));
            this.O0000OOo.setMax(musicProgressEvt.getDuration());
            this.O0000OOo.setProgress(musicProgressEvt.getCurrPo());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(O00O00Oo.O000000o, this.O0000OoO);
        bundle.putString(O00O00Oo.O00000Oo, this.O0000Ooo);
        bundle.putLong("extra_album_id", this.O0000o0o);
        bundle.putString(O00000Oo, this.O0000o00);
        bundle.putLong(O00000oo, this.O0000o);
    }

    public native void onStart();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStatusEvent(MusicStatusEvt musicStatusEvt) {
        if (musicStatusEvt != null) {
            this.O0000O0o.setImageResource(musicStatusEvt.isPlaying() ? 2131231065 : 2131231066);
        }
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(2131296630);
        TextView textView = (TextView) view.findViewById(2131297189);
        TextView textView2 = (TextView) view.findViewById(2131297187);
        this.O0000O0o = (ImageButton) view.findViewById(2131296356);
        this.O0000OOo = (SeekBar) view.findViewById(2131297092);
        this.O0000Oo0 = (TextView) view.findViewById(2131297209);
        this.O0000Oo = (TextView) view.findViewById(2131297293);
        if (this.O0000o0O > 0) {
            this.O0000Oo.setText(O000O0o0.O000000o("mm:ss", (long) this.O0000o0O));
            this.O0000OOo.setMax(this.O0000o0O);
        }
        if (this.O0000o0 > 0) {
            this.O0000Oo0.setText(O000O0o0.O000000o("mm:ss", (long) this.O0000o0));
            this.O0000OOo.setProgress(this.O0000o0);
        }
        this.O0000O0o.setImageResource(O00O00Oo.O000000o().O0000OoO() ? 2131231065 : 2131231066);
        textView2.setText(String.format("%s 来源：喜马拉雅fm", new Object[]{this.O0000o00}));
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            O00Oo.O00000o0(getContext()).O000000o(this.O0000OoO).O0000Oo(R.color.transparent).O00000o(R.color.transparent).O000000o(new O0OoOo[]{new lb(getContext(), DensityUtil.dip2px(2.0f), 0)}).O000000o(imageView);
        }
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            textView.setText(this.O0000Ooo);
        }
        this.O0000OOo.setOnSeekBarChangeListener(new 1(this));
        this.O0000O0o.setOnClickListener(this);
        view.findViewById(2131296357).setOnClickListener(this);
        view.findViewById(2131296354).setOnClickListener(this);
        view.findViewById(2131296353).setOnClickListener(this);
        view.findViewById(2131296352).setOnClickListener(this);
        view.findViewById(2131296651).setOnClickListener(this);
    }
}
