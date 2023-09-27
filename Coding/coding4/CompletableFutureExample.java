import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CompletableFutureExample {

    // Uses CompletableFuture to asynchronously get the sum and product of two integer.
    private static void homework1(int x, int y){
        CompletableFuture<Integer> doSum = CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(5);  //simulate a delay
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return x + y;
        });

        CompletableFuture<Integer> doProduct = CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(2);  //simulate a delay
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return x * y;
        });

        doSum.thenAcceptAsync(result -> {System.out.println("The sum is: " + result);});
        doProduct.thenAcceptAsync(result -> {System.out.println("The product is: " + result);});

        System.out.println("--------Start processing sum and product tasks----------");

        // Ensure that the program doesn't terminate before completing the futures
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(doSum, doProduct);
        combinedFuture.join(); // Wait for both futures to complete
    }

    // Use CompletableFuture to implement fake api fetching and merge the fetched data for further processing
    private static void homework2_3(){

        // simulate three url fetching
        String url1 = "https://jsonplaceholder.typicode.com/posts";
        String url2 = "https://jsonplaceholder.typicode.com/albums/1/photos";
        String url3 = "https://jsonplaceholder.typicode.com/posts/1/comments";

        CompletableFuture<String> processURL1 = CompletableFuture.supplyAsync(()->{
            return fetch(url1);
        });

        CompletableFuture<String> processURL2 = CompletableFuture.supplyAsync(()->{
            return fetch(url2);
        });

        CompletableFuture<String> processURL3 = CompletableFuture.supplyAsync(()->{
            return fetch(url3);
        });

        processURL1.thenAcceptAsync(result->{
            System.out.println("Data fetched from " + url1 + ":\n" + result);
        });

        processURL2.thenAcceptAsync(result->{
            System.out.println("Data fetched from " + url2 + ":\n" + result);
        });

        processURL3.thenAcceptAsync(result->{
            System.out.println("Data fetched from " + url3 + ":\n" + result);
        });

        System.out.println("---------Start fetching data from three urls--------");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(processURL1, processURL2, processURL3);
        combinedFuture.join();

        // do follow logics ...

    }

    private static String fetch(String urlString){
        try {
            // Create a URL object with the given URL
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method (GET by default)
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the request was successful (HTTP status code 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Create a BufferedReader to read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder responseData = new StringBuilder();

                // Read the response line by line and store it in responseData
                while ((line = reader.readLine()) != null) {
                    responseData.append(line);
                }

                // Close the reader and the connection
                reader.close();
                connection.disconnect();

                return responseData.toString();
            } else {
                System.err.println("Failed to fetch data. HTTP Response Code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }
        public static void main(String[] args) {
//            homework1(5, 7);
            homework2_3();

        }
}