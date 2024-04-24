import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        WithdrawLimitEntity entity = new WithdrawLimitEntity("LIMIT_500000", "This is to increase the withdral limit to 500000", 200000, 3000, 5)

        List<Double> amounts = List.of(30000D, 40000D, 2000D, 5000D, 15000D);

        Double sum = amounts.stream().reduce(Double::sum).get();

        WithdrawLimit withdrawLimit = new WithdrawLimit("LIMIT_5000", new FrequencyCriteria<>(100000D, amounts, 3, Compare.GREATER_THAN), null);


        WithdrawLimitCriteria withdrawLimitCriteria = new WithdrawLimitCriteria(amounts, withdrawLimit);


     List<String> strings =   withdrawLimitCriteria.build().getFailedMessages();

        System.out.println(strings);

    }
}