package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.Folder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: FolderAdapter */
/* renamed from: ef */
public class ef extends BaseAdapter {
    int O000000o;
    int O00000Oo = 0;
    private LayoutInflater O00000o;
    private Context O00000o0;
    private List<Folder> O00000oO = new ArrayList();

    /* compiled from: FolderAdapter */
    /* renamed from: ef$O000000o */
    class O000000o {
        ImageView O000000o;
        TextView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        ImageView O00000oO;

        O000000o(View view) {
            this.O000000o = (ImageView) view.findViewById(R.id.cover);
            this.O00000Oo = (TextView) view.findViewById(R.id.name);
            this.O00000o0 = (TextView) view.findViewById(R.id.path);
            this.O00000o = (TextView) view.findViewById(R.id.size);
            this.O00000oO = (ImageView) view.findViewById(R.id.indicator);
            view.setTag(this);
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(Folder folder) {
            if (folder != null) {
                this.O00000Oo.setText(folder.name);
                this.O00000o0.setText(folder.path);
                if (folder.images != null) {
                    this.O00000o.setText(String.format(Locale.CHINA, "%d%s", new Object[]{Integer.valueOf(folder.images.size()), ef.this.O00000o0.getResources().getString(R.string.photo_unit)}));
                } else {
                    TextView textView = this.O00000o;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("*");
                    stringBuilder.append(ef.this.O00000o0.getResources().getString(R.string.photo_unit));
                    textView.setText(stringBuilder.toString());
                }
                if (folder.cover != null) {
                    O00Oo.O00000o0(ef.this.O00000o0).O000000o(new File(folder.cover.path)).O0000O0o((int) R.mipmap.default_error).O00000Oo().O000000o(this.O000000o);
                } else {
                    this.O000000o.setImageResource(R.mipmap.default_error);
                }
            }
        }
    }

    public ef(Context context) {
        this.O00000o0 = context;
        this.O00000o = (LayoutInflater) context.getSystemService("layout_inflater");
        this.O000000o = this.O00000o0.getResources().getDimensionPixelOffset(R.dimen.folder_cover_size);
    }

    private int O00000Oo() {
        int i = 0;
        if (this.O00000oO != null && this.O00000oO.size() > 0) {
            for (Folder folder : this.O00000oO) {
                i += folder.images.size();
            }
        }
        return i;
    }

    public int O000000o() {
        return this.O00000Oo;
    }

    /* renamed from: O000000o */
    public Folder getItem(int i) {
        return i == 0 ? null : (Folder) this.O00000oO.get(i - 1);
    }

    public void O000000o(List<Folder> list) {
        if (list == null || list.size() <= 0) {
            this.O00000oO.clear();
        } else {
            this.O00000oO = list;
        }
        notifyDataSetChanged();
    }

    public void O00000Oo(int i) {
        if (this.O00000Oo != i) {
            this.O00000Oo = i;
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.O00000oO.size() + 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view == null) {
            view = this.O00000o.inflate(R.layout.list_item_folder, viewGroup, false);
            o000000o = new O000000o(view);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        if (o000000o != null) {
            if (i == 0) {
                o000000o.O00000Oo.setText(R.string.folder_all);
                o000000o.O00000o0.setText("/sdcard");
                o000000o.O00000o.setText(String.format(Locale.CHINA, "%d%s", new Object[]{Integer.valueOf(O00000Oo()), this.O00000o0.getResources().getString(R.string.photo_unit)}));
                if (this.O00000oO.size() > 0) {
                    Folder folder = (Folder) this.O00000oO.get(0);
                    if (folder.cover == null || TextUtils.isEmpty(folder.cover.path)) {
                        O00Oo.O00000o0(view.getContext()).O000000o(Integer.valueOf(R.mipmap.default_error)).O00000Oo().O000000o(o000000o.O000000o);
                    } else {
                        O00Oo.O00000o0(view.getContext()).O000000o(new File(folder.cover.path)).O00000oO(R.mipmap.default_error).O00000Oo().O000000o(o000000o.O000000o);
                    }
                }
            } else {
                o000000o.O000000o(getItem(i));
            }
            if (this.O00000Oo == i) {
                o000000o.O00000oO.setVisibility(0);
            } else {
                o000000o.O00000oO.setVisibility(4);
            }
        }
        return view;
    }
}
