package vn.edu.iuh.fit;

//import vn.edu.iuh.fit.no_Design_Patter.Employee;

//import vn.edu.iuh.fit.state_Pattern.Employee;

//import vn.edu.iuh.fit.strategy_Pattern_No_Design_Pattern.ArraySort;

//import vn.edu.iuh.fit.strategy_Pattern.ArraySort;
//import vn.edu.iuh.fit.strategy_Pattern.BubbleSort;
//import vn.edu.iuh.fit.strategy_Pattern.MergeSort;
//import vn.edu.iuh.fit.strategy_Pattern.QuickSort;

import vn.edu.iuh.fit.singleton_Pattern.DatabaseConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Employee emp1 = new Employee("DT");
//        Employee emp2 = new Employee("GD");
//        emp1.handleRequest();
//        emp2.handleRequest();


//        Employee emp1 = new Employee("DT");
//        Employee emp2 = new Employee("GD");
//        Employee emp3 = new Employee("NVVP");
//
//        emp1.performDuties();
//        emp2.performDuties();
//        emp3.performDuties();

//        int[] arr = {4, 5, 7, 3, 9};
//        ArraySort arraySort = new ArraySort(arr);
//        arraySort.mergeSort();
//        arraySort.quickSort();

//        int[] arr = {4, 5, 7, 3, 9};
//        ArraySort arraySort = new ArraySort(arr);
//
//        arraySort.setSortStrategy(new MergeSort());
//        arraySort.sort();
//
//        arraySort.setSortStrategy(new QuickSort());
//        arraySort.sort();
//
//        arraySort.setSortStrategy(new BubbleSort());
//        arraySort.sort();

        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.query("SELECT * FROM employees");
        System.out.println("db1 == db2: " + (db1 == db2)); // Kiểm tra cùng instance
    }
}