import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Double> amounts = List.of(30000D, 40000D, 2000D, 5000D, 15000D);

        WithdrawLimit withdrawLimit = new WithdrawLimit(50000D);


        withdrawLimit.setMinNumberOfTransaction(5);

        Map<Double, SingleCriteriaSpec> prop = new HashMap<>();

        prop.put(10000D, new SingleCriteriaSpec(3, CriteriaStatus.EACH));
        prop.put(90000D, new SingleCriteriaSpec(1,  CriteriaStatus.ONCE));

        withdrawLimit.setProperties(prop);

        WithdrawLimitCriteria withdrawLimitCriteria = new WithdrawLimitCriteria(amounts, withdrawLimit);


     List<String> strings =   withdrawLimitCriteria.build().getFailedMessages();

        System.out.println(strings);

    }
}