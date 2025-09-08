import java.util.*;

class Product {
    String productId;
    String productName;
    double price;
    String category;
    int stockQuantity;

    // Static variables
    static int totalProducts = 0;
    static String[] categories = {"Electronics", "Clothing", "Books", "Groceries", "Toys"};

    // Constructor
    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }

    // Static methods
    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.productId.equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public static void getProductsByCategory(Product[] products, String category) {
        System.out.println("\nProducts in category: " + category);
        for (Product p : products) {
            if (p != null && p.category.equalsIgnoreCase(category)) {
                System.out.println(p.productId + " - " + p.productName + " | ₹" + p.price + " | Stock: " + p.stockQuantity);
            }
        }
    }
}

class ShoppingCart {
    String cartId;
    String customerName;
    Product[] products;
    int[] quantities;
    double cartTotal;
    int itemCount;

    // Constructor
    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[50]; // max 50 items
        this.quantities = new int[50];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }

    // Methods
    public void addProduct(Product product, int quantity) {
        if (product.stockQuantity >= quantity) {
            products[itemCount] = product;
            quantities[itemCount] = quantity;
            product.stockQuantity -= quantity;
            itemCount++;
            calculateTotal();
            System.out.println(quantity + " x " + product.productName + " added to cart.");
        } else {
            System.out.println("Not enough stock available for " + product.productName);
        }
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i] != null && products[i].productId.equals(productId)) {
                products[i].stockQuantity += quantities[i]; // return stock
                System.out.println(products[i].productName + " removed from cart.");
                // Shift items left
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                calculateTotal();
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].price * quantities[i];
        }
    }

    public void displayCart() {
        System.out.println("\n--- Shopping Cart ---");
        if (itemCount == 0) {
            System.out.println("Cart is empty.");
        } else {
            for (int i = 0; i < itemCount; i++) {
                System.out.println(products[i].productName + " x " + quantities[i] + " | ₹" + (products[i].price * quantities[i]));
            }
            System.out.println("Cart Total: ₹" + cartTotal);
        }
    }

    public void checkout() {
        System.out.println("\n--- Checkout ---");
        displayCart();
        System.out.println("Thank you for shopping with us, " + customerName + "!");
        // Empty cart
        for (int i = 0; i < itemCount; i++) {
            products[i] = null;
            quantities[i] = 0;
        }
        itemCount = 0;
        cartTotal = 0.0;
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create product list (10 products)
        Product[] storeProducts = {
            new Product("P101", "Laptop", 55000, "Electronics", 5),
            new Product("P102", "Smartphone", 25000, "Electronics", 10),
            new Product("P103", "T-Shirt", 500, "Clothing", 20),
            new Product("P104", "Jeans", 1200, "Clothing", 15),
            new Product("P105", "Novel", 300, "Books", 30),
            new Product("P106", "Textbook", 800, "Books", 25),
            new Product("P107", "Rice (10kg)", 600, "Groceries", 50),
            new Product("P108", "Oil (5L)", 700, "Groceries", 40),
            new Product("P109", "Toy Car", 350, "Toys", 18),
            new Product("P110", "Doll", 450, "Toys", 22)
        };

        // Create a shopping cart
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        ShoppingCart cart = new ShoppingCart("CART01", name);

        int choice;
        do {
            System.out.println("\n--- Online Shopping Menu ---");
            System.out.println("1. View All Products");
            System.out.println("2. View Products by Category");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- All Products ---");
                    for (Product p : storeProducts) {
                        System.out.println(p.productId + " - " + p.productName + " | ₹" + p.price + " | Stock: " + p.stockQuantity + " | Category: " + p.category);
                    }
                    break;

                case 2:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    Product.getProductsByCategory(storeProducts, category);
                    break;

                case 3:
                    System.out.print("Enter Product ID to add: ");
                    String pid = sc.nextLine();
                    Product prod = Product.findProductById(storeProducts, pid);
                    if (prod != null) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        cart.addProduct(prod, qty);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    String rid = sc.nextLine();
                    cart.removeProduct(rid);
                    break;

                case 5:
                    cart.displayCart();
                    break;

                case 6:
                    cart.checkout();
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}

