package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.zjwh.android_wh_physicalfitness.entity.ActivityTipBean;
import com.zjwh.android_wh_physicalfitness.entity.DrawWinBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SportMoodMatchBean;
import com.zjwh.android_wh_physicalfitness.view.dialog.SportMoodShareDialog;
import com.zjwh.sw.map.entity.SWFixedPoint;
import com.zjwh.sw.map.entity.SWLatLng;
import java.util.List;

/* compiled from: RunHistoryDetailContract */
/* renamed from: hk */
public class hk {

    /* compiled from: RunHistoryDetailContract */
    /* renamed from: hk$O00000Oo */
    public interface O00000Oo {
        void O000000o(double d, double d2, long j, int i, long j2, boolean z, String str, int i2, String str2, String str3, List<SWLatLng> list);

        void O000000o(int i, int i2);

        void O000000o(long j, int i, double d, double d2, long j2, int i2);

        void O000000o(DrawWinBean drawWinBean);

        void O000000o(DrawWinBean drawWinBean, boolean z);

        void O000000o(ResponseError responseError);

        void O000000o(SportMoodMatchBean sportMoodMatchBean);

        void O000000o(SWLatLng sWLatLng);

        void O000000o(SWLatLng sWLatLng, SWLatLng sWLatLng2, double d, int i, double d2, double d3, int i2);

        void O000000o(List<ActivityTipBean> list);

        void O000000o(List<SWFixedPoint> list, int i, int i2);

        void O000000o(boolean z);

        void O000000o(boolean z, boolean z2, int i, String str);

        void O00000Oo(ResponseError responseError);

        void O00000Oo(SWLatLng sWLatLng);

        void O00000oO();

        void O00000oO(String str);

        void O00000oo();

        void O0000O0o();

        void O0000OOo();

        void O0000OoO();

        void O0000o();

        void O0000o0();

        void O0000o0O();

        void O0000o0o();
    }

    /* compiled from: RunHistoryDetailContract */
    /* renamed from: hk$O000000o */
    public interface O000000o extends gy {
        void O000000o();

        void O000000o(Context context, int i, int i2);

        void O000000o(Bundle bundle);

        void O000000o(String str);

        void O000000o(String str, Context context, float f, int i);

        SportMoodShareDialog O00000Oo(String str);

        void O00000Oo();

        void O00000Oo(Bundle bundle);

        void O00000o();

        void O00000o0();

        void O00000oO();

        int O00000oo();

        int O0000O0o();

        void O0000OOo();

        void O0000Oo0();
    }
}
