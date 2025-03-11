package vn.edu.iuh.fit.composite_Design_Pattern;

public class MenuItem implements MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("  " + name + " - " + price + "đ");
    }
}
