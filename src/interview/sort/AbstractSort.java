package interview.sort;

public abstract class AbstractSort implements Sort{
    private final String sortName;

    public AbstractSort(String sortName) {
        this.sortName = sortName;
    }

    public String getSortName() {
        return sortName;
    }
}
