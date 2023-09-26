package hw5_multithread.CompletableFuture;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Author: hyc
 */
public class APITest {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static CompletableFuture<String> getProductInformation() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static CompletableFuture<String> getReviews() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static CompletableFuture<String> getInventory() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static void main(String[] args) {
        getProductInformation().thenAccept(System.out::println);
        getReviews().thenAccept(System.out::println);
        getInventory().thenAccept(System.out::println);
    }
}
