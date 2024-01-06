/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.TeachingScheduleDAO;
import Model.Classrooms;
import Model.StudySlots;
import Model.TeachingSchedules;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UpdateSchedule extends HttpServlet {

    String selectedDateAttribute = "selectedDate";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateSchedule</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateSchedule at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userRole = (String) session.getAttribute("userrole");
        if (!userRole.equals("3")) {
            response.sendRedirect("home");
        }
        if (request.getAttribute(selectedDateAttribute) == null) {
            String currentDate = LocalDate.now().toString();
            request.setAttribute(selectedDateAttribute, currentDate);
        }
        request.getRequestDispatcher("../admin/UpdateSchedule.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeachingScheduleDAO tsd = new TeachingScheduleDAO();
        if (request.getParameter("update") != null) {
            String teachingScheduleID = request.getParameter("teachingScheduleID");
            String classroomID = request.getParameter("classroom");
            String slot = request.getParameter("slot");
            String updatedDate = request.getParameter("updatedDate");
            try {
                if (tsd.updateSchedule(teachingScheduleID, classroomID, slot, updatedDate)) {
                    request.setAttribute("notification", "Update Successful!");
                }
            } catch (Exception e) {
                request.setAttribute("notification", e.getMessage());
            }

        }

        if (request.getParameter("form1Submit") != null) {
            String instructorID = request.getParameter("instructorid");
            request.setAttribute("selectedInstructorID", instructorID);
            String selectedDate = request.getParameter("date");
            request.setAttribute(selectedDateAttribute, selectedDate);
            ArrayList<TeachingSchedules> data = tsd.getScheduleToUpdate(instructorID, selectedDate);
            request.setAttribute("data", data);
            ArrayList<Classrooms> classrooms = tsd.getClassroomList();
            request.setAttribute("classrooms", classrooms);
            ArrayList<StudySlots> slots = tsd.getStudySlots();
            request.setAttribute("slots", slots);
        }
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
