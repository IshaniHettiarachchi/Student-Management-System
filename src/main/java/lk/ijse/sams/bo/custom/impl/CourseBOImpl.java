/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.custom.impl;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.custom.CourseBO;
import lk.ijse.sams.dao.custom.CourseDAO;
import lk.ijse.sams.dao.custom.impl.CourseDAOImpl;
import lk.ijse.sams.dto.CourseDTO;

/**
 *
 * @author USER
 */
public class CourseBOImpl implements CourseBO{
    
private final CourseDAO courseDAO = new CourseDAOImpl();

@Override
public boolean saveCourse(CourseDTO dto) throws SQLException {
     return courseDAO.save(dto);

}

@Override
public boolean updateCourse(CourseDTO dto) throws SQLException {
     return courseDAO.update(dto);

}

@Override
public boolean deleteCourse( String courseId) throws SQLException {
     return courseDAO.delete(courseId);

}

@Override
public List<CourseDTO> getAllCourses() throws SQLException {
     return courseDAO.getAll();

}

@Override 
public List<String> getAllSubjects() throws SQLException { 
      return courseDAO.getAllSubjects(); 
} 

@Override 
public List<String> getAllCourseIds() throws SQLException { 
      return courseDAO.getAllCourseIds(); 
} 

@Override 
public List<String> getAllCourseNames() throws SQLException { 
      return courseDAO.getAllCourseNames(); 
}

}
