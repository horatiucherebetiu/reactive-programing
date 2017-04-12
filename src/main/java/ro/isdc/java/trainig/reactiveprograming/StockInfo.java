package ro.isdc.java.trainig.reactiveprograming;

import java.time.Instant;

/**
 * Created by Horatiu.Cherebetiu on 4/12/2017.
 */
public class StockInfo {

    private String stokValue;

    public StockInfo(String stokValue) {
        this.stokValue = stokValue;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "stokValue='" + stokValue + '\'' +
                '}';
    }

    public static StockInfo fetch(String symbol) {
        return new StockInfo(symbol + " " + Instant.now().getNano());
    }
}
