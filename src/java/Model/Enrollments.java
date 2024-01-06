/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Enrollments {
    private String id, studentID,groupID,totalSlot,totalAbsent;

    public Enrollments() {
    }

    public Enrollments(String id, String studentID, String groupID, String totalSlot, String totalAbsent) {
        this.id = id;
        this.studentID = studentID;
        this.groupID = groupID;
        this.totalSlot = totalSlot;
        this.totalAbsent = totalAbsent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getTotalSlot() {
        return totalSlot;
    }

    public void setTotalSlot(String totalSlot) {
        this.totalSlot = totalSlot;
    }

    public String getTotalAbsent() {
        return totalAbsent;
    }

    public void setTotalAbsent(String totalAbsent) {
        this.totalAbsent = totalAbsent;
    }
    
}
