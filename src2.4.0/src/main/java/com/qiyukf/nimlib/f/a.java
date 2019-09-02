package com.qiyukf.nimlib.f;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import java.io.Serializable;

public class a {
    public static Message a(int i, Object obj) {
        Message obtain = Message.obtain(null, i);
        if (obj != null) {
            Bundle bundle = new Bundle();
            if (obj instanceof Parcelable) {
                bundle.putParcelable("IPC", (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable("IPC", (Serializable) obj);
            }
            obtain.setData(bundle);
        }
        return obtain;
    }

    public static <T extends Parcelable> T a(Message message) {
        message.getData().setClassLoader(a.class.getClassLoader());
        return message.getData().getParcelable("IPC");
    }

    public static Serializable b(Message message) {
        message.getData().setClassLoader(a.class.getClassLoader());
        return message.getData().getSerializable("IPC");
    }
}
