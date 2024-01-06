/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.InstructorDAO;
import Dal.StudentDAO;
import Dal.TeachingScheduleDAO;
import Model.ResponseModel.ActivityDetails;
import Model.ResponseModel.StudentAttendances;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AttendanceController extends HttpServlet {
    String courseParam= "course";
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
            out.println("<title>Servlet AttendaceController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendaceController at " + request.getContextPath() + "</h1>");
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
        String userID = session.getAttribute("userid").toString();
        String userRole = (String) session.getAttribute("userrole");
        switch (userRole) {
            case "1":
                StudentDAO sd = new StudentDAO();
                if (request.getParameter("semester") == null && request.getParameter(courseParam) == null) {
                    String currentSemester = sd.getCurrentSemesterID();
                    String courseID = sd.getSemesterCourses(userID, currentSemester).get(0).getId();
                    request.setAttribute("courses", sd.getSemesterCourses(userID, currentSemester));
                    request.setAttribute(courseParam, sd.getSemesterCourses(userID, currentSemester).get(0));
                    ArrayList<ActivityDetails> data = sd.getCourseAttendance(userID, currentSemester, courseID);
                    request.setAttribute("data", data);
                }
                request.getRequestDispatcher("Attendance.jsp").forward(request, response);
                break;
            case "2":
                InstructorDAO idao = new InstructorDAO();
                if (request.getParameter("slot") != null) {
                    TeachingScheduleDAO tsd = new TeachingScheduleDAO();
                    String slotID = request.getParameter("slot");
                    ArrayList<StudentAttendances> data = tsd.getStudentList(slotID, userID);
                    request.setAttribute("data", data);
                    request.getRequestDispatcher("../instructor/TakeAttendance.jsp").forward(request, response);

                } else {
                    ArrayList<ActivityDetails> data = idao.getInstructorDailyTimetable(userID);
                    request.setAttribute("data", data);
                    request.getRequestDispatcher("../instructor/Attendance.jsp").forward(request, response);
                }
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
        StudentDAO sd = new StudentDAO();
        HttpSession session = request.getSession();
        String userID = session.getAttribute("userid").toString();
        String currentSemester = sd.getCurrentSemesterID();
        String courseID = request.getParameter("selectCourse");
        request.setAttribute("courses", sd.getSemesterCourses(userID, currentSemester));
        request.setAttribute(courseParam, sd.getCourseByID(courseID));
        ArrayList<ActivityDetails> data = sd.getCourseAttendance(userID, currentSemester, courseID);
        request.setAttribute("data", data);
        request.getRequestDispatcher("Attendance.jsp").forward(request, response);
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
