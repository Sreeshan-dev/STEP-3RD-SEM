package STEP.WEEK4.HW;

class FoodOrder {
    String customerName,foodItem;
    int quantity;
    double price;
    FoodOrder() { customerName="Unknown"; foodItem="None"; }
    FoodOrder(String f) { foodItem=f; quantity=1; price=100; }
    FoodOrder(String f,int q) { foodItem=f; quantity=q; price=q*100; }
    void printBill() { System.out.println(foodItem+" x"+quantity+" = "+price); }
    public static void main(String[] args) {
        new FoodOrder().printBill();
        new FoodOrder("Burger").printBill();
        new FoodOrder("Pizza",3).printBill();
    }
}
