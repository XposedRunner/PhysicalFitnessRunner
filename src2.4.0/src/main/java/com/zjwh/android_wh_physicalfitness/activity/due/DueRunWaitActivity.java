package com.zjwh.android_wh_physicalfitness.activity.due;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.MapView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o;
import com.zjwh.android_wh_physicalfitness.entity.DueRunInOrOut;
import com.zjwh.android_wh_physicalfitness.entity.DueRunReqParam;
import com.zjwh.android_wh_physicalfitness.entity.DueRunWait;
import com.zjwh.android_wh_physicalfitness.entity.DueRunWaitBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.service.RunLocationService;
import com.zjwh.android_wh_physicalfitness.service.RunLocationService.O00000o0;
import com.zjwh.android_wh_physicalfitness.ui.run.RunDueActivity;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000o;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.O00Oo;
import defpackage.fv;
import defpackage.gg;
import defpackage.gj;
import defpackage.gk;
import defpackage.la;
import defpackage.lm;
import defpackage.oO00OOOo;
import defpackage.oOo000Oo;
import defpackage.ooOOO0Oo;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class DueRunWaitActivity extends BaseActivity {
    private static final String O0000OOo = "roomId";
    private static final int O0000Oo0 = 6;
    @ViewInject(2131296668)
    public ImageView O000000o;
    @ViewInject(2131297366)
    public TextView O00000Oo;
    @ViewInject(2131297396)
    public TextView O00000o;
    @ViewInject(2131297412)
    public TextView O00000o0;
    @ViewInject(2131296365)
    public TextView O00000oO;
    Handler O00000oo = new Handler();
    Runnable O0000O0o = new Runnable() {
        public void run() {
            DueRunWaitActivity.this.O0000o0o();
        }
    };
    @ViewInject(2131296734)
    private View O0000Oo;
    @ViewInject(2131296650)
    private ImageView O0000o;
    @ViewInject(2131297228)
    private TextView O0000oO;
    @ViewInject(2131297227)
    private TextView O0000oO0;
    @ViewInject(2131297394)
    private TextView O0000oOO;
    @ViewInject(2131296682)
    private ImageView O0000oOo;
    @ViewInject(2131296945)
    private RecyclerView O0000oo;
    @ViewInject(2131296847)
    private MapView O0000oo0;
    private lm O0000ooO;
    private RunLocationService O0000ooo;
    private AnimatorSet O000O00o;
    private Dialog O000O0OO;
    private DueRunWaitBean O000O0Oo;
    private long O000O0o;
    private long O000O0o0 = 0;
    private int O000O0oO = -1;
    private int O000O0oo = -1;
    private boolean O000OO = false;
    private SWLatLng O000OO00;
    private boolean O000OO0o = false;
    private boolean O000OOOo = false;
    private O00000o0 O000OOo = new O00000o0() {
        public void O000000o(double d, double d2, double d3, double d4, float f) {
            DueRunWaitActivity.this.O000OO00 = new SWLatLng(d, d2, d3, d2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - DueRunWaitActivity.this.O000O0o0 > O000000o.O00000o) {
                DueRunWaitActivity.this.O0000ooO.O000000o(d, d2);
                DueRunWaitActivity.this.O000O0o0 = currentTimeMillis;
            }
        }

        public void O000000o(final long j) {
            if (!DueRunWaitActivity.this.isFinishing()) {
                DueRunWaitActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        long O0000O0o = DueRunWaitActivity.this.O000O0o - (j * 1000);
                        if (O0000O0o > 0) {
                            DueRunWaitActivity.this.O00000o0.setText(O000O0o0.O000000o(O000O0o0.O0000Oo0, O0000O0o));
                            return;
                        }
                        if (DueRunWaitActivity.this.O000OOOo) {
                            DueRunWaitActivity.this.O0000o0O();
                        }
                        if (DueRunWaitActivity.this.O000OO) {
                            RunDueActivity.O000000o(DueRunWaitActivity.this, DueRunWaitActivity.this.O000O0oO);
                            DueRunWaitActivity.this.finish();
                            return;
                        }
                        DueRunWaitActivity.this.O000000o("房间已不存在", "此房间已解散或约跑已经开始");
                    }
                });
            }
        }

        public void O00000Oo(long j) {
        }
    };
    private ServiceConnection O000OOo0 = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DueRunWaitActivity.this.O0000ooo = ((RunLocationService.O000000o) iBinder).O000000o();
            DueRunWaitActivity.this.O0000ooo.O000000o(DueRunWaitActivity.this.O000OOo);
            DueRunWaitActivity.this.O000OO0o = true;
            DueRunWaitActivity.this.O0000o0o();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            DueRunWaitActivity.this.O000OO0o = false;
            if (DueRunWaitActivity.this.O0000ooo != null) {
                DueRunWaitActivity.this.O0000ooo.O00000Oo();
                DueRunWaitActivity.this.O0000ooo = null;
            }
        }
    };
    private DueRunWait O00oOoOo;
    private O0000Oo O00oOooO;
    private fv O00oOooo;

    static {
        C.i(16777299);
    }

    @Event({2131296740, 2131296365, 2131296682})
    private void MyClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_enter) {
            if (id == R.id.iv_condition) {
                this.O000O00o = O00000o.O00000Oo(view);
                O0000Oo0();
            } else if (id == R.id.left_image) {
                onBackPressed();
            }
        } else if (this.O00oOoOo != null) {
            if (O00000oo() == this.O00oOoOo.getUid() || this.O000OO) {
                if (O00000oo() != this.O00oOoOo.getUid() && this.O000OO) {
                    O0000Oo O000000o = new O0000Oo(this.O0000o0).O000000o().O000000o(false).O00000Oo(false).O000000o("约跑提示");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("约跑还有");
                    stringBuilder.append(this.O00000o0.getText());
                    stringBuilder.append("就要开始了，您确认要退出当前组队吗？");
                    O000000o.O00000Oo(stringBuilder.toString()).O000000o((int) R.string.txt_out, new OnClickListener() {
                        public void onClick(View view) {
                            DueRunWaitActivity.this.O00000Oo(2);
                        }
                    }).O00000Oo((int) R.string.txt_stay, null).O00000Oo();
                } else if (O00000oo() == this.O00oOoOo.getUid()) {
                    O0000o();
                }
            } else if (this.O000OO00 != null && this.O000OO00.getBLat() > 0.0d && this.O000OO00.getBLon() > 0.0d) {
                this.O00000oO.setEnabled(false);
                this.O00000oO.setText(R.string.entering);
                O00000Oo(1);
            }
        }
    }

    private native void O000000o(int i);

    public static native void O000000o(Activity activity, int i);

    private void O000000o(Context context, final DueRunWait dueRunWait) {
        try {
            ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.layout_end_point, null).findViewById(R.id.iv_icon);
            int i = dueRunWait.getSex() == 0 ? R.drawable.default_round_female : R.drawable.default_round_male;
            O00Oo.O00000o0(context).O000000o(TextUtils.isEmpty(dueRunWait.getIcon()) ? Integer.valueOf(i) : dueRunWait.getIcon()).O0000Oo().O0000O0o(i).O00000oO(i).O000000o(new la(context)).O00000Oo((ooOOO0Oo) new oOo000Oo(imageView) {
                public void O000000o(Bitmap bitmap, oO00OOOo oo00oooo) {
                    super.O000000o((Object) bitmap, oo00oooo);
                    Bitmap O00000Oo = com.zjwh.android_wh_physicalfitness.utils.O0000Oo.O00000Oo(this.O00000Oo);
                    if (O00000Oo != null) {
                        try {
                            DueRunWaitActivity.this.O0000ooO.O000000o(O00000Oo, dueRunWait.getLat(), dueRunWait.getLon());
                        } catch (com.zjwh.sw.map.O00000o e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private native void O000000o(Bundle bundle);

    private native void O000000o(String str, String str2);

    private void O00000Oo(final int i) {
        if (!isFinishing() && this.O000OO00 != null && this.O000OO00.getBLat() > 0.0d && this.O000OO00.getBLon() > 0.0d) {
            O00000oO(getString(i == 1 ? R.string.entering : R.string.outing));
            DueRunReqParam dueRunReqParam = new DueRunReqParam(O00000oo(), this.O000OO00.getBLon(), this.O000OO00.getBLat(), i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/api/v8/");
            stringBuilder.append(this.O000O0oO);
            stringBuilder.append("/room/inout");
            gj gjVar = new gj(stringBuilder.toString());
            gjVar.setBodyContent(this.O0000OoO.toJson(dueRunReqParam));
            HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    DueRunWaitActivity.this.O0000OoO();
                    TextView textView = DueRunWaitActivity.this.O00000oO;
                    CharSequence charSequence = DueRunWaitActivity.this.O00000oo() == DueRunWaitActivity.this.O00oOoOo.getUid() ? "立即开始" : DueRunWaitActivity.this.O000OO ? "退出组队" : "加入房间";
                    textView.setText(charSequence);
                    DueRunWaitActivity.this.O00000oO.setEnabled(true);
                    if (responseError.getError() == 10907) {
                        DueRunWaitActivity.this.O000000o("房间已不存在", responseError.getMessage());
                    } else if (responseError.getError() == 10932) {
                        DueRunWaitActivity.this.O000000o("加入房间失败", responseError.getMessage(), new OnClickListener() {
                            public void onClick(View view) {
                                DueRunWaitActivity.this.O0000o0o();
                            }
                        });
                    } else {
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }

                public void onFinished() {
                }

                public void onSuccess(String str) {
                    if (i == 2) {
                        DueRunWaitActivity.this.O0000OoO();
                        Context context = DueRunWaitActivity.this;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(DueRunWaitActivity.this.O00000oo());
                        stringBuilder.append(gg.O000OO00);
                        O00O0Oo0.O000000o(context, stringBuilder.toString());
                        DueRunWaitActivity.this.O000OO = false;
                        DueRunWaitActivity.this.finish();
                    } else if (i == 1) {
                        DueRunWaitActivity.this.O0000o0o();
                    }
                }
            });
        }
    }

    private native void O00000Oo(Bundle bundle);

    private void O00000Oo(String str, String str2, OnClickListener onClickListener) {
        if (this.O00oOooO == null) {
            if (onClickListener == null) {
                onClickListener = new OnClickListener() {
                    public void onClick(View view) {
                        Context context = DueRunWaitActivity.this;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(DueRunWaitActivity.this.O00000oo());
                        stringBuilder.append(gg.O000OO00);
                        O00O0Oo0.O000000o(context, stringBuilder.toString());
                        DueRunWaitActivity.this.finish();
                    }
                };
            }
            this.O00oOooO = O000000o(str, str2, onClickListener);
            if (this.O00000oo != null && this.O0000O0o != null) {
                this.O00000oo.removeCallbacks(this.O0000O0o);
            }
        }
    }

    private native int O00000oo();

    private native void O0000O0o();

    private void O0000OOo() {
        if (!isFinishing()) {
            TextView textView;
            this.O00000oO.setEnabled(true);
            List<DueRunWait> roomMember = this.O000O0Oo.getRoomMember();
            if (roomMember != null && roomMember.size() > 0) {
                this.O00oOoOo = (DueRunWait) roomMember.get(0);
                textView = this.O00000oO;
                CharSequence charSequence = O00000oo() == this.O00oOoOo.getUid() ? "立即开始" : this.O000OO ? "退出组队" : "加入房间";
                textView.setText(charSequence);
                this.O00000oO.setEnabled(true);
                this.O00oOooo.O000000o(roomMember);
                O00O0O0o.O000000o(this.O0000o0, this.O00oOoOo.getIcon(), this.O000000o, this.O00oOoOo.getSex());
                this.O00000Oo.setText(this.O000O0Oo.getLocDesc());
                this.O0000oOO.setText(this.O000O0Oo.getRoomName());
                O000000o(this.O000O0Oo.getRoomMember() != null ? this.O000O0Oo.getRoomMember().size() : 0);
                try {
                    this.O0000ooO.O000000o(((double) this.O000O0Oo.getLocLat()) / 1000000.0d, ((double) this.O000O0Oo.getLocLon()) / 1000000.0d, this.O000O0Oo.getLocDesc());
                } catch (com.zjwh.sw.map.O00000o e) {
                    e.printStackTrace();
                }
                this.O0000ooO.O00000o();
                for (DueRunWait O000000o : roomMember) {
                    O000000o(this.O0000o0, O000000o);
                }
            }
            if (this.O000O0Oo.getInOrOutMember() != null && this.O000O0Oo.getInOrOutMember().size() > 0) {
                DueRunInOrOut dueRunInOrOut = (DueRunInOrOut) this.O000O0Oo.getInOrOutMember().get(0);
                O00Oo0.O000000o(this, dueRunInOrOut.getHeadImgUrl(), this.O0000o, dueRunInOrOut.getGender());
                textView = this.O0000oO0;
                String str = "%s%s";
                Object[] objArr = new Object[2];
                objArr[0] = dueRunInOrOut.getName();
                objArr[1] = dueRunInOrOut.getInOrOutRoom() == 1 ? "加入房间" : "退出房间";
                textView.setText(String.format(str, objArr));
                this.O0000oO.setText(O000O0o0.O000000o(this.O0000o0, dueRunInOrOut.getInOrOutTime()));
            }
        }
    }

    private native void O0000Oo0();

    private void O0000o() {
        gj gjVar = new gj(gk.O000OO);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("roomId", String.valueOf(this.O000O0oO));
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!DueRunWaitActivity.this.isFinishing()) {
                    if (responseError.getError() == 10934) {
                        DueRunWaitActivity.this.O00000Oo("约跑提示", responseError.getMessage());
                    } else {
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (DueRunWaitActivity.this.O000OOOo) {
                    DueRunWaitActivity.this.O0000o0O();
                }
                RunDueActivity.O000000o(DueRunWaitActivity.this, DueRunWaitActivity.this.O000O0oO);
                DueRunWaitActivity.this.finish();
            }
        });
    }

    private native void O0000o0();

    private native void O0000o0O();

    private native void O0000o0o();

    public native int O000000o();

    public native void O00000Oo();

    @PermissionSuccess(requestCode = 101)
    public void O00000o() {
        this.O000OOOo = true;
        O0000o0();
    }

    @PermissionFail(requestCode = 101)
    public void O00000oO() {
        O00O00o.O000000o(this, 101);
    }

    public void n_() {
    }

    public native void onBackPressed();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onPause();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();

    public native void onSaveInstanceState(Bundle bundle);
}
