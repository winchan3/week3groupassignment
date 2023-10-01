package example;

import okhttp3.*;
import org.json.JSONException;

import java.io.IOException;

public class apiCall {
    public Response exampleCall () throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://twelve-data1.p.rapidapi.com/time_series?symbol=AMZN&interval=1day&outputsize=1&format=json")
                .get()
                .addHeader("X-RapidAPI-Key", "645ec5ac8emsh35e1f43b32b17e2p1d365bjsnd2dea193b697")
                .addHeader("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .build();

        try {
            return client.newCall(request).execute();
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
