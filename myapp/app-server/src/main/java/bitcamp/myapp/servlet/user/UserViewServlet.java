package bitcamp.myapp.servlet.user;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/view")
public class UserViewServlet extends GenericServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        // 서블릿 컨테이너 ---> init(ServletConfig) ---> init() 호출한다.
        userDao = (UserDao) this.getServletContext().getAttribute("userDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);


        try {
            out.println("<h1>회원 조회</h1>");

            int userNo = Integer.parseInt(req.getParameter("no"));

            User user = userDao.findBy(userNo);
            if (user == null) {
                out.println("<p>없는 회원입니다.</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            out.println("<form action='/user/update'>");
            out.printf("       번호: <input name='no' readonly type='text' value='%d'><br>\n", user.getNo()); //readonly는 속성이 존재하는 것만으로 사용이 가능 값에 아무 의미가 없음
            out.printf("       이름: <input name='name' type='text' value='%s'><br>\n", user.getName()); //값을 넣지 않으면 웹은 빈문자열로 출력한다.
            out.printf("       이메일: <input name='email' type='email' value='%s'><br>\n", user.getEmail());
            out.println("       암호: <input name='password' type='password'><br>");
            out.printf("       연락처: <input name='tel' type='tel' value='%s>'<br>\n", user.getTel());
            out.println("       <button>변경</button>");
            out.printf("       <button type='button' onclick='location.href=\"/user/delete?no=%d\"'>삭제</button>\n", user.getNo()); //onclick속성안에 자바스크립트를 넣으면 실행이 된다.
            out.println("</form>"); //alert(화면에 문자열을 띄우는 일을 함) location(현재 웹브라우저가 어떤 콘텐츠를 출력하는지의 정보를 알려주는 메서드를 담고있다)은 온클릭에 설정한


        } catch (Exception e) {
            out.println("<p>조회 중 오류 발생!</p>");
        }
        out.println("</head>");
        out.println("<body>");
        
    }
}
