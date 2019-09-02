package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ImageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ImageGridAdapter */
/* renamed from: eh */
public class eh extends BaseAdapter {
    private static final int O00000Oo = 0;
    private static final int O00000o0 = 1;
    final int O000000o;
    private Context O00000o;
    private LayoutInflater O00000oO;
    private boolean O00000oo = true;
    private boolean O0000O0o = true;
    private List<ImageEntity> O0000OOo = new ArrayList();
    private List<ImageEntity> O0000Oo0 = new ArrayList();

    /* compiled from: ImageGridAdapter */
    /* renamed from: eh$O000000o */
    class O000000o {
        ImageView O000000o;
        ImageView O00000Oo;
        View O00000o0;

        O000000o(View view) {
            this.O000000o = (ImageView) view.findViewById(2131296606);
            this.O00000Oo = (ImageView) view.findViewById(R.id.checkmark);
            this.O00000o0 = view.findViewById(R.id.mask);
            view.setTag(this);
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(ImageEntity imageEntity) {
            if (imageEntity != null) {
                if (eh.this.O0000O0o) {
                    this.O00000Oo.setVisibility(0);
                    if (eh.this.O0000Oo0.contains(imageEntity)) {
                        this.O00000Oo.setImageResource(R.drawable.album_img_select);
                        this.O00000o0.setVisibility(0);
                    } else {
                        this.O00000Oo.setImageResource(R.drawable.album_img_unselect);
                        this.O00000o0.setVisibility(8);
                    }
                } else {
                    this.O00000Oo.setVisibility(8);
                }
                if (TextUtils.isEmpty(imageEntity.path)) {
                    this.O000000o.setImageResource(R.mipmap.default_error);
                } else {
                    O00Oo.O00000o0(eh.this.O00000o).O000000o(imageEntity.path).O0000Oo().O0000o0().O0000O0o((int) R.mipmap.default_error).O00000Oo().O000000o(this.O000000o);
                }
            }
        }
    }

    public eh(Context context, boolean z, int i) {
        int i2;
        this.O00000o = context;
        this.O00000oO = (LayoutInflater) context.getSystemService("layout_inflater");
        this.O00000oo = z;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (VERSION.SDK_INT >= 13) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            i2 = point.x;
        } else {
            i2 = windowManager.getDefaultDisplay().getWidth();
        }
        this.O000000o = i2 / i;
    }

    private ImageEntity O000000o(String str) {
        if (this.O0000OOo != null && this.O0000OOo.size() > 0) {
            for (ImageEntity imageEntity : this.O0000OOo) {
                if (imageEntity.path.equalsIgnoreCase(str)) {
                    return imageEntity;
                }
            }
        }
        return null;
    }

    /* renamed from: O000000o */
    public ImageEntity getItem(int i) {
        return this.O00000oo ? i == 0 ? null : (ImageEntity) this.O0000OOo.get(i - 1) : (ImageEntity) this.O0000OOo.get(i);
    }

    public void O000000o(ImageEntity imageEntity) {
        if (this.O0000Oo0.contains(imageEntity)) {
            this.O0000Oo0.remove(imageEntity);
        } else {
            this.O0000Oo0.add(imageEntity);
        }
        notifyDataSetChanged();
    }

    public void O000000o(ArrayList<String> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ImageEntity O000000o = O000000o((String) it.next());
            if (O000000o != null) {
                this.O0000Oo0.add(O000000o);
            }
        }
        if (this.O0000Oo0.size() > 0) {
            notifyDataSetChanged();
        }
    }

    public void O000000o(List<ImageEntity> list) {
        this.O0000Oo0.clear();
        if (list == null || list.size() <= 0) {
            this.O0000OOo.clear();
        } else {
            this.O0000OOo = list;
        }
        notifyDataSetChanged();
    }

    public void O000000o(boolean z) {
        this.O0000O0o = z;
    }

    public boolean O000000o() {
        return this.O00000oo;
    }

    public void O00000Oo(boolean z) {
        if (this.O00000oo != z) {
            this.O00000oo = z;
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.O00000oo ? this.O0000OOo.size() + 1 : this.O0000OOo.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        int i2 = 1;
        if (!this.O00000oo) {
            return 1;
        }
        if (i == 0) {
            i2 = 0;
        }
        return i2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (O000000o() && i == 0) {
            return this.O00000oO.inflate(R.layout.list_item_camera, viewGroup, false);
        }
        O000000o o000000o;
        if (view == null) {
            view = this.O00000oO.inflate(R.layout.list_item_image, viewGroup, false);
            o000000o = new O000000o(view);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        if (o000000o != null) {
            o000000o.O000000o(getItem(i));
        }
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }
}
