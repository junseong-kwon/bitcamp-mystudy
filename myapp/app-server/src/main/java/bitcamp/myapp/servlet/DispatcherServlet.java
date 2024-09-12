package bitcamp.myapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 60,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            req.getRequestDispatcher(req.getPathInfo()).include(req, res);

            Exception exception = (Exception) req.getAttribute("exception");
            if (exception != null) {
                throw exception;
            }

            // 쿠키 처리
            Enumeration<String> attrNames = req.getAttributeNames();
            while (attrNames.hasMoreElements()) {
                Object attrValue = req.getAttribute(attrNames.nextElement());
                if (attrValue instanceof Cookie) {
                    res.addCookie((Cookie) attrValue);
                }

            }

            String viewName = (String) req.getAttribute("viewName");
            if (viewName == null) {
                return;

            } else if (viewName.startsWith("redirect:")) {
                res.sendRedirect(viewName.substring(9));

            } else {
                String refresh = (String) req.getAttribute("refresh");
                if (refresh != null) {
                    res.setHeader("Refresh", refresh);
                }
                req.getRequestDispatcher(viewName).forward(req, res);
            }

        } catch (Exception e) {
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }

}
