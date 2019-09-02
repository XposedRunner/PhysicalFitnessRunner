package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public interface IXmCommonBusinessDispatcher extends IInterface {

    public static abstract class Stub extends Binder implements IXmCommonBusinessDispatcher {
        private static final String DESCRIPTOR = "com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher";
        static final int TRANSACTION_closeApp = 3;
        static final int TRANSACTION_getDownloadPlayPath = 1;
        static final int TRANSACTION_isOldTrackDownload = 2;

        private static class Proxy implements IXmCommonBusinessDispatcher {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void closeApp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDownloadPlayPath(Track track) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void isOldTrackDownload(Track track) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IXmCommonBusinessDispatcher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IXmCommonBusinessDispatcher)) ? new Proxy(iBinder) : (IXmCommonBusinessDispatcher) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Track track = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            track = (Track) Track.CREATOR.createFromParcel(parcel);
                        }
                        String downloadPlayPath = getDownloadPlayPath(track);
                        parcel2.writeNoException();
                        parcel2.writeString(downloadPlayPath);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            track = (Track) Track.CREATOR.createFromParcel(parcel);
                        }
                        isOldTrackDownload(track);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        closeApp();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void closeApp() throws RemoteException;

    String getDownloadPlayPath(Track track) throws RemoteException;

    void isOldTrackDownload(Track track) throws RemoteException;
}
