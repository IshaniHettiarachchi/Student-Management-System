/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author USER
 */
public class StudentModel {
    
    public static boolean savestudent(StudentDTO dto)throws SQLException{
        
        String sql = "INSERT INTO student" + "(student_id, name, email, course_id, contact)" + "VALUES(?, ?, ?, ?, ?)";
        
        Connection connection = DBConnection.getInstance().getConnection();
        
         PreparedStatement pst = connection.prepareStatement(sql);

        pst.setString(1, dto.getStudentId());
        pst.setString(2, dto.getName());
        pst.setString(3, dto.getEmail());
        pst.setString(4, dto.getCourseId());
        pst.setString(5, dto.getContact());

        return pst.executeUpdate() > 0;
    }
    
    public static List<StudentDTO> getAllStudents() throws SQLException {

    String sql = "SELECT * FROM student";

    Connection connection = DBConnection.getInstance().getConnection();

    PreparedStatement pst = connection.prepareStatement(sql);

    ResultSet rs = pst.executeQuery();

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
    
}
