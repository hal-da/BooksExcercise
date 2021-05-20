import java.util.Objects;
import java.util.TreeSet;

public class SortedBooks {
    //Book needs to implement Comparable<Book> for TreeSet
    TreeSet<Book> books = new TreeSet<>();

    public SortedBooks() {
    }

    public void addBook(Book book){
        if(!books.contains(book)) books.add(book);
        else System.out.println("Book already in collection");
    }

    public TreeSet<Book> getBooks() {
        return books;
    }

    public void setBooks(TreeSet<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "" + books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortedBooks that = (SortedBooks) o;
        return Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
