package com.itservice.model;

import java.time.LocalDateTime;

public class ServiceRequest {

    private String requestNumber;
    private String employeeId;
    private String employeeName;
    private String department;
    private String problemCategory;
    private String problemDescription;
    private String priority;
    private LocalDateTime requestDate;

    public ServiceRequest(String requestNumber,
                           String employeeId,
                           String employeeName,
                           String department,
                           String problemCategory,
                           String problemDescription,
                           String priority,
                           LocalDateTime requestDate) {

        this.requestNumber = requestNumber;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.problemCategory = problemCategory;
        this.problemDescription = problemDescription;
        this.priority = priority;
        this.requestDate = requestDate;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProblemCategory() {
        return problemCategory;
    }

    public void setProblemCategory(String problemCategory) {
        this.problemCategory = problemCategory;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
}