package vn.edu.iuh.fit.strategy_Pattern;

public class QuickSort implements SortStrategy {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Sắp xếp bằng QuickSort");
        return array.clone(); // Giả lập
    }
}