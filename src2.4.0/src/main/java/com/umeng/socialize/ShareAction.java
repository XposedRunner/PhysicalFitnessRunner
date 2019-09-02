package com.umeng.socialize;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.media.O0000Oo0;
import com.umeng.socialize.media.O0000o;
import com.umeng.socialize.media.O0000o0;
import com.umeng.socialize.media.O0000o00;
import com.umeng.socialize.media.O00oOooO;
import com.umeng.socialize.shareboard.O000000o;
import com.umeng.socialize.shareboard.O00000Oo;
import com.umeng.socialize.shareboard.O00000o;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.ShareBoardlistener;
import defpackage.by;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ShareAction {
    private ShareContent a = new ShareContent();
    private by b = null;
    private UMShareListener c = null;
    private ShareBoardlistener d = null;
    private Activity e;
    private List<by> f = null;
    private List<O00000o> g = new ArrayList();
    private List<ShareContent> h = new ArrayList();
    private List<UMShareListener> i = new ArrayList();
    private int j = 80;
    private View k = null;
    private O000000o l;
    private ShareBoardlistener m = new ShareBoardlistener() {
        public void O000000o(O00000o o00000o, by byVar) {
            ShareAction.this.setPlatform(byVar);
            ShareAction.this.share();
        }
    };
    private ShareBoardlistener n = new ShareBoardlistener() {
        public void O000000o(O00000o o00000o, by byVar) {
            int indexOf = ShareAction.this.f.indexOf(byVar);
            int size = ShareAction.this.h.size();
            if (size != 0) {
                ShareAction.this.a = indexOf < size ? (ShareContent) ShareAction.this.h.get(indexOf) : (ShareContent) ShareAction.this.h.get(size - 1);
            }
            size = ShareAction.this.i.size();
            if (size != 0) {
                if (indexOf < size) {
                    ShareAction.this.c = (UMShareListener) ShareAction.this.i.get(indexOf);
                } else {
                    ShareAction.this.c = (UMShareListener) ShareAction.this.i.get(size - 1);
                }
            }
            ShareAction.this.setPlatform(byVar);
            ShareAction.this.share();
        }
    };

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.e = (Activity) new WeakReference(activity).get();
        }
    }

    public static Rect locateView(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return null;
        }
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException e) {
            O0000O0o.O000000o(e);
            return null;
        }
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.g.add(by.O000000o(str, str2, str3, str4, 0));
        return this;
    }

    public void close() {
        if (this.l != null) {
            this.l.dismiss();
            this.l = null;
        }
    }

    public by getPlatform() {
        return this.b;
    }

    public ShareContent getShareContent() {
        return this.a;
    }

    public boolean getUrlValid() {
        return this.a == null || this.a.mMedia == null || !(this.a.mMedia instanceof O0000o) || this.a.mMedia.O00000o0() == null || this.a.mMedia.O00000o0().startsWith("http");
    }

    public void open() {
        open(null);
    }

    public void open(O00000Oo o00000Oo) {
        HashMap hashMap;
        if (this.g.size() != 0) {
            hashMap = new HashMap();
            hashMap.put("listener", this.c);
            hashMap.put("content", this.a);
            try {
                this.l = new O000000o(this.e, this.g, o00000Oo);
                if (this.d == null) {
                    this.l.O000000o(this.n);
                } else {
                    this.l.O000000o(this.d);
                }
                this.l.setFocusable(true);
                this.l.setBackgroundDrawable(new BitmapDrawable());
                if (this.k == null) {
                    this.k = this.e.getWindow().getDecorView();
                }
                this.l.showAtLocation(this.k, this.j, 0, 0);
                return;
            } catch (Exception e) {
                O0000O0o.O000000o(e);
                return;
            }
        }
        this.g.add(by.WEIXIN.O000000o());
        this.g.add(by.WEIXIN_CIRCLE.O000000o());
        this.g.add(by.SINA.O000000o());
        this.g.add(by.QQ.O000000o());
        hashMap = new HashMap();
        hashMap.put("listener", this.c);
        hashMap.put("content", this.a);
        this.l = new O000000o(this.e, this.g, o00000Oo);
        if (this.d == null) {
            this.l.O000000o(this.m);
        } else {
            this.l.O000000o(this.d);
        }
        this.l.setFocusable(true);
        this.l.setBackgroundDrawable(new BitmapDrawable());
        if (this.k == null) {
            this.k = this.e.getWindow().getDecorView();
        }
        this.l.showAtLocation(this.k, 80, 0, 0);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr == null || Arrays.asList(shareContentArr).size() == 0) {
            ShareContent shareContent = new ShareContent();
            shareContent.mText = "empty";
            this.h.add(shareContent);
        } else {
            this.h = Arrays.asList(shareContentArr);
        }
        return this;
    }

    public ShareAction setDisplayList(by... byVarArr) {
        this.f = Arrays.asList(byVarArr);
        this.g.clear();
        for (by O000000o : this.f) {
            this.g.add(O000000o.O000000o());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction setPlatform(by byVar) {
        this.b = byVar;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI.get(this.e).doShare(this.e, this, this.c);
    }

    public ShareAction withApp(File file) {
        this.a.app = file;
        return this;
    }

    public ShareAction withExtra(O0000Oo o0000Oo) {
        this.a.mExtra = o0000Oo;
        return this;
    }

    public ShareAction withFile(File file) {
        this.a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(O0000Oo0 o0000Oo0) {
        this.a.mMedia = o0000Oo0;
        return this;
    }

    public ShareAction withMedia(O0000Oo o0000Oo) {
        this.a.mMedia = o0000Oo;
        return this;
    }

    public ShareAction withMedia(O0000o00 o0000o00) {
        this.a.mMedia = o0000o00;
        return this;
    }

    public ShareAction withMedia(O0000o0 o0000o0) {
        this.a.mMedia = o0000o0;
        return this;
    }

    public ShareAction withMedia(O0000o o0000o) {
        this.a.mMedia = o0000o;
        return this;
    }

    public ShareAction withMedia(O00oOooO o00oOooO) {
        this.a.mMedia = o00oOooO;
        return this;
    }

    public ShareAction withMedias(O0000Oo... o0000OoArr) {
        if (o0000OoArr != null && o0000OoArr.length > 0) {
            this.a.mMedia = o0000OoArr[0];
        }
        this.a.mMedias = o0000OoArr;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i) {
        this.j = i;
        this.k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.a.mText = str;
        return this;
    }
}
