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
import lk.ijse.sams.dto.ClassSchedulingDTO;
import lk.ijse.sams.model.CourseModel;
import lk.ijse.sams.model.LecturerModel;


/**
 *
 * @author USER
 */
public class ClassSchedulingModel {
    
    public static boolean saveClassScheduling(ClassSchedulingDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "INSERT INTO class_schedule(session_name, course_id, subject, lecturer_id, date, start_time, end_time) VALUES (" + "'" + dto.getSessionName() + "', " + "'" + dto.getCourseId() + "', "+ "'" + dto.getSubject() + "', "+ "'" + dto.getLecturerId() + "', " + "'" + dto.getDate() + "'," + "'" + dto.getStartTime() + "'," + "'" + dto.getEndTime() + "')";
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    }
    
    public static boolean updateClassScheduling(ClassSchedulingDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "UPDATE class_schedule SET " + "course_id = '" + dto.getCourseId() + "', " + "subject = '" + dto.getSubject() + "'," + "lecturer_id = '" + dto.getLecturerId() + "' " + "date = '" + dto.getDate() + "start_time = '" + dto.getStartTime() + "end_time = '" + dto.getEndTime() + " WHERE session_name = '" + dto.getSessionName() + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    
    }
    
    public static boolean deleteClassScheduling(String sessionName) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "DELETE FROM class_schedule " + " WHERE session_name = '" + sessionName + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
    }
    
    public static List<ClassSchedulingDTO> getAllclassScheduling() throws SQLException {

        String sql = "SELECT * FROM class_schedule";

        Connection connection = DBConnection.getInstance().getConnection();

        Statement stm = connection.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<ClassSchedulingDTO> classList = new ArrayList<>();

        while (rs.next()) {

             ClassSchedulingDTO dto = new ClassSchedulingDTO(
                rs.getString("session_name"),
                rs.getString("course_id"),
                rs.getString("subject"),
                rs.getString("lecturer_id"),
                rs.getString("date"),
                rs.getString("start_time"),
                rs.getString("end_time")
                
        );

        classList.add(dto);
        }

       return classList;
    }
    
    public static ClassSchedulingDTO searchClassSchedule(String sessionName) throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
             
            String sql = "SELECT * FROM class_schedule " + "WHERE session_name = '" + sessionName + "'";
            
            Statement stm = connection.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()){
            
                ClassSchedulingDTO dto = new ClassSchedulingDTO(rs.getString("session_name"), rs.getString("course_id"), rs.getString("subject"), rs.getString("lecturer_id"), rs.getString("date"), rs.getString("start_time"), rs.getString("end_time"));
                
                return dto;
            }
            
            
        }

        return null;
    }
    
}
