package mini_project;
import java.util.ArrayList;
import java.util.List;

class Company {
    private List<Employee> employee_list;
    
    public Company() {
        employee_list = new ArrayList<>();
    }
    
    public void add_employee(Employee employee) {
        employee_list.add(employee);
        System.out.println("\nEmployee added successfully!");
    }
    
    public double calculateTotalBonus() {
        double total_bonus = 0;
        for (Employee emp : employee_list) {
            total_bonus += emp.calculateBonus();
        }
        return total_bonus;
    }
    
    public void show_employee_details() {
        if(employee_list.isEmpty()) {
            System.out.println("\nNo employee added!");
            return;
        }
        
        System.out.println("\n=== Employee Details ===");
        for (Employee emp : employee_list) {
            emp.getInfo();
            System.out.println("==========================");
        }
    }
    
    public boolean isEmployeeIDExists(String employee_id) {
        for (Employee emp : employee_list) {
            if (emp.getemployee_id().equals(employee_id)) {
                return true;
            }
        }
        return false;
    } 
}