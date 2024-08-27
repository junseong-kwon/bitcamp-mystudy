package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/project/list")
public class ProjectListServlet implements Servlet {

    private ServletConfig config;
    private ProjectDao projectDao;


    @Override
    public void init(ServletConfig config) throws ServletException {
        // 서블릿 객체를 생성한 후 바로 호출됨(물론, 생성자가 먼저 호출된다.)
        // 서블릿이 작업할 떄 사용할 의존 객체를 준비하는 일을 이 메서드에서 수행한다.
        this.config = config;

        ServletContext ctx = config.getServletContext();
        projectDao = (ProjectDao) ctx.getAttribute("projectDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("   <title>Title</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");

        try {

            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>번호</th><th>프로젝트</th><th>기간</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<h1>프로젝트 목록</h1>");
            for (Project project : projectDao.list()) {
                out.printf("<tr><td>%d</td><td><a href='/project/view?no=%1$d'>%s</a></td><td>%s ~ %s</td></tr>\n",
                        project.getNo(), project.getTitle(), project.getStartDate(), project.getEndDate());
            }
            out.println("</tbody>");
            out.println("</table>");

        } catch (Exception e) {
            out.println("<p>목록 조회 중 오류 발생!</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }


    @Override
    public void destroy() {
        //서블릿 컨테이너가 종료되기 전에 해제할 자원이 있다면 이 메서드에서 수행한다.
    }

    @Override
    public String getServletInfo() {
        // 서블릿 컨테이너 관리 화면에서 서블릿을 정보를 출력할 때 이 메서드가 호출된다.
        // 간단히 서블릿에 대한 정보를 문자열로 리턴하면 된다.
        return "게시판 목록 조회";
    }

    @Override
    public ServletConfig getServletConfig() {
        // 내부적으로 서블릿의 정보를 조회할 떄 사용할 ServletConfig 객체를 리턴해 준다.
        // 이 메서드가 리턴할 ServletConfig 객체는
        // init() 메서드가 호출될 때 파라미터로 넘어온 객체다.
        // 따라서 init() 메서드가 호출될 때 ServletConfig 객체를 보관해 둬야 한다.
        return this.config;
    }
}
