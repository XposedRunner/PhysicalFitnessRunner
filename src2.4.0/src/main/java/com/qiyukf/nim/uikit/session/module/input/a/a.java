package com.qiyukf.nim.uikit.session.module.input.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.qiyukf.nim.uikit.common.a.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.e.g;
import com.qiyukf.unicorn.h.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {
    private ListView a;
    private List<com.qiyukf.unicorn.f.a.d.d.a> b = new ArrayList();
    private d<com.qiyukf.unicorn.f.a.d.d.a> c;
    private String d;
    private String e;
    private String f;
    private Handler g;
    private long h = 0;
    private Runnable i = new Runnable() {
        public final void run() {
            if (!TextUtils.isEmpty(a.this.e) && a.this.e.length() <= 10) {
                a.b(a.this, a.this.e);
                a.this.d = a.this.e;
                a.this.h = System.currentTimeMillis();
            }
        }
    };

    public interface a {
        void a(com.qiyukf.unicorn.f.a.d.d.a aVar);
    }

    static /* synthetic */ void b(a aVar, String str) {
        com.qiyukf.unicorn.f.a.e.d dVar = new com.qiyukf.unicorn.f.a.e.d();
        dVar.a(com.qiyukf.unicorn.d.g().d(aVar.f));
        dVar.a(str);
        c.a(dVar, aVar.f, false);
    }

    private void b(String str) {
        ListView listView;
        int i;
        if (TextUtils.isEmpty(str)) {
            this.b.clear();
        } else {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                com.qiyukf.unicorn.f.a.d.d.a aVar = (com.qiyukf.unicorn.f.a.d.d.a) it.next();
                if (!aVar.a().contains(str) || aVar.a().equals(str)) {
                    it.remove();
                }
            }
        }
        this.c.notifyDataSetChanged();
        if (this.b.size() == 0) {
            listView = this.a;
            i = 8;
        } else {
            listView = this.a;
            i = 0;
        }
        listView.setVisibility(i);
    }

    public final void a(Context context, View view, String str, final a aVar) {
        this.f = str;
        this.a = (ListView) view.findViewById(R.id.ysf_quick_reply_list_view);
        this.c = new d(context, this.b, new com.qiyukf.nim.uikit.common.a.c(b.class));
        this.a.setAdapter(this.c);
        this.a.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (aVar != null) {
                    com.qiyukf.unicorn.f.a.d.d.a aVar = (com.qiyukf.unicorn.f.a.d.d.a) a.this.c.getItem(i);
                    if (aVar != null) {
                        aVar.a(aVar);
                        a.this.d = aVar.a();
                    }
                }
            }
        });
        this.g = com.qiyukf.nimlib.d.a.c.a.b(context);
    }

    public final void a(String str) {
        g k = com.qiyukf.unicorn.d.g().k(this.f);
        if (k == null || !k.a()) {
            if (this.b != null && this.b.size() > 0) {
                this.b.clear();
                this.c.notifyDataSetChanged();
            }
            return;
        }
        if (TextUtils.isEmpty(str) || str.length() > 10) {
            str = "";
        }
        if (!str.equals(this.d) || this.b.size() == 0) {
            this.g.removeCallbacks(this.i);
            long b = (long) (k.b() * 1000.0f);
            this.g.postDelayed(this.i, Math.max(Math.min(b - (System.currentTimeMillis() - this.h), b), 50));
        }
        this.e = str;
        this.c.a(this.e);
        b(this.e);
    }

    public final void a(List<com.qiyukf.unicorn.f.a.d.d.a> list) {
        this.b.clear();
        this.b.addAll(list);
        b(this.e);
    }
}
