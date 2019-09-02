package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.SupportActivity;
import android.support.v4.app.SupportActivity.ExtraData;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback.Stub;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.PlaybackStateCompat.CustomAction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {
    static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final Token mToken;

    public static abstract class Callback implements DeathRecipient {
        private final Object mCallbackObj;
        MessageHandler mHandler;
        boolean mHasExtraCallback;
        boolean mRegistered = false;

        private class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 10;
            private static final int MSG_UPDATE_VOLUME = 4;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (Callback.this.mRegistered) {
                    switch (message.what) {
                        case 1:
                            Callback.this.onSessionEvent((String) message.obj, message.getData());
                            break;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            break;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            break;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            break;
                        case 7:
                            Callback.this.onExtrasChanged((Bundle) message.obj);
                            break;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            break;
                        case 9:
                            Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            break;
                        case 10:
                            Callback.this.onShuffleModeChanged(((Boolean) message.obj).booleanValue());
                            break;
                    }
                }
            }

            public void post(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        private class StubApi21 implements android.support.v4.media.session.MediaControllerCompatApi21.Callback {
            StubApi21() {
            }

            public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
                Callback.this.onAudioInfoChanged(new PlaybackInfo(i, i2, i3, i4, i5));
            }

            public void onExtrasChanged(Bundle bundle) {
                Callback.this.onExtrasChanged(bundle);
            }

            public void onMetadataChanged(Object obj) {
                Callback.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
            }

            public void onPlaybackStateChanged(Object obj) {
                if (!Callback.this.mHasExtraCallback) {
                    Callback.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
                }
            }

            public void onQueueChanged(List<?> list) {
                Callback.this.onQueueChanged(QueueItem.fromQueueItemList(list));
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback.this.onQueueTitleChanged(charSequence);
            }

            public void onSessionDestroyed() {
                Callback.this.onSessionDestroyed();
            }

            public void onSessionEvent(String str, Bundle bundle) {
                if (!Callback.this.mHasExtraCallback || VERSION.SDK_INT >= 23) {
                    Callback.this.onSessionEvent(str, bundle);
                }
            }
        }

        private class StubCompat extends Stub {
            StubCompat() {
            }

            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback.this.mHandler.post(1, str, bundle);
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback.this.mHandler.post(7, bundle, null);
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback.this.mHandler.post(3, mediaMetadataCompat, null);
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback.this.mHandler.post(2, playbackStateCompat, null);
            }

            public void onQueueChanged(List<QueueItem> list) throws RemoteException {
                Callback.this.mHandler.post(5, list, null);
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback.this.mHandler.post(6, charSequence, null);
            }

            public void onRepeatModeChanged(int i) throws RemoteException {
                Callback.this.mHandler.post(9, Integer.valueOf(i), null);
            }

            public void onSessionDestroyed() throws RemoteException {
                Callback.this.mHandler.post(8, null, null);
            }

            public void onShuffleModeChanged(boolean z) throws RemoteException {
                Callback.this.mHandler.post(10, Boolean.valueOf(z), null);
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Object obj;
                if (parcelableVolumeInfo != null) {
                    PlaybackInfo playbackInfo = new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
                } else {
                    obj = null;
                }
                Callback.this.mHandler.post(4, obj, null);
            }
        }

        public Callback() {
            if (VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21());
            } else {
                this.mCallbackObj = new StubCompat();
            }
        }

        private void setHandler(Handler handler) {
            this.mHandler = new MessageHandler(handler.getLooper());
        }

        public void binderDied() {
            onSessionDestroyed();
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onShuffleModeChanged(boolean z) {
        }
    }

    private static class MediaControllerExtraData extends ExtraData {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
            this.mMediaController = mediaControllerCompat;
        }

        /* Access modifiers changed, original: 0000 */
        public MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i);

        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        TransportControls getTransportControls();

        boolean isShuffleModeEnabled();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void removeQueueItemAt(int i);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    static class MediaControllerImplApi21 implements MediaControllerImpl {
        private HashMap<Callback, ExtraCallback> mCallbackMap = new HashMap();
        protected final Object mControllerObj;
        private IMediaSession mExtraBinder;
        private List<Callback> mPendingCallbacks = new ArrayList();

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21, Handler handler) {
                super(handler);
                this.mMediaControllerImpl = new WeakReference(mediaControllerImplApi21);
            }

            /* Access modifiers changed, original: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.mMediaControllerImpl.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.mExtraBinder = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.processPendingCallbacks();
                }
            }
        }

        private class ExtraCallback extends Stub {
            private Callback mCallback;

            ExtraCallback(Callback callback) {
                this.mCallback = callback;
            }

            public void onEvent(final String str, final Bundle bundle) throws RemoteException {
                this.mCallback.mHandler.post(new Runnable() {
                    public void run() {
                        ExtraCallback.this.mCallback.onSessionEvent(str, bundle);
                    }
                });
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) throws RemoteException {
                this.mCallback.mHandler.post(new Runnable() {
                    public void run() {
                        ExtraCallback.this.mCallback.onPlaybackStateChanged(playbackStateCompat);
                    }
                });
            }

            public void onQueueChanged(List<QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void onRepeatModeChanged(final int i) throws RemoteException {
                this.mCallback.mHandler.post(new Runnable() {
                    public void run() {
                        ExtraCallback.this.mCallback.onRepeatModeChanged(i);
                    }
                });
            }

            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            public void onShuffleModeChanged(final boolean z) throws RemoteException {
                this.mCallback.mHandler.post(new Runnable() {
                    public void run() {
                        ExtraCallback.this.mCallback.onShuffleModeChanged(z);
                    }
                });
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, Token token) throws RemoteException {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, token.getToken());
            if (this.mControllerObj == null) {
                throw new RemoteException();
            }
            requestExtraBinder();
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat mediaSessionCompat) {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat.getSessionToken().getToken());
            requestExtraBinder();
        }

        private void processPendingCallbacks() {
            if (this.mExtraBinder != null) {
                synchronized (this.mPendingCallbacks) {
                    for (Callback callback : this.mPendingCallbacks) {
                        ExtraCallback extraCallback = new ExtraCallback(callback);
                        this.mCallbackMap.put(callback, extraCallback);
                        callback.mHasExtraCallback = true;
                        try {
                            this.mExtraBinder.registerCallbackListener(extraCallback);
                        } catch (RemoteException e) {
                            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                        }
                    }
                    this.mPendingCallbacks.clear();
                }
            }
        }

        private void requestExtraBinder() {
            sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this, new Handler()));
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, bundle, null);
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, null);
        }

        public void adjustVolume(int i, int i2) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, i, i2);
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }

        public MediaMetadataCompat getMetadata() {
            Object metadata = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            return metadata != null ? MediaMetadataCompat.fromMediaMetadata(metadata) : null;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        public PlaybackInfo getPlaybackInfo() {
            Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            return playbackInfo != null ? new PlaybackInfo(android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo)) : null;
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.mExtraBinder != null) {
                try {
                    return this.mExtraBinder.getPlaybackState();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
                }
            }
            Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            return playbackState != null ? PlaybackStateCompat.fromPlaybackState(playbackState) : null;
        }

        public List<QueueItem> getQueue() {
            List queue = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            return queue != null ? QueueItem.fromQueueItemList(queue) : null;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        public int getRatingType() {
            if (VERSION.SDK_INT < 22 && this.mExtraBinder != null) {
                try {
                    return this.mExtraBinder.getRatingType();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
                }
            }
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        public int getRepeatMode() {
            if (this.mExtraBinder != null) {
                try {
                    return this.mExtraBinder.getRepeatMode();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
                }
            }
            return 0;
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            return transportControls != null ? new TransportControlsApi21(transportControls) : null;
        }

        public boolean isShuffleModeEnabled() {
            if (this.mExtraBinder != null) {
                try {
                    return this.mExtraBinder.isShuffleModeEnabled();
                } catch (RemoteException e) {
                    Log.e(MediaControllerCompat.TAG, "Dead object in isShuffleModeEnabled.", e);
                }
            }
            return false;
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        public final void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback r3, android.os.Handler r4) {
            /*
            r2 = this;
            r0 = r2.mControllerObj;
            r1 = r3.mCallbackObj;
            android.support.v4.media.session.MediaControllerCompatApi21.registerCallback(r0, r1, r4);
            r0 = r2.mExtraBinder;
            if (r0 == 0) goto L_0x002c;
        L_0x000d:
            r3.setHandler(r4);
            r4 = new android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraCallback;
            r4.<init>(r3);
            r0 = r2.mCallbackMap;
            r0.put(r3, r4);
            r0 = 1;
            r3.mHasExtraCallback = r0;
            r3 = r2.mExtraBinder;	 Catch:{ RemoteException -> 0x0023 }
            r3.registerCallbackListener(r4);	 Catch:{ RemoteException -> 0x0023 }
            goto L_0x0038;
        L_0x0023:
            r3 = move-exception;
            r4 = "MediaControllerCompat";
            r0 = "Dead object in registerCallback.";
            android.util.Log.e(r4, r0, r3);
            goto L_0x0038;
        L_0x002c:
            r3.setHandler(r4);
            r4 = r2.mPendingCallbacks;
            monitor-enter(r4);
            r0 = r2.mPendingCallbacks;	 Catch:{ all -> 0x0039 }
            r0.add(r3);	 Catch:{ all -> 0x0039 }
            monitor-exit(r4);	 Catch:{ all -> 0x0039 }
        L_0x0038:
            return;
        L_0x0039:
            r3 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x0039 }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21.registerCallback(android.support.v4.media.session.MediaControllerCompat$Callback, android.os.Handler):void");
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, bundle, null);
        }

        public void removeQueueItemAt(int i) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i);
            sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT, bundle, null);
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, str, bundle, resultReceiver);
        }

        public void setVolumeTo(int i, int i2) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, i, i2);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        public final void unregisterCallback(android.support.v4.media.session.MediaControllerCompat.Callback r3) {
            /*
            r2 = this;
            r0 = r2.mControllerObj;
            r1 = r3.mCallbackObj;
            android.support.v4.media.session.MediaControllerCompatApi21.unregisterCallback(r0, r1);
            r0 = r2.mExtraBinder;
            if (r0 == 0) goto L_0x0026;
        L_0x000d:
            r0 = r2.mCallbackMap;	 Catch:{ RemoteException -> 0x001d }
            r3 = r0.remove(r3);	 Catch:{ RemoteException -> 0x001d }
            r3 = (android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback) r3;	 Catch:{ RemoteException -> 0x001d }
            if (r3 == 0) goto L_0x002f;
        L_0x0017:
            r0 = r2.mExtraBinder;	 Catch:{ RemoteException -> 0x001d }
            r0.unregisterCallbackListener(r3);	 Catch:{ RemoteException -> 0x001d }
            goto L_0x002f;
        L_0x001d:
            r3 = move-exception;
            r0 = "MediaControllerCompat";
            r1 = "Dead object in unregisterCallback.";
            android.util.Log.e(r0, r1, r3);
            goto L_0x002f;
        L_0x0026:
            r0 = r2.mPendingCallbacks;
            monitor-enter(r0);
            r1 = r2.mPendingCallbacks;	 Catch:{ all -> 0x0030 }
            r1.remove(r3);	 Catch:{ all -> 0x0030 }
            monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        L_0x002f:
            return;
        L_0x0030:
            r3 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0030 }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21.unregisterCallback(android.support.v4.media.session.MediaControllerCompat$Callback):void");
        }
    }

    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, Token token) throws RemoteException {
            super(context, token);
        }

        public MediaControllerImplApi23(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            return transportControls != null ? new TransportControlsApi23(transportControls) : null;
        }
    }

    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, Token token) throws RemoteException {
            super(context, token);
        }

        public MediaControllerImplApi24(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            return transportControls != null ? new TransportControlsApi24(transportControls) : null;
        }
    }

    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private Token mToken;
        private TransportControls mTransportControls;

        public MediaControllerImplBase(Token token) {
            this.mToken = token;
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.mBinder.addQueueItem(mediaDescriptionCompat);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItem.", e);
            }
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            try {
                if ((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.mBinder.addQueueItemAt(mediaDescriptionCompat, i);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItemAt.", e);
            }
        }

        public void adjustVolume(int i, int i2) {
            try {
                this.mBinder.adjustVolume(i, i2, null);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in adjustVolume.", e);
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.mBinder.sendMediaButton(keyEvent);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in dispatchMediaButtonEvent.", e);
            }
            return false;
        }

        public Bundle getExtras() {
            try {
                return this.mBinder.getExtras();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getExtras.", e);
                return null;
            }
        }

        public long getFlags() {
            try {
                return this.mBinder.getFlags();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getFlags.", e);
                return 0;
            }
        }

        public Object getMediaController() {
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            try {
                return this.mBinder.getMetadata();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getMetadata.", e);
                return null;
            }
        }

        public String getPackageName() {
            try {
                return this.mBinder.getPackageName();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPackageName.", e);
                return null;
            }
        }

        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.mBinder.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackInfo.", e);
                return null;
            }
        }

        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.mBinder.getPlaybackState();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
                return null;
            }
        }

        public List<QueueItem> getQueue() {
            try {
                return this.mBinder.getQueue();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getQueue.", e);
                return null;
            }
        }

        public CharSequence getQueueTitle() {
            try {
                return this.mBinder.getQueueTitle();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getQueueTitle.", e);
                return null;
            }
        }

        public int getRatingType() {
            try {
                return this.mBinder.getRatingType();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
                return 0;
            }
        }

        public int getRepeatMode() {
            try {
                return this.mBinder.getRepeatMode();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
                return 0;
            }
        }

        public PendingIntent getSessionActivity() {
            try {
                return this.mBinder.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getSessionActivity.", e);
                return null;
            }
        }

        public TransportControls getTransportControls() {
            if (this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        public boolean isShuffleModeEnabled() {
            try {
                return this.mBinder.isShuffleModeEnabled();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in isShuffleModeEnabled.", e);
                return false;
            }
        }

        public void registerCallback(Callback callback, Handler handler) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.asBinder().linkToDeath(callback, 0);
                this.mBinder.registerCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                callback.setHandler(handler);
                callback.mRegistered = true;
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
                callback.onSessionDestroyed();
            }
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.mBinder.removeQueueItem(mediaDescriptionCompat);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in removeQueueItem.", e);
            }
        }

        public void removeQueueItemAt(int i) {
            try {
                if ((this.mBinder.getFlags() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.mBinder.removeQueueItemAt(i);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in removeQueueItemAt.", e);
            }
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.mBinder.sendCommand(str, bundle, new ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in sendCommand.", e);
            }
        }

        public void setVolumeTo(int i, int i2) {
            try {
                this.mBinder.setVolumeTo(i, i2, null);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setVolumeTo.", e);
            }
        }

        public void unregisterCallback(Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.unregisterCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                this.mBinder.asBinder().unlinkToDeath(callback, 0);
                callback.mRegistered = false;
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);
            }
        }
    }

    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.mPlaybackType = i;
            this.mAudioStream = i2;
            this.mVolumeControl = i3;
            this.mMaxVolume = i4;
            this.mCurrentVolume = i5;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }
    }

    public static abstract class TransportControls {
        TransportControls() {
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleModeEnabled(boolean z);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object obj) {
            this.mControlsObj = obj;
        }

        public void fastForward() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        public void pause() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        public void play() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, str, bundle);
        }

        public void playFromSearch(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, str, bundle);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
        }

        public void prepare() {
            sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
        }

        public void rewind() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        public void seekTo(long j) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, j);
        }

        public void sendCustomAction(CustomAction customAction, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, str, bundle);
        }

        public void setRating(RatingCompat ratingCompat) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        public void setRepeatMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i);
            sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        public void setShuffleModeEnabled(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED", z);
            sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED", bundle);
        }

        public void skipToNext() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        public void skipToPrevious() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        public void skipToQueueItem(long j) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, j);
        }

        public void stop() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }
    }

    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri, bundle);
        }
    }

    static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object obj) {
            super(obj);
        }

        public void prepare() {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, str, bundle);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, str, bundle);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, uri, bundle);
        }
    }

    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.mBinder = iMediaSession;
        }

        public void fastForward() {
            try {
                this.mBinder.fastForward();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in fastForward.", e);
            }
        }

        public void pause() {
            try {
                this.mBinder.pause();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in pause.", e);
            }
        }

        public void play() {
            try {
                this.mBinder.play();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in play.", e);
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.mBinder.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromMediaId.", e);
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.mBinder.playFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromSearch.", e);
            }
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.mBinder.playFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromUri.", e);
            }
        }

        public void prepare() {
            try {
                this.mBinder.prepare();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepare.", e);
            }
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            try {
                this.mBinder.prepareFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromMediaId.", e);
            }
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            try {
                this.mBinder.prepareFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromSearch.", e);
            }
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            try {
                this.mBinder.prepareFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromUri.", e);
            }
        }

        public void rewind() {
            try {
                this.mBinder.rewind();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in rewind.", e);
            }
        }

        public void seekTo(long j) {
            try {
                this.mBinder.seekTo(j);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in seekTo.", e);
            }
        }

        public void sendCustomAction(CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            try {
                this.mBinder.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in sendCustomAction.", e);
            }
        }

        public void setRating(RatingCompat ratingCompat) {
            try {
                this.mBinder.rate(ratingCompat);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
            }
        }

        public void setRepeatMode(int i) {
            try {
                this.mBinder.setRepeatMode(i);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setRepeatMode.", e);
            }
        }

        public void setShuffleModeEnabled(boolean z) {
            try {
                this.mBinder.setShuffleModeEnabled(z);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setShuffleModeEnabled.", e);
            }
        }

        public void skipToNext() {
            try {
                this.mBinder.next();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToNext.", e);
            }
        }

        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToPrevious.", e);
            }
        }

        public void skipToQueueItem(long j) {
            try {
                this.mBinder.skipToQueueItem(j);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToQueueItem.", e);
            }
        }

        public void stop() {
            try {
                this.mBinder.stop();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in stop.", e);
            }
        }
    }

    public MediaControllerCompat(Context context, Token token) throws RemoteException {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.mToken = token;
        if (VERSION.SDK_INT >= 24) {
            this.mImpl = new MediaControllerImplApi24(context, token);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(context, token);
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, token);
        } else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.mToken = mediaSessionCompat.getSessionToken();
        if (VERSION.SDK_INT >= 24) {
            this.mImpl = new MediaControllerImplApi24(context, mediaSessionCompat);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(context, mediaSessionCompat);
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, mediaSessionCompat);
        } else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public static MediaControllerCompat getMediaController(Activity activity) {
        MediaControllerCompat mediaControllerCompat = null;
        if (activity instanceof SupportActivity) {
            MediaControllerExtraData mediaControllerExtraData = (MediaControllerExtraData) ((SupportActivity) activity).getExtraData(MediaControllerExtraData.class);
            if (mediaControllerExtraData != null) {
                mediaControllerCompat = mediaControllerExtraData.getMediaController();
            }
            return mediaControllerCompat;
        }
        if (VERSION.SDK_INT >= 21) {
            Object mediaController = MediaControllerCompatApi21.getMediaController(activity);
            if (mediaController == null) {
                return null;
            }
            try {
                return new MediaControllerCompat((Context) activity, Token.fromToken(MediaControllerCompatApi21.getSessionToken(mediaController)));
            } catch (RemoteException e) {
                Log.e(TAG, "Dead object in getMediaController.", e);
            }
        }
        return null;
    }

    public static void setMediaController(Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof SupportActivity) {
            ((SupportActivity) activity).putExtraData(new MediaControllerExtraData(mediaControllerCompat));
        }
        if (VERSION.SDK_INT >= 21) {
            Object obj = null;
            if (mediaControllerCompat != null) {
                obj = MediaControllerCompatApi21.fromToken(activity, mediaControllerCompat.getSessionToken().getToken());
            }
            MediaControllerCompatApi21.setMediaController(activity, obj);
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, i);
    }

    public void adjustVolume(int i, int i2) {
        this.mImpl.adjustVolume(i, i2);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.mImpl.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List<QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public Token getSessionToken() {
        return this.mToken;
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    /* Access modifiers changed, original: 0000 */
    @VisibleForTesting
    public boolean isExtraBinderReady() {
        boolean z = false;
        if (!(this.mImpl instanceof MediaControllerImplApi21)) {
            return false;
        }
        if (((MediaControllerImplApi21) this.mImpl).mExtraBinder != null) {
            z = true;
        }
        return z;
    }

    public boolean isShuffleModeEnabled() {
        return this.mImpl.isShuffleModeEnabled();
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        this.mImpl.registerCallback(callback, handler);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }

    public void removeQueueItemAt(int i) {
        this.mImpl.removeQueueItemAt(i);
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        this.mImpl.sendCommand(str, bundle, resultReceiver);
    }

    public void setVolumeTo(int i, int i2) {
        this.mImpl.setVolumeTo(i, i2);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.unregisterCallback(callback);
    }
}