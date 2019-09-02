package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import com.ximalaya.ting.android.opensdk.model.album.BatchAlbumList;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;
import com.ximalaya.ting.android.opensdk.model.pay.BoughtStatuList;
import com.ximalaya.ting.android.opensdk.model.ranks.RankList;
import com.ximalaya.ting.android.opensdk.model.tag.TagList;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.gg;
import defpackage.gk;
import defpackage.kz;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/* compiled from: MusicUtils */
public class O00O00o0 {
    public static final int O000000o = 2;
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;

    public static Cancelable O000000o(final Context context, int i, String str, String str2, final MyCallback<String> myCallback) {
        RequestParams requestParams = new RequestParams(gk.O00OoO0O);
        O000000o(requestParams, context);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("priceType", String.valueOf(i));
            jSONObject.put("payContent", str);
            jSONObject.put("priceString", str2);
            requestParams.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return x.http().post(requestParams, new CommonCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                myCallback.onCancelled(cancelledException);
            }

            public void onError(Throwable th, boolean z) {
                HttpUtil.error(context, th, 1, myCallback);
            }

            public void onFinished() {
                myCallback.onFinished();
            }

            public void onSuccess(String str) {
                ResponseError responseError = (ResponseError) O000o000.O000000o().fromJson(str, ResponseError.class);
                if (responseError.getError() == 10000) {
                    myCallback.onSuccess(O000o000.O000000o().toJson(responseError.getData()));
                } else {
                    myCallback.onError(responseError);
                }
            }
        });
    }

    public static Cancelable O000000o(Context context, String str, int i) {
        RequestParams requestParams = new RequestParams(gk.O00Ooo);
        O000000o(requestParams, context);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ximaOrderNo", str);
            jSONObject.put("ximaOrderStatus", i);
            requestParams.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return x.http().post(requestParams, new CommonCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(Throwable th, boolean z) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
            }
        });
    }

    public static void O000000o(int i, String str, final IDataCallBack<AlbumList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(DTransferConstants.RANK_KEY, str);
        arrayMap.put(DTransferConstants.PAGE_SIZE, "20");
        arrayMap.put(DTransferConstants.PAGE, String.valueOf(i));
        CommonRequest.getRankAlbums(arrayMap, new IDataCallBack<AlbumList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable AlbumList albumList) {
                iDataCallBack.onSuccess(albumList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O000000o(long j, int i, final IDataCallBack<TagList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(DTransferConstants.CATEGORY_ID, String.valueOf(j));
        arrayMap.put("type", String.valueOf(i));
        CommonRequest.getTags(arrayMap, new IDataCallBack<TagList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable TagList tagList) {
                iDataCallBack.onSuccess(tagList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O000000o(long j, final IDataCallBack<BoughtStatuList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ids", String.valueOf(j));
        CommonRequest.getBoughtAlbumStatus(arrayMap, new IDataCallBack<BoughtStatuList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable BoughtStatuList boughtStatuList) {
                iDataCallBack.onSuccess(boughtStatuList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O000000o(long j, String str, int i, int i2, final IDataCallBack<AlbumList> iDataCallBack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getAlbumList() called with: classifyId = [");
        stringBuilder.append(j);
        stringBuilder.append("], tagName = [");
        stringBuilder.append(str);
        stringBuilder.append("], calcDimension = [");
        stringBuilder.append(i);
        stringBuilder.append("], page = [");
        stringBuilder.append(i2);
        stringBuilder.append("]");
        kz.O000000o("TAG", stringBuilder.toString());
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(DTransferConstants.CATEGORY_ID, String.valueOf(j));
        if (!str.equals("全部")) {
            arrayMap.put(DTransferConstants.TAG_NAME, str);
        }
        arrayMap.put(DTransferConstants.CALC_DIMENSION, String.valueOf(i));
        arrayMap.put(DTransferConstants.PAGE, String.valueOf(i2));
        CommonRequest.getAlbumList(arrayMap, new IDataCallBack<AlbumList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable AlbumList albumList) {
                iDataCallBack.onSuccess(albumList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O000000o(final IDataCallBack<CategoryList> iDataCallBack) {
        CommonRequest.getCategories(new ArrayMap(), new IDataCallBack<CategoryList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable CategoryList categoryList) {
                iDataCallBack.onSuccess(categoryList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O000000o(String str, int i, final IDataCallBack<SearchAlbumList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(DTransferConstants.SEARCH_KEY, str);
        arrayMap.put(DTransferConstants.PAGE, String.valueOf(i));
        CommonRequest.getSearchedAlbums(arrayMap, new IDataCallBack<SearchAlbumList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable SearchAlbumList searchAlbumList) {
                iDataCallBack.onSuccess(searchAlbumList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    private static void O000000o(RequestParams requestParams, Context context) {
        String str = "";
        CharSequence charSequence = (String) O00O0Oo0.O00000o0(gg.O000o0O0, "");
        int intValue = ((Integer) O00O0Oo0.O00000o0(gg.O000o0O, Integer.valueOf(-1))).intValue();
        if (TextUtils.isEmpty(charSequence) || intValue == -1) {
            UserInfo O00000o0 = O00Oo0.O00000o0();
            if (!(O00000o0 == null || O00000o0.isLogout())) {
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = O00000o0.getToken();
                }
                if (intValue == -1) {
                    intValue = O00000o0.getUid();
                }
                O00O0Oo0.O000000o(gg.O000o0O0, TextUtils.isEmpty(charSequence) ? "" : charSequence);
                O00O0Oo0.O000000o(gg.O000o0O, Integer.valueOf(intValue));
            }
        }
        String str2 = (String) O00O0Oo0.O00000o0("CustomDeviceId", "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        String stringBuilder2 = stringBuilder.toString();
        if (TextUtils.isEmpty(str2)) {
            str2 = O00Oo0.O00000Oo(context, stringBuilder2);
            O00O0Oo0.O000000o("CustomDeviceId", (Object) str2);
        }
        if (!TextUtils.isEmpty(charSequence) && intValue >= 0) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("timeStamp", stringBuilder2);
            arrayMap.put("token", charSequence);
            arrayMap.put("uid", Integer.valueOf(intValue));
            str = O00O0o.O000000o(arrayMap, context.getString(R.string.md5_sign_salt));
        }
        requestParams.setAsJsonContent(true);
        requestParams.setHeader("Accept", "application/json");
        requestParams.setHeader("Content-Type", "application/json");
        requestParams.setHeader("appVersion", O00Oo0.O00000Oo());
        requestParams.setHeader("DeviceId", O00Oo0.O000000o());
        requestParams.setHeader("osVersion", O000OO.O00000o0());
        requestParams.setHeader("deviceName", O000OO.O0000OOo());
        requestParams.setHeader("osType", "0");
        requestParams.setHeader("CustomDeviceId", str2);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(intValue);
        stringBuilder3.append("");
        requestParams.setHeader("uid", stringBuilder3.toString());
        requestParams.setHeader("token", charSequence);
        requestParams.setHeader("timeStamp", stringBuilder2);
        requestParams.setHeader("tokenSign", str);
        requestParams.setHeader("nonce", O00Oo0.O0000Oo0());
    }

    public static void O00000Oo(long j, int i, final IDataCallBack<TrackList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(DTransferConstants.ALBUM_ID, String.valueOf(j));
        arrayMap.put(DTransferConstants.SORT, "asc");
        arrayMap.put(DTransferConstants.PAGE, String.valueOf(i));
        CommonRequest.getTracks(arrayMap, new IDataCallBack<TrackList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable TrackList trackList) {
                iDataCallBack.onSuccess(trackList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000Oo(long j, final IDataCallBack<BoughtStatuList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ids", String.valueOf(j));
        CommonRequest.getBoughtTrackStatus(arrayMap, new IDataCallBack<BoughtStatuList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable BoughtStatuList boughtStatuList) {
                iDataCallBack.onSuccess(boughtStatuList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000Oo(final IDataCallBack<RankList> iDataCallBack) {
        CommonRequest.getPaidRank(new ArrayMap(), new IDataCallBack<RankList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable RankList rankList) {
                iDataCallBack.onSuccess(rankList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000Oo(String str, int i, final IDataCallBack<AlbumList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        if (!str.equals("全部")) {
            arrayMap.put(DTransferConstants.TAG_NAME, str);
        }
        arrayMap.put(DTransferConstants.PAGE, String.valueOf(i));
        CommonRequest.getPaidAlbumByTag(arrayMap, new IDataCallBack<AlbumList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable AlbumList albumList) {
                iDataCallBack.onSuccess(albumList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000o(final IDataCallBack<AlbumList> iDataCallBack) {
        CommonRequest.getBoughtAlbums(new ArrayMap(), new IDataCallBack<AlbumList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable AlbumList albumList) {
                iDataCallBack.onSuccess(albumList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000o0(long j, int i, final IDataCallBack<TrackList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(DTransferConstants.ALBUM_ID, String.valueOf(j));
        arrayMap.put(DTransferConstants.SORT, "asc");
        arrayMap.put(DTransferConstants.PAGE, String.valueOf(i));
        CommonRequest.getPaidTrackByAlbum(arrayMap, new IDataCallBack<TrackList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable TrackList trackList) {
                iDataCallBack.onSuccess(trackList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000o0(long j, final IDataCallBack<BatchAlbumList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ids", String.valueOf(j));
        CommonRequest.batchGetPaidAlbum(arrayMap, new IDataCallBack<BatchAlbumList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable BatchAlbumList batchAlbumList) {
                iDataCallBack.onSuccess(batchAlbumList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000o0(final IDataCallBack<TagList> iDataCallBack) {
        CommonRequest.getPaidTags(new ArrayMap(), new IDataCallBack<TagList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable TagList tagList) {
                iDataCallBack.onSuccess(tagList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }

    public static void O00000o0(String str, int i, final IDataCallBack<AlbumList> iDataCallBack) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(DTransferConstants.SEARCH_KEY, str);
        arrayMap.put(DTransferConstants.PAGE, String.valueOf(i));
        CommonRequest.searchPaidAlbums(arrayMap, new IDataCallBack<AlbumList>() {
            /* renamed from: O000000o */
            public void onSuccess(@Nullable AlbumList albumList) {
                iDataCallBack.onSuccess(albumList);
            }

            public void onError(int i, String str) {
                iDataCallBack.onError(i, str);
            }
        });
    }
}
