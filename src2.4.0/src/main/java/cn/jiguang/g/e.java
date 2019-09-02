package cn.jiguang.g;

import android.text.TextUtils;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private static final Pattern e = Pattern.compile("^[A-Za-z][A-Za-z0-9_]*[.]+([A-Za-z][A-Za-z0-9_:.]*)*$");
    private static final Pattern f = Pattern.compile("^zygote[0-9]*$");
    public String a;
    private String b;
    private String c;
    private String d;

    private static int a(LinkedList<String> linkedList, String str, int i) {
        int indexOf = linkedList.indexOf(str);
        int indexOf2 = indexOf == -1 ? linkedList.indexOf(str.toLowerCase(Locale.ENGLISH)) : indexOf;
        return indexOf2 == -1 ? i : indexOf2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:17:0x0075 in {2, 5, 11, 12, 14, 16, 20} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public static cn.jiguang.g.e a(java.lang.String r4, java.util.Map<java.lang.String, java.lang.Integer> r5) {
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
        return r1;
        r0 = "\\s+";
        r4 = r4.split(r0);
        r0 = r4.length;
        r2 = 3;
        if (r0 >= r2) goto L_0x0013;
        return r1;
        r2 = new cn.jiguang.g.e;	 Catch:{ Throwable -> 0x0076 }
        r2.<init>();	 Catch:{ Throwable -> 0x0076 }
        if (r5 == 0) goto L_0x0062;	 Catch:{ Throwable -> 0x0076 }
        r3 = r5.isEmpty();	 Catch:{ Throwable -> 0x0076 }
        if (r3 == 0) goto L_0x0021;	 Catch:{ Throwable -> 0x0076 }
        goto L_0x0062;	 Catch:{ Throwable -> 0x0076 }
        r0 = "USER";	 Catch:{ Throwable -> 0x0076 }
        r0 = r5.get(r0);	 Catch:{ Throwable -> 0x0076 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x0076 }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x0076 }
        r0 = r4[r0];	 Catch:{ Throwable -> 0x0076 }
        r2.b = r0;	 Catch:{ Throwable -> 0x0076 }
        r0 = "PID";	 Catch:{ Throwable -> 0x0076 }
        r0 = r5.get(r0);	 Catch:{ Throwable -> 0x0076 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x0076 }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x0076 }
        r0 = r4[r0];	 Catch:{ Throwable -> 0x0076 }
        r2.c = r0;	 Catch:{ Throwable -> 0x0076 }
        r0 = "PPID";	 Catch:{ Throwable -> 0x0076 }
        r0 = r5.get(r0);	 Catch:{ Throwable -> 0x0076 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x0076 }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x0076 }
        r0 = r4[r0];	 Catch:{ Throwable -> 0x0076 }
        r2.d = r0;	 Catch:{ Throwable -> 0x0076 }
        r0 = "NAME";	 Catch:{ Throwable -> 0x0076 }
        r5 = r5.get(r0);	 Catch:{ Throwable -> 0x0076 }
        r5 = (java.lang.Integer) r5;	 Catch:{ Throwable -> 0x0076 }
        r5 = r5.intValue();	 Catch:{ Throwable -> 0x0076 }
        r4 = r4[r5];	 Catch:{ Throwable -> 0x0076 }
        r2.a = r4;	 Catch:{ Throwable -> 0x0076 }
        return r2;	 Catch:{ Throwable -> 0x0076 }
        r5 = 0;	 Catch:{ Throwable -> 0x0076 }
        r5 = r4[r5];	 Catch:{ Throwable -> 0x0076 }
        r2.b = r5;	 Catch:{ Throwable -> 0x0076 }
        r5 = 1;	 Catch:{ Throwable -> 0x0076 }
        r3 = r4[r5];	 Catch:{ Throwable -> 0x0076 }
        r2.c = r3;	 Catch:{ Throwable -> 0x0076 }
        r3 = 2;	 Catch:{ Throwable -> 0x0076 }
        r3 = r4[r3];	 Catch:{ Throwable -> 0x0076 }
        r2.d = r3;	 Catch:{ Throwable -> 0x0076 }
        r0 = r0 - r5;	 Catch:{ Throwable -> 0x0076 }
        r4 = r4[r0];	 Catch:{ Throwable -> 0x0076 }
        goto L_0x005f;
        return r2;
        r4 = move-exception;
        r5 = "AppStatUtils";
        r0 = new java.lang.StringBuilder;
        r2 = "parse ps printString err, ";
        r0.<init>(r2);
        r4 = r4.getMessage();
        r0.append(r4);
        r4 = r0.toString();
        android.util.Log.w(r5, r4);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.e.a(java.lang.String, java.util.Map):cn.jiguang.g.e");
    }

    public static Map<String, Integer> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, str.split("\\s+"));
        int size = linkedList.size() - 1;
        return (a(linkedList, "USER", 0) == 0 && a(linkedList, "PID", 1) == 1 && a(linkedList, "PPID", 2) == 2 && a(linkedList, "NAME", size) == size) ? null : new HashMap();
    }

    public final JSONObject a(int i) {
        try {
            return new JSONObject().put(Oauth2AccessToken.KEY_UID, this.b).put("pid", this.c).put("ppid", this.d).put("proc_name", i.a(this.a, 128));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean a() {
        return this.d.equals("0") || this.d.equals("1") || this.d.equals("2");
    }

    public final boolean b() {
        return f.matcher(this.a).matches();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ProcessInfo{user='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", pid='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", ppid='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", procName='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
