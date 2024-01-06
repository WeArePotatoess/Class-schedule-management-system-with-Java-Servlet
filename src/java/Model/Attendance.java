/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Attendance {

    private String teachingScheduleID, isAbsent, enrollmentID;

    public Attendance() {
    }

    public Attendance(String teachingScheduleID, String isAbsent, String enrollmentID) {
        this.teachingScheduleID = teachingScheduleID;
        this.isAbsent = isAbsent;
        this.enrollmentID = enrollmentID;
    }

    public String getTeachingScheduleID() {
        return teachingScheduleID;
    }

    public void setTeachingScheduleID(String teachingScheduleID) {
        this.teachingScheduleID = teachingScheduleID;
    }

    public String getIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(String isAbsent) {
        this.isAbsent = isAbsent;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }


}
