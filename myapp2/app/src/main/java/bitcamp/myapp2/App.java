package bitcamp.myapp2;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        String menu0 = " -----------------------------------";
        String menu00 = "";
        String menu01 = "[팀 프로젝트 관리 시스템]";
        String menu1 = "1. 회원";
        String menu2 = "2. 팀";
        String menu3 = "3. 프로젝트";
        String menu4 = "4. 게시판";
        String menu5 = "5. 도움말";
        String menu6 = "6. 종료";
        String bold = "\033[1m";
        String out = "\033[0m";
        String red = "\033[31m";

        System.out.println(bold + menu0);
        System.out.println(menu00);
        System.out.println(menu01 + out);
        System.out.println(menu1);
        System.out.println(menu2);
        System.out.println(menu3);
        System.out.println(menu4);
        System.out.println(menu5);
        System.out.println(red + bold + menu6 + out);
        System.out.println(bold + menu0 + out);

        int input;
        do {
            System.out.print("> ");
            input = keyboardScanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println("회원");
                    break;
                case 2:
                    System.out.println("팀");
                    break;
                case 3:
                    System.out.println("프로젝트");
                    break;
                case 4:
                    System.out.println("게시판");
                    break;
                case 5:
                    System.out.println("도움말");
                    break;
                case 6:
                    System.out.println("종료");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    break;
            }
        }
            while (input != 6) ;
        keyboardScanner.close();
    }
}
