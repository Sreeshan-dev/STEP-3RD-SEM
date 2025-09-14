package STEP.WEEK3.LAB; 
class Vehicle {
    private String id, brand;
    private double rent;
    private boolean available=true;
    private static int totalVehicles=0;
    private static double totalRevenue=0;

    Vehicle(String b,double r){ brand=b; rent=r; id="V"+(++totalVehicles); }
    double rentVehicle(int days){ if(available){ available=false; totalRevenue+=days*rent; return days*rent;} return 0; }
    void returnVehicle(){ available=true; }
    void displayInfo(){ System.out.println(id+" "+brand+" "+rent+" "+available); }
    static void showStats(){ System.out.println("Total Revenue: "+totalRevenue); }
}

public class RentalApp{
    public static void main(String[] args){
        Vehicle v1=new Vehicle("Honda",500), v2=new Vehicle("Toyota",600);
        v1.rentVehicle(3); v2.rentVehicle(2);
        v1.displayInfo(); v2.displayInfo();
        Vehicle.showStats();
    }
}

