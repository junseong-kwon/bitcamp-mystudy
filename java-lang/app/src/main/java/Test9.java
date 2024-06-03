// 실습
// - 애플리케이션 아규먼트를 다음과 같이 결과가 나오도록 모두 출력 하라.
//      $ java -classpath ... Test6 aaa bbb ccc ddd
//      'aaa'
//      'bbb'
//      'ccc'
//      'ddd'
// 
//

class Test9 {
    public static void main(String[] args) {
        int kill = 11;
        if (kill <= 2) {
            System.out.println("우육면");
        } else if (kill <= 10) {
            System.out.println("짬뽕");
        } else {
            System.out.println("돈까스");
        }
    }
}
