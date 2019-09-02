package com.qiyukf.nim.uikit.session.helper;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.c.c;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.session.activity.PickImageActivity;
import com.qiyukf.unicorn.R;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public final class d implements Serializable {

    public interface a {
        void sendImage(File file, String str, boolean z);
    }

    private static class b extends AsyncTask<Void, Void, File> {
        private boolean a;
        private PhotoInfo b;
        private a c;

        public b(boolean z, PhotoInfo photoInfo, a aVar) {
            this.a = z;
            this.b = photoInfo;
            this.c = aVar;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            String absolutePath = this.b.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                return null;
            }
            if (this.a) {
                String b = c.b(absolutePath);
                String a = com.qiyukf.basesdk.c.a.b.a(absolutePath);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b);
                stringBuilder.append(".");
                stringBuilder.append(a);
                b = com.qiyukf.nimlib.k.c.c.a(stringBuilder.toString(), com.qiyukf.nimlib.k.c.b.TYPE_IMAGE);
                com.qiyukf.basesdk.c.a.a.a(absolutePath, b);
                com.qiyukf.nimlib.k.b.b.a(new File(b));
                return new File(b);
            }
            File a2 = com.qiyukf.nimlib.k.b.b.a(new File(absolutePath), com.qiyukf.basesdk.c.a.b.a(absolutePath));
            if (a2 == null) {
                return null;
            }
            com.qiyukf.nimlib.k.b.b.a(a2);
            return a2;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            File file = (File) obj;
            if (file == null) {
                g.b(R.string.ysf_picker_image_error);
            } else if (this.c != null) {
                this.c.sendImage(file, com.qiyukf.basesdk.c.a.b.b(this.b.getAbsolutePath()), this.a);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static void a(Fragment fragment, Intent intent, int i, int i2, a aVar) {
        if (intent.getBooleanExtra("RESULT_SEND", false)) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("scaled_image_list");
            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("orig_image_list");
            boolean booleanExtra = intent.getBooleanExtra("is_original", false);
            for (i2 = 0; i2 < stringArrayListExtra.size(); i2++) {
                String str = (String) stringArrayListExtra.get(i2);
                File file = new File(str);
                String str2 = (String) stringArrayListExtra2.get(i2);
                if (booleanExtra) {
                    File file2;
                    String b = c.b(str2);
                    String a = com.qiyukf.basesdk.c.a.b.a(str2);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(b);
                    stringBuilder.append(".");
                    stringBuilder.append(a);
                    String a2 = com.qiyukf.nimlib.k.c.c.a(stringBuilder.toString(), com.qiyukf.nimlib.k.c.b.TYPE_IMAGE);
                    com.qiyukf.basesdk.c.a.a.a(str2, a2);
                    str = com.qiyukf.nimlib.k.c.c.b(com.qiyukf.basesdk.c.a.b.b(str), com.qiyukf.nimlib.k.c.b.TYPE_THUMB_IMAGE);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(b);
                    stringBuilder2.append(".");
                    stringBuilder2.append(a);
                    b = com.qiyukf.nimlib.k.c.c.a(stringBuilder2.toString(), com.qiyukf.nimlib.k.c.b.TYPE_THUMB_IMAGE);
                    if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(b))) {
                        File file3 = new File(str);
                        if (file3.exists() && file3.isFile()) {
                            file2 = new File(b);
                            if (file2.getParentFile() != null) {
                                if (!file2.getParentFile().exists()) {
                                    file2.getParentFile().mkdirs();
                                }
                                file3.renameTo(file2);
                            }
                        }
                    }
                    if (aVar != null) {
                        file2 = new File(a2);
                        aVar.sendImage(file2, file2.getName(), true);
                    }
                } else if (aVar != null) {
                    aVar.sendImage(file, file.getName(), false);
                }
            }
            return;
        }
        if (intent.getBooleanExtra("RESULT_RETAKE", false)) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(com.qiyukf.basesdk.c.c.d.b());
            stringBuilder3.append(".jpg");
            String a3 = com.qiyukf.nimlib.k.c.c.a(stringBuilder3.toString(), com.qiyukf.nimlib.k.c.b.TYPE_TEMP);
            if (i == 6) {
                PickImageActivity.start(fragment, i2, 2, a3);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088 A:{RETURN} */
    public static void a(android.support.v4.app.Fragment r5, android.content.Intent r6, int r7, com.qiyukf.nim.uikit.session.helper.d.a r8) {
        /*
        if (r6 != 0) goto L_0x0008;
    L_0x0002:
        r5 = com.qiyukf.unicorn.R.string.ysf_picker_image_error;
        com.qiyukf.basesdk.c.d.g.b(r5);
        return;
    L_0x0008:
        r0 = "from_local";
        r1 = 0;
        r0 = r6.getBooleanExtra(r0, r1);
        if (r0 == 0) goto L_0x003f;
    L_0x0011:
        r5 = "is_original";
        r5 = r6.getBooleanExtra(r5, r1);
        r6 = com.qiyukf.nim.uikit.common.media.picker.model.b.a(r6);
        if (r6 != 0) goto L_0x0023;
    L_0x001d:
        r5 = com.qiyukf.unicorn.R.string.ysf_picker_image_error;
        com.qiyukf.basesdk.c.d.g.b(r5);
        return;
    L_0x0023:
        r6 = r6.iterator();
    L_0x0027:
        r7 = r6.hasNext();
        if (r7 == 0) goto L_0x003e;
    L_0x002d:
        r7 = r6.next();
        r7 = (com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo) r7;
        r0 = new com.qiyukf.nim.uikit.session.helper.d$b;
        r0.<init>(r5, r7, r8);
        r7 = new java.lang.Void[r1];
        com.qiyukf.basesdk.c.d.e.a(r0, r7);
        goto L_0x0027;
    L_0x003e:
        return;
    L_0x003f:
        r8 = new android.content.Intent;
        r8.<init>();
        r0 = "file_path";
        r0 = r6.getStringExtra(r0);
        r2 = android.text.TextUtils.isEmpty(r0);
        r3 = 1;
        if (r2 == 0) goto L_0x0057;
    L_0x0051:
        r6 = com.qiyukf.unicorn.R.string.ysf_picker_image_error;
        com.qiyukf.basesdk.c.d.g.b(r6);
        goto L_0x0086;
    L_0x0057:
        r2 = new java.io.File;
        r2.<init>(r0);
        r4 = "orig_image_file_path";
        r8.putExtra(r4, r0);
        r4 = "image/jpeg";
        r2 = com.qiyukf.nimlib.k.b.b.a(r2, r4);
        r6 = r6.getExtras();
        r4 = "from_local";
        r6 = r6.getBoolean(r4, r3);
        if (r6 != 0) goto L_0x0076;
    L_0x0073:
        com.qiyukf.basesdk.c.a.a.b(r0);
    L_0x0076:
        if (r2 != 0) goto L_0x0079;
    L_0x0078:
        goto L_0x0051;
    L_0x0079:
        com.qiyukf.nimlib.k.b.b.a(r2);
        r6 = "image_file_path";
        r0 = r2.getAbsolutePath();
        r8.putExtra(r6, r0);
        r1 = r3;
    L_0x0086:
        if (r1 != 0) goto L_0x0089;
    L_0x0088:
        return;
    L_0x0089:
        r6 = r5.getContext();
        r0 = com.qiyukf.nim.uikit.common.media.picker.activity.PreviewImageFromCameraActivity.class;
        r8.setClass(r6, r0);
        r5.startActivityForResult(r8, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.helper.d.a(android.support.v4.app.Fragment, android.content.Intent, int, com.qiyukf.nim.uikit.session.helper.d$a):void");
    }
}
