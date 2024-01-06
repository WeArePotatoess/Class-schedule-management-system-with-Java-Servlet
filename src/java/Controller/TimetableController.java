/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.InstructorDAO;
import Dal.StudentDAO;
import Model.ResponseModel.ActivityDetails;
import Model.Semesters;
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
public class TimetableController extends HttpServlet {

    String changedDateAttribute = "changedDate";
    String weekChangedAttribute = "week-changed";

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
            out.println("<title>Servlet TimetableController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimetableController at " + request.getContextPath() + "</h1>");
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
        LocalDate currentDate;
        if (request.getAttribute(changedDateAttribute) == null) {
            currentDate = LocalDate.now();
        } else {
            currentDate = LocalDate.parse((CharSequence) request.getAttribute(changedDateAttribute));
        }
        String userID = session.getAttribute("userid").toString();
        String userRole = (String) session.getAttribute("userrole");
        ArrayList<ActivityDetails> data;
        switch (userRole) {
            case "1":
                StudentDAO sd = new StudentDAO();
                Semesters s = sd.getCurrentSemester(currentDate);
                LocalDate currentD = LocalDate.parse((CharSequence) s.getStartDate());
                LocalDate lastDateOfSemester = LocalDate.parse((CharSequence) s.getEndDate());
//                String selectedWeek=currentDate
                ArrayList<String> weeks = new ArrayList<>();
                while (currentD.isBefore(lastDateOfSemester)) {
                    weeks.add(currentD.toString() + "/" + currentD.plusDays(6).toString());
                    currentD = currentD.plusDays(7);
                }
                request.setAttribute("weeks", weeks);
                data = sd.getCurrentWeeklyTimetable(currentDate, userID);
                request.setAttribute("date", currentDate.toString());
                request.setAttribute("data", data);
                request.getRequestDispatcher("WeeklyTimetable.jsp").forward(request, response);
                break;
            case "2":
                InstructorDAO idao = new InstructorDAO();
                data = idao.getInstructorWeeklyTimeTable(currentDate, userID);
                request.setAttribute("date", currentDate.toString());
                request.setAttribute("data", data);
                request.getRequestDispatcher("../instructor/InstructorWeeklyTimetable.jsp").forward(request, response);
                break;
            default:
                break;
        }
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
        String selectedDate = "";
        if (request.getParameter("date-changed") != null) {
            selectedDate = request.getParameter("date-changed");
        }
        if (request.getParameter(weekChangedAttribute) != null) {
            String selectedWeek = request.getParameter(weekChangedAttribute);
            selectedDate = request.getParameter(weekChangedAttribute).split("[/]")[0];
            request.setAttribute("selectedWeek", selectedWeek);
        }
        request.setAttribute(changedDateAttribute, selectedDate);
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
