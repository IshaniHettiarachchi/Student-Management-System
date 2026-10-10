/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.SuperBO;
import lk.ijse.sams.dto.CourseDTO;
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author USER
 */
public interface CourseBO extends SuperBO{
    
      
    boolean saveCourse(CourseDTO dto) throws SQLException;
    
    boolean updateCourse(CourseDTO dto) throws SQLException;
    
    boolean deleteCourse(String courseId) throws SQLException;
    
    List<CourseDTO> getAllCourses() throws SQLException;
    
    List<String> getAllSubjects() throws SQLException;
    
    List<String> getAllCourseIds() throws SQLException;

    List<String> getAllCourseNames() throws SQLException;

    
}
