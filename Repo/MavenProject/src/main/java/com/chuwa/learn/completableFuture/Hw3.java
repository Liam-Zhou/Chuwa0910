package com.chuwa.learn.completableFuture;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class Hw3 {

    public static void main(String[] args) {
        Hw3 store = new Hw3();

        int id = 2;

        CompletableFuture<ProductInfo> productInfoFuture = store.fetchProductInfo(id);
        CompletableFuture<List<String>> reviewsFuture = store.fetchReviews(id);
        CompletableFuture<Integer> stockFuture = store.fetchStock(id);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productInfoFuture, reviewsFuture, stockFuture);


        try {
            combinedFuture.get();

            ProductInfo productInfo = productInfoFuture.get();
            List<String> reviews = reviewsFuture.get();
            int stock = stockFuture.get();

            System.out.println("Product Name: " + productInfo.getName());
            System.out.println("Product Price: " + productInfo.getPrice());
            System.out.println("Reviews: " + reviews);
            System.out.println("In-Stock: " + stock);
        } catch (Exception e) {
            System.out.println("Error in the process with " + e.getMessage());
        }
    }

    public CompletableFuture<ProductInfo> fetchProductInfo(int id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL apiUrl = new URL("https://my-json-server.typicode.com/hxwang-463/jsonRepo/wrongendpoint/"+ id);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                    JSONObject jsonObject = new JSONObject(response.toString());
                    String name = jsonObject.getString("name");
                    int price = jsonObject.getInt("price");
                    return new ProductInfo(name, price);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }).exceptionally(e -> {
            System.out.println("fetchProductInfo failed with exception: " + e.getMessage());
            return null;
        });
    }

    public CompletableFuture<List<String>> fetchReviews(int id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL apiUrl = new URL("https://my-json-server.typicode.com/hxwang-463/jsonRepo/reviews/"+ id);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                    JSONObject jsonObject = new JSONObject(response.toString());
                    JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("reviews"));
                    List<String> reviews = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        reviews.add(jsonArray.getString(i));
                    }
                    return reviews;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }).exceptionally(e -> {
            System.out.println("fetchReviews failed with exception: " + e.getMessage());
            return null;
        });
    }

    public CompletableFuture<Integer> fetchStock(int id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL apiUrl = new URL("https://my-json-server.typicode.com/hxwang-463/jsonRepo/inventory/"+ id);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    reader.close();
                    JSONObject jsonObject = new JSONObject(response.toString());
                    int inStock = jsonObject.getInt("instock");
                    return inStock;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }).exceptionally(e -> {
            System.out.println("fetchStock failed with exception: " + e.getMessage());
            return null;
        });
    }
}


