package com.qiyukf.unicorn.api.msg;

import java.io.Serializable;

public class PushMessageExtension implements Serializable {
    private Action action;
    private Sender sender;

    public static class Action implements Serializable {
        private String label;
        private String url;

        public String getLabel() {
            return this.label;
        }

        public String getUrl() {
            return this.url;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public static class Sender implements Serializable {
        private String avatar;
        private String id;
        private String name;

        public String getAvatar() {
            return this.avatar;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public Action getAction() {
        return this.action;
    }

    public Sender getSender() {
        return this.sender;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
