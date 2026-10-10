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
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author USER
 */
public class StudentModel {
    
    public static boolean saveStudent(StudentDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "INSERT INTO student(student_id, name, email, course_id, contact) VALUES (" + "'" + dto.getStudentId() + "', " + "'" + dto.getName() + "', "+ "'" + dto.getEmail() + "', "+ "'" + dto.getCourseId() + "', "+ "'" + dto.getContact() + "')";
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    }
    
    public static List<StudentDTO> getAllStudents() throws SQLException {

    String sql = "SELECT * FROM student";

    Connection connection = DBConnection.getInstance().getConnection();

    Statement stm = connection.createStatement();

    ResultSet rs = stm.executeQuery(sql);

    List<StudentDTO> studentList = new ArrayList<>();

    while (rs.next()) {

        StudentDTO dto = new StudentDTO(
                rs.getString("student_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("course_id"),
                rs.getString("contact")
        );

        studentList.add(dto);
    }

    return studentList;
    }
    
    public static boolean updateStudent(StudentDTO dto)throws SQLException{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "UPDATE student SET " + "name = '" + dto.getName() + "', " + "email = '" + dto.getEmail() + "'," + "course_id = '" + dto.getCourseId() + "', " + "contact = '" + dto.getContact() + "' " + " WHERE student_id = '" + dto.getStudentId() + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
        
    
    }
    
    public static boolean deleteStudent(String studentId) throws SQLException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        if(connection != null){
          String sql = "DELETE FROM student " + " WHERE student_id = '" + studentId + "'"; 
            
          Statement stm = connection.createStatement();
          
          int result = stm.executeUpdate(sql);
          return result > 0;
        }
        return false;
    }
    
    public static List<String> getAllStudentIds() throws SQLException {

       String sql = "SELECT student_id FROM student";

       Connection connection = DBConnection.getInstance().getConnection();

       Statement stm = connection.createStatement();

       ResultSet rs = stm.executeQuery(sql);

       List<String> studentList = new ArrayList<>();

       while (rs.next()) {

         studentList.add(rs.getString("student_id"));

       }

    return studentList;
    }
    
}
