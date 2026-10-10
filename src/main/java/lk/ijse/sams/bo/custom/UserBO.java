/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo.custom;

import java.sql.SQLException;
import lk.ijse.sams.dto.UserDTO;

/**
 *
 * @author USER
 */
public interface UserBO {
    
    UserDTO checkLogin(UserDTO dto) throws SQLException;
    
}
