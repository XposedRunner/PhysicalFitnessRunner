package com.google.zxing.oned.rss.expanded.decoders;

abstract class DecodedObject {
    private final int newPosition;

    DecodedObject(int i) {
        this.newPosition = i;
    }

    /* Access modifiers changed, original: final */
    public final int getNewPosition() {
        return this.newPosition;
    }
}
