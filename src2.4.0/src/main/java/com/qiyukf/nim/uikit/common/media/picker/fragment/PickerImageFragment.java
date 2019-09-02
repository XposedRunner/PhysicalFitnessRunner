package com.qiyukf.nim.uikit.common.media.picker.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.common.media.picker.a.b;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.unicorn.R;
import java.util.ArrayList;
import java.util.List;

public class PickerImageFragment extends TFragment implements OnItemClickListener {
    private GridView a;
    private a b;
    private List<PhotoInfo> c;
    private b d;
    private boolean e;
    private int f;
    private int g = 1;

    public interface a {
        void onPhotoSelectClick(PhotoInfo photoInfo);

        void onPhotoSingleClick(List<PhotoInfo> list, int i);
    }

    public PickerImageFragment() {
        setContainerId(R.id.picker_photos_fragment);
    }

    private void a() {
        if (this.a != null) {
            this.a.setNumColumns(this.g == 2 ? 6 : 4);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = getArguments();
        this.c = new ArrayList();
        this.c.addAll(com.qiyukf.nim.uikit.common.media.picker.b.b.a(getContext()));
        this.e = bundle.getBoolean("multi_select_mode");
        this.f = bundle.getInt("multi_select_size_limit", 9);
        this.g = bundle.getInt("extra_screen_orientation");
        this.a = (GridView) getView().findViewById(R.id.picker_images_gridview);
        a();
        this.d = new b(getActivity(), this.c, this.a, this.e, 0, this.f, this.g);
        this.a.setAdapter(this.d);
        this.a.setOnItemClickListener(this);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.b == null) {
            this.b = (a) activity;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.g = configuration.orientation;
        a();
        this.d.a(configuration);
        if (this.d != null) {
            this.d.notifyDataSetChanged();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.ysf_picker_images_fragment, viewGroup, false);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.b.onPhotoSingleClick(this.c, i);
    }

    public void resetFragment(List<PhotoInfo> list, int i) {
        this.a.setAdapter(null);
        if (this.c == null) {
            this.c = new ArrayList();
        } else {
            this.c.clear();
        }
        if (list != null) {
            this.c.addAll(list);
        }
        a();
        this.d = new b(getActivity(), this.c, this.a, this.e, i, this.f, this.g);
        this.a.setAdapter(this.d);
    }

    public void updateSelectPhotos(List<PhotoInfo> list) {
        if (list != null) {
            for (PhotoInfo photoInfo : this.c) {
                photoInfo.setChoose(list.contains(photoInfo));
            }
            if (this.d != null) {
                this.d.notifyDataSetChanged();
            }
        }
    }

    public void updateSelectedForAdapter(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }
}
