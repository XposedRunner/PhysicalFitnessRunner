package com.zjwh.android_wh_physicalfitness.activity.due;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.MapView;
import com.google.gson.reflect.TypeToken;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.media.O0000Oo;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseShareActivity;
import com.zjwh.android_wh_physicalfitness.entity.DrawWinBean;
import com.zjwh.android_wh_physicalfitness.entity.DueRun;
import com.zjwh.android_wh_physicalfitness.entity.DueRunComplete;
import com.zjwh.android_wh_physicalfitness.entity.GetDrawChanceBean;
import com.zjwh.android_wh_physicalfitness.entity.LocJsonEntity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.RoomInfoModel;
import com.zjwh.android_wh_physicalfitness.entity.RoomersModel;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.entity.database.MyLocation;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.view.dialog.LotteryDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.LotteryDialog.O000000o;
import com.zjwh.android_wh_physicalfitness.view.dialog.MyDrawWinDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.MyPrizeResultDialog;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.O00Oo;
import defpackage.O00o000;
import defpackage.by;
import defpackage.cu;
import defpackage.ed;
import defpackage.gf;
import defpackage.gg;
import defpackage.gj;
import defpackage.gk;
import defpackage.la;
import defpackage.lo;
import defpackage.ly;
import defpackage.oO00OOOo;
import defpackage.oOo000Oo;
import defpackage.ooOOO0Oo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class DueRunCompleteActivity extends BaseShareActivity implements O000000o {
    private static final String O00000o0 = "extra_has_draw_chance";
    Handler O000000o = new Handler();
    Runnable O00000Oo = new Runnable() {
        public void run() {
            gj gjVar = new gj(gk.O00O00o);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("drawType", 1);
                jSONObject.put("rrid", DueRunCompleteActivity.this.O000O0o0.getRrid());
                jSONObject.put("signature", HttpUtil.singDraw(1, DueRunCompleteActivity.this.O000O0o0.getRrid()));
                gjVar.setBodyContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            DueRunCompleteActivity.this.O000000o(HttpUtil.postOp(DueRunCompleteActivity.this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    O00Oo00.O000000o("网络连接异常");
                    if (DueRunCompleteActivity.this.O000O0oo != null) {
                        DueRunCompleteActivity.this.O000O0oo.O00000Oo(true);
                    }
                    if (DueRunCompleteActivity.this.O00oOoOo != null) {
                        DueRunCompleteActivity.this.O00oOoOo.O00000Oo();
                    }
                }

                public void onFinished() {
                }

                public void onSuccess(String str) {
                    DueRunCompleteActivity.this.O0000o0();
                    DueRunCompleteActivity.this.O0000OOo();
                    DueRunCompleteActivity.this.O000000o((DrawWinBean) O000o000.O000000o().fromJson(str, DrawWinBean.class));
                }
            }));
        }
    };
    @ViewInject(2131296734)
    private View O00000o;
    @ViewInject(2131296847)
    private MapView O00000oO;
    @ViewInject(2131297394)
    private TextView O00000oo;
    @ViewInject(2131297366)
    private TextView O0000O0o;
    @ViewInject(2131297040)
    private RecyclerView O0000OOo;
    @ViewInject(2131296647)
    private ImageView O0000Oo;
    @ViewInject(2131296786)
    private RelativeLayout O0000Oo0;
    @ViewInject(2131297396)
    private TextView O0000o;
    private int O0000oO = -1;
    private double O0000oO0;
    private DueRunComplete O0000oOO = null;
    private List<List<MyLocation>> O000O00o = new ArrayList();
    private List<Map<String, Object>> O000O0OO = new ArrayList();
    private ed O000O0Oo;
    private Handler O000O0o = new Handler();
    private GetDrawChanceBean O000O0o0;
    private lo O000O0oO;
    private MyDrawWinDialog O000O0oo;
    private Runnable O000OO00 = new Runnable() {
        public void run() {
            for (Map map : DueRunCompleteActivity.this.O000O0OO) {
                DueRunCompleteActivity.this.O000000o(DueRunCompleteActivity.this.O0000o0, (SWLatLng) map.get("latLng"), (String) map.get("iconUrl"), ((Integer) map.get(cu.O000O0oo)).intValue());
            }
        }
    };
    private LotteryDialog O00oOoOo;
    private List<DueRun> O00oOooo = new ArrayList();

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.due.DueRunCompleteActivity$2 */
    class AnonymousClass2 implements ly {
        final /* synthetic */ int O000000o;

        AnonymousClass2(int i) {
            this.O000000o = i;
        }

        public void O000000o(Bitmap bitmap) {
            by byVar;
            String str = "";
            by byVar2 = null;
            switch (this.O000000o) {
                case 0:
                    str = DueRunCompleteActivity.this.getString(R.string.umeng_socialize_text_wechat_no_install);
                    byVar2 = by.WEIXIN;
                    byVar = by.WEIXIN;
                    break;
                case 1:
                    str = DueRunCompleteActivity.this.getString(R.string.umeng_socialize_text_wechat_no_install);
                    byVar2 = by.WEIXIN_CIRCLE;
                    byVar = by.WEIXIN;
                    break;
                case 2:
                    str = DueRunCompleteActivity.this.getString(R.string.umeng_socialize_text_qq_no_install);
                    byVar2 = by.QQ;
                    byVar = by.QQ;
                    break;
                case 3:
                    str = DueRunCompleteActivity.this.getString(R.string.umeng_socialize_text_qq_no_install);
                    byVar2 = by.QZONE;
                    byVar = by.QQ;
                    break;
                case 4:
                    str = DueRunCompleteActivity.this.getString(R.string.umeng_socialize_text_sina_no_install);
                    byVar2 = by.SINA;
                    byVar = by.SINA;
                    break;
                default:
                    byVar = null;
                    break;
            }
            if (byVar == null || UMShareAPI.get(DueRunCompleteActivity.this.getApplicationContext()).isInstall(DueRunCompleteActivity.this, byVar)) {
                if (byVar2 != null) {
                    new ShareAction(DueRunCompleteActivity.this).setPlatform(byVar2).setCallback(DueRunCompleteActivity.this.O00oOooO).withText(DueRunCompleteActivity.this.getResources().getString(R.string.banner_txt_1)).withMedia(new O0000Oo(DueRunCompleteActivity.this.O0000o0, bitmap)).share();
                }
                return;
            }
            O00Oo00.O000000o(DueRunCompleteActivity.this.O0000o0, str);
        }
    }

    static {
        C.i(16777297);
    }

    public static native void O000000o(Activity activity, int i);

    public static native void O000000o(Activity activity, int i, GetDrawChanceBean getDrawChanceBean);

    private void O000000o(Context context, final SWLatLng sWLatLng, String str, int i) {
        try {
            Object str2;
            ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.layout_end_point, null).findViewById(R.id.iv_icon);
            i = i == 0 ? R.drawable.default_round_female : R.drawable.default_round_male;
            O00o000 O00000o0 = O00Oo.O00000o0(context);
            if (TextUtils.isEmpty(str2)) {
                str2 = Integer.valueOf(i);
            }
            O00000o0.O000000o(str2).O0000Oo().O0000O0o(i).O00000oO(i).O000000o(new la(context)).O00000Oo((ooOOO0Oo) new oOo000Oo(imageView) {
                public void O000000o(Bitmap bitmap, oO00OOOo oo00oooo) {
                    super.O000000o((Object) bitmap, oo00oooo);
                    try {
                        DueRunCompleteActivity.this.O000O0oO.O000000o(com.zjwh.android_wh_physicalfitness.utils.O0000Oo.O00000Oo(this.O00000Oo), sWLatLng);
                    } catch (O00000o e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private native void O000000o(Bundle bundle);

    private void O000000o(DrawWinBean drawWinBean) {
        if (drawWinBean != null) {
            if (drawWinBean.isGetPrize()) {
                MyDrawWinDialog O000000o = MyDrawWinDialog.O000000o(drawWinBean);
                if (!isFinishing()) {
                    try {
                        O000000o.show(getSupportFragmentManager(), null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(O00Oo0.O00000oO());
                    stringBuilder.append(gg.O0000ooo);
                    O00O0Oo0.O000000o(stringBuilder.toString(), Boolean.valueOf(true));
                } else {
                    return;
                }
            }
            MyPrizeResultDialog O000000o2 = MyPrizeResultDialog.O000000o(drawWinBean);
            if (!isFinishing()) {
                try {
                    O000000o2.show(getSupportFragmentManager(), null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void O000000o(DrawWinBean drawWinBean, boolean z) {
        if (drawWinBean != null) {
            this.O000O0oo = MyDrawWinDialog.O000000o(drawWinBean);
            if (z) {
                this.O000O0oo.O000000o(true);
                this.O000O0oo.O000000o(new MyDrawWinDialog.O000000o() {
                    public void O000000o() {
                        O00Oo00o.O000000o(DueRunCompleteActivity.this.O0000o0, O00Oo00o.O000000o.O00000oO, "rbutton1");
                        DueRunCompleteActivity.this.O000O0oo.O00000Oo(false);
                        DueRunCompleteActivity.this.O000000o.post(DueRunCompleteActivity.this.O00000Oo);
                    }
                });
            }
            if (!isFinishing()) {
                try {
                    this.O000O0oo.show(getSupportFragmentManager(), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O00Oo0.O00000oO());
                stringBuilder.append(gg.O0000ooo);
                O00O0Oo0.O000000o(stringBuilder.toString(), Boolean.valueOf(true));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d A:{Catch:{ Exception -> 0x00c8, all -> 0x00c5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d A:{Catch:{ Exception -> 0x00c8, all -> 0x00c5 }} */
    private synchronized void O000000o(java.util.List<com.zjwh.android_wh_physicalfitness.entity.database.MyLocation> r28, java.lang.String r29, int r30) {
        /*
        r27 = this;
        r1 = r27;
        r2 = r29;
        monitor-enter(r27);
        if (r28 == 0) goto L_0x00d0;
    L_0x0007:
        r4 = r28.size();	 Catch:{ Exception -> 0x00c8 }
        if (r4 <= 0) goto L_0x00d0;
    L_0x000d:
        r4 = 0;
        r5 = r1.O000O0oO;	 Catch:{ Exception -> 0x00c8 }
        r5.O00000o();	 Catch:{ Exception -> 0x00c8 }
        r3 = r28.iterator();	 Catch:{ Exception -> 0x00c8 }
    L_0x0017:
        r5 = r3.hasNext();	 Catch:{ Exception -> 0x00c8 }
        if (r5 == 0) goto L_0x00d0;
    L_0x001d:
        r5 = r3.next();	 Catch:{ Exception -> 0x00c8 }
        r5 = (com.zjwh.android_wh_physicalfitness.entity.database.MyLocation) r5;	 Catch:{ Exception -> 0x00c8 }
        r6 = r5.getType();	 Catch:{ Exception -> 0x00c8 }
        r7 = -1;
        if (r6 != r7) goto L_0x002b;
    L_0x002a:
        goto L_0x0017;
    L_0x002b:
        r6 = new com.zjwh.sw.map.entity.SWLatLng;	 Catch:{ Exception -> 0x00c8 }
        r9 = r5.getgLat();	 Catch:{ Exception -> 0x00c8 }
        r11 = r5.getgLng();	 Catch:{ Exception -> 0x00c8 }
        r13 = r5.getLat();	 Catch:{ Exception -> 0x00c8 }
        r15 = r5.getLng();	 Catch:{ Exception -> 0x00c8 }
        r8 = r6;
        r8.<init>(r9, r11, r13, r15);	 Catch:{ Exception -> 0x00c8 }
        if (r4 == 0) goto L_0x007f;
    L_0x0043:
        r7 = new com.zjwh.sw.map.entity.SWLatLng;	 Catch:{ Exception -> 0x00c8 }
        r18 = r4.getgLat();	 Catch:{ Exception -> 0x00c8 }
        r20 = r4.getgLng();	 Catch:{ Exception -> 0x00c8 }
        r22 = r4.getLat();	 Catch:{ Exception -> 0x00c8 }
        r24 = r4.getLng();	 Catch:{ Exception -> 0x00c8 }
        r17 = r7;
        r17.<init>(r18, r20, r22, r24);	 Catch:{ Exception -> 0x00c8 }
        r8 = r5.getBdD();	 Catch:{ Exception -> 0x00c8 }
        r9 = r4.getBdD();	 Catch:{ Exception -> 0x00c8 }
        r8 = r8 - r9;
        r9 = r1.O000O0oO;	 Catch:{ Exception -> 0x00c8 }
        r11 = r1.O0000oO0;	 Catch:{ Exception -> 0x00c8 }
        r13 = r5.getType();	 Catch:{ Exception -> 0x00c8 }
        r14 = r5.getSpeed();	 Catch:{ Exception -> 0x00c8 }
        r26 = r3;
        r2 = (double) r8;	 Catch:{ Exception -> 0x00c8 }
        r18 = r4.getType();	 Catch:{ Exception -> 0x00c8 }
        r8 = r9;
        r9 = r7;
        r10 = r6;
        r16 = r2;
        r8.O000000o(r9, r10, r11, r13, r14, r16, r18);	 Catch:{ Exception -> 0x00c8 }
        goto L_0x0081;
    L_0x007f:
        r26 = r3;
    L_0x0081:
        r2 = r5.getType();	 Catch:{ Exception -> 0x00c8 }
        r3 = 5;
        if (r2 != r3) goto L_0x008d;
    L_0x0088:
        r2 = r1.O000O0oO;	 Catch:{ Exception -> 0x00c8 }
        r2.O000000o(r6);	 Catch:{ Exception -> 0x00c8 }
    L_0x008d:
        r2 = r5.getType();	 Catch:{ Exception -> 0x00c8 }
        r3 = 6;
        if (r2 != r3) goto L_0x00bb;
    L_0x0094:
        r2 = r1.O0000o0;	 Catch:{ Exception -> 0x00c8 }
        r4 = r30;
        r3 = r29;
        r1.O000000o(r2, r6, r3, r4);	 Catch:{ Exception -> 0x00c8 }
        r2 = new java.util.HashMap;	 Catch:{ Exception -> 0x00c8 }
        r2.<init>();	 Catch:{ Exception -> 0x00c8 }
        r7 = "latLng";
        r2.put(r7, r6);	 Catch:{ Exception -> 0x00c8 }
        r6 = "iconUrl";
        r2.put(r6, r3);	 Catch:{ Exception -> 0x00c8 }
        r6 = "sex";
        r7 = java.lang.Integer.valueOf(r30);	 Catch:{ Exception -> 0x00c8 }
        r2.put(r6, r7);	 Catch:{ Exception -> 0x00c8 }
        r6 = r1.O000O0OO;	 Catch:{ Exception -> 0x00c8 }
        r6.add(r2);	 Catch:{ Exception -> 0x00c8 }
        goto L_0x00bf;
    L_0x00bb:
        r4 = r30;
        r3 = r29;
    L_0x00bf:
        r2 = r3;
        r4 = r5;
        r3 = r26;
        goto L_0x0017;
    L_0x00c5:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00ce;
    L_0x00c8:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();	 Catch:{ all -> 0x00c5 }
        goto L_0x00d0;
    L_0x00ce:
        monitor-exit(r27);
        throw r2;
    L_0x00d0:
        monitor-exit(r27);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.activity.due.DueRunCompleteActivity.O000000o(java.util.List, java.lang.String, int):void");
    }

    private void O000000o(final boolean z) {
        gj gjVar = new gj(gk.O00O00o0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rrid", this.O000O0o0.getRrid());
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                DueRunCompleteActivity.this.O000000o((DrawWinBean) O000o000.O000000o().fromJson(str, DrawWinBean.class), z);
            }
        }));
    }

    private native void O00000Oo(Bundle bundle);

    private void O0000O0o() {
        if (this.O000O0o0 != null) {
            if (this.O000O0o0.getLuckyDrawCondition() == 1) {
                this.O00oOoOo = LotteryDialog.O000000o();
                this.O00oOoOo.O000000o((O000000o) this);
                if (!isFinishing()) {
                    try {
                        this.O00oOoOo.show(getSupportFragmentManager(), null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (this.O000O0o0.getLuckyDrawCondition() == 2) {
                O000000o(true);
            } else if (this.O000O0o0.getLuckyDrawCondition() == 3) {
                O000000o(false);
            }
        }
    }

    private void O0000OOo() {
        try {
            if (this.O00oOoOo != null && this.O00oOoOo.getDialog() != null && this.O00oOoOo.getDialog().isShowing()) {
                this.O00oOoOo.dismiss();
                this.O00oOoOo = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O0000o() {
        if (this.O000O00o != null && this.O000O00o.size() > 0) {
            List arrayList = new ArrayList();
            for (List<MyLocation> it : this.O000O00o) {
                for (MyLocation myLocation : it) {
                    arrayList.add(new SWLatLng(myLocation.getgLat(), myLocation.getgLng(), myLocation.getLat(), myLocation.getLng()));
                }
            }
            arrayList.add(new SWLatLng(-1.0d, -1.0d, this.O0000oOO.getRoomInfoModel().getLocLat() / 1000000.0d, this.O0000oOO.getRoomInfoModel().getLocLon() / 1000000.0d));
            this.O000O0oO.O000000o(arrayList);
        }
    }

    private void O0000o0() {
        try {
            if (this.O000O0oo != null && this.O000O0oo.getDialog() != null && this.O000O0oo.getDialog().isShowing()) {
                this.O000O0oo.dismiss();
                this.O000O0oo = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private native void O0000o0O();

    private void O0000o0o() {
        try {
            this.O00oOooo.clear();
            this.O000O00o.clear();
            if (this.O0000oOO != null) {
                RoomInfoModel roomInfoModel = this.O0000oOO.getRoomInfoModel();
                List<RoomersModel> roomersModelList = this.O0000oOO.getRoomersModelList();
                if (roomInfoModel != null) {
                    this.O00000oo.setText(roomInfoModel.getRoomName());
                    this.O0000O0o.setText(roomInfoModel.getLocDesc());
                }
                if (roomersModelList != null && roomersModelList.size() > 0) {
                    RoomersModel roomersModel = null;
                    for (final RoomersModel roomersModel2 : roomersModelList) {
                        if (roomersModel2.isIniter()) {
                            roomersModel = roomersModel2;
                        }
                        LocJsonEntity locJsonEntity = (LocJsonEntity) this.O0000OoO.fromJson(roomersModel2.getPoints(), LocJsonEntity.class);
                        if (locJsonEntity != null) {
                            try {
                                final List list = locJsonEntity.getUseZip() ? (List) this.O0000OoO.fromJson(O00Oo0.O00000Oo(locJsonEntity.getAllLocJson()), new TypeToken<List<MyLocation>>() {
                                }.getType()) : (List) this.O0000OoO.fromJson(locJsonEntity.getAllLocJson(), new TypeToken<List<MyLocation>>() {
                                }.getType());
                                if (list != null && list.size() > 0) {
                                    new Handler().post(new Runnable() {
                                        public void run() {
                                            DueRunCompleteActivity.this.O000000o(list, roomersModel2.getIcon(), roomersModel2.getSex());
                                        }
                                    });
                                    this.O000O00o.add(list);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        DueRun dueRun = new DueRun();
                        dueRun.setIcon(roomersModel2.getIcon());
                        dueRun.setSex(roomersModel2.getSex());
                        dueRun.setTotalNum(roomersModel2.isFinished());
                        this.O00oOooo.add(dueRun);
                    }
                    if (roomersModel != null) {
                        O00Oo0.O000000o(this, roomersModel.getIcon(), this.O0000Oo, roomersModel.getSex());
                    }
                    this.O0000o.setText(String.format(Locale.getDefault(), "%d/6", new Object[]{Integer.valueOf(this.O00oOooo.size())}));
                    this.O000O0Oo.notifyDataSetChanged();
                    this.O000O0o.postDelayed(this.O000OO00, 1000);
                }
            }
            O0000o();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void O0000oO0() {
        O00000oO(getString(R.string.txt_loading));
        gj gjVar = new gj(gk.O000O0o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(gg.O0000Ooo, this.O0000oO);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
                DueRunCompleteActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                if (!DueRunCompleteActivity.this.isFinishing()) {
                    try {
                        DueRunCompleteActivity.this.O0000oOO = (DueRunComplete) DueRunCompleteActivity.this.O0000OoO.fromJson(str, DueRunComplete.class);
                        DueRunCompleteActivity.this.O000O0oO.O00000Oo(new SWLatLng(-1.0d, -1.0d, DueRunCompleteActivity.this.O0000oOO.getRoomInfoModel().getLocLat() / 1000000.0d, DueRunCompleteActivity.this.O0000oOO.getRoomInfoModel().getLocLon() / 1000000.0d));
                        DueRunCompleteActivity.this.O0000o0o();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }));
    }

    @Event({2131296740, 2131296369})
    private void topClickEvent(View view) {
        int id = view.getId();
        if (id == R.id.btn_share) {
            com.zjwh.android_wh_physicalfitness.utils.O00000o.O000000o(view, new Runnable() {
                public void run() {
                    if (!DueRunCompleteActivity.this.isFinishing()) {
                        O00O00o.O00000oO(DueRunCompleteActivity.this);
                    }
                }
            });
        } else if (id == R.id.left_image) {
            finish();
        }
    }

    public native int O000000o();

    public native void O000000o(int i);

    @PermissionSuccess(requestCode = 102)
    public void O00000o() {
        O0000Oo0();
    }

    @PermissionFail(requestCode = 102)
    public void O00000oO() {
        O00O00o.O000000o(this, 102);
    }

    public void O00000oo() {
        O00Oo00o.O000000o(this.O0000o0, O00Oo00o.O000000o.O00000oO, "rbutton2");
        this.O000000o.postDelayed(this.O00000Oo, 500);
    }

    public void n_() {
        RunRuleModel O00000Oo = O0000o.O00000Oo();
        this.O0000oO0 = gf.O0000o;
        if (O00000Oo != null) {
            this.O0000oO0 = O00000Oo.getSpeedTop() > 0.0d ? O00000Oo.getSpeedTop() : gf.O0000o;
        }
    }

    public native void onCreate(Bundle bundle);

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        O0000OOo();
        O0000o0();
        super.onDestroy();
        if (this.O000O0oO != null) {
            this.O000O0oO.O00000o0();
            this.O000O0oO = null;
        }
        if (this.O000O0o != null) {
            this.O000O0o.removeCallbacks(this.O000OO00);
            this.O000OO00 = null;
            this.O000O0o = null;
        }
        if (this.O000O0OO != null) {
            this.O000O0OO.clear();
            this.O000O0OO = null;
        }
        if (this.O000O00o != null) {
            this.O000O00o.clear();
            this.O000O00o = null;
        }
        if (this.O00oOooo != null) {
            this.O00oOooo.clear();
            this.O00oOooo = null;
        }
        if (this.O00oOoOo != null) {
            try {
                this.O00oOoOo.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.O000000o != null && this.O00000Oo != null) {
            this.O000000o.removeCallbacks(this.O00000Oo);
            this.O000000o = null;
            this.O00000Oo = null;
        }
    }

    public native void onPause();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionGen.onRequestPermissionsResult((Activity) this, i, strArr, iArr);
    }

    public native void onResume();

    public native void onSaveInstanceState(Bundle bundle);
}
