package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.DensityUtil;

/* compiled from: ActionItemDialog */
public class O000000o {
    private Context O000000o;
    private BottomSheetDialog O00000Oo;
    private LinearLayout O00000o;
    private TextView O00000o0;
    private ScrollView O00000oO;
    private List<O00000Oo> O00000oo;
    private Typeface O0000O0o;
    private int O0000OOo = ((int) (((double) DensityUtil.getScreenHeight()) * 0.075d));
    private OnDismissListener O0000Oo;
    private OnClickListener O0000Oo0;

    /* compiled from: ActionItemDialog */
    public interface O000000o {
        void O000000o(int i);
    }

    /* compiled from: ActionItemDialog */
    public class O00000Oo {
        String O000000o;
        O000000o O00000Oo;
        O00000o0 O00000o0;

        public O00000Oo(String str, O00000o0 o00000o0, O000000o o000000o) {
            this.O000000o = str;
            this.O00000o0 = o00000o0;
            this.O00000Oo = o000000o;
        }
    }

    /* compiled from: ActionItemDialog */
    public enum O00000o0 {
        Blue("#037BFF"),
        Red("#FD4A2E"),
        Green("#33C4C2"),
        Black("#333333");
        
        private String O00000oO;

        private O00000o0(String str) {
            this.O00000oO = str;
        }

        public String O000000o() {
            return this.O00000oO;
        }

        public void O000000o(String str) {
            this.O00000oO = str;
        }
    }

    public O000000o(Context context) {
        this.O000000o = context;
        this.O0000O0o = Typeface.createFromAsset(context.getAssets(), "fonts/Impact.ttf");
    }

    private void O00000o0() {
        if (this.O00000oo != null && this.O00000oo.size() > 0) {
            int size = this.O00000oo.size();
            if (size >= 7) {
                LayoutParams layoutParams = (LayoutParams) this.O00000oO.getLayoutParams();
                layoutParams.height = DensityUtil.getScreenHeight() / 2;
                this.O00000oO.setLayoutParams(layoutParams);
            }
            for (int i = 1; i <= size; i++) {
                O00000Oo o00000Oo = (O00000Oo) this.O00000oo.get(i - 1);
                String str = o00000Oo.O000000o;
                O00000o0 o00000o0 = o00000Oo.O00000o0;
                final O000000o o000000o = o00000Oo.O00000Oo;
                TextView textView = new TextView(this.O000000o);
                textView.setText(str);
                textView.setTextSize(18.0f);
                textView.setGravity(17);
                textView.setTypeface(this.O0000O0o);
                textView.setBackgroundResource(R.drawable.selector_solid_white);
                if (o00000o0 == null) {
                    textView.setTextColor(Color.parseColor(O00000o0.Blue.O000000o()));
                } else {
                    textView.setTextColor(Color.parseColor(o00000o0.O000000o()));
                }
                textView.setLayoutParams(new LayoutParams(-1, this.O0000OOo));
                textView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (o000000o != null) {
                            o000000o.O000000o(i);
                        }
                        O000000o.this.O00000Oo.dismiss();
                    }
                });
                View view = new View(this.O000000o);
                view.setLayoutParams(new LayoutParams(-1, 1));
                view.setBackgroundColor(ContextCompat.getColor(this.O000000o, R.color.window_background));
                this.O00000o.addView(view);
                this.O00000o.addView(textView);
            }
        }
    }

    public O000000o O000000o() {
        View inflate = LayoutInflater.from(this.O000000o).inflate(R.layout.view_action_item, null);
        inflate.setMinimumWidth(DensityUtil.getScreenHeight());
        this.O00000oO = (ScrollView) inflate.findViewById(R.id.sLayout_content);
        this.O00000o = (LinearLayout) inflate.findViewById(R.id.lLayout_content);
        this.O00000o0 = (TextView) inflate.findViewById(R.id.tv_title);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_cancel);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                O000000o.this.O00000Oo.dismiss();
                if (O000000o.this.O0000Oo0 != null) {
                    O000000o.this.O0000Oo0.onClick(view);
                }
            }
        });
        textView.setTypeface(this.O0000O0o);
        this.O00000o0.setTypeface(this.O0000O0o);
        LayoutParams layoutParams = new LayoutParams(-1, this.O0000OOo);
        layoutParams.topMargin = 24;
        textView.setLayoutParams(layoutParams);
        this.O00000Oo = new BottomSheetDialog(this.O000000o);
        this.O00000Oo.setContentView(inflate);
        if (VERSION.SDK_INT >= 18) {
            Window window = this.O00000Oo.getWindow();
            if (window != null) {
                window.getDecorView().getViewTreeObserver().addOnWindowAttachListener(new OnWindowAttachListener() {
                    public void onWindowAttached() {
                    }

                    public void onWindowDetached() {
                        O000000o.this.O0000Oo0 = null;
                        O000000o.this.O0000Oo = null;
                        O000000o.this.O00000Oo = null;
                        if (O000000o.this.O00000oo != null) {
                            for (O00000Oo o00000Oo : O000000o.this.O00000oo) {
                                o00000Oo.O00000Oo = null;
                            }
                            O000000o.this.O00000oo.clear();
                        }
                    }
                });
            }
        }
        return this;
    }

    public O000000o O000000o(int i) {
        this.O00000o0.setText(this.O000000o.getText(i));
        this.O00000o0.setVisibility(0);
        return this;
    }

    public O000000o O000000o(OnDismissListener onDismissListener) {
        this.O0000Oo = onDismissListener;
        this.O00000Oo.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (O000000o.this.O0000Oo != null) {
                    O000000o.this.O0000Oo.onDismiss(dialogInterface);
                }
            }
        });
        return this;
    }

    public O000000o O000000o(OnClickListener onClickListener) {
        this.O0000Oo0 = onClickListener;
        this.O00000Oo.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (O000000o.this.O0000Oo0 != null) {
                    O000000o.this.O0000Oo0.onClick(null);
                }
            }
        });
        return this;
    }

    public O000000o O000000o(String str) {
        this.O00000o0.setText(str);
        this.O00000o0.setVisibility(0);
        return this;
    }

    public O000000o O000000o(String str, O00000o0 o00000o0, O000000o o000000o) {
        if (this.O00000oo == null) {
            this.O00000oo = new ArrayList();
        }
        this.O00000oo.add(new O00000Oo(str, o00000o0, o000000o));
        return this;
    }

    public O000000o O000000o(boolean z) {
        this.O00000Oo.setCancelable(z);
        return this;
    }

    public O000000o O00000Oo(boolean z) {
        this.O00000Oo.setCanceledOnTouchOutside(z);
        return this;
    }

    public void O00000Oo() {
        O00000o0();
        this.O00000Oo.show();
    }
}
