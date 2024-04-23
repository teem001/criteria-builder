import java.util.List;

public class WithdrawLimitCriteria {

    private final List<Double> listOfAmount;

    private final WithdrawLimit withdrawLimits;


    public WithdrawLimitCriteria(List<Double> listOfAmount, WithdrawLimit withdrawLimits) {
        this.listOfAmount = listOfAmount;
        this.withdrawLimits = withdrawLimits;
    }


    public WithdrawLimitCriteria build(){


        withdrawLimits.validate();
       return this;

    }

    public List<Double> getListOfAmount() {
        return listOfAmount;
    }

    public WithdrawLimit getWithdrawLimits() {
        return withdrawLimits;
    }

    public List<String> getFailedMessages() {
        return CriteriaValidator.failValidationMessages;
    }


}
