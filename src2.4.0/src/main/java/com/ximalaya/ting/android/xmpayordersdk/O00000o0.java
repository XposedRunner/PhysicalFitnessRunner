package com.ximalaya.ting.android.xmpayordersdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$IRequestCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.model.pay.PayInfo;
import com.ximalaya.ting.android.opensdk.model.pay.PayInfo.PriceTypeDetailBean;
import com.ximalaya.ting.android.opensdk.model.pay.PayOderStatue;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PayOrderManager */
public class O00000o0 {
    public static String O000000o = "h5";
    public static Activity O00000Oo;
    protected static O000000o O00000o0;

    /* compiled from: PayOrderManager */
    public interface O000000o {
        public static final String O000000o = "onCreate";
        public static final String O00000Oo = "onStart";
        public static final String O00000o = "onPause";
        public static final String O00000o0 = "onResume";
        public static final String O00000oO = "onStop";
        public static final String O00000oo = "onDestory";
        public static final String O0000O0o = "onRestart";

        void O000000o();
    }

    public static String O000000o() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String O000000o(Collection collection) {
        String str = "";
        if (collection == null || collection.size() <= 0) {
            return str;
        }
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == collection.size() - 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(it.next());
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(it.next());
            stringBuilder2.append(",");
            str = stringBuilder2.toString();
            i++;
        }
        return str;
    }

    public static void O000000o(final long j, @NonNull Context context, O000000o o000000o) {
        O00000Oo(j, new ArrayList<Long>() {
        }, context, o000000o);
    }

    public static void O000000o(long j, List<Long> list, @NonNull Context context, O000000o o000000o) {
        O00000Oo(j, list, context, o000000o);
    }

    public static void O000000o(final Context context) {
        ArrayList arrayList = SharedPreferencesUtil.getInstance(context).getArrayList(DTransferConstants.SHARE_PAY_ORDER_NO);
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                final String str = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("xima_order_no", str);
                    CommonRequest.clientCancelOrder(hashMap, new IDataCallBack<PayOderStatue>() {
                        private void O000000o() {
                            O00000o0.O000000o(context, str);
                        }

                        public final void onError(int i, String str) {
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            O00000o0.O000000o(context, str);
                        }
                    });
                }
            }
        }
    }

    public static void O000000o(Context context, String str) {
        ArrayList arrayList = SharedPreferencesUtil.getInstance(context).getArrayList(DTransferConstants.SHARE_PAY_ORDER_NO);
        if (arrayList != null && arrayList.remove(str)) {
            SharedPreferencesUtil.getInstance(context).saveArrayList(DTransferConstants.SHARE_PAY_ORDER_NO, arrayList);
        }
    }

    public static void O000000o(O000000o o000000o) {
        O00000o0 = o000000o;
    }

    public static void O000000o(String str, final Context context, final O000000o o000000o) {
        HashMap hashMap = new HashMap();
        hashMap.put("xima_order_no", str);
        hashMap.put("invoke_page_type", O000000o);
        CommonRequest.baseGetRequest(DTransferConstants.GET_PAY_URL, hashMap, new IDataCallBack<XimalayaResponse>() {
            private static void O000000o() {
            }

            public final void onError(int i, String str) {
                if (o000000o != null) {
                    o000000o.O000000o(O00000Oo.O000000o(i, str));
                }
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }
        }, new CommonRequest$IRequestCallBack<XimalayaResponse>() {
            private XimalayaResponse O000000o(String str) throws Exception {
                O00000o0.O00000Oo(str, o000000o, context);
                return null;
            }

            public final /* synthetic */ Object success(String str) throws Exception {
                O00000o0.O00000Oo(str, o000000o, context);
                return null;
            }
        });
    }

    @Nullable
    public static List<String> O00000Oo(Context context) {
        return SharedPreferencesUtil.getInstance(context).getArrayList(DTransferConstants.SHARE_PAY_ORDER_NO);
    }

    public static void O00000Oo() {
        if (O00000Oo != null && !O00000Oo.isFinishing()) {
            O00000Oo.finish();
        }
    }

    private static void O00000Oo(long j, final List<Long> list, @NonNull final Context context, final O000000o o000000o) {
        if (context != null && o000000o != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(DTransferConstants.ALBUM_ID, String.valueOf(j));
            CommonRequest.getPriceInfo(hashMap, new IDataCallBack<PayInfo>() {
                private void O000000o(PayInfo payInfo) {
                    if (payInfo == null || payInfo.getPriceTypeDetail() == null || payInfo.getPriceTypeDetail().get(0) == null || ((PriceTypeDetailBean) payInfo.getPriceTypeDetail().get(0)).getDiscountedPrice() <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        if (o000000o != null) {
                            o000000o.O000000o(O00000Oo.O00000Oo(1015));
                        }
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("invoke_page_type", O00000o0.O000000o);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(payInfo.getComposedPriceType());
                    hashMap.put("price_type", stringBuilder.toString());
                    hashMap.put("pay_content", O00000o0.O000000o(list));
                    PriceTypeDetailBean priceTypeDetailBean = (PriceTypeDetailBean) payInfo.getPriceTypeDetail().get(0);
                    String str = "price";
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(priceTypeDetailBean.getDiscountedPrice() <= CropImageView.DEFAULT_ASPECT_RATIO ? priceTypeDetailBean.getPrice() : priceTypeDetailBean.getDiscountedPrice());
                    hashMap.put(str, stringBuilder2.toString());
                    CommonRequest.basePostRequest(DTransferConstants.CLIENT_PLACE_ORDER, hashMap, new IDataCallBack<XimalayaResponse>() {
                        private static void O000000o() {
                        }

                        public final void onError(int i, String str) {
                            if (o000000o != null) {
                                o000000o.O000000o(O00000Oo.O000000o(i, str));
                            }
                        }

                        public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        }
                    }, new CommonRequest$IRequestCallBack<XimalayaResponse>() {
                        private XimalayaResponse O000000o(String str) throws Exception {
                            O00000o0.O00000Oo(str, o000000o, context);
                            return null;
                        }

                        public final /* synthetic */ Object success(String str) throws Exception {
                            O00000o0.O00000Oo(str, o000000o, context);
                            return null;
                        }
                    });
                }

                public final void onError(int i, String str) {
                    if (o000000o != null) {
                        o000000o.O000000o(O00000Oo.O000000o(i, str));
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    PayInfo payInfo = (PayInfo) obj;
                    if (payInfo == null || payInfo.getPriceTypeDetail() == null || payInfo.getPriceTypeDetail().get(0) == null || ((PriceTypeDetailBean) payInfo.getPriceTypeDetail().get(0)).getDiscountedPrice() <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        if (o000000o != null) {
                            o000000o.O000000o(O00000Oo.O00000Oo(1015));
                        }
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("invoke_page_type", O00000o0.O000000o);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(payInfo.getComposedPriceType());
                    hashMap.put("price_type", stringBuilder.toString());
                    hashMap.put("pay_content", O00000o0.O000000o(list));
                    PriceTypeDetailBean priceTypeDetailBean = (PriceTypeDetailBean) payInfo.getPriceTypeDetail().get(0);
                    String str = "price";
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(priceTypeDetailBean.getDiscountedPrice() <= CropImageView.DEFAULT_ASPECT_RATIO ? priceTypeDetailBean.getPrice() : priceTypeDetailBean.getDiscountedPrice());
                    hashMap.put(str, stringBuilder2.toString());
                    CommonRequest.basePostRequest(DTransferConstants.CLIENT_PLACE_ORDER, hashMap, /* anonymous class already generated */, /* anonymous class already generated */);
                }
            });
        }
    }

    private static void O00000Oo(String str, O000000o o000000o, @NonNull Context context) {
        try {
            CharSequence optString;
            JSONObject jSONObject = new JSONObject(str);
            String str2 = null;
            if (jSONObject.has("order_settlement_url")) {
                optString = jSONObject.optString("order_settlement_url");
            } else if (jSONObject.has("error_no")) {
                if (o000000o != null) {
                    o000000o.O000000o(O00000Oo.O000000o(jSONObject.optInt("error_no"), jSONObject.optString("error_desc")));
                }
                return;
            } else {
                optString = null;
            }
            if (jSONObject.has("order_no")) {
                str2 = jSONObject.optString("order_no");
            }
            if (TextUtils.isEmpty(optString)) {
                if (o000000o != null) {
                    o000000o.O000000o(O00000Oo.O00000Oo(102));
                }
            } else if (TextUtils.isEmpty(AccessTokenManager.getInstanse().getUid())) {
                if (o000000o != null) {
                    o000000o.O000000o(O00000Oo.O00000Oo(4));
                }
                if (CommonRequest.getInstanse().getITokenStateChange() != null) {
                    CommonRequest.getInstanse().getITokenStateChange().tokenLosted();
                }
            } else {
                Intent intent = new Intent(context, XmPayOrderActivity.class);
                intent.putExtra(XmPayOrderActivity.O0000Oo, optString);
                str = O000000o();
                intent.putExtra(XmPayOrderActivity.O0000OoO, str);
                intent.putExtra(XmPayOrderActivity.O0000Ooo, str2);
                O00000o.O000000o().O000000o(str, o000000o);
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            if (o000000o != null) {
                o000000o.O000000o(O00000Oo.O00000Oo(102));
            }
        }
    }

    public static boolean O00000o0() {
        return O00000Oo != null;
    }
}
