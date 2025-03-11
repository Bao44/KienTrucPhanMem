package vn.edu.iuh.fit.strategy_Pattern;

public class BubbleSort implements SortStrategy {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Sắp xếp bằng BubbleSort");
        return array.clone(); // Giả lập
    }
}