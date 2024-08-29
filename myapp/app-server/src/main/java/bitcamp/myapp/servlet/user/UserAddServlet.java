package bitcamp.myapp.servlet.user;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/add")
public class UserAddServlet extends GenericServlet {

    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void init() throws ServletException {
        ServletContext ctx = this.getServletContext();
        this.userDao = (UserDao) ctx.getAttribute("userDao");
        this.sqlSessionFactory = (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
    }

    @Override // ServletRequest(부모)는 httpServletRequest(자식), ServletResponse는 HttpServletResponse가 넘어온다.
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        try {

            out.println("<h1>회원 등록 결과</h1>");

            User user = new User();
            user.setName(req.getParameter("name"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setTel(req.getParameter("tel"));

            userDao.insert(user);
            sqlSessionFactory.openSession(false).commit();
            out.println("<p>등록 성공입니다.</p>");

        } catch (Exception e) {
            sqlSessionFactory.openSession(false).rollback();
            out.println("<p>등록 중 오류 발생!</p>");
        }

        out.println("</body>");
        out.println("</html>"); //버퍼에 보관

        ((HttpServletResponse) res).setHeader("Refresh", "1;url=/user/list"); //ServletResponse에는 setHeader가 없지만 자식인 HttpServletResponse에는 존재한다.
    } //버퍼를 초과하면 자동으로 데이터를 보내지만 그렇지 않으면 맨 마지막에 헤더를 세팅해도 좋다.
}
