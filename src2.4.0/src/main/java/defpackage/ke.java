package defpackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;
import defpackage.hu.O000000o;
import defpackage.hu.O00000Oo;

/* compiled from: MusicSearchPImpl */
/* renamed from: ke */
public class ke extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "extra_search_music_type";
    public static final int O00000Oo = 1;
    public static final int O00000o = 2;
    private int O00000oO;
    private int O00000oo;
    private boolean O0000O0o;
    private String O0000OOo;

    /* compiled from: MusicSearchPImpl */
    /* renamed from: ke$1 */
    class 1 implements IDataCallBack<SearchAlbumList> {
        final /* synthetic */ ke O000000o;

        1(ke keVar) {
        }

        public void O000000o(@Nullable SearchAlbumList searchAlbumList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    /* compiled from: MusicSearchPImpl */
    /* renamed from: ke$2 */
    class 2 implements IDataCallBack<AlbumList> {
        final /* synthetic */ ke O000000o;

        2(ke keVar) {
        }

        public void O000000o(@Nullable AlbumList albumList) {
        }

        public void onError(int i, String str) {
        }

        public /* synthetic */ void onSuccess(@Nullable Object obj) {
        }
    }

    public ke(O00000Oo o00000Oo) {
    }

    private void O000000o(XimalayaResponse ximalayaResponse) {
    }

    static /* synthetic */ void O000000o(ke keVar, XimalayaResponse ximalayaResponse) {
    }

    private void O00000Oo() {
    }

    private void O00000o() {
    }

    private void O00000o0() {
    }

    public void O000000o() {
    }

    public void O000000o(Bundle bundle) {
    }

    public void O000000o(String str) {
    }

    public void O000000o(boolean z) {
    }

    public void O00000Oo(Bundle bundle) {
    }
}
