package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.amap.api.mapcore.util.o0O00000;
import com.amap.api.mapcore.util.o0O0000O;
import com.amap.api.mapcore.util.o0O000o0;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.O000000o;

public class OfflineMapActivity extends AMapPermissionActivity implements OnClickListener {
    private static int a;
    private O000000o b;
    private o0O00000 c;
    private o0O00000[] d = new o0O00000[32];
    private int e = -1;
    private o0O0000O f;

    private void a(o0O00000 o0o00000) {
        try {
            if (this.b != null) {
                this.b.O00000o0();
                this.b = null;
            }
            this.b = c(o0o00000);
            if (this.b != null) {
                this.c = o0o00000;
                this.b.O000000o(this);
                this.b.O000000o(this.c.O00000Oo);
                this.b.O000000o();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            if ((a != 1 || this.b == null) && a > 1) {
                a--;
                this.e = ((this.e - 1) + 32) % 32;
                o0O00000 o0o00000 = this.d[this.e];
                o0o00000.O00000Oo = bundle;
                a(o0o00000);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private void b(o0O00000 o0o00000) {
        try {
            a++;
            a(o0o00000);
            this.e = (this.e + 1) % 32;
            this.d[this.e] = o0o00000;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private O000000o c(o0O00000 o0o00000) {
        try {
            if (o0o00000.O000000o != 1) {
                return null;
            }
            if (this.f == null) {
                this.f = new o0O0000O();
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr() {
        try {
            if (!a(null)) {
                if (this.b != null) {
                    this.b.O00000o0();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (!a(bundle)) {
                if (this.b != null) {
                    this.b.O00000o0();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onClick(View view) {
        try {
            if (this.b != null) {
                this.b.O000000o(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            o0O000o0.O000000o(getApplicationContext());
            this.e = -1;
            a = 0;
            b(new o0O00000(1, null));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        try {
            super.onDestroy();
            if (this.b != null) {
                this.b.O00000o0();
                this.b = null;
            }
            this.c = null;
            this.d = null;
            if (this.f != null) {
                this.f.O00000o0();
                this.f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.b != null && !this.b.O00000oO()) {
                    return true;
                }
                if (a(null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (a == 1) {
                        finish();
                    }
                    return false;
                }
                this.e = -1;
                a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        try {
            super.onPause();
            if (this.b != null) {
                this.b.O0000Oo0();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        try {
            super.onResume();
            if (this.b != null) {
                this.b.O0000O0o();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        try {
            super.onStart();
            if (this.b != null) {
                this.b.O00000oo();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        try {
            super.onStop();
            if (this.b != null) {
                this.b.O0000OOo();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.b.O00000Oo());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
