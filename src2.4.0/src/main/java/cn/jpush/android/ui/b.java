package cn.jpush.android.ui;

final class b implements Runnable {
    final /* synthetic */ FullScreenView a;

    b(FullScreenView fullScreenView) {
        this.a = fullScreenView;
    }

    public final void run() {
        if (this.a.mWebView != null) {
            this.a.mWebView.clearHistory();
        }
    }
}
