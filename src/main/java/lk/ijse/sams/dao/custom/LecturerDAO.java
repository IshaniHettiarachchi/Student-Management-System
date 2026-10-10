/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.dao.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.dao.SuperDAO;
import lk.ijse.sams.dto.LecturerDTO;
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author USER
 */
public interface LecturerDAO extends SuperDAO{
    
    boolean save(LecturerDTO dto) throws SQLException;
    
    boolean update(LecturerDTO dto) throws SQLException;
    
    boolean delete(String lecturerId) throws SQLException;
    
    List<LecturerDTO> getAll() throws SQLException;
    
    List<String> getAllLecturerIds() throws SQLException;
 
    
}
