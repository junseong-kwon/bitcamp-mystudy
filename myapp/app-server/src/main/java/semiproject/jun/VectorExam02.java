package semiproject.jun;

import java.util.List;
import java.util.Vector;

public class VectorExam02 {

  public static void main(String[] args) {
    List<Board> list = new Vector<>();
    Thread threadA = new Thread() {
      @Override
      public void run() {
        for (int i = 1; i <= 1000; i++) {
          list.add(new Board("제목" + 1, "내용" + 1, "글쓴이" + 1));
        }
      }
    };

    Thread threadB = new Thread() {
      @Override
      public void run() {
        for (int i = 1; i <= 1000; i++) {
          list.add(new Board("제목" + 1, "내용" + 1, "글쓴이" + 1));
        }
      }
    };

    threadA.start();
    threadB.start();

    try {
      threadA.join();
      threadB.join();
    } catch (Exception e) {
    }

    int size = list.size();
    System.out.println("총 객체 수: " + size);
    System.out.println();
  }
}
