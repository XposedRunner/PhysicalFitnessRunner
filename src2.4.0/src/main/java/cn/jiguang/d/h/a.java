package cn.jiguang.d.h;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class a {
    public static b a(Context context) {
        b bVar = new b();
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                bVar.a = registerReceiver.getIntExtra("level", -1);
                bVar.b = registerReceiver.getIntExtra("scale", -1);
                switch (registerReceiver.getIntExtra("status", -1)) {
                    case 1:
                        bVar.c = 0;
                        break;
                    case 2:
                        bVar.c = 2;
                        break;
                    case 3:
                    case 4:
                        bVar.c = 1;
                        break;
                    case 5:
                        bVar.c = 3;
                        break;
                    default:
                        break;
                }
                bVar.d = registerReceiver.getIntExtra("voltage", -1);
                bVar.e = registerReceiver.getIntExtra("temperature", -1);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
