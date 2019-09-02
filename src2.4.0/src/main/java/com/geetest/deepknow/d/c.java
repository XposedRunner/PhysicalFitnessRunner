package com.geetest.deepknow.d;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.d.a.b;

/* compiled from: DPOnItemSelected */
public class c implements OnItemSelectedListener {
    private final OnItemSelectedListener a;
    private final b b;

    public c(OnItemSelectedListener onItemSelectedListener, b bVar) {
        this.a = onItemSelectedListener;
        this.b = bVar;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        JniLib1557756502.cV(this, adapterView, view, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(56));
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        JniLib1557756502.cV(this, adapterView, Integer.valueOf(57));
    }
}
