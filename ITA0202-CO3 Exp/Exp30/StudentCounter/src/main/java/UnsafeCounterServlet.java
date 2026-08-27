import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/unsafe")
public class UnsafeCounterServlet extends HttpServlet {

    private int visitorCount = 0;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int oldCount = visitorCount;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        visitorCount = oldCount + 1;

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Unsafe Visitor Counter</title>");

        out.println("<style>");
        out.println("body { font-family:Arial; background:#ffecec; text-align:center; padding:50px; }");
        out.println(".box { width:500px; margin:auto; background:white; padding:30px; border-radius:15px; box-shadow:0 0 10px gray; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h1>Unsafe Visitor Counter</h1>");

        out.println("<h2>Visitor Count: "
                + visitorCount + "</h2>");

        out.println("<p>This counter is not thread-safe.</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}