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
import lk.ijse.sams.dao.custom.CourseDAO;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.CourseDTO;
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author USER
 */
public class CourseDAOImpl implements CourseDAO{
    
@Override
public boolean save(CourseDTO dto) throws SQLException {
    
    String sql = "INSER INTO course " + "(course_id, name, subjects, duration) " + "VALUES (?, ?, ?, ?)";
    
    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, dto.getCourseId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getSubject());
        pstm.setString(4, dto.getDuration());
      
        return pstm.executeUpdate() > 0;
    }
}

@Override
public boolean update(CourseDTO dto) throws SQLException {

    String sql = "UPDATE course SET name = ?, subjects = ?, " + "duration = ? WHERE course_id = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getSubject());
        pstm.setString(3, dto.getDuration());
        pstm.setString(4, dto.getCourseId());
       
        return pstm.executeUpdate() > 0;
    }
}

@Override
public boolean delete(String courseId) throws SQLException {

    String sql = "DELETE FROM course WHERE course_id = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, courseId);

        return pstm.executeUpdate() > 0;
    }
}

@Override
public List<String> getAllSubjects() throws SQLException {

    String sql = "SELECT subjects FROM course";

    List<String> subjects = new ArrayList<>();

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {
            subjects.add(rs.getString("subjects"));
        }
    }

    return subjects;
}

@Override
public List<CourseDTO> getAll() throws SQLException {
    
    String sql = "SELECT course_id, name, subjects, duration " + "FROM course";
    
    List<CourseDTO> courseList = new ArrayList<>();
    
    Connection connection = DBConnection.getInstance().getConnection();

    try (
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                CourseDTO dto = new CourseDTO(
                    
                   rs.getString("course_id"),
                   rs.getString("name"),
                   rs.getString("subjects"),
                   rs.getString("duration"));
            
                courseList.add(dto);
        }
    }
    
    return courseList;
}

@Override 
public List<String> getAllCourseIds() throws SQLException { 
    
    String sql = "SELECT course_id FROM course"; 
    
    List<String> courseIds = new ArrayList<>();
    
    Connection connection = DBConnection.getInstance().getConnection(); 
    
    try (
            PreparedStatement pstm = connection.prepareStatement(sql); 
            ResultSet rs = pstm.executeQuery()) { 
        
            while (rs.next()) { 
                courseIds.add(rs.getString("course_id")); 
            } 
    } return courseIds; 
}

@Override
public List<String> getAllCourseNames() throws SQLException {
    
    String sql = "SELECT name FROM course";
    
    List<String> courseNames = new ArrayList<>();

    Connection connection = DBConnection.getInstance().getConnection();

    try (
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    courseNames.add(rs.getString("name"));
        }
    }

    return courseNames;
}
    
}
