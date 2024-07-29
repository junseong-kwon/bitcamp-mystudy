package semiproject;

public class Calculator2 {

  private static int a = 10;
  private static int b = 5;
  private static int result = 0;


  public static void main(String[] args) {

    System.out.println("두 수의 연산결과는 다음과 같습니다.\n");
    getResult();

  }


  public static void plus(int a, int b) {
    result = a + b;
  }

  public static void minus(int a, int b) {
    result = a - b;
  }

  public static void multiple(int a, int b) {
    result = a * b;
  }

  public static void divide(int a, int b) {
    result = a / b;
  }

  public static void getResult() {
    plus(a, b);
    System.out.printf("두수를 더하기한 결과는 : %d 입니다\n", result);

    minus(a, b);
    System.out.printf("두수를 마이너스한 결과는 : %d 입니다\n", result);

    multiple(a, b);
    System.out.printf("두수를 곱하기한 결과는 : %d 입니다\n", result);

    divide(a, b);
    System.out.printf("두수를 나누기한 결과는 : %d 입니다\n", result);
  }
}
