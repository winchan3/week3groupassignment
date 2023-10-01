package example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class RapidAPI {

    public static JSONArray stocks(String API_TOKEN, String exchange, String format) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/stocks?exchange=%s&format=%s", exchange, format))
                .get()
                .addHeader("X-RapidAPI-Key", API_TOKEN)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getString("status").equals("ok")) {
                return responseBody.getJSONArray("data");
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject timeSeries (String API_TOKEN, String symbol, String interval, Integer size, String format) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://twelve-data1.p.rapidapi.com/time_series?symbol=%s&interval=%s&outputsize=%s&format=%s",
                        symbol, interval, size, format))
                .get()
                .addHeader("X-RapidAPI-Key", API_TOKEN)
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getString("status").equals("ok")) {
                return responseBody;
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

    }

}
