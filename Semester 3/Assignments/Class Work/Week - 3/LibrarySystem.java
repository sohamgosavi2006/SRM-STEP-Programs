// Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int quantity;

    public Book(String title, String author, String isbn, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getTotalValue() { return price * quantity; }

    public void displayBook() {
        System.out.println("Title: " + title + " | Author: " + author +
                " | ISBN: " + isbn + " | Price: " + price + " | Qty: " + quantity);
    }
}

// Library class (contains multiple Book objects → object interaction)
class Library {
    private String libraryName;
    private Book[] books;
    private int totalBooks;

    public Library(String libraryName, int capacity) {
        this.libraryName = libraryName;
        this.books = new Book[capacity];
        this.totalBooks = 0;
    }

    public void addBook(Book book) {
        if (totalBooks < books.length) {
            books[totalBooks++] = book;
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Library full! Cannot add more books.");
        }
    }

    public void searchByTitle(String title) {
        for (Book b : books) {
            if (b != null && b.getTitle().equalsIgnoreCase(title)) {
                b.displayBook();
                return;
            }
        }
        System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book b : books) {
            if (b != null && b.getAuthor().equalsIgnoreCase(author)) {
                b.displayBook();
                found = true;
            }
        }
        if (!found) System.out.println("No books found by " + author);
    }

    public void displayInventory() {
        System.out.println("=== " + libraryName + " Inventory ===");
        for (int i = 0; i < totalBooks; i++) {
            books[i].displayBook();
        }
    }

    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < totalBooks; i++) {
            total += books[i].getTotalValue();
        }
        return total;
    }
}

// Demo
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library("City Library", 10);

        // Add books
        library.addBook(new Book("Java Basics", "James", "ISBN001", 500, 5));
        library.addBook(new Book("Python 101", "Guido", "ISBN002", 400, 3));
        library.addBook(new Book("C++ Guide", "Bjarne", "ISBN003", 600, 2));

        // Search
        library.searchByTitle("Python 101");
        library.searchByAuthor("James");

        // Display
        library.displayInventory();

        // Total value
        System.out.println("Total value of books: " + library.calculateTotalValue());
    }
}
