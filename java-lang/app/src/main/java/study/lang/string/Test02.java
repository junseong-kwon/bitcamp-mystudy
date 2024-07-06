package study.lang.string;

public class Test02 {
  public static void main(String[] args) {
    String s = "aaa";
    String s2 = "aaa";
    System.out.println(s == s2); // 레퍼런스에 들어 있는 값을 비교한다.

  }

}
// String literal을 넣게 되면 인스턴스 주소를 검색하고 없으면 만듦
// 위와 같이 같은 리터럴을 보게 된다면 그 주소에 있는 인스턴스를 리턴해서 같은 값이 나온다