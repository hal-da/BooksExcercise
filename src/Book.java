import java.util.ArrayList;
import java.util.Objects;

public class Book implements Comparable<Book> {



    public static class Builder {
        private String title;
        private String subTitle;
        private String isbn;
        private String topic;
        private double price;
        private int edition;

        private Language language;
        private Condition condition;
        private Format format;

        private Publisher publisher;
        private ArrayList<Author> authors = new ArrayList<>();
        private ArrayList<Illustrator> illustrators = new ArrayList<>();

        public Builder(String title){
            this.title = title;
        }
        public Builder setSubtitle(String subTitle){
            this.subTitle = subTitle;
            return this;
        }
        public Builder setIsbn(String isbn){
            this.isbn = isbn;
            return this;
        }
        public Builder setPrice(double price){
            this.price = price;
            return this;
        }
        public Builder setLanguage(Language language){
            this.language = language;
            return this;
        }
        public Builder setCondition(Condition condition){
            this.condition = condition;
            return this;
        }
        public Builder setFormat(Format format){
            this.format = format;
            return this;
        }
        public Builder setPublisher(Publisher publisher){
            this.publisher = publisher;
            return this;
        }

        public Builder setEdition(int edition){
            this.edition = edition;
            return this;
        }

        public Builder addAuthor(Author author){
            this.authors.add(author);
            return this;
        }
        public Builder addIllustrator(Illustrator illustrator){
            this.illustrators.add(illustrator);
            return this;
        }

        public Builder setTopic(String topic){
            this.topic = topic;
            return this;
        }

        public Book build(){
            Book book = new Book();
            book.title = this.title;
            book.subTitle = subTitle;
            book.isbn = isbn;
            book.topic = topic;
            book.price = price;
            book.edition = edition;

            book.language = language;
            book.condition = condition;
            book.format = format;

            book.publisher = publisher;
            book.authors = authors;
            book.illustrators = illustrators;

            return book;
        }

    }


    enum Format {
        HARDCOVER, SOFTCOVER
    }
    enum Language {
        EN, DE, FR
    }

    enum Condition {
        NEW, USED, TRASH
    }

    private String title;
    private String subTitle;
    private String isbn;
    private String topic;
    private double price;
    private int edition;

    private Language language;
    private Condition condition;
    private Format format;

    private Publisher publisher;
    private ArrayList<Author> authors = new ArrayList<>();
    private ArrayList<Illustrator> illustrators = new ArrayList<>();

    private Book(){    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setIllustrators(ArrayList<Illustrator> illustrators) {
        this.illustrators = illustrators;
    }

    public void addAuthor(Author author){
        author.addBook(this);
        if(!authors.contains(author)) authors.add(author);
    }

    public void addIllustrators(Illustrator illustrator) {
        illustrator.addBook(this);
        if(!illustrators.contains(illustrator))illustrators.add(illustrator);
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<Illustrator> getIllustrators() {
        return illustrators;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        publisher.addBook(this);
        this.publisher = publisher;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int compareByTopic(Book book){
        return topic.compareToIgnoreCase(book.topic);
    }

    @Override
    public String toString() {
        return "\n" + "Book: " + title + " from " + authors + " topic: " + topic ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && edition == book.edition && Objects.equals(title, book.title) && Objects.equals(subTitle, book.subTitle) && Objects.equals(isbn, book.isbn) && language == book.language && condition == book.condition && format == book.format && Objects.equals(publisher, book.publisher) && Objects.equals(authors, book.authors) && Objects.equals(illustrators, book.illustrators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, subTitle, isbn, price, edition, language, condition, format, publisher, authors, illustrators);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareToIgnoreCase(o.getTitle());
    }
}
