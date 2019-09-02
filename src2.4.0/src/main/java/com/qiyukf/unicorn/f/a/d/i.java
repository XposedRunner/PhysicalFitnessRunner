package com.qiyukf.unicorn.f.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.e.f;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.c;
import com.qiyukf.unicorn.f.a.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@b(a = 60)
public class i extends e implements c {
    @a(a = "answer_label")
    private String a;
    @a(a = "answer_flag")
    private int b;
    @a(a = "answer_list")
    private String c;
    @a(a = "operator_hint_desc")
    private String d;
    @a(a = "evaluation")
    private int e;
    @a(a = "evaluation_reason")
    private int f;
    @a(a = "evaluation_guide")
    private String g;
    @a(a = "evaluation_content")
    private String h;
    private List<f> i;
    private long j;

    public final String a() {
        return this.a;
    }

    public final String a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(this.a) && this.i != null && this.i.size() == 1) {
            stringBuilder.append(com.qiyukf.unicorn.j.c.a(((f) this.i.get(0)).c));
        } else {
            if (!TextUtils.isEmpty(this.a)) {
                stringBuilder.append(com.qiyukf.unicorn.j.c.a(this.a));
            }
            if (this.i != null) {
                for (f fVar : this.i) {
                    stringBuilder.append("\r\n");
                    stringBuilder.append(fVar.b);
                }
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\r\n");
            }
            stringBuilder.append(b() ? com.qiyukf.unicorn.j.c.a(this.d) : this.d);
        }
        return com.qiyukf.nim.uikit.session.emoji.e.b(context, stringBuilder.toString(), null).toString();
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a(long j) {
        this.j = j;
    }

    public final void a(String str) {
        this.h = str;
    }

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        this.j = com.qiyukf.basesdk.c.b.c(jSONObject, "sessionid");
        JSONArray b = com.qiyukf.basesdk.c.b.b(this.c);
        if (b != null) {
            this.i = new ArrayList(b.length());
            for (int i = 0; i < b.length(); i++) {
                JSONObject b2 = com.qiyukf.basesdk.c.b.b(b, i);
                f fVar = new f();
                fVar.a = com.qiyukf.basesdk.c.b.c(b2, "id");
                fVar.b = com.qiyukf.basesdk.c.b.e(b2, "question");
                fVar.c = com.qiyukf.basesdk.c.b.e(b2, "answer");
                fVar.d = com.qiyukf.basesdk.c.b.b(b2, "answer_flag");
                this.i.add(fVar);
            }
        }
    }

    public final String b(Context context) {
        return TextUtils.isEmpty(this.g) ? context.getString(R.string.ysf_message_robot_evaluation_guide) : this.g;
    }

    public final boolean b() {
        return (this.b & 2) == 2;
    }

    public final String c() {
        return this.d;
    }

    public boolean countToUnread() {
        return true;
    }

    public final List<f> d() {
        return this.i;
    }

    public final int e() {
        return this.e;
    }

    public final String f() {
        return this.h;
    }

    public final long g() {
        return this.j;
    }

    public String getContent(Context context) {
        return a(context).replace("\n", " ");
    }

    public final boolean h() {
        return this.f == 1;
    }

    /* Access modifiers changed, original: protected */
    public JSONObject toJsonObject(boolean z) {
        JSONObject toJsonObject = super.toJsonObject(z);
        if (!z) {
            com.qiyukf.basesdk.c.b.a(toJsonObject, "sessionid", this.j);
        }
        return toJsonObject;
    }
}
