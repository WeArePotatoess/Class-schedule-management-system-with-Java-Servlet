/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext {

    public UserDAO() {
    }

    PreparedStatement pstm;
    ResultSet rs;

    public Users checkLogin(String username, String password) {
        String strSQL = "SELECT * FROM Users WHERE username=? and password =?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String id = rs.getString(1);
                String us = rs.getString(2);
                String pass = rs.getString(3);
                Users u = new Users(id, username, password);
                return u;
            }
        } catch (SQLException e) {
            System.out.println("checkLogin: " + e.getMessage());
        }
        return null;
    }

    public String getUserID(String username) {
        String strSQL = "Select * from Users where username = ?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            String id = "";
            while (rs.next()) {
                id = rs.getString(1);
            }
            return id;

        } catch (SQLException e) {
            System.out.println("getUserID: " + e.getMessage());
            return null;
        }
    }

    public String getUserRole(String userID) {
        String strSQL = "select role_id from User_Role where user_id=?";
        String userRole = "";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, userID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                userRole = rs.getString(1);
                return userRole;
            }
        } catch (SQLException e) {
            System.out.println("getUserRole: " + e.getMessage());
        }
        return userRole;
    }

}
