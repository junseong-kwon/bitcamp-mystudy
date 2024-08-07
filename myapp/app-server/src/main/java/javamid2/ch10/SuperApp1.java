package javamid2.ch10;

import java.util.Scanner;

public class SuperApp1 {

  static Scanner scanner = new Scanner(System.in);
  static String[] menu = {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"};

  public static void main(String[] args) {

    for (int i = 0; i < menu.length; i++) {
      System.out.printf("%d. %s\n", (i + 1), menu[i]);
    }
    String command;
    while (true) {
      System.out.print("메뉴를 선택하세요: ");
      command = scanner.nextLine();
      if (command.equals("menu")) {
        for (int i = 0; i < menu.length; i++) {
          System.out.printf("%d. %s\n", (i + 1), menu[i]);
        }
      } else {
        int menuNo = Integer.parseInt(command);
        if (menuNo >= 1 && menuNo <= menu.length) {
          if (menu[menuNo - 1].equals("종료")) {
            break;
          }
          System.out.println(menu[menuNo - 1]);
        } else {
          System.out.println("잘못된 번호입니다.");
        }
      }
    }
  }
}





