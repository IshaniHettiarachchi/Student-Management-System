/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.UserDTO;

/**
 *
 * @author USER
 */

public class UserModel {

    public UserDTO checkLogin(UserDTO dto) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, dto.getUsername());
        stm.setString(2, dto.getPassword());

        ResultSet rs = stm.executeQuery();

        if (rs.next()) {

         return new UserDTO(
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
            );

        }

      return null;
    }
}