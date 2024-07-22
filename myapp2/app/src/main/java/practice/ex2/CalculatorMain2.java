package practice.ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMain2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plus plus = new Plus();
        Minus minus = new Minus();
        Multiplication multi = new Multiplication();
        Divine div = new Divine();
        Menu menu = new Menu();





        menu.menus();
        while (true) {
            try {
                String menuNo = scanner.nextLine();
                if (menuNo.equals("menu")) {
                    menu.menus();
                    continue;
                }
            
            switch (menuNo) {
                case "1":
                    plus.plus();
                    break;
                case "2":
                    minus.minus();
                    break;
                case "3":
                    multi.multiple();
                    break;
                case "4":
                    div.divine();
                    break;
                case  "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            }catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine();
            }catch (Exception e) {
                System.out.println("잘못된 입력");
            }
        }
    }

}
