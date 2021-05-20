import java.util.ArrayList;
import java.util.Objects;

public class BookShelf {
    private ArrayList<Book> books = new ArrayList<>();

    public BookShelf() {
    }

    public void addBook(Book book){
        if(!books.contains(book)) books.add(book);
    }

    public boolean removeBook(Book book){
        return books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return books + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookShelf bookShelf = (BookShelf) o;
        return Objects.equals(books, bookShelf.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
