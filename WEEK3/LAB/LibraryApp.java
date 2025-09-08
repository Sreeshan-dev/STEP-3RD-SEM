package STEP.WEEK3.LAB;
class Book {
    private String bookId, title;
    private boolean available = true;
    private static int totalBooks = 0;

    Book(String t) { title=t; bookId="B"+(++totalBooks); }
    void issueBook() { if(available) available=false; }
    void returnBook() { available=true; }
    void displayBookInfo() { System.out.println(bookId+" "+title+" "+available); }
}

class Member {
    private String name;
    private Book[] books = new Book[5];
    private int count=0;
    Member(String n){ name=n; }
    void borrowBook(Book b){ if(b!=null && b.available) { b.issueBook(); books[count++]=b; } }
    void returnBook(String id){ for(int i=0;i<count;i++){ if(books[i].bookId.equals(id)){ books[i].returnBook(); books[i]=null; } } }
}

public class LibraryApp {
    public static void main(String[] args){
        Book[] books = {new Book("Java"), new Book("Python")};
        Member m = new Member("Alice");
        m.borrowBook(books[0]); m.borrowBook(books[1]);
        for(Book b: books) b.displayBookInfo();
    }
}
