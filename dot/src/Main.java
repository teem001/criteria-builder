import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Double> amounts = List.of(30000D, 40000D, 2000D, 5000D, 15000D);

        Double sum = amounts.stream().reduce(Double::sum).get();

        WithdrawLimit withdrawLimit = new WithdrawLimit("LIMIT_5000", new FrequencyCriteria<>(100000D, amounts, 3, Compare.GREATER_THAN), new Criteria<>(sum, Compare.GREATER_THAN, 900000D ));




        Map<Double, SingleCriteriaSpec> prop = new HashMap<>();

        prop.put(10000D, new SingleCriteriaSpec(3, CriteriaStatus.EACH));
        prop.put(90000D, new SingleCriteriaSpec(1,  CriteriaStatus.ONCE));


        WithdrawLimitCriteria withdrawLimitCriteria = new WithdrawLimitCriteria(amounts, withdrawLimit);


     List<String> strings =   withdrawLimitCriteria.build().getFailedMessages();

        System.out.println(strings);

    }
}