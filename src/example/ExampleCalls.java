package example;

public class ExampleCalls {
    public static void main(String[] args) {
        String API_TOKEN = System.getenv("API_TOKEN");
        String exchange = "NASDAQ";
        String format = "json";
        String symbol = "AMZN";
        String interval = "1day";
        Integer outputsize = 10;
        System.out.println(RapidAPI.stocks(API_TOKEN, exchange, format));
        System.out.println(RapidAPI.timeSeries(API_TOKEN, symbol, interval, outputsize, format));
    }
}
