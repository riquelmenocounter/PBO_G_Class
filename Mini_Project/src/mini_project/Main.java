package mini_project;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Company company = new Company();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getValidIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addEmployeeMenu();
                    break;
                case 2:
                    company.show_employee_details();
                    break;
                case 3:
                    calculateTotalBonusMenu();
                    break;
                case 4:
                    System.out.println("\nThank you for using Employee Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! Please select 1-4.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===========================================");
        System.out.println("           Welcome to Imam's Company       ");
        System.out.println("===========================================");
        System.out.println("1. Add an employee");
        System.out.println("2. Show all employee details");
        System.out.println("3. Calculate total bonuses");
        System.out.println("4. Exit");
        System.out.println("===========================================");
    }

    private static void addEmployeeMenu() {
        System.out.println("\n========== Add Employee ==========");
        System.out.println("Select employee type:");
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.println("3. Intern");
        
        int type = getValidIntegerInput("Enter employee type (1-3): ");

        if (type < 1 || type > 3) {
            System.out.println("\nInvalid employee type!");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("\nName cannot be empty!");
            return;
        }

        System.out.print("Enter employee ID: ");
        String employee_id = scanner.nextLine().trim();
        if (employee_id.isEmpty()) {
            System.out.println("\nEmployee ID cannot be empty!");
            return;
        }

        if (company.isEmployeeIDExists(employee_id)) {
            System.out.println("\nEmployee ID already exists!");
            return;
        }

        double salary = getValidDoubleInput("Enter salary: ");
        if (salary <= 0) {
            System.out.println("\nSalary must be greater than 0!");
            return;
        }

        Employee employee = null;

        switch (type) {
            case 1: 
                int teamSize = getValidIntegerInput("Enter team size: ");
                if (teamSize < 0) {
                    System.out.println("\nTeam size cannot be negative!");
                    return;
                }
                employee = new Manager(name, employee_id, salary, teamSize);
                break;

            case 2:
                System.out.print("Enter programming language: ");
                String programmingLanguage = scanner.nextLine().trim();
                if (programmingLanguage.isEmpty()) {
                    System.out.println("\nProgramming language cannot be empty!");
                    return;
                }
                employee = new Developer(name, employee_id, salary, programmingLanguage);
                break;

            case 3:
                System.out.print("Enter school name: ");
                String school_name = scanner.nextLine().trim();
                if (school_name.isEmpty()) {
                    System.out.println("\nSchool name cannot be empty!");
                    return;
                }
                int intern_duration = getValidIntegerInput("Enter internship duration (months): ");
                if (intern_duration <= 0) {
                    System.out.println("\nInternship duration must be greater than 0!");
                    return;
                }
                employee = new Intern(name, employee_id, salary, school_name, intern_duration);
                break;
        }

        if (employee != null) {
            company.add_employee(employee);
        }
    }

    private static void calculateTotalBonusMenu() {
        double totalBonus = company.calculateTotalBonus();
        System.out.println("\n========== Total Bonus ==========");
        System.out.println("Total bonuses to be paid: Rp " + String.format("%,.0f", totalBonus));
        System.out.println("===================================");
    }

    private static int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }

    private static double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}