import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WithdrawLimitCriteria {

    private final List<Double> listOfAmount;

    private final WithdrawLimit withdrawLimits;

    private final List<String>  failedMessages;


    public WithdrawLimitCriteria(List<Double> listOfAmount, WithdrawLimit withdrawLimits) {
        this.listOfAmount = listOfAmount;
        this.withdrawLimits = withdrawLimits;
        this.failedMessages = new ArrayList<>();
    }


    public WithdrawLimitCriteria build(){

        Double totalAmount = listOfAmount.stream().reduce(0D, Double::sum);

        int size = listOfAmount.size();

        if(size < withdrawLimits.getMinNumberOfTransaction()) failedMessages.add(String.format("Minimum number of transaction not reached, needed %s found %s",withdrawLimits.getMinNumberOfTransaction(), size));

       withdrawLimits.getProperties().forEach( (p, q) ->{
           if(q.getCriteriaStatus() == CriteriaStatus.EACH) {

               int count = (int) listOfAmount.stream().filter(amount-> amount >= p  ).count();

               if(count < q.getNumberOfTimes())
                   failedMessages.add(String.format("transaction with amount %s must be performed %s but found %s ", p, q.getNumberOfTimes(), count));

           }
           else {

               if(totalAmount.compareTo(p) < 1) failedMessages.add(String.format("The total transaction of %s is less minimum transaction of %s", totalAmount, p));
           }
               }

       );

       return this;

    }

    public List<Double> getListOfAmount() {
        return listOfAmount;
    }

    public WithdrawLimit getWithdrawLimits() {
        return withdrawLimits;
    }

    public List<String> getFailedMessages() {
        return failedMessages;
    }


}
