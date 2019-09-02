package com.zjwh.android_wh_physicalfitness.view.WebView;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000Oo;

/* compiled from: VideoEnabledWebChromeClient */
public class O000000o extends WebChromeClient implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private View O000000o;
    private ViewGroup O00000Oo;
    private VideoEnabledWebView O00000o;
    private View O00000o0;
    private boolean O00000oO;
    private FrameLayout O00000oo;
    private CustomViewCallback O0000O0o;
    private O000000o O0000OOo;

    /* compiled from: VideoEnabledWebChromeClient */
    public interface O000000o {
        void O000000o(boolean z);
    }

    public O000000o(View view, ViewGroup viewGroup) {
        this.O000000o = view;
        this.O00000Oo = viewGroup;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oO = false;
    }

    public O000000o(View view, ViewGroup viewGroup, View view2) {
        this.O000000o = view;
        this.O00000Oo = viewGroup;
        this.O00000o0 = view2;
        this.O00000o = null;
        this.O00000oO = false;
    }

    public O000000o(View view, ViewGroup viewGroup, View view2, VideoEnabledWebView videoEnabledWebView) {
        this.O000000o = view;
        this.O00000Oo = viewGroup;
        this.O00000o0 = view2;
        this.O00000o = videoEnabledWebView;
        this.O00000oO = false;
    }

    public void O000000o(O000000o o000000o) {
        this.O0000OOo = o000000o;
    }

    public boolean O000000o() {
        return this.O00000oO;
    }

    public boolean O00000Oo() {
        if (!this.O00000oO) {
            return false;
        }
        onHideCustomView();
        return true;
    }

    public View getVideoLoadingProgressView() {
        if (this.O00000o0 == null) {
            return super.getVideoLoadingProgressView();
        }
        this.O00000o0.setVisibility(0);
        return this.O00000o0;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    public void onHideCustomView() {
        if (this.O00000oO) {
            this.O00000Oo.setVisibility(4);
            this.O00000Oo.removeView(this.O00000oo);
            this.O000000o.setVisibility(0);
            if (!(this.O0000O0o == null || this.O0000O0o.getClass().getName().contains(".chromium."))) {
                this.O0000O0o.onCustomViewHidden();
            }
            this.O00000oO = false;
            this.O00000oo = null;
            this.O0000O0o = null;
            if (this.O0000OOo != null) {
                this.O0000OOo.O000000o(false);
            }
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.O00000o0 != null) {
            this.O00000o0.setVisibility(8);
        }
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();
            this.O00000oO = true;
            this.O00000oo = frameLayout;
            this.O0000O0o = customViewCallback;
            this.O000000o.setVisibility(4);
            this.O00000Oo.addView(this.O00000oo, new LayoutParams(-1, -1));
            this.O00000Oo.setVisibility(0);
            if (focusedChild instanceof VideoView) {
                VideoView videoView = (VideoView) focusedChild;
                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
            } else if (this.O00000o != null && this.O00000o.getSettings().getJavaScriptEnabled() && (focusedChild instanceof SurfaceView)) {
                String str = O00000Oo.O0000Oo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("var _ytrp_html5_video_last;");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("var _ytrp_html5_video = document.getElementsByTagName('video')[0];");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("_ytrp_html5_video_last = _ytrp_html5_video;");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("function _ytrp_html5_video_ended() {");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("_VideoEnabledWebView.notifyVideoEnd();");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("}");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);");
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("}");
                this.O00000o.loadUrl(stringBuilder.toString());
            }
            if (this.O0000OOo != null) {
                this.O0000OOo.O000000o(true);
            }
        }
    }
}
