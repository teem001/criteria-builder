import java.util.List;
import java.util.Map;

public class WithdrawLimit {

    private final String withdrawalLimitName;

    private final FrequencyCriteria<Double, List<Double>> frequencyCriteria;

    private final Criteria<Double> criteria;



    public WithdrawLimit( String withdrawalLimitName, FrequencyCriteria<Double,
            List<Double>> frequencyCriteria, Criteria<Double> criteria) {
        this.withdrawalLimitName = withdrawalLimitName;
        this.frequencyCriteria = frequencyCriteria;
        this.criteria = criteria;
    }


    public String getWithdrawalLimitName() {
        return withdrawalLimitName;
    }

    public FrequencyCriteria<Double, List<Double>> getFrequencyCriteria() {
        return frequencyCriteria;
    }

    public Criteria<Double> getCriteria() {
        return criteria;
    }

    public void validate() {
        getCriteria().build();
        getFrequencyCriteria().build();
    }
}
