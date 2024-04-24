public class WithdrawLimitEntity {

    private final String withdrawLimitName;

    private final String description;

    private final double minimumTotalLimit;

    private  final double minimumSingleLimit;
    private final  int minimumSingleLimitCount;

    public WithdrawLimitEntity(String withdrawLimitName, String description, double minimumTotalLimit, double mininumSingleLimit, int minimumSingleLimitCount) {
        this.withdrawLimitName = withdrawLimitName;
        this.description = description;
        this.minimumTotalLimit = minimumTotalLimit;
        this.minimumSingleLimit = mininumSingleLimit;
        this.minimumSingleLimitCount = minimumSingleLimitCount;
    }

    public String getWithdrawLimitName() {
        return withdrawLimitName;
    }

    public String getDescription() {
        return description;
    }

    public double getMinimumTotalLimit() {
        return minimumTotalLimit;
    }

    public double getMinimumSingleLimit() {
        return minimumSingleLimit;
    }

    public int getMinimumSingleLimitCount() {
        return minimumSingleLimitCount;
    }
}
