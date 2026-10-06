/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.CourseDTO;
import lk.ijse.sams.dto.LecturerDTO;

/**
 *
 * @author USER
 */
public class LecturerModel {
    
    public static boolean saveLecturer(LecturerDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "INSERT INTO lecturer(lecturer_id, name, email, subject) VALUES (" + "'" + dto.getLecturerId() + "', " + "'" + dto.getName() + "', "+ "'" + dto.getEmail() + "', "+ "'" + dto.getSubject() + "')";
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    }
    
     public static boolean updateLecturer(LecturerDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "UPDATE lecturer SET " + "name = '" + dto.getName() + "', " + "subjects = '" + dto.getSubject() + "'," + " WHERE lecturer_id = '" + dto.getLecturerId() + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    
    }
    
}
