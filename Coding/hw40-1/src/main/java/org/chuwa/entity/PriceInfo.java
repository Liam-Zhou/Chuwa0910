package org.chuwa.entity;

import java.util.List;

public class PriceInfo {
    private List<PriceDisplayCode> priceDisplayCodes;
    private String wasPrice;
    private List<UnitPrice> unitPrices;
    private String priceRange;
    private List<CurrentPrice> currentPrices;
   private String shipPrice;

    public List<PriceDisplayCode> getPriceDisplayCodes() {
        return priceDisplayCodes;
    }

    public void setPriceDisplayCodes(List<PriceDisplayCode> priceDisplayCodes) {
        this.priceDisplayCodes = priceDisplayCodes;
    }

    public String getWasPrice() {
        return wasPrice;
    }

    public void setWasPrice(String wasPrice) {
        this.wasPrice = wasPrice;
    }

    public List<UnitPrice> getUnitPrices() {
        return unitPrices;
    }

    public void setUnitPrices(List<UnitPrice> unitPrices) {
        this.unitPrices = unitPrices;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public List<CurrentPrice> getCurrentPrices() {
        return currentPrices;
    }

    public void setCurrentPrices(List<CurrentPrice> currentPrices) {
        this.currentPrices = currentPrices;
    }

    public String getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(String shipPrice) {
        this.shipPrice = shipPrice;
    }
}
