package ro.isdc.java.trainig.reactiveprograming.exception;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Horatiu.Cherebetiu on 4/12/2017.
 */
public class Sample {

    public static void main(String[] args) {
        final List<String> symbols = Arrays.asList("GOOGLE", "AMAZON", "INIC", "MSFT");

        Observable<StockInfo> feed = StockSerrver.getFeed(symbols);
        System.out.println("Got observable");

        feed.subscribe(
                System.out::println,
                err -> System.out.println("ERROR: " + err),
                () -> System.out.println("DONE")
        );
    }
}
