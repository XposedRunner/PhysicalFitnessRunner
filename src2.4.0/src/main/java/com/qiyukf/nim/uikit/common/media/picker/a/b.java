package com.qiyukf.nim.uikit.common.media.picker.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.common.media.picker.activity.CheckboxImageView;
import com.qiyukf.nim.uikit.common.media.picker.b.c;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import java.util.List;

public final class b extends BaseAdapter {
    private Context a;
    private LayoutInflater b;
    private List<PhotoInfo> c;
    private GridView d;
    private int e = 0;
    private int f = (d.a() / 4);
    private boolean g;
    private int h;
    private int i = 1;
    private com.qiyukf.nim.uikit.common.media.picker.fragment.PickerImageFragment.a j;

    private class a {
        public ImageView a;
        public CheckboxImageView b;
        public RelativeLayout c;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    public b(Context context, List<PhotoInfo> list, GridView gridView, boolean z, int i, int i2, int i3) {
        this.a = context;
        this.b = LayoutInflater.from(context);
        this.c = list;
        this.d = gridView;
        this.g = z;
        this.e = i;
        this.h = i2;
        this.i = i3;
        if (this.j == null) {
            this.j = (com.qiyukf.nim.uikit.common.media.picker.fragment.PickerImageFragment.a) context;
        }
        this.f = i3 == 2 ? d.a() / 6 : d.a() / 4;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a(Configuration configuration) {
        this.i = configuration.orientation;
        if (this.d != null) {
            if (this.i == 2) {
                this.f = d.a() / 6;
                return;
            }
            this.f = d.a() / 4;
        }
    }

    public final int getCount() {
        return this.c.size();
    }

    public final Object getItem(int i) {
        return this.c.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        View inflate;
        if (view == null) {
            aVar = new a(this, (byte) 0);
            inflate = this.b.inflate(R.layout.ysf_picker_photo_grid_item, null);
            aVar.a = (ImageView) inflate.findViewById(R.id.picker_photo_grid_item_img);
            aVar.b = (CheckboxImageView) inflate.findViewById(R.id.picker_photo_grid_item_select);
            aVar.c = (RelativeLayout) inflate.findViewById(R.id.picker_photo_grid_item_select_hotpot);
            inflate.setTag(aVar);
        } else {
            inflate = view;
            aVar = (a) view.getTag();
        }
        if (this.g) {
            aVar.c.setVisibility(0);
        } else {
            aVar.c.setVisibility(8);
        }
        LayoutParams layoutParams = aVar.c.getLayoutParams();
        layoutParams.width = this.f / 2;
        layoutParams.height = this.f / 2;
        aVar.c.setLayoutParams(layoutParams);
        aVar.c.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                PhotoInfo photoInfo = (PhotoInfo) b.this.c.get(i);
                if (photoInfo.isChoose()) {
                    photoInfo.setChoose(false);
                    b.this.e = b.this.e - 1;
                } else if (b.this.e < b.this.h) {
                    photoInfo.setChoose(true);
                    b.this.e = b.this.e + 1;
                } else {
                    g.b(String.format(b.this.a.getResources().getString(R.string.ysf_picker_image_exceed_max_image_select), new Object[]{Integer.valueOf(b.this.h)}));
                    return;
                }
                ((a) b.this.d.getChildAt(i - b.this.d.getFirstVisiblePosition()).getTag()).b.a(((PhotoInfo) b.this.c.get(i)).isChoose());
                b.this.j.onPhotoSelectClick(photoInfo);
            }
        });
        aVar.b.a(((PhotoInfo) this.c.get(i)).isChoose());
        layoutParams = aVar.a.getLayoutParams();
        layoutParams.width = this.f;
        layoutParams.height = this.f;
        aVar.a.setLayoutParams(layoutParams);
        final PhotoInfo photoInfo = (PhotoInfo) this.c.get(i);
        if (photoInfo != null) {
            final String a = c.a(photoInfo.getImageId(), photoInfo.getFilePath());
            aVar.a.setTag(a);
            aVar.a.setImageResource(R.drawable.ysf_image_placeholder_loading);
            com.qiyukf.nim.uikit.a.a(a, this.f, this.f, new ImageLoaderListener() {
                public final void onLoadComplete(@NonNull Bitmap bitmap) {
                    if (a.equals(aVar.a.getTag())) {
                        aVar.a.setImageBitmap(com.qiyukf.nim.uikit.common.media.picker.b.a.a(bitmap, photoInfo.getAbsolutePath()));
                    }
                }

                public final void onLoadFailed(Throwable th) {
                }
            });
        }
        return inflate;
    }
}
