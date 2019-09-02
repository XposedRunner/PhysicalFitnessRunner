package com.qiyukf.unicorn.api.customization.action;

import android.content.Intent;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.session.activity.PickImageActivity;
import com.qiyukf.nim.uikit.session.helper.d.a;
import com.qiyukf.nimlib.k.c.b;
import com.qiyukf.nimlib.k.c.c;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.MessageService;
import java.io.File;

public class CameraAction extends BaseAction {
    int actionFontColor = 0;
    private a callback = new a() {
        public void sendImage(File file, String str, boolean z) {
            MessageService.sendMessage(CameraAction.this.buidlImageMessage(file));
        }
    };

    public CameraAction(int i, int i2) {
        super(i, i2);
    }

    private String tempFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.b());
        stringBuilder.append(".jpg");
        return c.a(stringBuilder.toString(), b.TYPE_TEMP);
    }

    public int getActionFontColor() {
        return this.actionFontColor == 0 ? super.getActionFontColor() : this.actionFontColor;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4) {
            com.qiyukf.nim.uikit.session.helper.d.a(getFragment(), intent, makeRequestCode(6), this.callback);
        } else if (i == 6) {
            com.qiyukf.nim.uikit.session.helper.d.a(getFragment(), intent, i, makeRequestCode(4), this.callback);
        }
    }

    public void onClick() {
        com.qiyukf.basesdk.c.c.a(getFragment()).a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").a(new com.qiyukf.basesdk.c.c.a() {
            public void onDenied() {
                g.a(R.string.ysf_no_permission_camera);
            }

            public void onGranted() {
                PickImageActivity.start(CameraAction.this.getFragment(), CameraAction.this.makeRequestCode(4), 2, CameraAction.this.tempFile(), true, 1, false, false, 0, 0);
            }
        }).a();
    }

    public void setActionFontColor(int i) {
        this.actionFontColor = i;
    }
}
