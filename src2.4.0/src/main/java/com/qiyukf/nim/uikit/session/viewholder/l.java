package com.qiyukf.nim.uikit.session.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.qiyukf.basesdk.c.a.b;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.basesdk.c.d.f;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.common.ui.imageview.MsgThumbImageView;
import com.qiyukf.nim.uikit.session.activity.WatchVideoActivity;
import com.qiyukf.nimlib.k.b.b.a;
import com.qiyukf.nimlib.k.c.c;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.unicorn.R;
import java.io.File;

public class l extends i {
    a a;
    VideoAttachment b;
    private TextView c;
    private TextView g;

    static /* synthetic */ void b(l lVar) {
        if (lVar.b.getPath() == null) {
            g.a("请先下载视频");
        }
        String b = c.b();
        if (TextUtils.isEmpty(lVar.b.getExtension())) {
            g.a(R.string.ysf_video_save_fail);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("video_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(".mp4");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(b);
        stringBuilder3.append(stringBuilder2);
        stringBuilder2 = stringBuilder3.toString();
        if (com.qiyukf.basesdk.b.a.c.a.a(lVar.b.getPath(), stringBuilder2) != -1) {
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(new File(stringBuilder2)));
                lVar.context.sendBroadcast(intent);
                stringBuilder = new StringBuilder();
                stringBuilder.append(lVar.context.getString(R.string.ysf_video_save_to));
                stringBuilder.append(b);
                stringBuilder.append("查看");
                g.b(stringBuilder.toString());
                return;
            } catch (Exception unused) {
                g.b(R.string.ysf_picture_save_fail);
                return;
            }
        }
        g.a(R.string.ysf_video_save_fail);
    }

    /* Access modifiers changed, original: protected|final */
    public final String a(String str) {
        VideoAttachment videoAttachment = (VideoAttachment) this.message.getAttachment();
        String thumbPathForSave = videoAttachment.getThumbPathForSave();
        return com.qiyukf.nimlib.k.b.a.a(str, thumbPathForSave, videoAttachment.getWidth(), videoAttachment.getHeight()) ? thumbPathForSave : null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        this.a = aVar;
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.d.setLayoutParams(layoutParams);
        setLayoutParams(aVar.a, aVar.b, this.f);
    }

    /* Access modifiers changed, original: protected|final */
    public final int[] a() {
        VideoAttachment videoAttachment = (VideoAttachment) this.message.getAttachment();
        return new int[]{videoAttachment.getWidth(), videoAttachment.getHeight()};
    }

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        super.bindContentView();
        this.b = (VideoAttachment) this.message.getAttachment();
        long a = f.a(this.b.getDuration());
        TextView textView = this.c;
        StringBuilder stringBuilder = a < 10 ? new StringBuilder("00:0") : new StringBuilder("00:");
        stringBuilder.append(a);
        textView.setText(stringBuilder.toString());
        this.g.setText(b.a(this.b.getSize()));
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_video;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        super.inflateContentView();
        this.g = (TextView) findViewById(R.id.tv_ysf_item_message_size);
        this.c = (TextView) findViewById(R.id.tv_ysf_item_message_duration);
    }

    /* Access modifiers changed, original: protected */
    public void onItemClick() {
        WatchVideoActivity.start(this.context, this.message, false);
    }

    /* Access modifiers changed, original: protected */
    public boolean onItemLongClick() {
        MsgThumbImageView msgThumbImageView = this.d;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.ysf_popup_video_msg_item, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, d.a(100.0f), d.a(30.0f), true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.ysf_tv_popup_video_voice);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ysf_tv_popup_video_save);
        textView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                popupWindow.dismiss();
                WatchVideoActivity.start(l.this.context, l.this.message, true);
            }
        });
        textView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                popupWindow.dismiss();
                l.b(l.this);
            }
        });
        LayoutParams layoutParams = (LayoutParams) msgThumbImageView.getLayoutParams();
        popupWindow.showAsDropDown(msgThumbImageView, (layoutParams.width / 2) - d.a(50.0f), -(layoutParams.height + d.a(30.0f)));
        return true;
    }
}
