//import java.util.*;

class Book {
    String bookId, title, author, isbn, category, issueDate, dueDate;
    boolean isIssued;

    static int totalBooks = 0;

    Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
        totalBooks++;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " by " + author + " (" + category + ")";
    }
}

class Member {
    String memberId, memberName, memberType, membershipDate;
    Book[] booksIssued;
    double totalFines;

    static int totalMembers = 0;
    static String libraryName = "City Central Library";
    static double finePerDay = 2.0;
    static int maxBooksAllowed = 3;

    Member(String memberId, String memberName, String memberType, String membershipDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipDate = membershipDate;
        this.booksIssued = new Book[maxBooksAllowed];
        this.totalFines = 0.0;
        totalMembers++;
    }

    void issueBook(Book book, String issueDate, String dueDate) {
        for (int i = 0; i < booksIssued.length; i++) {
            if (booksIssued[i] == null) {
                if (!book.isIssued) {
                    booksIssued[i] = book;
                    book.isIssued = true;
                    book.issueDate = issueDate;
                    book.dueDate = dueDate;
                    System.out.println(memberName + " issued " + book.title);
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book limit reached!");
    }

    void returnBook(Book book, int overdueDays) {
        for (int i = 0; i < booksIssued.length; i++) {
            if (booksIssued[i] != null && booksIssued[i].bookId.equals(book.bookId)) {
                booksIssued[i] = null;
                book.isIssued = false;
                if (overdueDays > 0) {
                    double fine = overdueDays * finePerDay;
                    totalFines += fine;
                    System.out.println("Fine imposed: " + fine);
                }
                System.out.println(memberName + " returned " + book.title);
                return;
            }
        }
        System.out.println("Book not found in member account!");
    }

    void calculateFine() {
        System.out.println(memberName + " has total fine: ₹" + totalFines);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("B001", "Java Basics", "James Gosling", "1111", "Programming");
        Book b2 = new Book("B002", "AI Fundamentals", "Andrew Ng", "2222", "AI");
        Member m1 = new Member("M001", "Alice", "Student", "01-01-2024");

        m1.issueBook(b1, "01-09-2025", "10-09-2025");
        m1.issueBook(b2, "01-09-2025", "12-09-2025");

        m1.returnBook(b1, 5);  // 5 days overdue
        m1.calculateFine();
    }
}
