package javamid2.thread;

public class Board {

  private String subject;
  private String content;
  private String writer;

  public Board(String subject, String content, String writer) {
    this.subject = subject;
    this.content = content;
    this.writer = writer;
  }

  public String getSubject() {
    return subject;
  }

}