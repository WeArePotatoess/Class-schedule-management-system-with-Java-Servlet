/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dal.TeachingScheduleDAO;

/**
 *
 * @author Admin
 */
public class TeachingSchedules {

    private String teachingScheduleID, teachingDate, dayOfWeek, instructorID, groupID, classroomID, slot, status;

    public TeachingSchedules() {
    }

    public TeachingSchedules(String teachingScheduleID, String teachingDate, String dayOfWeek, String instructorID, String groupID, String classroomID, String slot, String status) {
        this.teachingScheduleID = teachingScheduleID;
        this.teachingDate = teachingDate;
        this.dayOfWeek = dayOfWeek;
        this.instructorID = instructorID;
        this.groupID = groupID;
        this.classroomID = classroomID;
        this.slot = slot;
        this.status = status;
    }

    public String getTeachingScheduleID() {
        return teachingScheduleID;
    }

    public void setTeachingScheduleID(String teachingScheduleID) {
        this.teachingScheduleID = teachingScheduleID;
    }

    public String getTeachingDate() {
        return teachingDate;
    }

    public void setTeachingDate(String teachingDate) {
        this.teachingDate = teachingDate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroupName() {
        TeachingScheduleDAO tsd = new TeachingScheduleDAO();
        return tsd.getGroupNameByID(groupID);
    }
}
