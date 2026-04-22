import java.util.Scanner;

// Employee class
class Employee {
    private static String companyName;
    private static int totalEmployees = 0;

    private String empId;
    private String name;
    private String department;
    private double salary;

    public Employee(String empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        totalEmployees++;
    }

    public static void setCompanyName(String name) { companyName = name; }
    public static int getTotalEmployees() { return totalEmployees; }

    public double calculateAnnualSalary() { return salary * 12; }
    public void updateSalary(double newSalary) { this.salary = newSalary; }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void displayEmployee() {
        System.out.println("[" + companyName + "] ID: " + empId + " | Name: " + name +
                " | Dept: " + department + " | Salary: " + salary);
    }
}

// Department class
class Department {
    private String deptName;
    private Employee[] employees;
    private int employeeCount;

    public Department(String deptName, int capacity) {
        this.deptName = deptName;
        this.employees = new Employee[capacity];
        this.employeeCount = 0;
    }

    public void addEmployee(Employee e) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = e;
            System.out.println("Added employee to " + deptName + " department");
        }
    }

    public void displayEmployees() {
        System.out.println("=== Department: " + deptName + " ===");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployee();
        }
    }

    public Employee findHighestPaid() {
        if (employeeCount == 0) return null;
        Employee highest = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() > highest.getSalary()) {
                highest = employees[i];
            }
        }
        return highest;
    }

    public double calculatePayroll() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    public Employee[] getEmployees() { return employees; }
    public int getEmployeeCount() { return employeeCount; }
}

// Main system
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee.setCompanyName("Tech Solutions Pvt Ltd");

        Department dev = new Department("Development", 10);
        Department hr = new Department("HR", 10);

        // Add employees
        dev.addEmployee(new Employee("E101", "Soham", "Development", 50000));
        dev.addEmployee(new Employee("E102", "Arjun", "Development", 60000));
        hr.addEmployee(new Employee("E201", "Maya", "HR", 45000));

        // Display dept info
        dev.displayEmployees();
        hr.displayEmployees();

        // Highest paid across company
        Employee highest = dev.findHighestPaid().getSalary() > hr.findHighestPaid().getSalary()
                ? dev.findHighestPaid() : hr.findHighestPaid();
        System.out.println("Highest Paid Employee: ");
        highest.displayEmployee();

        // Payroll
        System.out.println("Development Payroll: " + dev.calculatePayroll());
        System.out.println("HR Payroll: " + hr.calculatePayroll());

        // Company statistics
        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}
