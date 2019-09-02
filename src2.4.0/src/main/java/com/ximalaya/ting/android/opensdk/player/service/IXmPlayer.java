package com.ximalaya.ting.android.opensdk.player.service;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.statistic.RecordModel;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import java.util.List;
import java.util.Map;

public interface IXmPlayer extends IInterface {

    public static abstract class Stub extends Binder implements IXmPlayer {
        private static final String DESCRIPTOR = "com.ximalaya.ting.android.opensdk.player.service.IXmPlayer";
        static final int TRANSACTION_addPlayList = 28;
        static final int TRANSACTION_browseAlbums = 52;
        static final int TRANSACTION_clearPlayCache = 33;
        static final int TRANSACTION_exitSoundAd = 110;
        static final int TRANSACTION_getAlbumByCategoryId = 69;
        static final int TRANSACTION_getAlbumByCategoryIdAndTag = 85;
        static final int TRANSACTION_getAlbumInfo = 64;
        static final int TRANSACTION_getAttentionAlbum = 63;
        static final int TRANSACTION_getCategoriesList = 84;
        static final int TRANSACTION_getCategoryModelList = 56;
        static final int TRANSACTION_getCurPlayUrl = 46;
        static final int TRANSACTION_getCurrIndex = 14;
        static final int TRANSACTION_getCurrentTrackPlayedDuration = 116;
        static final int TRANSACTION_getDefultPageSize = 68;
        static final int TRANSACTION_getDuration = 15;
        static final int TRANSACTION_getHistoryPos = 98;
        static final int TRANSACTION_getHotContent = 57;
        static final int TRANSACTION_getLastPlayTrackInAlbum = 100;
        static final int TRANSACTION_getMainHotContent = 66;
        static final int TRANSACTION_getMyCollect = 62;
        static final int TRANSACTION_getNewRank = 67;
        static final int TRANSACTION_getNextPlayList = 41;
        static final int TRANSACTION_getParam = 31;
        static final int TRANSACTION_getParseDeviceInfo = 70;
        static final int TRANSACTION_getPlayCurrPosition = 16;
        static final int TRANSACTION_getPlayList = 30;
        static final int TRANSACTION_getPlayListOrder = 45;
        static final int TRANSACTION_getPlayListSize = 32;
        static final int TRANSACTION_getPlayMode = 25;
        static final int TRANSACTION_getPlaySourceType = 23;
        static final int TRANSACTION_getPlayerStatus = 13;
        static final int TRANSACTION_getPrePlayList = 42;
        static final int TRANSACTION_getProvinces = 81;
        static final int TRANSACTION_getRadio = 22;
        static final int TRANSACTION_getRadioList = 82;
        static final int TRANSACTION_getRadioSchedules = 83;
        static final int TRANSACTION_getRank = 65;
        static final int TRANSACTION_getRecommendAlbumListByAlbumId = 80;
        static final int TRANSACTION_getRecommendAlbumListByTrackId = 79;
        static final int TRANSACTION_getSourseLists = 51;
        static final int TRANSACTION_getSpecialListenList = 75;
        static final int TRANSACTION_getSubjectDetail = 76;
        static final int TRANSACTION_getSuggestAlbums = 74;
        static final int TRANSACTION_getTags = 86;
        static final int TRANSACTION_getTempo = 117;
        static final int TRANSACTION_getTrack = 21;
        static final int TRANSACTION_getTrackDetailInfo = 87;
        static final int TRANSACTION_getTrackInfoSync = 88;
        static final int TRANSACTION_getTrackListByLastTrack = 58;
        static final int TRANSACTION_getTrackListByTrackIdAtAlbum = 78;
        static final int TRANSACTION_getUserInfo = 61;
        static final int TRANSACTION_hasNextSound = 12;
        static final int TRANSACTION_hasPreSound = 11;
        static final int TRANSACTION_haveNextPlayList = 106;
        static final int TRANSACTION_havePrePlayList = 107;
        static final int TRANSACTION_init = 47;
        static final int TRANSACTION_insertPlayListHead = 115;
        static final int TRANSACTION_isAdPlaying = 105;
        static final int TRANSACTION_isAdsActive = 18;
        static final int TRANSACTION_isBuffering = 108;
        static final int TRANSACTION_isDLNAState = 72;
        static final int TRANSACTION_isLoading = 112;
        static final int TRANSACTION_isOnlineSource = 10;
        static final int TRANSACTION_isPlaying = 17;
        static final int TRANSACTION_needContinuePlay = 73;
        static final int TRANSACTION_pausePlay = 7;
        static final int TRANSACTION_pausePlayInMillis = 104;
        static final int TRANSACTION_permutePlayList = 44;
        static final int TRANSACTION_play = 4;
        static final int TRANSACTION_playNext = 3;
        static final int TRANSACTION_playPre = 2;
        static final int TRANSACTION_playRadio = 29;
        static final int TRANSACTION_registeAdsListener = 38;
        static final int TRANSACTION_registeCommonBusinessListener = 40;
        static final int TRANSACTION_registeCustomDataCallBack = 48;
        static final int TRANSACTION_registeMainDataSupportCallBack = 59;
        static final int TRANSACTION_registePlayerListener = 36;
        static final int TRANSACTION_removeListByIndex = 97;
        static final int TRANSACTION_requestSoundAd = 103;
        static final int TRANSACTION_resetPlayList = 96;
        static final int TRANSACTION_resetPlayer = 113;
        static final int TRANSACTION_seekTo = 9;
        static final int TRANSACTION_setAdsDataHandlerClassName = 94;
        static final int TRANSACTION_setAppSecret = 35;
        static final int TRANSACTION_setAppkeyAndPackId = 118;
        static final int TRANSACTION_setBreakpointResume = 111;
        static final int TRANSACTION_setCategoryId = 55;
        static final int TRANSACTION_setCheckAdContent = 114;
        static final int TRANSACTION_setDLNAState = 71;
        static final int TRANSACTION_setHistoryPosById = 99;
        static final int TRANSACTION_setNotification = 34;
        static final int TRANSACTION_setPageSize = 26;
        static final int TRANSACTION_setPlayByAlbumTracks = 54;
        static final int TRANSACTION_setPlayByTrack = 53;
        static final int TRANSACTION_setPlayCdnConfigureModel = 95;
        static final int TRANSACTION_setPlayIndex = 5;
        static final int TRANSACTION_setPlayList = 27;
        static final int TRANSACTION_setPlayListChangeListener = 43;
        static final int TRANSACTION_setPlayMode = 24;
        static final int TRANSACTION_setPlayModel = 50;
        static final int TRANSACTION_setPlayStatisticClassName = 93;
        static final int TRANSACTION_setPlayerProcessRequestEnvironment = 101;
        static final int TRANSACTION_setProxy = 1;
        static final int TRANSACTION_setProxyNew = 109;
        static final int TRANSACTION_setRecordModel = 91;
        static final int TRANSACTION_setSoundTouchAllParams = 102;
        static final int TRANSACTION_setTokenInvalidForSDK = 89;
        static final int TRANSACTION_setTokenToPlayForSDK = 90;
        static final int TRANSACTION_setVolume = 92;
        static final int TRANSACTION_startPlay = 6;
        static final int TRANSACTION_stopPlay = 8;
        static final int TRANSACTION_subscribeAlbum = 77;
        static final int TRANSACTION_unregisteAdsListener = 39;
        static final int TRANSACTION_unregisteCustomDataCallBack = 49;
        static final int TRANSACTION_unregisteMainDataSupportCallBack = 60;
        static final int TRANSACTION_unregistePlayerListener = 37;
        static final int TRANSACTION_updateTrackDownloadUrlInPlayList = 19;
        static final int TRANSACTION_updateTrackInPlayList = 20;

        private static class Proxy implements IXmPlayer {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void addPlayList(List<Track> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void browseAlbums(long j, int i, int i2, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j2);
                    this.mRemote.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearPlayCache() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void exitSoundAd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(110, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAlbumByCategoryId(long j, int i, int i2, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j2);
                    this.mRemote.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAlbumByCategoryIdAndTag(long j, int i, int i2, int i3, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    this.mRemote.transact(85, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAlbumInfo(long j, int i, int i2, String str, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    this.mRemote.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAttentionAlbum(int i, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCategoriesList(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.mRemote.transact(84, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCategoryModelList(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCurPlayUrl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getCurrIndex() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getCurrentTrackPlayedDuration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(116, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDefultPageSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDuration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getHistoryPos(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(98, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getHotContent(boolean z, int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.mRemote.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public String getLastPlayTrackInAlbum(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(100, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                    return str;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMainHotContent(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.mRemote.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMyCollect(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.mRemote.transact(62, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getNewRank(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.mRemote.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getNextPlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map getParam() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    Map readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getParseDeviceInfo(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlayCurrPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<Track> getPlayList(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    List<Track> createTypedArrayList = obtain2.createTypedArrayList(Track.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getPlayListOrder() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlayListSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPlayMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlaySourceType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlayerStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getPrePlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getProvinces(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(81, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Radio getRadio() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    Radio radio = obtain2.readInt() != 0 ? (Radio) Radio.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return radio;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRadioList(int i, long j, int i2, int i3, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    this.mRemote.transact(82, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRadioSchedules(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(83, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRank(String str, String str2, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRecommendAlbumListByAlbumId(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(80, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRecommendAlbumListByTrackId(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(79, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSourseLists(String str, int i, int i2, int i3, int i4, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeLong(j);
                    this.mRemote.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSpecialListenList(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.mRemote.transact(75, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSubjectDetail(int i, int i2, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(76, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSuggestAlbums(int i, int i2, boolean z, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z);
                    obtain.writeLong(j);
                    this.mRemote.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTags(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(86, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getTempo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(117, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Track getTrack(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Track track = obtain2.readInt() != 0 ? (Track) Track.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return track;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTrackDetailInfo(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(87, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Track getTrackInfoSync(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(88, obtain, obtain2, 0);
                    obtain2.readException();
                    Track track = obtain2.readInt() != 0 ? (Track) Track.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return track;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTrackListByLastTrack(long j, long j2, int i, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(i);
                    obtain.writeLong(j3);
                    this.mRemote.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTrackListByTrackIdAtAlbum(long j, long j2, boolean z, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(z);
                    obtain.writeLong(j3);
                    this.mRemote.transact(78, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getUserInfo(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasNextSound() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasPreSound() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean haveNextPlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(106, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean havePrePlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(107, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void init(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void insertPlayListHead(List<Track> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    this.mRemote.transact(115, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(105, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdsActive() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isBuffering() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(108, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isDLNAState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(112, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isOnlineSource() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void needContinuePlay(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z);
                    this.mRemote.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean pausePlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pausePlayInMillis(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(104, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean permutePlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean play(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean playNext() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean playPre() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean playRadio(Radio radio) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (radio != null) {
                        obtain.writeInt(1);
                        radio.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(29, obtain, obtain2, 0);
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

            public void registeAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmAdsEventDispatcher != null ? iXmAdsEventDispatcher.asBinder() : null);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registeCommonBusinessListener(IXmCommonBusinessDispatcher iXmCommonBusinessDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmCommonBusinessDispatcher != null ? iXmCommonBusinessDispatcher.asBinder() : null);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registeCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmCustomDataCallBack != null ? iXmCustomDataCallBack.asBinder() : null);
                    this.mRemote.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registeMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmMainDataSupportDataCallback != null ? iXmMainDataSupportDataCallback.asBinder() : null);
                    this.mRemote.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmPlayerEventDispatcher != null ? iXmPlayerEventDispatcher.asBinder() : null);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeListByIndex(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(97, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestSoundAd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resetPlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(96, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resetPlayer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(113, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean seekTo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAdsDataHandlerClassName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(94, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAppSecret(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAppkeyAndPackId(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(118, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setBreakpointResume(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z);
                    this.mRemote.transact(111, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCategoryId(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCheckAdContent(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z);
                    this.mRemote.transact(114, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDLNAState(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z);
                    this.mRemote.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setHistoryPosById(long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    this.mRemote.transact(99, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setNotification(int i, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPageSize(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayByAlbumTracks(String str, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayByTrack(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayCdnConfigureModel(CdnConfigModel cdnConfigModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (cdnConfigModel != null) {
                        obtain.writeInt(1);
                        cdnConfigModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(95, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setPlayIndex(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayList(Map map, List<Track> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    obtain.writeTypedList(list);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayListChangeListener(IXmDataCallback iXmDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmDataCallback != null ? iXmDataCallback.asBinder() : null);
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayMode(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayModel(String str, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayStatisticClassName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(93, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayerProcessRequestEnvironment(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setProxy(String str, int i, String str2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setProxyNew(Config config) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (config != null) {
                        obtain.writeInt(1);
                        config.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(109, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        config.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRecordModel(RecordModel recordModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (recordModel != null) {
                        obtain.writeInt(1);
                        recordModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(91, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        recordModel.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSoundTouchAllParams(float f, float f2, float f3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    obtain.writeFloat(f3);
                    this.mRemote.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTokenInvalidForSDK(IXmTokenInvalidForSDKCallBack iXmTokenInvalidForSDKCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmTokenInvalidForSDKCallBack != null ? iXmTokenInvalidForSDKCallBack.asBinder() : null);
                    this.mRemote.transact(89, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTokenToPlayForSDK(AccessToken accessToken) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (accessToken != null) {
                        obtain.writeInt(1);
                        accessToken.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(90, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        accessToken.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVolume(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.mRemote.transact(92, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean startPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean stopPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void subscribeAlbum(String str, boolean z, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z);
                    obtain.writeLong(j);
                    this.mRemote.transact(77, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisteAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmAdsEventDispatcher != null ? iXmAdsEventDispatcher.asBinder() : null);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisteCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmCustomDataCallBack != null ? iXmCustomDataCallBack.asBinder() : null);
                    this.mRemote.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisteMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmMainDataSupportDataCallback != null ? iXmMainDataSupportDataCallback.asBinder() : null);
                    this.mRemote.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregistePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXmPlayerEventDispatcher != null ? iXmPlayerEventDispatcher.asBinder() : null);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateTrackDownloadUrlInPlayList(Track track) throws RemoteException {
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
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        track.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean updateTrackInPlayList(Track track) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    if (obtain2.readInt() != 0) {
                        track.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IXmPlayer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IXmPlayer)) ? new Proxy(iBinder) : (IXmPlayer) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Track track = null;
                boolean z = false;
                boolean playPre;
                Track track2;
                String playMode;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        setProxy(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = playPre();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = playNext();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = play(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = setPlayIndex(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = startPlay();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = pausePlay();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = stopPlay();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = seekTo(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = isOnlineSource();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = hasPreSound();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = hasNextSound();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        i = getPlayerStatus();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        i = getCurrIndex();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        i = getDuration();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        i = getPlayCurrPosition();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = isPlaying();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = isAdsActive();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            track = (Track) Track.CREATOR.createFromParcel(parcel);
                        }
                        updateTrackDownloadUrlInPlayList(track);
                        parcel2.writeNoException();
                        if (track != null) {
                            parcel2.writeInt(1);
                            track.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            track = (Track) Track.CREATOR.createFromParcel(parcel);
                        }
                        playPre = updateTrackInPlayList(track);
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        if (track != null) {
                            parcel2.writeInt(1);
                            track.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        track2 = getTrack(parcel.readInt());
                        parcel2.writeNoException();
                        if (track2 != null) {
                            parcel2.writeInt(1);
                            track2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        Radio radio = getRadio();
                        parcel2.writeNoException();
                        if (radio != null) {
                            parcel2.writeInt(1);
                            radio.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        i = getPlaySourceType();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 24:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayMode(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface(DESCRIPTOR);
                        playMode = getPlayMode();
                        parcel2.writeNoException();
                        parcel2.writeString(playMode);
                        return true;
                    case 26:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPageSize(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayList(parcel.readHashMap(getClass().getClassLoader()), parcel.createTypedArrayList(Track.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface(DESCRIPTOR);
                        addPlayList(parcel.createTypedArrayList(Track.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        Radio radio2;
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            radio2 = (Radio) Radio.CREATOR.createFromParcel(parcel);
                        }
                        playPre = playRadio(radio2);
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 30:
                        parcel.enforceInterface(DESCRIPTOR);
                        List playList = getPlayList(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(playList);
                        return true;
                    case 31:
                        parcel.enforceInterface(DESCRIPTOR);
                        Map param = getParam();
                        parcel2.writeNoException();
                        parcel2.writeMap(param);
                        return true;
                    case 32:
                        parcel.enforceInterface(DESCRIPTOR);
                        i = getPlayListSize();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 33:
                        parcel.enforceInterface(DESCRIPTOR);
                        clearPlayCache();
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        Notification notification;
                        parcel.enforceInterface(DESCRIPTOR);
                        i = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                        }
                        setNotification(i, notification);
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface(DESCRIPTOR);
                        setAppSecret(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface(DESCRIPTOR);
                        registePlayerListener(com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregistePlayerListener(com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface(DESCRIPTOR);
                        registeAdsListener(com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisteAdsListener(com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 40:
                        parcel.enforceInterface(DESCRIPTOR);
                        registeCommonBusinessListener(com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 41:
                        parcel.enforceInterface(DESCRIPTOR);
                        getNextPlayList();
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface(DESCRIPTOR);
                        getPrePlayList();
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayListChangeListener(com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = permutePlayList();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 45:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = getPlayListOrder();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 46:
                        parcel.enforceInterface(DESCRIPTOR);
                        playMode = getCurPlayUrl();
                        parcel2.writeNoException();
                        parcel2.writeString(playMode);
                        return true;
                    case 47:
                        parcel.enforceInterface(DESCRIPTOR);
                        init(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 48:
                        parcel.enforceInterface(DESCRIPTOR);
                        registeCustomDataCallBack(com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisteCustomDataCallBack(com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 50:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayModel(parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 51:
                        parcel.enforceInterface(DESCRIPTOR);
                        getSourseLists(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 52:
                        parcel.enforceInterface(DESCRIPTOR);
                        browseAlbums(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 53:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayByTrack(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 54:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayByAlbumTracks(parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 55:
                        parcel.enforceInterface(DESCRIPTOR);
                        setCategoryId(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 56:
                        parcel.enforceInterface(DESCRIPTOR);
                        getCategoryModelList(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 57:
                        parcel.enforceInterface(DESCRIPTOR);
                        getHotContent(parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 58:
                        parcel.enforceInterface(DESCRIPTOR);
                        getTrackListByLastTrack(parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 59:
                        parcel.enforceInterface(DESCRIPTOR);
                        registeMainDataSupportCallBack(com.ximalaya.ting.android.opensdk.player.service.IXmMainDataSupportDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 60:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisteMainDataSupportCallBack(com.ximalaya.ting.android.opensdk.player.service.IXmMainDataSupportDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 61:
                        parcel.enforceInterface(DESCRIPTOR);
                        getUserInfo(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 62:
                        parcel.enforceInterface(DESCRIPTOR);
                        getMyCollect(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 63:
                        parcel.enforceInterface(DESCRIPTOR);
                        getAttentionAlbum(parcel.readInt(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 64:
                        parcel.enforceInterface(DESCRIPTOR);
                        getAlbumInfo(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 65:
                        parcel.enforceInterface(DESCRIPTOR);
                        getRank(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 66:
                        parcel.enforceInterface(DESCRIPTOR);
                        getMainHotContent(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 67:
                        parcel.enforceInterface(DESCRIPTOR);
                        getNewRank(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 68:
                        parcel.enforceInterface(DESCRIPTOR);
                        i = getDefultPageSize();
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 69:
                        parcel.enforceInterface(DESCRIPTOR);
                        getAlbumByCategoryId(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 70:
                        parcel.enforceInterface(DESCRIPTOR);
                        getParseDeviceInfo(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 71:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setDLNAState(z);
                        parcel2.writeNoException();
                        return true;
                    case 72:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = isDLNAState();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 73:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        needContinuePlay(z);
                        parcel2.writeNoException();
                        return true;
                    case 74:
                        parcel.enforceInterface(DESCRIPTOR);
                        getSuggestAlbums(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 75:
                        parcel.enforceInterface(DESCRIPTOR);
                        getSpecialListenList(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 76:
                        parcel.enforceInterface(DESCRIPTOR);
                        getSubjectDetail(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 77:
                        parcel.enforceInterface(DESCRIPTOR);
                        playMode = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        subscribeAlbum(playMode, z, parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 78:
                        parcel.enforceInterface(DESCRIPTOR);
                        getTrackListByTrackIdAtAlbum(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 79:
                        parcel.enforceInterface(DESCRIPTOR);
                        getRecommendAlbumListByTrackId(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 80:
                        parcel.enforceInterface(DESCRIPTOR);
                        getRecommendAlbumListByAlbumId(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 81:
                        parcel.enforceInterface(DESCRIPTOR);
                        getProvinces(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 82:
                        parcel.enforceInterface(DESCRIPTOR);
                        getRadioList(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 83:
                        parcel.enforceInterface(DESCRIPTOR);
                        getRadioSchedules(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 84:
                        parcel.enforceInterface(DESCRIPTOR);
                        getCategoriesList(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 85:
                        parcel.enforceInterface(DESCRIPTOR);
                        getAlbumByCategoryIdAndTag(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 86:
                        parcel.enforceInterface(DESCRIPTOR);
                        getTags(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 87:
                        parcel.enforceInterface(DESCRIPTOR);
                        getTrackDetailInfo(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 88:
                        parcel.enforceInterface(DESCRIPTOR);
                        track2 = getTrackInfoSync(parcel.readLong());
                        parcel2.writeNoException();
                        if (track2 != null) {
                            parcel2.writeInt(1);
                            track2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 89:
                        parcel.enforceInterface(DESCRIPTOR);
                        setTokenInvalidForSDK(com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 90:
                        AccessToken accessToken;
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            accessToken = (AccessToken) AccessToken.CREATOR.createFromParcel(parcel);
                        }
                        setTokenToPlayForSDK(accessToken);
                        parcel2.writeNoException();
                        if (accessToken != null) {
                            parcel2.writeInt(1);
                            accessToken.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 91:
                        RecordModel recordModel;
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            recordModel = (RecordModel) RecordModel.CREATOR.createFromParcel(parcel);
                        }
                        setRecordModel(recordModel);
                        parcel2.writeNoException();
                        if (recordModel != null) {
                            parcel2.writeInt(1);
                            recordModel.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 92:
                        parcel.enforceInterface(DESCRIPTOR);
                        setVolume(parcel.readFloat(), parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 93:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayStatisticClassName(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 94:
                        parcel.enforceInterface(DESCRIPTOR);
                        setAdsDataHandlerClassName(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 95:
                        CdnConfigModel cdnConfigModel;
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            cdnConfigModel = (CdnConfigModel) CdnConfigModel.CREATOR.createFromParcel(parcel);
                        }
                        setPlayCdnConfigureModel(cdnConfigModel);
                        parcel2.writeNoException();
                        return true;
                    case 96:
                        parcel.enforceInterface(DESCRIPTOR);
                        resetPlayList();
                        parcel2.writeNoException();
                        return true;
                    case 97:
                        parcel.enforceInterface(DESCRIPTOR);
                        removeListByIndex(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 98:
                        parcel.enforceInterface(DESCRIPTOR);
                        playMode = getHistoryPos(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(playMode);
                        return true;
                    case 99:
                        parcel.enforceInterface(DESCRIPTOR);
                        setHistoryPosById(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 100:
                        parcel.enforceInterface(DESCRIPTOR);
                        playMode = getLastPlayTrackInAlbum(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(playMode);
                        return true;
                    case 101:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayerProcessRequestEnvironment(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 102:
                        parcel.enforceInterface(DESCRIPTOR);
                        setSoundTouchAllParams(parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 103:
                        parcel.enforceInterface(DESCRIPTOR);
                        requestSoundAd();
                        parcel2.writeNoException();
                        return true;
                    case 104:
                        parcel.enforceInterface(DESCRIPTOR);
                        pausePlayInMillis(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 105:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = isAdPlaying();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 106:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = haveNextPlayList();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 107:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = havePrePlayList();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 108:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = isBuffering();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 109:
                        Config config;
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            config = (Config) Config.CREATOR.createFromParcel(parcel);
                        }
                        setProxyNew(config);
                        parcel2.writeNoException();
                        if (config != null) {
                            parcel2.writeInt(1);
                            config.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 110:
                        parcel.enforceInterface(DESCRIPTOR);
                        exitSoundAd();
                        parcel2.writeNoException();
                        return true;
                    case 111:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setBreakpointResume(z);
                        parcel2.writeNoException();
                        return true;
                    case 112:
                        parcel.enforceInterface(DESCRIPTOR);
                        playPre = isLoading();
                        parcel2.writeNoException();
                        parcel2.writeInt(playPre);
                        return true;
                    case 113:
                        parcel.enforceInterface(DESCRIPTOR);
                        resetPlayer();
                        parcel2.writeNoException();
                        return true;
                    case 114:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setCheckAdContent(z);
                        parcel2.writeNoException();
                        return true;
                    case 115:
                        parcel.enforceInterface(DESCRIPTOR);
                        insertPlayListHead(parcel.createTypedArrayList(Track.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 116:
                        parcel.enforceInterface(DESCRIPTOR);
                        long currentTrackPlayedDuration = getCurrentTrackPlayedDuration();
                        parcel2.writeNoException();
                        parcel2.writeLong(currentTrackPlayedDuration);
                        return true;
                    case 117:
                        parcel.enforceInterface(DESCRIPTOR);
                        float tempo = getTempo();
                        parcel2.writeNoException();
                        parcel2.writeFloat(tempo);
                        return true;
                    case 118:
                        parcel.enforceInterface(DESCRIPTOR);
                        setAppkeyAndPackId(parcel.readString(), parcel.readString());
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

    void addPlayList(List<Track> list) throws RemoteException;

    void browseAlbums(long j, int i, int i2, long j2) throws RemoteException;

    void clearPlayCache() throws RemoteException;

    void exitSoundAd() throws RemoteException;

    void getAlbumByCategoryId(long j, int i, int i2, long j2) throws RemoteException;

    void getAlbumByCategoryIdAndTag(long j, int i, int i2, int i3, long j2) throws RemoteException;

    void getAlbumInfo(long j, int i, int i2, String str, long j2) throws RemoteException;

    void getAttentionAlbum(int i, String str, long j) throws RemoteException;

    void getCategoriesList(int i, int i2, long j) throws RemoteException;

    void getCategoryModelList(long j) throws RemoteException;

    String getCurPlayUrl() throws RemoteException;

    int getCurrIndex() throws RemoteException;

    long getCurrentTrackPlayedDuration() throws RemoteException;

    int getDefultPageSize() throws RemoteException;

    int getDuration() throws RemoteException;

    String getHistoryPos(String str) throws RemoteException;

    void getHotContent(boolean z, int i, int i2, long j) throws RemoteException;

    String getLastPlayTrackInAlbum(String str) throws RemoteException;

    void getMainHotContent(int i, int i2, int i3, long j) throws RemoteException;

    void getMyCollect(int i, int i2, long j) throws RemoteException;

    void getNewRank(int i, int i2, int i3, long j) throws RemoteException;

    void getNextPlayList() throws RemoteException;

    Map getParam() throws RemoteException;

    void getParseDeviceInfo(long j) throws RemoteException;

    int getPlayCurrPosition() throws RemoteException;

    List<Track> getPlayList(int i) throws RemoteException;

    boolean getPlayListOrder() throws RemoteException;

    int getPlayListSize() throws RemoteException;

    String getPlayMode() throws RemoteException;

    int getPlaySourceType() throws RemoteException;

    int getPlayerStatus() throws RemoteException;

    void getPrePlayList() throws RemoteException;

    void getProvinces(long j) throws RemoteException;

    Radio getRadio() throws RemoteException;

    void getRadioList(int i, long j, int i2, int i3, long j2) throws RemoteException;

    void getRadioSchedules(String str, long j) throws RemoteException;

    void getRank(String str, String str2, int i, long j) throws RemoteException;

    void getRecommendAlbumListByAlbumId(long j, long j2) throws RemoteException;

    void getRecommendAlbumListByTrackId(long j, long j2) throws RemoteException;

    void getSourseLists(String str, int i, int i2, int i3, int i4, long j) throws RemoteException;

    void getSpecialListenList(int i, int i2, int i3, long j) throws RemoteException;

    void getSubjectDetail(int i, int i2, long j, long j2) throws RemoteException;

    void getSuggestAlbums(int i, int i2, boolean z, long j) throws RemoteException;

    void getTags(long j, long j2) throws RemoteException;

    float getTempo() throws RemoteException;

    Track getTrack(int i) throws RemoteException;

    void getTrackDetailInfo(long j, long j2) throws RemoteException;

    Track getTrackInfoSync(long j) throws RemoteException;

    void getTrackListByLastTrack(long j, long j2, int i, long j3) throws RemoteException;

    void getTrackListByTrackIdAtAlbum(long j, long j2, boolean z, long j3) throws RemoteException;

    void getUserInfo(long j) throws RemoteException;

    boolean hasNextSound() throws RemoteException;

    boolean hasPreSound() throws RemoteException;

    boolean haveNextPlayList() throws RemoteException;

    boolean havePrePlayList() throws RemoteException;

    void init(String str, String str2, String str3) throws RemoteException;

    void insertPlayListHead(List<Track> list) throws RemoteException;

    boolean isAdPlaying() throws RemoteException;

    boolean isAdsActive() throws RemoteException;

    boolean isBuffering() throws RemoteException;

    boolean isDLNAState() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isOnlineSource() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void needContinuePlay(boolean z) throws RemoteException;

    boolean pausePlay() throws RemoteException;

    void pausePlayInMillis(long j) throws RemoteException;

    boolean permutePlayList() throws RemoteException;

    boolean play(int i) throws RemoteException;

    boolean playNext() throws RemoteException;

    boolean playPre() throws RemoteException;

    boolean playRadio(Radio radio) throws RemoteException;

    void registeAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException;

    void registeCommonBusinessListener(IXmCommonBusinessDispatcher iXmCommonBusinessDispatcher) throws RemoteException;

    void registeCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException;

    void registeMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException;

    void registePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException;

    void removeListByIndex(int i) throws RemoteException;

    void requestSoundAd() throws RemoteException;

    void resetPlayList() throws RemoteException;

    void resetPlayer() throws RemoteException;

    boolean seekTo(int i) throws RemoteException;

    void setAdsDataHandlerClassName(String str) throws RemoteException;

    void setAppSecret(String str) throws RemoteException;

    void setAppkeyAndPackId(String str, String str2) throws RemoteException;

    void setBreakpointResume(boolean z) throws RemoteException;

    void setCategoryId(int i, long j) throws RemoteException;

    void setCheckAdContent(boolean z) throws RemoteException;

    void setDLNAState(boolean z) throws RemoteException;

    void setHistoryPosById(long j, int i) throws RemoteException;

    void setNotification(int i, Notification notification) throws RemoteException;

    void setPageSize(int i) throws RemoteException;

    void setPlayByAlbumTracks(String str, int i, long j) throws RemoteException;

    void setPlayByTrack(String str, long j) throws RemoteException;

    void setPlayCdnConfigureModel(CdnConfigModel cdnConfigModel) throws RemoteException;

    boolean setPlayIndex(int i) throws RemoteException;

    void setPlayList(Map map, List<Track> list) throws RemoteException;

    void setPlayListChangeListener(IXmDataCallback iXmDataCallback) throws RemoteException;

    void setPlayMode(String str) throws RemoteException;

    void setPlayModel(String str, int i, long j) throws RemoteException;

    void setPlayStatisticClassName(String str) throws RemoteException;

    void setPlayerProcessRequestEnvironment(int i) throws RemoteException;

    void setProxy(String str, int i, String str2, Map map) throws RemoteException;

    void setProxyNew(Config config) throws RemoteException;

    void setRecordModel(RecordModel recordModel) throws RemoteException;

    void setSoundTouchAllParams(float f, float f2, float f3) throws RemoteException;

    void setTokenInvalidForSDK(IXmTokenInvalidForSDKCallBack iXmTokenInvalidForSDKCallBack) throws RemoteException;

    void setTokenToPlayForSDK(AccessToken accessToken) throws RemoteException;

    void setVolume(float f, float f2) throws RemoteException;

    boolean startPlay() throws RemoteException;

    boolean stopPlay() throws RemoteException;

    void subscribeAlbum(String str, boolean z, long j) throws RemoteException;

    void unregisteAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException;

    void unregisteCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException;

    void unregisteMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException;

    void unregistePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException;

    void updateTrackDownloadUrlInPlayList(Track track) throws RemoteException;

    boolean updateTrackInPlayList(Track track) throws RemoteException;
}
