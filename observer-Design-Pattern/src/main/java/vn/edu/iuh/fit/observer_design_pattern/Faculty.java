package vn.edu.iuh.fit.observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private List<ClassRoom> classes;

    public Faculty() {
        this.classes = new ArrayList<>();
    }

    public ClassRoom createClass(String className) {
        ClassRoom newClass = new ClassRoom(className);
        classes.add(newClass);
        return newClass;
    }

    public ClassRoom getClass(String className) {
        for (ClassRoom classRoom : classes) {
            if (classRoom.getClassName().equals(className)) {
                return classRoom;
            }
        }
        return null;
    }
}
