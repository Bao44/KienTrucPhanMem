package vn.edu.iuh.fit.state_Pattern;

public class TeamLeaderState implements RoleState {
    @Override
    public void performDuties() {
        System.out.println("Team Leader.");
    }
}
