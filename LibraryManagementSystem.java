import java.util.HashMap;
import java.util.Scanner;

class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Library {
    private HashMap<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(String id) {
        if (books.containsKey(id)) {
            books.remove(id);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void issueBook(String id) {
        Book book = books.get(id);
        if (book != null) {
            if (!book.isIssued()) {
                book.issueBook();
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book is already issued!");
            }
        } else {
            System.out.println("Book not found!");
        }
    }

    public void returnBook(String id) {
        Book book = books.get(id);
        if (book != null) {
            if (book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Book was not issued!");
            }
        } else {
            System.out.println("Book not found!");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library!");
        } else {
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    id = scanner.nextLine();
                    library.removeBook(id);
                    break;
                case 3:
                    System.out.print("Enter book ID to issue: ");
                    id = scanner.nextLine();
                    library.issueBook(id);
                    break;
                case 4:
                    System.out.print("Enter book ID to return: ");
                    id = scanner.nextLine();
                    library.returnBook(id);
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


