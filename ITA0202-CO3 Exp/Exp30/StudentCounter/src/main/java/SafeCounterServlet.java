import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/safe")
public class SafeCounterServlet extends HttpServlet {

    private final AtomicInteger visitorCount =
            new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int count = visitorCount.incrementAndGet();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Safe Visitor Counter</title>");

        out.println("<style>");
        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background: #eaffea;");
        out.println("text-align: center;");
        out.println("padding: 50px;");
        out.println("}");

        out.println(".box {");
        out.println("width: 500px;");
        out.println("margin: auto;");
        out.println("background: white;");
        out.println("padding: 30px;");
        out.println("border-radius: 15px;");
        out.println("box-shadow: 0 0 10px gray;");
        out.println("}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h1>Thread-Safe Visitor Counter</h1>");

        out.println("<h2>Visitor Count: "
                + count + "</h2>");

        out.println("<p>AtomicInteger provides thread-safe counting.</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}