/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Courses;
import Model.ResponseModel.ActivityDetails;
import Model.Semesters;
import Model.Students;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentDAO extends DBContext {

    public StudentDAO() {
    }

    PreparedStatement pstm;
    ResultSet rs;

    public Students getInfor(String parameter) {
        String strSQL = "Select * from Students where user_id=?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, parameter);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String studentID = rs.getString(2);
                String majorID = rs.getString(3);
                String studentCode = rs.getString(4);
                String studentName = rs.getString(5);
                String gender = rs.getString(6);
                String dob = rs.getString(7);
                String picURL = rs.getString(8);
                Students s = new Students(userID, studentID, majorID, studentCode, studentName, gender, dob, picURL);
//                System.out.println(s);
                return s;
            }

        } catch (SQLException e) {
            System.out.println("getInfor: " + e.getMessage());
        }
        return null;
    }

    public String getMajor(String majorID) {
        String strSQL = "Select * from Majors where major_id=?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, majorID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getString(2);
            }
        } catch (SQLException e) {
            System.out.println("getMajor: " + e.getMessage());
        }
        return null;
    }

    public LocalDate getFirstDateOfWeek(LocalDate currentDate) {
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

    public ArrayList<ActivityDetails> getCurrentWeeklyTimetable(LocalDate currentDate, String userID) {
        LocalDate firstDateOfWeek = getFirstDateOfWeek(currentDate);
        ArrayList<ActivityDetails> data = new ArrayList<>();
        String strSQL = "SELECT ts.teaching_date,\n"
                + "	ts.day_of_week,\n"
                + "	room.classroom_code,\n"
                + "	ts.slot_id,\n"
                + "	g.group_name,\n"
                + "	ts.status,\n"
                + "	i.fullname,\n"
                + "	c.course_name,\n"
                + "	c.course_code, \n"
                + "	atts.isAbsent,\n"
                + "	s.time_end,\n"
                + "	s.time_start\n"
                + "FROM TeachingSchedule ts, Groups g, Enrollments e,StudySlots s,Courses c, Instructors i ,AttendanceStatus atts, Classrooms room\n"
                + "WHERE teaching_date>=? and teaching_date<= DATEADD(DAY,6,?)\n"
                + "and g.group_id=ts.group_id and \n"
                + "e.student_id = (\n"
                + "	select student_id from Students WHERE user_id=?)\n"
                + "and s.slot_id=ts.slot_id\n"
                + "and atts.enrollment_id=e.enrollment_id\n"
                + "and atts.teaching_schedule_id=ts.teaching_schedule_id\n"
                + "and c.course_id=g.course_id\n"
                + "and i.instructor_id=ts.instructor_id\n"
                + "and room.classroom_id=ts.classroom_id\n"
                + "order by ts.teaching_schedule_id";
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
            System.out.println("getCurrentWeeklyTimetable: " + e.getMessage());
        }
        return data;
    }

    public String getCurrentSemesterID() {
        LocalDate currentDate = LocalDate.now();
        String strSQL = "select semester_id from Semesters where date_start<=? and date_end>=?";
        String semesterID = "";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, currentDate.toString());
            pstm.setString(2, currentDate.toString());
            rs = pstm.executeQuery();
            while (rs.next()) {
                semesterID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("getCurrentSemesterID: " + e.getMessage());
        }
        return semesterID;
    }

    public ArrayList<Courses> getSemesterCourses(String userID, String semesterID) {
        String strSQL = "Select * from Courses where course_id in (\n"
                + "select course_id from Groups where group_id in (\n"
                + "select group_id from Enrollments where\n"
                + "student_id=(select student_id from Students where user_id=?)\n"
                + "and group_id in (select group_id from Groups where semester_id=?)\n"
                + ")\n"
                + ")";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, userID);
            pstm.setString(2, semesterID);
            rs = pstm.executeQuery();
            ArrayList<Courses> courses = new ArrayList<>();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String courseName = rs.getString(2);
                String courseCode = rs.getString(3);
                String departmentID = rs.getString(4);
                Courses c = new Courses(courseID, courseName, courseCode, departmentID);
                courses.add(c);
            }
            return courses;
        } catch (SQLException e) {
            System.out.println("getSemesterCourses: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<ActivityDetails> getCourseAttendance(String userID, String semester, String courseID) {
        String strSQL = "SELECT ts.teaching_date,\n"
                + "	ts.day_of_week,\n"
                + "	room.classroom_code,\n"
                + "	ts.slot_id,\n"
                + "	g.group_name,\n"
                + "	ts.status,\n"
                + "	i.fullname,\n"
                + "	c.course_name,\n"
                + "	c.course_code, \n"
                + "	atts.isAbsent,\n"
                + "	s.time_end,\n"
                + "	s.time_start\n"
                + "FROM TeachingSchedule ts, Groups g, Enrollments e,StudySlots s,Courses c, Instructors i ,AttendanceStatus atts, Classrooms room\n"
                + "WHERE\n"
                + "g.group_id=ts.group_id and \n"
                + "e.student_id = (\n"
                + "	select student_id from Students WHERE user_id=?)\n"
                + "and s.slot_id=ts.slot_id\n"
                + "and atts.enrollment_id=e.enrollment_id\n"
                + "and atts.teaching_schedule_id=ts.teaching_schedule_id\n"
                + "and c.course_id=g.course_id\n"
                + "and i.instructor_id=ts.instructor_id\n"
                + "and room.classroom_id=ts.classroom_id\n"
                + "and c.course_id=?\n"
                + "and g.semester_id=?\n"
                + "order by ts.teaching_date";
        try {
            ArrayList<ActivityDetails> data = new ArrayList<>();
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, userID);
            pstm.setString(2, courseID);
            pstm.setString(3, semester);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String teachingDate = rs.getString(1);
                String dayOfWeek = rs.getString(2);
                String classroom = rs.getString(3);
                String slot = rs.getString(4);
                String group = rs.getString(5);
                String status = rs.getString(6);
                String instructor = rs.getString(7);
                String courseName = rs.getString(8);
                String courseCode = rs.getString(9);
                String isAbsent = rs.getString(10);
                String timeEnd = rs.getString(11);
                String timeStart = rs.getString(12);
                ActivityDetails act = new ActivityDetails(teachingDate, dayOfWeek, classroom, slot, group, status, instructor, courseName, courseCode, isAbsent, timeStart, timeEnd);
                data.add(act);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("getCourseAttendance: " + e.getMessage());
            return null;
        }
    }

    public Courses getCourseByID(String courseID) {
        String strSQL = "Select * from Courses where course_id =?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, courseID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String code = rs.getString(3);
                String departmentID = rs.getString(4);
                Courses c = new Courses(id, name, code, departmentID);
                return c;
            }
        } catch (SQLException e) {
            System.out.println("getCourseByID: " + e.getMessage());
        }
        return null;
    }

    public Semesters getCurrentSemester(LocalDate currentDate) {
        String strSQL = "SELECT * FROM Semesters WHERE date_start<= ? and date_end>= ?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, currentDate.toString());
            pstm.setString(2, currentDate.toString());
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String dateStart = rs.getString(3);
                String dateEnd = rs.getString(4);
                Semesters s = new Semesters(id, name, dateStart, dateEnd);
                return s;
            }
        } catch (SQLException e) {
            System.out.println("getCurrentSemester: " + e.getMessage());
        }
        return null;
    }
}
