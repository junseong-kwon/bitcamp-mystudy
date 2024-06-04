package study.lang.variavle;

// 실습
// primitive type의 변수를 선언하라.
// - 각 변수에 최소 값, 최대값을 할당하라.
// -각 변수에 최소값, 최대값 범위를 벗어나는 값을 넣은 후 오류를 확인하라.
// -예)
// byte b1 = -128
// byte b2 = 127



public class Test01 {
  public static void main(String[] args) throws Exception {
    System.out.println(Byte.MIN_VALUE);
    System.out.println(Byte.MAX_VALUE);

    System.out.println(Short.MIN_VALUE);
    System.out.println(Short.MAX_VALUE);

    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);

    System.out.println(Long.MIN_VALUE);
    System.out.println(Long.MAX_VALUE);

    System.out.println(Float.MIN_VALUE);
    System.out.println(Float.MAX_VALUE);

    System.out.println(Double.MIN_VALUE);
    System.out.println(Double.MAX_VALUE);



  }

}
