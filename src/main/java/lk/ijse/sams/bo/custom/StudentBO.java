/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.SuperBO;
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author USER
 */
public interface StudentBO extends SuperBO{
    
    boolean saveStudent(StudentDTO dto) throws SQLException;
    
    List<StudentDTO> getAllStudents() throws SQLException;
    
    boolean updateStudent(StudentDTO dto) throws SQLException;
    
    boolean deleteStudent(String studentId) throws SQLException;
    
    List<String> getAllStudentIds() throws SQLException;


}
