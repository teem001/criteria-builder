public class SingleCriteriaSpec {

    private int numberOfTimes;
    private CriteriaStatus criteriaStatus;

    public SingleCriteriaSpec(int numberOfTimes, CriteriaStatus criteriaStatus) {
        this.numberOfTimes = numberOfTimes;
        this.criteriaStatus = criteriaStatus;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }


    public CriteriaStatus getCriteriaStatus() {
        return criteriaStatus;
    }

    public void setCriteriaStatus(CriteriaStatus criteriaStatus) {
        this.criteriaStatus = criteriaStatus;
    }
}
