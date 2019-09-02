package com.zjwh.android_wh_physicalfitness.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.view.photoview.PhotoView;
import com.zjwh.android_wh_physicalfitness.view.photoview.PhotoViewPager;
import java.util.ArrayList;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ImageViewerActivity extends BaseActivity {
    public static final String O000000o = "extra_image_paths";
    public static final String O00000Oo = "extra_image_position";
    @ViewInject(2131297472)
    private PhotoViewPager O00000o;
    @ViewInject(2131296622)
    public LinearLayout O00000o0;
    private List<String> O00000oO;
    private List<PhotoView> O00000oo;
    private int O0000O0o = 0;

    public static class O000000o extends PagerAdapter {
        private List<PhotoView> O000000o;

        O000000o(List<PhotoView> list) {
            this.O000000o = list;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        public int getCount() {
            return this.O000000o.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.removeView((View) this.O000000o.get(i));
            viewGroup.addView((View) this.O000000o.get(i));
            return this.O000000o.get(i);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class O00000Oo implements OnPageChangeListener {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(ImageViewerActivity imageViewerActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            ImageViewerActivity.this.O00000o0.getChildAt(i).setEnabled(true);
            if (i != ImageViewerActivity.this.O0000O0o) {
                ImageViewerActivity.this.O00000o0.getChildAt(ImageViewerActivity.this.O0000O0o).setEnabled(false);
                ImageViewerActivity.this.O0000O0o = i;
            }
        }
    }

    static {
        C.i(16777317);
    }

    public static void O000000o(Activity activity, ArrayList<String> arrayList, int i) {
        Intent intent = new Intent(activity, ImageViewerActivity.class);
        intent.putStringArrayListExtra(O000000o, arrayList);
        intent.putExtra(O00000Oo, i);
        activity.startActivity(intent);
    }

    private native void O000000o(Bundle bundle);

    private native void O00000o();

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE, XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
        super.onCreate(bundle);
        O000000o(bundle);
        if (!isFinishing()) {
            O00000o();
        }
    }

    public native void onDestroy();
}
