package ro.isdc.java.trainig.reactiveprograming.exception;

import java.util.Random;

/**
 * Created by Horatiu.Cherebetiu on 4/12/2017.
 */
public class StockInfo {

    private double stokValue;

    private String symbol;

    public StockInfo(String symbol, double stokValue) {
        this.symbol = symbol;
        this.stokValue = stokValue;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "stokValue=" + stokValue +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    public double getStokValue() {
        return stokValue;
    }

    public void setStokValue(double stokValue) {
        this.stokValue = stokValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static StockInfo fetch(String symbol) {
        if ("INIC".equals(symbol)) {
           throw new RuntimeException("Unknow symbol = " + symbol);
        }
        return new StockInfo(symbol, new Random().nextInt(5) + 10);
    }
}
