import java.util.*;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }
}

class Patron {
    private String name;

    public Patron(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Patron [name=" + name + "]";
    }
}

class Library {
    private Map<Book, Patron> libraryMap;

    public Library() {
        libraryMap = new HashMap<>();
    }

    public void addBook(Book book, Patron patron) {
        libraryMap.put(book, patron);
        System.out.println("Book added to the library: " + book);
    }

    public void removeBook(Book book) {
        if (libraryMap.containsKey(book)) {
            libraryMap.remove(book);
            System.out.println("Book removed from the library: " + book);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void updateBook(Book oldBook, Book newBook) {
        if (libraryMap.containsKey(oldBook)) {
            Patron patron = libraryMap.get(oldBook);
            libraryMap.remove(oldBook);
            libraryMap.put(newBook, patron);
            System.out.println("Book updated: " + oldBook + " -> " + newBook);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void updatePatron(Book book, Patron newPatron) {
        if (libraryMap.containsKey(book)) {
            libraryMap.put(book, newPatron);
            System.out.println("Patron updated for book: " + book);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void displayLibrary() {
        System.out.println("\nLibrary details : ");
        if (libraryMap.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (Map.Entry<Book, Patron> entry : libraryMap.entrySet()) {
                Book book = entry.getKey();
                Patron patron = entry.getValue();
                System.out.println("Book: " + book + ", Patron: " + patron);
            }
        }
        System.out.println();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();

        Book book1 = new Book("Book 1", "Author 1");
        Book book2 = new Book("Book 2", "Author 2");
        Book book3 = new Book("Book 3", "Author 3");

        Patron patron1 = new Patron("Patron 1");
        Patron patron2 = new Patron("Patron 2");

        lib.addBook(book1, patron1);
        lib.addBook(book2, patron2);
        lib.displayLibrary();

        lib.removeBook(book1);
        lib.updateBook(book2, new Book("Updated Book", "New Author"));
        lib.updatePatron(book3, patron1);//book Not present in library
        lib.displayLibrary();

    }
}
