package problem25;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ApiFetcher {
    private static final String API_URL = "https://jsonplaceholder.typicode.com";

    public static String fetchData(String endpoint) throws Exception {
        URL url = new URL(API_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {  // OK status
            Scanner sc = new Scanner(url.openStream());
            StringBuilder output = new StringBuilder();
            while (sc.hasNext()) {
                output.append(sc.nextLine());
            }
            sc.close();
            return output.toString();
        } else {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> post = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchData("/posts/1");
            } catch (Exception e) {
                e.printStackTrace();
                return "Default value";
            }
        });

        CompletableFuture<String> comment = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchData("/comments/1");
            } catch (Exception e) {
                e.printStackTrace();
                return "Default value";
            }
        });

        CompletableFuture<String> user = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchData("/users/1");
            } catch (Exception e) {
                e.printStackTrace();
                return "Default value";
            }
        });

        CompletableFuture<Void> combinedFuture = post
                .thenAccept(result -> System.out.println("Post:\n" + result + "\n"))
                .thenCompose(a -> comment.thenAccept(result -> System.out.println("Comment:\n" + result + "\n")))
                .thenCompose(a -> user.thenAccept(result -> System.out.println("User:\n" + result + "\n")));

        combinedFuture.get();
    }
}


