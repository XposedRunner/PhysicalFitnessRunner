package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IComOpenClient extends IInterface {

    public static abstract class a extends Binder implements IComOpenClient {

        private static class a implements IComOpenClient {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean a(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static IComOpenClient a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IComOpenClient)) ? new a(iBinder) : (IComOpenClient) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String a;
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                        a = a(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 2:
                        parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                        boolean a2 = a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(a2);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            a = "com.baidu.mapframework.open.aidl.IComOpenClient";
            parcel2.writeString(a);
            return true;
        }
    }

    String a(String str) throws RemoteException;

    boolean a(String str, String str2, Bundle bundle) throws RemoteException;
}
