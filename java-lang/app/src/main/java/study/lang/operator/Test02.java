package study.lang.operator;

// 실습
// - 산술 연산자를 사용하여 연산을 수행한 후 결과를 확인하라.
//
// 학습 내용
// -byte, short, char를 산술연산할 때 int로 변환 후 수행한다.
// - int와 int의 연산 결과는 int
// - 다른 타입으로 변환하는 것을 형변환 이라 한다.

public class Test02 {
  public static void main(String[] args) {
    byte b1 = 100;
    byte b2 = 20;

    int b3 = (b1 + b2);

    // 다음 코드를 해보고, 컴파일 오류가 나는 이유를 설명하고
    // 컴파일 오류가 나오지 않도록 해결하
    // byte는 기본 수치가 작아 내부 연산자인 int로 변환되어 계산하기 떄문에

    int r = b1 + b2;

    char c = 20;
    short s = 30;

    // short보다 int가 더 크기 떄문 작아서 들어가지 않는다.

    long i1 = 22_0000_000L;
    long i2 = 22_0000_0000L;
    long i3 = i1 + i2;
    System.out.println(i3); // -94967296

    long r3 = i1 + i2;
    System.out.println(r3); //


  }
}
