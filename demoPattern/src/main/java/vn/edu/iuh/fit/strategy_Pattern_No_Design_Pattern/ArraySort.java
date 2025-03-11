package vn.edu.iuh.fit.strategy_Pattern_No_Design_Pattern;

import java.util.Arrays;

public class ArraySort {
    private int[] array;

    public ArraySort(int[] array) {
        this.array = array.clone();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] mergeSort() {
        // Giả lập MergeSort
        System.out.println("Arrange with MergeSort");
        return array;
    }

    public int[] quickSort() {
        // Giả lập QuickSort
        System.out.println("Arrange with QuickSort");
        return array;
    }

    public int[] bubbleSort() {
        // Giả lập BubbleSort
        System.out.println("Arrange with BubbleSort");
        return array;
    }

    @Override
    public String toString() {
        return "ArraySort{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}