package com.chuwa.shawnlearning.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ShoppingCartUtil {
    private static final List<String> ALTERNATIVE_ITEMS = Arrays.asList("Apple", "Orange", "Banana", "Grape");

    public static Optional<String> getFirstItemName(Customer customer) {
        return Optional.of(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .map(items -> items.get(0))
                .map(Item::getName)
                .filter(ALTERNATIVE_ITEMS::contains);
    }

    public static double getTotalPrice(Optional<Customer> customer) {
        return customer
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .map(items -> items.stream().mapToDouble(Item::getPrice).sum())
                .orElse(0.0);
    }

    public static String getFirstItemNameOrThrowException(Customer customer) throws EmptyCartException {
        return Optional.of(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .map(items -> items.get(0))
                .map(Item::getName)
                .filter(ALTERNATIVE_ITEMS::contains)
                .orElseThrow(() -> new EmptyCartException("Empty cart"));
    }

    public static void checkItemsInCart(Customer customer) {
        // write you code
        Optional.of(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .ifPresentOrElse(items -> System.out.println("There are items in the cart"), () -> System.out.println("There are no items in the cart"));
    }

    public static void printItemsInCart(Customer customer) {
        // write you code
        Optional.of(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .ifPresent(items -> items.forEach(item -> System.out.println(item.getName())));
    }



    public static String getRandomAlternativeItem() {
        Random random = new Random();
        int randomIndex = random.nextInt(ALTERNATIVE_ITEMS.size());
        return ALTERNATIVE_ITEMS.get(randomIndex);
    }




}
