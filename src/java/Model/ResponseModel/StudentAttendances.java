/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.ResponseModel;

/**
 *
 * @author Admin
 */
public class StudentAttendances {
    private String picURL,studentCode,studentName,isAbsent;

    public StudentAttendances() {
    }

    public StudentAttendances(String picURL, String studentCode, String studentName, String isAbsent) {
        this.picURL = picURL;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.isAbsent = isAbsent;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(String isAbsent) {
        this.isAbsent = isAbsent;
    }
    
}
