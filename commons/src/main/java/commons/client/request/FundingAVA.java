package commons.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class FundingAVA {

    private String id;
    private String currency = "AVA";
    @JsonProperty("transaction_type")
    private String transactionType = "Reward";
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("fund")
    private float amount;
    private String reason;

    public FundingAVA(int userId, float amount) {
        this.userId = userId;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public FundingAVA setId(String id) {
        this.id = id;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public FundingAVA setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public FundingAVA setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public FundingAVA setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public FundingAVA setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public FundingAVA setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public FundingAVA updateReason(String name) {
        this.reason += name;
        return this;
    }

    public FundingAVA toLatin() {
        this.reason = StringUtils.stripAccents(this.reason);
        return this;
    }
}
