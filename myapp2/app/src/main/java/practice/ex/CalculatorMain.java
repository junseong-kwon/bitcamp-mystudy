package practice.ex;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu();
        System.out.print("입력해봐: ");
        while (true) {
            try {
                String menuNo = scanner.nextLine();
                if (menuNo.equals("menu")) {
                    menu();
                    System.out.print("입력해봐: ");
                    continue;
                }
                switch (menuNo) {
                    case "1":
                        System.out.println("더하기");
                        System.out.print("첫 번째 숫자: ");
                        int a1 = scanner.nextInt();
                        System.out.print("두 번째 숫자: ");
                        int b1 = scanner.nextInt();
                        scanner.nextLine(); // 개행 문자 제거
                        System.out.println("결과는 : " + plus(a1, b1) + " 입니다.");
                        break;
                    case "2":
                        System.out.println("빼기");
                        System.out.print("첫 번째 숫자: ");
                         a1 = scanner.nextInt();
                        System.out.print("두 번째 숫자: ");
                         b1 = scanner.nextInt();
                        scanner.nextLine(); // 개행 문자 제거
                        System.out.println("결과는 : " + minus(a1, b1) + " 입니다.");
                        break;
                    case "3":
                        System.out.println("곱하기");
                        System.out.print("첫 번째 숫자: ");
                        a1 = scanner.nextInt();
                        System.out.print("두 번째 숫자: ");
                        b1 = scanner.nextInt();
                        scanner.nextLine(); // 개행 문자 제거
                        System.out.println("결과는 : " + multiplication(a1, b1) + " 입니다.");
                        break;
                    case "4":
                        System.out.println("나누기");
                        System.out.print("첫 번째 숫자: ");
                        double a2 = scanner.nextDouble();
                        System.out.print("두 번째 숫자: ");
                        double b2 = scanner.nextDouble();
                        scanner.nextLine(); // 개행 문자 제거
                        System.out.println("결과는 : " + divine(a2, b2) + " 입니다.");
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 메뉴 번호를 입력해 주세요.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("숫자를 입력해 주세요.");
                scanner.nextLine(); // 잘못된 입력 제거
            } catch (Exception ex) {
                System.out.println("예상치 못한 오류가 발생했습니다: " + ex.getMessage());
            }
            System.out.print("입력해봐: ");
        }
    }

    public static int plus(int a, int b) {
       return a + b;


    }
    public static int minus(int a, int b) {
        return a - b;
    }
    public static int multiplication(int a, int b) {
        return a * b;
    }
    public static double divine(double a, double b) {
        return a / b;
    }
    public static void menu() {
        System.out.println("1. 더하기");
        System.out.println("2. 빼기");
        System.out.println("3. 곱하기");
        System.out.println("4. 나누기");
        System.out.println("0. 종료");
    }


}
