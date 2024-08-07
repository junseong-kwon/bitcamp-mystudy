package javamid2.ch10;

import java.util.Scanner;

public class SuperApp2 {

  static Scanner scanner = new Scanner(System.in);
  static String[] mainMenu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};

  public static void main(String[] args) {

    for (int i = 0; i < mainMenu.length; i++) {
      System.out.printf("%d. %s\n", (i + 1), mainMenu[i]);
    }
    System.out.print("메뉴를 선택하세요: ");
    String command;
    while (true) {
      try {
        command = scanner.nextLine();

        if (command.equals("menu")) {
          for (int i = 0; i < mainMenu.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), mainMenu[i]);
          }
        } else {
          int menuNo = Integer.parseInt(command);
          if (menuNo >= 1 && menuNo <= mainMenu.length) {
            if (mainMenu[menuNo - 1].equals("종료")) {
              break;
            }
            System.out.printf("%d. %s\n", (1 + 1), mainMenu[menuNo - 1]);
          } else {
            System.out.println("숫자로 메뉴 번호를 입력하세요.");
          }
        }
      } catch (Exception e) {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }
}
