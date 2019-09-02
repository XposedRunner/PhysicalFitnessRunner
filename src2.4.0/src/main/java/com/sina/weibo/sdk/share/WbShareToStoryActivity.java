package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Msg;
import com.sina.weibo.sdk.constant.WBConstants.Response;
import com.sina.weibo.sdk.utils.ImageUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;

public class WbShareToStoryActivity extends Activity {
    private String callbackActivity;
    private View progressBar;
    private int progressColor = -1;
    private int progressId = -1;
    private FrameLayout rootLayout;
    private SaveFileTask saveFileTask;

    private class SaveFileTask extends AsyncTask<StoryMessage, Object, StoryObject> {
        private SaveFileTask() {
        }

        /* Access modifiers changed, original: protected|varargs */
        public StoryObject doInBackground(StoryMessage... storyMessageArr) {
            int i = 0;
            StoryMessage storyMessage = storyMessageArr[0];
            if (storyMessage.getVideoUri() == null) {
                i = 1;
            }
            String copyFileToWeiboTem = ImageUtils.copyFileToWeiboTem(WbShareToStoryActivity.this, i == 1 ? storyMessage.getImageUri() : storyMessage.getVideoUri(), i);
            if (TextUtils.isEmpty(copyFileToWeiboTem)) {
                return null;
            }
            StoryObject storyObject = new StoryObject();
            storyObject.sourcePath = copyFileToWeiboTem;
            storyObject.sourceType = i;
            storyObject.appId = WbSdk.getAuthInfo().getAppKey();
            storyObject.appPackage = WbShareToStoryActivity.this.getPackageName();
            return storyObject;
        }

        /* Access modifiers changed, original: protected */
        public void onPostExecute(StoryObject storyObject) {
            super.onPostExecute(storyObject);
            if (storyObject != null) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
                    intent.putExtra("storyData", storyObject);
                    WbShareToStoryActivity.this.startActivity(intent);
                    return;
                } catch (Exception unused) {
                    WbShareToStoryActivity.this.setCallbackActivity(2);
                    return;
                }
            }
            WbShareToStoryActivity.this.setCallbackActivity(2);
        }
    }

    private boolean checkInfo(StoryMessage storyMessage) {
        return storyMessage.checkSource() && WbSdk.supportMultiImage(this);
    }

    private void gotoSave(StoryMessage storyMessage) {
        if (this.saveFileTask != null) {
            this.saveFileTask.cancel(true);
        }
        this.saveFileTask = new SaveFileTask();
        this.saveFileTask.execute(new StoryMessage[]{storyMessage});
    }

    private void initView() {
        try {
            this.progressColor = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_COLOR, -1);
            this.progressId = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_ID, -1);
        } catch (Exception unused) {
        }
        this.rootLayout = new FrameLayout(this);
        if (this.progressId != -1) {
            try {
                this.progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(this.progressId, null);
            } catch (Exception unused2) {
                this.progressBar = new WbSdkProgressBar(this);
            }
        } else {
            this.progressBar = new WbSdkProgressBar(this);
            if (this.progressColor != -1) {
                ((WbSdkProgressBar) this.progressBar).setProgressColor(this.progressColor);
            }
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(this.progressBar, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
        setContentView(this.rootLayout);
    }

    private void setCallbackActivity(int i) {
        if (this.rootLayout != null) {
            this.rootLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(Response.ERRCODE, i);
            intent.setFlags(131072);
            intent.setClassName(this, this.callbackActivity);
            startActivity(intent);
        } catch (Exception e) {
            LogUtil.v("weibo sdk", e.toString());
        }
        finish();
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                this.callbackActivity = bundle.getString(WBConstants.SHARE_START_ACTIVITY);
            } catch (Exception unused) {
            }
        } else {
            this.callbackActivity = getIntent().getStringExtra(WBConstants.SHARE_START_ACTIVITY);
        }
        if (TextUtils.isEmpty(this.callbackActivity)) {
            finish();
            return;
        }
        StoryMessage storyMessage = null;
        try {
            storyMessage = (StoryMessage) getIntent().getParcelableExtra(Msg.STORY);
        } catch (Exception unused2) {
        }
        if (storyMessage == null) {
            setCallbackActivity(2);
        } else if (checkInfo(storyMessage)) {
            initView();
            gotoSave(storyMessage);
        } else {
            setCallbackActivity(2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        int intExtra;
        super.onNewIntent(intent);
        try {
            intExtra = intent.getIntExtra("backType", 0);
        } catch (Exception unused) {
            intExtra = 0;
        }
        if (intExtra == 0) {
            setCallbackActivity(1);
        } else {
            setCallbackActivity(0);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
    }

    /* Access modifiers changed, original: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(WBConstants.SHARE_START_ACTIVITY, this.callbackActivity);
    }
}
