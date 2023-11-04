package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FoodOutletsJava8 {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        List<String> seattle = FoodOutletsJava8.getRelevantFoodOutlets11("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets11(String city, int maxCost) throws IOException{
        List<String> res = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_Addr = BASE_URL + "&page=1";

        //处理page1
        String resBody = callURL(URL_Addr);
        List<String> strings = processData(resBody,maxCost);
        res.addAll(strings);

        //get total_pages
        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();
        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString());

        // 处理剩余page: 2 - last page
        for (int i = 2; i <= total_pages; i++) {
            URL_Addr = BASE_URL + "&page=" + i;
            resBody = callURL(URL_Addr);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }

        return res;
    }

    // take the URL you want to make a GET request to. It may throw an IOException if there are I/O errors.
    private static String callURL(String URL_Addr) throws IOException{
        //Create a URL object using the provided URL address.
        URL url = new URL(URL_Addr);

        /*
        Open a connection to the URL using HttpURLConnection.

        It casts the connection to an HttpURLConnection object,
        which allows you to work with HTTP-specific features.
        将连接强制转换为HttpURLConnection对象，从而允许使用HTTP特定的功能。
        */
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /*
        Create a BufferedReader to read the response from the connection's input stream.

        sets up a BufferedReader to read the response from the input stream of the connection (con.getInputStream()).
        This allows you to read the content of the response.
        创建一个BufferedReader从connection的input stream来读取response

        getInputStream():
        getInputStream() is a method provided by HttpURLConnection 返回一个InputStream
        that returns an InputStream representing the input stream for the HTTP response.

        InputStreamReader:
        The InputStreamReader is used to read characters from an InputStream 从InputStream中读取characters
        It essentially converts the binary input stream into a character-based input stream.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        /*
        Read the first line of the response(from the BufferedReader) (assuming it's a single line).
        if the response has multiple lines,
        you would need to read them in a loop and concatenate them to build the complete response.
        */
        String line = br.readLine();


        // disconnects and close the connection.
        con.disconnect();

        /*
        Return the response body as a string.
        the method returns the line variable, which contains the response body as a string.
        This is the content of the first line of the HTTP response received from the specified URL.
        */
        return line;
    }

    /*
     takes a JSON response body (resBody) as a string and an integer maxCost as input.
     It processes the JSON data within the response body to extract information
     and filter it based on a maximum cost threshold
     */
    private static List<String> processData(String resBody, int maxCost){
        List<String> res = new ArrayList<>();

        /*
        Parse the JSON response body into a JsonObject.

        parses the resBody string into a JsonObject using a JSON parser (likely from a library like Gson).
        This allows you to access and manipulate the JSON data within the response body.
         */
        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();

        /*
        Extract the "data" array from the JSON.

        extracts the "data" array from the JSON object.
        It assumes that the JSON structure contains a "data" array.
         */
        JsonArray jsonArray = jsonBody.get("data").getAsJsonArray();

        // Iterate over each element (JSON object) in the "data" array
        jsonArray.forEach(d -> {
            /*
            Within the loop, it extracts the "estimated_cost" property from the current JSON object
            and converts it to an integer.
             */
            int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            /*
            Check if the estimated cost is less than or equal to the specified "maxCost."
             */
            if (estimated_cost <= maxCost) {
                /*
                 It checks if the estimated cost is less than or equal to the specified maxCost.
                 and add it to the result list.
                 */
                res.add(d.getAsJsonObject().get("name").getAsString());
            }
        });

        /*
        Return the list of names that meet the specified condition.
        which contains the names that meet the specified filtering criteria
        (i.e., names associated with objects in the JSON array whose "estimated_cost" is less than or equal to maxCost).
         */
        return res;
    }


}
