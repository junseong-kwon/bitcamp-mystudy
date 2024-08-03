package semiproject.cal;

import java.util.Scanner;

interface Execute {

  void execute();

}

public class CalculatorMain {


  public static String[] menus = {"더하기", "빼기", "곱하기", "나누기", "숫자 확인"};

  static Scanner scanner = new Scanner(System.in);
  static int num1;
  static int num2;
  static int result;

  public static void main(String[] args) {

    System.out.print("첫번째 숫자를 입력하세요: ");
    num1 = scanner.nextInt();
    System.out.print("두번쨰 숫자를 입력하세요: ");
    num2 = scanner.nextInt();
    scanner.nextLine();

    menu();
    System.out.print("메뉴 선택해: ");
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
              plus(num1, num2);
              break;
            case 2:
              minus(num1, num2);
              break;
            case 3:
              mutiple(num1, num2);
              break;
            case 4:
              divine(num1, num2);
              break;
            case 5:
              search();
              break;
            case 0:
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

  static void plus(int num1, int num2) {
    result = num1 + num2;
    System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
  }

  static void minus(int num1, int num2) {
    result = num1 - num2;
    System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
  }

  static void mutiple(int num1, int num2) {
    result = num1 * num2;
    System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
  }

  static void divine(double num1, double num2) {
    double result = (double) num1 / (double) num2;
    System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
  }

  static void menu() {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i]);
    }
    System.out.println("0. 종료");
  }

  static void search() {
    System.out.println("숫자1: " + num1 + ", 숫자2 : " + num2);
  }
}

