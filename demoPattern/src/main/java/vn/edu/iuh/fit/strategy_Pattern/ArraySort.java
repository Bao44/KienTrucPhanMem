package vn.edu.iuh.fit.strategy_Pattern;

public class ArraySort {
    private SortStrategy sortStrategy;
    private int[] array;

    public ArraySort(int[] array) {
        this.array = array.clone();
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public int[] sort() {
        return sortStrategy.sort(array);
    }
}