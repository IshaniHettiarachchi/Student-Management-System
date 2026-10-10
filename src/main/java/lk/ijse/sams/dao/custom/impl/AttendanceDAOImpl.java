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
import lk.ijse.sams.dao.custom.AttendanceDAO;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.AttendanceDTO;

/**
 *
 * @author USER
 */
public class AttendanceDAOImpl implements AttendanceDAO{
    
@Override
public boolean save(AttendanceDTO dto) throws SQLException {
    
    String sql = "INSERT INTO attendance " + "(student_id, session_name, date, status) " + "VALUES (?, ?, ?, ?)";
    
    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, dto.getStudentId());
        pstm.setString(2, dto.getSessionName());
        pstm.setString(3, dto.getDate());
        pstm.setString(4, dto.getStatus());
      
        return pstm.executeUpdate() > 0;
    }
}

@Override
public boolean update(AttendanceDTO dto) throws SQLException {

    String sql = "UPDATE attendance SET date = ?, status = ? " + "WHERE student_id = ? AND session_name = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, dto.getDate());
        pstm.setString(2, dto.getStatus());
        pstm.setString(3, dto.getStudentId());
        pstm.setString(4, dto.getSessionName());
      
       
        return pstm.executeUpdate() > 0;
    }
}

@Override
public boolean delete(String studentId, String sessionName) throws SQLException {

    String sql = "DELETE FROM attendance WHERE student_id = ? AND session_name = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, studentId);
        pstm.setString(2, sessionName);

        return pstm.executeUpdate() > 0;
    }
}

@Override
public List<AttendanceDTO> searchBySession(String sessionName) throws SQLException {

    String sql = "SELECT student_id, session_name, date, status " + "FROM attendance WHERE session_name =?";
    
    List<AttendanceDTO> attendanceList = new ArrayList<>();
    
    Connection connection = DBConnection.getInstance().getConnection();

    try (
            PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, sessionName);

        try (ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                 attendanceList.add(new AttendanceDTO(
                        rs.getString("student_id"),
                        rs.getString("session_name"),
                        rs.getString("date"),
                        rs.getString("status")
                ));
            }
        }
    }
    
    return attendanceList;
}

@Override
public List<AttendanceDTO> searchByStudentId(String studentId) throws SQLException {

    String sql = "SELECT student_id, session_name, date, status " + "FROM attendance WHERE student_id =?";
    
    List<AttendanceDTO> attendanceList = new ArrayList<>();
    
    Connection connection = DBConnection.getInstance().getConnection();

    try (
            PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, studentId);

        try (ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                 attendanceList.add(new AttendanceDTO(
                        rs.getString("student_id"),
                        rs.getString("session_name"),
                        rs.getString("date"),
                        rs.getString("status")
                ));
            }
        }
    }
    
    return attendanceList;
}

@Override
    public List<AttendanceDTO> getAll() throws SQLException {
        
        String sql = "SELECT student_id, session_name, date, status " + "FROM attendance";

        List<AttendanceDTO> attendanceList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();

        try (
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

                 while (rs.next()) {
                     attendanceList.add(new AttendanceDTO(
                            rs.getString("student_id"),
                            rs.getString("session_name"),
                            rs.getString("date"),
                            rs.getString("status")
                ));
            }
        }

        return attendanceList;
    }



}
