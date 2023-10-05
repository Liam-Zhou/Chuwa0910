package org.chuwa.entity;

import java.util.List;

public class Banner {
    private String title;
    private String description;
    private String additionalInfo;
    private String bannerType;
    private boolean hasCloseButton;
    private boolean isOptedIn;
    private String freeDeliveryAvailable;
    private String planInfo;
    private String strikeString;
    private boolean showBanner;
    private String buttonTitle;
    private boolean isOptInBanner;
    private String optedInTitle;
    private String optedInAdditionalInfo;
    private String optedInButtonAnalyticsName;
    private String optedInButtonTitle;
    private String buttonAnalyticsName;
    private List<ImageURL> imageURLs;
    private String programType;
    private String programSubType;
    private boolean isBelowMinimumPriceBanner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getBannerType() {
        return bannerType;
    }

    public void setBannerType(String bannerType) {
        this.bannerType = bannerType;
    }

    public boolean isHasCloseButton() {
        return hasCloseButton;
    }

    public void setHasCloseButton(boolean hasCloseButton) {
        this.hasCloseButton = hasCloseButton;
    }

    public boolean isOptedIn() {
        return isOptedIn;
    }

    public void setOptedIn(boolean optedIn) {
        isOptedIn = optedIn;
    }

    public String getFreeDeliveryAvailable() {
        return freeDeliveryAvailable;
    }

    public void setFreeDeliveryAvailable(String freeDeliveryAvailable) {
        this.freeDeliveryAvailable = freeDeliveryAvailable;
    }

    public String getPlanInfo() {
        return planInfo;
    }

    public void setPlanInfo(String planInfo) {
        this.planInfo = planInfo;
    }

    public String getStrikeString() {
        return strikeString;
    }

    public void setStrikeString(String strikeString) {
        this.strikeString = strikeString;
    }

    public boolean isShowBanner() {
        return showBanner;
    }

    public void setShowBanner(boolean showBanner) {
        this.showBanner = showBanner;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void setButtonTitle(String buttonTitle) {
        this.buttonTitle = buttonTitle;
    }

    public boolean isOptInBanner() {
        return isOptInBanner;
    }

    public void setOptInBanner(boolean optInBanner) {
        isOptInBanner = optInBanner;
    }

    public String getOptedInTitle() {
        return optedInTitle;
    }

    public void setOptedInTitle(String optedInTitle) {
        this.optedInTitle = optedInTitle;
    }

    public String getOptedInAdditionalInfo() {
        return optedInAdditionalInfo;
    }

    public void setOptedInAdditionalInfo(String optedInAdditionalInfo) {
        this.optedInAdditionalInfo = optedInAdditionalInfo;
    }

    public String getOptedInButtonAnalyticsName() {
        return optedInButtonAnalyticsName;
    }

    public void setOptedInButtonAnalyticsName(String optedInButtonAnalyticsName) {
        this.optedInButtonAnalyticsName = optedInButtonAnalyticsName;
    }

    public String getOptedInButtonTitle() {
        return optedInButtonTitle;
    }

    public void setOptedInButtonTitle(String optedInButtonTitle) {
        this.optedInButtonTitle = optedInButtonTitle;
    }

    public String getButtonAnalyticsName() {
        return buttonAnalyticsName;
    }

    public void setButtonAnalyticsName(String buttonAnalyticsName) {
        this.buttonAnalyticsName = buttonAnalyticsName;
    }

    public List<ImageURL> getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(List<ImageURL> imageURLs) {
        this.imageURLs = imageURLs;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getProgramSubType() {
        return programSubType;
    }

    public void setProgramSubType(String programSubType) {
        this.programSubType = programSubType;
    }

    public boolean isBelowMinimumPriceBanner() {
        return isBelowMinimumPriceBanner;
    }

    public void setBelowMinimumPriceBanner(boolean belowMinimumPriceBanner) {
        isBelowMinimumPriceBanner = belowMinimumPriceBanner;
    }
}
