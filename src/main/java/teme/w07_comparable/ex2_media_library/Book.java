package teme.w07_comparable.ex2_media_library;

import java.util.Objects;

class Book extends MediaEntity {

    private String author;
    private String publisher;

    Book(String title, String author, String publisher, int noOfDownloads) {
        super(MediaType.BOOK, title, noOfDownloads);
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getPublisher(), book.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAuthor(), getPublisher());
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                "} " + super.toString();
    }


}
