/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.SuperBO;
import lk.ijse.sams.dto.CourseDTO;
import lk.ijse.sams.dto.LecturerDTO;

/**
 *
 * @author USER
 */
public interface LecturerBO extends SuperBO{
    
    boolean saveLecturer(LecturerDTO dto) throws SQLException;
    
    boolean updateLecturer(LecturerDTO dto) throws SQLException;
    
    boolean deleteLecturer(String lecturerId) throws SQLException;
    
    List<LecturerDTO> getAllLecturer() throws SQLException;
    
    List<String> getAllLecturerIds() throws SQLException;
    
    
}
