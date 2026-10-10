/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.custom.impl;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.custom.ClassSchedulingBO;
import lk.ijse.sams.dao.custom.ClassSchedulingDAO;
import lk.ijse.sams.dao.custom.impl.ClassSchedulingDAOImpl;
import lk.ijse.sams.dto.ClassSchedulingDTO;

/**
 *
 * @author USER
 */
public class ClassSchedulingBOImpl implements ClassSchedulingBO {
    
private final ClassSchedulingDAO classSchedulingDAO = new ClassSchedulingDAOImpl();

@Override
public boolean saveClassScheduling(ClassSchedulingDTO dto) throws SQLException {
        return classSchedulingDAO.save(dto);
}

@Override
public boolean updateClassScheduling(ClassSchedulingDTO dto) throws SQLException {
        return classSchedulingDAO.update(dto);
}

@Override
public boolean deleteClassScheduling(String sessionName) throws SQLException {
        return classSchedulingDAO.delete(sessionName);
}

@Override
public List<ClassSchedulingDTO> getAllClassScheduling() throws SQLException {
        return classSchedulingDAO.getAll();
}

@Override
public ClassSchedulingDTO searchClassSchedule(String sessionName) throws SQLException {
        return classSchedulingDAO.searchBySessionName(sessionName);
}
    
}
