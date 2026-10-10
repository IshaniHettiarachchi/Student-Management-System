/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.custom.impl;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.custom.LecturerBO;
import lk.ijse.sams.dao.custom.LecturerDAO;
import lk.ijse.sams.dao.custom.impl.LecturerDAOImpl;
import lk.ijse.sams.dto.LecturerDTO;

/**
 *
 * @author USER
 */
public class LecturerBOImpl implements LecturerBO{

private final LecturerDAO lecturerDAO = new LecturerDAOImpl();

@Override
public boolean saveLecturer(LecturerDTO dto) throws SQLException {
     return lecturerDAO.save(dto);

}

@Override
public boolean updateLecturer(LecturerDTO dto) throws SQLException {
     return lecturerDAO.update(dto);

}

@Override
public boolean deleteLecturer( String lecturerId) throws SQLException {
     return lecturerDAO.delete(lecturerId);

}

@Override 
public List<LecturerDTO> getAllLecturer() throws SQLException { 
     return lecturerDAO.getAll(); 
} 

@Override 
public List<String> getAllLecturerIds() throws SQLException { 
    return lecturerDAO.getAllLecturerIds(); 
}

    
}
