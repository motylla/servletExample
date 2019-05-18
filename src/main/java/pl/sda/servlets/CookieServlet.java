package pl.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name="CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();

        //Próba pobrania ciastka 'color'
        getCookie(req, "color").ifPresent(c -> {
            out.println("<body bgcolor=" + c.getValue() + "> </body>");
        });

        out.println("<form action = '/cookie' method = 'post' >");
        out.println("<select name = 'color'> ");
        out.println("<option>blue</option>");
        out.println("<option>pink</option>");
        out.println("<option>green</option>");
        out.println("<option>black</option>");
        out.println("</select>");
        out.println("<input type='submit' value='zapisz'>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        resp.addCookie(new Cookie("color", color));
        resp.getWriter().println("Ciasteczko zapisane");
    }

    private Optional<Cookie> getCookie(HttpServletRequest req, String cookieName) {
        for (Cookie c: req.getCookies()) {
            if (c.getName().equals(cookieName)) {
                return Optional.ofNullable(c);
            }
        }
        return Optional.empty();
    }
}
