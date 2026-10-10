/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.dao.custom;

import java.sql.SQLException;
import lk.ijse.sams.dto.StudentDTO;
import java.util.List;
import lk.ijse.sams.dao.SuperDAO;


/**
 *
 * @author USER
 */
public interface StudentDAO extends SuperDAO{
    
    boolean save(StudentDTO dto) throws SQLException;
    
    List<StudentDTO> getAll() throws SQLException;
    
    boolean update(StudentDTO dto) throws SQLException;
    
    boolean delete(String studentId) throws SQLException;
    
    List<String> getAllStudentIds() throws SQLException;

    
    
    
}
