package vn.edu.iuh.fit.observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom implements Subject {
    private List<Observer> observers;
    private String className;
    private String message;

    public ClassRoom(String className) {
        this.className = className;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    public String getClassName() {
        return className;
    }
}
