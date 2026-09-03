<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.itservice.model.ServiceRequest" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>IT Service Request Report</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f4f7;
            margin: 0;
            padding: 30px;
        }

        .container {
            width: 95%;
            margin: auto;
            background-color: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .buttons {
            margin-top: 20px;
            text-align: center;
        }

        .button {
            display: inline-block;
            padding: 10px 18px;
            margin: 5px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .download {
            background-color: #dc3545;
        }

        .back {
            background-color: #28a745;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th {
            background-color: #007bff;
            color: white;
            padding: 10px;
        }

        td {
            padding: 9px;
            border: 1px solid #ccc;
            text-align: center;
        }

        .description {
            text-align: left;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>IT Service Request Report</h2>

    <table>

        <tr>
            <th>Request No.</th>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Department</th>
            <th>Category</th>
            <th>Description</th>
            <th>Priority</th>
            <th>Date & Time (IST)</th>
        </tr>

        <%
            List<ServiceRequest> serviceRequests =
                (List<ServiceRequest>) request.getAttribute("serviceRequests");

            DateTimeFormatter dateFormatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");

            if (serviceRequests != null && !serviceRequests.isEmpty()) {

                synchronized (serviceRequests) {

                    for (ServiceRequest serviceRequest : serviceRequests) {
        %>

        <tr>

            <td>
                <%= serviceRequest.getRequestNumber() %>
            </td>

            <td>
                <%= serviceRequest.getEmployeeId() %>
            </td>

            <td>
                <%= serviceRequest.getEmployeeName() %>
            </td>

            <td>
                <%= serviceRequest.getDepartment() %>
            </td>

            <td>
                <%= serviceRequest.getProblemCategory() %>
            </td>

            <td class="description">
                <%= serviceRequest.getProblemDescription() %>
            </td>

            <td>
                <%= serviceRequest.getPriority() %>
            </td>

            <td>
                <%= serviceRequest.getRequestDate()
                        .format(dateFormatter) %> IST
            </td>

        </tr>

        <%
                    }
                }

            } else {
        %>

        <tr>
            <td colspan="8">
                No service requests have been submitted yet.
            </td>
        </tr>

        <%
            }
        %>

    </table>

    <div class="buttons">

        <a class="button download"
           href="DownloadReportServlet">
            Download Report as PDF
        </a>

        <a class="button back"
           href="serviceRequest.jsp">
            Submit New Request
        </a>

    </div>

</div>

</body>
</html>