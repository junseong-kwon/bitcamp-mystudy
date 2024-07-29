package semiproject;

import java.util.Scanner;

public class Calculator_Final {

  private static int a;
  private static int b;
  private static int result = 0;


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    getResult(in);
  }


  public static void plus(int a, int b) {
    result = a + b;
    System.out.printf("두수를 더하기한 결과는 : %d 입니다\n", result);
  }

  public static void minus(int a, int b) {
    result = a - b;
    System.out.printf("두수를 마이너스한 결과는 : %d 입니다\n", result);
  }

  public static void multiple(int a, int b) {
    result = a * b;
    System.out.printf("두수를 곱하기한 결과는 : %d 입니다\n", result);
  }

  public static void divide(int a, int b) {
    result = a / b;
    System.out.printf("두수를 나누기한 결과는 : %d 입니다\n", result);
  }

  public static void getResult(Scanner in) {
    System.out.println("연산 할 첫번째 숫자를 입력해주세요");
    a = in.nextInt();
    System.out.println("연산 할 두번째 숫자를 입력해주세요");
    b = in.nextInt();

    System.out.println("두 수의 연산결과는 다음과 같습니다.\n");
    plus(a, b);
    minus(a, b);
    multiple(a, b);
    divide(a, b);
    clear();
  }

  public static void clear() {
    System.out.println("\n연산이 완료되었습니다\n'result' 변수를 초기화 합니다.");
    result = 0;
  }
}
