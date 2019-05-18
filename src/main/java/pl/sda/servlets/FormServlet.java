package pl.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    private String userLogin = "motylla";
    private String userPassword = "abcd";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        out.println("<h1> logowanie </h1>");
        out.println("<form action='/form' method='post'>");
        out.println("<input type='text' name='login'>");
        out.println("<input type='password' name='password'>");
        out.println("<input type='submit' value='wyslij'>");
        out.println("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userLogin.equals(login) && userPassword.equals(password)) {
            out.println("OK, formularz przyjęty");
        } else {
            out.println("Błędny login i hasło");
        }


    }
}
