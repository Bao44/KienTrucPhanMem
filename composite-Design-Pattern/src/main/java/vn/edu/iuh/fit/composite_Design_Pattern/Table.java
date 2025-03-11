package vn.edu.iuh.fit.composite_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private int tableNumber;
    private MenuComposite order;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.order = new MenuComposite("Order for Table " + tableNumber);
    }

    public void addItem(MenuItem item) {
        order.add(item);
    }

    public void removeItem(MenuItem item) {
        order.remove(item);
    }

    public double getBill() {
        return order.getPrice();
    }

    public void printBill() {
        System.out.println("Hóa đơn cho bàn " + tableNumber + ":");
        order.print();
        System.out.println("Tổng tiền: " + getBill() + "đ");
        System.out.println();
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
