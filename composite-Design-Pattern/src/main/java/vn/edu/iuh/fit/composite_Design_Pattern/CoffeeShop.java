package vn.edu.iuh.fit.composite_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
    private List<Table> tables;

    public CoffeeShop() {
        this.tables = new ArrayList<>();
    }

    public Table createTable(int tableNumber) {
        Table table = new Table(tableNumber);
        tables.add(table);
        return table;
    }

    public Table getTable(int tableNumber) {
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null;
    }

    public void printAllTables() {
        System.out.println("TÌNH TRẠNG CÁC BÀN:");
        for (Table table : tables) {
            table.printBill();
        }
    }
}
