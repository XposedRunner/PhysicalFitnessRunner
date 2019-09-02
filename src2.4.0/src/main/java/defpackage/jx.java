package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.BatchAlbumList;
import com.ximalaya.ting.android.opensdk.model.pay.BoughtStatuList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.ximalaya.ting.android.xmpayordersdk.O00000Oo;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicSwitchEvt;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.music.MusicOrderBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hp.O000000o;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: AlbumListPImpl */
/* renamed from: jx */
public class jx extends iu<O00000Oo> implements O000000o {
    private int O000000o;
    private int O00000Oo;
    private long O00000o;
    private long O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;
    private List<Track> O0000OOo;

    /* compiled from: AlbumListPImpl */
    /* renamed from: jx$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ long O00000Oo;
        final /* synthetic */ jx O00000o0;

        /* compiled from: AlbumListPImpl */
        /* renamed from: jx$1$1 */
        class 1 implements com.ximalaya.ting.android.xmpayordersdk.O000000o {
            final /* synthetic */ MusicOrderBean O000O0Oo;
            final /* synthetic */ 1 O00oOoOo;

            /* compiled from: AlbumListPImpl */
            /* renamed from: jx$1$1$1 */
            class 1 implements IDataCallBack<BoughtStatuList> {
                final /* synthetic */ 1 O000000o;

                1(1 1) {
                }

                public void O000000o(@Nullable BoughtStatuList boughtStatuList) {
                }

                public void onError(int i, String str) {
                }

                public /* synthetic */ void onSuccess(@Nullable Object obj) {
                }
            }

            1(1 1, MusicOrderBean musicOrderBean) {
            }

            public void O000000o(O00000Oo o00000Oo) {
            }
        }

        1(jx jxVar, Context context, long j) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
        }
    }

    /* compiled from: AlbumListPImpl */
    /* renamed from: jx$2 */
    class 2 implements IDataCallBack<BatchAlbumList> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ long O00000Oo;
        final /* synthetic */ jx O00000o0;

        2(jx jxVar, Context context, long j) {
        }

        public void O000000o(@Nullable BatchAlbumList batchAlbumList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    /* compiled from: AlbumListPImpl */
    /* renamed from: jx$3 */
    class 3 implements IDataCallBack<TrackList> {
        final /* synthetic */ jx O000000o;

        3(jx jxVar) {
        }

        public void O000000o(@Nullable TrackList trackList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    /* compiled from: AlbumListPImpl */
    /* renamed from: jx$4 */
    class 4 implements IDataCallBack<TrackList> {
        final /* synthetic */ jx O000000o;

        4(jx jxVar) {
        }

        public void O000000o(@Nullable TrackList trackList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    public jx(O00000Oo o00000Oo) {
    }

    private void O000000o(Context context, long j, double d) {
    }

    private void O000000o(TrackList trackList) {
    }

    static /* synthetic */ void O000000o(jx jxVar, Context context, long j, double d) {
    }

    private void O0000O0o() {
    }

    private void O0000OOo() {
    }

    public int O000000o(MusicSwitchEvt musicSwitchEvt) {
        return 0;
    }

    public List<Track> O000000o() {
        return null;
    }

    public void O000000o(int i) {
    }

    public void O000000o(Context context, long j) {
    }

    public void O000000o(Bundle bundle) {
    }

    public void O000000o(boolean z) {
    }

    public void O00000Oo(Bundle bundle) {
    }

    public boolean O00000Oo() {
        return false;
    }

    public long O00000o() {
        return 0;
    }

    public boolean O00000o0() {
        return false;
    }

    public int O00000oO() {
        return 0;
    }

    public int O00000oo() {
        return 0;
    }
}
