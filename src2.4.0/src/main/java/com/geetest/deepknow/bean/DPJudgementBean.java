package com.geetest.deepknow.bean;

import java.util.Map;

public class DPJudgementBean {
    private Map<String, Object> attr;
    private String id;
    private int interactive;

    public DPJudgementBean(String str, int i, Map<String, Object> map) {
        this.id = str;
        this.interactive = i;
        this.attr = map;
    }

    public Map<String, Object> getAttr() {
        return this.attr;
    }

    public String getId() {
        return this.id;
    }

    public int getInteractive() {
        return this.interactive;
    }

    public void setAttr(Map<String, Object> map) {
        this.attr = map;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInteractive(int i) {
        this.interactive = i;
    }
}
