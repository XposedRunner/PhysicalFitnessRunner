package com.ximalaya.ting.android.opensdk.player.mediacontrol;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.session.MediaSession;
import android.media.session.MediaSession.Callback;
import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerConfig;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase.IBitmapDownOkCallBack;

public class MediaControlManager {
    public static final String REMOTE_CONTROL_COVER_DRAWABLE = "reflect_player_cover_default";
    private AudioManager audioManager;
    private boolean isRegisterRemoteControl = false;
    private Context mContext;
    private RemoteControlClient mRemoteControlClient;
    private MediaSession mSession;
    private ComponentName mediaButtonReceiver;
    private WireControlReceiver wireControlReceiver;

    public MediaControlManager(Context context) {
        this.mContext = context;
        if (XmPlayerConfig.getInstance(context).isUseSystemLockScreen()) {
            this.wireControlReceiver = new WireControlReceiver();
            this.audioManager = (AudioManager) context.getSystemService("audio");
        }
    }

    /* JADX WARNING: Missing block: B:7:0x004c, code skipped:
            return;
     */
    private void register(android.media.session.MediaSession r5) {
        /*
        r4 = this;
        r0 = r4.mContext;
        r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerConfig.getInstance(r0);
        r0 = r0.isUseSystemLockScreen();
        if (r0 == 0) goto L_0x004c;
    L_0x000c:
        if (r5 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x004c;
    L_0x000f:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 < r1) goto L_0x004b;
    L_0x0015:
        r0 = new android.content.Intent;
        r1 = "android.intent.action.MEDIA_BUTTON";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r2 = r4.mContext;
        r3 = com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver.class;
        r1.<init>(r2, r3);
        r0.setComponent(r1);
        r1 = r4.mContext;
        r1 = r1.getApplicationContext();
        r2 = 0;
        r0 = android.app.PendingIntent.getBroadcast(r1, r2, r0, r2);
        r5.setMediaButtonReceiver(r0);
        r0 = new android.media.AudioAttributes$Builder;
        r0.<init>();
        r1 = 1;
        r1 = r0.setUsage(r1);
        r2 = 2;
        r1.setContentType(r2);
        r0 = r0.build();
        r5.setPlaybackToLocal(r0);
    L_0x004b:
        return;
    L_0x004c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.mediacontrol.MediaControlManager.register(android.media.session.MediaSession):void");
    }

    private void updateRemoteControlClientInfor(String str, String str2, String str3, long j, Bitmap bitmap) {
        if (VERSION.SDK_INT >= 14) {
            MetadataEditor editMetadata = this.mRemoteControlClient.editMetadata(true);
            editMetadata.putString(7, str);
            editMetadata.putString(1, str2);
            editMetadata.putString(2, str3);
            editMetadata.putLong(9, j);
            if (bitmap == null) {
                int identifier = this.mContext.getResources().getIdentifier(REMOTE_CONTROL_COVER_DRAWABLE, "drawable", this.mContext.getPackageName());
                if (identifier <= 0 && ConstantsOpenSdk.isDebug && BaseUtil.isMainApp()) {
                    throw new RuntimeException("请内置名为player_cover_default资源图片，作为锁屏封面默认图");
                }
                bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), identifier);
            }
            if (!(bitmap == null || bitmap.isRecycled())) {
                try {
                    editMetadata.putBitmap(100, bitmap);
                } catch (Exception unused) {
                }
            }
            editMetadata.apply();
        }
    }

    private void updateScreenImg() {
        if (VERSION.SDK_INT >= 14 && this.mRemoteControlClient != null) {
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null && playerSrvice.getPlayListControl() != null) {
                Track track = (Track) playerSrvice.getPlayListControl().getCurrentPlayableModel();
                if (track != null) {
                    String trackTitle = track.getTrackTitle();
                    String albumTitle = track.getAlbum() != null ? track.getAlbum().getAlbumTitle() : "";
                    String nickname = track.getAnnouncer() != null ? track.getAnnouncer().getNickname() : "";
                    long duration = (long) track.getDuration();
                    updateRemoteControlClientInfor(trackTitle, albumTitle, nickname, duration, null);
                    int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
                    int i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
                    final String str = trackTitle;
                    final String str2 = albumTitle;
                    final String str3 = nickname;
                    final long j = duration;
                    FileUtilBase.getBitmapByUrl(this.mContext, track, 0, 0, new IBitmapDownOkCallBack() {
                        public void onSuccess(Bitmap bitmap) {
                            if (MediaControlManager.this.mRemoteControlClient != null && bitmap != null) {
                                MediaControlManager.this.updateRemoteControlClientInfor(str, str2, str3, j, bitmap);
                            }
                        }
                    });
                }
            }
        }
    }

    public void initMediaControl() {
        if (XmPlayerConfig.getInstance(this.mContext).isUseSystemLockScreen() && VERSION.SDK_INT >= 21) {
            try {
                this.mSession = new MediaSession(this.mContext, "MusicService");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.mSession != null) {
                this.mSession.setCallback(new Callback() {
                    public boolean onMediaButtonEvent(Intent intent) {
                        MediaControlManager.this.wireControlReceiver.onReceive(MediaControlManager.this.mContext, intent);
                        return super.onMediaButtonEvent(intent);
                    }
                });
                this.mSession.setFlags(3);
            }
        }
    }

    public void pausePlay() {
        if (XmPlayerConfig.getInstance(this.mContext).isUseSystemLockScreen()) {
            if (VERSION.SDK_INT >= 21 && this.mSession != null) {
                this.mSession.setPlaybackState(new Builder().setState(2, 0, 1.0f).build());
            }
            if (VERSION.SDK_INT >= 14 && this.mRemoteControlClient != null) {
                this.mRemoteControlClient.setPlaybackState(2);
            }
        }
    }

    public void release() {
        if (XmPlayerConfig.getInstance(this.mContext).isUseSystemLockScreen()) {
            if (VERSION.SDK_INT >= 21 && this.mSession != null) {
                this.mSession.setActive(false);
                this.mSession.release();
            }
            if (VERSION.SDK_INT >= 14) {
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
                if (audioManager != null) {
                    if (this.mediaButtonReceiver != null) {
                        audioManager.unregisterMediaButtonEventReceiver(this.mediaButtonReceiver);
                    }
                    if (this.mRemoteControlClient != null) {
                        audioManager.unregisterRemoteControlClient(this.mRemoteControlClient);
                    }
                }
                if (this.wireControlReceiver != null && this.isRegisterRemoteControl) {
                    try {
                        this.mContext.unregisterReceiver(this.wireControlReceiver);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void startPlay() {
        if (XmPlayerConfig.getInstance(this.mContext).isUseSystemLockScreen()) {
            if (VERSION.SDK_INT >= 21) {
                PlaybackState build = new Builder().setActions(1591).setState(3, 0, 1.0f, SystemClock.elapsedRealtime()).build();
                if (this.mSession != null) {
                    register(this.mSession);
                    this.mSession.setActive(true);
                    this.mSession.setPlaybackState(build);
                }
                XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                if (playerSrvice != null) {
                    final Track track = (Track) playerSrvice.getPlayListControl().getCurrentPlayableModel();
                    if (track != null) {
                        int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
                        int i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
                        FileUtilBase.getBitmapByUrl(this.mContext, track, 0, 0, new IBitmapDownOkCallBack() {
                            public void onSuccess(Bitmap bitmap) {
                                if (VERSION.SDK_INT >= 14 && VERSION.SDK_INT >= 21) {
                                    MediaMetadata.Builder builder = new MediaMetadata.Builder();
                                    if (!(bitmap == null || bitmap.isRecycled())) {
                                        builder.putBitmap("android.media.metadata.ART", bitmap);
                                    }
                                    builder.putString("android.media.metadata.TITLE", track.getTrackTitle());
                                    if (track.getAlbum() != null) {
                                        builder.putString("android.media.metadata.ALBUM", track.getAlbum().getAlbumTitle());
                                    }
                                    if (track.getAnnouncer() != null) {
                                        builder.putString("android.media.metadata.ARTIST", track.getAnnouncer().getNickname());
                                    }
                                    if (MediaControlManager.this.mSession != null) {
                                        MediaControlManager.this.mSession.setMetadata(builder.build());
                                    }
                                }
                            }
                        });
                    } else {
                        return;
                    }
                }
                return;
            }
            if (VERSION.SDK_INT >= 14) {
                this.audioManager = (AudioManager) this.mContext.getSystemService("audio");
                this.mediaButtonReceiver = new ComponentName(this.mContext.getPackageName(), WireControlReceiver.class.getName());
                this.audioManager.registerMediaButtonEventReceiver(this.mediaButtonReceiver);
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(this.mediaButtonReceiver);
                this.mRemoteControlClient = new RemoteControlClient(PendingIntent.getBroadcast(this.mContext, 0, intent, 134217728));
                this.audioManager.registerRemoteControlClient(this.mRemoteControlClient);
                this.mRemoteControlClient.setTransportControlFlags(669);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
                intentFilter.setPriority(10000);
                this.mContext.registerReceiver(this.wireControlReceiver, intentFilter);
                if (VERSION.SDK_INT >= 14 && VERSION.SDK_INT < 21) {
                    updateScreenImg();
                    if (this.mRemoteControlClient != null) {
                        this.mRemoteControlClient.setPlaybackState(3);
                    }
                }
                this.isRegisterRemoteControl = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void stopPlay() {
        if (XmPlayerConfig.getInstance(this.mContext).isUseSystemLockScreen()) {
            if (VERSION.SDK_INT >= 21 && this.mSession != null) {
                this.mSession.setPlaybackState(new Builder().setState(1, 0, 1.0f).build());
            }
            if (VERSION.SDK_INT >= 14 && this.mRemoteControlClient != null) {
                this.mRemoteControlClient.setPlaybackState(1);
            }
        }
    }
}
