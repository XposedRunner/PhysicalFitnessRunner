package com.qiyukf.unicorn.api;

import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.unicorn.api.msg.ProductReslectOnclickListener;
import java.io.Serializable;
import java.util.List;

public class ProductDetail implements Serializable, Cloneable {
    private String actionText;
    private int actionTextColor;
    private boolean alwaysSend;
    private String desc;
    private String ext;
    private String handlerTag;
    private boolean isOpenReselect;
    private String note;
    private boolean openTemplate;
    private String picture;
    private ProductReslectOnclickListener productReslectOnclickListener;
    private String reselectText;
    private boolean sendByUser;
    private int show;
    private String tagString;
    private List<Tag> tags;
    private String title;
    private String url;

    public static class Builder {
        private ProductDetail productDetail = new ProductDetail();

        public ProductDetail build() {
            return this.productDetail;
        }

        public ProductDetail create() {
            return build();
        }

        public Builder setActionText(String str) {
            this.productDetail.actionText = str;
            return this;
        }

        public Builder setActionTextColor(int i) {
            this.productDetail.actionTextColor = i;
            return this;
        }

        public Builder setAlwaysSend(boolean z) {
            this.productDetail.alwaysSend = z;
            return this;
        }

        public Builder setDesc(String str) {
            ProductDetail productDetail = this.productDetail;
            if (str.length() > SecExceptionCode.SEC_ERROR_STA_ENC) {
                str = str.substring(0, SecExceptionCode.SEC_ERROR_STA_ENC);
            }
            productDetail.desc = str;
            return this;
        }

        public Builder setExt(String str) {
            this.productDetail.ext = str;
            return this;
        }

        public Builder setHandlerTag(String str) {
            this.productDetail.handlerTag = str;
            return this;
        }

        public Builder setIsOpenReselect(boolean z) {
            this.productDetail.isOpenReselect = z;
            return this;
        }

        public Builder setNote(String str) {
            ProductDetail productDetail = this.productDetail;
            if (str.length() > 100) {
                str = str.substring(0, 100);
            }
            productDetail.note = str;
            return this;
        }

        public Builder setOpenTemplate(boolean z) {
            this.productDetail.openTemplate = z;
            return this;
        }

        public Builder setPicture(String str) {
            this.productDetail.picture = str;
            return this;
        }

        public Builder setProductReslectOnclickListener(ProductReslectOnclickListener productReslectOnclickListener) {
            this.productDetail.productReslectOnclickListener = productReslectOnclickListener;
            return this;
        }

        public Builder setReselectText(String str) {
            this.productDetail.reselectText = str;
            return this;
        }

        public Builder setSendByUser(boolean z) {
            this.productDetail.sendByUser = z;
            return this;
        }

        public Builder setShow(int i) {
            this.productDetail.show = i;
            return this;
        }

        public Builder setTagString(String str) {
            this.productDetail.tagString = str;
            return this;
        }

        public Builder setTags(List<Tag> list) {
            this.productDetail.tags = list;
            return this;
        }

        public Builder setTitle(String str) {
            ProductDetail productDetail = this.productDetail;
            if (str.length() > 100) {
                str = str.substring(0, 100);
            }
            productDetail.title = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.productDetail.url = str;
            return this;
        }
    }

    public static class Tag implements Serializable, Cloneable {
        private String data;
        private String focusIframe;
        private String label;
        private String url;

        public Tag(String str, String str2, String str3, String str4) {
            this.label = str;
            this.url = str2;
            this.data = str4;
            this.focusIframe = str3;
        }

        public String getData() {
            return this.data;
        }

        public String getFocusIframe() {
            return this.focusIframe;
        }

        public String getLabel() {
            return this.label;
        }

        public String getUrl() {
            return this.url;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setFocusIframe(String str) {
            this.focusIframe = str;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    private ProductDetail() {
    }

    public final ProductDetail clone() {
        try {
            return (ProductDetail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ProductDetail) {
            ProductDetail productDetail = (ProductDetail) obj;
            if (TextUtils.equals(this.url, productDetail.url) && TextUtils.equals(this.title, productDetail.title) && TextUtils.equals(this.desc, productDetail.desc)) {
                return true;
            }
        }
        return false;
    }

    public String getActionText() {
        return this.actionText;
    }

    public int getActionTextColor() {
        return this.actionTextColor;
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

    public String getPicture() {
        return this.picture;
    }

    public ProductReslectOnclickListener getProductReslectOnclickListener() {
        return this.productReslectOnclickListener;
    }

    public String getReselectText() {
        return this.reselectText;
    }

    public int getShow() {
        return this.show;
    }

    public String getTagString() {
        return this.tagString;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAlwaysSend() {
        return this.alwaysSend;
    }

    public boolean isOpenReselect() {
        return this.isOpenReselect;
    }

    public boolean isOpenTemplate() {
        return this.openTemplate;
    }

    public boolean isSendByUser() {
        return this.sendByUser;
    }

    public void setSendByUser(boolean z) {
        this.sendByUser = z;
    }

    public final boolean valid() {
        return (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.desc) && TextUtils.isEmpty(this.picture) && TextUtils.isEmpty(this.url) && TextUtils.isEmpty(this.note)) ? false : true;
    }
}
