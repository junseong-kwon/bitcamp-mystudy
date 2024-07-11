// 0) 패턴 적용 전
// 1) private 생성자 + Factory Method 설계 패턴
// 2
package study.patterns.ex01;

import study.patterns.ex01.step1.Sedan;

public class Test01 {
  public static void main(String[] args) {
    Sedan s1 = new Sedan();
    s1.maker = "현대자동차";
    s1.model = "소나타";
    s1.cc = 1998;
    s1.auto = true;
    s1.sunroof = true;

    Sedan s2 = new Sedan();
    s2.maker = "기아자동차";
    s2.model = "k7";
    s2.cc = 2500;
    s2.auto = true;
    s2.sunroof = true;
  }
}