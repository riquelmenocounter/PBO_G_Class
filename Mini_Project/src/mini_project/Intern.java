package mini_project;

class Intern extends Employee {
    private String school_name;
    private int intern_duration;
    
    public Intern(String name, String employee_id, double salary, String school_name, int intern_duration) {
        super(name, employee_id, salary);
        this.school_name = school_name;
        this.intern_duration = intern_duration;
    }
    
    public String getSchoolName() {
        return school_name;
    }
    
    public int getIntern_Duration() {
        return intern_duration;
    }
    
    @Override
    public double calculateBonus() {
        return intern_duration * 100000;
    }
    
    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Position: Intern");
        System.out.println("School Name: " + school_name);
        System.out.println("Internship Duration: " + intern_duration + " months");
    }
}