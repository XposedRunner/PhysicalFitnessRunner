package com.qiyukf.nim.uikit.session.helper;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.session.activity.CaptureVideoActivity;
import com.qiyukf.nim.uikit.session.activity.PickImageActivity;
import com.qiyukf.nimlib.k.c.b;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.widget.a.g;
import java.io.File;

public final class c {
    private static String a;
    private static File b;

    public interface a {
        void a(File file);
    }

    public static void a(Intent intent, a aVar) {
        String stringExtra;
        if (b == null || !b.exists()) {
            stringExtra = intent.getStringExtra("EXTRA_DATA_FILE_NAME");
            if (!TextUtils.isEmpty(stringExtra)) {
                b = new File(stringExtra);
            }
        }
        if (b != null && b.exists()) {
            if (b.length() <= 0) {
                b.delete();
                return;
            }
            stringExtra = b.getPath();
            String b = com.qiyukf.basesdk.c.c.c.b(stringExtra);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append(".mp4");
            b = com.qiyukf.nimlib.k.c.c.a(stringBuilder.toString(), b.TYPE_VIDEO);
            if (com.qiyukf.basesdk.b.a.c.a.b(stringExtra, b) && aVar != null) {
                aVar.a(new File(b));
            }
        }
    }

    protected static void a(TFragment tFragment) {
        if (com.qiyukf.nimlib.k.c.c.a(b.TYPE_VIDEO)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.a());
            stringBuilder.append(".mp4");
            String a = com.qiyukf.nimlib.k.c.c.a(stringBuilder.toString(), b.TYPE_TEMP);
            a = a;
            if (a == null) {
                stringBuilder = new StringBuilder("videoFilePath = ");
                stringBuilder.append(a);
                stringBuilder.append("this is ");
                Log.e("TAG", stringBuilder.toString());
                return;
            }
            b = new File(a);
            StringBuilder stringBuilder2 = new StringBuilder("videoFile = ");
            stringBuilder2.append(b);
            stringBuilder2.append("this is ");
            Log.e("TAG", stringBuilder2.toString());
            CaptureVideoActivity.start(tFragment, a, 1);
        }
    }

    public static void a(final TFragment tFragment, final int i, final boolean z, final String str, boolean z2) {
        if (tFragment.isAdded()) {
            com.qiyukf.basesdk.c.d.b.a((Fragment) tFragment);
            CharSequence[] charSequenceArr = new CharSequence[3];
            charSequenceArr[0] = tFragment.getString(R.string.ysf_input_panel_take);
            if (z2) {
                charSequenceArr[1] = tFragment.getString(R.string.ysf_pick_video_record);
                charSequenceArr[2] = tFragment.getString(R.string.ysf_picker_image_choose_from_photo_album);
            } else {
                charSequenceArr[1] = tFragment.getString(R.string.ysf_picker_image_choose_from_photo_album);
            }
            g.a(tFragment.getContext(), null, charSequenceArr, new com.qiyukf.unicorn.widget.a.g.a() {
                public final void a(int i) {
                    com.qiyukf.basesdk.c.c a;
                    com.qiyukf.basesdk.c.c.a anonymousClass1;
                    if (i == 0) {
                        a = com.qiyukf.basesdk.c.c.a(tFragment).a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA");
                        anonymousClass1 = new com.qiyukf.basesdk.c.c.a() {
                            public final void onDenied() {
                                com.qiyukf.basesdk.c.d.g.a(R.string.ysf_no_permission_camera);
                            }

                            public final void onGranted() {
                                PickImageActivity.start(tFragment, i, 2, str, z, 1, false, false, 0, 0);
                            }
                        };
                    } else if (i == 1) {
                        a = com.qiyukf.basesdk.c.c.a(tFragment).a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO");
                        anonymousClass1 = new com.qiyukf.basesdk.c.c.a() {
                            public final void onDenied() {
                                com.qiyukf.basesdk.c.d.g.a(R.string.ysf_no_permission_video);
                            }

                            public final void onGranted() {
                                c.a(tFragment);
                            }
                        };
                    } else {
                        if (i == 2) {
                            com.qiyukf.basesdk.c.c.a(tFragment).a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").a(new com.qiyukf.basesdk.c.c.a() {
                                public final void onDenied() {
                                    com.qiyukf.basesdk.c.d.g.a(R.string.ysf_no_permission_photo);
                                }

                                public final void onGranted() {
                                    PickImageActivity.start(tFragment, i, 1, str, z, 9, false, false, 0, 0);
                                }
                            }).a();
                        }
                        return;
                    }
                    a.a(anonymousClass1).a();
                }
            });
        }
    }
}
