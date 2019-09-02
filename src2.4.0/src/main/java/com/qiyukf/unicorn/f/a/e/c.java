package com.qiyukf.unicorn.f.a.e;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@b(a = 51)
public class c extends e {
    @a(a = "evaluation")
    private int a;
    @a(a = "fromType")
    private String b;
    @a(a = "sessionid")
    private long c;
    @a(a = "remarks")
    private String d;
    private com.qiyukf.unicorn.f.a.c.b e;
    private List<String> f;

    public final CharSequence a(Context context) {
        if (!a()) {
            return !TextUtils.isEmpty(this.e.d()) ? this.e.d() : context.getString(R.string.ysf_evaluation_message_item_text);
        } else {
            CharSequence charSequence = null;
            if (com.qiyukf.unicorn.b.a().b() != null) {
                com.qiyukf.unicorn.b.a();
                if (!TextUtils.isEmpty(null)) {
                    com.qiyukf.unicorn.b.a();
                    return null;
                }
            }
            int i = this.a;
            for (com.qiyukf.unicorn.f.a.c.c cVar : this.e.f()) {
                if (i == cVar.b()) {
                    charSequence = cVar.a();
                    break;
                }
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = context.getString(i == 1 ? R.string.ysf_evaluation_dissatisfied : R.string.ysf_evaluation_satisfied);
            }
            CharSequence e = !TextUtils.isEmpty(this.e.e()) ? this.e.e() : context.getString(R.string.ysf_evaluation_result_default_prefix);
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(e).append(" ").append(spannableString).append(" ").append(context.getString(R.string.ysf_evaluation_result_suffix));
            return spannableStringBuilder;
        }
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(long j) {
        this.c = j;
    }

    public final void a(com.qiyukf.unicorn.f.a.c.b bVar) {
        this.e = bVar;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void a(List<String> list) {
        this.f = list;
    }

    public final boolean a() {
        return this.a != -1;
    }

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        jSONObject = com.qiyukf.basesdk.c.b.f(jSONObject, "evaluation_setting");
        if (jSONObject != null) {
            this.e = new com.qiyukf.unicorn.f.a.c.b();
            this.e.a(jSONObject);
            return;
        }
        this.e = com.qiyukf.unicorn.f.a.c.b.a();
    }

    public final long b() {
        return this.c;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final com.qiyukf.unicorn.f.a.c.b c() {
        return this.e;
    }

    public boolean countToUnread() {
        return true;
    }

    public String getContent(Context context) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(a(context).toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: protected */
    public JSONObject toJsonObject(boolean z) {
        JSONObject toJsonObject = super.toJsonObject(z);
        if (z) {
            if (this.f != null) {
                Object jSONArray = new JSONArray();
                for (String put : this.f) {
                    jSONArray.put(put);
                }
                com.qiyukf.basesdk.c.b.a(toJsonObject, "tagList", jSONArray);
            }
            return toJsonObject;
        }
        com.qiyukf.basesdk.c.b.a(toJsonObject, "evaluation_setting", this.e.b());
        return toJsonObject;
    }
}
