package defpackage;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import defpackage.oOOO0O0o.O000000o;

/* compiled from: NiftyNotificationView */
/* renamed from: oOOOOO0O */
public class oOOOOO0O {
    private static final String O000000o = "Null parameters are not accepted";
    private static final int O00000Oo = 16908299;
    private static final int O00000o0 = 16908294;
    private oOOO0O0o O00000o = null;
    private final CharSequence O00000oO;
    private final oOOO0OO0 O00000oo;
    private Activity O0000O0o;
    private ViewGroup O0000OOo;
    private Drawable O0000Oo;
    private FrameLayout O0000Oo0;
    private int O0000OoO;
    private boolean O0000Ooo;
    private OnClickListener O0000o00;

    private oOOOOO0O(Activity activity, CharSequence charSequence, oOOO0OO0 oooo0oo0, ViewGroup viewGroup) {
        if (activity == null || charSequence == null) {
            throw new IllegalArgumentException(O000000o);
        }
        this.O0000Ooo = true;
        this.O0000O0o = activity;
        this.O00000oO = charSequence;
        this.O00000oo = oooo0oo0;
        this.O0000OOo = viewGroup;
        this.O00000o = new O000000o().O000000o();
        O000000o(oooo0oo0);
    }

    private oOOOOO0O(Activity activity, CharSequence charSequence, oOOO0OO0 oooo0oo0, ViewGroup viewGroup, oOOO0O0o oooo0o0o) {
        if (activity == null || charSequence == null || oooo0o0o == null) {
            throw new IllegalArgumentException(O000000o);
        }
        this.O0000Ooo = false;
        this.O0000O0o = activity;
        this.O00000oO = charSequence;
        this.O00000oo = oooo0oo0;
        this.O0000OOo = viewGroup;
        this.O00000o = oooo0o0o;
        O000000o(oooo0oo0);
    }

    public static oOOOOO0O O000000o(Activity activity, CharSequence charSequence, oOOO0OO0 oooo0oo0, int i) {
        return new oOOOOO0O(activity, charSequence, oooo0oo0, (ViewGroup) activity.findViewById(i));
    }

    public static oOOOOO0O O000000o(Activity activity, CharSequence charSequence, oOOO0OO0 oooo0oo0, int i, oOOO0O0o oooo0o0o) {
        return new oOOOOO0O(activity, charSequence, oooo0oo0, (ViewGroup) activity.findViewById(i), oooo0o0o);
    }

    private void O000000o(oOOO0OO0 oooo0oo0) {
        this.O0000Oo = null;
        this.O0000OoO = 0;
    }

    private void O0000o() {
        if (this.O0000O0o != null) {
            this.O0000Oo0 = O0000oO0();
            this.O0000Oo0.addView(O0000oO());
        }
    }

    private RelativeLayout O0000oO() {
        ImageView imageView;
        RelativeLayout relativeLayout = new RelativeLayout(this.O0000O0o);
        relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
        if (this.O0000Oo == null && this.O0000OoO == 0) {
            imageView = null;
        } else {
            imageView = O0000oOo();
            relativeLayout.addView(imageView, imageView.getLayoutParams());
        }
        TextView O0000oOO = O0000oOO();
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        if (imageView != null) {
            layoutParams.addRule(1, imageView.getId());
        }
        layoutParams.addRule(13);
        relativeLayout.addView(O0000oOO, layoutParams);
        return relativeLayout;
    }

    private FrameLayout O0000oO0() {
        FrameLayout frameLayout = new FrameLayout(this.O0000O0o);
        if (this.O0000o00 != null) {
            frameLayout.setOnClickListener(this.O0000o00);
        }
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    private TextView O0000oOO() {
        int O000000o = O000000o((float) this.O00000o.O0000OoO);
        int O000000o2 = O000000o((float) this.O00000o.O0000O0o);
        TextView textView = new TextView(this.O0000O0o);
        textView.setMaxHeight(O000000o2);
        textView.setMaxHeight(O000000o2);
        textView.setId(O00000Oo);
        textView.setText(this.O00000oO);
        textView.setMaxLines(this.O00000o.O0000Oo);
        textView.setEllipsize(TruncateAt.END);
        int i = O000000o * 2;
        textView.setPadding(i, O000000o, i, O000000o);
        textView.setTextColor(Color.parseColor(this.O00000o.O00000oO));
        textView.setBackgroundColor(Color.parseColor(this.O00000o.O00000oo));
        if (this.O0000Oo == null && this.O0000OoO == 0) {
            textView.setGravity(this.O0000Ooo ? 17 : this.O00000o.O0000Oo0);
        } else {
            textView.setMinHeight(O000000o2);
            textView.setGravity(this.O0000Ooo ? 16 : this.O00000o.O0000Oo0);
        }
        return textView;
    }

    private ImageView O0000oOo() {
        int O000000o = O000000o((float) this.O00000o.O0000O0o);
        ImageView imageView = new ImageView(this.O0000O0o);
        imageView.setMinimumHeight(O000000o);
        imageView.setMinimumWidth(O000000o);
        imageView.setMaxWidth(O000000o);
        imageView.setMaxHeight(O000000o);
        imageView.setId(O00000o0);
        imageView.setBackgroundColor(Color.parseColor(this.O00000o.O0000OOo));
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        if (this.O0000Oo != null) {
            imageView.setImageDrawable(this.O0000Oo);
        }
        if (this.O0000OoO != 0) {
            imageView.setImageResource(this.O0000OoO);
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public int O000000o(float f) {
        return (int) ((f * this.O0000O0o.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public long O000000o() {
        return this.O00000oo.O000000o().O000000o();
    }

    public oOOOOO0O O000000o(int i) {
        this.O0000OoO = i;
        return this;
    }

    public oOOOOO0O O000000o(Drawable drawable) {
        this.O0000Oo = drawable;
        return this;
    }

    public oOOOOO0O O000000o(OnClickListener onClickListener) {
        this.O0000o00 = onClickListener;
        return this;
    }

    public void O000000o(boolean z) {
        oOOO0o00.O000000o().O000000o(this, z);
    }

    public long O00000Oo() {
        return this.O00000oo.O000000o().O000000o();
    }

    public oOOO0OO0 O00000o() {
        return this.O00000oo;
    }

    public long O00000o0() {
        return this.O00000o.O00000o;
    }

    public oOOO0O0o O00000oO() {
        return this.O00000o;
    }

    /* Access modifiers changed, original: 0000 */
    public Activity O00000oo() {
        return this.O0000O0o;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O0000O0o() {
        return this.O0000O0o != null && O0000OOo();
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O0000OOo() {
        return (this.O0000Oo0 == null || this.O0000Oo0.getParent() == null) ? false : true;
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000Oo() {
        this.O0000OOo = null;
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000Oo0() {
        this.O0000O0o = null;
    }

    /* Access modifiers changed, original: 0000 */
    public ViewGroup O0000OoO() {
        return this.O0000OOo;
    }

    /* Access modifiers changed, original: 0000 */
    public View O0000Ooo() {
        if (this.O0000Oo0 == null) {
            O0000o();
        }
        return this.O0000Oo0;
    }

    public void O0000o0() {
        oOOO0o00.O000000o().O000000o(this);
    }

    public void O0000o00() {
        O000000o(true);
    }

    public void O0000o0O() {
        oOOO0o00.O000000o().O00000Oo();
    }

    public void O0000o0o() {
        oOOO0o00.O000000o().O00000Oo(this);
    }
}
