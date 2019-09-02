package com.qiyukf.nim.uikit.session.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.session.module.a;
import com.qiyukf.nim.uikit.session.module.b;
import com.qiyukf.nim.uikit.session.module.input.e;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.e.o;
import com.qiyukf.unicorn.h.c;
import java.util.List;
import s.h.e.l.l.C;

public class MessageFragment extends TFragment implements b {
    protected View a;
    protected TextView b;
    protected e c;
    protected com.qiyukf.nim.uikit.session.module.a.b d;
    protected a e;
    protected String f;
    protected SessionTypeEnum g;
    protected SensorEventListener h;
    private View i;
    private com.qiyukf.nim.uikit.session.a j;
    private SensorManager k;
    private Sensor l;
    private d.a m = new d.a() {
        public final void a() {
            MessageFragment.this.a(true);
            MessageFragment.b(MessageFragment.this);
            if (MessageFragment.this.isResumed()) {
                ((MsgService) NIMClient.getService(MsgService.class)).setChattingAccount(MessageFragment.this.f, MessageFragment.this.g);
            }
        }
    };
    private com.qiyukf.nim.uikit.common.media.a.a.a n = new com.qiyukf.nim.uikit.common.media.a.a.a() {
        public final void a(com.qiyukf.nim.uikit.common.media.a.b bVar) {
            MessageFragment.this.getActivity().getWindow().setFlags(128, 128);
            MessageFragment.this.getActivity();
            if (com.qiyukf.nim.uikit.session.b.b.i().b() == 0) {
                MessageFragment.this.d.b(R.string.ysf_audio_is_playing_by_earphone);
            }
        }

        public final void b(com.qiyukf.nim.uikit.common.media.a.b bVar) {
            MessageFragment.this.getActivity().getWindow().setFlags(0, 128);
            MessageFragment.d(MessageFragment.this);
        }
    };
    private Observer<List<IMMessage>> o = new Observer<List<IMMessage>>() {
        public final /* synthetic */ void onEvent(Object obj) {
            List list = (List) obj;
            if (list != null && !list.isEmpty()) {
                MessageFragment.this.d.a(list);
                MessageFragment.this.onReceiveMessage(list);
            }
        }
    };

    static {
        C.i(27);
    }

    private void a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeReceiveMessage(this.o, z);
        c.a(z ? this : null);
    }

    private void b() {
        if (this.l != null && this.k != null && this.h != null) {
            this.k.unregisterListener(this.h);
        }
    }

    static /* synthetic */ void b(MessageFragment messageFragment) {
        if (messageFragment.d == null) {
            messageFragment.d = new com.qiyukf.nim.uikit.session.module.a.b(messageFragment.e, messageFragment.a);
        } else {
            messageFragment.d.a(messageFragment.e);
        }
        if (messageFragment.c == null) {
            messageFragment.c = new e(messageFragment.e, messageFragment.a, messageFragment.j);
        } else {
            messageFragment.c.a(messageFragment.e);
        }
        if (messageFragment.j != null) {
            messageFragment.c.a(messageFragment.j.c);
            messageFragment.d.a(messageFragment.j.a, messageFragment.j.b);
            return;
        }
        messageFragment.d.a(null, 0);
        messageFragment.c.a(0);
    }

    static /* synthetic */ void c(MessageFragment messageFragment) {
        if (messageFragment.getActivity() != null) {
            messageFragment.getActivity().getWindow().setFlags(32768, 32768);
            messageFragment.getActivity().getWindow().setFlags(1024, 1024);
            if (messageFragment.i == null) {
                View.inflate(messageFragment.getActivity(), R.layout.ysf_screen_lock_layout, (ViewGroup) messageFragment.getActivity().getWindow().getDecorView());
                messageFragment.i = messageFragment.getActivity().findViewById(R.id.screen_lock_layout);
            }
            messageFragment.i.setVisibility(0);
            if (!com.qiyukf.unicorn.b.b.i()) {
                messageFragment.getActivity();
                if (com.qiyukf.nim.uikit.session.b.b.i().f()) {
                    messageFragment.getActivity().setVolumeControlStream(0);
                }
            }
        }
    }

    static /* synthetic */ void d(MessageFragment messageFragment) {
        if (messageFragment.getActivity() != null && messageFragment.i != null && messageFragment.i.getVisibility() != 8) {
            boolean g = messageFragment.d.g();
            messageFragment.getActivity().getWindow().setFlags(0, 32768);
            messageFragment.getActivity().getWindow().clearFlags(1024);
            if (VERSION.SDK_INT >= 14) {
                messageFragment.getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (messageFragment.i != null) {
                messageFragment.i.setVisibility(8);
            }
            if (g) {
                messageFragment.d.h();
            }
            if (!com.qiyukf.unicorn.b.b.i()) {
                messageFragment.getActivity();
                if (com.qiyukf.nim.uikit.session.b.b.i().g()) {
                    messageFragment.getActivity().setVolumeControlStream(3);
                    messageFragment.d.b(R.string.ysf_audio_switch_to_speaker);
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        this.d.a(this.e);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str) {
        this.f = str;
        this.e.c = str;
        ((MsgService) NIMClient.getService(MsgService.class)).setChattingAccount(str, this.g);
    }

    public native boolean isAllowSendMessage(boolean z);

    public native boolean isLongClickEnabled();

    public native void onActivityCreated(Bundle bundle);

    public native void onActivityResult(int i, int i2, Intent intent);

    public native void onConfigurationChanged(Configuration configuration);

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public native void onPause();

    /* Access modifiers changed, original: protected */
    public void onReceiveMessage(List<IMMessage> list) {
    }

    public void onResume() {
        FragmentActivity activity;
        super.onResume();
        if (this.d != null) {
            this.d.d();
        }
        if (this.c != null) {
            this.c.a();
        }
        if (this.d != null) {
            this.d.f();
        }
        getActivity();
        com.qiyukf.nim.uikit.session.b.b.i().a(this.n);
        if (this.k == null) {
            this.k = (SensorManager) getActivity().getSystemService("sensor");
            this.l = this.k.getDefaultSensor(8);
            this.h = new SensorEventListener() {
                public final void onAccuracyChanged(Sensor sensor, int i) {
                }

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent.sensor.getType() == 8) {
                        float f = sensorEvent.values[0];
                        if (f >= 5.0f || f >= sensorEvent.sensor.getMaximumRange()) {
                            MessageFragment.d(MessageFragment.this);
                        } else {
                            MessageFragment.this.getActivity();
                            if (com.qiyukf.nim.uikit.session.b.b.i().d()) {
                                MessageFragment.c(MessageFragment.this);
                            }
                        }
                    }
                }
            };
        }
        int i = 3;
        if (!(this.l == null || this.k == null || this.h == null)) {
            this.k.registerListener(this.h, this.l, 3);
        }
        if (com.qiyukf.unicorn.b.b.i()) {
            activity = getActivity();
            i = 0;
        } else {
            activity = getActivity();
        }
        activity.setVolumeControlStream(i);
        if (d.b()) {
            ((MsgService) NIMClient.getService(MsgService.class)).setChattingAccount(this.f, this.g);
            if (d.g().l(this.e.c) != null && "1".equals(d.g().l(this.e.c).a()) && d.g().e(this.f) == 0) {
                o oVar = new o();
                oVar.a(String.valueOf(d.g().c(this.f)));
                c.a(oVar, this.f, true);
            }
        }
    }

    public native boolean sendMessage(IMMessage iMMessage, boolean z);

    public native void shouldCollapseInputPanel();
}
