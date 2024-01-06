/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dal.StudentDAO;

/**
 *
 * @author Admin
 */
public class Students {

    private String userID, studentID, majorID, code, studentName, gender, dob, picURL;

    public Students() {
    }

    public Students(String userID, String studentID, String majorID, String studentCode, String studentName, String gender, String dob, String picURL) {
        this.userID = userID;
        this.studentID = studentID;
        this.majorID = majorID;
        this.code = studentCode;
        this.studentName = studentName;
        this.gender = gender;
        this.dob = dob;
        this.picURL = picURL;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getMajorName(){
        StudentDAO sd= new StudentDAO();
        return sd.getMajor(majorID);
    }
    
}
