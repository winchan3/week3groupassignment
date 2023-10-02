package example;

public class ExampleCalls {
    public static void main(String[] args) {
        String API_TOKEN = "e8af6cedf9mshf35e68a5b040250p12fc53jsne75b26c51cd0";
        String exchange = "NASDAQ";
        String format = "json";
        String symbol = "AMZN";
        String interval = "1day";
        Integer outputsize = 10;
        System.out.println(RapidAPI.stocks(API_TOKEN, exchange, format));
        System.out.println(RapidAPI.timeSeries(API_TOKEN, symbol, interval, outputsize, format));
    }
}
