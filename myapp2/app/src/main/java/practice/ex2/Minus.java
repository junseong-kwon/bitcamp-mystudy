package practice.ex2;

import java.util.Scanner;

public class Minus {

    Scanner scanner = new Scanner(System.in);


    public void minus (){
        System.out.println("빼기");
        System.out.print("첫 번째 숫자: ");
        int a1 = scanner.nextInt();
        System.out.print("두 번째 숫자: ");
        int b1 = scanner.nextInt();
        scanner.nextLine();
        int minus = a1 - b1;
        System.out.println("결과는: " + minus + "입니다.");
    }
}
