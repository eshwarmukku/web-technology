package lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {

    static int constructorCount = 0;
    static int initCount = 0;
    static int serviceCount = 0;
    static int doGetCount = 0;
    static int destroyCount = 0;

    public LifecycleServlet() {
        constructorCount++;

        System.out.println(
            "Constructor executed: " + constructorCount
        );
    }

    @Override
    public void init() throws ServletException {
        super.init();

        initCount++;

        System.out.println(
            "init() executed: " + initCount
        );
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        serviceCount++;

        System.out.println(
            "service() executed: " + serviceCount
        );

        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doGetCount++;

        System.out.println(
            "doGet() executed: " + doGetCount
        );

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Lifecycle</title>");

        out.println("<style>");
        out.println("body { font-family: Arial; background:#eef2f7; text-align:center; padding:40px; }");
        out.println(".box { width:500px; margin:auto; background:white; padding:30px; border-radius:15px; box-shadow:0 0 10px gray; }");
        out.println("p { font-size:18px; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h1>Servlet Lifecycle</h1>");

        out.println("<p>Welcome to Servlet Lifecycle Demonstration</p>");

        out.println("<p><b>Constructor:</b> "
                + constructorCount + "</p>");

        out.println("<p><b>init():</b> "
                + initCount + "</p>");

        out.println("<p><b>service():</b> "
                + serviceCount + "</p>");

        out.println("<p><b>doGet():</b> "
                + doGetCount + "</p>");

        out.println("<p><b>destroy():</b> "
                + destroyCount + "</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {

        destroyCount++;

        System.out.println(
            "destroy() executed: " + destroyCount
        );

        super.destroy();
    }
}