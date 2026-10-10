/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.custom.impl;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.custom.StudentBO;
import lk.ijse.sams.dao.custom.StudentDAO;
import lk.ijse.sams.dto.StudentDTO;
import lk.ijse.sams.dao.custom.impl.StudentDAOImpl;

/**
 *
 * @author USER
 */
public class StudentBOImpl implements StudentBO {
    
private final StudentDAO studentDAO = new StudentDAOImpl();

@Override
public boolean saveStudent(StudentDTO dto) throws SQLException {
     return studentDAO.save(dto);

}

@Override
public List<StudentDTO> getAllStudents() throws SQLException {
    return studentDAO.getAll();

}

@Override
public boolean updateStudent(StudentDTO dto) throws SQLException {
     return studentDAO.update(dto);

}

@Override
public boolean deleteStudent( String studentId) throws SQLException {
     return studentDAO.delete(studentId);

}

@Override
public List<String> getAllStudentIds() throws SQLException {
     return studentDAO.getAllStudentIds();

}


}
