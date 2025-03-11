package vn.edu.iuh.fit.state_Pattern;

public class OfficeStaffState implements RoleState{
    @Override
    public void performDuties() {
        System.out.println("Office Staff.");
    }
}
