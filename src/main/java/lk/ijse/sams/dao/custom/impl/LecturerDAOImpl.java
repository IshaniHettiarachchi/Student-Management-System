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
import lk.ijse.sams.dao.custom.LecturerDAO;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.LecturerDTO;

/**
 *
 * @author USER
 */
public class LecturerDAOImpl implements LecturerDAO{

@Override
public boolean save(LecturerDTO dto) throws SQLException {
    
    String sql = "INSER INTO course " + "(course_id, name, subjects, duration) " + "VALUES (?, ?, ?, ?)";
    
    Connection connection = DBConnection.getInstance().getConnection();

    try (
        PreparedStatement pstm = connection.prepareStatement(sql)) {

        pstm.setString(1, dto.getLecturerId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getEmail());
        pstm.setString(4, dto.getSubject());
      
        return pstm.executeUpdate() > 0;
    }
} 

@Override
public boolean update(LecturerDTO dto) throws SQLException {
    
    String sql = "UPDATE lecturer SET name = ?, email = ?, " + "subject = ? WHERE lecturer_id = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (
        PreparedStatement pstm = connection.prepareStatement(sql)) {
        
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getEmail());
        pstm.setString(3, dto.getSubject());
        pstm.setString(4, dto.getLecturerId());

        return pstm.executeUpdate() > 0;
    }
}

@Override
public boolean delete(String lecturerId) throws SQLException {
    
    String sql = "DELETE FROM lecturer WHERE lecturer_id = ?";

    Connection connection = DBConnection.getInstance().getConnection();

    try (
        PreparedStatement pstm = connection.prepareStatement(sql)) {
        pstm.setString(1, lecturerId);

        return pstm.executeUpdate() > 0;
    }
}

@Override
public List<LecturerDTO> getAll() throws SQLException {
    
    String sql = "SELECT lecturer_id, name, email, subject FROM lecturer";
    
    List<LecturerDTO> lecturerList = new ArrayList<>();

    Connection connection =
            DBConnection.getInstance().getConnection();

    try (
         PreparedStatement pstm = connection.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {
            LecturerDTO dto = new LecturerDTO(
                    rs.getString("lecturer_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("subject")
            );

            lecturerList.add(dto);
        }
    }

    return lecturerList;
}

@Override
public List<String> getAllLecturerIds() throws SQLException {
    
    String sql = "SELECT lecturer_id FROM lecturer";
    
    List<String> lecturerIds = new ArrayList<>();

    Connection connection =
            DBConnection.getInstance().getConnection();

    try (
         PreparedStatement pstm = connection.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {
            lecturerIds.add(rs.getString("lecturer_id"));
        }
    }

    return lecturerIds;
}

}
    
    

