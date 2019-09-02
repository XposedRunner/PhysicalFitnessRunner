package com.zjwh.android_wh_physicalfitness.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadingEmptyLayout extends RelativeLayout {
    private static final String O000000o = "ProgressActivity.TAG_LOADING";
    private static final String O00000Oo = "ProgressActivity.TAG_EMPTY";
    private static final String O00000o0 = "ProgressActivity.TAG_ERROR";
    private final String O00000o;
    private final String O00000oO;
    private final String O00000oo;
    private final String O0000O0o;
    private final String O0000OOo;
    private LayoutParams O0000Oo;
    private View O0000Oo0;
    private List<View> O0000OoO;
    private LinearLayout O0000Ooo;
    private ImageView O0000o;
    private TextView O0000o0;
    private LinearLayout O0000o00;
    private TextView O0000o0O;
    private View O0000o0o;
    private TextView O0000oO;
    private TextView O0000oO0;
    private TextView O0000oOO;
    private LayoutInflater O0000oOo;
    private Drawable O0000oo;
    private String O0000oo0;

    public LoadingEmptyLayout(Context context) {
        this(context, null);
    }

    public LoadingEmptyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000o = "type_content";
        this.O00000oO = "type_loading";
        this.O00000oo = "type_empty";
        this.O0000O0o = "type_error";
        this.O0000OOo = "type_empty_button";
        this.O0000OoO = new ArrayList();
        this.O0000oo0 = "type_content";
        O000000o(attributeSet);
    }

    public LoadingEmptyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = "type_content";
        this.O00000oO = "type_loading";
        this.O00000oo = "type_empty";
        this.O0000O0o = "type_error";
        this.O0000OOo = "type_empty_button";
        this.O0000OoO = new ArrayList();
        this.O0000oo0 = "type_content";
        O000000o(attributeSet);
    }

    @TargetApi(21)
    public LoadingEmptyLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.O00000o = "type_content";
        this.O00000oO = "type_loading";
        this.O00000oo = "type_empty";
        this.O0000O0o = "type_error";
        this.O0000OOo = "type_empty_button";
        this.O0000OoO = new ArrayList();
        this.O0000oo0 = "type_content";
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        this.O0000oOo = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    private void O000000o(java.lang.String r5, android.graphics.drawable.Drawable r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, android.view.View.OnClickListener r10, java.util.List<java.lang.Integer> r11) {
        /*
        r4 = this;
        r4.O0000oo0 = r5;
        r0 = r5.hashCode();
        r1 = 1;
        r2 = 0;
        switch(r0) {
            case -1093164024: goto L_0x0034;
            case -1093013309: goto L_0x002a;
            case -598131401: goto L_0x0020;
            case 6514505: goto L_0x0016;
            case 16748660: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x003e;
    L_0x000c:
        r0 = "type_content";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x003e;
    L_0x0014:
        r5 = r2;
        goto L_0x003f;
    L_0x0016:
        r0 = "type_empty_button";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x003e;
    L_0x001e:
        r5 = 3;
        goto L_0x003f;
    L_0x0020:
        r0 = "type_loading";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x003e;
    L_0x0028:
        r5 = r1;
        goto L_0x003f;
    L_0x002a:
        r0 = "type_error";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x003e;
    L_0x0032:
        r5 = 4;
        goto L_0x003f;
    L_0x0034:
        r0 = "type_empty";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x003e;
    L_0x003c:
        r5 = 2;
        goto L_0x003f;
    L_0x003e:
        r5 = -1;
    L_0x003f:
        r0 = 0;
        r3 = 8;
        switch(r5) {
            case 0: goto L_0x0126;
            case 1: goto L_0x0119;
            case 2: goto L_0x00d2;
            case 3: goto L_0x008b;
            case 4: goto L_0x0047;
            default: goto L_0x0045;
        };
    L_0x0045:
        goto L_0x0132;
    L_0x0047:
        r4.O0000OoO();
        r4.O0000Ooo();
        r4.O0000Oo();
        r5 = r4.O0000o;
        r5.setImageDrawable(r6);
        r5 = android.text.TextUtils.isEmpty(r7);
        if (r5 == 0) goto L_0x0061;
    L_0x005b:
        r5 = r4.O0000oO0;
        r5.setVisibility(r3);
        goto L_0x006b;
    L_0x0061:
        r5 = r4.O0000oO0;
        r5.setText(r7);
        r5 = r4.O0000oO0;
        r5.setVisibility(r2);
    L_0x006b:
        r5 = android.text.TextUtils.isEmpty(r8);
        if (r5 == 0) goto L_0x0077;
    L_0x0071:
        r5 = r4.O0000oO;
        r5.setVisibility(r3);
        goto L_0x0081;
    L_0x0077:
        r5 = r4.O0000oO;
        r5.setText(r8);
        r5 = r4.O0000oO;
        r5.setVisibility(r2);
    L_0x0081:
        r5 = r4.O0000oOO;
        r5.setOnClickListener(r10);
        r4.O000000o(r2, r11);
        goto L_0x0132;
    L_0x008b:
        r4.O0000OoO();
        r4.O0000o00();
        r4.O0000Oo0();
        if (r6 == 0) goto L_0x009b;
    L_0x0096:
        r5 = r4.O0000o0;
        r5.setCompoundDrawablesWithIntrinsicBounds(r0, r6, r0, r0);
    L_0x009b:
        r5 = android.text.TextUtils.isEmpty(r8);
        if (r5 == 0) goto L_0x00a7;
    L_0x00a1:
        r5 = r4.O0000o0;
        r5.setVisibility(r3);
        goto L_0x00b1;
    L_0x00a7:
        r5 = r4.O0000o0;
        r5.setText(r8);
        r5 = r4.O0000o0;
        r5.setVisibility(r2);
    L_0x00b1:
        if (r10 == 0) goto L_0x00c9;
    L_0x00b3:
        r5 = r4.O0000o0O;
        r5.setVisibility(r2);
        r5 = android.text.TextUtils.isEmpty(r9);
        if (r5 != 0) goto L_0x00c3;
    L_0x00be:
        r5 = r4.O0000o0O;
        r5.setText(r9);
    L_0x00c3:
        r5 = r4.O0000o0O;
        r5.setOnClickListener(r10);
        goto L_0x00ce;
    L_0x00c9:
        r5 = r4.O0000o0O;
        r5.setVisibility(r3);
    L_0x00ce:
        r4.O000000o(r2, r11);
        goto L_0x0132;
    L_0x00d2:
        r4.O0000OoO();
        r4.O0000o00();
        r4.O0000OOo();
        if (r6 == 0) goto L_0x00e2;
    L_0x00dd:
        r5 = r4.O0000o0;
        r5.setCompoundDrawablesWithIntrinsicBounds(r0, r6, r0, r0);
    L_0x00e2:
        r5 = android.text.TextUtils.isEmpty(r8);
        if (r5 == 0) goto L_0x00ee;
    L_0x00e8:
        r5 = r4.O0000o0;
        r5.setVisibility(r3);
        goto L_0x00f8;
    L_0x00ee:
        r5 = r4.O0000o0;
        r5.setText(r8);
        r5 = r4.O0000o0;
        r5.setVisibility(r2);
    L_0x00f8:
        if (r10 == 0) goto L_0x0110;
    L_0x00fa:
        r5 = r4.O0000o0O;
        r5.setVisibility(r2);
        r5 = android.text.TextUtils.isEmpty(r9);
        if (r5 != 0) goto L_0x010a;
    L_0x0105:
        r5 = r4.O0000o0O;
        r5.setText(r9);
    L_0x010a:
        r5 = r4.O0000o0O;
        r5.setOnClickListener(r10);
        goto L_0x0115;
    L_0x0110:
        r5 = r4.O0000o0O;
        r5.setVisibility(r3);
    L_0x0115:
        r4.O000000o(r2, r11);
        goto L_0x0132;
    L_0x0119:
        r4.O0000Ooo();
        r4.O0000o00();
        r4.O0000O0o();
        r4.O000000o(r2, r11);
        goto L_0x0132;
    L_0x0126:
        r4.O0000OoO();
        r4.O0000Ooo();
        r4.O0000o00();
        r4.O000000o(r1, r11);
    L_0x0132:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout.O000000o(java.lang.String, android.graphics.drawable.Drawable, java.lang.String, java.lang.String, java.lang.String, android.view.View$OnClickListener, java.util.List):void");
    }

    private void O000000o(boolean z, List<Integer> list) {
        for (View view : this.O0000OoO) {
            if (!list.contains(Integer.valueOf(view.getId()))) {
                view.setVisibility(z ? 0 : 8);
            }
        }
    }

    private void O0000O0o() {
        if (this.O0000Ooo == null) {
            this.O0000Oo0 = this.O0000oOo.inflate(R.layout.progress_loading_view, null);
            this.O0000Ooo = (LinearLayout) this.O0000Oo0.findViewById(R.id.loadingStateRelativeLayout);
            this.O0000Ooo.setTag(O000000o);
            this.O0000Oo = new LayoutParams(-1, -1);
            addView(this.O0000Ooo, this.O0000Oo);
            return;
        }
        this.O0000Ooo.setVisibility(0);
    }

    private void O0000OOo() {
        if (this.O0000o00 == null) {
            this.O0000Oo0 = this.O0000oOo.inflate(R.layout.layout_empty_view, null);
            this.O0000o00 = (LinearLayout) this.O0000Oo0.findViewById(R.id.empty_view);
            this.O0000o00.setTag(O00000Oo);
            this.O0000o0 = (TextView) this.O0000Oo0.findViewById(R.id.tv_msg);
            this.O0000o0O = (TextView) this.O0000Oo0.findViewById(R.id.btnOperate);
            this.O0000Oo = new LayoutParams(-1, -1);
            addView(this.O0000o00, this.O0000Oo);
            return;
        }
        this.O0000o00.setVisibility(0);
    }

    private void O0000Oo() {
        if (this.O0000o0o == null) {
            this.O0000Oo0 = this.O0000oOo.inflate(R.layout.tips_loading_failed, null);
            this.O0000o0o = this.O0000Oo0.findViewById(R.id.lin_reload);
            this.O0000o0o.setTag(O00000o0);
            this.O0000o = (ImageView) this.O0000Oo0.findViewById(R.id.errorStateImageView);
            this.O0000oO0 = (TextView) this.O0000Oo0.findViewById(R.id.description);
            this.O0000oO = (TextView) this.O0000Oo0.findViewById(R.id.tv_check_network);
            this.O0000oO.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    try {
                        view.getContext().startActivity(new Intent("android.settings.SETTINGS"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.O0000oOO = (TextView) this.O0000Oo0.findViewById(R.id.retry_btn);
            this.O0000Oo = new LayoutParams(-1, -1);
            addView(this.O0000o0o, this.O0000Oo);
            return;
        }
        this.O0000o0o.setVisibility(0);
    }

    private void O0000Oo0() {
        if (this.O0000o00 == null) {
            this.O0000Oo0 = this.O0000oOo.inflate(R.layout.tips_topic_empty, null);
            this.O0000o00 = (LinearLayout) this.O0000Oo0.findViewById(R.id.empty_view);
            this.O0000o00.setTag(O00000Oo);
            this.O0000o0 = (TextView) this.O0000Oo0.findViewById(R.id.topic_empty_tv);
            this.O0000o0O = (TextView) this.O0000Oo0.findViewById(R.id.btnOperate);
            this.O0000Oo = new LayoutParams(-1, -1);
            addView(this.O0000o00, this.O0000Oo);
            return;
        }
        this.O0000o00.setVisibility(0);
    }

    private void O0000OoO() {
        if (this.O0000Ooo != null) {
            this.O0000Ooo.setVisibility(8);
        }
    }

    private void O0000Ooo() {
        if (this.O0000o00 != null) {
            this.O0000o00.setVisibility(8);
        }
    }

    private void O0000o00() {
        if (this.O0000o0o != null) {
            this.O0000o0o.setVisibility(8);
        }
    }

    public void O000000o() {
        O000000o("type_content", null, null, null, null, null, Collections.emptyList());
    }

    public void O000000o(Drawable drawable, String str, OnClickListener onClickListener) {
        O000000o("type_empty_button", drawable, null, str, null, onClickListener, Collections.emptyList());
    }

    public void O000000o(Drawable drawable, String str, String str2) {
        O000000o("type_empty", drawable, str, str2, null, null, Collections.emptyList());
    }

    public void O000000o(Drawable drawable, String str, String str2, OnClickListener onClickListener) {
        O000000o("type_empty", drawable, null, str2, str, onClickListener, Collections.emptyList());
    }

    public void O000000o(Drawable drawable, String str, String str2, String str3, OnClickListener onClickListener) {
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.no_net_icon);
        }
        O000000o("type_error", drawable, str, str2, str3, onClickListener, Collections.emptyList());
    }

    public void O000000o(Drawable drawable, String str, String str2, String str3, OnClickListener onClickListener, List<Integer> list) {
        O000000o("type_error", drawable, str, str2, str3, onClickListener, list);
    }

    public void O000000o(Drawable drawable, String str, String str2, List<Integer> list) {
        O000000o("type_empty", drawable, str, str2, null, null, list);
    }

    public void O000000o(String str, OnClickListener onClickListener) {
        O000000o(null, str, onClickListener);
    }

    public void O000000o(List<Integer> list) {
        O000000o("type_content", null, null, null, null, null, list);
    }

    public void O00000Oo() {
        O000000o("type_loading", null, null, null, null, null, Collections.emptyList());
    }

    public void O00000Oo(String str, OnClickListener onClickListener) {
        if (this.O0000oo == null) {
            this.O0000oo = ContextCompat.getDrawable(getContext(), R.drawable.no_net_icon);
        }
        O000000o("type_error", this.O0000oo, null, str, "点击重试", onClickListener, Collections.emptyList());
    }

    public void O00000Oo(List<Integer> list) {
        O000000o("type_loading", null, null, null, null, null, list);
    }

    public boolean O00000o() {
        return this.O0000oo0.equals("type_loading");
    }

    public boolean O00000o0() {
        return this.O0000oo0.equals("type_content");
    }

    public boolean O00000oO() {
        return this.O0000oo0.equals("type_empty");
    }

    public boolean O00000oo() {
        return this.O0000oo0.equals("type_error");
    }

    public void addView(@NonNull View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getTag() == null || !(view.getTag().equals(O000000o) || view.getTag().equals(O00000Oo) || view.getTag().equals(O00000o0))) {
            this.O0000OoO.add(view);
        }
    }

    public String getState() {
        return this.O0000oo0;
    }
}
