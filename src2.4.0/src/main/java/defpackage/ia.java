package defpackage;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.entity.BlurDialogMsg;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.sw.map.entity.SWLatLng;
import java.util.List;

/* compiled from: BaseRunContract */
/* renamed from: ia */
public class ia {

    /* compiled from: BaseRunContract */
    /* renamed from: ia$O00000Oo */
    public interface O00000Oo {
        O0000Oo O000000o(String str, String str2, OnClickListener onClickListener);

        void O000000o(double d, double d2, float f);

        void O000000o(int i);

        void O000000o(int i, int i2);

        void O000000o(Intent intent, ServiceConnection serviceConnection);

        void O000000o(ServiceConnection serviceConnection);

        void O000000o(SWLatLng sWLatLng);

        void O000000o(SWLatLng sWLatLng, SWLatLng sWLatLng2, double d, int i, double d2, double d3, int i2);

        void O000000o(String str);

        void O000000o(String str, boolean z);

        void O000000o(List<FivePoint> list, SWLatLng sWLatLng);

        void O000000o(boolean z);

        void O000000o(boolean z, boolean z2);

        void O00000Oo(String str);

        void O00000o();

        void O00000o0(String str);

        void O00000oO();

        void O00000oO(String str);

        void O00000oo();

        void O0000O0o();

        void O0000OOo();

        void O0000Oo0();

        void O0000OoO();

        void O0000Ooo();

        void k_();
    }

    /* compiled from: BaseRunContract */
    /* renamed from: ia$O000000o */
    public interface O000000o extends gy {
        void O000000o();

        void O000000o(Bundle bundle);

        void O000000o(boolean z);

        boolean O000000o(int i);

        void O00000Oo();

        void O00000Oo(Bundle bundle);

        void O00000Oo(boolean z);

        void O00000o();

        boolean O00000o0();

        void O00000oO();

        void O00000oo();

        void O0000O0o();

        void O0000OOo();

        void O0000Oo();

        void O0000Oo0();

        SWLatLng O0000Ooo();

        boolean O0000o();

        boolean O0000o0();

        void O0000o00();

        boolean O0000o0O();

        boolean O0000o0o();

        BlurDialogMsg O0000oO();

        boolean O0000oO0();

        BroadcastReceiver O0000oOO();

        void O0000oOo();

        void O0000oo0();
    }
}
