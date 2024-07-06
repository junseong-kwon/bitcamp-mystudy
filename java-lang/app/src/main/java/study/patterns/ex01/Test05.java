// 0) 패턴 적용 전
// 1) private 생성자 + Factory Method 설계 패턴
// 2) Abstract Factory 설계 패턴
// 3) Abstract Factory 설계 패턴 + 인터페이스

package study.patterns.ex01;

import study.patterns.ex01.step3.Car;
import study.patterns.ex01.step3.CarFactory;
import study.patterns.ex01.step3.K7Factory;
import study.patterns.ex01.step3.SonataFactory;

public class Test05 {
  public static void main(String[] args) {
    SonataFactory sonataFactory = new SonataFactory();
    K7Factory k7Factory = new K7Factory();
    K7Factory k7Factory2 = new K7Factory();
    K7Factory k7Factory3 = new K7Factory();

    System.out.println(k7Factory == k7Factory2);

    printCar(sonataFactory);
    printCar(k7Factory);


  }

  static void printCar(CarFactory carFactory) {
    Car car = carFactory.createCar();// CarFactory 객체 사용 규칙에 따라 메서드 실행
    System.out.println(car);
  }
}
