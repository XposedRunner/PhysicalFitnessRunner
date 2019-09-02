package com.qiyukf.nimlib.sdk.media.record;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.basesdk.b.a.c.a;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.k.c.b;
import com.qiyukf.nimlib.k.c.c;
import com.qiyukf.unicorn.R;
import java.io.File;

public class AudioRecorder {
    public static final int DEFAULT_MAX_AUDIO_RECORD_TIME_SECOND = 60;
    private static final String TAG = "AudioRecordManager";
    private File audioFile;
    private AudioManager audioManager;
    private boolean cancelRecord = false;
    private IAudioRecordCallback cb;
    private Context context;
    private OnErrorListener errorListener = new OnErrorListener() {
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            AudioRecorder.this.mUiHandler.removeCallbacks(AudioRecorder.this.recordingUpdateUI);
            AudioRecorder.this.handleEndRecord(false, 0);
        }
    };
    private OnInfoListener infoListener = new OnInfoListener() {
        public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
            if (i == 800) {
                AudioRecorder.this.recordTime = 0;
                AudioRecorder.this.handleReachedMaxRecordTime(AudioRecorder.this.maxDuration * 1000);
            }
        }
    };
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    private int maxDuration;
    private MediaRecorder mediaRecorder;
    private long recordTime = 0;
    private RecordType recordType;
    private Runnable recordingUpdateUI = new Runnable() {
        public void run() {
            if (AudioRecorder.this.mediaRecorder != null && AudioRecorder.this.cb != null) {
                AudioRecorder.this.cb.onUpdateAmplitude(AudioRecorder.this.mediaRecorder.getMaxAmplitude());
                AudioRecorder.this.mUiHandler.postDelayed(this, 100);
            }
        }
    };
    private File tempFile;

    public AudioRecorder(Context context, RecordType recordType, int i, IAudioRecordCallback iAudioRecordCallback) {
        this.context = context.getApplicationContext();
        setRecordType(recordType);
        if (i <= 0) {
            this.maxDuration = 60;
        } else {
            this.maxDuration = i;
        }
        this.cb = iAudioRecordCallback;
        this.audioManager = (AudioManager) context.getSystemService("audio");
    }

    private void handleReachedMaxRecordTime(int i) {
        this.cb.onRecordReachedMaxTime(i);
        this.mUiHandler.removeCallbacks(this.recordingUpdateUI);
        stop();
        a.b(this.tempFile.getAbsolutePath());
    }

    private void setRecordType(RecordType recordType) {
        if (VERSION.SDK_INT >= 10 || recordType == RecordType.AMR) {
            this.recordType = recordType;
        } else {
            this.recordType = RecordType.AMR;
        }
    }

    private void stop() {
        final MediaRecorder mediaRecorder = this.mediaRecorder;
        this.mediaRecorder = null;
        com.qiyukf.basesdk.c.a.a().c().post(new Runnable() {
            public void run() {
                try {
                    mediaRecorder.setOnErrorListener(null);
                    mediaRecorder.setOnInfoListener(null);
                    mediaRecorder.setPreviewDisplay(null);
                    mediaRecorder.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void completeRecord(boolean z) {
        if (isRecording()) {
            this.cancelRecord = z;
            this.audioManager.abandonAudioFocus(null);
            if (this.mediaRecorder != null) {
                this.mUiHandler.removeCallbacks(this.recordingUpdateUI);
                stop();
                handleEndRecord(true, (int) (System.currentTimeMillis() - this.recordTime));
            }
            this.recordTime = 0;
            a.b(this.tempFile.getAbsolutePath());
        }
    }

    public void handleEndRecord(boolean z, final int i) {
        if (this.cancelRecord) {
            this.cb.onRecordCancel();
        } else if (z) {
            this.mUiHandler.postDelayed(new Runnable() {
                public void run() {
                    a.a(AudioRecorder.this.tempFile.getAbsolutePath(), AudioRecorder.this.audioFile.getAbsolutePath());
                    if (AudioRecorder.this.audioFile == null || !AudioRecorder.this.audioFile.exists() || AudioRecorder.this.audioFile.length() <= 0 || i < SecExceptionCode.SEC_ERROR_DYN_ENC) {
                        AudioRecorder.this.cb.onRecordFail();
                    } else {
                        AudioRecorder.this.cb.onRecordSuccess(AudioRecorder.this.audioFile, (long) i, AudioRecorder.this.recordType);
                    }
                }
            }, 500);
        } else {
            this.cb.onRecordFail();
        }
    }

    public boolean isRecording() {
        return this.recordTime > 0;
    }

    public boolean startRecord() {
        this.audioManager.requestAudioFocus(null, 0, 2);
        if (isRecording()) {
            com.qiyukf.basesdk.a.a.a("AudioRecorder", "AudioRecordManager startRecord false, as current state is isRecording");
            return false;
        } else if (c.a(b.TYPE_AUDIO)) {
            int outputFormat = this.recordType.getOutputFormat();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.a());
            stringBuilder.append(outputFormat);
            String a = c.a(stringBuilder.toString(), b.TYPE_AUDIO);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(d.a());
            stringBuilder2.append(outputFormat);
            String a2 = c.a(stringBuilder2.toString(), b.TYPE_AUDIO);
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) {
                com.qiyukf.basesdk.a.a.a("AudioRecorder", "AudioRecordManager startRecord false, as outputFilePath is empty");
                return false;
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a2);
            stringBuilder2.append(this.recordType.getFileSuffix());
            this.audioFile = new File(stringBuilder2.toString());
            this.tempFile = new File(a);
            this.cancelRecord = false;
            try {
                this.mediaRecorder = new MediaRecorder();
                this.mediaRecorder.setOnInfoListener(this.infoListener);
                this.mediaRecorder.setOnErrorListener(this.errorListener);
                this.mediaRecorder.setAudioSource(1);
                this.mediaRecorder.setOutputFormat(this.recordType.getOutputFormat());
                this.mediaRecorder.setAudioEncoder(this.recordType.getAudioEncoder());
                this.mediaRecorder.setOutputFile(this.tempFile.getPath());
                this.mediaRecorder.setMaxDuration(this.maxDuration * 1000);
                if (!this.cancelRecord) {
                    this.cb.onRecordReady();
                    this.mediaRecorder.prepare();
                    this.mediaRecorder.start();
                    this.recordTime = System.currentTimeMillis();
                    this.cb.onRecordStart(this.tempFile, this.recordType);
                    this.mUiHandler.post(this.recordingUpdateUI);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return isRecording();
        } else {
            com.qiyukf.basesdk.a.a.a("AudioRecorder", "AudioRecordManager startRecord false, as has no enough space to write");
            g.b(R.string.ysf_picker_image_sdcard_not_enough_error);
            return false;
        }
    }
}
