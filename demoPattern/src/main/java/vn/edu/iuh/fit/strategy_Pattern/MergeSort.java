package vn.edu.iuh.fit.strategy_Pattern;

public class MergeSort implements SortStrategy {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Sắp xếp bằng MergeSort");
        return array.clone(); // Giả lập
    }
}
