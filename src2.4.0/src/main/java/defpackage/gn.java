package defpackage;

import android.content.Context;
import com.zjwh.android_wh_physicalfitness.entity.AttendanceListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfo;
import java.util.List;

/* compiled from: AttendanceListContract */
/* renamed from: gn */
public class gn {

    /* compiled from: AttendanceListContract */
    /* renamed from: gn$O00000Oo */
    public interface O00000Oo {
        void O000000o(int i, int i2, String str);

        void O000000o(ResponseError responseError, int i, int i2);

        void O000000o(List<SemesterInfo> list);

        void O000000o(boolean z);

        void O000000o(boolean z, List<AttendanceListBean> list);

        void O00000Oo(ResponseError responseError, int i, int i2);

        void O00000Oo(List<SemesterInfo> list);

        void O00000o();

        void O00000oO();

        void O00000oo();

        void O0000OoO();
    }

    /* compiled from: AttendanceListContract */
    /* renamed from: gn$O000000o */
    public interface O000000o extends gy {
        void O000000o();

        void O000000o(Context context);

        void O000000o(Context context, int i);

        void O000000o(Context context, int i, int i2);

        void O000000o(SemesterInfo semesterInfo);

        int O00000Oo();

        int O00000o0();
    }
}
