package mini_project;

class Developer extends Employee {
    private String programming_language;
    
    public Developer(String name, String employee_id, double salary, String programming_language) {
        super(name, employee_id, salary);
        this.programming_language = programming_language;
    }
    
    public String getprogramming_language() {
        return programming_language;
    }
    
    @Override
    public double calculateBonus() {
        return getSalary() * 0.15;
    }
    
    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Position: Developer");
        System.out.println("Programming Language: " + programming_language);
    }
}