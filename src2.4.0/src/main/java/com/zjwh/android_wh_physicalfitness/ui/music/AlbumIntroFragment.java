package com.zjwh.android_wh_physicalfitness.ui.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.AlbumIntroEvent;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import defpackage.ho$O00000Oo;
import org.greenrobot.eventbus.O00000o0;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427444)
public class AlbumIntroFragment extends BaseFragment implements ho$O00000Oo {
    public static final String O000000o = "extra_paid";
    @ViewInject(2131297186)
    private TextView O00000oo;
    @ViewInject(2131297296)
    private TextView O0000O0o;
    @ViewInject(2131297194)
    private TextView O0000OOo;
    @ViewInject(2131297272)
    private TextView O0000Oo;
    @ViewInject(2131297295)
    private TextView O0000Oo0;
    private O000000o O0000OoO;

    static {
        C.i(49);
    }

    public static native AlbumIntroFragment O000000o(boolean z);

    private O000000o O00000Oo() {
        if (this.O0000OoO == null) {
            this.O0000OoO = new jw(this);
        }
        return this.O0000OoO;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O00000Oo = O00000Oo();
        if (bundle == null) {
            bundle = getArguments();
        }
        O00000Oo.O000000o(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        O00000o0.O000000o().O000000o(this);
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AlbumIntroEvent albumIntroEvent) {
        if (albumIntroEvent != null) {
            this.O00000oo.setText(albumIntroEvent.getAlbumIntro());
            this.O0000Oo.setText(albumIntroEvent.getNickName());
        }
    }

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        int i = 8;
        this.O0000O0o.setVisibility(O00000Oo().O000000o() ? 0 : 8);
        this.O0000OOo.setVisibility(O00000Oo().O000000o() ? 0 : 8);
        this.O0000Oo0.setVisibility(O00000Oo().O000000o() ? 0 : 8);
        TextView textView = this.O0000Oo;
        if (O00000Oo().O000000o()) {
            i = 0;
        }
        textView.setVisibility(i);
    }
}
