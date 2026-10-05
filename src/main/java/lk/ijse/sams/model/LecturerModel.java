/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.LecturerDTO;

/**
 *
 * @author USER
 */
public class LecturerModel {
    
    public static boolean saveLecturer(lecturerDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "INSERT INTO lecturer(course_id, name, subjects, duration) VALUES (" + "'" + dto.getCourseId() + "', " + "'" + dto.getName() + "', "+ "'" + dto.getSubject() + "', "+ "'" + dto.getDuration() + "')";
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    }
    
}
