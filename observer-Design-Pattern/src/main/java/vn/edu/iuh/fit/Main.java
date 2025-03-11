package vn.edu.iuh.fit;

import vn.edu.iuh.fit.observer_design_pattern.ClassRoom;
import vn.edu.iuh.fit.observer_design_pattern.Faculty;
import vn.edu.iuh.fit.observer_design_pattern.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Tạo Khoa và các lớp học
        Faculty faculty = new Faculty();
        ClassRoom classA = faculty.createClass("CNTT-A");
        ClassRoom classB = faculty.createClass("CNTT-B");

        // Tạo các sinh viên
        Student student1 = new Student("SV001", "Nguyễn Văn A");
        Student student2 = new Student("SV002", "Trần Thị B");
        Student student3 = new Student("SV003", "Lê Văn C");
        Student student4 = new Student("SV004", "Phạm Thị D");

        // Đăng ký sinh viên vào các lớp học
        classA.registerObserver(student1);
        classA.registerObserver(student2);
        classB.registerObserver(student3);
        classB.registerObserver(student4);

        // Lớp trưởng gửi thông báo
        System.out.println("Lớp trưởng lớp CNTT-A gửi thông báo:");
        classA.setMessage("Ngày mai lớp sẽ học bù vào buổi chiều.");

        System.out.println("\nLớp trưởng lớp CNTT-B gửi thông báo:");
        classB.setMessage("Tuần sau lớp sẽ có bài kiểm tra.");
    }
}