package com.umeng.socialize.media;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O00000o0;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000OOo;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity;
import defpackage.bq;
import defpackage.db;
import java.io.File;

/* compiled from: SimpleShareContent */
public class O00000o {
    private O0000Oo O000000o;
    public int O00000Oo = 24576;
    public int O00000o = 131072;
    public int O00000o0 = 18432;
    public final int O00000oO = 491520;
    public final String O00000oo = "这里是标题";
    public final String O0000O0o = "这里是描述";
    private O0000Oo[] O0000OOo;
    private O0000o0 O0000Oo;
    private String O0000Oo0;
    private O0000Oo0 O0000OoO;
    private O00oOooO O0000Ooo;
    private int O0000o;
    private O0000o O0000o0;
    private O0000o00 O0000o00;
    private File O0000o0O;
    private O000000o O0000o0o;
    private String O0000oO;
    private String O0000oO0;
    private CompressListener O0000oOO;

    public O00000o(ShareContent shareContent) {
        this.O0000Oo0 = shareContent.mText;
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O0000Oo)) {
            this.O000000o = (O0000Oo) shareContent.mMedia;
            this.O0000o0o = this.O000000o;
            if (shareContent.mMedias != null && shareContent.mMedias.length > 0) {
                this.O0000OOo = shareContent.mMedias;
            }
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O00oOooO)) {
            this.O0000Ooo = (O00oOooO) shareContent.mMedia;
            this.O0000o0o = this.O0000Ooo;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O0000o0)) {
            this.O0000Oo = (O0000o0) shareContent.mMedia;
            this.O0000o0o = this.O0000Oo;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O0000Oo0)) {
            this.O0000OoO = (O0000Oo0) shareContent.mMedia;
            this.O0000o0o = this.O0000OoO;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O0000o)) {
            this.O0000o0 = (O0000o) shareContent.mMedia;
            this.O0000o0o = this.O0000o0;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof O0000o00)) {
            this.O0000o00 = (O0000o00) shareContent.mMedia;
            this.O0000o0o = this.O0000o0;
        }
        if (shareContent.file != null) {
            this.O0000o0O = shareContent.file;
        }
        this.O0000oO = shareContent.subject;
        this.O0000o = shareContent.getShareType();
        this.O0000oO0 = O000000o();
    }

    private String O000000o() {
        int i = this.O0000o;
        if (i == 8) {
            return "video";
        }
        if (i == 16) {
            return "web";
        }
        if (i == 32) {
            return "file";
        }
        if (i == 64) {
            return "emoji";
        }
        if (i == 128) {
            return "minapp";
        }
        switch (i) {
            case 1:
                return ArticleDetailActivity.O00000o;
            case 2:
                return db.O000Ooo;
            case 3:
                return "textandimage";
            case 4:
                return "music";
            default:
                return "error";
        }
    }

    private byte[] O00000Oo() {
        byte[] O000000o = O00000o0.O000000o();
        if (O00000Oo.O00000o0() != 0) {
            O000000o = bq.O000000o(new O0000Oo(O00000Oo.O000000o(), O00000Oo.O00000o0()), this.O00000o0);
            if (O000000o == null || O000000o.length <= 0) {
                O0000O0o.O000000o(O0000OOo.O0000OoO);
            }
        }
        return O000000o;
    }

    public String O000000o(O000000o o000000o) {
        if (TextUtils.isEmpty(o000000o.O00000oo())) {
            return "这里是标题";
        }
        String O00000oo = o000000o.O00000oo();
        if (O00000oo.length() > 512) {
            O00000oo = O00000oo.substring(0, 512);
        }
        return O00000oo;
    }

    public String O000000o(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "这里是描述";
        }
        if (str.length() > i) {
            str = str.substring(0, i);
        }
        return str;
    }

    public void O000000o(CompressListener compressListener) {
        this.O0000oOO = compressListener;
    }

    public void O000000o(O0000Oo o0000Oo) {
        this.O000000o = o0000Oo;
    }

    public void O000000o(O0000o0 o0000o0) {
        this.O0000Oo = o0000o0;
    }

    public void O000000o(O00oOooO o00oOooO) {
        this.O0000Ooo = o00oOooO;
    }

    public void O000000o(String str) {
        this.O0000Oo0 = str;
    }

    public String O00000Oo(O000000o o000000o) {
        if (TextUtils.isEmpty(o000000o.O000000o())) {
            return "这里是描述";
        }
        String O000000o = o000000o.O000000o();
        if (O000000o.length() > XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE) {
            O000000o = O000000o.substring(0, XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
        }
        return O000000o;
    }

    public String O00000Oo(O00oOooO o00oOooO) {
        return TextUtils.isEmpty(o00oOooO.O0000Oo()) ? o00oOooO.O00000o0() : o00oOooO.O0000Oo();
    }

    public String O00000Oo(String str) {
        return O000000o(str, 10240);
    }

    public String O00000Oo(String str, int i) {
        return (!TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public byte[] O00000Oo(O0000Oo o0000Oo) {
        if (o0000Oo.O00000o() == null) {
            return O00000Oo();
        }
        byte[] O000000o = bq.O000000o(o0000Oo.O00000o(), this.O00000o0);
        if (O000000o == null || O000000o.length <= 0) {
            O0000O0o.O000000o(O0000OOo.O0000OoO);
            O000000o = O00000Oo();
        }
        return O000000o;
    }

    public File O00000o() {
        return this.O0000o0O;
    }

    public byte[] O00000o(O000000o o000000o) {
        if (o000000o.O00000o() == null) {
            return O00000o0.O000000o();
        }
        byte[] O0000o00;
        if (this.O0000oOO != null) {
            O0000Oo O00000o = o000000o.O00000o();
            if (O00000o == null) {
                return O00000o0.O000000o();
            }
            O0000o00 = O00000o.O0000o00();
            if (O0000o00 == null || bq.O000000o(O00000o) > this.O00000o) {
                O0000o00 = this.O0000oOO.O000000o(O0000o00);
            }
        } else {
            O0000o00 = bq.O000000o(o000000o.O00000o().O0000o00(), this.O00000o, CompressFormat.JPEG);
            if (O0000o00 == null || O0000o00.length <= 0) {
                O0000O0o.O000000o(O0000OOo.O0000OoO);
            }
        }
        return O0000o00;
    }

    public byte[] O00000o(O0000Oo o0000Oo) {
        if (O00000oO(o0000Oo) <= 491520) {
            return O00000o0(o0000Oo);
        }
        byte[] O000000o = bq.O000000o(O0000o0(), 491520);
        if (O000000o != null && O000000o.length > 0) {
            return O000000o;
        }
        O0000O0o.O000000o(O0000OOo.O0000OoO);
        return null;
    }

    public byte[] O00000o0(O000000o o000000o) {
        if (o000000o.O00000o() == null) {
            return O00000Oo();
        }
        byte[] O0000o00;
        if (this.O0000oOO != null) {
            O0000Oo O00000o = o000000o.O00000o();
            if (O00000o == null) {
                return O00000o0.O000000o();
            }
            O0000o00 = O00000o.O0000o00();
            if (O0000o00 == null || bq.O000000o(O00000o) > this.O00000Oo) {
                O0000o00 = this.O0000oOO.O000000o(O0000o00);
            }
        } else {
            O0000o00 = bq.O000000o(o000000o.O00000o(), this.O00000Oo);
            if (O0000o00 == null || O0000o00.length <= 0) {
                O0000O0o.O000000o(O0000OOo.O0000OoO);
                O0000o00 = O00000Oo();
            }
        }
        return O0000o00;
    }

    public byte[] O00000o0(O0000Oo o0000Oo) {
        return o0000Oo.O0000o00();
    }

    public int O00000oO(O0000Oo o0000Oo) {
        return bq.O000000o(o0000Oo);
    }

    public O0000Oo0 O00000oO() {
        return this.O0000OoO;
    }

    public O000000o O00000oo() {
        return this.O0000o0o;
    }

    public boolean O00000oo(O0000Oo o0000Oo) {
        return o0000Oo.O0000OoO() != null;
    }

    public String O0000O0o() {
        return this.O0000oO;
    }

    public String O0000OOo() {
        return TextUtils.isEmpty(this.O0000oO) ? "umengshare" : this.O0000oO;
    }

    public int O0000Oo() {
        return this.O0000o;
    }

    public String O0000Oo0() {
        return this.O0000oO0;
    }

    public O0000o O0000OoO() {
        return this.O0000o0;
    }

    public O0000o00 O0000Ooo() {
        return this.O0000o00;
    }

    public O0000o0 O0000o() {
        return this.O0000Oo;
    }

    public O0000Oo O0000o0() {
        return this.O000000o;
    }

    public String O0000o00() {
        return this.O0000Oo0;
    }

    public O0000Oo[] O0000o0O() {
        return this.O0000OOo;
    }

    public O00oOooO O0000o0o() {
        return this.O0000Ooo;
    }
}
