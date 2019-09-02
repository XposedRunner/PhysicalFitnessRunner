package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JResponse;
import cn.jpush.a.b;
import cn.jpush.a.d;
import cn.jpush.android.a;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.d.f;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.service.e;
import cn.jpush.client.android.BuildConfig;
import java.nio.ByteBuffer;

public class c implements JAction {
    public long dispatchMessage(Context context, long j, int i, Object obj, ByteBuffer byteBuffer) {
        if (!a.a(context)) {
            return -1;
        }
        JResponse aVar;
        if (i != 3) {
            if (i != 10) {
                switch (i) {
                    case 26:
                    case 27:
                        aVar = new cn.jpush.a.a(obj, byteBuffer);
                        break;
                    case 28:
                    case 29:
                        break;
                    default:
                        aVar = null;
                        break;
                }
            }
            aVar = new d(obj, byteBuffer);
        } else {
            aVar = new b(obj, byteBuffer);
        }
        if (ServiceInterface.c(context) && aVar != null && (aVar instanceof b) && ((b) aVar).a() != 20) {
            return -1;
        }
        if (aVar != null) {
            StringBuilder stringBuilder = new StringBuilder("response:");
            stringBuilder.append(aVar.toString());
            f.a("JPushDataAction", stringBuilder.toString());
            int command = aVar.getCommand();
            if (command == 3) {
                return k.a(a.e, j, aVar);
            }
            if (command != 10) {
                switch (command) {
                    case 26:
                        g.a().a(context, aVar.getRid().longValue(), aVar.code);
                        break;
                    case 27:
                        if (aVar.code != 0) {
                            cn.jpush.android.c.a.a().a(context, aVar.getRid().longValue(), aVar.code);
                            break;
                        }
                        cn.jpush.android.c.a.a().a(context, aVar.getRid().longValue());
                        break;
                    case 28:
                    case 29:
                        return n.a(context, ((d) aVar).a(), aVar.getCommand() == 28 ? 1 : 2, aVar.getRid().longValue());
                }
            }
        }
        return aVar != null ? aVar.getRid().longValue() : -1;
    }

    public void dispatchTimeOutMessage(Context context, long j, long j2, int i) {
        if (a.a(context)) {
            if (i != 10) {
                switch (i) {
                    case 26:
                        g.a().a(context, j2, cn.jpush.android.api.b.c);
                        return;
                    case 27:
                        cn.jpush.android.c.a.a().b(context, j2);
                        return;
                    case 28:
                    case 29:
                        break;
                    default:
                        return;
                }
            }
            f.a(context).a(j2, cn.jpush.android.api.b.c);
        }
    }

    public IBinder getBinderByType(String str) {
        return null;
    }

    public String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public void handleMessage(Context context, long j, Object obj) {
        if (a.a(context) && obj != null) {
            if (obj instanceof Bundle) {
                e.a(context);
                Bundle bundle = (Bundle) obj;
                if (bundle != null) {
                    bundle.getInt("what");
                }
            } else if (obj instanceof Intent) {
                String str;
                String str2;
                cn.jpush.android.service.d.a();
                Intent intent = (Intent) obj;
                if (intent == null) {
                    str = "PushReceiverCore";
                    str2 = "Received null intent broadcast. Give up processing.";
                } else {
                    try {
                        str2 = intent.getAction();
                        StringBuilder stringBuilder = new StringBuilder("onReceive - ");
                        stringBuilder.append(str2);
                        f.a("PushReceiverCore", stringBuilder.toString());
                        if (a.a(context.getApplicationContext()) && str2 != null) {
                            if (JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID.equals(str2)) {
                                cn.jpush.android.c.d.a().b(context, intent.getExtras());
                                return;
                            } else if (str2.startsWith(JPushInterface.ACTION_NOTIFICATION_RECEIVED_PROXY)) {
                                try {
                                    if (!ServiceInterface.d(context)) {
                                        intent.getIntExtra("notificaion_type", 0);
                                        str2 = intent.getStringExtra("message");
                                        if (TextUtils.isEmpty(str2)) {
                                            f.c("PushReceiverCore", "Got an empty notification, don't show it!");
                                            return;
                                        }
                                        cn.jpush.android.data.a a = i.a(context, str2, intent.getStringExtra("appId"), intent.getStringExtra("senderId"), intent.getStringExtra(JThirdPlatFormInterface.KEY_MSG_ID));
                                        if (a != null) {
                                            a.i = true;
                                            i.a(context, a);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            } else {
                                if (!str2.equals("android.intent.action.PACKAGE_ADDED")) {
                                    if (str2.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
                                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                                        if (!(networkInfo == null || 2 == networkInfo.getType() || 3 == networkInfo.getType() || intent.getBooleanExtra("noConnectivity", false) || State.CONNECTED == networkInfo.getState())) {
                                            State state = State.DISCONNECTED;
                                            networkInfo.getState();
                                            return;
                                        }
                                    } else if (str2.startsWith("cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY")) {
                                        cn.jpush.android.service.d.a(context, intent);
                                        return;
                                    } else if (str2.startsWith("cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY")) {
                                        StringBuilder stringBuilder2;
                                        try {
                                            Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
                                            intent2.putExtras(intent.getExtras());
                                            intent2.addCategory(context.getPackageName());
                                            intent2.setPackage(context.getPackageName());
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append(context.getPackageName());
                                            stringBuilder2.append(".permission.JPUSH_MESSAGE");
                                            context.sendBroadcast(intent2, stringBuilder2.toString());
                                            return;
                                        } catch (Throwable th) {
                                            stringBuilder2 = new StringBuilder("Click notification sendBroadcast :");
                                            stringBuilder2.append(th.getMessage());
                                            f.c("PushReceiverCore", stringBuilder2.toString());
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        return;
                    } catch (NullPointerException unused) {
                        str = "PushReceiverCore";
                        str2 = "Received no action intent broadcast. Give up processing.";
                    }
                }
                f.c(str, str2);
            } else {
                f.a("JPushDataAction", "handleMessage unknown object ");
            }
        }
    }

    public boolean isSupportedCMD(int i) {
        return i == 3 || i == 10 || i == 27 || i == 28 || i == 29 || i == 26;
    }

    public void onActionRun(Context context, long j, Bundle bundle, Object obj) {
        f.a("JPushDataAction", "Action - onActionRun");
        if (a.a(context)) {
            e.a(context).a(bundle, (Handler) obj);
        }
    }

    public void onEvent(Context context, long j, int i) {
        if (!a.a(context)) {
            return;
        }
        if (i != 19) {
            switch (i) {
                case 0:
                    break;
                case 1:
                    cn.jpush.android.c.d.a().f(context);
                    break;
                default:
                    return;
            }
            return;
        }
        e.a(context).a();
    }
}
