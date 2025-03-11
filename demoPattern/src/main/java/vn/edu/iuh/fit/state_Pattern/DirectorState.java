package vn.edu.iuh.fit.state_Pattern;

public class DirectorState implements RoleState{
    @Override
    public void performDuties() {
        System.out.println("Director.");
    }
}
