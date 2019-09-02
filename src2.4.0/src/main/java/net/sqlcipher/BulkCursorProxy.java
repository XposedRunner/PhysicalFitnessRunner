package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: BulkCursorNative */
final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras;
    private IBinder mRemote;

    public BulkCursorProxy(IBinder iBinder) {
    }

    public IBinder asBinder() {
        return null;
    }

    public void close() throws RemoteException {
    }

    public int count() throws RemoteException {
        return 0;
    }

    public void deactivate() throws RemoteException {
    }

    public boolean deleteRow(int i) throws RemoteException {
        return false;
    }

    public String[] getColumnNames() throws RemoteException {
        return null;
    }

    public Bundle getExtras() throws RemoteException {
        return null;
    }

    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        return false;
    }

    public CursorWindow getWindow(int i) throws RemoteException {
        return null;
    }

    public void onMove(int i) throws RemoteException {
    }

    public int requery(IContentObserver iContentObserver, CursorWindow cursorWindow) throws RemoteException {
        return 0;
    }

    public Bundle respond(Bundle bundle) throws RemoteException {
        return null;
    }

    public boolean updateRows(Map map) throws RemoteException {
        return false;
    }
}
