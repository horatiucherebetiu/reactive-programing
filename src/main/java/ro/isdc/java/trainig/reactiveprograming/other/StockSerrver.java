package ro.isdc.java.trainig.reactiveprograming.other;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import ro.isdc.java.trainig.reactiveprograming.StockInfo;

import java.util.List;

/**
 * Created by Horatiu.Cherebetiu on 4/12/2017.
 */
public class StockSerrver {

    public static Observable<StockInfo> getFeed(List<String> symbols) {
        return Observable.create(subscribe -> emit(subscribe, symbols));
    }

    private static void emit(ObservableEmitter<StockInfo> subscriber, List<String> symbols) {

        int i = 0;
        while (i < 300) {
            i++;
            symbols.stream()
                    .map(StockInfo::fetch)
                    .forEach(subscriber::onNext);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subscriber.onComplete();
    }
}
