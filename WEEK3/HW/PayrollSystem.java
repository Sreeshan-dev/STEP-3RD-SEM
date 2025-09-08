//import java.util.*;

class Employee {
    String empId, empName, department, designation, joinDate;
    double baseSalary;
    boolean[] attendanceRecord;

    static int totalEmployees = 0;
    static String companyName = "Tech Solutions Ltd.";
    static double totalSalaryExpense = 0.0;
    static int workingDaysPerMonth = 30;

    Employee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.attendanceRecord = new boolean[workingDaysPerMonth];
        totalEmployees++;
    }

    void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= workingDaysPerMonth) {
            attendanceRecord[day - 1] = present;
        }
    }

    int getPresentDays() {
        int count = 0;
        for (boolean day : attendanceRecord) if (day) count++;
        return count;
    }

    double calculateSalary() {
        int presentDays = getPresentDays();
        double salary = (baseSalary / workingDaysPerMonth) * presentDays;
        totalSalaryExpense += salary;
        return salary;
    }

    double calculateBonus() {
        return getPresentDays() >= 25 ? baseSalary * 0.10 : 0;
    }

    void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        System.out.println("PaySlip for " + empName + " | Dept: " + department);
        System.out.println("Base: " + baseSalary + " | Salary: " + salary + " | Bonus: " + bonus);
        System.out.println("Total Pay: " + (salary + bonus));
    }
}

class Department {
    String deptId, deptName;
    Employee manager;
    Employee[] employees;
    double budget;

    Department(String deptId, String deptName, Employee manager, int capacity, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.employees = new Employee[capacity];
        this.budget = budget;
    }

    void addEmployee(Employee emp) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = emp;
                return;
            }
        }
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("E001", "John", "IT", "Full-time", 30000, "01-01-2023");
        Employee e2 = new Employee("E002", "Sara", "HR", "Part-time", 15000, "01-02-2023");

        e1.markAttendance(1, true);
        e1.markAttendance(2, true);
        e1.markAttendance(3, false);
        e1.markAttendance(4, true);

        e2.markAttendance(1, true);
        e2.markAttendance(2, false);
        e2.markAttendance(3, true);

        e1.generatePaySlip();
        e2.generatePaySlip();

        System.out.println("Total Employees: " + Employee.totalEmployees);
        System.out.println("Total Salary Expense: " + Employee.totalSalaryExpense);
    }
}
