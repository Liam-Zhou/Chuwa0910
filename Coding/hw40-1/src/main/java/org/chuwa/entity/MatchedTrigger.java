package org.chuwa.entity;

public class MatchedTrigger {
    private String pageType;
    private String pageId;
    private String zone;
    private boolean inheritable;

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public boolean isInheritable() {
        return inheritable;
    }

    public void setInheritable(boolean inheritable) {
        this.inheritable = inheritable;
    }
}
