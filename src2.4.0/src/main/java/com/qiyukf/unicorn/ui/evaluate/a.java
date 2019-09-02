package com.qiyukf.unicorn.ui.evaluate;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.c.b;
import com.qiyukf.unicorn.f.a.e.c;
import com.qiyukf.unicorn.widget.a.g;
import com.qiyukf.unicorn.widget.flowlayout.FlowLayout;
import com.qiyukf.unicorn.widget.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends Dialog implements OnCancelListener, OnShowListener, OnClickListener {
    private View a;
    private ImageView b;
    private ScrollView c;
    private LinearLayout d;
    private EditText e;
    private Button f;
    private a g;
    private Context h;
    private c i;
    private b j;
    private String k;
    private int l;
    private Set<Integer>[] m;
    private List<String> n = new ArrayList();
    private OnTouchListener o = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            a.this.e.postDelayed(new Runnable() {
                public final void run() {
                    a.this.c.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                }
            }, 200);
            return false;
        }
    };
    private com.qiyukf.unicorn.widget.flowlayout.a<String> p = new com.qiyukf.unicorn.widget.flowlayout.a<String>(this.n) {
        public final /* synthetic */ View a(FlowLayout flowLayout, int i, Object obj) {
            String str = (String) obj;
            View inflate = LayoutInflater.from(flowLayout.getContext()).inflate(R.layout.ysf_evaluation_tag_item, flowLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.ysf_tag_text);
            textView.setText(str);
            textView.setSelected(a.this.m[a.this.l].contains(Integer.valueOf(i)));
            return inflate;
        }
    };
    private TagFlowLayout.b q = new TagFlowLayout.b() {
        public final boolean a(View view, int i) {
            TextView textView = (TextView) view.findViewById(R.id.ysf_tag_text);
            if (textView.isSelected()) {
                textView.setSelected(false);
                a.this.m[a.this.l].remove(Integer.valueOf(i));
                return true;
            }
            textView.setSelected(true);
            a.this.m[a.this.l].add(Integer.valueOf(i));
            return true;
        }
    };

    public interface a {
        void a(int i, List<String> list, String str);
    }

    public a(Context context, c cVar) {
        super(context, R.style.ysf_popup_dialog_style);
        this.h = context;
        this.i = cVar;
        a();
    }

    public a(Context context, String str) {
        super(context, R.style.ysf_popup_dialog_style);
        this.h = context;
        this.k = str;
        a();
    }

    private void a() {
        if (this.i != null) {
            this.j = this.i.c();
        }
        if (this.j == null || this.j.f() == null) {
            d.g();
            this.j = com.qiyukf.unicorn.h.a.a(this.k);
        }
        this.m = new Set[this.j.f().size()];
        for (int i = 0; i < this.m.length; i++) {
            this.m[i] = new HashSet();
        }
        this.a = LayoutInflater.from(getContext()).inflate(R.layout.ysf_dialog_evaluation, null);
        setContentView(this.a);
        setCancelable(false);
        setOnShowListener(this);
        setOnCancelListener(this);
        this.b = (ImageView) this.a.findViewById(R.id.ysf_evaluation_dialog_close);
        this.c = (ScrollView) this.a.findViewById(R.id.scroll_view);
        this.e = (EditText) this.a.findViewById(R.id.ysf_evaluation_dialog_et_remark);
        this.f = (Button) this.a.findViewById(R.id.ysf_btn_submit);
        this.d = (LinearLayout) this.a.findViewById(R.id.ysf_evaluation_dialog_radio_group);
        TagFlowLayout tagFlowLayout = (TagFlowLayout) this.a.findViewById(R.id.ysf_evaluation_tag_layout);
        this.b.setOnClickListener(this);
        this.e.setOnTouchListener(this.o);
        this.f.setOnClickListener(this);
        tagFlowLayout.a(this.p);
        tagFlowLayout.a(this.q);
        b();
    }

    static /* synthetic */ void a(a aVar, int i) {
        aVar.l = i;
        aVar.f.setEnabled(true);
        int i2 = 0;
        while (i2 < aVar.d.getChildCount()) {
            aVar.d.getChildAt(i2).setSelected(i2 == aVar.l);
            i2++;
        }
        List c = ((com.qiyukf.unicorn.f.a.c.c) aVar.j.f().get(aVar.l)).c();
        aVar.n.clear();
        aVar.n.addAll(c);
        aVar.p.c();
    }

    private void b() {
        Object bVar;
        int c = this.j.c();
        List f = this.j.f();
        ArrayList<b> arrayList = new ArrayList();
        if (c == 2) {
            arrayList.add(new b(((com.qiyukf.unicorn.f.a.c.c) f.get(0)).a(), R.drawable.ysf_evaluation_satisfied));
            bVar = new b(((com.qiyukf.unicorn.f.a.c.c) f.get(1)).a(), R.drawable.ysf_evaluation_dissatisfied);
        } else if (c == 3) {
            arrayList.add(new b(((com.qiyukf.unicorn.f.a.c.c) f.get(0)).a(), R.drawable.ysf_evaluation_satisfied));
            arrayList.add(new b(((com.qiyukf.unicorn.f.a.c.c) f.get(1)).a(), R.drawable.ysf_evaluation_common));
            bVar = new b(((com.qiyukf.unicorn.f.a.c.c) f.get(2)).a(), R.drawable.ysf_evaluation_dissatisfied);
        } else {
            arrayList.add(new b(((com.qiyukf.unicorn.f.a.c.c) f.get(0)).a(), R.drawable.ysf_evaluation_very_satisfied));
            arrayList.add(new b(((com.qiyukf.unicorn.f.a.c.c) f.get(1)).a(), R.drawable.ysf_evaluation_satisfied));
            arrayList.add(new b(((com.qiyukf.unicorn.f.a.c.c) f.get(2)).a(), R.drawable.ysf_evaluation_common));
            arrayList.add(new b(((com.qiyukf.unicorn.f.a.c.c) f.get(3)).a(), R.drawable.ysf_evaluation_dissatisfied));
            bVar = new b(((com.qiyukf.unicorn.f.a.c.c) f.get(4)).a(), R.drawable.ysf_evaluation_very_dissatisfied);
        }
        arrayList.add(bVar);
        for (b bVar2 : arrayList) {
            final EvaluationEntryView evaluationEntryView = new EvaluationEntryView(this.h);
            evaluationEntryView.a(bVar2.a());
            evaluationEntryView.a(bVar2.b());
            final int indexOf = arrayList.indexOf(bVar2);
            evaluationEntryView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    evaluationEntryView.a();
                    a.a(a.this, indexOf);
                }
            });
            this.d.addView(evaluationEntryView, new LayoutParams(0, -2, 1.0f));
        }
    }

    public final void a(a aVar) {
        this.g = aVar;
    }

    public final void a(boolean z) {
        if (this.f != null) {
            this.f.setEnabled(z);
        }
    }

    public final void b(boolean z) {
        if (this.f != null) {
            this.f.setText(z ? R.string.ysf_evaluation_btn_submitting : R.string.ysf_evaluation_btn_submit);
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d.g().c().a(null);
    }

    public final void onClick(View view) {
        com.qiyukf.basesdk.c.d.b.b(getWindow().getDecorView());
        if (view != this.b) {
            if (!(view != this.f || this.g == null || this.l == -1)) {
                com.qiyukf.unicorn.f.a.c.c cVar = (com.qiyukf.unicorn.f.a.c.c) this.j.f().get(this.l);
                int b = cVar.b();
                Set<Integer> set = this.m[this.l];
                ArrayList arrayList = new ArrayList(set.size());
                for (Integer intValue : set) {
                    arrayList.add(cVar.c().get(intValue.intValue()));
                }
                this.g.a(b, arrayList, this.e.getText().toString().trim());
            }
        } else if (this.e.length() == 0) {
            cancel();
        } else {
            this.a.setVisibility(8);
            g.a(this.h, null, this.h.getString(R.string.ysf_evaluation_dialog_message), this.h.getString(R.string.ysf_yes), this.h.getString(R.string.ysf_no), false, new com.qiyukf.unicorn.widget.a.g.a() {
                public final void a(int i) {
                    if (i == 0) {
                        a.this.cancel();
                    } else {
                        a.this.a.setVisibility(0);
                    }
                }
            });
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
    }

    public final void onShow(DialogInterface dialogInterface) {
        d.g().c().a(this);
    }
}
