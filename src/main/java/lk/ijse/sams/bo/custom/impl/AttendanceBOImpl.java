/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.custom.impl;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.custom.AttendanceBO;
import lk.ijse.sams.dao.custom.AttendanceDAO;
import lk.ijse.sams.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.sams.dto.AttendanceDTO;

/**
 *
 * @author USER
 */
public class AttendanceBOImpl implements AttendanceBO {
    
private final AttendanceDAO attendanceDAO = new AttendanceDAOImpl();

@Override
public boolean saveAttendance(AttendanceDTO dto) throws SQLException {
        return attendanceDAO.save(dto);
}

@Override
public boolean updateAttendance(AttendanceDTO dto) throws SQLException {
        return attendanceDAO.update(dto);
}

@Override
public boolean deleteAttendance(String studentId, String sessionName) throws SQLException {
        return attendanceDAO.delete(studentId, sessionName);
}

@Override
public List<AttendanceDTO> searchAttendance(String sessionName) throws SQLException {
        return attendanceDAO.searchBySession(sessionName);
}

@Override
public List<AttendanceDTO> searchAttendanceByStudentId(String studentId) throws SQLException {
        return attendanceDAO.searchByStudentId(studentId);
}

@Override
public List<AttendanceDTO> getAllAttendance() throws SQLException {
        return attendanceDAO.getAll();
}
    
}
