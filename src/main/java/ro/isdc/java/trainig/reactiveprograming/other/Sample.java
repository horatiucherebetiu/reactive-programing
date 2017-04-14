package ro.isdc.java.trainig.reactiveprograming.other;

import io.reactivex.Observable;
import ro.isdc.java.trainig.reactiveprograming.StockInfo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Horatiu.Cherebetiu on 4/12/2017.
 */
public class Sample {

    public static void main(String[] args) {
        final List<String> symbols = Arrays.asList("GOOGLE", "AMAZON", "INIC", "MSFT");

        Observable<StockInfo> feed = StockSerrver.getFeed(symbols)
                .filter( stockInfo -> stockInfo.getStokValue() > 12)
                .map(stockInfo -> new StockInfo(stockInfo.getSymbol(), stockInfo.getStokValue() + 0.9));

        // .take
        // .takeWhile
        // cold observer - separated session
        // hot observable - share session

        feed.subscribe(
                System.out::println,
                err -> System.out.println("ERROR: " + err),
                () -> System.out.println("DONE")
        );
    }
}
