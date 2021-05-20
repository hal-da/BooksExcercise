import java.util.Comparator;

public class BooksComparator implements Comparator<Book> {

    @Override
        public int compare(Book o1, Book o2) {
        return o1.getAuthors().get(0).getFirstName().compareToIgnoreCase(o2.getAuthors().get(0).getFirstName());
    }

}
