package ro.isdc.java.trainig.reactiveprograming;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

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

//        while(true) {
            symbols.stream()
                    .map(StockInfo::fetch)
                    .forEach(subscriber::onNext);
//        }
    }
}
