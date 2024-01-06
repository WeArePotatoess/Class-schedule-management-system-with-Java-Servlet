/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Instructors;
import Model.ResponseModel.ActivityDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class InstructorDAO extends DBContext {

    public InstructorDAO() {
    }
    PreparedStatement pstm;
    ResultSet rs;

    public Instructors getInstructorInfor(String userID) {
        String strSQL = "SELECT * FROM Instructors where user_id=?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, userID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userid = rs.getString(1);
                String instructorID = rs.getString(2);
                String fullname = rs.getString(3);
                String gender = rs.getString(4);
                String picURL = rs.getString(5);
                String departmentID = rs.getString(6);
                Instructors i = new Instructors(userid, instructorID, fullname, gender, picURL, departmentID);
                return i;
            }
        } catch (SQLException e) {
            System.out.println("getInfor: " + e.getMessage());
        }
        return null;
    }

    private LocalDate getFirstDateOfWeek(LocalDate currentDate) {
        LocalDate firstDateOfWeek = currentDate;
        String currentDay = currentDate.getDayOfWeek().toString();
        switch (currentDay) {
            case "MONDAY":
                break;
            case "TUESDAY":
                firstDateOfWeek = currentDate.minusDays(1);
                break;
            case "WEDNESDAY":
                firstDateOfWeek = currentDate.minusDays(2);
                break;
            case "THURSDAY":
                firstDateOfWeek = currentDate.minusDays(3);

                break;
            case "FRIDAY":
                firstDateOfWeek = currentDate.minusDays(4);

                break;
            case "SATURDAY":
                firstDateOfWeek = currentDate.minusDays(5);

                break;
            case "SUNDAY":
                firstDateOfWeek = currentDate.minusDays(6);
                break;
            default:
                break;
        }
        return firstDateOfWeek;
    }

    public ArrayList<ActivityDetails> getInstructorWeeklyTimeTable(LocalDate currentDate, String userID) {
        LocalDate firstDateOfWeek = getFirstDateOfWeek(currentDate);
        ArrayList<ActivityDetails> data = new ArrayList<>();
        String strSQL = "Select \n"
                + "ts.teaching_date, ts.day_of_week,room.classroom_code,ts.slot_id,g.group_name,ts.status,i.fullname,c.course_name,c.course_code,0,s.time_end,s.time_start\n"
                + "from TeachingSchedule ts, Classrooms room, Groups g, StudySlots s,Instructors i, Courses c\n"
                + "where  teaching_date>=? and teaching_date<= DATEADD(DAY,6,?)\n"
                + "and ts.instructor_id = (select instructor_id from Instructors where user_id=?)\n"
                + "and ts.classroom_id=room.classroom_id\n"
                + "and ts.group_id=g.group_id\n"
                + "and ts.slot_id=s.slot_id\n"
                + "and i.instructor_id=ts.instructor_id\n"
                + "and c.course_id=g.course_id";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, firstDateOfWeek.toString());
            pstm.setString(2, firstDateOfWeek.toString());
            pstm.setString(3, userID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String actDate = rs.getString(1);
                String dayOfWeek = rs.getString(2);
                String classroom = rs.getString(3);
                String slotID = rs.getString(4);
                String groupName = rs.getString(5);
                String status = rs.getString(6);
                String instructorName = rs.getString(7);
                String courseName = rs.getString(8);
                String courseCode = rs.getString(9);
                String isAbsent = rs.getString(10);
                String timeEnd = rs.getString(11);
                String timeStart = rs.getString(12);
                ActivityDetails act = new ActivityDetails(actDate, dayOfWeek, classroom, slotID, groupName, status, instructorName, courseName, courseCode, isAbsent, timeStart, timeEnd);
                data.add(act);
            }
        } catch (SQLException e) {
            System.out.println("getInstructorWeeklyTimeTable: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<ActivityDetails> getInstructorDailyTimetable(String userID) {
        LocalDate currentDate = LocalDate.now();
        String strSQL = "Select \n"
                + "ts.teaching_date, ts.day_of_week,room.classroom_code,ts.slot_id,g.group_name,ts.status,i.fullname,c.course_name,c.course_code,0,s.time_end,s.time_start\n"
                + "from TeachingSchedule ts, Classrooms room, Groups g, StudySlots s,Instructors i, Courses c\n"
                + "where  teaching_date=?\n"
                + "and ts.instructor_id = (select instructor_id from Instructors where user_id=?)\n"
                + "and ts.classroom_id=room.classroom_id\n"
                + "and ts.group_id=g.group_id\n"
                + "and ts.slot_id=s.slot_id\n"
                + "and i.instructor_id=ts.instructor_id\n"
                + "and c.course_id=g.course_id";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, currentDate.toString());
            pstm.setString(2, userID);
            rs = pstm.executeQuery();
            ArrayList<ActivityDetails> data = new ArrayList<>();
            while (rs.next()) {
                String room = rs.getString(3);
                String slot = rs.getString(4);
                String group = rs.getString(5);
                String courseName = rs.getString(8);
                String courseCode = rs.getString(9);
                String timeEnd = rs.getString(11);
                String timeStart = rs.getString(12);
                ActivityDetails ad = new ActivityDetails(room, slot, group, courseName, courseCode, timeStart, timeEnd);
                data.add(ad);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("getInstructorDailyTimetable: " + e.getMessage());
        }
        return null;
    }

}
