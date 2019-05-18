package pl.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name="HttpServlet", urlPatterns = "/httpServlet")
public class HttpServlet extends javax.servlet.http.HttpServlet {
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        out.println("Witaj w serwlecie http! ");
        out.println("Byłaś już tutaj: " + counter.get());
        counter.addAndGet(1);


    }
}
