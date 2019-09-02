package com.qiyukf.unicorn.ui.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.e.f;
import com.qiyukf.unicorn.f.a.d.i;
import com.qiyukf.unicorn.f.a.e.m;
import com.qiyukf.unicorn.h.c;
import com.qiyukf.unicorn.widget.a.d.a;
import java.util.List;

public class e extends a<f> {
    private View b;
    private View c;
    private View d;
    private TextView e;

    private void a(int i) {
        final i iVar = (i) this.message.getAttachment();
        if (i == 3 && iVar.h()) {
            this.e.setVisibility(0);
            this.e.setText(iVar.f());
            this.e.setHint(this.e.length() == 0 ? iVar.b(this.context) : null);
            this.e.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (e.this.a(iVar)) {
                        e.d(e.this);
                    } else {
                        g.a(R.string.ysf_robot_evaluate_disable);
                    }
                }
            });
            return;
        }
        this.e.setVisibility(8);
    }

    private boolean a(i iVar) {
        if (iVar.g() == 0) {
            return false;
        }
        String sessionId = this.message.getSessionId();
        return iVar.g() == d.g().c(sessionId) || iVar.g() == d.g().f(sessionId);
    }

    static /* synthetic */ void d(e eVar) {
        final i iVar = (i) eVar.message.getAttachment();
        new com.qiyukf.unicorn.widget.a.d(eVar.context).a(iVar.f(), iVar.b(eVar.context)).a(new a() {
            public final void a(final String str) {
                if (e.this.a(iVar)) {
                    e.this.e.setText(str);
                    e.this.e.setHint(e.this.e.length() == 0 ? iVar.b(e.this.context) : null);
                    m mVar = new m();
                    mVar.a(e.this.message.getUuid());
                    mVar.b(str);
                    c.a(mVar, e.this.message.getSessionId(), false).setCallback(new RequestCallbackWrapper<Void>() {
                        public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                            if (i == 200) {
                                g.a("感谢您的反馈");
                                iVar.a(str);
                                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(e.this.message, true);
                                return;
                            }
                            g.a(R.string.ysf_network_error);
                        }
                    });
                    return;
                }
                g.a(R.string.ysf_robot_evaluate_disable);
            }
        }).show();
    }

    /* Access modifiers changed, original: protected|final */
    public final String b() {
        i iVar = (i) this.message.getAttachment();
        List d = iVar.d();
        return (!TextUtils.isEmpty(iVar.a()) || d == null || d.size() != 1 || TextUtils.isEmpty(((f) d.get(0)).c)) ? !TextUtils.isEmpty(iVar.a()) ? iVar.a() : null : ((f) d.get(0)).c;
    }

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        super.bindContentView();
        final i iVar = (i) this.message.getAttachment();
        if (iVar.e() <= 0 || !a(iVar)) {
            this.b.setVisibility(8);
            return;
        }
        boolean z = false;
        this.b.setVisibility(0);
        this.c.setSelected(iVar.e() == 2);
        View view = this.d;
        if (iVar.e() == 3) {
            z = true;
        }
        view.setSelected(z);
        a(iVar.e());
        this.c.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!e.this.c.isSelected()) {
                    if (e.this.a(iVar)) {
                        e.a(e.this, 2);
                        return;
                    }
                    g.a(R.string.ysf_robot_evaluate_disable);
                }
            }
        });
        this.d.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!e.this.d.isSelected()) {
                    if (e.this.a(iVar)) {
                        e.a(e.this, 3);
                        return;
                    }
                    g.a(R.string.ysf_robot_evaluate_disable);
                }
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final String c() {
        return ((i) this.message.getAttachment()).c();
    }

    /* Access modifiers changed, original: protected|final */
    public final List<f> d() {
        i iVar = (i) this.message.getAttachment();
        List d = iVar.d();
        return (!TextUtils.isEmpty(iVar.a()) || d == null || d.size() != 1 || TextUtils.isEmpty(((f) d.get(0)).c)) ? d : null;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean e() {
        this.message.getAttachment();
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean f() {
        return ((i) this.message.getAttachment()).b();
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        super.inflateContentView();
        this.b = LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_robot_evaluation, this.a, false);
        this.c = this.b.findViewById(R.id.ysf_robot_evaluate_useful);
        this.d = this.b.findViewById(R.id.ysf_robot_evaluate_useless);
        this.e = (TextView) this.b.findViewById(R.id.ysf_robot_evaluation_content);
        this.a.addView(this.b);
    }
}
