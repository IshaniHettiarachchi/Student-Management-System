/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.AttendanceDTO;

/**
 *
 * @author USER
 */
public class AttendanceModel {
    
    public static boolean saveAttendance(AttendanceDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "INSERT INTO attendance(student_id, session_name, date, status) VALUES (" + "'" + dto.getStudentId() + "', "+ "'" + dto.getSessionName() + "', "+ "'" + dto.getDate() + "', " + "'" + dto.getStatus() + "')";
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    }
    
    public static boolean updateAttendance(AttendanceDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "UPDATE attendance SET " + "student_id = '" + dto.getStudentId() + "', " + "session_name = '" + dto.getSessionName() + "'," + "date = '" + dto.getDate() + "' " + "status = '" + dto.getStatus() + " WHERE student_id = '" + dto.getStudentId() + "'" + "AND session_name = '" + dto.getSessionName() + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
    }
    
    public static boolean deleteAttendance(String studentId, String sessionName) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "DELETE FROM attendance " + " WHERE student_id = '" + studentId + "'" + "AND session_name = '" + sessionName + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
    }
    
    public static List<AttendanceDTO> searchAttendance(String sessionName) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        List<AttendanceDTO> attendanceList = new ArrayList<>();

        if(connection != null){
           
           String sql = "SELECT * FROM attendance " + "WHERE session_name = '" + sessionName + "'";
           
           Statement stm = connection.createStatement();

           ResultSet rs = stm.executeQuery(sql);

           while (rs.next()) {

                AttendanceDTO dto = new AttendanceDTO(
                    rs.getString("student_id"),
                    rs.getString("session_name"),
                    rs.getString("date"),
                    rs.getString("status")

                 );

           attendanceList.add(dto);
           }
            rs.close();
            stm.close();
        }
        return attendanceList;
    }
    
    public static List<AttendanceDTO> searchAttendanceByStudentId(String studentId) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        List<AttendanceDTO> attendanceList = new ArrayList<>();

        if(connection != null){
           
           String sql = "SELECT * FROM attendance WHERE student_id = '"    + studentId + "'";  
           
           Statement stm = connection.createStatement();

           ResultSet rs = stm.executeQuery(sql);

           while (rs.next()) {

                AttendanceDTO dto = new AttendanceDTO(
                    rs.getString("student_id"),
                    rs.getString("session_name"),
                    rs.getString("date"),
                    rs.getString("status")

                 );

           attendanceList.add(dto);
           }
            rs.close();
            stm.close();
        }
        return attendanceList;
    }
    
     public static List<AttendanceDTO> getAllAttendance() throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        List<AttendanceDTO> attendanceList = new ArrayList<>();

        if(connection != null){
           
           String sql = "SELECT * FROM attendance ";
           
           Statement stm = connection.createStatement();

           ResultSet rs = stm.executeQuery(sql);

           while (rs.next()) {

                AttendanceDTO dto = new AttendanceDTO(
                    rs.getString("student_id"),
                    rs.getString("session_name"),
                    rs.getString("date"),
                    rs.getString("status")

                 );

           attendanceList.add(dto);
           }
        }
        return attendanceList;
    }
}

    

   
    
    
