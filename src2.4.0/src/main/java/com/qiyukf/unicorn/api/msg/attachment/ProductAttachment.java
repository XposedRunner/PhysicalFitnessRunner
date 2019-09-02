package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.unicorn.api.ProductDetail;
import com.qiyukf.unicorn.api.ProductDetail.Tag;
import com.qiyukf.unicorn.api.msg.ProductReslectOnclickListener;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import com.tencent.open.SocialConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@b(a = 121)
public class ProductAttachment extends e implements Cloneable {
    @a(a = "actionText")
    private String actionText;
    @a(a = "actionTextColor")
    private int actionTextColor;
    @a(a = "activity")
    private String activity;
    @a(a = "activityHref")
    private String activityHref;
    @a(a = "auto")
    private int auto;
    @a(a = "desc")
    private String desc;
    @a(a = "ext")
    private String ext;
    private String handlerTag;
    private boolean isOpenReselect;
    @a(a = "note")
    private String note;
    @a(a = "orderCount")
    private String orderCount;
    @a(a = "orderId")
    private String orderID;
    @a(a = "orderSku")
    private String orderSku;
    @a(a = "orderStatus")
    private String orderStatus;
    @a(a = "orderTime")
    private String orderTime;
    @a(a = "payMoney")
    private String payMoney;
    @a(a = "picture")
    private String picture;
    @a(a = "price")
    private String price;
    private ProductReslectOnclickListener productReslectOnclickListener;
    private String reselectText;
    @a(a = "sendByUser")
    private int sendByUser;
    @a(a = "show")
    private int show;
    @a(a = "tags")
    private JSONArray tags;
    @a(a = "template")
    private String template;
    @a(a = "title")
    private String title;
    @a(a = "url")
    private String url;

    private static JSONArray fromTag(List<Tag> list) {
        JSONArray jSONArray = new JSONArray();
        for (Tag tag : list) {
            Object jSONObject = new JSONObject();
            com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "label", tag.getLabel());
            com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, SocialConstants.PARAM_URL, tag.getUrl());
            com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "focusIframe", tag.getFocusIframe());
            com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "data", tag.getData());
            com.qiyukf.basesdk.c.b.a(jSONArray, jSONObject);
        }
        return jSONArray;
    }

    public final ProductAttachment clone() {
        try {
            return (ProductAttachment) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void fromProductDetail(ProductDetail productDetail, boolean z) {
        JSONArray fromTag;
        setTitle(productDetail.getTitle());
        setDesc(productDetail.getDesc());
        setPicture(productDetail.getPicture());
        setUrl(productDetail.getUrl());
        setNote(productDetail.getNote());
        setShow(productDetail.getShow());
        setExt(productDetail.getExt());
        setActionText(productDetail.getActionText());
        setActionTextColor(productDetail.getActionTextColor());
        setSendByUser(productDetail.isSendByUser());
        setHandlerTag(productDetail.getHandlerTag());
        setReselectText(productDetail.getReselectText());
        setOpenReselect(productDetail.isOpenReselect());
        setProductReslectOnclickListener(productDetail.getProductReslectOnclickListener());
        if (productDetail.isOpenTemplate()) {
            setTemplate("pictureLink");
        }
        if (TextUtils.isEmpty(productDetail.getTagString())) {
            if (productDetail.getTags() != null && productDetail.getTags().size() > 0) {
                fromTag = fromTag(productDetail.getTags());
            }
            this.auto = z;
        }
        fromTag = com.qiyukf.basesdk.c.b.b(productDetail.getTagString());
        this.tags = fromTag;
        this.auto = z;
    }

    public String getActionText() {
        return this.actionText;
    }

    public int getActionTextColor() {
        return this.actionTextColor;
    }

    public String getActivity() {
        return this.activity;
    }

    public String getActivityHref() {
        return this.activityHref;
    }

    public int getAuto() {
        return this.auto;
    }

    public String getContent(Context context) {
        return this.url;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getExt() {
        return this.ext;
    }

    public String getHandlerTag() {
        return this.handlerTag;
    }

    public String getNote() {
        return this.note;
    }

    public String getOrderCount() {
        return this.orderCount;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public String getOrderSku() {
        return this.orderSku;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public String getPayMoney() {
        return this.payMoney;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getPrice() {
        return this.price;
    }

    public ProductReslectOnclickListener getProductReslectOnclickListener() {
        return this.productReslectOnclickListener;
    }

    public String getReselectText() {
        return this.reselectText;
    }

    public int getSendByUser() {
        return this.sendByUser;
    }

    public int getShow() {
        return this.show;
    }

    public JSONArray getTags() {
        return this.tags;
    }

    public String getTemplate() {
        return this.template;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isOpenReselect() {
        return this.isOpenReselect;
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setActionTextColor(int i) {
        this.actionTextColor = i;
    }

    public void setActivity(String str) {
        this.activity = str;
    }

    public void setActivityHref(String str) {
        this.activityHref = str;
    }

    public void setAuto(int i) {
        this.auto = i;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setHandlerTag(String str) {
        this.handlerTag = str;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setOpenReselect(boolean z) {
        this.isOpenReselect = z;
    }

    public void setOrderCount(String str) {
        this.orderCount = str;
    }

    public void setOrderID(String str) {
        this.orderID = str;
    }

    public void setOrderSku(String str) {
        this.orderSku = str;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public void setPayMoney(String str) {
        this.payMoney = str;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProductReslectOnclickListener(ProductReslectOnclickListener productReslectOnclickListener) {
        this.productReslectOnclickListener = productReslectOnclickListener;
    }

    public void setReselectText(String str) {
        this.reselectText = str;
    }

    public void setSendByUser(int i) {
        this.sendByUser = i;
    }

    public void setShow(int i) {
        this.show = i;
    }

    public void setTags(JSONArray jSONArray) {
        this.tags = jSONArray;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
