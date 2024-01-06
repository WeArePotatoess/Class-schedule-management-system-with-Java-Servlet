package Controller;

import Dal.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * class chua cac xu ly cho Servlet1
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {
    String sesstionIDAttribute="sessionid";
    String userIDAttribute="userid";
    String userRoleAttribute="userrole";
    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if (request.getParameter("login") != null) {
                String username = request.getParameter("logusername");
                String password = request.getParameter("logpass");
                UserDAO u = new UserDAO();
                if (u.checkLogin(username, password) != null) {
                    HttpSession session = request.getSession();
                    String sessionid = session.getId();
                    session.setAttribute(sesstionIDAttribute, sessionid);
                    String userID = u.getUserID(username);
                    session.setAttribute(userIDAttribute, userID);
                    String userRole = u.getUserRole(userID);
                    session.setAttribute(userRoleAttribute, userRole);
                    response.sendRedirect("home");
                } else {
                    request.setAttribute("loginerror", "Incorrect user name or password!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (session.getAttribute(sesstionIDAttribute) != null) {
                session.removeAttribute(sesstionIDAttribute);
            }
            if (session.getAttribute(userIDAttribute) != null) {
                session.removeAttribute(userIDAttribute);
            }
            if (session.getAttribute(userRoleAttribute) != null) {
                session.removeAttribute(userRoleAttribute);
            }
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
