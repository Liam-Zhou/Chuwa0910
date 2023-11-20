package space.gavinklfong.demo.streamapi.models;

import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise {
    /** Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
     *
     * : This is obviously a filtering logic, the output should fulfill the two filtering requirements.
     * So, you can apply 2 filter() operations to obtain the result.
     */
    public static void Exercise1(){
        List<Product> result = ProductRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());
    }

    /** Exercise 2 — Obtain a list of order with products belong to category “Baby”
     *
     * You need to start from the data flow from the order entities and then check if order’s products
     * belong to the category “Baby”.
     * Hence, the filter logic looks into the products stream of each order record
     * and use anyMatch() to determine if any product fulfill the criteria.
     */
    public static void Exercise2(){
        List<Order> result = OrderRepo.findAll()
                .stream()
                .filter(order -> order.getProducts()
                        .stream()
                        .anyMatch(product -> product.getCategory().equalsIgnoreCase("Baby"))
                )
                .collect(Collectors.toList());
    }

    /** Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
     *
     * :In this exercise, you will see how to transform data using the stream API.
     * After you’ve obtained a product list with a category that belongs to “Toys” using filter(),
     * you can then apply a 10% discount to the product price by using map().
     *
     * why not just use : .map(product -> product.getPrice()*0.9)
     * : is likely related to the intention to create a new instance with the updated price while keeping the other fields unchanged.
     *
     * 1. **Using `product.getPrice() * 0.9`:**
     * This calculates the discounted price but doesn't create a new instance.
     * If your `Product` class is mutable (i.e., not designed to be immutable),
     * the existing `Product` instances in your stream would have their prices updated in place.
     *
     * 2. **Using `product.withPrice(product.getPrice() * 0.9)`:**
     *  This creates a new instance of `Product` with the updated price, following the principles of immutability.
     *  It ensures that the original `Product` instances remain unchanged,
     *  and a new instance is generated for each product in the stream with the modified price.
     *
     *  This approach is particularly useful when dealing with immutable or effectively immutable objects.
     *  It avoids unintended side effects and aligns with the principles of functional programming,
     *  where immutability is often preferred.
     */

    public static void Exercise3(){
        List<Product> result = ProductRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Toys"))
                // create a new Product instance for each product in the stream
                // .map(product -> product.getPrice()*0.9)
                .map(product -> product.withPrice(product.getPrice()*0.9))
                .collect(Collectors.toList());
    }

    /** Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
     *
     * :This exercise illustrates the usage of flatMap().
     * You can firstly start from an order list and then filter the list by customer tier and order date.
     * Next, get the product list from each order record and use flatMap() to emit product records into the stream.
     * For example, if we have 3 order records and each order contains 10 products,
     * then flatMap() will emit 10 data elements for each order record,
     * resulting in 30 (3 x 10) product record output in the stream.
     *
     * Since product list would contain duplicated product records if multiple orders would include the same product.
     * In order to generate a unique product list,
     * applying distinct() operation can help to produce the unique list.
     */
    public static void Exercise4(){
        List<Product> result = OrderRepo.findAll()
                .stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,2,1)) >= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,4,1)) <= 0)
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /** Exercise 5 — Get the cheapest products of “Books” category
     * One of the effective ways to obtain the product with the lowest price is to sort the product list by price
     * in an ascending order and get the first element.
     * Java Stream API provides sorted() operation for stream data sorting based on specific field attributes.
     * In order to obtain the first element in the stream, you can use the terminal operation findFirst().
     * The operation returns the first data element wrapped by Optional as it is possible that the output stream can be empty.
     *
     * This solution can only return a single product record with the lowest price.
     * If there are multiple product records with the same lowest price,
     * the solution should be modified such that it looks for the lowest price amount first and then filters product records
     * by the price amount so as to get a list of products with the same lowest price.
     */
    public static void Exercise5(){
        Optional<Product> result = ProductRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst();
        /*
        Optional<Product> products = ProductRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .min(Comparator.comparing(Product::getPrice));
         */
    }

    /** Exercise 6 — Get the 3 most recent placed order
     * Similar to previous exercise, the obvious solution is to sort the order records by order date field.
     * The tricky part is that the sorting this time should be in descending order such that
     * you can obtain the order records with the most recent order date.
     * It can be achieved simply by calling Comparator.reversed().
     */
    public static void Exercise6(){
        List<Order> result = OrderRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    /** Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021,
     * log the order records to the console and then return its product list
     *
     * You can see that this exercise involves two actions
     * — (1) write order records to the console  前一个输出order
     * and (2) produce a list of products.   后一个输出product
     * Generating different output from a stream is not possible,
     * how can we fulfill this requirement? Apart from running the stream flow twice,
     * operation peek() allows execution of system logic as part of a stream flow.
     * The sample solution runs peek() to write order records to the console right after data filtering,
     * then subsequent operations such as flatMap() will be executed for the output of product records.
     */
    public static void Exercise7(){
            List<Product> result = OrderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021,3,15)))
                    // peek 方法用于执行系统逻辑，例如在流处理的过程中输出信息到控制台，而不会改变流中的元素。
                .peek(order -> System.out.println(order.toString()))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /** Calculate total lump sum of all orders placed in Feb 2021  计算所有订单的总价
     *
     * All previous exercise was to output a record list by a terminal operation,
     * let’s do some calculation this time.
     * This exercise is to sum up all the products ordered in Feb 2021.
     * As you’ve gone through previous exercises,
     * you can easily obtain the list of products using filter() and flatMap() operations.
     * Next, you can make use of mapToDouble() operation to convert the stream into a stream of data type Double
     * by specifying the price field as the mapping value.
     * At last, terminal operation sum() will help you add up all values and return the total value.
     */
    public static void Exercise8(){
        Double result = OrderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,2,1)) >= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,3,1)) < 0)
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(product -> product.getPrice())
                .sum();
    }

    /** Exercise 9 — Calculate order average payment placed on 14-Mar-2021
     * In addition to total sum, stream API offers operation for average value calculation as well.
     * You might find that the return data type is different from sum() as it is an Optional data type.
     * The reason is that the data stream would be empty and so calculation won’t output an average value for a empty data stream.
     */
    public static void Exercise9(){
        Double result = OrderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021,3,14)))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(product -> product.getPrice())
                .average().getAsDouble();
    }

    /** Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
     * What if you need to get sum, average, max, min and count at the same time?
     * Should we run the data stream 5 times to get those figures one by one? Such an approach is not quite effective.
     * Luckily, stream API provides a convenient way to get all those values at once
     * by using terminal operation summaryStatistics().
     * It returns a data type DoubleSummaryStatistics which contains all the required figures.
     */
    public static void Exercise10(){
        DoubleSummaryStatistics result = ProductRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
    }

    /** Exercise 11 — Obtain a data map with order id and order’s product count
     * Except for value calculation, all previous exercises just output a record list.
     * The helper class Collectors provide a number of useful operations for data consolidation and data collection output.
     * Let’s check out the exercise to create a data map with order id as the key while the associated value is product count.
     * The terminal operation Collectors.toMap() accepts two arguments for your specify the key and value respectively.
     */
    public static void Exercise11(){
        Map<Long, Integer> result = OrderRepo.findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                                order -> order.getId(),
                                order -> order.getProducts().size()
                        )
                );
    }

    /** Exercise 12 — Produce a data map with order records grouped by customer
     *
     *  This exercise is to consolidate a list of orders by customer.
     *  Collectors.groupingBy() is a handy function,
     *  you can just simply specify what is the key data element, it will then aggregate data for you.
     */
    public static void Exercise12(){
        Map<Customer, List<Order>> result = OrderRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(Order::getCustomer)
                );
    }

    /** Exercise 13 — Produce a data map with order record and product total sum
     *
     * The data map output this time is not a simple extraction of data fields from the stream,
     * you need to create a sub-stream for each order in order to calculate the product total sum.
     * Since, the key element is the order record itself instead of an order id,
     * so Function.identity() is used to tell Collectors.toMap() to use the data element as the key.
     */
    public static void Exercise13(){
        Map<Order, Double> result = OrderRepo.findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                order -> order.getProducts().stream()
                                        .mapToDouble(p -> p.getPrice()).sum()
                        )
                );
    }

    /** Exercise 14 — Obtain a data map with list of product name by category
     *
     *  This exercise helps you get familiar with the way to transform the data output of data map entries.
     *  If you only use Collectors.groupingBy(Product::getCategory),
     *  then the output will be
     *  Map<Category, List of Products> but the expected output should be Map<Category, List of Product Name>.
     *  You can use Collectors.mapping() to convert product objects to product names for the data map construction.
     */

    public static void Exercise14(){
        Map<String, List<String>> result = ProductRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                // 将每个类别中的产品名称收集到一个列表中。
                                Collectors.mapping(product -> product.getName(), Collectors.toList())
                        )
                );
    }

    /** Exercise 15 — Get the most expensive product by category
     *
     * Similar to data transformation using Collectors.mapping(),
     * Collectors.maxBy() helps to obtain the record with max value as part of data map construction.
     * By providing a comparator for product price, maxBy() is able to get the product with the largest value for each category.
     */

    public static void Exercise15(){
        Map<String, Optional<Product>> result = ProductRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))
                        )
                );
    }

}
