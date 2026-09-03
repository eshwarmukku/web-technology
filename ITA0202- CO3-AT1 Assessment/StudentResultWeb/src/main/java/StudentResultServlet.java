import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String m1 = request.getParameter("mark1");
        String m2 = request.getParameter("mark2");
        String m3 = request.getParameter("mark3");

        out.println("<html><body>");
        out.println("<h2>Student Result</h2>");

        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            m1 == null || m1.trim().isEmpty() ||
            m2 == null || m2.trim().isEmpty() ||
            m3 == null || m3.trim().isEmpty()) {

            out.println("<h3>Please fill all fields.</h3>");
            out.println("</body></html>");
            return;
        }

        try {
            int mark1 = Integer.parseInt(m1);
            int mark2 = Integer.parseInt(m2);
            int mark3 = Integer.parseInt(m3);

            if (mark1 < 0 || mark1 > 100 ||
                mark2 < 0 || mark2 > 100 ||
                mark3 < 0 || mark3 > 100) {

                out.println("<h3>Marks must be between 0 and 100.</h3>");
                out.println("</body></html>");
                return;
            }

            int total = mark1 + mark2 + mark3;
            double average = total / 3.0;

            int highest = Math.max(mark1,
                            Math.max(mark2, mark3));

            String result;

            if (mark1 >= 40 && mark2 >= 40 && mark3 >= 40)
                result = "PASS";
            else
                result = "FAIL";

            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Register Number:</b> " + regno + "</p>");
            out.println("<p><b>Subject 1:</b> " + mark1 + "</p>");
            out.println("<p><b>Subject 2:</b> " + mark2 + "</p>");
            out.println("<p><b>Subject 3:</b> " + mark3 + "</p>");
            out.println("<p><b>Total:</b> " + total + "</p>");
            out.println("<p><b>Average:</b> " + average + "</p>");
            out.println("<p><b>Highest Mark:</b> " + highest + "</p>");
            out.println("<h3>Result: " + result + "</h3>");

        } catch (NumberFormatException e) {
            out.println("<h3>Please enter valid numeric marks.</h3>");
        }

        out.println("</body></html>");
    }
}