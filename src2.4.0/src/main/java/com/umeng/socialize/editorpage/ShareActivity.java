package com.umeng.socialize.editorpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O0000o0;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import defpackage.bv;
import defpackage.by;
import defpackage.cd;
import defpackage.ce;
import java.io.File;

public class ShareActivity extends Activity implements OnClickListener {
    private static int O00000o = 140;
    private static final String O00000o0 = "ShareActivity";
    protected ImageView O000000o;
    TextWatcher O00000Oo = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ShareActivity.this.O0000o00 = ShareActivity.this.O00000oO();
        }
    };
    private String O00000oO = "6.9.4";
    private String O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private EditText O0000Oo;
    private cd O0000Oo0;
    private TextView O0000OoO;
    private Context O0000Ooo;
    private TextView O0000o;
    private by O0000o0;
    private boolean O0000o00;
    private boolean O0000o0O = false;
    private ImageView O0000o0o;

    private by O000000o(String str) {
        return str.equals("TENCENT") ? by.TENCENT : str.equals("RENREN") ? by.RENREN : str.equals("DOUBAN") ? by.DOUBAN : str.equals("TWITTER") ? by.TWITTER : str.equals("LINKEDIN") ? by.LINKEDIN : by.SINA;
    }

    private String O00000Oo(String str) {
        return str.equals("TENCENT") ? getResources().getString(this.O0000Oo0.O00000oO("umeng_socialize_sharetotencent")) : str.equals("RENREN") ? getResources().getString(this.O0000Oo0.O00000oO("umeng_socialize_sharetorenren")) : str.equals("DOUBAN") ? getResources().getString(this.O0000Oo0.O00000oO("umeng_socialize_sharetodouban")) : str.equals("TWITTER") ? getResources().getString(this.O0000Oo0.O00000oO("umeng_socialize_sharetotwitter")) : str.equals("LINKEDIN") ? getResources().getString(this.O0000Oo0.O00000oO("umeng_socialize_sharetolinkin")) : getResources().getString(this.O0000Oo0.O00000oO("umeng_socialize_sharetosina"));
    }

    private void O00000Oo() {
        this.O0000Oo = (EditText) findViewById(this.O0000Oo0.O00000Oo("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.O00000oo)) {
            this.O0000Oo.setText(this.O00000oo);
            this.O0000Oo.setSelection(this.O00000oo.length());
        }
        this.O0000o = (TextView) findViewById(this.O0000Oo0.O00000Oo("umeng_web_title"));
        this.O000000o = (ImageView) findViewById(this.O0000Oo0.O00000Oo("umeng_share_icon"));
        if (this.O0000OOo != null) {
            findViewById(this.O0000Oo0.O00000Oo("umeng_socialize_share_bottom_area")).setVisibility(0);
            this.O000000o = (ImageView) findViewById(this.O0000Oo0.O00000Oo("umeng_share_icon"));
            this.O000000o.setVisibility(0);
            if (this.O0000OOo.equals("video")) {
                this.O000000o.setImageResource(cd.O000000o(this.O0000Ooo, "drawable", "umeng_socialize_share_video"));
            } else if (this.O0000OOo.equals("music")) {
                this.O000000o.setImageResource(cd.O000000o(this.O0000Ooo, "drawable", "umeng_socialize_share_music"));
            } else if (this.O0000OOo.equals("web")) {
                this.O000000o.setImageResource(cd.O000000o(this.O0000Ooo, "drawable", "umeng_socialize_share_web"));
            } else {
                this.O000000o.setImageURI(Uri.fromFile(new File(this.O0000OOo)));
            }
            if (!TextUtils.isEmpty(this.O0000O0o)) {
                this.O0000o.setVisibility(0);
                this.O0000o.setText(this.O0000O0o);
            }
            findViewById(this.O0000Oo0.O00000Oo("root")).setBackgroundColor(-1);
        } else if (!TextUtils.isEmpty(this.O0000O0o)) {
            this.O000000o.setImageResource(cd.O000000o(this.O0000Ooo, "drawable", "umeng_socialize_share_web"));
            this.O0000o.setVisibility(0);
            this.O0000o.setText(this.O0000O0o);
        }
    }

    private void O00000o() {
        this.O0000OOo = null;
        findViewById(this.O0000Oo0.O00000Oo("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.O0000Oo0.O00000Oo("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    private void O00000o0() {
        String obj = this.O0000Oo.getText().toString();
        if (TextUtils.isEmpty(obj.trim()) && this.O0000o0 == by.SINA && (TextUtils.isEmpty(this.O0000OOo) || this.O0000OOo.equals("web") || this.O0000OOo.equals("video") || this.O0000OOo.equals("music"))) {
            Toast.makeText(this.O0000Ooo, O0000o0.O000O0oO, 0).show();
        } else if (O0000Oo0.O00000o0(obj) > O00000o && this.O0000o0 != by.TWITTER && this.O0000o0 != by.LINKEDIN) {
        } else {
            if (!this.O0000o00 || this.O0000o0 == by.TWITTER) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(ce.O0000oOO, obj);
                bundle.putString("pic", this.O0000OOo);
                intent.putExtras(bundle);
                setResult(-1, intent);
                O000000o();
                return;
            }
            Toast.makeText(this.O0000Ooo, O0000o0.O000O0oo, 0).show();
        }
    }

    private boolean O00000oO() {
        int O00000o0 = O00000o - O0000Oo0.O00000o0(this.O0000Oo.getText().toString());
        TextView textView = this.O0000OoO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000Oo0.O00000o0(this.O0000Oo.getText().toString()));
        stringBuilder.append("/");
        stringBuilder.append(O00000o);
        textView.setText(stringBuilder.toString());
        return O00000o0 < 0;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        finish();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!ce.O0000Ooo || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ShareActivity.this.setResult(1000);
                ShareActivity.this.finish();
            }
        }, 400);
        return true;
    }

    public void onCancel(View view) {
        setResult(1000);
        O000000o();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == this.O0000Oo0.O00000Oo("umeng_back")) {
            onCancel(view);
        } else if (id == this.O0000Oo0.O00000Oo("umeng_share_btn")) {
            O00000o0();
        } else if (id == this.O0000Oo0.O00000Oo("umeng_del")) {
            O00000o();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        this.O0000Oo0 = cd.O000000o((Context) this);
        this.O0000o0O = O0000Oo0.O00000o0((Context) this);
        super.onCreate(bundle);
        this.O0000Ooo = this;
        setContentView(this.O0000Oo0.O000000o("umeng_socialize_share"));
        LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.O0000o0O) {
            int[] O00000Oo = O0000Oo0.O00000Oo(this.O0000Ooo);
            attributes.width = O00000Oo[0];
            attributes.height = O00000Oo[1];
        }
        getWindow().setAttributes(attributes);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000o0.O000000o);
        stringBuilder.append(this.O00000oO);
        O0000O0o.O000000o(stringBuilder.toString());
        bundle = getIntent().getExtras();
        this.O0000o0 = O000000o(bundle.getString(ce.O0000oO0));
        if (this.O0000o0 == by.RENREN) {
            O00000o = XmPlayerService.CODE_GET_SUBJECTDETAIL;
        } else {
            O00000o = bv.O0000Oo;
        }
        this.O00000oo = bundle.getString(ce.O0000oOO);
        this.O0000OOo = bundle.getString("pic");
        this.O0000O0o = bundle.getString("title");
        O00000Oo();
        this.O0000o0o = (ImageView) findViewById(this.O0000Oo0.O00000Oo("umeng_del"));
        this.O0000Oo.addTextChangedListener(this.O00000Oo);
        ((TextView) findViewById(this.O0000Oo0.O00000Oo("umeng_title"))).setText(O00000Oo(bundle.getString(ce.O0000oO0)));
        findViewById(this.O0000Oo0.O00000Oo("umeng_back")).setOnClickListener(this);
        findViewById(this.O0000Oo0.O00000Oo("umeng_share_btn")).setOnClickListener(this);
        this.O0000o0o.setOnClickListener(this);
        this.O0000OoO = (TextView) findViewById(this.O0000Oo0.O00000Oo("umeng_socialize_share_word_num"));
        this.O0000o00 = O00000oO();
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            setResult(1000);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        this.O0000Oo.requestFocus();
        super.onResume();
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        super.onStop();
    }
}
