import java.util.HashMap;
import java.util.Map;

public class BookManager {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(String id, String title, String author, String genre, String status) {
        if (books.containsKey(id)) {
            System.out.println("Book ID must be unique!");
            return;
        }
        books.put(id, new Book(id, title, author, genre, status));
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    public void searchBook(String query) {
        books.values().stream()
            .filter(b -> b.getId().equalsIgnoreCase(query) || b.getTitle().equalsIgnoreCase(query))
            .findFirst()
            .ifPresentOrElse(System.out::println, () -> System.out.println("Book not found!"));
    }

    public void updateBook(String id, String newTitle, String newAuthor, String newStatus) {
        Book book = books.get(id);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!newTitle.isEmpty()) book.setTitle(newTitle);
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
        if (!newStatus.isEmpty()) book.setStatus(newStatus);
        System.out.println("Book updated successfully!");
    }

    public void deleteBook(String id) {
        if (books.remove(id) != null)
            System.out.println("Book deleted successfully!");
        else
            System.out.println("Book not found!");
    }
}
