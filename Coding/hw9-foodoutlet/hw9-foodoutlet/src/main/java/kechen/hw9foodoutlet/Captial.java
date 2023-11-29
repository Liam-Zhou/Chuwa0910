package kechen.hw9foodoutlet;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

class Capital {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        String canada = Capital.getCapital("Canada");
        System.out.println(canada);
    }

    public static String getCapital(String country)
    {
        try{
            // 利用gson从url中read json
            String co = country.replace(" ", "%20");
            URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=" + co);
            // 客户端http请求
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = br.readLine();
            System.out.println("line : " + line);

            Gson gson = new Gson();   // create Gson(序列化/反序列化json)
            Country c = gson.fromJson(line, Country.class);
            Data d = c.data.get(0);
            String capital = d.capital;
            return capital;
        }catch(Exception e){
            System.out.println(e);
        }
        return "-1";
    }

    static class Country{
        int page, per_page, total, total_pages;
        List<Data> data;
    }
    static class Data{
        String name, capital;
        List<String> callingCodes;
    }
}
