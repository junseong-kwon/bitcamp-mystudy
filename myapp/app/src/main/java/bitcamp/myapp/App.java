package bitcamp.myapp;

import org.checkerframework.checker.units.qual.N;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner keyboardScanner = new Scanner(System.in);
    static String[] menus = new String[] {
            "회원",
            "팀",
            "프로젝트",
            "게시판",
            "도움말",
            "종료"
    };

    static String[][] subMenus = new String[][] {
            {"등록", "목록", "조회", "변경", "삭제"},
            {"등록", "목록", "조회", "변경", "삭제"},
            {"등록", "목록", "조회", "변경", "삭제"},
            {"등록", "목록", "조회", "변경", "삭제"}
    };



    public static void main(String[] args) {
        printMenu();


        String command;
        while (true) {
            try {
                command = promft("메인");

                if (command.equals("menu")) {
                    printMenu();

                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo, menus) ;
                    if (menuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                            break;
                    } else {
                        if (menuNo >= 1 && menuNo <= 4) {
                            System.out.printf("[%s]\n", menuTitle);
                            for (int i = 0; i < subMenus[menuNo - 1].length; i++) {
                                System.out.printf("%d. %s\n", (i + 1), subMenus[menuNo - 1][i]);
                            }
                            System.out.println("9. 이전");

                            while (true) {
                                String subCommand = promft("메인/" + menuTitle);
                                if (subCommand.equals("menu")) {
                                    System.out.printf("[%s]\n", menuTitle);
                                    for (int i = 0; i < subMenus[menuNo - 1].length; i++) {
                                        System.out.printf("%d. %s\n", (i + 1), subMenus[menuNo - 1][i]);
                                    }
                                    System.out.println("9. 이전");
                                    continue;
                                } else if (subCommand.equals("9")) {
                                    break;
                                }
                                try {
                                    int subMenuNo = Integer.parseInt(subCommand);
                                    String subMenuTitle = getMenuTitle(subMenuNo, subMenus[menuNo - 1]);
                                    if (subMenuTitle == null) {
                                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                                    } else {
                                        System.out.println(subMenuTitle);
                                    }
                                } catch (NumberFormatException ex) {
                                    System.out.println("숫자로 메뉴 번호를 입력하세요.");
                                }
                            }
                        } else {
                                System.out.println(menuTitle);
                            }
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");

        keyboardScanner.close();
    }
    static void printMenu() {
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String appTitle = "[팀 프로젝트 관리 시스템]";
        String line = "----------------------------------";



        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < menus.length; i++) {
            if (menus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    static String promft(String title) {
        System.out.print("> ");
        return keyboardScanner.nextLine();
    }

    static boolean isValidateMenu(int menuNo, String[] menus) {
        return menuNo >= 1 && menuNo <= menus.length;
    }
    static String getMenuTitle(int menuNo, String[] menus) {
       return isValidateMenu(menuNo, menus) ? menus[menuNo - 1] : null;
    }

}
