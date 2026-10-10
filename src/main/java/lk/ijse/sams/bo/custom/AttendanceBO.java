/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.SuperBO;
import lk.ijse.sams.dto.AttendanceDTO;
import lk.ijse.sams.dto.CourseDTO;

/**
 *
 * @author USER
 */
public interface AttendanceBO extends SuperBO {
    
    boolean saveAttendance(AttendanceDTO  dto) throws SQLException;
    
    boolean updateAttendance(AttendanceDTO  dto) throws SQLException;
    
    boolean deleteAttendance(String studentId, String sessionName) throws SQLException;
    
    List<AttendanceDTO> getAllAttendance() throws SQLException;
    
    List<AttendanceDTO> searchAttendanceByStudentId(String studentId) throws SQLException;
    
    List<AttendanceDTO> searchAttendance(String sessionName) throws SQLException;

    
}
