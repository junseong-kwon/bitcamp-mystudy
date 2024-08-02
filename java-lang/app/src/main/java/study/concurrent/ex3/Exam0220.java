// Runnable 인터페이스 구현 + Thread - 익명 클래스로 구현하기
package study.concurrent.ex3;

public class Exam0220 {

  public static void main(String[] args) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.println("===> " + i);
        }
      }
    }).start();
//스레드를 생성해서 스타트할건데 런을 가지고 있는 러너블 구현체를 넘겨줄거
    for (int i = 0; i < 1000; i++) {
      System.out.println(">>>> " + i);
    }

  }

}
