package semiproject.jun;

import java.util.Scanner;

interface Execute {

}

public class Calculator {


  public static String[] menus = {"더하기", "빼기", "곱하기", "나누기", "숫자 확인", "종료"};

  static Scanner scanner = new Scanner(System.in);
  static int num1;
  static int num2;
  static int result;

  public static void main(String[] args) {
    System.out.println("숫자를 입력하세요");

    num1 = scanner.nextInt();
    num2 = scanner.nextInt();

    menu();
    System.out.println("메뉴 선택해");
    while (true) {
      try {
        String choice = scanner.nextLine();
        if (choice.equals("menu")) {
          menu();
          System.out.println("메뉴 선택해");
        } else {
          int goodchoice = Integer.parseInt(choice);
          switch (goodchoice) {
            case 1:
              chaos.plus();
              break;
            case 2:
              minus();
              break;
            case 3:
              mutiple();
              break;
            case 4:
              divine();
              break;
            case 5:
              search();
              break;
            case 6:
              return;
            default:
              System.out.println("제대로 된 것을 입력해라");
          }
        }
      } catch (Exception e) {
        System.out.println("오류 발생!");

      }
    }
  }


  static void minus() {
    result = num1 - num2;
    System.out.println(result);
  }

  static void mutiple() {
    result = num1 * num2;
    System.out.println(result);
  }

  static void divine() {
    result = num1 / num2;
    System.out.println(result);
  }

  static void menu() {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i]);

    }
  }


  static void search() {
    System.out.println("숫자1: " + num1 + ", 숫자2 : " + num2);
  }

  static class chaos {

    static void plus() {
      result = num1 + num2;
      System.out.println(result);
    }
  }
}
