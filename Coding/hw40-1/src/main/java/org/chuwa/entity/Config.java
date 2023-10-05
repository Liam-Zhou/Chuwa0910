package org.chuwa.entity;

import java.util.List;

public class Config {
    private List<TileOptions> tileOptions;
    private List<Product> products;

    public List<TileOptions> getTileOptions() {
        return tileOptions;
    }

    public void setTileOptions(List<TileOptions> tileOptions) {
        this.tileOptions = tileOptions;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
