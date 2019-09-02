package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public final class b {
    private static Pattern a = Pattern.compile("\\[[^\\[\\]]{1,10}\\]");
    private static final List<a> b = new ArrayList();
    private static final Map<String, a> c = new HashMap();
    private static LruCache<String, Bitmap> d = new LruCache<String, Bitmap>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != ((Bitmap) obj3)) {
                bitmap.recycle();
            }
        }
    };

    private static class a {
        String a;
        String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    private static class b extends DefaultHandler {
        private String a;

        private b() {
            this.a = "";
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("Catalog")) {
                this.a = attributes.getValue(str, "Title");
                return;
            }
            if (str2.equals("Emoticon")) {
                str2 = attributes.getValue(str, "Tag");
                str = attributes.getValue(str, "File");
                StringBuilder stringBuilder = new StringBuilder("unicorn_emoji/");
                stringBuilder.append(this.a);
                stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                stringBuilder.append(str);
                a aVar = new a(str2, stringBuilder.toString());
                b.c.put(aVar.a, aVar);
                if (this.a.equals("default")) {
                    b.b.add(aVar);
                }
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0044=Splitter:B:22:0x0044, B:16:0x003a=Splitter:B:16:0x003a} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A:{SYNTHETIC, Splitter:B:25:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A:{SYNTHETIC, Splitter:B:19:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063 A:{SYNTHETIC, Splitter:B:32:0x0063} */
    static {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        b = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        c = r0;
        r0 = com.qiyukf.nim.uikit.b.a();
        r1 = "unicorn_emoji/emoji.xml";
        r2 = new com.qiyukf.nim.uikit.session.emoji.b$b;
        r3 = 0;
        r2.<init>(r3);
        r3 = 0;
        r0 = r0.getAssets();	 Catch:{ IOException -> 0x0043, SAXException -> 0x0039 }
        r0 = r0.open(r1);	 Catch:{ IOException -> 0x0043, SAXException -> 0x0039 }
        r1 = android.util.Xml.Encoding.UTF_8;	 Catch:{ IOException -> 0x0034, SAXException -> 0x0031, all -> 0x002e }
        android.util.Xml.parse(r0, r1, r2);	 Catch:{ IOException -> 0x0034, SAXException -> 0x0031, all -> 0x002e }
        if (r0 == 0) goto L_0x0051;
    L_0x002a:
        r0.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x0051;
    L_0x002e:
        r1 = move-exception;
        r3 = r0;
        goto L_0x0061;
    L_0x0031:
        r1 = move-exception;
        r3 = r0;
        goto L_0x003a;
    L_0x0034:
        r1 = move-exception;
        r3 = r0;
        goto L_0x0044;
    L_0x0037:
        r1 = move-exception;
        goto L_0x0061;
    L_0x0039:
        r1 = move-exception;
    L_0x003a:
        r1.printStackTrace();	 Catch:{ all -> 0x0037 }
        if (r3 == 0) goto L_0x0051;
    L_0x003f:
        r3.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x0051;
    L_0x0043:
        r1 = move-exception;
    L_0x0044:
        r1.printStackTrace();	 Catch:{ all -> 0x0037 }
        if (r3 == 0) goto L_0x0051;
    L_0x0049:
        r3.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x0051;
    L_0x004d:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0051:
        r0 = "\\[[^\\[\\]]{1,10}\\]";
        r0 = java.util.regex.Pattern.compile(r0);
        a = r0;
        r0 = new com.qiyukf.nim.uikit.session.emoji.b$1;
        r0.<init>();
        d = r0;
        return;
    L_0x0061:
        if (r3 == 0) goto L_0x006b;
    L_0x0063:
        r3.close();	 Catch:{ IOException -> 0x0067 }
        goto L_0x006b;
    L_0x0067:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x006b:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.emoji.b.<clinit>():void");
    }

    public static final int a() {
        return b.size();
    }

    public static final Drawable a(Context context, int i) {
        String str = (i < 0 || i >= b.size()) ? null : ((a) b.get(i)).a;
        return str == null ? null : a(context, str);
    }

    public static final Drawable a(Context context, String str) {
        a aVar = (a) c.get(str);
        if (aVar == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) d.get(aVar.b);
        if (bitmap == null) {
            bitmap = b(context, aVar.b);
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static final String a(int i) {
        return (i < 0 || i >= b.size()) ? null : ((a) b.get(i)).a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c A:{SYNTHETIC, Splitter:B:21:0x004c} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A:{SYNTHETIC, Splitter:B:30:0x0059} */
    private static android.graphics.Bitmap b(android.content.Context r4, java.lang.String r5) {
        /*
        r0 = 0;
        r1 = r4.getResources();	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r2.<init>();	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r3 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        r2.inDensity = r3;	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r3 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r3 = r3.densityDpi;	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r2.inScreenDensity = r3;	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r1 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r1 = r1.densityDpi;	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r2.inTargetDensity = r1;	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r4 = r4.getAssets();	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r4 = r4.open(r5);	 Catch:{ Exception -> 0x0045, all -> 0x0043 }
        r1 = new android.graphics.Rect;	 Catch:{ Exception -> 0x0041 }
        r1.<init>();	 Catch:{ Exception -> 0x0041 }
        r1 = android.graphics.BitmapFactory.decodeStream(r4, r1, r2);	 Catch:{ Exception -> 0x0041 }
        if (r1 == 0) goto L_0x0036;
    L_0x0031:
        r2 = d;	 Catch:{ Exception -> 0x0041 }
        r2.put(r5, r1);	 Catch:{ Exception -> 0x0041 }
    L_0x0036:
        if (r4 == 0) goto L_0x0040;
    L_0x0038:
        r4.close();	 Catch:{ IOException -> 0x003c }
        return r1;
    L_0x003c:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0040:
        return r1;
    L_0x0041:
        r5 = move-exception;
        goto L_0x0047;
    L_0x0043:
        r5 = move-exception;
        goto L_0x0057;
    L_0x0045:
        r5 = move-exception;
        r4 = r0;
    L_0x0047:
        r5.printStackTrace();	 Catch:{ all -> 0x0055 }
        if (r4 == 0) goto L_0x0054;
    L_0x004c:
        r4.close();	 Catch:{ IOException -> 0x0050 }
        return r0;
    L_0x0050:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0054:
        return r0;
    L_0x0055:
        r5 = move-exception;
        r0 = r4;
    L_0x0057:
        if (r0 == 0) goto L_0x0061;
    L_0x0059:
        r0.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x0061;
    L_0x005d:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0061:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.emoji.b.b(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static final Pattern b() {
        return a;
    }
}
