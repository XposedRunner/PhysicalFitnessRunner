package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage {
    private static final String TAG = "MicroMsg.AddCardToWXCardPackage";

    public static class Req extends BaseReq {
        public List<WXCardItem> cardArrary;

        /* JADX WARNING: Missing block: B:23:0x0049, code skipped:
            return false;
     */
        public boolean checkArgs() {
            /*
            r5 = this;
            r0 = r5.cardArrary;
            r1 = 0;
            if (r0 == 0) goto L_0x0049;
        L_0x0005:
            r0 = r5.cardArrary;
            r0 = r0.size();
            if (r0 == 0) goto L_0x0049;
        L_0x000d:
            r0 = r5.cardArrary;
            r0 = r0.size();
            r2 = 40;
            if (r0 <= r2) goto L_0x0018;
        L_0x0017:
            return r1;
        L_0x0018:
            r0 = r5.cardArrary;
            r0 = r0.iterator();
        L_0x001e:
            r2 = r0.hasNext();
            if (r2 == 0) goto L_0x0047;
        L_0x0024:
            r2 = r0.next();
            r2 = (com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem) r2;
            if (r2 == 0) goto L_0x0046;
        L_0x002c:
            r3 = r2.cardId;
            if (r3 == 0) goto L_0x0046;
        L_0x0030:
            r3 = r2.cardId;
            r3 = r3.length();
            r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r3 > r4) goto L_0x0046;
        L_0x003a:
            r3 = r2.cardExtMsg;
            if (r3 == 0) goto L_0x001e;
        L_0x003e:
            r2 = r2.cardExtMsg;
            r2 = r2.length();
            if (r2 <= r4) goto L_0x001e;
        L_0x0046:
            return r1;
        L_0x0047:
            r0 = 1;
            return r0;
        L_0x0049:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$Req.checkArgs():boolean");
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                String str = AddCardToWXCardPackage.TAG;
                StringBuilder stringBuilder = new StringBuilder("Req.toBundle exception:");
                stringBuilder.append(e.getMessage());
                Log.e(str, stringBuilder.toString());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    public static class Resp extends BaseResp {
        public List<WXCardItem> cardArrary;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return (this.cardArrary == null || this.cardArrary.size() == 0) ? false : true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            if (this.cardArrary == null) {
                this.cardArrary = new LinkedList();
            }
            String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string != null && string.length() > 0) {
                try {
                    JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        WXCardItem wXCardItem = new WXCardItem();
                        wXCardItem.cardId = jSONObject.optString("card_id");
                        wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
                        wXCardItem.cardState = jSONObject.optInt("is_succ");
                        this.cardArrary.add(wXCardItem);
                    }
                } catch (Exception unused) {
                }
            }
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.key("is_succ");
                    jSONStringer.value((long) wXCardItem.cardState);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                String str = AddCardToWXCardPackage.TAG;
                StringBuilder stringBuilder = new StringBuilder("Resp.toBundle exception:");
                stringBuilder.append(e.getMessage());
                Log.e(str, stringBuilder.toString());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    public static final class WXCardItem {
        public String cardExtMsg;
        public String cardId;
        public int cardState;
    }
}
