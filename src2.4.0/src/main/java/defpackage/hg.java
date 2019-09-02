package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.mine.ClassBean;
import java.util.List;

/* compiled from: ChangeClassContract */
/* renamed from: hg */
public class hg {

    /* compiled from: ChangeClassContract */
    /* renamed from: hg$O00000Oo */
    public interface O00000Oo {
        void O000000o(Intent intent);

        void O000000o(ResponseError responseError);

        void O000000o(String str);

        void O000000o(List<ClassBean> list);

        void O00000o();

        void O00000oO();

        void O00000oo();
    }

    /* compiled from: ChangeClassContract */
    /* renamed from: hg$O000000o */
    public interface O000000o extends gy {
        void O000000o(Context context);

        void O000000o(Context context, ClassBean classBean);

        void O000000o(Bundle bundle);

        void O000000o(ClassBean classBean);

        void O00000Oo(Bundle bundle);
    }
}
