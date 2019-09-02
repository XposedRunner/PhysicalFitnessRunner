package com.qiyukf.nim.uikit.session.module.input;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.c.c;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.session.emoji.EmoticonPickerView;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import com.qiyukf.unicorn.b.b;
import com.tencent.stat.DeviceInfo;
import java.util.List;

public final class d {
    private static int a;
    private static final int c = com.qiyukf.basesdk.c.d.d.a(380.0f);
    private static final int d = com.qiyukf.basesdk.c.d.d.a(200.0f);
    private a b;
    private Fragment e;
    private com.qiyukf.nim.uikit.session.emoji.d f;
    private List<BaseAction> g;
    private int h;
    private LinearLayout i;
    private MessageBottomContainer j;
    private EmoticonPickerView k;
    private View l;
    private View m;
    private EditText n;
    private View o;
    private View p;
    private TextView q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;

    interface a {
        void a(boolean z);
    }

    public d(Fragment fragment, LinearLayout linearLayout, com.qiyukf.nim.uikit.session.emoji.d dVar, List<BaseAction> list, int i) {
        this.e = fragment;
        this.f = dVar;
        this.g = list;
        this.h = i;
        this.i = linearLayout;
        this.j = (MessageBottomContainer) linearLayout.findViewById(R.id.nim_message_emoticon_container);
        this.k = (EmoticonPickerView) linearLayout.findViewById(R.id.emoticon_picker_view);
        this.m = linearLayout.findViewById(R.id.textMessageLayout);
        this.n = (EditText) linearLayout.findViewById(R.id.editTextMessage);
        this.o = linearLayout.findViewById(R.id.buttonAudioMessage);
        this.p = linearLayout.findViewById(R.id.buttonTextMessage);
        this.q = (TextView) linearLayout.findViewById(R.id.audioRecord);
    }

    static int a() {
        if (a == 0) {
            a = b.b(d);
        }
        int min = Math.min(c, Math.max(d, a));
        StringBuilder stringBuilder = new StringBuilder("getValidBottomHeight:");
        stringBuilder.append(min);
        com.qiyukf.basesdk.a.a.a(DeviceInfo.TAG_IMEI, stringBuilder.toString());
        return min;
    }

    static boolean a(int i) {
        i = Math.max(Math.min(i, c), d);
        int b = b.b(d);
        if (b != i) {
            a = i;
            b.a(i);
        }
        return b != i;
    }

    public static int b() {
        return a - com.qiyukf.basesdk.c.d.d.a(40.0f);
    }

    private void b(boolean z) {
        if (this.l != null) {
            if (this.t) {
                this.b.a(false);
            }
            this.t = false;
            this.l.setVisibility(8);
            if (z) {
                i();
            }
        }
    }

    private void c(boolean z) {
        if (this.k != null) {
            this.r = false;
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            if (z) {
                i();
            }
        }
    }

    private void d(boolean z) {
        int i = 8;
        this.q.setVisibility(z ? 0 : 8);
        this.n.setVisibility(z ? 8 : 0);
        this.p.setVisibility(z ? 0 : 8);
        View view = this.o;
        if (!z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    private void i() {
        this.s = true;
        com.qiyukf.basesdk.c.d.b.a(this.n);
    }

    private void j() {
        this.s = false;
        com.qiyukf.basesdk.c.d.b.b(this.n);
    }

    private void k() {
        this.t = true;
        this.b.a(true);
        if (this.l == null) {
            View.inflate(this.e.getContext(), R.layout.ysf_message_activity_actions_layout, this.i);
            this.l = this.i.findViewById(R.id.actionsLayout);
            this.l.setBackgroundColor(this.h);
            c.a(this.l, this.g);
        }
        c(false);
        j();
        this.l.setVisibility(0);
    }

    private void l() {
        this.r = true;
        d(false);
        j();
        b(false);
        this.n.requestFocus();
        this.k.setVisibility(0);
        this.j.setVisibility(0);
        this.k.a(this.f);
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    public final void a(boolean z) {
        d(false);
        c(z);
        b(z);
        this.m.setVisibility(0);
        if (z) {
            i();
        }
    }

    public final void c() {
        if (this.k == null || this.k.getVisibility() == 8) {
            l();
        } else {
            c(true);
        }
    }

    public final void d() {
        if (this.r) {
            l();
        } else if (this.t) {
            k();
        } else {
            boolean z = this.s;
            c(z);
            b(z);
        }
    }

    public final void e() {
        j();
        c(false);
        b(false);
    }

    public final void f() {
        j();
        c.a(this.e).a("android.permission.RECORD_AUDIO").a(new com.qiyukf.basesdk.c.c.a() {
            public final void onDenied() {
                g.a(R.string.ysf_no_permission_send_audio);
            }

            public final void onGranted() {
                d.this.c(false);
                d.this.b(false);
                d.this.d(true);
            }
        }).a();
    }

    public final void g() {
        if (this.l == null || this.l.getVisibility() == 8) {
            k();
        } else {
            b(true);
        }
    }

    public final View h() {
        return this.l;
    }
}
