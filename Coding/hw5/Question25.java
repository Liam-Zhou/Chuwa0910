package homework.hw5;

import com.sun.deploy.net.HttpResponse;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Question25 {
    public static void main(String[] args) {
        Homework1 h1 = new Homework1();
        Homework23 h2 = new Homework23();
    }

    static class Homework1 {
        public Homework1() {
            int num1 = 5;
            int num2 = 6;
            CompletableFuture<Integer> homework1Sum = CompletableFuture.supplyAsync(() -> num1 + num2);
            CompletableFuture<Integer> homework1Product = CompletableFuture.supplyAsync(() -> num1 * num2);
            CompletableFuture<Integer> result = homework1Sum.thenCombine(homework1Product, (sum, product) -> {
                System.out.println("Sum: " + sum);
                System.out.println("Product: " + product);
                return null;
            });
            result.join();
        }
    }

    static class Homework23 {
        public Homework23() {
            String userUrl = "https://jsonplaceholder.typicode.com/users/1",
                    todoUrl = "https://jsonplaceholder.typicode.com/todos/1",
                    photosUrl = "https://jsonplaceholder.typicode.com/photos/1";
            CompletableFuture<String> userData = CompletableFuture.supplyAsync(() -> fetchData(userUrl));
            CompletableFuture<String> todoData = CompletableFuture.supplyAsync(() -> fetchData(todoUrl));
            CompletableFuture<String> photoData = CompletableFuture.supplyAsync(() -> fetchData(photosUrl));

            CompletableFuture<Void> allOf = CompletableFuture.allOf(userData, todoData, photoData);

            allOf.thenRun(() -> {
                try {
                    String users = userData.get();
                    String todos = todoData.get();
                    String photos = photoData.get();

                    System.out.println(mergeData(users, todos, photos));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            allOf.exceptionally((e) -> {
                e.printStackTrace();
                return null;
            });

            allOf.join();
        }

        public static String fetchData(String url) {
            try {
                URL u = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) u.openConnection();

                connection.setRequestMethod("GET");
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    reader.close();
                    return response.toString();
                } else {
                    System.out.println("HTTP Request failed with: " + connection.getResponseCode());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static Map<String, String> mergeData(String users, String todos, String photos) {
            try {

                Map<String, String> mergedData = new HashMap<>();
                mergedData.put("user", users);
                mergedData.put("todo", todos);
                mergedData.put("photo", photos);


                return mergedData;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }
}
