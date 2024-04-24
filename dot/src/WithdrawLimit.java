import java.util.List;

public class WithdrawLimit {

    private final WithdrawLimitEntity withdrawLimitEntity;
    private final FrequencyCriteria<Double, List<Double>> frequencyCriteria;

    private final Criteria<Double> criteria;


    public WithdrawLimit( WithdrawLimitEntity withdrawLimitEntity, FrequencyCriteria<Double,
            List<Double>> frequencyCriteria, Criteria<Double> criteria) {
        this.withdrawLimitEntity = withdrawLimitEntity;
        this.frequencyCriteria = frequencyCriteria;
        this.criteria = criteria;
    }


    public WithdrawLimitEntity getWithdrawLimitEntity() {
        return withdrawLimitEntity;
    }

    public FrequencyCriteria<Double, List<Double>> getFrequencyCriteria() {
        return frequencyCriteria;
    }

    public Criteria<Double> getCriteria() {
        return criteria;
    }

    public void validate() {
        if (getCriteria() != null)
            getCriteria().build();

        if (getFrequencyCriteria() != null)
            getFrequencyCriteria().build();
    }
}
