import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String dateTime = now.format(format);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Information</title>");

        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f2f2f2; text-align: center; }");
        out.println(".box { width: 450px; margin: 100px auto; padding: 30px; background: white; border-radius: 15px; box-shadow: 0 0 10px gray; }");
        out.println("h1 { color: #333; }");
        out.println("p { font-size: 18px; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h1>Welcome to Student Portal</h1>");

        out.println("<p><b>Student Name:</b> Hari Prasad</p>");

        out.println("<p><b>Course Name:</b> B.Tech Information Technology</p>");

        out.println("<p><b>Current Date and Time:</b> "
                + dateTime + "</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}