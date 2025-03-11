package vn.edu.iuh.fit;


import vn.edu.iuh.fit.composite_Design_Pattern.CoffeeShop;
import vn.edu.iuh.fit.composite_Design_Pattern.MenuItem;
import vn.edu.iuh.fit.composite_Design_Pattern.Table;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// Tạo các món trong menu
        MenuItem espresso = new MenuItem("Espresso", 25000);
        MenuItem americano = new MenuItem("Americano", 30000);
        MenuItem latte = new MenuItem("Latte", 35000);
        MenuItem cappuccino = new MenuItem("Cappuccino", 40000);
        MenuItem croissant = new MenuItem("Croissant", 25000);
        MenuItem cheesecake = new MenuItem("Cheesecake", 40000);

        // Tạo quán cà phê và các bàn
        CoffeeShop coffeeShop = new CoffeeShop();
        Table table1 = coffeeShop.createTable(1);
        Table table2 = coffeeShop.createTable(2);

        // Đặt món cho bàn 1
        table1.addItem(espresso);
        table1.addItem(cappuccino);
        table1.addItem(croissant);

        // Đặt món cho bàn 2
        table2.addItem(latte);
        table2.addItem(americano);
        table2.addItem(cheesecake);

        // In hóa đơn cho từng bàn
        coffeeShop.printAllTables();

    }
}