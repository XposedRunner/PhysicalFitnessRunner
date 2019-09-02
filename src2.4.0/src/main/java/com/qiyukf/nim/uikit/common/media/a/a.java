package com.qiyukf.nim.uikit.common.media.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.media.player.AudioPlayer;
import com.qiyukf.nimlib.sdk.media.player.OnPlayListener;
import com.qiyukf.unicorn.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a<T> {
    protected boolean a = true;
    protected final List<a> b = new ArrayList();
    protected Context c;
    protected AudioPlayer d;
    protected b e;
    protected boolean f = false;
    protected long g;
    protected Handler h = new Handler();
    Runnable i = new Runnable() {
        public final void run() {
            if (a.this.d == null) {
                com.qiyukf.basesdk.a.a.a("AudioRecorder", "playRunnable run when currentAudioPlayer == null");
                return;
            }
            a.this.d.start(a.this.o);
        }
    };
    private int j;
    private MediaPlayer k = null;
    private boolean l = false;
    private b m = null;
    private int n;
    private int o;

    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    public class b implements OnPlayListener {
        protected AudioPlayer a;
        protected b b;

        public b(AudioPlayer audioPlayer, b bVar) {
            this.a = audioPlayer;
            this.b = bVar;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean a() {
            return a.this.d == this.a;
        }

        public void onCompletion() {
            if (a()) {
                a.this.c();
                a.this.b(a.this.e);
                a.this.a();
            }
        }

        public void onError(String str) {
            if (a()) {
                a.this.c();
                a.this.b(a.this.e);
            }
        }

        public void onInterrupt() {
            if (a()) {
                a.this.c();
                a.this.b(a.this.e);
            }
        }

        public void onPlaying(long j) {
            if (a()) {
                a.this.h();
            }
        }

        public void onPrepared() {
            if (a()) {
                a.this.j = 2;
                if (a.this.f) {
                    a.this.f = false;
                    this.a.seekTo((int) a.this.g);
                }
            }
        }
    }

    public a(Context context) {
        this.c = context;
        this.l = true;
    }

    private void a(int i) {
        if (this.d.isPlaying()) {
            this.g = this.d.getCurrentPosition();
            this.f = true;
            this.o = i;
            this.d.start(i);
            return;
        }
        this.o = this.n;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        if (this.l) {
            this.k = MediaPlayer.create(this.c, R.raw.ysf_audio_end_tip);
            this.k.setLooping(false);
            this.k.setAudioStreamType(3);
            this.k.setOnCompletionListener(new OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    a.this.k.release();
                    a.this.k = null;
                }
            });
            this.k.start();
        }
    }

    public final void a(a aVar) {
        synchronized (this.b) {
            this.b.add(aVar);
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(b bVar) {
        this.m = new b(this.d, bVar);
        this.d.setOnPlayListener(this.m);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(b bVar, int i, boolean z, long j) {
        String b = bVar.b();
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (d()) {
            e();
            if (this.e.a(bVar)) {
                return false;
            }
        }
        this.j = 0;
        this.e = bVar;
        this.d = new AudioPlayer(this.c);
        this.d.setDataSource(b);
        a(this.e);
        if (z) {
            this.n = i;
        }
        this.o = i;
        this.h.postDelayed(this.i, j);
        this.j = 1;
        b bVar2 = this.e;
        synchronized (this.b) {
            for (a a : this.b) {
                a.a(bVar2);
            }
        }
        return true;
    }

    public final int b() {
        return this.o;
    }

    public final void b(a aVar) {
        synchronized (this.b) {
            this.b.remove(aVar);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(b bVar) {
        synchronized (this.b) {
            for (a b : this.b) {
                b.b(bVar);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void c() {
        this.d.setOnPlayListener(null);
        this.d = null;
        this.j = 0;
    }

    public final boolean d() {
        return this.d != null ? this.j == 2 || this.j == 1 : false;
    }

    public void e() {
        if (this.j == 2) {
            this.d.stop();
            return;
        }
        if (this.j == 1) {
            this.h.removeCallbacks(this.i);
            c();
            b(this.e);
        }
    }

    public final boolean f() {
        if (!d() || this.o == 0) {
            return false;
        }
        a(0);
        return true;
    }

    public final boolean g() {
        if (!d() || this.n == this.o) {
            return false;
        }
        a(this.n);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void h() {
        synchronized (this.b) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
