package practice.ex2;

import java.util.Scanner;

public class Multiplication {

    Scanner scanner = new Scanner(System.in);


    public void multiple (){
        System.out.println("곱하기");
        System.out.print("첫 번째 숫자: ");
        int a1 = scanner.nextInt();
        System.out.print("두 번째 숫자: ");
        int b1 = scanner.nextInt();
        scanner.nextLine();
        int multi = a1 * b1;
        System.out.println("결과는: " + multi + "입니다.");
    }
}
