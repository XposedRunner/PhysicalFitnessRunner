package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.channel.a.a.a;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Resp;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.net.URLEncoder;

final class WXApiImplV10 implements IWXAPI {
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname;
    private String appId;
    private boolean checkSignature = false;
    private Context context;
    private boolean detached = false;

    WXApiImplV10(Context context, String str, boolean z) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("<init>, appId = ");
        stringBuilder.append(str);
        stringBuilder.append(", checkSignature = ");
        stringBuilder.append(z);
        Log.d(str2, stringBuilder.toString());
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        String str2;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = TAG;
            str2 = "checkSumConsistent fail, invalid arguments";
        } else if (bArr.length != bArr2.length) {
            str = TAG;
            str2 = "checkSumConsistent fail, length is different";
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        Log.e(str, str2);
        return false;
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("handleWxInternalRespType, extInfo = ");
        stringBuilder.append(str);
        Log.i(str2, stringBuilder.toString());
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wx_internal_resptype");
            String str3 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("handleWxInternalRespType, respType = ");
            stringBuilder2.append(queryParameter);
            Log.i(str3, stringBuilder2.toString());
            if (d.a(queryParameter)) {
                Log.e(TAG, "handleWxInternalRespType fail, respType is null");
                return false;
            } else if (queryParameter.equals("subscribemessage")) {
                Resp resp = new Resp();
                resp.openId = parse.getQueryParameter("openid");
                resp.templateID = parse.getQueryParameter("template_id");
                resp.scene = d.b(parse.getQueryParameter("scene"));
                resp.action = parse.getQueryParameter("action");
                resp.reserved = parse.getQueryParameter("reserved");
                iWXAPIEventHandler.onResp(resp);
                return true;
            } else if (queryParameter.contains("invoice_auth_insert")) {
                WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
                resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp2);
                return true;
            } else if (queryParameter.contains("payinsurance")) {
                WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
                resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp3);
                return true;
            } else if (queryParameter.contains("nontaxpay")) {
                WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
                resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp4);
                return true;
            } else {
                Log.e(TAG, "this open sdk version not support the request type");
                return false;
            }
        } catch (Exception e) {
            String str4 = TAG;
            stringBuilder = new StringBuilder("handleWxInternalRespType fail, ex = ");
            stringBuilder.append(e.getMessage());
            Log.e(str4, stringBuilder.toString());
            return false;
        }
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context, BaseReq baseReq) {
        Req req = (Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        String encode = URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(req.url)}));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, "2", encode}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String[] strArr = new String[5];
        strArr[0] = this.appId;
        strArr[1] = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
        strArr[2] = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"));
        strArr[3] = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type"));
        strArr[4] = stringBuilder.toString();
        Cursor query = contentResolver.query(parse, null, null, strArr, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizTempSessionReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession");
        String[] strArr = new String[4];
        strArr[0] = this.appId;
        strArr[1] = bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
        strArr[2] = bundle.getString("_wxapi_jump_to_biz_webview_req_session_from");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type"));
        strArr[3] = stringBuilder.toString();
        Cursor query = contentResolver.query(parse, null, null, strArr, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context, Bundle bundle) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String[] strArr = new String[4];
        strArr[0] = this.appId;
        strArr[1] = bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
        strArr[2] = bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene"));
        strArr[3] = stringBuilder.toString();
        Cursor query = contentResolver.query(parse, null, null, strArr, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogram(Context context, BaseReq baseReq) {
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        String[] strArr = new String[4];
        strArr[0] = this.appId;
        strArr[1] = req.userName;
        strArr[2] = req.path;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.miniprogramType);
        strArr[3] = stringBuilder.toString();
        Cursor query = contentResolver.query(parse, null, null, strArr, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context, BaseReq baseReq) {
        WXNontaxPay.Req req = (WXNontaxPay.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        String encode = URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(req.url)}));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, "3", encode}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayInSurance(Context context, BaseReq baseReq) {
        WXPayInsurance.Req req = (WXPayInsurance.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
        String encode = URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(req.url)}));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, "4", encode}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("pay, set wxappPayEntryClassname = ");
            stringBuilder.append(wxappPayEntryClassname);
            Log.d(str, stringBuilder.toString());
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e) {
                    String str2 = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("get from metaData failed : ");
                    stringBuilder2.append(e.getMessage());
                    Log.e(str2, stringBuilder2.toString());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        Args args = new Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context, args);
    }

    private boolean sendSubscribeMessage(Context context, BaseReq baseReq) {
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "1", String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    public final void detach() {
        Log.d(TAG, "detach");
        this.detached = true;
        this.context = null;
    }

    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            int i = new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
            if (i == 0) {
                try {
                    return this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                } catch (Exception e) {
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder("get from metaData failed : ");
                    stringBuilder.append(e.getMessage());
                    Log.e(str, stringBuilder.toString());
                }
            }
            return i;
        } else {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        }
    }

    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        String str;
        StringBuilder stringBuilder;
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, Token.WX_TOKEN_VALUE_MSG)) {
                Log.i(TAG, "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (this.detached) {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            } else {
                String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
                int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
                String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (stringExtra2 != null) {
                    if (stringExtra2.length() != 0) {
                        if (checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), b.a(stringExtra, intExtra, stringExtra2))) {
                            int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                            String str2 = TAG;
                            StringBuilder stringBuilder2 = new StringBuilder("handleIntent, cmd = ");
                            stringBuilder2.append(intExtra2);
                            Log.i(str2, stringBuilder2.toString());
                            String str3;
                            switch (intExtra2) {
                                case 1:
                                    iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                                    return true;
                                case 2:
                                    iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                                    return true;
                                case 3:
                                    iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                                    return true;
                                case 4:
                                    ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                                    str3 = req.message.messageExt;
                                    if (str3 == null || !str3.contains("wx_internal_resptype")) {
                                        iWXAPIEventHandler.onReq(req);
                                        return true;
                                    }
                                    boolean handleWxInternalRespType = handleWxInternalRespType(str3, iWXAPIEventHandler);
                                    str = TAG;
                                    stringBuilder = new StringBuilder("handleIntent, extInfo contains wx_internal_resptype, ret = ");
                                    stringBuilder.append(handleWxInternalRespType);
                                    Log.i(str, stringBuilder.toString());
                                    return handleWxInternalRespType;
                                case 5:
                                    iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                                    return true;
                                case 6:
                                    iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                                    return true;
                                case 9:
                                    iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                                    return true;
                                case 12:
                                    iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                                    return true;
                                case 14:
                                    iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                                    return true;
                                case 15:
                                    iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                                    return true;
                                case 16:
                                    iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                                    return true;
                                case 17:
                                    iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                                    return true;
                                case 19:
                                    iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                                    return true;
                                default:
                                    str3 = TAG;
                                    StringBuilder stringBuilder3 = new StringBuilder("unknown cmd = ");
                                    stringBuilder3.append(intExtra2);
                                    Log.e(str3, stringBuilder3.toString());
                                    return false;
                            }
                        }
                        Log.e(TAG, "checksum fail");
                        return false;
                    }
                }
                Log.e(TAG, "invalid argument");
                return false;
            }
        } catch (Exception e) {
            str = TAG;
            stringBuilder = new StringBuilder("handleIntent fail, ex = ");
            stringBuilder.append(e.getMessage());
            Log.e(str, stringBuilder.toString());
            return false;
        }
    }

    public final boolean isWXAppInstalled() {
        if (this.detached) {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
            return packageInfo == null ? false : WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean isWXAppSupportAPI() {
        if (!this.detached) {
            return getWXAppSupportAPI() >= 620823552;
        } else {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
    }

    public final boolean openWXApp() {
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            try {
                this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                return true;
            } catch (Exception e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("startActivity fail, exception = ");
                stringBuilder.append(e.getMessage());
                Log.e(str, stringBuilder.toString());
                return false;
            }
        } else {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            return false;
        }
    }

    public final boolean registerApp(String str) {
        return registerApp(str, 0);
    }

    public final boolean registerApp(String str, long j) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("registerApp, appId = ");
            stringBuilder.append(str);
            Log.d(str2, stringBuilder.toString());
            if (str != null) {
                this.appId = str;
            }
            str2 = TAG;
            stringBuilder = new StringBuilder("registerApp, appId = ");
            stringBuilder.append(str);
            Log.d(str2, stringBuilder.toString());
            if (str != null) {
                this.appId = str;
            }
            str = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("register app ");
            stringBuilder2.append(this.context.getPackageName());
            Log.d(str, stringBuilder2.toString());
            a aVar = new a();
            aVar.a = "com.tencent.mm";
            aVar.action = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            stringBuilder2 = new StringBuilder("weixin://registerapp?appid=");
            stringBuilder2.append(this.appId);
            aVar.content = stringBuilder2.toString();
            aVar.b = j;
            return com.tencent.mm.opensdk.channel.a.a.a(this.context, aVar);
        } else {
            Log.e(TAG, "register app failed for wechat app signature check failed");
            return false;
        }
    }

    public final boolean sendReq(BaseReq baseReq) {
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        String str;
        String str2;
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            str = TAG;
            str2 = "sendReq failed for wechat app signature check failed";
        } else if (baseReq.checkArgs()) {
            str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("sendReq, req type = ");
            stringBuilder.append(baseReq.getType());
            Log.i(str2, stringBuilder.toString());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5) {
                return sendPayReq(this.context, bundle);
            }
            if (baseReq.getType() == 7) {
                return sendJumpToBizProfileReq(this.context, bundle);
            }
            if (baseReq.getType() == 8) {
                return sendJumpToBizWebviewReq(this.context, bundle);
            }
            if (baseReq.getType() == 10) {
                return sendJumpToBizTempSessionReq(this.context, bundle);
            }
            if (baseReq.getType() == 9) {
                return sendAddCardToWX(this.context, bundle);
            }
            if (baseReq.getType() == 16) {
                return sendChooseCardFromWX(this.context, bundle);
            }
            if (baseReq.getType() == 11) {
                return sendOpenRankListReq(this.context, bundle);
            }
            if (baseReq.getType() == 12) {
                return sendOpenWebview(this.context, bundle);
            }
            if (baseReq.getType() == 13) {
                return sendOpenBusiLuckyMoney(this.context, bundle);
            }
            if (baseReq.getType() == 14) {
                return createChatroom(this.context, bundle);
            }
            if (baseReq.getType() == 15) {
                return joinChatroom(this.context, bundle);
            }
            if (baseReq.getType() == 17) {
                return sendHandleScanResult(this.context, bundle);
            }
            if (baseReq.getType() == 18) {
                return sendSubscribeMessage(this.context, baseReq);
            }
            if (baseReq.getType() == 19) {
                return sendLaunchWXMiniprogram(this.context, baseReq);
            }
            if (baseReq.getType() == 20) {
                return sendInvoiceAuthInsert(this.context, baseReq);
            }
            if (baseReq.getType() == 21) {
                return sendNonTaxPay(this.context, baseReq);
            }
            if (baseReq.getType() == 22) {
                return sendPayInSurance(this.context, baseReq);
            }
            if (baseReq.getType() == 2 && bundle.getInt("_wxapi_sendmessagetowx_req_media_type") == 36) {
                SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                if (getWXAppSupportAPI() < Build.MINIPROGRAM_SUPPORTED_SDK_INT) {
                    WXWebpageObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                    req.message.mediaObject = wXWebpageObject;
                } else {
                    WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req.message.mediaObject;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(wXMiniProgramObject.userName);
                    stringBuilder2.append("@app");
                    wXMiniProgramObject.userName = stringBuilder2.toString();
                    String str3 = wXMiniProgramObject.path;
                    if (!d.a(str3)) {
                        String[] split = str3.split("\\?");
                        if (split.length > 1) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(split[0]);
                            stringBuilder3.append(".html?");
                            stringBuilder3.append(split[1]);
                            str3 = stringBuilder3.toString();
                        } else {
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(split[0]);
                            stringBuilder4.append(".html");
                            str3 = stringBuilder4.toString();
                        }
                        wXMiniProgramObject.path = str3;
                    }
                }
                req.scene = 0;
                baseReq.toBundle(bundle);
            }
            Args args = new Args();
            args.bundle = bundle;
            StringBuilder stringBuilder5 = new StringBuilder("weixin://sendreq?appid=");
            stringBuilder5.append(this.appId);
            args.content = stringBuilder5.toString();
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(this.context, args);
        } else {
            str = TAG;
            str2 = "sendReq checkArgs fail";
        }
        Log.e(str, str2);
        return false;
    }

    public final boolean sendResp(BaseResp baseResp) {
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        String str;
        String str2;
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            str = TAG;
            str2 = "sendResp failed for wechat app signature check failed";
        } else if (baseResp.checkArgs()) {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            Args args = new Args();
            args.bundle = bundle;
            StringBuilder stringBuilder = new StringBuilder("weixin://sendresp?appid=");
            stringBuilder.append(this.appId);
            args.content = stringBuilder.toString();
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return MMessageActV2.send(this.context, args);
        } else {
            str = TAG;
            str2 = "sendResp checkArgs fail";
        }
        Log.e(str, str2);
        return false;
    }

    public final void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("unregisterApp, appId = ");
            stringBuilder.append(this.appId);
            Log.d(str, stringBuilder.toString());
            if (this.appId == null || this.appId.length() == 0) {
                Log.e(TAG, "unregisterApp fail, appId is empty");
                return;
            }
            str = TAG;
            stringBuilder = new StringBuilder("unregister app ");
            stringBuilder.append(this.context.getPackageName());
            Log.d(str, stringBuilder.toString());
            a aVar = new a();
            aVar.a = "com.tencent.mm";
            aVar.action = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            stringBuilder = new StringBuilder("weixin://unregisterapp?appid=");
            stringBuilder.append(this.appId);
            aVar.content = stringBuilder.toString();
            com.tencent.mm.opensdk.channel.a.a.a(this.context, aVar);
        } else {
            Log.e(TAG, "unregister app failed for wechat app signature check failed");
        }
    }
}
