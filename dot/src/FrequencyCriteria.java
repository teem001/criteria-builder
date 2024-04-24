import java.util.List;
import java.util.stream.Collectors;


public class FrequencyCriteria<T extends Comparable<T>, R extends List<T>> extends CriteriaValidator {

    private final T value;
    private final R TCollection;
    private final int frequency;

    private final Compare compare;
    public FrequencyCriteria(T value, R TCollection, int frequency, Compare compare) {
        this.value = value;
        this.TCollection = TCollection;
        this.frequency = frequency;
        this.compare = compare;
    }

    @Override
    boolean build() {
        int count =0;
        int lessThan = 0;
        int numberEqualOrGreater = 0;

        for (T t : TCollection){
            if(value.compareTo(t) == 0) {
                count++;
                numberEqualOrGreater++;
            }
           else if(value.compareTo(t) < 0) {
                lessThan++;
            }
           if(value.compareTo(t) > 0) {
               numberEqualOrGreater++;
            }

        }
        switch (compare) {
            case EQUAL_TO :{

                var value = count == frequency;
                System.out.println(value);
                if(!value) super.addReasonForInvalidation(String.format("The expect frequency of  %s is not equal to the actual %s for the value of %s",frequency, count, this.value ));
                return value;
            }
            case LESS_THAN: {

              var value =  frequency < lessThan;
                System.out.println(value);
                if(!value) super.addReasonForInvalidation(String.format("The expect frequency of  %s is not less than the actual %s for the value of %s",frequency, lessThan, this.value ));
                return value;
            }
            case GREATER_THAN: {
                var value =  frequency >= numberEqualOrGreater;
                System.out.println(value);
                if(!value) super.addReasonForInvalidation(String.format("The expect frequency of  %s is not greater than or equal to the actual %s for the value of %s",frequency, numberEqualOrGreater, this.value ));
                return value;
            }

        }

        return false;
    }
}
