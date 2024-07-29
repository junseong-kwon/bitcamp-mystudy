//package semiproject;
//
//public class sense {
//  Primitive type 변수와 static 변수를 각각 선언하고 초기화 하기
//		- 연산은 다른 메서드에서 진행, 결과값을 메인메서드에서 사용하기
//		- 메서드에서 또다른 메서드 호출하기 / 또다른 메서드 호출시 파라미터 넘기기 / 호출된 메서드에서 인자값(argument)을 받아 처리하는 Logic 구현하기
//
//
//      ※ Logic 흐름 및 Code 해석 ※
//      1) static 변수를 선언하고 초기화 한다
//      (code)
//  private static int result = 0; // 결과값을 받을 int형 result를 선언하고, 0으로 초기화
//
//
//      2) main() 메서드 실행 후 연산처리 메서드(plus()/minus()/multiple()/divide() 메서드)를 호출하고, main() 메서드에서 결과값을 이용하여 문구출력
//      (code)
//  // main() 메서드에서만 사용할 지역변수를 선언하고 초기화
//  int a = 10;
//  int b = 5;
//
//		   System.out.println("두 수의 연산결과는 다음과 같습니다.\n"); // Console창에 "두 수의 연산결과는 다음과 같습니다" 문구를 처음 출력
//  // * 참고 사항 * : \n 은 줄을 바꾼다는 의미의 특수한 의미를 가진 문자(개행문자 라고도함)
//
//  plus(a,b); // 2-1-1) plus() 메서드를 호출하고 변수a 와 변수b의 값을 파라미터로 전달한다
//  // 2-1-2) plus() 메서드는 파라미터로 받은 인자값(변수 a의 값, 변수 b의 값)으로 연산처리 하고, 결과를 result 변수에 담는다
//  // * 참고 사항 * : 정확하게는 메모리 공간을 할당하여 결과값을 저장하고, 시작 주소값을 result 라고 붙여진 메모리공간에 저장한다.
//
//			System.out.printf("두수를 더하기한 결과는 : %d 입니다\n", result); // 2-2-1) printf 함수에서 "두수를 더하기한 결과는 : %d 입니다" 문구를 출력한다
//  // 2-2-2) 문구출력을 진행할 때 문구 중 '%d'가 있는 자리에 result변수의 값(plus() 메서드의 연산처리 결과값)을 넣어서 함께 출력한다
//
//  minus(a,b); // 2-3-1) minus() 메서드를 호출하고 변수a 와 변수b의 값을 파라미터로 전달한다
//  // 2-3-2) minus() 메서드는 파라미터로 받은 인자값(변수 a의 값, 변수 b의 값)으로 연산처리 하고, 결과를 result 변수에 담는다
//
//			System.out.printf("두수를 마이너스한 결과는 : %d 입니다\n", result); // 2-4-1) printf 함수에서 "두수를 마이너스한 결과는 : %d 입니다" 문구를 출력한다
//  // 2-4-2) 문구출력을 진행할 때 문구 중 '%d'가 있는 자리에 result변수의 값(minus() 메서드의 연산처리 결과값)을 넣어서 함께 출력한다
//
//  multiple(a,b); // 2-5-1) multiple() 메서드를 호출하고 변수a 와 변수b의 값을 파라미터로 전달한다
//  // 2-5-2) multiple() 메서드는 파라미터로 받은 인자값(변수 a의 값, 변수 b의 값)으로 연산처리 하고, 결과를 result 변수에 담는다
//
//			System.out.printf("두수를 곱하기한 결과는 : %d 입니다\n", result); // 2-6-1) printf 함수에서 "두수를 곱하기한 결과는 : %d 입니다" 문구를 출력한다
//  // 2-6-2) 문구출력을 진행할 때 문구 중 '%d'가 있는 자리에 result변수의 값(multiple() 메서드의 연산처리 결과값)을 넣어서 함께 출력한다
//
//  divide(a,b); // 2-7-1) divide() 메서드를 호출하고 변수a 와 변수b의 값을 파라미터로 전달한다
//  // 2-7-2) divide() 메서드는 파라미터로 받은 인자값(변수 a의 값, 변수 b의 값)으로 연산처리 하고, 결과를 result 변수에 담는다
//
//			System.out.printf("두수를 나누기한 결과는 : %d 입니다\n", result); // 2-8-1) printf 함수에서 "두수를 나누기한 결과는 : %d 입니다" 문구를 출력한다
//  // 2-8-2) 문구출력을 진행할 때 문구 중 '%d'가 있는 자리에 result변수의 값(divide() 메서드의 연산처리 결과값)을 넣어서 함께 출력한다
//
//
//	  3) main() 메서드와 메서드간의 흐름정리
//	     3-1) 위에서 아래로, 순차적으로 main 메서드내 code내용이 처리된다
//		 3-2) code 내용 처리중 연산처리 메서드(plus()/minus()/multiple()/divide() 메서드)를 호출한다
//		 3-3) 잠시 연산처리 메서드로 이동하여 로직을 처리하고, 완료되면 다시 main() 메서드로 복귀
//
//      ※ plus()/minus()/multiple()/divide() 메서드 Logic 해석 ※
//      (plus 메서드)
//      1) 인자값(argument)으로 두개의 정수를 a와 b라는 이름으로 받는다
//		     -> public static void plus(int a, int b)
//		     *** 주의 *** : main() 메서드에서 넘겨준값만 받지 main메서드의 변수 a,b와는 관련 없음!!
//      2) 변수 a의 값과 b의 값을 더하기 연산수행한 다음 static변수인 result에 담는다
//		     -> result = a + b;
//
//	    (minus 메서드)
//      1) 인자값(argument)으로 두개의 정수를 a와 b라는 이름으로 받는다
//		    -> public static void minus(int a, int b)
//		 2) 변수 a의 값과 b의 값을 빼기 연산수행한 다음 static변수인 result에 담는다
//		    -> result = a - b;
//
//	    (multiple 메서드)
//      1) 인자값(argument)으로 두개의 정수를 a와 b라는 이름으로 받는다
//		    -> public static void multiple(int a, int b)
//		 2) 변수 a의 값과 b의 값을 곱하기 연산수행한 다음 static변수인 result에 담는다
//		    -> result = a * b;
//
//	    (divide 메서드)
//      1) 인자값(argument)으로 두개의 정수를 a와 b라는 이름으로 받는다
//		    -> public static void divide(int a, int b)
//		 2) 변수 a의 값과 b의 값을 나누기 연산수행한 다음 static변수인 result에 담는다
//		    -> result = a / b;
//
//
//
//
//
//  [2] 파일명 : Calculator2.java
//      ※ 작성/구현목적 ※
//      - main() 메서드에는 첫 문구출력 기능만 수행, 나머지는 다른 메서들에서 처리하기
//		- main() 메서드가 아닌 메서드에서 다른 메서드들을 호출, 연산처리결과 사용하기
//
//
//      ※ Logic 흐름 및 Code 해석 ※
//      1) static 변수를 선언하고 초기화
//      (code)
//  private static int a = 10;
//  private static int b = 5;
//  private static int result = 0;
//
//
//      2) main 메서드 실행 후 getResult 메서드(연산처리 메서드 호출과 결과를 처리수행)를 호출
//	       (code)
//      System.out.println("두 수의 연산결과는 다음과 같습니다.\n"); // Console창에 먼저 띄울 문구를 출력
//  getResult(); // getResult() 메서드 호출
//
//
//      3) getResult() 메서드 - Logic 처리흐름 해석
//	     3-1) 이전 "Calculator1.java" 파일의 main 메서드 처리흐름과 같이 연산처리 메서드를 호출(파라미터로 static 변수 a와 b의 값을 전달)
//	     3-2) 연산처리 결과값 담긴 result 변수를 이용하여 문구 출력 수행
//      (code)
//  plus(a,b); // plus 메서드 호출
//	        System.out.printf("두수를 더하기한 결과는 : %d 입니다\n", result); // result변수의 값을 이용하여 문구 출력
//
//  minus(a,b); // minus 메서드 호출
//	        System.out.printf("두수를 마이너스한 결과는 : %d 입니다\n", result); // result변수의 값을 이용하여 문구 출력
//
//  multiple(a,b); // multiple 메서드 호출
//	        System.out.printf("두수를 곱하기한 결과는 : %d 입니다\n", result); // result변수의 값을 이용하여 문구 출력
//
//  divide(a,b); // divide 메서드 호출
//	        System.out.printf("두수를 나누기한 결과는 : %d 입니다\n", result); // result변수의 값을 이용하여 문구 출력
//			※ plus/minus/multiple/divide 메서드는 동일한 logic를 사용하기에 해석 생략함
//
//
//
//
//
//  [3] 파일명 : Calculator3.java
//      ※ 작성/구현목적 ※
//      - main메서드에 최소기능만 두기, 나머지는 다른 메서드에서 모두 처리하기 ===> 메서드로 기능묶기
//		- 연산결과를 담는 result 변수를 초기화시키는 메서드(clear() 메서드) 추가 ===> 기능추가
//
//      ※ Logic 흐름 및 Code 해석 ※
//      1) static 변수를 선언하고 초기화
//
//	  2) main 메서드 실행, 다른 기능(연산처리, 문구출력)은 getResult 메서드와 plus/minus/multiple/divide 메서드에서 처리
//
//      3) getResult 메서드 - 변경된 Logic 처리흐름 해석
//	     3-1) Console창에 첫 출력할 문구("두 수의 연산결과는 다음과 같습니다.")를 출력
//		 3-2) plus(), minus(), multiple(), divide() 메서드를 차례로 부르고 각각 호출시 파라미터값 전달
//		 3-3) clear() 메서드 실행후 종료
//}
