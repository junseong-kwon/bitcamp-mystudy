package practice.ex2;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;


public class Plus {
    Scanner scanner = new Scanner(System.in);


    public void plus (){
        System.out.println("더하기");
        System.out.print("첫 번째 숫자: ");
        int a1 = scanner.nextInt();
        System.out.print("두 번째 숫자: ");
        int b1 = scanner.nextInt();
        scanner.nextLine();
        int sum = a1 + b1;
        System.out.println("결과는: " + sum + "입니다.");
    }

}
