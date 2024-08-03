package javamid2.ch09;

public class A {

  B field = new B();

  A() {
    B b = new B();
  }

  void method() {
    B b = new B();
  }

  class B {

  }

}
