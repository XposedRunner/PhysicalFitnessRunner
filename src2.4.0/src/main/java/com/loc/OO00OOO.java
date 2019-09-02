package com.loc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILocationProviderService */
public interface OO00OOO extends IInterface {

    /* compiled from: ILocationProviderService */
    public static abstract class O000000o extends Binder implements OO00OOO {

        /* compiled from: ILocationProviderService */
        private static class O000000o implements OO00OOO {
            private IBinder O000000o;

            O000000o(IBinder iBinder) {
                this.O000000o = iBinder;
            }

            public final int O000000o(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.service.locationprovider.ILocationProviderService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.O000000o.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.O000000o;
            }
        }

        public static OO00OOO O000000o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.service.locationprovider.ILocationProviderService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OO00OOO)) ? new O000000o(iBinder) : (OO00OOO) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.amap.api.service.locationprovider.ILocationProviderService");
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                int O000000o = O000000o(bundle);
                parcel2.writeNoException();
                parcel2.writeInt(O000000o);
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.amap.api.service.locationprovider.ILocationProviderService");
                return true;
            }
        }
    }

    int O000000o(Bundle bundle) throws RemoteException;
}
