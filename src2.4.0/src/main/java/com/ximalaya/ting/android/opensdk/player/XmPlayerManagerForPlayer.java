package com.ximalaya.ting.android.opensdk.player;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayer;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayer.Stub;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class XmPlayerManagerForPlayer {
    private static volatile XmPlayerManagerForPlayer sInstance;
    private CopyOnWriteArrayList<IConnectListener> connectListeners = new CopyOnWriteArrayList();
    private Context mAppCtx;
    private boolean mBindRet = false;
    private ServiceConnection mConn = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            XmPlayerManagerForPlayer.this.mPlayerStub = Stub.asInterface(iBinder);
            if (XmPlayerManagerForPlayer.this.connectListeners != null) {
                Iterator it = XmPlayerManagerForPlayer.this.connectListeners.iterator();
                while (it.hasNext()) {
                    ((IConnectListener) it.next()).onConnected();
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private IXmPlayer mPlayerStub;

    public interface IConnectListener {
        void onConnected();
    }

    private XmPlayerManagerForPlayer(Context context) {
        this.mAppCtx = context.getApplicationContext();
    }

    private void addOnConnectedListerner(IConnectListener iConnectListener) {
        if (iConnectListener != null && !this.connectListeners.contains(iConnectListener)) {
            this.connectListeners.add(iConnectListener);
        }
    }

    public static XmPlayerManagerForPlayer getInstance(Context context) {
        if (sInstance == null) {
            synchronized (XmPlayerManagerForPlayer.class) {
                if (sInstance == null) {
                    sInstance = new XmPlayerManagerForPlayer(context);
                }
            }
        }
        return sInstance;
    }

    public static void release() {
        if (sInstance != null && sInstance.connectListeners != null) {
            sInstance.connectListeners.clear();
        }
    }

    public static void unBind() {
        if (sInstance != null && sInstance.mAppCtx != null && sInstance.mConn != null && sInstance.mPlayerStub != null && sInstance.mPlayerStub.asBinder() != null && sInstance.mPlayerStub.asBinder().isBinderAlive()) {
            sInstance.mAppCtx.unbindService(sInstance.mConn);
        }
    }

    public void init() {
        try {
            this.mAppCtx.startService(XmPlayerService.getIntent(this.mAppCtx));
            this.mBindRet = this.mAppCtx.bindService(XmPlayerService.getIntent(this.mAppCtx), this.mConn, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(IConnectListener iConnectListener) {
        addOnConnectedListerner(iConnectListener);
        init();
    }
}
