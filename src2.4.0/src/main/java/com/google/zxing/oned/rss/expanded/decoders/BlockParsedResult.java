package com.google.zxing.oned.rss.expanded.decoders;

final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    BlockParsedResult(DecodedInformation decodedInformation, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation;
    }

    BlockParsedResult(boolean z) {
        this(null, z);
    }

    /* Access modifiers changed, original: 0000 */
    public DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isFinished() {
        return this.finished;
    }
}
