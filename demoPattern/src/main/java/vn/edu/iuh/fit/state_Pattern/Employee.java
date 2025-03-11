package vn.edu.iuh.fit.state_Pattern;

public class Employee {
    private RoleState roleState;

    public Employee(String chucVu) {
        setRole(chucVu);
    }

    public RoleState getRoleState() {
        return roleState;
    }

    public void setRoleState(RoleState roleState) {
        this.roleState = roleState;
    }

    public void setRole(String chucVu) {
        switch (chucVu) {
            case "DT":
                this.roleState = new TeamLeaderState();
                break;
            case "GD":
                this.roleState = new DirectorState();
                break;
            case "NVVP":
                this.roleState = new OfficeStaffState();
                break;
            default:
                throw new IllegalArgumentException("No.");
        }
    }

    public void performDuties() {
        roleState.performDuties();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "roleState=" + roleState +
                '}';
    }
}
