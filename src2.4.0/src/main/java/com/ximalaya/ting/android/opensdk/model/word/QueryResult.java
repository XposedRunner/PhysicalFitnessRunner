package com.ximalaya.ting.android.opensdk.model.word;

import com.google.gson.annotations.SerializedName;

public class QueryResult {
    @SerializedName("highlight_keyword")
    private String highlightKeyword;
    private String keyword;
    @SerializedName("id")
    private long queryId;

    public String getHighlightKeyword() {
        return this.highlightKeyword;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public long getQueryId() {
        return this.queryId;
    }

    public void setHighlightKeyword(String str) {
        this.highlightKeyword = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setQueryId(long j) {
        this.queryId = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QueryResult [queryId=");
        stringBuilder.append(this.queryId);
        stringBuilder.append(", keyword=");
        stringBuilder.append(this.keyword);
        stringBuilder.append(", highlightKeyword=");
        stringBuilder.append(this.highlightKeyword);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
