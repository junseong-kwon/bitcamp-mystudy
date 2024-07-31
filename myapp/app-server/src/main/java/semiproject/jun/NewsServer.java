package semiproject.jun;

import java.net.DatagramSocket;
import java.util.Scanner;

public class NewsServer {

  private static DatagramSocket datagramSocket = null;

  public static void main(String[] args) {
    System.out.println("--------------------------------------");
    System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
    System.out.println("--------------------------------------");

    startServer();

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String key = scanner.nextLine();
      if (key.toLowerCase().equals("q")) {
        break;
      }
    }

    scanner.close();

    stopServer();
  }

  public static void

}
