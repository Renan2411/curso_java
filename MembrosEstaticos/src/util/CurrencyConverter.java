package util;

public class CurrencyConverter {

    private static final double IOF_TAX = 0.06;

    public static double dolarConverter(double brlValue, double dolarValue){
        return (brlValue * (1 + IOF_TAX)) * dolarValue;
    }

}
