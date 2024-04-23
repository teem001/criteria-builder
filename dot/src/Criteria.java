import java.util.Comparator;

public class Criteria<T extends Comparable<T>> extends CriteriaValidator {

    private final T value;
    private final Compare compare;
    private final T result;


    public Criteria(T value, Compare compare, T result) {
        this.value = value;
        this.compare = compare;
        this.result = result;
    }


    public boolean build(){
        int compareValue = value.compareTo(result);
        var value = compare.getCompareValue() == compareValue;
        if(!value) super.addReasonForInvalidation(String.format("The expect value of  %s is not equal or greater to the actual %s", this.value, result ));
        return value;
    }

}
