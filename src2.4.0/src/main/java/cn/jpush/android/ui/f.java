package cn.jpush.android.ui;

final class f implements Runnable {
    final /* synthetic */ PushActivity a;

    f(PushActivity pushActivity) {
        this.a = pushActivity;
    }

    public final void run() {
        if (PushActivity.a(this.a) != null) {
            PushActivity.a(this.a).showTitleBar();
        }
    }
}
