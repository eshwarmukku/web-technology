package com.itservice.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.itservice.model.ServiceRequest;

import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Phrase;
import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfWriter;

public class DownloadReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf");

        response.setHeader(
            "Content-Disposition",
            "attachment; filename=IT_Service_Request_Report.pdf"
        );

        Document document = new Document();

        try {

            PdfWriter.getInstance(
                document,
                response.getOutputStream()
            );

            document.open();

            Font titleFont =
                FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 18
                );

            Font headerFont =
                FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 8
                );

            Font normalFont =
                FontFactory.getFont(
                    FontFactory.HELVETICA, 7
                );

            Paragraph title =
                new Paragraph(
                    "IT Service Request Report",
                    titleFont
                );

            title.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(title);

            document.add(
                new Paragraph(
                    "Date and Time: IST (Asia/Kolkata)"
                )
            );

            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(8);

            table.setWidthPercentage(100);

            String[] headers = {
                "Request No.",
                "Employee ID",
                "Name",
                "Department",
                "Category",
                "Description",
                "Priority",
                "Date & Time"
            };

            for (String header : headers) {

                PdfPCell cell =
                    new PdfPCell(
                        new Phrase(header, headerFont)
                    );

                table.addCell(cell);
            }

            List<ServiceRequest> serviceRequests =
                ServiceRequestServlet.getServiceRequests();

            DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy hh:mm a"
                );

            synchronized (serviceRequests) {

                for (ServiceRequest serviceRequest :
                     serviceRequests) {

                    table.addCell(
                        new Phrase(
                            serviceRequest.getRequestNumber(),
                            normalFont
                        )
                    );

                    table.addCell(
                        new Phrase(
                            serviceRequest.getEmployeeId(),
                            normalFont
                        )
                    );

                    table.addCell(
                        new Phrase(
                            serviceRequest.getEmployeeName(),
                            normalFont
                        )
                    );

                    table.addCell(
                        new Phrase(
                            serviceRequest.getDepartment(),
                            normalFont
                        )
                    );

                    table.addCell(
                        new Phrase(
                            serviceRequest.getProblemCategory(),
                            normalFont
                        )
                    );

                    table.addCell(
                        new Phrase(
                            serviceRequest.getProblemDescription(),
                            normalFont
                        )
                    );

                    table.addCell(
                        new Phrase(
                            serviceRequest.getPriority(),
                            normalFont
                        )
                    );

                    table.addCell(
                        new Phrase(
                            serviceRequest.getRequestDate()
                                .format(formatter)
                                + " IST",
                            normalFont
                        )
                    );
                }
            }

            document.add(table);

        } catch (DocumentException e) {

            throw new ServletException(
                "Error creating PDF",
                e
            );

        } finally {

            document.close();
        }
    }
}