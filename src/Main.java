
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Author berndOestereicher = new Author("Bernd", "Östereich");
        Author axelScheithauer = new Author("Axel", "Scheithauer");
        Illustrator stefanWestphal = new Illustrator("Stefan", "Westphal");
        Address address = new Address("Standard Adress 1");
        Publisher oldenburgVerlag = new Publisher("Oldenburg Verlag", address);

        Book analyseUndDesignUML = new Book.Builder("Analyse und Design mit der UML 2.5")
                .addAuthor(berndOestereicher)
                .setCondition(Book.Condition.NEW)
                .setFormat(Book.Format.HARDCOVER)
                .setSubtitle("Objektorientierte Softwareentwicklung")
                .setEdition(1)
                .setIsbn("978-3-486-72140-9")
                .setPublisher(oldenburgVerlag)
                .setLanguage(Book.Language.DE)
                .addIllustrator(stefanWestphal)
                .setPrice(89.90)
                .setTopic("UML")
                .build();

        Book emptyBook = new Book.Builder("empty book").addAuthor(new Author(" ", " ")).setTopic(" ").setIsbn(" ").build();
        Book a = new Book.Builder("a").setTopic("9").addAuthor(new Author("x","x")).setIsbn("1").build();
        Book b = new Book.Builder("b").setTopic("8").addAuthor(new Author("y","y")).setIsbn("2").build();
        Book c = new Book.Builder("c").setTopic("7").addAuthor(new Author("z","z")).setIsbn("3").build();
        Book x = new Book.Builder("x").setTopic("6").addAuthor(new Author("a","a")).setIsbn("4").build();
        Book y = new Book.Builder("y").setTopic("5").addAuthor(new Author("b","b")).setIsbn("5").build();
        Book z = new Book.Builder("z").setTopic("4").addAuthor(new Author("c","c")).setIsbn("6").build();
        Book zDoppelIsbn = new Book.Builder("zDoppel").setTopic("4").addAuthor(new Author("cDoppel","cDoppel")).setIsbn("6").build();


        System.out.println(axelScheithauer.getBooks() + " - author.getBooks from axel scheithauer");
        analyseUndDesignUML.addAuthor(axelScheithauer);
        System.out.println(axelScheithauer.getBooks() + " - author.getBooks from axel scheithauer, added author to book, automatically added book to author ");


        //bookshelf
        BookShelf bookShelf = new BookShelf();
        System.out.println("Empty Shelf: \n" + bookShelf);
        bookShelf.addBook(emptyBook);
        bookShelf.addBook(emptyBook);
        bookShelf.addBook(analyseUndDesignUML);

        System.out.println("Addes a few books: \n" + bookShelf);
        bookShelf.removeBook(emptyBook);
        bookShelf.removeBook(emptyBook);
        bookShelf.removeBook(emptyBook);
        System.out.println("Removed EmptyBook: \n" + bookShelf);

        //SortedBooks
        SortedBooks sortedBooks = new SortedBooks();
        sortedBooks.addBook(b);
        sortedBooks.addBook(c);
        sortedBooks.addBook(c);
        sortedBooks.addBook(c);
        sortedBooks.addBook(x);
        sortedBooks.addBook(z);
        sortedBooks.addBook(a);
        sortedBooks.addBook(y);
        sortedBooks.addBook(emptyBook);
        sortedBooks.addBook(analyseUndDesignUML);
        sortedBooks.addBook(zDoppelIsbn);

        // Natural Order
        System.out.println("\nSortedBooks - sorted by natural order(title) via TreeSet");
        System.out.println(sortedBooks);



        System.out.println("\naNewOrder - sorted via Collections.sort(book.author.lastname");
        ArrayList<Book> aNewOrder =  new ArrayList<>(sortedBooks.getBooks());
        /*
        so lt. Aufgabe, i guess:

        Collections.sort(aNewOrder, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthors().get(0).getLastName().compareToIgnoreCase(o2.getAuthors().get(0).getLastName());
            }
        });
         */
        aNewOrder.sort((bookA, bookB) -> bookA.getAuthors().get(0).getLastName().compareToIgnoreCase(bookB.getAuthors().get(0).getLastName()));
        System.out.println(aNewOrder);

        System.out.println("\naNewOrder - sorted by title in Main via Method reference");
        aNewOrder.sort(Main::compareByTitle);
        System.out.println(aNewOrder);

        System.out.println("\naNewOrder - sorted by Topic in Book via Method reference");
        aNewOrder.sort(Book::compareByTopic);
        System.out.println(aNewOrder);

        System.out.println("\naNewOrder - sorted by FirstName in Book via Comparator Class:");
        BooksComparator firstNameComparator = new BooksComparator();
        aNewOrder.sort(firstNameComparator);
        System.out.println(aNewOrder);

        //Library - HashMap
        // Erstelle Methoden um neue Bücher einzufügen und zu entfernen (in Library)

        Library library = new Library();

        //add all existing books
        /*Was passiert wenn Du zwei Bücher mit dem selben Key abspeicherst? - erster eintrag wird natürlich überschrieben
        - würde exception einbauen um das zu verhindern, oder (je nach anwendung) zähler in Book und diesen erhöhen bei neurlichem Eintrag
        - Anzahl der Exemplare sowieso sinnvoll für Buchverleih
         */
        for (Book book : aNewOrder) {
            try {
                library.addBook(book);
            } catch (BookAlreadyInCollectionException e){
                 //do nothing this time
            }
        }

        //! Wie kannst Du alle Bücher ausgeben? - toString in Library überschrieben
        System.out.println(library);


        System.out.println("\nremove via key (isbn) book b");
        library.removeBook(b.getIsbn());
        System.out.println(library);

    }

    public static int compareByTitle(Book b1, Book b2){
        return b1.getTitle().compareToIgnoreCase(b2.getTitle());
    }
}
