package bitcamp.myapp3;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner keyboardScanner = new Scanner(System.in);

        String bold = "\033[1m";
        String del = "\033[0m";
        String red = "\033[31m";
        String menuDelimiter = "------------------------------";
        String menuTitle = "[팀 프로젝트 관리 시스템]";
        String[] menuItems = {"회원", "팀", "프로젝트", "게시판", "도움말"};

        System.out.println(bold + menuDelimiter);
        System.out.println(menuTitle + del);
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        System.out.println(bold + red + "종료" + del);
        System.out.println(bold + menuDelimiter + del);

        boolean isRunning = true;
        while (isRunning) {
            System.out.print("< ");
            String input = keyboardScanner.nextLine().trim();

            switch (input) {
                case "1":
             1       System.out.println("회원");
                    break;
                case "2":
                    System.out.println("팀");
                    break;
                case "3":
                    System.out.println("프로젝트");
                    break;
                case "4":
                    System.out.println("게시판");
                    break;
                case "5":
                    System.out.println("도움말");
                    break;
                case "6":
                    isRunning = false; //
                    System.out.println("종료합니다");// 반복문 종료
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
                    break;
            }

            System.out.println();

        }

        keyboardScanner.close(); // Scanner 닫기
    }
}