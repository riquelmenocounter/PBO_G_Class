package mini_project;

class Employee {
    private String name;
    private String employee_id;
    private double salary;
    
    public Employee(String name, String employee_id, double salary) {
        this.name = name;
        this.employee_id = employee_id;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public String getemployee_id() {
        return employee_id;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public double calculateBonus() {
        return 0.0;
    }
    
    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employee_id);
        System.out.println("Salary: Rp " + String.format("%,.0f", salary));
        System.out.println("Bonus: Rp " + String.format("%,.0f", calculateBonus()));
    }
}
