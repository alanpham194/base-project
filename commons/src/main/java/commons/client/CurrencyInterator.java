package commons.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CurrencyInterator {
    @Value("${EXCHANGE_RATE_URL}")
    String exchangeRateUrl;
    @Autowired
    ClientHelper clientHelper;

    public Float convertCurrency(float amount, String currency, String desCurrency) {
        String params = "?amount=" + amount + "&currency=" + currency + "&des_currency=" + desCurrency;
        return clientHelper.callRest(exchangeRateUrl, "GET", params, null, Float.class);
    }
}
