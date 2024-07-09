package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;

public abstract class AbstractCommand implements Command {

  protected String menuTitle;

  public AbstractCommand(String menuTitle) {
    this.menuTitle = menuTitle;
  }

  @Override
  public void execute() {
    printMenu();

    while (true) {
      String command = Prompt.input(String.format("메인/%s>", menuTitle));
      if (command.equals("menu")) {
        printMenu();
        continue;
      } else if (command.equals("9")) { // 이전 메뉴 선택
        break;
      }

      try {
        int menuNo = Integer.parseInt(command);
        String menuName = getMenuTitle(menuNo);
        if (menuName == null) {
          System.out.println("유효한 메뉴 번호가 아닙니다.");
          continue;
        }
      } catch (NumberFormatException ex) {
        System.out.println("숫자로 메뉴 번호를 입력하세요.");
      }
    }
  }

  private boolean isValidateMenu(int menuNo) {
    return menuNo >= 1 && menuNo <= menus.length;
  }

  private String getMenuTitle(int menuNo) {
    return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
  }

  protected abstract String[] getMenues();

  protected abstract void processMenu(String menuName);
}
