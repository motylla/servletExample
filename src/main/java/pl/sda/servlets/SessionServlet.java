package pl.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="SessionServlet", urlPatterns = {"/session/add", "/session/view"})
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getRequestURI().endsWith("add")) {
            session.setMaxInactiveInterval(100);
            session.setAttribute("login", "Magda");
        }
        if (req.getRequestURI().endsWith("view")) {
            resp.getWriter().println("login: " + session.getAttribute("login"));

        }



    }
}
