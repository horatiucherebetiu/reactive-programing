package ro.isdc.java.trainig.reactiveprograming.unsubscribe;

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
        System.out.println("Start emitting...");

        symbols.stream()
                .map(StockInfo::fetch)
                .forEach(subscriber::onNext);

        subscriber.onComplete();
        subscriber.onNext(new StockInfo("DONE", 0));
    }
}
