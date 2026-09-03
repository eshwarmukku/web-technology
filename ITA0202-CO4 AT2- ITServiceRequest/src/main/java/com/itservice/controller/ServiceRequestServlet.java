package com.itservice.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.itservice.model.ServiceRequest;

public class ServiceRequestServlet extends HttpServlet {

    private static int requestCounter = 1000;

    private static final List<ServiceRequest> serviceRequests =
            new ArrayList<>();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String employeeId = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String department = request.getParameter("department");
        String problemCategory = request.getParameter("problemCategory");
        String problemDescription = request.getParameter("problemDescription");
        String priority = request.getParameter("priority");

        if (employeeId == null || employeeId.trim().isEmpty() ||
            employeeName == null || employeeName.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            problemCategory == null || problemCategory.trim().isEmpty() ||
            problemDescription == null || problemDescription.trim().isEmpty() ||
            priority == null || priority.trim().isEmpty()) {

            request.setAttribute("error",
                    "All fields are mandatory. Please fill in all details.");

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("serviceRequest.jsp");

            dispatcher.forward(request, response);
            return;
        }

        employeeId = employeeId.trim();
        employeeName = employeeName.trim();
        department = department.trim();
        problemCategory = problemCategory.trim();
        problemDescription = problemDescription.trim();
        priority = priority.trim();

        String requestNumber = "SR-" + (++requestCounter);

        ZoneId istZone = ZoneId.of("Asia/Kolkata");

        LocalDateTime requestDate =
                LocalDateTime.now(istZone);

        ServiceRequest serviceRequest =
                new ServiceRequest(
                        requestNumber,
                        employeeId,
                        employeeName,
                        department,
                        problemCategory,
                        problemDescription,
                        priority,
                        requestDate
                );

        synchronized (serviceRequests) {
            serviceRequests.add(serviceRequest);
        }

        request.setAttribute("serviceRequest", serviceRequest);
        request.setAttribute("requestNumber", requestNumber);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("acknowledgement.jsp");

        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("serviceRequests", serviceRequests);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("report.jsp");

        dispatcher.forward(request, response);
    }

    public static List<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }
}