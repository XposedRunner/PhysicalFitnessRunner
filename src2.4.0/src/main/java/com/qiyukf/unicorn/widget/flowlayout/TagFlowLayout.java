package com.qiyukf.unicorn.widget.flowlayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.HashSet;
import java.util.Set;

public class TagFlowLayout extends FlowLayout implements a {
    private a d;
    private int e;
    private Set<Integer> f;
    private a g;
    private b h;

    public interface b {
        boolean a(View view, int i);
    }

    public interface a {
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        this.f = new HashSet();
    }

    private static void a(int i, TagView tagView) {
        tagView.setChecked(true);
        tagView.getChildAt(0);
        StringBuilder stringBuilder = new StringBuilder("onSelected ");
        stringBuilder.append(i);
        Log.d("zhy", stringBuilder.toString());
    }

    static /* synthetic */ void a(TagFlowLayout tagFlowLayout, TagView tagView, int i) {
        if (tagView.isChecked()) {
            b(i, tagView);
            tagFlowLayout.f.remove(Integer.valueOf(i));
        } else {
            if (tagFlowLayout.e == 1 && tagFlowLayout.f.size() == 1) {
                Integer num = (Integer) tagFlowLayout.f.iterator().next();
                b(num.intValue(), (TagView) tagFlowLayout.getChildAt(num.intValue()));
                a(i, tagView);
                tagFlowLayout.f.remove(num);
            } else if (tagFlowLayout.e <= 0 || tagFlowLayout.f.size() < tagFlowLayout.e) {
                a(i, tagView);
            } else {
                return;
            }
            tagFlowLayout.f.add(Integer.valueOf(i));
        }
        if (tagFlowLayout.g != null) {
            HashSet hashSet = new HashSet(tagFlowLayout.f);
        }
    }

    private void b() {
        removeAllViews();
        a aVar = this.d;
        HashSet a = this.d.a();
        for (int i = 0; i < aVar.b(); i++) {
            View a2 = aVar.a(this, i, aVar.a(i));
            final TagView tagView = new TagView(getContext());
            a2.setDuplicateParentStateEnabled(true);
            if (a2.getLayoutParams() != null) {
                tagView.setLayoutParams(a2.getLayoutParams());
            } else {
                int i2 = (int) ((5.0f * getResources().getDisplayMetrics().density) + 0.5f);
                MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(i2, i2, i2, i2);
                tagView.setLayoutParams(marginLayoutParams);
            }
            a2.setLayoutParams(new LayoutParams(-1, -1));
            tagView.addView(a2);
            addView(tagView);
            if (a.contains(Integer.valueOf(i))) {
                a(i, tagView);
            }
            aVar.a(i);
            a2.setClickable(false);
            tagView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    TagFlowLayout.a(TagFlowLayout.this, tagView, i);
                    if (TagFlowLayout.this.h != null) {
                        TagFlowLayout.this.h.a(tagView, i);
                    }
                }
            });
        }
        this.f.addAll(a);
    }

    private static void b(int i, TagView tagView) {
        tagView.setChecked(false);
        tagView.getChildAt(0);
        StringBuilder stringBuilder = new StringBuilder("unSelected ");
        stringBuilder.append(i);
        Log.d("zhy", stringBuilder.toString());
    }

    public final void a() {
        this.f.clear();
        b();
    }

    public final void a(b bVar) {
        this.h = bVar;
    }

    public final void a(a aVar) {
        this.d = aVar;
        this.d.a((a) this);
        this.f.clear();
        b();
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8 && tagView.getChildAt(0).getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String parseInt : string.split("\\|")) {
                    int parseInt2 = Integer.parseInt(parseInt);
                    this.f.add(Integer.valueOf(parseInt2));
                    TagView tagView = (TagView) getChildAt(parseInt2);
                    if (tagView != null) {
                        a(parseInt2, tagView);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String str = "";
        if (this.f.size() > 0) {
            for (Integer intValue : this.f) {
                int intValue2 = intValue.intValue();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(intValue2);
                stringBuilder.append("|");
                str = stringBuilder.toString();
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString("key_choose_pos", str);
        return bundle;
    }
}
