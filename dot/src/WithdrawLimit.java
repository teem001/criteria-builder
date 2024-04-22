import java.util.Map;

public class WithdrawLimit {

    private final double amount;

    private double minNumberOfTransaction;
    private Map<Double, SingleCriteriaSpec> properties;

    public WithdrawLimit(double amount) {
        this.amount = amount;
    }


    public double getAmount() {
        return amount;
    }

    public double getMinNumberOfTransaction() {
        return minNumberOfTransaction;
    }

    public void setMinNumberOfTransaction(double minNumberOfTransaction) {
        this.minNumberOfTransaction = minNumberOfTransaction;
    }


    public Map<Double, SingleCriteriaSpec> getProperties() {
        return properties;
    }

    public void setProperties(Map<Double, SingleCriteriaSpec> properties) {
        this.properties = properties;
    }
}
