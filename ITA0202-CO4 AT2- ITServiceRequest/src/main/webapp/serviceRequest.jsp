<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>IT Service Request</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f4f7;
        }

        .container {
            width: 500px;
            margin: 40px auto;
            background-color: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            text-align: center;
        }

        label {
            font-weight: bold;
        }

        input, select, textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        textarea {
            height: 100px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>IT Service Request Form</h2>

    <form action="ServiceRequestServlet" method="post">

        <label>Employee ID:</label>
        <input type="text" name="employeeId" required>

        <label>Employee Name:</label>
        <input type="text" name="employeeName" required>

        <label>Department:</label>
        <input type="text" name="department" required>

        <label>Problem Category:</label>
        <select name="problemCategory" required>
            <option value="">-- Select Category --</option>
            <option value="Network">Network</option>
            <option value="Software">Software</option>
            <option value="Hardware">Hardware</option>
            <option value="Account">Account</option>
            <option value="Other">Other</option>
        </select>

        <label>Problem Description:</label>
        <textarea name="problemDescription"
                  placeholder="Describe your problem"
                  required></textarea>

        <label>Priority:</label>
        <select name="priority" required>
            <option value="">-- Select Priority --</option>
            <option value="Low">Low</option>
            <option value="Medium">Medium</option>
            <option value="High">High</option>
        </select>

        <input type="submit" value="Submit Service Request">

    </form>

</div>

</body>
</html>