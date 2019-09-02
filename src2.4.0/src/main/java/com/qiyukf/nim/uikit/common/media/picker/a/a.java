package com.qiyukf.nim.uikit.common.media.picker.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.nim.uikit.common.media.picker.b.c;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import java.util.List;

public final class a extends BaseAdapter {
    private LayoutInflater a;
    private List<com.qiyukf.nim.uikit.common.media.picker.model.a> b;
    private Context c;

    private class a {
        public ImageView a;
        public TextView b;
        public TextView c;

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    public a(Context context, List<com.qiyukf.nim.uikit.common.media.picker.model.a> list) {
        this.c = context;
        this.a = LayoutInflater.from(context);
        this.b = list;
    }

    public final int getCount() {
        return this.b.size();
    }

    public final Object getItem(int i) {
        return this.b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View inflate;
        if (view == null) {
            aVar = new a(this, (byte) 0);
            inflate = this.a.inflate(R.layout.ysf_picker_photofolder_item, null);
            aVar.a = (ImageView) inflate.findViewById(R.id.picker_photofolder_cover);
            aVar.b = (TextView) inflate.findViewById(R.id.picker_photofolder_info);
            aVar.c = (TextView) inflate.findViewById(R.id.picker_photofolder_num);
            inflate.setTag(aVar);
        } else {
            inflate = view;
            aVar = (a) view.getTag();
        }
        final com.qiyukf.nim.uikit.common.media.picker.model.a aVar2 = (com.qiyukf.nim.uikit.common.media.picker.model.a) this.b.get(i);
        final String a = c.a(aVar2.a(), aVar2.c());
        aVar.a.setTag(a);
        aVar.a.setImageResource(R.drawable.ysf_image_placeholder_loading);
        com.qiyukf.nim.uikit.a.a(a, d.a(75.0f), d.a(75.0f), new ImageLoaderListener() {
            public final void onLoadComplete(@NonNull Bitmap bitmap) {
                if (a.equals(aVar.a.getTag())) {
                    aVar.a.setImageBitmap(com.qiyukf.nim.uikit.common.media.picker.b.a.a(bitmap, aVar2.b()));
                }
            }

            public final void onLoadFailed(Throwable th) {
            }
        });
        aVar.b.setText(aVar2.d());
        aVar.c.setText(String.format(this.c.getResources().getString(R.string.ysf_picker_image_folder_info), new Object[]{Integer.valueOf(((com.qiyukf.nim.uikit.common.media.picker.model.a) this.b.get(i)).e().size())}));
        return inflate;
    }
}
