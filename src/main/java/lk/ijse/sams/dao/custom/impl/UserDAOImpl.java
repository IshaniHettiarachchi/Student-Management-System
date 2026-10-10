/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.sams.dao.custom.UserDAO;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.UserDTO;

/**
 *
 * @author USER
 */
public class UserDAOImpl implements UserDAO {
    
@Override 
public UserDTO checkLogin(UserDTO dto) throws SQLException { 
    
    String sql = "SELECT username, password, role " + "FROM users " + "WHERE username = ? AND password = ?";
    
    Connection connection = DBConnection.getInstance().getConnection(); 
    
        try (
             PreparedStatement pstm = connection.prepareStatement(sql)) { 
                pstm.setString(1, dto.getUsername()); 
                pstm.setString(2, dto.getPassword());
                
             try (ResultSet rs = pstm.executeQuery()) { 
                 
            if (rs.next()) { 
                return new UserDTO( 
                         rs.getString("username"), 
                         rs.getString("password"), 
                         rs.getString("role") ); 
                } 
            } 
        
        } 
        
        return null; }
    
}
