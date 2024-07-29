package book;

import java.util.ArrayList;
import java.util.List;

public class Library {

  private List<Book> books;

  public Library() {
    books = new ArrayList<>();
  }

  public void addBook(String title, String author) {
    books.add(new Book(title, author));
  }

  public List<Book> getBooks() {
    return books;
  }

  public Book findBookByTitle(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }
    return null;
  }

  public boolean loanBook(String title) {
    Book book = findBookByTitle(title);
    if (book != null && !book.isLoaned()) {
      book.loanBook();
      return true;
    }
    return false;
  }

  public boolean returnBook(String title) {
    Book book = findBookByTitle(title);
    if (book != null && book.isLoaned()) {
      book.returnBook();
      return true;
    }
    return false;
  }
}
