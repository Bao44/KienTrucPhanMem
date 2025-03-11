package vn.edu.iuh.fit.composite_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class MenuComposite implements MenuComponent {
    private String name;
    private List<MenuComponent> components = new ArrayList<>();

    public MenuComposite(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        components.add(component);
    }

    public void remove(MenuComponent component) {
        components.remove(component);
    }

    public MenuComponent getChild(int i) {
        return components.get(i);
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (MenuComponent component : components) {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println(name + ":");
        for (MenuComponent component : components) {
            component.print();
        }
    }
}
