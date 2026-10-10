/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.dao.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.dao.SuperDAO;
import lk.ijse.sams.dto.AttendanceDTO;
import lk.ijse.sams.dto.CourseDTO;

/**
 *
 * @author USER
 */
public interface AttendanceDAO extends SuperDAO{
    
    boolean save(AttendanceDTO dto) throws SQLException;
    
    boolean update(AttendanceDTO dto) throws SQLException;
    
    boolean delete(String studentId, String sessionName) throws SQLException;
    
    List<AttendanceDTO> getAll() throws SQLException;
    
    List<AttendanceDTO> searchBySession(String sessionName) throws SQLException;
    
    List<AttendanceDTO> searchByStudentId(String studentId) throws SQLException;
    
    
}
