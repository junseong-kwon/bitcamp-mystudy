package semiproject.jun;

import java.util.Scanner;
public static String[] menus = {"더하기", "빼기", "곱하기", "나누기", "숫자 확인", "종료"};
public class Calculator {





  static Scanner scanner = new Scanner(System.in);

  private static int a = 10;
  private static int b = 5;
  private static int result = 0;

  public static void main(String[] args) {
    printMenu();

    String command;

    while (true) {
      try {
        command = promft();

        if (command.equals("menu")) {
          printMenu();
        } else {
          int menuNo = Integer.parseInt(command);
          String menuTitle = getMenuTitle(menuNo);

          if (menuTitle == null) {
            System.out.println("유효한 메뉴 번호가 아닙니다.");
          } else if (menuTitle.equals("종료")) {
            break;
          } else {
            System.out.println(menuTitle);
            switch (menuNo) {
              case 1:
                plus();
                break;
              case 2:
                break;
              case 3:
                break;
              case 4:
                break;
              case 5:
                break;
              case 6:
                break;

            }


          }
        }
      } catch (Exception e) {
        System.out.println("제대로 입력하세요");
      }
    }
  }

  static void printMenu() {
    for (int i = 0; i < menus.length; i++) {
      if (menus[i].equals("종료")) {
        System.out.printf("%d. %s\n", (i + 1), menus[i]);
      } else {
        System.out.printf("%d. %s\n", (i + 1), menus[i]);
      }
    }
  }

  static String promft() {
    System.out.print("입력해봐: ");
    return scanner.nextLine();
  }

  static boolean isValidateMenu(int menuNo) {
    return menuNo >= 1 && menuNo <= menus.length;
  }

  static String getMenuTitle(int menuNo) {
    return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;

  }

  public static int plus() {
  f
  }

  public static void getResult() {
    System.out.println("두 수의 연산결과는 다음과 같습니다.\n");
    plus();

  }

}
