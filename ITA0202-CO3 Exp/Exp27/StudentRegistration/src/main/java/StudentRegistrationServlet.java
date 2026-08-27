import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        String regno = request.getParameter("registerNumber");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");

        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            semester == null || semester.trim().isEmpty()) {

            out.println("<html>");
            out.println("<body style='font-family:Arial;text-align:center;'>");

            out.println("<h2 style='color:red;'>");
            out.println("Please fill all the fields.");
            out.println("</h2>");

            out.println("<a href='index.html'>Go Back</a>");

            out.println("</body>");
            out.println("</html>");

            return;
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Successful</title>");

        out.println("<style>");
        out.println("body { font-family:Arial; background:#eef2f7; text-align:center; padding:40px; }");
        out.println(".box { width:500px; margin:auto; padding:30px; background:white; border-radius:15px; box-shadow:0 0 10px gray; }");
        out.println("p { font-size:18px; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h1>Registration Successful</h1>");

        out.println("<p><b>Student Name:</b> " + name + "</p>");
        out.println("<p><b>Register Number:</b> " + regno + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Department:</b> " + department + "</p>");
        out.println("<p><b>Semester:</b> " + semester + "</p>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}