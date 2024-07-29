package book;

import java.util.Scanner;

public class Main {

  private static Library library = new Library();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("[도서 대출 프로그램]");
      System.out.println("1. 도서 추가");
      System.out.println("2. 도서 목록 조회");
      System.out.println("3. 도서 대출");
      System.out.println("4. 도서 반납");
      System.out.println("5. 종료");
      System.out.print("옵션을 선택하세요: ");

      int choice = scanner.nextInt();
      scanner.nextLine();  // 개행 문자 처리

      switch (choice) {
        case 1:
          System.out.print("도서 제목을 입력하세요: ");
          String title = scanner.nextLine();
          System.out.print("도서 저자를 입력하세요: ");
          String author = scanner.nextLine();
          library.addBook(title, author);
          break;
        case 2:
          listBooks();
          break;
        case 3:
          System.out.print("대출할 도서 제목을 입력하세요: ");
          title = scanner.nextLine();
          if (library.loanBook(title)) {
            System.out.println("도서가 성공적으로 대출되었습니다.");
          } else {
            System.out.println("도서를 대출할 수 없습니다.");
          }
          break;
        case 4:
          System.out.print("반납할 도서 제목을 입력하세요: ");
          title = scanner.nextLine();
          if (library.returnBook(title)) {
            System.out.println("도서가 성공적으로 반납되었습니다.");
          } else {
            System.out.println("도서를 반납할 수 없습니다.");
          }
          break;
        case 5:
          System.out.println("종료합니다.");
          scanner.close();
          return;
        default:
          System.out.println("잘못된 선택입니다.");
      }
    }
  }

  private static void listBooks() {
    for (Book book : library.getBooks()) {
      System.out.println(book);
    }
  }
}
