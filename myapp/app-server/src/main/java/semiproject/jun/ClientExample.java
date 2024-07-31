package semiproject.jun;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExample {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      Socket socket = new Socket("localhost", 50001);

      System.out.println("[클라이언트] 연결 성공");
      scanner.nextLine();

      String data = "보낼 데이터";
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      dos.writeUTF(data);
      dos.flush();

      DataInputStream dis = new DataInputStream(socket.getInputStream());
      String data2 = dis.readUTF();
      System.out.println(data2);

      socket.close();
      System.out.println("[클라이언트] 연결 끊음");
    } catch (UnknownHostException e) {

    } catch (IOException e) {

    }
  }

}
