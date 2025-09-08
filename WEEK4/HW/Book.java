package STEP.WEEK4.HW;
class Book {
    String title,author,isbn;
    boolean isAvailable;
    Book() {}
    Book(String t,String a) { title=t; author=a; }
    Book(String t,String a,String i,boolean av) { title=t; author=a; isbn=i; isAvailable=av; }
    void borrowBook() { isAvailable=false; }
    void returnBook() { isAvailable=true; }
    void displayBookInfo() { System.out.println(title+" "+author+" "+isbn+" "+isAvailable); }
    public static void main(String[] args) {
        Book b=new Book("1984","Orwell","123",true); b.displayBookInfo(); b.borrowBook(); b.displayBookInfo();
    }
}
