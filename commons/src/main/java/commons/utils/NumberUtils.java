package commons.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtils {

    private static NumberUtils instance;

    public static synchronized NumberUtils getInstance() {
        if (instance == null) {
            instance = new NumberUtils();
        }

        return instance;
    }

    public String formatNumber(float number) {
        NumberFormat numberFormatter = new DecimalFormat("##");
        return numberFormatter.format(number);
    }

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public double round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}
