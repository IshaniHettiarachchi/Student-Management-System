/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.dao.custom.StudentDAO;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.StudentDTO;
/**
 *
 * @author USER
 */
public class StudentDAOImpl implements StudentDAO{
    
@Override 
public boolean save(StudentDTO dto) throws SQLException {  
String sql = "INSERT INTO student " + "(student_id, name, email, course_id, contact) " + "VALUES (?, ?, ?, ?, ?)";

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, dto.getStudentId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getEmail());
        pstm.setString(4, dto.getCourseId());
        pstm.setString(5, dto.getContact());

        return pstm.executeUpdate() > 0;
    }
}

@Override
public List<StudentDTO> getAll() throws SQLException {

    String sql = "SELECT student_id, name, email, course_id, contact " + "FROM student";

    List<StudentDTO> studentList = new ArrayList<>();

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

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
    }

    return studentList;
}

@Override
public boolean update(StudentDTO dto) throws SQLException {

    String sql = "UPDATE student SET name = ?, email = ?, " + "course_id = ?, contact = ? WHERE student_id = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getEmail());
        pstm.setString(3, dto.getCourseId());
        pstm.setString(4, dto.getContact());
        pstm.setString(5, dto.getStudentId());

        return pstm.executeUpdate() > 0;
    }
}

@Override
public boolean delete(String studentId) throws SQLException {

    String sql = "DELETE FROM student WHERE student_id = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm =
                 connection.prepareStatement(sql)) {

        pstm.setString(1, studentId);

        return pstm.executeUpdate() > 0;
    }
}

@Override
public List<String> getAllStudentIds() throws SQLException {

    String sql = "SELECT student_id FROM student";

    List<String> studentIds = new ArrayList<>();

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {
            studentIds.add(rs.getString("student_id"));
        }
    }

    return studentIds;
}

}

