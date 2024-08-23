package bitcamp.myapp;

import bitcamp.util.Prompt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientApp {

    private static final String GOODBYE = "<[goodbye!]>";

    public static void main(String[] args) {
        ClientApp app = new ClientApp();
        app.execute();
    }


    void execute() {
        String host = Prompt.input("서버?"); // 프롬프트에 서버 값 입력
        int port = Prompt.inputInt("포트번호?"); // 프롬프트에 포트번호 입력

        try (Socket socket = new Socket(host, port); // 소켓에 서버, 포트번호값을 넣어주고 소켓 연결
             DataInputStream in = new DataInputStream(socket.getInputStream()); // 데이터 입력을 받을 수 있는 객체 생성
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) { //데이터 출력을 할 수 있는 객체 생성

            while (true) { //반복문을 통해 서버와 통신
                String message = in.readUTF(); // 문자열을 받아서 message변수에 저장
                if (message.endsWith(GOODBYE)) { //메세지의 끝이 GOODBYE면
                    System.out.println(message.substring(0, message.indexOf(GOODBYE))); // 문자열의 0번부터 GOODBYE가 나오기 전까지의 문자열을 출력
                    System.out.println("종료합니다!"); // 종료
                    break;
                }
                System.out.print(message); // GOODBYE가 아니라면 받은 문자열을 출력

                String input = Prompt.input(""); //프롬프트에 입력한 값을 input변수에 저장
                out.writeUTF(input); //서버에 출력
                out.flush(); //데이터 보관소를 비워준다
            }

        } catch (Exception ex) {
            System.out.println("실행 오류!");
            ex.printStackTrace();
        }


        Prompt.close(); //프롬프트를 다 사용했으면 종료


    }
}
