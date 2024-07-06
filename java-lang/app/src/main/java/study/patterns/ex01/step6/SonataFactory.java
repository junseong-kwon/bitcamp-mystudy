package study.patterns.ex01.step6;
//0) 패턴 적용 전
//1) private 생성자 + Factory Method 설계 패턴
//2) Abstract Factory 설계 패턴
//3) Abstract Factory 설계 패턴 + 인터페이스
//4)
public class SonataFactory implements CarFactory{


  private SonataFactory() {}

  // 생성한 객체를 저장할 스태틱 필드를 준비
  // -> 오직 한개의 한 개의 객체만 저장할 의도
  private static SonataFactory instance;

  // -> 객체를 만들어 리턴해주는 메서드 준비
  public static SonataFactory getInstance() {
    if (instance == null) {
      instance = new SonataFactory();
    }
    return instance;
  }
  @Override
  public Sedan createCar() {
    Sedan s = new Sedan() ;
    s.maker = "현대자동차";
    s.model = "소나타";
    s.cc = 1998;
    s.auto = true;
    s.sunroof = true;
    return s;

  }
}