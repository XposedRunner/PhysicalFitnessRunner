package com.qiyukf.unicorn.api.pop;

import android.support.annotation.DrawableRes;
import java.io.Serializable;

public class SessionListEntrance implements Serializable {
    @DrawableRes
    private int imageResId;
    private Position position;

    public static class Builder {
        private SessionListEntrance sessionListEntrance = new SessionListEntrance();

        public SessionListEntrance build() {
            return this.sessionListEntrance;
        }

        public Builder setImageResId(@DrawableRes int i) {
            this.sessionListEntrance.imageResId = i;
            return this;
        }

        public Builder setPosition(Position position) {
            this.sessionListEntrance.position = position;
            return this;
        }
    }

    public enum Position {
        TOP_LEFT,
        TOP_RIGHT
    }

    private SessionListEntrance() {
    }

    @DrawableRes
    public int getImageResId() {
        return this.imageResId;
    }

    public Position getPosition() {
        return this.position;
    }
}
