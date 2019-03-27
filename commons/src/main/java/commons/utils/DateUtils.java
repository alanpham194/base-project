package commons.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static long getDifferentBetween(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return Math.abs(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)) + 1;
    }
}
