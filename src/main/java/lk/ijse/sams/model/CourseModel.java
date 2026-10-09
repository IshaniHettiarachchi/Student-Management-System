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
import lk.ijse.sams.dto.CourseDTO;


/**
 *
 * @author USER
 */
public class CourseModel {
    
     public static boolean saveCourse(CourseDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "INSERT INTO course(course_id, name, subjects, duration) VALUES (" + "'" + dto.getCourseId() + "', " + "'" + dto.getName() + "', "+ "'" + dto.getSubject() + "', "+ "'" + dto.getDuration() + "')";
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    }
    
     public static boolean updateCourse(CourseDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "UPDATE course SET " + "name = '" + dto.getName() + "', " + "subjects = '" + dto.getSubject() + "'," + "duration = '" + dto.getDuration() + "' "  + " WHERE course_id = '" + dto.getCourseId() + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    
    }
     
     public static boolean deleteCourse(String courseId) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "DELETE FROM course " + " WHERE course_id = '" + courseId + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
    }
    
    public static List<CourseDTO> getAllCourses() throws SQLException {

       String sql = "SELECT * FROM course";

       Connection connection = DBConnection.getInstance().getConnection();

       Statement stm = connection.createStatement();

       ResultSet rs = stm.executeQuery(sql);

       List<CourseDTO> courseList = new ArrayList<>();

       while (rs.next()) {

         CourseDTO dto = new CourseDTO(
                rs.getString("course_id"),
                rs.getString("name"),
                rs.getString("subjects"),
                rs.getString("duration")
        );

        courseList.add(dto);
    }

    return courseList;
    }
    
    public static List<String> getAllSubjects() throws SQLException {

       String sql = "SELECT subjects FROM course";

       Connection connection = DBConnection.getInstance().getConnection();

       Statement stm = connection.createStatement();

       ResultSet rs = stm.executeQuery(sql);

       List<String> subjectList = new ArrayList<>();

       while (rs.next()) {

         subjectList.add(rs.getString("subjects"));

       }

    return subjectList;
    }
      
    public static List<String> getAllCourseIds() throws SQLException {

       String sql = "SELECT course_id FROM course";

       Connection connection = DBConnection.getInstance().getConnection();

       Statement stm = connection.createStatement();

       ResultSet rs = stm.executeQuery(sql);

       List<String> courseList = new ArrayList<>();

       while (rs.next()) {

         courseList.add(rs.getString("course_id"));

       }

    return courseList;
    }
    
    
}
