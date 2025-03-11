package vn.edu.iuh.fit.no_Design_Patter;

public class Employee {
    String chucVu;

    public Employee(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void handleRequest() {
        if (chucVu.equals("DT")) {
            System.out.println("DT.");
        } else if (chucVu.equals("GD")) {
            System.out.println("GD");
        } else if (chucVu.equals("NVVP")) {
            System.out.println("NVVP.");
        } else {
            System.out.println("No.");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "chucVu='" + chucVu + '\'' +
                '}';
    }
}


