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
import lk.ijse.sams.dao.custom.ClassSchedulingDAO;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.ClassSchedulingDTO;

/**
 *
 * @author USER
 */
public class ClassSchedulingDAOImpl implements ClassSchedulingDAO {
    
@Override
public boolean save(ClassSchedulingDTO dto) throws SQLException {

        String sql = "INSERT INTO class_schedule " + "(session_name, course_id, subject, lecturer_id, " + "`date`, start_time, end_time) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DBConnection.getInstance().getConnection();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, dto.getSessionName());
            pstm.setString(2, dto.getCourseId());
            pstm.setString(3, dto.getSubject());
            pstm.setString(4, dto.getLecturerId());
            pstm.setString(5, dto.getDate());
            pstm.setString(6, dto.getStartTime());
            pstm.setString(7, dto.getEndTime());

            return pstm.executeUpdate() > 0;
        }
    }

@Override
public boolean update(ClassSchedulingDTO dto) throws SQLException {

        String sql = "UPDATE class_schedule SET " + "course_id = ?, subject = ?, lecturer_id = ?, " + "`date` = ?, start_time = ?, end_time = ? " + "WHERE session_name = ?";

        Connection connection = DBConnection.getInstance().getConnection();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, dto.getCourseId());
            pstm.setString(2, dto.getSubject());
            pstm.setString(3, dto.getLecturerId());
            pstm.setString(4, dto.getDate());
            pstm.setString(5, dto.getStartTime());
            pstm.setString(6, dto.getEndTime());
            pstm.setString(7, dto.getSessionName());

            return pstm.executeUpdate() > 0;
        }
    }

@Override
public boolean delete(String sessionName) throws SQLException {

        String sql = "DELETE FROM class_schedule " + "WHERE session_name = ?";

        Connection connection = DBConnection.getInstance().getConnection();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, sessionName);

            return pstm.executeUpdate() > 0;
        }
    }

@Override
public List<ClassSchedulingDTO> getAll() throws SQLException {

        String sql = "SELECT session_name, course_id, subject, " + "lecturer_id, `date`, start_time, end_time " + "FROM class_schedule";

        List<ClassSchedulingDTO> classList = new ArrayList<>();

        Connection connection =
                DBConnection.getInstance().getConnection();

        try (
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

                 while (rs.next()) {
                     classList.add(new ClassSchedulingDTO(
                        rs.getString("session_name"),
                        rs.getString("course_id"),
                        rs.getString("subject"),
                        rs.getString("lecturer_id"),
                        rs.getString("date"),
                        rs.getString("start_time"),
                        rs.getString("end_time")
                ));
            }
        }

        return classList;
    }

@Override
public ClassSchedulingDTO searchBySessionName(String sessionName) throws SQLException {

        String sql = "SELECT session_name, course_id, subject, " + "lecturer_id, `date`, start_time, end_time " + "FROM class_schedule WHERE session_name = ?";

        Connection connection = DBConnection.getInstance().getConnection();

        try (
            PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, sessionName);

            try (ResultSet rs = pstm.executeQuery()) {

                if (rs.next()) {
                    return new ClassSchedulingDTO(
                            rs.getString("session_name"),
                            rs.getString("course_id"),
                            rs.getString("subject"),
                            rs.getString("lecturer_id"),
                            rs.getString("date"),
                            rs.getString("start_time"),
                            rs.getString("end_time")
                    );
                }
            }
        }

        return null;
    }    
    
}
