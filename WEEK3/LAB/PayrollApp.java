package WEEK3.LAB;
class Employee {
    private String id, name;
    private double base;
    private static int total=0;

    Employee(String n, double b){ name=n; base=b; id="E"+(++total); }
    double calculateSalary(double bonus){ return base+bonus; }
    double calculateSalary(int hours, double rate){ return hours*rate; }
    void displayInfo(){ System.out.println(id+" "+name+" "+base); }
}

public class PayrollApp{
    public static void main(String[] args){
        Employee f = new Employee("Alice",5000);
        Employee p = new Employee("Bob",0);
        System.out.println(f.calculateSalary(500));
        System.out.println(p.calculateSalary(20,100));
        f.displayInfo(); p.displayInfo();
    }
}

