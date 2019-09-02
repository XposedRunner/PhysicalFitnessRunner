package com.sw.emoji;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;

public class EmoticonsKeyboard extends AutoHeightLayout implements OnPageChangeListener {
    protected LayoutInflater O00000oO;
    protected ViewPager O00000oo;
    protected EmotionIndicatorView O0000O0o;
    protected EditText O0000OOo;
    protected TextView O0000Oo;
    protected TextView O0000Oo0;
    protected ImageButton O0000OoO;
    protected ImageButton O0000Ooo;
    protected View O0000o;
    protected TextView O0000o0;
    protected ImageButton O0000o00;
    protected View O0000o0O;
    protected View O0000o0o;
    protected View O0000oO0;
    private O00000o0 O0000oOo;
    private int O0000oo;
    private int O0000oo0 = 0;
    private O00000Oo O0000ooO;

    public enum O000000o {
        Like,
        Post
    }

    public enum O00000Oo {
        DEF_KEY,
        EMOJI
    }

    public interface O00000o0 {
        void O000000o();

        void O000000o(int i);

        void O00000Oo(int i);
    }

    public EmoticonsKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000oO = (LayoutInflater) context.getSystemService("layout_inflater");
        O00000Oo();
        O0000OOo();
        O00000o0();
    }

    private void O0000OOo() {
        this.O00000oo = (ViewPager) findViewById(R.id.keyboard_emoji_body);
        this.O0000O0o = (EmotionIndicatorView) findViewById(R.id.keyboard_emoji_indicator);
        this.O0000OOo = (EditText) findViewById(R.id.keyboard_comment_edt);
        this.O0000o0O = findViewById(R.id.keyboard_edt_layout);
        this.O0000o0o = findViewById(R.id.keyboard_like_layout);
        this.O0000o = findViewById(R.id.keyboard_post_layout);
        this.O0000oO0 = findViewById(R.id.keyboard_emoji_layout);
        this.O0000Oo0 = (TextView) findViewById(R.id.keyboard_like);
        this.O0000Oo = (TextView) findViewById(R.id.keyboard_unlike);
        this.O0000OoO = (ImageButton) findViewById(R.id.keyboard_change);
        this.O0000Ooo = (ImageButton) findViewById(R.id.keyboard_comment);
        this.O0000o00 = (ImageButton) findViewById(R.id.keyboard_send_img);
        this.O0000o0 = (TextView) findViewById(R.id.keyboard_post_btn);
        this.O00000oo.addOnPageChangeListener(this);
        this.O0000OOo.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                EmoticonsKeyboard.this.O0000Ooo.setEnabled(TextUtils.isEmpty(editable) ^ 1);
                EmoticonsKeyboard.this.O0000o0.setEnabled(TextUtils.isEmpty(editable) ^ 1);
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.O0000Ooo.setEnabled(false);
    }

    private void setEmojiVisibility(boolean z) {
        LayoutParams layoutParams = (LayoutParams) this.O0000oO0.getLayoutParams();
        if (z) {
            this.O0000oO0.setVisibility(0);
            if (this.O0000ooO == O00000Oo.DEF_KEY) {
                layoutParams.height = this.O0000oo;
            } else {
                layoutParams.height = s.O000000o(getContext(), 215.0f);
            }
            if (this.O0000oOo != null) {
                this.O0000oOo.O00000Oo(layoutParams.height);
            }
        } else {
            this.O0000oO0.setVisibility(8);
            layoutParams.height = 0;
        }
        this.O0000oO0.setLayoutParams(layoutParams);
    }

    public void O000000o() {
        super.O000000o();
        if (this.O0000ooO == O00000Oo.DEF_KEY) {
            O00000oo();
            if (this.O0000oOo != null) {
                this.O0000oOo.O000000o();
            }
        }
    }

    public void O000000o(O000000o o000000o) {
        switch (o000000o) {
            case Like:
                this.O0000o0o.setVisibility(0);
                this.O0000o.setVisibility(8);
                return;
            case Post:
                this.O0000o0o.setVisibility(8);
                this.O0000o.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void O000000o(O00000Oo o00000Oo) {
        if (o00000Oo != this.O0000ooO) {
            if (O0000O0o()) {
                s.O00000o0(getContext());
            }
            O00000oO(true);
            this.O0000ooO = O00000Oo.EMOJI;
            setEmojiVisibility(true);
        } else if (O0000O0o()) {
            s.O00000o0(getContext());
            O00000oO(true);
        } else {
            s.O000000o(this.O0000OOo);
            O00000oO(false);
        }
    }

    public void O000000o(boolean z) {
        this.O0000o00.setVisibility(z ? 0 : 8);
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo() {
        this.O00000oO.inflate(R.layout.view_keyboard_emoji, this);
    }

    public void O00000Oo(int i) {
        super.O00000Oo(i);
        this.O0000oo = i;
        this.O0000ooO = O00000Oo.DEF_KEY;
        if (this.O0000oO0.getVisibility() == 8 && this.O0000oOo != null) {
            this.O0000oOo.O000000o(i);
        }
        setEmojiVisibility(true);
        O00000oO(false);
    }

    public void O00000Oo(boolean z) {
        this.O0000o0O.setVisibility(z ? 0 : 8);
    }

    public void O00000o(boolean z) {
        this.O0000Oo.setTextColor(ContextCompat.getColor(getContext(), z ? R.color.unlike_checked : R.color.like_unchecked));
    }

    public boolean O00000o() {
        return this.O0000o0O.getVisibility() == 0;
    }

    public void O00000o0() {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr : p.O000000o) {
            ArrayList arrayList2 = new ArrayList();
            for (String str : p.O000000o[r2]) {
                p pVar = new p();
                pVar.O00000Oo(1);
                pVar.O000000o(str);
                arrayList2.add(pVar);
            }
            p pVar2 = new p();
            pVar2.O000000o(R.drawable.chat_delete_icon);
            pVar2.O00000Oo(2);
            arrayList2.add(pVar2);
            EmoticonPageView emoticonPageView = new EmoticonPageView(getContext());
            emoticonPageView.getRecyclerView().setAdapter(new m(arrayList2, new q<p>() {
                public void O000000o(p pVar) {
                    if (pVar.O00000o0() == 1) {
                        EmoticonsKeyboard.this.getEditText().getText().insert(EmoticonsKeyboard.this.getEditText().getSelectionStart(), pVar.O000000o());
                        return;
                    }
                    EmoticonsKeyboard.this.getEditText().onKeyDown(67, new KeyEvent(0, 67));
                }
            }));
            arrayList.add(emoticonPageView);
        }
        n nVar = new n(arrayList);
        this.O00000oo.setAdapter(nVar);
        this.O0000O0o.O000000o(nVar.getCount());
    }

    public void O00000o0(int i) {
        this.O0000oo = i;
    }

    public void O00000o0(boolean z) {
        this.O0000Oo0.setTextColor(ContextCompat.getColor(getContext(), z ? R.color.like_checked : R.color.like_unchecked));
    }

    public void O00000oO(boolean z) {
        this.O0000OoO.setImageResource(z ? R.drawable.chat_change_keyboard_icon : R.drawable.chat_change_emoji_icon);
    }

    public boolean O00000oO() {
        return this.O0000oO0.getVisibility() == 0;
    }

    public void O00000oo() {
        this.O0000ooO = O00000Oo.DEF_KEY;
        this.O0000OOo.clearFocus();
        s.O00000o0(getContext());
        setEmojiVisibility(false);
        O00000oO(false);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.O0000oO0.isShown()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        O00000oo();
        return true;
    }

    public EditText getEditText() {
        return this.O0000OOo;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.O0000O0o.O000000o(this.O0000oo0, i);
        this.O0000oo0 = i;
    }

    public void setOnSoftListener(O00000o0 o00000o0) {
        this.O0000oOo = o00000o0;
    }
}
