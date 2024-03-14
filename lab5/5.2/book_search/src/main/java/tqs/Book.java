package tqs;

public class Book {

    private String title;
    private String author;

    // standard constructors, getters & setters ...
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;
        return book.getTitle().equals(this.title) && book.getAuthor().equals(this.author);
    }
}