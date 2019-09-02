package com.zjwh.android_wh_physicalfitness.entity;

public class NewsDetailBean extends NewsBean {
    private String author;
    private int authorUid;
    private String content;
    private NewsHotCommentBean hotComments;
    private String htmlUrl;
    private int isLiked;
    private int isUnliked;
    private String publisher;
    private String shareUrl;
    private int unlikeCount;

    public String getAuthor() {
        return this.author;
    }

    public int getAuthorUid() {
        return this.authorUid;
    }

    public String getContent() {
        return this.content;
    }

    public NewsHotCommentBean getHotComments() {
        return this.hotComments;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public int getIsLiked() {
        return this.isLiked;
    }

    public int getIsUnliked() {
        return this.isUnliked;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public int getUnlikeCount() {
        return this.unlikeCount;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setAuthorUid(int i) {
        this.authorUid = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setHotComments(NewsHotCommentBean newsHotCommentBean) {
        this.hotComments = newsHotCommentBean;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIsLiked(int i) {
        this.isLiked = i;
    }

    public void setIsUnliked(int i) {
        this.isUnliked = i;
    }

    public void setPublisher(String str) {
        this.publisher = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setUnlikeCount(int i) {
        this.unlikeCount = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NewsDetailBean{content='");
        stringBuilder.append(this.content);
        stringBuilder.append('\'');
        stringBuilder.append(", author='");
        stringBuilder.append(this.author);
        stringBuilder.append('\'');
        stringBuilder.append(", publisher='");
        stringBuilder.append(this.publisher);
        stringBuilder.append('\'');
        stringBuilder.append(", unlikeCount=");
        stringBuilder.append(this.unlikeCount);
        stringBuilder.append(", isLiked=");
        stringBuilder.append(this.isLiked);
        stringBuilder.append(", isUnliked=");
        stringBuilder.append(this.isUnliked);
        stringBuilder.append(", hotComments=");
        stringBuilder.append(this.hotComments);
        stringBuilder.append(", shareUrl='");
        stringBuilder.append(this.shareUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", htmlUrl='");
        stringBuilder.append(this.htmlUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", authorUid=");
        stringBuilder.append(this.authorUid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
