package com.qiyukf.nim.uikit.session.module.input.a;

import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.qiyukf.nim.uikit.common.a.f;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.d.d.a;

public class b extends f<a> {
    private TextView a;

    /* Access modifiers changed, original: protected */
    public int getResId() {
        return R.layout.ysf_view_holder_faq_list;
    }

    public void inflate() {
        this.a = (TextView) findView(R.id.ysf_tv_faq_list_item);
    }

    public /* synthetic */ void refresh(Object obj) {
        String str = (String) getAdapter().c();
        String a = ((a) obj).a();
        int color = ContextCompat.getColor(this.context, R.color.ysf_red_f25058);
        SpannableString spannableString = new SpannableString(a);
        int indexOf = TextUtils.isEmpty(str) ? -1 : a.toLowerCase().indexOf(str.toLowerCase());
        if (indexOf >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(color), indexOf, str.length() + indexOf, 33);
        }
        this.a.setText(spannableString);
    }
}
