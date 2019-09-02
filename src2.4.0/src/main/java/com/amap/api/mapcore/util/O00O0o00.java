package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: OfflineMapDataVerify */
public class O00O0o00 extends Thread {
    private Context O000000o;
    private O00Oo O00000Oo;

    public O00O0o00(Context context) {
        this.O000000o = context;
        this.O00000Oo = O00Oo.O000000o(context);
    }

    private O00Oo00 O000000o(File file) {
        String O000000o = OOo000.O000000o(file);
        O00Oo00 o00Oo00 = new O00Oo00();
        o00Oo00.O00000Oo(O000000o);
        return o00Oo00;
    }

    private O00Oo00 O000000o(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        O00O0O0o O000000o = O00O0O0o.O000000o(this.O000000o);
        if (O000000o == null) {
            return null;
        }
        String O00000oo = O000000o.O00000oo(str);
        File[] listFiles = new File(OOo000.O00000o0(this.O000000o)).listFiles();
        if (listFiles == null) {
            return null;
        }
        O00Oo00 o00Oo00 = null;
        for (File file : listFiles) {
            Object obj = ((file.getName().contains(O00000oo) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) ? 1 : null;
            if (obj != null) {
                o00Oo00 = O000000o(file);
                if (!(o00Oo00 == null || o00Oo00.O00000o() == null)) {
                    return o00Oo00;
                }
            }
        }
        return o00Oo00;
    }

    private void O000000o() {
        ArrayList arrayList = new ArrayList();
        ArrayList O000000o = this.O00000Oo.O000000o();
        O000000o(arrayList, "vmap/");
        O000000o(arrayList, "map/");
        O00000Oo(arrayList, "map/");
        ArrayList O00000Oo = O00000Oo();
        Iterator it = O000000o.iterator();
        while (it.hasNext()) {
            O00Oo00 o00Oo00 = (O00Oo00) it.next();
            if (o00Oo00 != null) {
                if (o00Oo00.O00000o() != null) {
                    if (o00Oo00.O0000Ooo == 4 || o00Oo00.O0000Ooo == 7) {
                        boolean contains = arrayList.contains(o00Oo00.O0000Oo0());
                        if (!contains) {
                            String O00000o0 = O00o.O00000o0(o00Oo00.O0000O0o());
                            if (O00000o0 != null) {
                                int indexOf = arrayList.indexOf(O00000o0);
                                if (indexOf != -1) {
                                    arrayList.set(indexOf, o00Oo00.O0000Oo0());
                                    contains = true;
                                }
                            }
                        }
                        if (!contains) {
                            this.O00000Oo.O00000Oo(o00Oo00);
                        }
                    } else {
                        Object obj = null;
                        String O00000o02;
                        int indexOf2;
                        if (o00Oo00.O0000Ooo == 0 || o00Oo00.O0000Ooo == 1) {
                            if (O00000Oo.contains(o00Oo00.O00000oo()) || O00000Oo.contains(o00Oo00.O0000Oo0())) {
                                obj = 1;
                            }
                            if (obj == null) {
                                O00000o02 = O00o.O00000o0(o00Oo00.O0000O0o());
                                if (O00000o02 != null) {
                                    indexOf2 = O00000Oo.indexOf(O00000o02);
                                    if (indexOf2 != -1) {
                                        O00000Oo.set(indexOf2, o00Oo00.O0000Oo0());
                                        obj = 1;
                                    }
                                }
                            }
                            if (obj == null) {
                                this.O00000Oo.O00000Oo(o00Oo00);
                            }
                        } else if (o00Oo00.O0000Ooo == 3 && o00Oo00.O0000OOo() != 0) {
                            if (O00000Oo.contains(o00Oo00.O00000oo()) || O00000Oo.contains(o00Oo00.O0000Oo0())) {
                                obj = 1;
                            }
                            if (obj == null) {
                                O00000o02 = O00o.O00000o0(o00Oo00.O0000O0o());
                                if (O00000o02 != null) {
                                    indexOf2 = O00000Oo.indexOf(O00000o02);
                                    if (indexOf2 != -1) {
                                        O00000Oo.set(indexOf2, o00Oo00.O0000Oo0());
                                        obj = 1;
                                    }
                                }
                            }
                            if (obj == null) {
                                this.O00000Oo.O00000Oo(o00Oo00);
                            }
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (!O000000o(str, O000000o)) {
                O00Oo00 O000000o2 = O000000o(str);
                if (O000000o2 != null) {
                    this.O00000Oo.O000000o(O000000o2);
                }
            }
        }
        O00O0O0o O000000o3 = O00O0O0o.O000000o(this.O000000o);
        if (O000000o3 != null) {
            O000000o3.O000000o(null);
        }
    }

    private void O000000o(ArrayList<String> arrayList, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OOo000.O00000Oo(this.O000000o));
        stringBuilder.append(str);
        File file = new File(stringBuilder.toString());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.getName().endsWith(".dat")) {
                        String name = file2.getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf > -1 && lastIndexOf < name.length()) {
                            name = name.substring(0, lastIndexOf);
                            if (!arrayList.contains(name)) {
                                arrayList.add(name);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean O000000o(String str, ArrayList<O00Oo00> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(((O00Oo00) it.next()).O0000Oo0())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OOo000.O00000o0(this.O000000o));
        File file = new File(stringBuilder.toString());
        if (!file.exists()) {
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".zip")) {
                String name = file2.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > -1 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Missing block: B:35:0x0089, code skipped:
            if (r9 != 0) goto L_0x008d;
     */
    private void O00000Oo(java.util.ArrayList<java.lang.String> r13, java.lang.String r14) {
        /*
        r12 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r12.O000000o;
        r1 = com.amap.api.mapcore.util.OOo000.O000000o(r1);
        r0.append(r1);
        r0.append(r14);
        r14 = new java.io.File;
        r0 = r0.toString();
        r14.<init>(r0);
        r0 = r14.exists();
        if (r0 != 0) goto L_0x0021;
    L_0x0020:
        return;
    L_0x0021:
        r14 = r14.listFiles();
        if (r14 != 0) goto L_0x0028;
    L_0x0027:
        return;
    L_0x0028:
        r0 = 0;
        r1 = r14.length;
        r2 = r0;
    L_0x002b:
        if (r2 >= r1) goto L_0x0095;
    L_0x002d:
        r3 = r14[r2];
        r4 = r3.isDirectory();
        if (r4 == 0) goto L_0x0092;
    L_0x0035:
        r4 = r3.getName();
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 != 0) goto L_0x0092;
    L_0x003f:
        r3 = r3.list();
        if (r3 == 0) goto L_0x0092;
    L_0x0045:
        r5 = 1;
        r6 = r3.length;
        if (r6 >= r5) goto L_0x004a;
    L_0x0049:
        goto L_0x0092;
    L_0x004a:
        r6 = r13.contains(r4);
        if (r6 != 0) goto L_0x0092;
    L_0x0050:
        r6 = "a0";
        r6 = r4.equals(r6);
        if (r6 == 0) goto L_0x006a;
    L_0x0058:
        r6 = r3.length;
        r7 = r0;
    L_0x005a:
        if (r7 >= r6) goto L_0x008c;
    L_0x005c:
        r8 = r3[r7];
        r9 = "m1.ans";
        r8 = r9.equals(r8);
        if (r8 == 0) goto L_0x0067;
    L_0x0066:
        goto L_0x008d;
    L_0x0067:
        r7 = r7 + 1;
        goto L_0x005a;
    L_0x006a:
        r6 = r3.length;
        r7 = r0;
        r8 = r7;
        r9 = r8;
    L_0x006e:
        if (r7 >= r6) goto L_0x0087;
    L_0x0070:
        r10 = r3[r7];
        r11 = "m1.ans";
        r11 = r11.equals(r10);
        if (r11 == 0) goto L_0x007b;
    L_0x007a:
        r8 = r5;
    L_0x007b:
        r11 = "m3.ans";
        r10 = r11.equals(r10);
        if (r10 == 0) goto L_0x0084;
    L_0x0083:
        r9 = r5;
    L_0x0084:
        r7 = r7 + 1;
        goto L_0x006e;
    L_0x0087:
        if (r8 == 0) goto L_0x008c;
    L_0x0089:
        if (r9 == 0) goto L_0x008c;
    L_0x008b:
        goto L_0x008d;
    L_0x008c:
        r5 = r0;
    L_0x008d:
        if (r5 == 0) goto L_0x0092;
    L_0x008f:
        r13.add(r4);
    L_0x0092:
        r2 = r2 + 1;
        goto L_0x002b;
    L_0x0095:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00O0o00.O00000Oo(java.util.ArrayList, java.lang.String):void");
    }

    public void run() {
        try {
            O000000o();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
