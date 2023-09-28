package com.chuwa.shawnlearning.future;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;
public class HW23 {

    public static class Product {
        private final String name;
        public Product(String n){
            this.name = n;
        }

        public String getName(){
            return this.name;
        }

    }

    public static class Inventory {
        private final Integer count;
        public Inventory(Integer n){
            this.count = n;
        }

        public Integer getCount(){
            return this.count;
        }
    }

    public static class Review {
        private final String comment;
        public Review(String n){
            this.comment = n;
        }

        public String getComment(){
            return this.comment;
        }
    }
    public static class API<T> {
        public T fetch(Integer id){
            return null;
        }
    }

    @Test
    public void testNormal(){
        API<Review> reviewAPI = mock(API.class);
        API<Product> productAPI = mock(API.class);
        API<Inventory> inventoryAPI = mock(API.class);

        when(reviewAPI.fetch(anyInt())).thenReturn(new Review("Good"));
        when(productAPI.fetch(anyInt())).thenReturn(new Product("Product"));
        when(inventoryAPI.fetch(anyInt())).thenReturn(new Inventory(5));
        final Integer productId = 1;

        var productFuture = CompletableFuture.supplyAsync(()->productAPI.fetch(productId));
        var reviewFuture = CompletableFuture.supplyAsync(()-> reviewAPI.fetch(productId));
        var inventoryFuture = CompletableFuture.supplyAsync(()-> inventoryAPI.fetch(productId));
        CompletableFuture.allOf(productFuture, reviewFuture, inventoryFuture).join();
        try {
            System.out.println("Name: "+productFuture.get().name);
            System.out.println("Review: "+reviewFuture.get().comment);
            System.out.println("Inventory: " + inventoryFuture.get().count);
            Assertions.assertEquals(inventoryFuture.get().count, 5);
            Assertions.assertEquals(productFuture.get().name, "Product");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void testAbNormal(){
        API<Review> reviewAPI = mock(API.class);
        API<Product> productAPI = mock(API.class);
        API<Inventory> inventoryAPI = mock(API.class);

        when(reviewAPI.fetch(anyInt())).thenThrow(new RuntimeException("What ???"));
        when(productAPI.fetch(anyInt())).thenReturn(new Product("Product"));
        when(inventoryAPI.fetch(anyInt())).thenReturn(new Inventory(5));
        final Integer productId = 1;

        var productFuture = CompletableFuture.supplyAsync(()->productAPI.fetch(productId));
        var reviewFuture = CompletableFuture.supplyAsync(()-> reviewAPI.fetch(productId)).exceptionally(e -> {
            System.out.println(e.getMessage());
            return new Review("Bad");
        });
        var inventoryFuture = CompletableFuture.supplyAsync(()-> inventoryAPI.fetch(productId));
        CompletableFuture.allOf(productFuture, reviewFuture, inventoryFuture).join();
        try {
            System.out.println("Name: "+productFuture.get().name);
            System.out.println("Review: "+reviewFuture.get().comment);
            System.out.println("Inventory: " + inventoryFuture.get().count);
            Assertions.assertEquals(inventoryFuture.get().count, 5);
            Assertions.assertEquals(productFuture.get().name, "Product");
            Assertions.assertEquals(reviewFuture.get().comment, "Bad");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

}
