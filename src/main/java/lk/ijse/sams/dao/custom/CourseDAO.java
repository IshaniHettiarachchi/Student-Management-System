/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.dao.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.dao.SuperDAO;
import lk.ijse.sams.dto.CourseDTO;

/**
 *
 * @author USER
 */
public interface CourseDAO extends SuperDAO{
    
    boolean save(CourseDTO dto) throws SQLException;
    
    boolean update(CourseDTO dto) throws SQLException;
    
    boolean delete(String courseId) throws SQLException;
    
    List<CourseDTO> getAll() throws SQLException;
    
    List<String> getAllSubjects() throws SQLException;
    
    List<String> getAllCourseIds() throws SQLException;
    
    List<String> getAllCourseNames() throws SQLException;
    
    
}
