package com.qiyukf.nim.uikit.session.module.input;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.nim.uikit.b;
import com.qiyukf.nim.uikit.session.a;
import com.qiyukf.nim.uikit.session.emoji.EmoticonPickerView;
import com.qiyukf.nim.uikit.session.emoji.d;
import com.qiyukf.nimlib.sdk.media.record.AudioRecorder;
import com.qiyukf.nimlib.sdk.media.record.IAudioRecordCallback;
import com.qiyukf.nimlib.sdk.media.record.RecordType;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import com.qiyukf.unicorn.e.g;
import com.qiyukf.unicorn.f.a.e.q;
import com.qiyukf.unicorn.h.c;
import java.io.File;
import java.util.List;

public final class e implements d, IAudioRecordCallback {
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private List<BaseAction> E;
    private int F = 0;
    private d G;
    private f H;
    private String I = "";
    private a J;
    private Runnable K = new Runnable() {
        public final void run() {
            g j = com.qiyukf.unicorn.d.g().j(e.this.m.c);
            long c = com.qiyukf.unicorn.d.g().c(e.this.m.c);
            long e = (long) com.qiyukf.unicorn.d.g().e(e.this.m.c);
            String obj = e.this.b.getText().toString();
            if (j.a() && c > 0 && e == 0 && !e.this.m.c.equals(b.b()) && !TextUtils.equals(obj, e.this.I)) {
                e.this.I = obj;
                q qVar = new q();
                qVar.a(c);
                qVar.a(e.this.I);
                qVar.b(System.currentTimeMillis());
                qVar.a(j.b());
                c.a(qVar, e.this.m.c, false);
            }
            e.this.o.postDelayed(this, (long) (j.b() * 1000.0f));
        }
    };
    private OnClickListener L = new OnClickListener() {
        public final void onClick(View view) {
            if (view == e.this.e) {
                e.this.G.a(true);
                e.this.h();
            } else if (view == e.this.f) {
                e.this.G.f();
                e.this.h();
            } else if (view == e.this.h) {
                e.g(e.this);
            } else if (view == e.this.g) {
                if (e.this.J == null || !e.this.J.h) {
                    ((BaseAction) e.this.E.get(0)).onClick();
                } else {
                    e.this.G.g();
                }
            } else if (view == e.this.i) {
                e.this.G.c();
            } else {
                if (view == e.this.b) {
                    e.this.G.a(true);
                }
            }
        }
    };
    private com.qiyukf.nim.uikit.session.module.input.a.a.a M = new com.qiyukf.nim.uikit.session.module.input.a.a.a() {
        public final void a(com.qiyukf.unicorn.f.a.d.d.a aVar) {
            e.this.b.setText(aVar.a());
            e.g(e.this);
        }
    };
    protected LinearLayout a;
    protected EditText b;
    protected TextView c;
    protected View d;
    protected View e;
    protected View f;
    protected View g;
    protected View h;
    protected View i;
    protected View j;
    protected EmoticonPickerView k;
    protected AudioRecorder l;
    private com.qiyukf.nim.uikit.session.module.a m;
    private View n;
    private Handler o;
    private com.qiyukf.nim.uikit.session.module.input.a.a p;
    private ViewGroup q;
    private LevelListDrawable r;
    private View s;
    private TextView t;
    private TextView u;
    private View v;
    private View w;
    private ImageView x;
    private ImageView y;
    private long z;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088  */
    public e(com.qiyukf.nim.uikit.session.module.a r3, android.view.View r4, com.qiyukf.nim.uikit.session.a r5) {
        /*
        r2 = this;
        r2.<init>();
        r0 = 0;
        r2.A = r0;
        r2.B = r0;
        r2.C = r0;
        r2.D = r0;
        r2.F = r0;
        r0 = "";
        r2.I = r0;
        r0 = new com.qiyukf.nim.uikit.session.module.input.e$3;
        r0.<init>();
        r2.K = r0;
        r0 = new com.qiyukf.nim.uikit.session.module.input.e$4;
        r0.<init>();
        r2.L = r0;
        r0 = new com.qiyukf.nim.uikit.session.module.input.e$8;
        r0.<init>();
        r2.M = r0;
        r2.m = r3;
        r2.n = r4;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = com.qiyukf.unicorn.d.e();
        r4 = r4.inputPanelOptions;
        if (r4 == 0) goto L_0x0073;
    L_0x0038:
        r0 = r4.showActionPanel;
        if (r0 == 0) goto L_0x0073;
    L_0x003c:
        r0 = r4.actionPanelOptions;
        r0 = r0.actionListProvider;
        if (r0 == 0) goto L_0x005d;
    L_0x0042:
        r0 = r4.actionPanelOptions;
        r0 = r0.actionListProvider;
        r0 = r0.getActionList();
        r0 = r0.size();
        if (r0 != 0) goto L_0x0051;
    L_0x0050:
        goto L_0x005d;
    L_0x0051:
        r4 = r4.actionPanelOptions;
        r4 = r4.actionListProvider;
        r4 = r4.getActionList();
        r3.addAll(r4);
        goto L_0x007b;
    L_0x005d:
        r4 = new com.qiyukf.unicorn.api.customization.action.AlbumAction;
        r0 = com.qiyukf.unicorn.R.drawable.ysf_ic_action_album;
        r1 = com.qiyukf.unicorn.R.string.ysf_picker_image_folder;
        r4.<init>(r0, r1);
        r3.add(r4);
        r4 = new com.qiyukf.unicorn.api.customization.action.CameraAction;
        r0 = com.qiyukf.unicorn.R.drawable.ysf_ic_action_camera;
        r1 = com.qiyukf.unicorn.R.string.ysf_input_panel_take;
        r4.<init>(r0, r1);
        goto L_0x0078;
    L_0x0073:
        r4 = new com.qiyukf.unicorn.api.customization.action.ImageAction;
        r4.<init>();
    L_0x0078:
        r3.add(r4);
    L_0x007b:
        r2.E = r3;
        r3 = new android.os.Handler;
        r3.<init>();
        r2.o = r3;
        r2.J = r5;
        if (r5 == 0) goto L_0x008c;
    L_0x0088:
        r3 = r5.c;
        r2.F = r3;
    L_0x008c:
        r2.f();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.module.input.e.<init>(com.qiyukf.nim.uikit.session.module.a, android.view.View, com.qiyukf.nim.uikit.session.a):void");
    }

    private void a(boolean z, boolean z2) {
        if (z) {
            this.t.setText(R.string.ysf_audio_record_cancel_tip);
            this.t.setBackgroundResource(R.drawable.ysf_audio_cancel_record_red_bg);
            return;
        }
        this.t.setBackgroundResource(0);
        if (z2) {
            this.t.setText(this.m.a.getString(R.string.ysf_audio_record_time_is_up_tips, new Object[]{Integer.valueOf(60)}));
            return;
        }
        this.t.setText(R.string.ysf_audio_record_move_up_to_cancel);
    }

    private void d(boolean z) {
        this.m.a.getWindow().setFlags(0, 128);
        this.l.completeRecord(z);
        this.c.setText(R.string.ysf_audio_record_touch_to_record);
    }

    private void e(boolean z) {
        if (this.A && this.B != z) {
            this.B = z;
            f(z);
        }
    }

    private void f() {
        this.a = (LinearLayout) this.n.findViewById(R.id.messageActivityBottomLayout);
        this.j = this.n.findViewById(R.id.textMessageLayout);
        this.e = this.n.findViewById(R.id.buttonTextMessage);
        this.f = this.n.findViewById(R.id.buttonAudioMessage);
        this.g = this.n.findViewById(R.id.action_list_trigger_button);
        this.i = this.n.findViewById(R.id.emoji_button);
        this.h = this.n.findViewById(R.id.send_message_button);
        this.b = (EditText) this.n.findViewById(R.id.editTextMessage);
        this.c = (TextView) this.n.findViewById(R.id.audioRecord);
        this.d = this.n.findViewById(R.id.ysf_audio_recording_panel);
        this.t = (TextView) this.n.findViewById(R.id.ysf_cancel_recording_text_view);
        this.q = (ViewGroup) this.n.findViewById(R.id.ysf_audio_amplitude_panel);
        this.x = (ImageView) this.n.findViewById(R.id.ysf_amplitude_indicator);
        this.y = (ImageView) this.n.findViewById(R.id.ysf_recording_view_mic);
        this.r = (LevelListDrawable) ((ImageView) this.n.findViewById(R.id.ysf_amplitude_indicator)).getDrawable();
        this.s = this.n.findViewById(R.id.ysf_recording_cancel_indicator);
        this.u = (TextView) this.n.findViewById(R.id.ysf_recording_count_down_label);
        this.w = this.n.findViewById(R.id.ysf_audio_recording_animation_view);
        this.v = this.n.findViewById(R.id.ysf_audio_record_end_tip);
        this.k = (EmoticonPickerView) this.n.findViewById(R.id.emoticon_picker_view);
        this.G = new d(this.m.b, this.a, this, this.E, this.F);
        this.G.a(new a() {
            public final void a(boolean z) {
                e.this.c(z ^ 1);
            }
        });
        this.H = new f(this.m, this.a);
        this.e.setVisibility(8);
        int i = 0;
        this.f.setVisibility(0);
        this.p = new com.qiyukf.nim.uikit.session.module.input.a.a();
        this.p.a(this.m.b.getContext(), this.n, this.m.c, this.M);
        g();
        this.e.setOnClickListener(this.L);
        this.f.setOnClickListener(this.L);
        this.i.setOnClickListener(this.L);
        this.h.setOnClickListener(this.L);
        this.g.setOnClickListener(this.L);
        this.b.setOnClickListener(this.L);
        UICustomization uICustomization = com.qiyukf.unicorn.d.e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.inputTextSize > 0.0f) {
                this.b.setTextSize(uICustomization.inputTextSize);
            }
            if (uICustomization.inputTextColor != 0) {
                this.b.setTextColor(uICustomization.inputTextColor);
            }
        }
        this.b.setInputType(131073);
        this.b.addTextChangedListener(new TextWatcher() {
            private int b;
            private int c;

            public final void afterTextChanged(Editable editable) {
                e.this.h();
                com.qiyukf.nim.uikit.session.emoji.e.a(e.this.m.a, editable, this.b, this.c);
                e.this.p.a(editable.toString());
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.b = i;
                this.c = i3;
            }
        });
        String e = com.qiyukf.unicorn.b.b.e(this.m.c);
        if (!TextUtils.isEmpty(e)) {
            this.b.setText(e);
            this.b.setSelection(e.length());
            com.qiyukf.unicorn.b.b.b(this.m.c, null);
        }
        if (uICustomization == null || !uICustomization.hideKeyboardOnEnterConsult) {
            this.G.a(true);
        } else {
            this.G.a(false);
        }
        this.c.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    e.this.C = true;
                    e.j(e.this);
                    e.k(e.this);
                    return true;
                }
                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    e.this.C = false;
                    e.this.d(e.a(view, motionEvent));
                } else if (motionEvent.getAction() == 2) {
                    e.this.C = false;
                    e.this.e(e.a(view, motionEvent));
                    return true;
                }
                return true;
            }
        });
        h();
        this.b.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return (keyEvent.getAction() == 1 && i == 4) ? e.this.c() : false;
            }
        });
        if (this.J != null) {
            View view;
            int i2;
            this.f.setBackgroundResource(this.J.d != 0 ? this.J.d : R.drawable.ysf_message_button_bottom_audio_selector);
            this.i.setBackgroundResource(this.J.e != 0 ? this.J.e : R.drawable.ysf_message_button_bottom_emoji_selector);
            if (this.J.h) {
                view = this.g;
                i2 = this.J.g != 0 ? this.J.g : R.drawable.ysf_ic_actionpanel_start;
            } else {
                view = this.g;
                i2 = this.J.f != 0 ? this.J.f : R.drawable.ysf_message_button_bottom_add_selector;
            }
            view.setBackgroundResource(i2);
        }
        while (i < this.E.size()) {
            ((BaseAction) this.E.get(i)).setIndex(i);
            ((BaseAction) this.E.get(i)).setContainer(this.m);
            i++;
        }
    }

    private void f(boolean z) {
        boolean z2 = false;
        if (z) {
            this.c.setText(R.string.ysf_audio_record_touch_to_record);
            this.w.setVisibility(4);
            this.s.setVisibility(0);
        } else {
            this.c.setText(R.string.ysf_audio_record_up_to_complete);
            this.s.setVisibility(4);
            this.w.setVisibility(0);
            if (System.currentTimeMillis() - this.z > 50000) {
                this.q.setVisibility(4);
                this.u.setVisibility(0);
            } else {
                this.q.setVisibility(0);
                this.u.setVisibility(4);
            }
        }
        if (System.currentTimeMillis() - this.z >= 59000) {
            z2 = true;
        }
        a(z, z2);
    }

    private void g() {
        UICustomization uICustomization = com.qiyukf.unicorn.d.e().uiCustomization;
        View findViewById = this.n.findViewById(R.id.switchLayout);
        int i = 0;
        int i2 = (uICustomization == null || !uICustomization.hideAudio) ? 0 : 8;
        findViewById.setVisibility(i2);
        findViewById = this.i;
        int i3 = (uICustomization == null || !uICustomization.hideEmoji) ? 0 : 8;
        findViewById.setVisibility(i3);
        i3 = com.qiyukf.basesdk.c.c.d.a(this.b.getText()) ^ 1;
        this.g.setVisibility(i3 != 0 ? 8 : 0);
        findViewById = this.h;
        if (i3 == 0) {
            i = 8;
        }
        findViewById.setVisibility(i);
        this.h.setEnabled(i3);
    }

    static /* synthetic */ void g(e eVar) {
        if (eVar.m.e.sendMessage(MessageBuilder.createTextMessage(eVar.m.c, eVar.m.d, eVar.b.getText().toString().trim()), false)) {
            eVar.b.setText("");
        }
    }

    private void h() {
        int i = 1;
        int i2 = 0;
        int i3 = this.c.getVisibility() == 0 ? 1 : 0;
        int a = com.qiyukf.basesdk.c.c.d.a(this.b.getText()) ^ 1;
        int i4 = (i3 != 0 || (a == 0 && !this.D)) ? 0 : 1;
        if (this.D || (i3 == 0 && a != 0)) {
            i = 0;
        }
        this.h.setEnabled(a);
        this.h.setVisibility(i4 != 0 ? 0 : 8);
        View view = this.g;
        if (i == 0) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    private void i() {
        this.d.setVisibility(8);
    }

    static /* synthetic */ void j(e eVar) {
        if (eVar.l == null) {
            eVar.l = new AudioRecorder(eVar.m.a, RecordType.AMR, 60, eVar);
        }
    }

    static /* synthetic */ void k(e eVar) {
        eVar.m.a.getWindow().setFlags(128, 128);
        eVar.A = eVar.l.startRecord();
        eVar.B = false;
        if (eVar.A && eVar.C) {
            eVar.c.setText(R.string.ysf_audio_record_up_to_complete);
            eVar.f(false);
            eVar.d.setVisibility(0);
        }
    }

    public final void a() {
        this.o.post(this.K);
    }

    public final void a(int i) {
        this.F = i;
    }

    public final void a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            int i3 = (i << 16) >> 24;
            if (i3 != 0) {
                i3--;
                if (i3 < 0 || i3 >= this.E.size()) {
                    com.qiyukf.basesdk.a.a.d("MsgSendLayout", "request code out of actions' range");
                } else {
                    BaseAction baseAction = (BaseAction) this.E.get(i3);
                    if (baseAction != null) {
                        baseAction.onActivityResult(i & 255, i2, intent);
                    }
                }
            }
        }
    }

    public final void a(com.qiyukf.nim.uikit.session.module.a aVar) {
        this.m = aVar;
    }

    public final void a(com.qiyukf.unicorn.f.a.d.d dVar) {
        if (dVar.a() == com.qiyukf.unicorn.d.g().d(this.m.c)) {
            this.p.a(dVar.b());
        }
    }

    public final void a(String str) {
        Editable text = this.b.getText();
        int i = 0;
        if (str.equals("/DEL")) {
            this.b.dispatchKeyEvent(new KeyEvent(0, 67));
            return;
        }
        int selectionStart = this.b.getSelectionStart();
        int selectionEnd = this.b.getSelectionEnd();
        if (selectionStart < 0) {
            selectionStart = 0;
        }
        if (selectionEnd >= 0) {
            i = selectionEnd;
        }
        if (selectionStart <= i) {
            text.replace(selectionStart, i, str);
        } else {
            text.replace(i, selectionStart, str);
        }
        this.b.setSelection(Math.min(selectionStart, i) + str.length());
    }

    public final void a(List<? extends com.qiyukf.unicorn.e.c> list) {
        this.H.a((List) list);
    }

    public final void a(boolean z) {
        this.D = z;
        e(true);
        i();
        this.G.a(false);
        if (z) {
            UICustomization uICustomization = com.qiyukf.unicorn.d.e().uiCustomization;
            View findViewById = this.n.findViewById(R.id.switchLayout);
            int i = (uICustomization == null || !uICustomization.hideAudioWithRobot) ? 0 : 8;
            findViewById.setVisibility(i);
            this.i.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            return;
        }
        g();
    }

    public final void b() {
        if (this.l != null) {
            d(true);
        }
        com.qiyukf.unicorn.b.b.b(this.m.c, this.b.getText().toString());
        this.o.removeCallbacks(this.K);
    }

    public final void b(boolean z) {
        CharSequence charSequence = null;
        if (z) {
            e(true);
            i();
            this.G.a(false);
            this.b.setText(null);
            this.G.e();
        }
        EditText editText = this.b;
        if (z) {
            charSequence = this.b.getContext().getString(R.string.ysf_no_staff_disabled);
        }
        editText.setHint(charSequence);
        this.b.setEnabled(z ^ 1);
        this.f.setEnabled(z ^ 1);
        this.i.setEnabled(z ^ 1);
        this.g.setEnabled(z ^ 1);
    }

    @TargetApi(11)
    public final void c(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "rotation", new float[]{0.0f, 45.0f});
        ofFloat.setDuration(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.g, "rotation", new float[]{45.0f, 0.0f});
        ofFloat.setDuration(300);
        if (this.J != null && this.J.h) {
            if (z) {
                ofFloat2.start();
            } else {
                ofFloat.start();
            }
        }
    }

    public final boolean c() {
        View h = this.G.h();
        boolean z = (this.k != null && this.k.getVisibility() == 0) || (h != null && h.getVisibility() == 0);
        this.G.e();
        return z;
    }

    public final boolean d() {
        return this.l != null && this.l.isRecording();
    }

    public final void e() {
        if (this.G != null) {
            this.G.d();
        }
    }

    public final void onRecordCancel() {
        i();
    }

    public final void onRecordFail() {
        this.x.setVisibility(8);
        this.y.setImageResource(R.drawable.ysf_recording_alert);
        this.t.setText(R.string.ysf_audio_record_alert);
        this.t.setPadding(com.qiyukf.basesdk.c.d.d.a(25.0f), com.qiyukf.basesdk.c.d.d.a(5.0f), com.qiyukf.basesdk.c.d.d.a(25.0f), com.qiyukf.basesdk.c.d.d.a(5.0f));
        this.o.postDelayed(new Runnable() {
            public final void run() {
                e.this.x.setVisibility(0);
                e.this.y.setImageResource(R.drawable.ysf_recording_mic);
                e.this.t.setText(R.string.ysf_audio_record_cancel_tip);
                e.this.t.setPadding(com.qiyukf.basesdk.c.d.d.a(5.0f), com.qiyukf.basesdk.c.d.d.a(5.0f), com.qiyukf.basesdk.c.d.d.a(5.0f), com.qiyukf.basesdk.c.d.d.a(5.0f));
                e.this.i();
            }
        }, 1000);
    }

    public final void onRecordReachedMaxTime(int i) {
        i();
        this.l.handleEndRecord(true, i);
    }

    public final void onRecordReady() {
    }

    public final void onRecordStart(File file, RecordType recordType) {
        this.z = System.currentTimeMillis();
    }

    public final void onRecordSuccess(File file, long j, RecordType recordType) {
        i();
        this.m.e.sendMessage(MessageBuilder.createAudioMessage(this.m.c, this.m.d, file, j, this.D), false);
    }

    public final void onUpdateAmplitude(int i) {
        boolean z = false;
        this.r.setLevel(Math.max(0, Math.min(5, (int) (((float) ((int) (20.0d * Math.log10((double) (i / 100))))) / 7.3733335f))));
        long currentTimeMillis = 60 - ((System.currentTimeMillis() - this.z) / 1000);
        if (currentTimeMillis >= 11) {
            this.q.setVisibility(0);
            this.u.setVisibility(4);
            this.v.setVisibility(4);
        } else if (currentTimeMillis > 1) {
            this.q.setVisibility(4);
            this.u.setVisibility(0);
            this.v.setVisibility(4);
            this.u.setText(String.valueOf(currentTimeMillis - 1));
        } else {
            this.q.setVisibility(4);
            this.u.setVisibility(4);
            this.v.setVisibility(0);
            if (this.s.getVisibility() == 0) {
                z = true;
            }
            a(z, true);
        }
    }
}
