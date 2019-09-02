package com.geetest.deepknow.d;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.d.a.a;

/* compiled from: DPOnItemClickListenerProxy */
public class b implements OnItemClickListener {
    private final OnItemClickListener a;
    private final a b;

    public b(OnItemClickListener onItemClickListener, a aVar) {
        this.a = onItemClickListener;
        this.b = aVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        JniLib1557756502.cV(this, adapterView, view, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(55));
    }
}
