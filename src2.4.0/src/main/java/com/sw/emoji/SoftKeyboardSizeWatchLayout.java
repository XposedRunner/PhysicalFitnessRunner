package com.sw.emoji;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class SoftKeyboardSizeWatchLayout extends RelativeLayout {
    private Context O000000o;
    private int O00000Oo = -1;
    private List<O000000o> O00000o;
    private int O00000o0 = -1;
    protected int O0000oO = 0;
    protected boolean O0000oOO = false;

    public interface O000000o {
        void O000000o();

        void O00000Oo(int i);
    }

    public SoftKeyboardSizeWatchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O000000o = context;
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                Rect rect = new Rect();
                ((Activity) SoftKeyboardSizeWatchLayout.this.O000000o).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                if (SoftKeyboardSizeWatchLayout.this.O0000oO == 0) {
                    SoftKeyboardSizeWatchLayout.this.O0000oO = rect.bottom;
                }
                SoftKeyboardSizeWatchLayout.this.O00000o0 = SoftKeyboardSizeWatchLayout.this.O0000oO - rect.bottom;
                if (!(SoftKeyboardSizeWatchLayout.this.O00000Oo == -1 || SoftKeyboardSizeWatchLayout.this.O00000o0 == SoftKeyboardSizeWatchLayout.this.O00000Oo)) {
                    if (SoftKeyboardSizeWatchLayout.this.O00000o0 > 0) {
                        SoftKeyboardSizeWatchLayout.this.O0000oOO = true;
                        if (SoftKeyboardSizeWatchLayout.this.O00000o != null) {
                            for (O000000o O00000Oo : SoftKeyboardSizeWatchLayout.this.O00000o) {
                                O00000Oo.O00000Oo(SoftKeyboardSizeWatchLayout.this.O00000o0);
                            }
                        }
                    } else {
                        SoftKeyboardSizeWatchLayout.this.O0000oOO = false;
                        if (SoftKeyboardSizeWatchLayout.this.O00000o != null) {
                            for (O000000o O00000Oo2 : SoftKeyboardSizeWatchLayout.this.O00000o) {
                                O00000Oo2.O000000o();
                            }
                        }
                    }
                }
                SoftKeyboardSizeWatchLayout.this.O00000Oo = SoftKeyboardSizeWatchLayout.this.O00000o0;
            }
        });
    }

    public void O000000o(O000000o o000000o) {
        if (this.O00000o == null) {
            this.O00000o = new ArrayList();
        }
        this.O00000o.add(o000000o);
    }

    public boolean O0000O0o() {
        return this.O0000oOO;
    }
}
