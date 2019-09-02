package com.qiyukf.unicorn.api;

import com.qiyukf.unicorn.e.c;

public class QuickEntry implements c {
    private String iconUrl;
    private long id;
    private String name;

    public QuickEntry(long j, String str, String str2) {
        this.id = j;
        this.name = str;
        this.iconUrl = str2;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }
}
