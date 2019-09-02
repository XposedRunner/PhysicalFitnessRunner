package com.umeng.socialize.shareboard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000o;
import defpackage.by;
import defpackage.cd;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShareBoardMenuHelper */
class O00000o0 {
    private static String O000000o = "O00000o0";
    private O00000Oo O00000Oo;

    public O00000o0(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    private int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private View O000000o(Context context, final O00000o o00000o) {
        LinearLayout linearLayout = new LinearLayout(context);
        LayoutParams layoutParams = new LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        if (o00000o != null) {
            int O000000o;
            cd O000000o2 = cd.O000000o(context);
            View inflate = LayoutInflater.from(context).inflate(O000000o2.O000000o("socialize_share_menu_item"), null);
            SocializeImageView socializeImageView = (SocializeImageView) inflate.findViewById(O000000o2.O00000Oo("socialize_image_view"));
            TextView textView = (TextView) inflate.findViewById(O000000o2.O00000Oo("socialize_text_view"));
            if (this.O00000Oo.O0000oO == 0 || this.O00000Oo.O0000o == O00000Oo.O00000o) {
                socializeImageView.setPadding(0, 0, 0, 0);
            } else {
                socializeImageView.O00000Oo(this.O00000Oo.O0000oO, this.O00000Oo.O0000oOO);
                socializeImageView.O000000o(this.O00000Oo.O0000o, this.O00000Oo.O0000oO0);
            }
            if (this.O00000Oo.O0000oo0 != 0) {
                socializeImageView.setPressedColor(this.O00000Oo.O0000oo0);
            }
            CharSequence charSequence = "";
            try {
                charSequence = o00000o.O00000Oo;
            } catch (Exception e) {
                by byVar = o00000o.O00000oo;
                String byVar2 = byVar == null ? "" : byVar.toString();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o.O000000o);
                stringBuilder.append(byVar2);
                O0000O0o.O000000o(stringBuilder.toString(), e);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(o00000o.O00000Oo);
            }
            textView.setGravity(17);
            try {
                O000000o = cd.O000000o(context, "drawable", o00000o.O00000o0);
            } catch (Exception e2) {
                by byVar3 = o00000o.O00000oo;
                String byVar4 = byVar3 == null ? "" : byVar3.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(O0000o.O000000o);
                stringBuilder2.append(byVar4);
                O0000O0o.O000000o(stringBuilder2.toString(), e2);
                O000000o = 0;
            }
            if (O000000o != 0) {
                socializeImageView.setImageResource(O000000o);
            }
            if (this.O00000Oo.O0000oOo != 0) {
                textView.setTextColor(this.O00000Oo.O0000oOo);
            }
            inflate.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    by byVar = o00000o.O00000oo;
                    if (O00000o0.this.O00000Oo != null && O00000o0.this.O00000Oo.O000000o() != null) {
                        O00000o0.this.O00000Oo.O000000o().O000000o(o00000o, byVar);
                    }
                }
            });
            linearLayout.addView(inflate);
        }
        return linearLayout;
    }

    private View O000000o(Context context, O00000o[] o00000oArr, boolean z) {
        LinearLayout linearLayout = new LinearLayout(context);
        int i = 0;
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        if (z) {
            layoutParams.topMargin = O000000o(context, 20.0f);
        }
        linearLayout.setLayoutParams(layoutParams);
        while (i < o00000oArr.length) {
            linearLayout.addView(O000000o(context, o00000oArr[i]));
            i++;
        }
        return linearLayout;
    }

    public View O000000o(Context context, O00000o[][] o00000oArr) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        int i = 0;
        while (i < o00000oArr.length) {
            linearLayout.addView(O000000o(context, o00000oArr[i], i != 0));
            i++;
        }
        return linearLayout;
    }

    public List<O00000o[][]> O000000o(List<O00000o> list) {
        int i = this.O00000Oo.O000O0Oo * 2;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3;
        if (size < this.O00000Oo.O000O0Oo) {
            O00000o[][] o00000oArr = (O00000o[][]) Array.newInstance(O00000o.class, new int[]{1, size});
            for (i3 = 0; i3 < list.size(); i3++) {
                o00000oArr[0][i3] = (O00000o) list.get(i3);
            }
            arrayList.add(o00000oArr);
            return arrayList;
        }
        int i4;
        int i5 = size / i;
        i = size % i;
        if (i != 0) {
            i4 = i / this.O00000Oo.O000O0Oo;
            if (i % this.O00000Oo.O000O0Oo == 0) {
                i2 = 0;
            }
            i4 += i2;
            i5++;
        } else {
            i4 = -1;
        }
        i = 0;
        while (i < i5) {
            i2 = (i != i5 + -1 || i4 == -1) ? 2 : i4;
            arrayList.add((O00000o[][]) Array.newInstance(O00000o.class, new int[]{i2, this.O00000Oo.O000O0Oo}));
            i++;
        }
        i = 0;
        i3 = i;
        while (i < arrayList.size()) {
            O00000o[][] o00000oArr2 = (O00000o[][]) arrayList.get(i);
            i2 = o00000oArr2.length;
            int i6 = i3;
            i3 = 0;
            while (i3 < i2) {
                O00000o[] o00000oArr3 = o00000oArr2[i3];
                int i7 = i6;
                for (i6 = 0; i6 < o00000oArr3.length; i6++) {
                    if (i7 < size) {
                        o00000oArr3[i6] = (O00000o) list.get(i7);
                    }
                    i7++;
                }
                i3++;
                i6 = i7;
            }
            i++;
            i3 = i6;
        }
        return arrayList;
    }
}
