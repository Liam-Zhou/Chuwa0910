package org.chuwa.entity;

public class TileOptions {
    private boolean fulfillmentBadging;
    private boolean averageRatings;
    private boolean productFlags;

    public boolean isFulfillmentBadging() {
        return fulfillmentBadging;
    }

    public void setFulfillmentBadging(boolean fulfillmentBadging) {
        this.fulfillmentBadging = fulfillmentBadging;
    }

    public boolean isAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(boolean averageRatings) {
        this.averageRatings = averageRatings;
    }

    public boolean isProductFlags() {
        return productFlags;
    }

    public void setProductFlags(boolean productFlags) {
        this.productFlags = productFlags;
    }
}
