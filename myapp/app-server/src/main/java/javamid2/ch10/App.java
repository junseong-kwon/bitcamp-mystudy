package javamid2.ch10;

import java.util.Scanner;

public class App {

  static Scanner scanner = new Scanner(System.in);

  static String[] mainMenus = new String[]{"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};
  static String[][] subMenus = {
      {"등록a", "목록", "조회", "변경", "삭제"},
      {"등록b", "목록", "조회", "변경", "삭제"},
      {"등록c", "목록", "조회", "변경", "삭제"},
      {"등록d", "목록", "조회", "변경", "삭제"},
  };

  public static void main(String[] args) {

    String command;

    System.out.printf("%5d\n", 123);
    System.out.printf("%7.1f\n", 123.45);
    System.out.printf("%10s\n", "Hi");

  }

  public static void menu() {
    for (int i = 0; i < mainMenus.length; i++) {
      System.out.println(mainMenus[i]);
      for (int k = 0; k < subMenus.length; k++) {
        System.out.println(subMenus[i][k]);

      }
    }
  }
}

