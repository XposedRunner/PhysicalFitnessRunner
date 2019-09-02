package com.qiyukf.nim.uikit.common.ui.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.qiyukf.nim.uikit.a;
import com.qiyukf.nim.uikit.b;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.ImageLoaderListener;

public class HeadImageView extends ShapedImageView {
    public static final int a = ((int) b.a().getResources().getDimension(R.dimen.ysf_avatar_size));

    public HeadImageView(Context context) {
        super(context);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(String str) {
        int i = a;
        setImageResource(com.qiyukf.nimlib.b.d().userInfoProvider.getDefaultIconResId());
        UserInfo userInfo = com.qiyukf.nimlib.b.d().userInfoProvider.getUserInfo(str);
        if (userInfo == null || !a.b(userInfo.getAvatar())) {
            setTag(null);
            return;
        }
        setTag(userInfo.getAvatar());
        str = userInfo.getAvatar();
        final Object tag = getTag();
        ImageLoaderListener anonymousClass1 = new ImageLoaderListener() {
            public final void onLoadComplete(@NonNull Bitmap bitmap) {
                if (HeadImageView.this.getTag() != null && HeadImageView.this.getTag().equals(tag)) {
                    HeadImageView.this.setImageBitmap(bitmap);
                }
            }

            public final void onLoadFailed(Throwable th) {
            }
        };
        Bitmap a = a.a(str);
        if (a != null) {
            anonymousClass1.onLoadComplete(a);
        } else {
            a.a(str, i, i, anonymousClass1);
        }
    }
}
