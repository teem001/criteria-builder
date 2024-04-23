import java.util.ArrayList;
import java.util.List;

public abstract class CriteriaValidator {

    public static final List<String> failValidationMessages = new ArrayList<>();
    private final List<Boolean> buildResult = new ArrayList<>();

    abstract boolean build();



    public void addReasonForInvalidation(String message){

        failValidationMessages.add(message);
    }
    public void addReasonForInvalidation(boolean message){

        buildResult.add(message);
    }


}
