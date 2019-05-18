package pl.sda.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name="RawServlet", urlPatterns = "/hello")
public class RawServlet implements Servlet {
    private AtomicInteger counter;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        counter = new AtomicInteger(0);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.println("<html><head></head>");
        out.println("<body>");

        out.println("<h1>Witaj w servlecie!! </h1>" );
        out.println("<p>Byłaś już: " + counter.get() + "</p>");
        counter.addAndGet(1);
        out.println("<p> Host żądania: " + servletRequest.getRemoteHost() + "</p>");
        out.println("<p> Parametr żądania: " + servletRequest.getParameter("id") + "</p>");
        out.println("<p> Typ zawartości: " + servletRequest.getContentType() + "</p>");
        out.println("</body></html>");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
