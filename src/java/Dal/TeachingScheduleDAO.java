/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Classrooms;
import Model.ResponseModel.StudentAttendances;
import Model.Students;
import Model.StudySlots;
import Model.TeachingSchedules;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TeachingScheduleDAO extends DBContext {

    public TeachingScheduleDAO() {
    }

    PreparedStatement pstm;
    ResultSet rs;

    public ArrayList<StudentAttendances> getStudentList(String slotID, String userID) {
        String currentDate = LocalDate.now().toString();
        String strSQL = "SELECT\n"
                + "s.pic_url,\n"
                + "s.student_code,\n"
                + "s.student_name,\n"
                + "atts.isAbsent\n"
                + "FROM AttendanceStatus atts, Enrollments e,Students s WHERE teaching_schedule_id = (\n"
                + "	SELECT teaching_schedule_id FROM TeachingSchedule WHERE teaching_date=? and slot_id=? and instructor_id=(\n"
                + "		SELECT instructor_id FROM Instructors WHERE user_id=?\n"
                + "		)\n"
                + "	)\n"
                + "and atts.enrollment_id=e.enrollment_id\n"
                + "and s.student_id=e.student_id";
        try {
            ArrayList<StudentAttendances> data = new ArrayList<>();
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, currentDate);
            pstm.setString(2, slotID);
            pstm.setString(3, userID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String picURL = rs.getString(1);
                String studentCode = rs.getString(2);
                String studentName = rs.getString(3);
                String isAbsent = rs.getString(4);
                StudentAttendances sa = new StudentAttendances(picURL, studentCode, studentName, isAbsent);
                data.add(sa);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("getStudentList: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<TeachingSchedules> getScheduleToUpdate(String instructorID, String selectedDate) {
        String strSQL = "select * from TeachingSchedule where\n"
                + "teaching_date=?\n"
                + "and instructor_id =?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, selectedDate);
            pstm.setString(2, instructorID);
            rs = pstm.executeQuery();
            ArrayList<TeachingSchedules> data = new ArrayList<>();
            while (rs.next()) {
                String teachingScheduleID = rs.getString(1);
                String ID = rs.getString(2);
                String groupID = rs.getString(3);
                String classroomID = rs.getString(4);
                String slot = rs.getString(5);
                String status = rs.getString(6);
                String teachingDate = rs.getString(7);
                String dayOfWeek = rs.getString(8);
                TeachingSchedules ts = new TeachingSchedules(teachingScheduleID, teachingDate, dayOfWeek, ID, groupID, classroomID, slot, status);
                data.add(ts);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("getScheduleToUpdate: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Classrooms> getClassroomList() {
        String strSQL = "SELECT * FROM Classrooms";
        try {
            pstm = connection.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            ArrayList<Classrooms> data = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString(1);
                String code = rs.getString(2);
                String buildingName = rs.getString(3);
                String capacity = rs.getString(4);
                Classrooms c = new Classrooms(id, code, buildingName, capacity);
                data.add(c);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("getClassroomList: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<StudySlots> getStudySlots() {
        String strSQL = "SELECT * FROM StudySlots";
        try {
            pstm = connection.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            ArrayList<StudySlots> data = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString(1);
                String timeStart = rs.getString(2);
                String timeEnd = rs.getString(3);
                StudySlots s = new StudySlots(id, timeStart, timeEnd);
                data.add(s);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("getStudySlots: ");
        }
        return null;
    }

    public String getGroupNameByID(String id) {
        String strSQL = "SELECT * FROM Groups WHERE group_id=?";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getString(2);
            }
        } catch (SQLException e) {
            System.out.println("getGroupNameByID: " + e.getMessage());
        }
        return null;
    }

    public boolean updateSchedule(String teachingScheduleID, String classroomID, String slot, String updatedDate) throws Exception{
        String strSQL = "BEGIN TRANSACTION;\n"
                + "\n"
                + "UPDATE TeachingSchedule\n"
                + "SET classroom_id = ?, slot_id = ?, teaching_date = ?\n"
                + "WHERE teaching_schedule_id = ?;\n"
                + "\n"
                + "IF @@ERROR <> 0\n"
                + "    ROLLBACK;\n"
                + "ELSE\n"
                + "    COMMIT;";
        try {
            pstm = connection.prepareStatement(strSQL);
            pstm.setString(1, classroomID);
            pstm.setString(2, slot);
            pstm.setString(3, updatedDate);
            pstm.setString(4, teachingScheduleID);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("updateSchedule" + e.getMessage());
            throw new Exception("Duplicate schedule");
        }
//        return false;
    }

}
