package study.lang.literal;

//실습
//리터럴을 사용하여 다음과 같이 출력하라
// -출력
// 100
//3.14
//가
//가나다
//true
// 유형별 자료(Data type)의 표현법(Literal)을 설명하라.
// 정수 int
// 정수 100
// 정수 100
// 정수 100
// 정수 100
// 10진수 LITERAL 100을 지시에 따라 다양한 진수 리터럴로 표현하라
public class Test02 {
    public static void main(String[] args) {
        System.out.println(100); // 10진수
        System.out.println(0B0110100); // 2진수
        System.out.println(0144); // 8진수
        System.out.println(0X64); // 16진수
    }

}
