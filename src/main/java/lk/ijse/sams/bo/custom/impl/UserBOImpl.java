/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.custom.impl;

import java.sql.SQLException;
import lk.ijse.sams.bo.custom.UserBO;
import lk.ijse.sams.dao.custom.UserDAO;
import lk.ijse.sams.dao.custom.impl.UserDAOImpl;
import lk.ijse.sams.dto.UserDTO;

/**
 *
 * @author USER
 */
public class UserBOImpl implements UserBO{
    
    private final UserDAO userDAO = new UserDAOImpl(); 

@Override 
public UserDTO checkLogin(UserDTO dto) throws SQLException { 
    return userDAO.checkLogin(dto); }
    
}
