package defpackage;

import android.content.Context;
import com.zjwh.sw.map.entity.RunPeopleBean;
import com.zjwh.sw.map.entity.SWLatLng;
import java.util.List;

/* compiled from: CheatReportContract */
/* renamed from: gp */
public class gp {

    /* compiled from: CheatReportContract */
    /* renamed from: gp$O00000Oo */
    public interface O00000Oo {
        void O000000o(int i, boolean z);

        void O000000o(String str);

        void O000000o(String str, String str2);

        void O000000o(List<RunPeopleBean> list);

        void O00000Oo(String str);

        void O00000Oo(List<SWLatLng> list);

        void O00000o();

        void O00000o0(String str);

        void O00000oO();
    }

    /* compiled from: CheatReportContract */
    /* renamed from: gp$O000000o */
    public interface O000000o extends gy {
        RunPeopleBean O000000o();

        void O000000o(int i);

        void O000000o(int i, Context context);

        void O000000o(Context context);

        void O000000o(Context context, double d, double d2, double d3, double d4);

        void O000000o(Context context, String str, int i, int i2);

        List<RunPeopleBean> O00000Oo();

        void O00000o();

        List<SWLatLng> O00000o0();
    }
}
