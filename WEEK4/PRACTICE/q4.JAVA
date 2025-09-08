public class Book {
    String title;
    String author;
    double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println(title + " by " + author + " - $" + price);
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell", 299.99);
        b1.display();
        b2.display();
    }
}
