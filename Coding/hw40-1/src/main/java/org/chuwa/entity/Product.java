package org.chuwa.entity;

import java.util.List;

public class Product {
    private Long id;
    private String offerId;
    private int orderLimit;
    private int weightIncrement;
    private String fulfillmentType;
    private String availabilityStatus;
    private boolean showAtc;
    private boolean showOptions;
    private String canonicalUrl;
    private String name;
    private Long usItemId;
    private String sellerId;
    private String sellerName;
    private String hasSellerBadge;
    private String fulfillmentSpeed;
    private double averageRating;
    private int unitQuantity;
    private String type;
    private List<PreOrder> preOrders;
    private String sponsoredProduct;
    private double shipPrice;
    private List<Flag> flags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public int getOrderLimit() {
        return orderLimit;
    }

    public void setOrderLimit(int orderLimit) {
        this.orderLimit = orderLimit;
    }

    public int getWeightIncrement() {
        return weightIncrement;
    }

    public void setWeightIncrement(int weightIncrement) {
        this.weightIncrement = weightIncrement;
    }

    public String getFulfillmentType() {
        return fulfillmentType;
    }

    public void setFulfillmentType(String fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public boolean isShowAtc() {
        return showAtc;
    }

    public void setShowAtc(boolean showAtc) {
        this.showAtc = showAtc;
    }

    public boolean isShowOptions() {
        return showOptions;
    }

    public void setShowOptions(boolean showOptions) {
        this.showOptions = showOptions;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUsItemId() {
        return usItemId;
    }

    public void setUsItemId(Long usItemId) {
        this.usItemId = usItemId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getHasSellerBadge() {
        return hasSellerBadge;
    }

    public void setHasSellerBadge(String hasSellerBadge) {
        this.hasSellerBadge = hasSellerBadge;
    }

    public String getFulfillmentSpeed() {
        return fulfillmentSpeed;
    }

    public void setFulfillmentSpeed(String fulfillmentSpeed) {
        this.fulfillmentSpeed = fulfillmentSpeed;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(int unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PreOrder> getPreOrders() {
        return preOrders;
    }

    public void setPreOrders(List<PreOrder> preOrders) {
        this.preOrders = preOrders;
    }

    public String getSponsoredProduct() {
        return sponsoredProduct;
    }

    public void setSponsoredProduct(String sponsoredProduct) {
        this.sponsoredProduct = sponsoredProduct;
    }

    public double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(double shipPrice) {
        this.shipPrice = shipPrice;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
    }
}
