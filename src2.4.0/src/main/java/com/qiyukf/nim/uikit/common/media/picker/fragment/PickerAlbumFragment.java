package com.qiyukf.nim.uikit.common.media.picker.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.unicorn.R;
import java.util.ArrayList;
import java.util.List;
import s.h.e.l.l.C;

public class PickerAlbumFragment extends TFragment implements OnItemClickListener {
    private b a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private ListView e;
    private List<com.qiyukf.nim.uikit.common.media.picker.model.a> f = new ArrayList();

    private class a extends AsyncTask<Void, Object, Object> {
        private a() {
        }

        /* synthetic */ a(PickerAlbumFragment pickerAlbumFragment, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            PickerAlbumFragment.a(PickerAlbumFragment.this);
            PickerAlbumFragment.b(PickerAlbumFragment.this);
            return null;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (!(PickerAlbumFragment.this.getActivity() == null || PickerAlbumFragment.this.f == null)) {
                PickerAlbumFragment.this.e.setAdapter(new com.qiyukf.nim.uikit.common.media.picker.a.a(PickerAlbumFragment.this.getActivity(), PickerAlbumFragment.this.f));
                if (PickerAlbumFragment.this.f.size() > 0) {
                    PickerAlbumFragment.this.b.setVisibility(8);
                    return;
                }
                PickerAlbumFragment.this.b.setVisibility(0);
                PickerAlbumFragment.this.c.setVisibility(8);
                PickerAlbumFragment.this.d.setVisibility(0);
            }
        }
    }

    public interface b {
        void onAlbumItemClick(com.qiyukf.nim.uikit.common.media.picker.model.a aVar);
    }

    static {
        C.i(26);
    }

    public PickerAlbumFragment() {
        setContainerId(R.id.picker_album_fragment);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A:{SYNTHETIC, Splitter:B:30:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A:{SYNTHETIC, Splitter:B:23:0x005b} */
    static /* synthetic */ void a(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment r5) {
        /*
        com.qiyukf.nim.uikit.common.media.picker.b.c.a();
        r0 = 0;
        r5 = r5.getActivity();	 Catch:{ Exception -> 0x0052, all -> 0x004d }
        r5 = com.qiyukf.nim.uikit.common.media.b.a.a(r5);	 Catch:{ Exception -> 0x0052, all -> 0x004d }
        if (r5 == 0) goto L_0x0046;
    L_0x000e:
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x0044 }
        if (r0 == 0) goto L_0x0046;
    L_0x0014:
        r0 = "image_id";
        r0 = r5.getColumnIndex(r0);	 Catch:{ Exception -> 0x0044 }
        r0 = r5.getInt(r0);	 Catch:{ Exception -> 0x0044 }
        r1 = "_data";
        r1 = r5.getColumnIndex(r1);	 Catch:{ Exception -> 0x0044 }
        r1 = r5.getString(r1);	 Catch:{ Exception -> 0x0044 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0044 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044 }
        r3 = "file://";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0044 }
        r2.append(r1);	 Catch:{ Exception -> 0x0044 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x0044 }
        com.qiyukf.nim.uikit.common.media.picker.b.c.a(r0, r1);	 Catch:{ Exception -> 0x0044 }
        r0 = r5.moveToNext();	 Catch:{ Exception -> 0x0044 }
        if (r0 != 0) goto L_0x0014;
    L_0x0043:
        goto L_0x0046;
    L_0x0044:
        r0 = move-exception;
        goto L_0x0056;
    L_0x0046:
        if (r5 == 0) goto L_0x004c;
    L_0x0048:
        r5.close();	 Catch:{ Exception -> 0x004c }
        return;
    L_0x004c:
        return;
    L_0x004d:
        r5 = move-exception;
        r4 = r0;
        r0 = r5;
        r5 = r4;
        goto L_0x0061;
    L_0x0052:
        r5 = move-exception;
        r4 = r0;
        r0 = r5;
        r5 = r4;
    L_0x0056:
        r0.printStackTrace();	 Catch:{ all -> 0x0060 }
        if (r5 == 0) goto L_0x005f;
    L_0x005b:
        r5.close();	 Catch:{ Exception -> 0x005f }
        return;
    L_0x005f:
        return;
    L_0x0060:
        r0 = move-exception;
    L_0x0061:
        if (r5 == 0) goto L_0x0066;
    L_0x0063:
        r5.close();	 Catch:{ Exception -> 0x0066 }
    L_0x0066:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment.a(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x011b A:{SYNTHETIC, Splitter:B:30:0x011b} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012e A:{SYNTHETIC, Splitter:B:44:0x012e} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0135 A:{SYNTHETIC, Splitter:B:50:0x0135} */
    static /* synthetic */ void b(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment r12) {
        /*
        r0 = r12.f;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r12.f = r0;
        goto L_0x0011;
    L_0x000c:
        r0 = r12.f;
        r0.clear();
    L_0x0011:
        r0 = 0;
        r1 = r12.getActivity();	 Catch:{ Exception -> 0x0128 }
        r1 = com.qiyukf.nim.uikit.common.media.b.a.b(r1);	 Catch:{ Exception -> 0x0128 }
        r0 = new java.util.HashMap;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r0.<init>();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        if (r1 == 0) goto L_0x0119;
    L_0x0021:
        r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        if (r2 == 0) goto L_0x0119;
    L_0x0027:
        r2 = "_id";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r3 = "_data";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r4 = "bucket_display_name";
        r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r4 = r1.getString(r4);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r5 = "_size";
        r5 = r1.getColumnIndex(r5);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r5 = r1.getLong(r5);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r7 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8 = 0;
        if (r7 != 0) goto L_0x0063;
    L_0x0056:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r7.<init>(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r7 = r7.exists();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        if (r7 == 0) goto L_0x0063;
    L_0x0061:
        r7 = 1;
        goto L_0x0064;
    L_0x0063:
        r7 = r8;
    L_0x0064:
        if (r7 != 0) goto L_0x007b;
    L_0x0066:
        r2 = "PICKER";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r5 = "it is not a valid path:";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r4.append(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r3 = r4.toString();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        android.util.Log.d(r2, r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        goto L_0x0113;
    L_0x007b:
        r7 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r7.<init>();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9 = new com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.<init>();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r10 = r0.containsKey(r4);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        if (r10 == 0) goto L_0x00c9;
    L_0x008b:
        r7 = r0.remove(r4);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r7 = (com.qiyukf.nim.uikit.common.media.picker.model.a) r7;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r10 = r12.f;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r10 = r10.contains(r7);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        if (r10 == 0) goto L_0x009f;
    L_0x0099:
        r8 = r12.f;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8 = r8.indexOf(r7);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
    L_0x009f:
        r9.setImageId(r2);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r10 = "file://";
        r2.<init>(r10);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2.append(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.setFilePath(r2);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.setAbsolutePath(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.setSize(r5);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = r7.e();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2.add(r9);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = r12.f;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2.set(r8, r7);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r0.put(r4, r7);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        goto L_0x0113;
    L_0x00c9:
        r8 = new com.qiyukf.nim.uikit.common.media.picker.model.a;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8.<init>();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r7.clear();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.setImageId(r2);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r11 = "file://";
        r10.<init>(r11);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r10.append(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.setFilePath(r10);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.setAbsolutePath(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r9.setSize(r5);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r7.add(r9);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8.a(r2);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r5 = "file://";
        r2.<init>(r5);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2.append(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8.b(r2);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8.a(r3);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8.c(r4);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r8.a(r7);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2 = r12.f;	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r2.add(r8);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        r0.put(r4, r8);	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
    L_0x0113:
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0122, all -> 0x0120 }
        if (r2 != 0) goto L_0x0027;
    L_0x0119:
        if (r1 == 0) goto L_0x011f;
    L_0x011b:
        r1.close();	 Catch:{ Exception -> 0x011f }
        return;
    L_0x011f:
        return;
    L_0x0120:
        r12 = move-exception;
        goto L_0x0133;
    L_0x0122:
        r12 = move-exception;
        r0 = r1;
        goto L_0x0129;
    L_0x0125:
        r12 = move-exception;
        r1 = r0;
        goto L_0x0133;
    L_0x0128:
        r12 = move-exception;
    L_0x0129:
        r12.printStackTrace();	 Catch:{ all -> 0x0125 }
        if (r0 == 0) goto L_0x0132;
    L_0x012e:
        r0.close();	 Catch:{ Exception -> 0x0132 }
        return;
    L_0x0132:
        return;
    L_0x0133:
        if (r1 == 0) goto L_0x0138;
    L_0x0135:
        r1.close();	 Catch:{ Exception -> 0x0138 }
    L_0x0138:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment.b(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment):void");
    }

    public native void onActivityCreated(Bundle bundle);

    public native void onAttach(Activity activity);

    public native void onCreate(Bundle bundle);

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.onAlbumItemClick((com.qiyukf.nim.uikit.common.media.picker.model.a) this.f.get(i));
    }
}
