/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.ResponseModel;

/**
 *
 * @author Admin
 */
public class ActivityDetails {

    private String actDate, dayOfWeek, classroom, slot, studentGroup, status, instructor, courseName, courseCode, isAbsent, timeStart, timeEnd;

    public ActivityDetails() {
    }

    public ActivityDetails(String classroom, String slot, String studentGroup, String courseName, String courseCode, String timeStart, String timeEnd) {
        this.classroom = classroom;
        this.slot = slot;
        this.studentGroup = studentGroup;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public ActivityDetails(String actDate, String dayOfWeek, String classroom, String slot, String studentGroup, String status, String instructor, String courseName, String courseCode, String isAbsent, String timeStart, String timeEnd) {
        this.actDate = actDate;
        this.dayOfWeek = dayOfWeek;
        this.classroom = classroom;
        this.slot = slot;
        this.studentGroup = studentGroup;
        this.status = status;
        this.instructor = instructor;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.isAbsent = isAbsent;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getActDate() {
        return actDate;
    }

    public void setActDate(String actDate) {
        this.actDate = actDate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getIsAbsent() {
        if (status.equals("0")) {
            return "Not yet";
        } else if (isAbsent.equals("1")) {
            return "Absent";
        } else {
            return "Attended";
        }
    }

    public void setIsAbsent(String isAbsent) {
        this.isAbsent = isAbsent;
    }

    public String getTimeStart() {
        String[] s = timeStart.split(":");
        String formartedTime = s[0] + ":" + s[1];
        return formartedTime;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        String[] s = timeEnd.split(":");
        String formartedTime = s[0] + ":" + s[1];
        return formartedTime;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

}
