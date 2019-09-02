package com.sina.weibo.sdk.share;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.ImageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class WbShareTransActivity$CopyResourceTask extends AsyncTask<WeiboMultiMessage, Object, WbShareTransActivity$TransResourceResult> {
    final /* synthetic */ WbShareTransActivity this$0;

    private WbShareTransActivity$CopyResourceTask(WbShareTransActivity wbShareTransActivity) {
        this.this$0 = wbShareTransActivity;
    }

    /* synthetic */ WbShareTransActivity$CopyResourceTask(WbShareTransActivity wbShareTransActivity, WbShareTransActivity$1 wbShareTransActivity$1) {
        this(wbShareTransActivity);
    }

    /* Access modifiers changed, original: protected|varargs */
    public WbShareTransActivity$TransResourceResult doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        WeiboMultiMessage weiboMultiMessage = weiboMultiMessageArr[0];
        WbShareTransActivity$TransResourceResult wbShareTransActivity$TransResourceResult = new WbShareTransActivity$TransResourceResult(this.this$0, null);
        try {
            if (WbSdk.isWbInstall(this.this$0)) {
                if (WeiboAppManager.queryWbInfoInternal(this.this$0).getSupportVersion() >= ApiUtils.STORY_INT_VER) {
                    if (!(weiboMultiMessage.imageObject == null || weiboMultiMessage.multiImageObject == null)) {
                        weiboMultiMessage.imageObject = null;
                    }
                    if (!(weiboMultiMessage.videoSourceObject == null || (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.imageObject == null))) {
                        weiboMultiMessage.multiImageObject = null;
                        weiboMultiMessage.imageObject = null;
                    }
                } else {
                    weiboMultiMessage.multiImageObject = null;
                    weiboMultiMessage.videoSourceObject = null;
                }
                if (weiboMultiMessage.multiImageObject != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                    while (it.hasNext()) {
                        String copyFileToWeiboTem = ImageUtils.copyFileToWeiboTem(this.this$0, (Uri) it.next(), 1);
                        if (!TextUtils.isEmpty(copyFileToWeiboTem)) {
                            arrayList.add(Uri.fromFile(new File(copyFileToWeiboTem)));
                        }
                    }
                    weiboMultiMessage.multiImageObject.setImageList(arrayList);
                }
                if (weiboMultiMessage.videoSourceObject != null) {
                    String copyFileToWeiboTem2 = ImageUtils.copyFileToWeiboTem(this.this$0, weiboMultiMessage.videoSourceObject.videoPath, 0);
                    weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(copyFileToWeiboTem2));
                    weiboMultiMessage.videoSourceObject.during = ImageUtils.getVideoDuring(copyFileToWeiboTem2);
                }
            }
            wbShareTransActivity$TransResourceResult.message = weiboMultiMessage;
            wbShareTransActivity$TransResourceResult.transDone = true;
        } catch (Exception unused) {
            wbShareTransActivity$TransResourceResult.transDone = false;
        }
        return wbShareTransActivity$TransResourceResult;
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(WbShareTransActivity$TransResourceResult wbShareTransActivity$TransResourceResult) {
        super.onPostExecute(wbShareTransActivity$TransResourceResult);
        WbShareTransActivity.access$300(this.this$0).setVisibility(4);
        if (wbShareTransActivity$TransResourceResult.transDone) {
            WbShareTransActivity.access$400(this.this$0, wbShareTransActivity$TransResourceResult.message);
        } else {
            WbShareTransActivity.access$000(this.this$0, 2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }
}
