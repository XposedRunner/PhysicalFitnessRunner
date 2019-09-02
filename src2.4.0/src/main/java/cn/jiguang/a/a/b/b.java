package cn.jiguang.a.a.b;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

final class b extends PhoneStateListener {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        this.a.h = signalStrength.getGsmSignalStrength();
        try {
            this.a.f();
        } catch (Throwable th) {
            this.a.e();
            this.a.d();
        }
        this.a.e();
        this.a.d();
    }
}
