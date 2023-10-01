import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class exampleCall {
    public HttpResponse<String> example() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://twelve-data1.p.rapidapi.com/time_series?symbol=AMZN&interval=1day&outputsize=30&format=json"))
                .header("X-RapidAPI-Key", "ebe47e25a1msh9098aed74483d87p1f8f4ajsn564bc68013e2")
                .header("X-RapidAPI-Host", "twelve-data1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }

}
