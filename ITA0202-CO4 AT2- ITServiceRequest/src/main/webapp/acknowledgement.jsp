<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.itservice.model.ServiceRequest" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Service Request Acknowledgement</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f4f7;
        }

        .container {
            width: 600px;
            margin: 40px auto;
            background-color: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            text-align: center;
        }

        .success {
            background-color: #d4edda;
            color: #155724;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        td:first-child {
            font-weight: bold;
            width: 35%;
        }
    </style>
</head>

<body>

<%
    ServiceRequest serviceRequest =
        (ServiceRequest) request.getAttribute("serviceRequest");

    String requestNumber =
        (String) request.getAttribute("requestNumber");
%>

<div class="container">

    <h2>Service Request Acknowledgement</h2>

    <div class="success">
        Your IT service request has been submitted successfully.
    </div>

    <table>

        <tr>
            <td>Service Request Number</td>
            <td><%= requestNumber %></td>
        </tr>

        <tr>
            <td>Employee ID</td>
            <td><%= serviceRequest.getEmployeeId() %></td>
        </tr>

        <tr>
            <td>Employee Name</td>
            <td><%= serviceRequest.getEmployeeName() %></td>
        </tr>

        <tr>
            <td>Department</td>
            <td><%= serviceRequest.getDepartment() %></td>
        </tr>

        <tr>
            <td>Problem Category</td>
            <td><%= serviceRequest.getProblemCategory() %></td>
        </tr>

        <tr>
            <td>Priority</td>
            <td><%= serviceRequest.getPriority() %></td>
        </tr>

        <tr>
            <td>Problem Description</td>
            <td><%= serviceRequest.getProblemDescription() %></td>
        </tr>

    </table>

</div>

</body>
</html>