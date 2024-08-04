package semiproject.cal;

import java.util.Scanner;

interface Execute {

  void execute();
}

public class CalculatorMain2 {


  public static String[] menus = {"더하기", "빼기", "곱하기", "나누기", "숫자 확인"};

  static Scanner scanner = new Scanner(System.in);
  private static int num1;
  private static int num2;
  private static int result;

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
              Execute plus = () -> {
                result = num1 + num2;
                System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
              };
              plus.execute();
              break;
            case 2:
              Execute minus = new Execute() {
                @Override
                public void execute() {
                  result = num1 - num2;
                  System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
                }
              };
              minus.execute();
              break;
            case 3:
              Execute multiple = () -> {
                result = num1 * num2;
                System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
              };
              multiple.execute();
              break;
            case 4:
              Execute divine = () -> {
                double result = (double) num1 / (double) num2;
                System.out.print("두 수의 연산결과는 다음과 같습니다.\n" + result + "\n");
              };
              divine.execute();
              break;
            case 5:
              Execute search = () -> {
                System.out.println(
                    "첫번째 숫자 : " + num1 + ", 두번째 숫자 : " + num2);
              };
              search.execute();
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

  static void menu() {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i]);
    }
    System.out.println("0. 종료");
  }
}

