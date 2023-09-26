package org.example;

import jdk.jfr.Category;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Exercise 1 - Obtain a list of products belongs to category “Books” with price > 100
        List<Product> result = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory.equals("Books"))
                .filter(product -> product.getPrice > 100)
                .collect(Collectors.toList());

        // Exercise 2 - Obtain a list of order with products belong to category “Baby”
        List<Order> result2 = orderRepo.findAll()
                .stream()
                .filter(order -> order.getProducts()
                        .stream()
                        .anyMatch(product -> product.getCategory.equals("Baby")))
                .collect(Collectors.toList());

        // Exercise 3 - Obtain a list of product with category = “Toys” and then apply 10% discount
        List<Product> result3 = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory.equals("Toys"))
                .map(product -> product.setPrice(product.getPrice() * 0.9))
                .collect(Collectors.toList());

        // Exercise 4 - Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        List<Product> result4 = orderRepo.findAll()
                .stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        // Exercise 5 - Get the cheapest products of “Books” category
        List<Product> result5 = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory.equals("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst();

        // Exercise 6 - Get the 3 most recent placed order
        List<Order> result6 = orderRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        // Exercise 7 - Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
        List<Product> result7 = orderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 3, 15)))
                .peek(order -> System.out.println(order.toString()))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        // Exercise 8 - Calculate total lump sum of all orders placed in Feb 2021
        Double result8 = orderRepo.findAll()
                .stream()
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .sum();

        // Exercise 9 - Calculate order average payment placed on 14-Mar-2021
        Double result9 = orderRepo.findAll()
                .stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .average().getAsDouble();

        // Exercise 10 - Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
        DoubleSummaryStatistics statistics = productRepo.findAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(p -> p.getPrice())
                .summaryStatistics();

        // Exercise 11 - Obtain a data map with order id and order’s product count
        Map<Long, Integer>  result11 = orderRepo.findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                                order -> order.getId(),
                                order -> order.getProducts().size()));

        // Exercise 12 - Produce a data map with order records grouped by customer
        Map<Order, Double> result12 = orderRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        // Exercise 13 - Produce a data map with order record and product total sum
        Map<Order, Double> result13 = orderRepo.findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                order -> order.getProducts().stream()
                                        .mapToDouble(p -> p.getPrice()).sum()));

        // Exercise 14 - Obtain a data map with list of product name by category
        Map<String, List<String>> result14 = productRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(product -> product.getName(), Collectors.toList())));

        // Exercise 15 - Get the most expensive product by category
        Map<String, Optional<Product>> result = productRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice)));

    }
}

