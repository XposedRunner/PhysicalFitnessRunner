package com.qiyukf.basesdk.c.b;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import android.widget.TextView;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Stack;
import org.xml.sax.XMLReader;

final class c implements TagHandler {
    private static final BulletSpan e = new BulletSpan(10);
    private Context a;
    private TextPaint b;
    private Stack<String> c = new Stack();
    private Stack<Integer> d = new Stack();

    private static class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static class b {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class c {
        public String a;
        public String b;

        public c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    private static class d {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static class e {
        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    private static class f {
        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    private static class g {
        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    private static class h {
        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }
    }

    private static class i {
        private i() {
        }

        /* synthetic */ i(byte b) {
            this();
        }
    }

    c() {
    }

    private static Object a(Editable editable, Class cls) {
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            return null;
        }
        for (int length = spans.length; length > 0; length--) {
            int i = length - 1;
            if (editable.getSpanFlags(spans[i]) == 17) {
                return spans[i];
            }
        }
        return null;
    }

    static String a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("<div>(<img\\s+[^>]*>)</div>", "$1");
        StringBuilder stringBuilder = new StringBuilder("<html>");
        stringBuilder.append(str);
        stringBuilder.append("</html>");
        return stringBuilder.toString().replace("<ul", "<HTML_TEXT_TAG_UL").replace("</ul>", "</HTML_TEXT_TAG_UL>").replace("<ol", "<HTML_TEXT_TAG_OL").replace("</ol>", "</HTML_TEXT_TAG_OL>").replace("<li", "<HTML_TEXT_TAG_LI").replace("</li>", "</HTML_TEXT_TAG_LI>").replace("<font", "<HTML_TEXT_TAG_FONT").replace("</font>", "</HTML_TEXT_TAG_FONT>").replace("<div", "<HTML_TEXT_TAG_DIV").replace("</div>", "</HTML_TEXT_TAG_DIV>");
    }

    private static HashMap<String, String> a(XMLReader xMLReader) {
        HashMap hashMap = new HashMap();
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(xMLReader);
            declaredField = obj.getClass().getDeclaredField("theAtts");
            declaredField.setAccessible(true);
            obj = declaredField.get(obj);
            declaredField = obj.getClass().getDeclaredField("data");
            declaredField.setAccessible(true);
            String[] strArr = (String[]) declaredField.get(obj);
            Field declaredField2 = obj.getClass().getDeclaredField("length");
            declaredField2.setAccessible(true);
            int intValue = ((Integer) declaredField2.get(obj)).intValue();
            for (int i = 0; i < intValue; i++) {
                int i2 = i * 5;
                hashMap.put(strArr[i2 + 1], strArr[i2 + 4]);
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private static void a(Editable editable) {
        int length = editable.length();
        if ((length <= 0 || editable.charAt(length - 1) != 10) && length != 0) {
            editable.append("\n");
        }
    }

    private static void a(Editable editable, Class cls, boolean z, Object... objArr) {
        Object a = a(editable, cls);
        int spanStart = editable.getSpanStart(a);
        int length = editable.length();
        editable.removeSpan(a);
        if (spanStart != length) {
            if (z) {
                editable.append("\n");
                length++;
            }
            for (Object span : objArr) {
                editable.setSpan(span, spanStart, length, 33);
            }
        }
    }

    private static void a(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    private static int b(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    private int c(String str) {
        try {
            return (Math.min(Math.max(Integer.parseInt(str), 1), 7) - 3) + ((int) ((this.b.getTextSize() / this.a.getResources().getDisplayMetrics().density) + 0.5f));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(TextView textView) {
        this.a = textView.getContext().getApplicationContext();
        this.b = textView.getPaint();
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        int i = 10;
        int length;
        if (z) {
            if (str.equalsIgnoreCase("HTML_TEXT_TAG_UL")) {
                this.c.push(str);
            } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_OL")) {
                this.c.push(str);
                this.d.push(Integer.valueOf(1));
            } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_LI")) {
                if (editable.length() > 0 && editable.charAt(editable.length() - 1) != 10) {
                    editable.append("\n");
                }
                if (!this.c.isEmpty()) {
                    String str2 = (String) this.c.peek();
                    if (str2.equalsIgnoreCase("HTML_TEXT_TAG_OL")) {
                        a(editable, new d());
                        this.d.push(Integer.valueOf(((Integer) this.d.pop()).intValue() + 1));
                        return;
                    }
                    if (str2.equalsIgnoreCase("HTML_TEXT_TAG_UL")) {
                        a(editable, new i());
                    }
                }
            } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_FONT")) {
                length = editable.length();
                HashMap a = a(xMLReader);
                editable.setSpan(new c((String) a.get("color"), (String) a.get("size")), length, length, 17);
            } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_DIV")) {
                a(editable);
            } else if (str.equalsIgnoreCase(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE)) {
                a(editable, new b());
            } else if (str.equalsIgnoreCase("center")) {
                a(editable, new a());
            } else if (str.equalsIgnoreCase("s") || str.equalsIgnoreCase("strike")) {
                a(editable, new e());
            } else if (str.equalsIgnoreCase("tr")) {
                a(editable, new h());
            } else if (str.equalsIgnoreCase("th")) {
                a(editable, new g());
            } else if (str.equalsIgnoreCase("td")) {
                a(editable, new f());
            }
        } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_UL")) {
            this.c.pop();
        } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_OL")) {
            this.c.pop();
            this.d.pop();
        } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_LI")) {
            if (!this.c.isEmpty()) {
                if (((String) this.c.peek()).equalsIgnoreCase("HTML_TEXT_TAG_UL")) {
                    if (editable.length() > 0 && editable.charAt(editable.length() - 1) != 10) {
                        editable.append("\n");
                    }
                    if (this.c.size() > 1) {
                        i = 10 - e.getLeadingMargin(true);
                        if (this.c.size() > 2) {
                            i -= (this.c.size() - 2) * 20;
                        }
                    }
                    BulletSpan bulletSpan = new BulletSpan(i);
                    a(editable, i.class, false, new Standard(20 * (this.c.size() - 1)), bulletSpan);
                } else if (((String) this.c.peek()).equalsIgnoreCase("HTML_TEXT_TAG_OL")) {
                    if (editable.length() > 0 && editable.charAt(editable.length() - 1) != 10) {
                        editable.append("\n");
                    }
                    length = (this.c.size() - 1) * 20;
                    if (this.c.size() > 2) {
                        length -= (this.c.size() - 2) * 20;
                    }
                    com.qiyukf.basesdk.c.b.a.c cVar = new com.qiyukf.basesdk.c.b.a.c(this.b, ((Integer) this.d.lastElement()).intValue() - 1);
                    a(editable, d.class, false, new Standard(length), cVar);
                }
            }
        } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_FONT")) {
            length = editable.length();
            Object a2 = a(editable, c.class);
            int spanStart = editable.getSpanStart(a2);
            editable.removeSpan(a2);
            if (spanStart != length) {
                c cVar2 = (c) a2;
                i = b(cVar2.a);
                int c = c(cVar2.b);
                if (i != -1) {
                    editable.setSpan(new ForegroundColorSpan(i | ViewCompat.MEASURED_STATE_MASK), spanStart, length, 33);
                }
                if (c > 0) {
                    editable.setSpan(new AbsoluteSizeSpan(c, true), spanStart, length, 33);
                }
            }
        } else if (str.equalsIgnoreCase("HTML_TEXT_TAG_DIV")) {
            a(editable);
        } else if (str.equalsIgnoreCase(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE)) {
            a(editable, b.class, false, new TypefaceSpan("monospace"));
        } else if (str.equalsIgnoreCase("center")) {
            a(editable, a.class, true, new AlignmentSpan.Standard(Alignment.ALIGN_CENTER));
        } else if (str.equalsIgnoreCase("s") || str.equalsIgnoreCase("strike")) {
            a(editable, e.class, false, new StrikethroughSpan());
        } else if (str.equalsIgnoreCase("tr")) {
            a(editable, h.class, false, new Object[0]);
        } else if (str.equalsIgnoreCase("th")) {
            a(editable, g.class, false, new Object[0]);
        } else if (str.equalsIgnoreCase("td")) {
            a(editable, f.class, false, new Object[0]);
        }
    }
}
