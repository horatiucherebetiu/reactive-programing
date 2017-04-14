package ro.isdc.java.trainig.reactiveprograming.unsubscribe;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ro.isdc.java.trainig.reactiveprograming.StockInfo;

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

        feed.subscribe(new Observer<StockInfo>() {

            private Disposable disposable;

            @Override
            public void onSubscribe(Disposable disposable) {
                this.disposable = disposable;
            }

            @Override
            public void onNext(StockInfo stockInfo) {
                System.out.println(stockInfo);
                if (stockInfo.getStokValue() >= 6 && stockInfo.getStokValue() <= 8) {
                    System.out.println("unsubscribing...");
                    disposable.dispose();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        } );
    }
}
