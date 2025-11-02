package mini_project;

class Manager extends Employee {
    private int TeamSize;
    
    public Manager(String name, String employee_id, double salary, int TeamSize) {
        super(name, employee_id, salary);
        this.TeamSize = TeamSize;
    }
    
    public int getTeamSize() {
        return TeamSize;
    }
    
    @Override
    public double calculateBonus() {
        return (getSalary() * 0.20) + (TeamSize * 500000);
    }
    
    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Position: Manager");
        System.out.println("Team Size: " + TeamSize + " members");
    }
}
