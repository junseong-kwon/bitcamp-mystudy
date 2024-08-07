// 인스턴스 읽기 - 배열 활용
package study.io.ex12.b;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test02_2 {

  public static void main(String[] args) throws Exception {

    // score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라.
    // => java.io.BufferedInputStream 클래스를 사용하라.
    // => java.io.DataInputStream 클래스를 사용하라.
    //
    FileInputStream in0 = new FileInputStream("temp/score.data");
    BufferedInputStream in1 = new BufferedInputStream(in0);
    DataInputStream in = new DataInputStream(in1);

    int len = in.readInt();
    Score[] students = new Score[len];

    for (int i = 0; i < students.length; i++) {
      Score s = new Score();
      s.setName(in.readUTF());
      s.setKor(in.readInt());
      s.setEng(in.readInt());
      s.setMath(in.readInt());
      students[i] = s;
    }

    in.close();

    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // =>   홍길동, 100, 100, 100, 300, 100 
    // 

    for (Score s : students) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
          s.getName(), s.getKor(), s.getEng(), s.getMath(),
          s.getSum(), s.getAver());
    }
  }

}
