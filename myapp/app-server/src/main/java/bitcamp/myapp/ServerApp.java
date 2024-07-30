package bitcamp.myapp;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.dao.skel.BoardDaoSkel;
import bitcamp.myapp.dao.skel.ProjectDaoSkel;
import bitcamp.myapp.dao.skel.UserDaoSkel;
import bitcamp.myapp.listener.InitApplicationListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApp {

  List<ApplicationListener> listeners = new ArrayList<>();
  ApplicationContext appCtx = new ApplicationContext();

  UserDaoSkel userDaoSkel;
  BoardDaoSkel boardDaoSkel;
  ProjectDaoSkel projectDaoSkel;


  public static void main(String[] args) {
    ServerApp app = new ServerApp();

    app.addApplicationlistener(new InitApplicationListener());

    app.execute();
  }

  private void addApplicationlistener(ApplicationListener listener) {
    listeners.add(listener);
  }

  private void removeApplicationListener(ApplicationListener listener) {
    listeners.remove(listener);
  }


  void execute() {

    for (ApplicationListener listener : listeners) {
      try {
        listener.onStrat(appCtx);
      } catch (Exception e) {
        System.out.println("리스너 실행 중 오류 발생!");
      }
    }

    //서버에서 사용할 Dao Skeleton 객체를 준비
    userDaoSkel = (UserDaoSkel) appCtx.getAttribute("userDaoSkel");
    boardDaoSkel = (BoardDaoSkel) appCtx.getAttribute("boardDaoSkel");
    projectDaoSkel = (ProjectDaoSkel) appCtx.getAttribute("projectDaoSkel");

    System.out.println("서버 프로젝트 관리 시스템 시작!");

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      // try에 위와 같은 것을 넣어두면 자동으로 close문을 닫아준다.
      //try안에는 변수 선언만 넣어줄 수 있다.
      // 일반 명령문은 넣어줄 수 없다.

      System.out.println("서버 실행중...");

      while (true) {
        processRequest(serverSocket.accept());
      }

    } catch (Exception e) {
      System.out.println("통신 중 오류 발생!");
      e.printStackTrace();
    }

    System.out.println("종료합니다.");

    for (ApplicationListener listener : listeners) {
      try {
        listener.onShutdown(appCtx);
      } catch (Exception e) {
        System.out.println("리스터 실행 중 오류 발생!");
      }
    }
  }

  void processRequest(Socket s) {
    String remoteHost = null;
    int port = 0;

    try (Socket socket = s) {

      InetSocketAddress addr = (InetSocketAddress) s.getRemoteSocketAddress(); //Inet 주소 정보 리턴
      remoteHost = addr.getHostString();
      port = addr.getPort();

      System.out.printf("%s:%d 클라이언트와 연결되었음!\n", remoteHost, port);

      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

      String dataName = in.readUTF();
      switch (dataName) {
        case "users":
          userDaoSkel.service(in, out); //입출력 스트림 줄테니 니가 처리해라
          break;
        case "projects":
          projectDaoSkel.service(in, out);
          break;
        case "boards":
          boardDaoSkel.service(in, out);
          break;
        default:
      }
    } catch (Exception e) {
      System.out.printf("%s:%d 클라이언트 요청 처리 중 오류 발생!\n", remoteHost, port);
    }
  }
}


