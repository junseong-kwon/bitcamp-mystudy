package book;

public class Book {

  private String title;
  private String author;
  private boolean isLoaned;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    this.isLoaned = false;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public boolean isLoaned() {
    return isLoaned;
  }

  public void loanBook() {
    isLoaned = true;
  }

  public void returnBook() {
    isLoaned = false;
  }

  @Override
  public String toString() {
    return "제목: " + title + ", 저자: " + author + ", 대출 여부: " + (isLoaned ? "대출중" : "대출 가능");
  }
}
