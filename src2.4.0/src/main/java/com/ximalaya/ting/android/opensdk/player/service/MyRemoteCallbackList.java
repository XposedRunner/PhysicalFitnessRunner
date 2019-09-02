package com.ximalaya.ting.android.opensdk.player.service;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.util.Log;

public class MyRemoteCallbackList<T extends IInterface> extends RemoteCallbackList<T> {
    private static final String TAG = "XmPlayerService";

    static class ProcessCookie {
        private int pid;
        private int uid;

        public ProcessCookie(int i, int i2) {
            this.pid = i;
            this.uid = i2;
        }

        public int getPid() {
            return this.pid;
        }

        public int getUid() {
            return this.uid;
        }

        public void setPid(int i) {
            this.pid = i;
        }

        public void setUid(int i) {
            this.uid = i;
        }
    }

    public void onCallbackDied(T t, Object obj) {
        super.onCallbackDied(t, obj);
        unregister(t);
        if (obj != null && (obj instanceof ProcessCookie)) {
            ProcessCookie processCookie = (ProcessCookie) obj;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Process ");
            stringBuilder.append(processCookie.getPid());
            stringBuilder.append(" died");
            Log.e(str, stringBuilder.toString());
        }
    }
}
