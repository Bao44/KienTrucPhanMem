package vn.edu.iuh.fit.observer_design_pattern;

public class Student implements Observer {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Sinh viên " + name + " (MSSV: " + studentId + ") nhận thông báo: " + message);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}
