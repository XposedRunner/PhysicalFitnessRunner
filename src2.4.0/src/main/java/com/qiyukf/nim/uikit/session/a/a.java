package com.qiyukf.nim.uikit.session.a;

import android.content.Intent;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.session.helper.c;
import com.qiyukf.nimlib.k.c.b;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.io.File;
import java.io.Serializable;

public abstract class a extends BaseAction implements Serializable {
    private com.qiyukf.nim.uikit.session.helper.d.a callback = new com.qiyukf.nim.uikit.session.helper.d.a() {
        public final void sendImage(File file, String str, boolean z) {
            a.this.onPicked(file);
        }
    };
    private boolean multiSelect;
    private c pickImageAndVideoHelper;

    protected a(int i, int i2, boolean z) {
        super(i, i2);
        this.multiSelect = z;
    }

    private String tempFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.b());
        stringBuilder.append(".jpg");
        return com.qiyukf.nimlib.k.c.c.a(stringBuilder.toString(), b.TYPE_TEMP);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4) {
            com.qiyukf.nim.uikit.session.helper.d.a(getFragment(), intent, makeRequestCode(6), this.callback);
        } else if (i == 6) {
            com.qiyukf.nim.uikit.session.helper.d.a(getFragment(), intent, i, makeRequestCode(4), this.callback);
        }
    }

    public void onClick() {
        c.a((TFragment) getFragment(), makeRequestCode(4), this.multiSelect, tempFile(), true);
    }

    public abstract void onPicked(File file);
}
