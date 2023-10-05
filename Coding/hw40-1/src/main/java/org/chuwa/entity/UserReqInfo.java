package org.chuwa.entity;

import java.util.List;

public class UserReqInfo {
    private int preferredStoreId;
    private List<Integer> storeIds;
    private List<CartContext> cartContexts;

    public int getPreferredStoreId() {
        return preferredStoreId;
    }

    public void setPreferredStoreId(int preferredStoreId) {
        this.preferredStoreId = preferredStoreId;
    }

    public List<Integer> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Integer> storeIds) {
        this.storeIds = storeIds;
    }

    public List<CartContext> getCartContexts() {
        return cartContexts;
    }

    public void setCartContexts(List<CartContext> cartContexts) {
        this.cartContexts = cartContexts;
    }
}
