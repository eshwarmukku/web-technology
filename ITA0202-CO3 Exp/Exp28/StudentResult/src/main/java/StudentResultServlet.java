import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class StudentResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        String regno = request.getParameter("registerNumber");

        String m1 = request.getParameter("mark1");
        String m2 = request.getParameter("mark2");
        String m3 = request.getParameter("mark3");
        String m4 = request.getParameter("mark4");
        String m5 = request.getParameter("mark5");

        // Check empty fields
        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            m1 == null || m1.trim().isEmpty() ||
            m2 == null || m2.trim().isEmpty() ||
            m3 == null || m3.trim().isEmpty() ||
            m4 == null || m4.trim().isEmpty() ||
            m5 == null || m5.trim().isEmpty()) {

            showError(out, "Please fill all the fields.");
            return;
        }

        int mark1, mark2, mark3, mark4, mark5;

        // Convert marks to integers
        try {

            mark1 = Integer.parseInt(m1);
            mark2 = Integer.parseInt(m2);
            mark3 = Integer.parseInt(m3);
            mark4 = Integer.parseInt(m4);
            mark5 = Integer.parseInt(m5);

        } catch (NumberFormatException e) {

            showError(out, "Marks must contain numeric values only.");
            return;
        }

        // Check mark range
        if (mark1 < 0 || mark1 > 100 ||
            mark2 < 0 || mark2 > 100 ||
            mark3 < 0 || mark3 > 100 ||
            mark4 < 0 || mark4 > 100 ||
            mark5 < 0 || mark5 > 100) {

            showError(out, "Marks must be between 0 and 100.");
            return;
        }

        // Calculate result
        int total = mark1 + mark2 + mark3 + mark4 + mark5;

        double average = total / 5.0;

        int highest = Math.max(mark1,
                       Math.max(mark2,
                       Math.max(mark3,
                       Math.max(mark4, mark5))));

        int lowest = Math.min(mark1,
                      Math.min(mark2,
                      Math.min(mark3,
                      Math.min(mark4, mark5))));

        String grade;

        if (average >= 90)
            grade = "A+";
        else if (average >= 80)
            grade = "A";
        else if (average >= 70)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";

        String status;

        if (mark1 >= 40 && mark2 >= 40 &&
            mark3 >= 40 && mark4 >= 40 &&
            mark5 >= 40) {

            status = "PASS";

        } else {

            status = "FAIL";
        }

        // Display result
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Result</title>");

        out.println("<style>");

        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background:#eef2f7;");
        out.println("text-align:center;");
        out.println("padding:30px;");
        out.println("}");

        out.println(".container {");
        out.println("width:650px;");
        out.println("margin:auto;");
        out.println("background:white;");
        out.println("padding:30px;");
        out.println("border-radius:15px;");
        out.println("box-shadow:0 0 12px gray;");
        out.println("}");

        out.println("table {");
        out.println("width:100%;");
        out.println("border-collapse:collapse;");
        out.println("margin-top:20px;");
        out.println("}");

        out.println("th, td {");
        out.println("border:1px solid #aaa;");
        out.println("padding:12px;");
        out.println("}");

        out.println("th {");
        out.println("background:#333;");
        out.println("color:white;");
        out.println("}");

        out.println(".pass {");
        out.println("color:green;");
        out.println("font-weight:bold;");
        out.println("}");

        out.println(".fail {");
        out.println("color:red;");
        out.println("font-weight:bold;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<h1>Student Result</h1>");

        out.println("<p><b>Student Name:</b> " + name + "</p>");
        out.println("<p><b>Register Number:</b> " + regno + "</p>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Subject</th>");
        out.println("<th>Mark</th>");
        out.println("</tr>");

        out.println("<tr><td>Subject 1</td><td>" + mark1 + "</td></tr>");
        out.println("<tr><td>Subject 2</td><td>" + mark2 + "</td></tr>");
        out.println("<tr><td>Subject 3</td><td>" + mark3 + "</td></tr>");
        out.println("<tr><td>Subject 4</td><td>" + mark4 + "</td></tr>");
        out.println("<tr><td>Subject 5</td><td>" + mark5 + "</td></tr>");

        out.println("<tr><th>Total</th><th>" + total + "</th></tr>");

        out.println("<tr><th>Average</th><th>"
                + String.format("%.2f", average)
                + "</th></tr>");

        out.println("<tr><th>Highest Mark</th><th>"
                + highest + "</th></tr>");

        out.println("<tr><th>Lowest Mark</th><th>"
                + lowest + "</th></tr>");

        out.println("<tr><th>Grade</th><th>"
                + grade + "</th></tr>");

        out.println("<tr><th>Result</th><th class='"
                + (status.equals("PASS") ? "pass" : "fail")
                + "'>"
                + status
                + "</th></tr>");

        out.println("</table>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }


    // Error message method
    private void showError(PrintWriter out, String message) {

        out.println("<html>");
        out.println("<body style='font-family:Arial;text-align:center;padding:50px;'>");

        out.println("<h2 style='color:red;'>Error</h2>");

        out.println("<p>" + message + "</p>");

        out.println("<a href='index.html'>Go Back</a>");

        out.println("</body>");
        out.println("</html>");
    }
}