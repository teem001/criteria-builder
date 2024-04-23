public enum Compare {
    GREATER_THAN(1),LESS_THAN(-1), EQUAL_TO(0);

    private final int compareValue;

    Compare(int compareValue){
        this.compareValue = compareValue;
    }

    public int getCompareValue() {
        return compareValue;
    }
}
