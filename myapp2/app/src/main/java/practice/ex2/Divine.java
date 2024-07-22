package practice.ex2;

import java.util.Scanner;

public class Divine {

    Scanner scanner = new Scanner(System.in);


    public void divine (){
        System.out.println("나누기");
        System.out.print("첫 번째 숫자: ");
        int a1 = scanner.nextInt();
        System.out.print("두 번째 숫자: ");
        int b1 = scanner.nextInt();
        scanner.nextLine();
        double div = (double) a1 / (double) b1;
        System.out.println("결과는: " + div + "입니다.");
    }
}
