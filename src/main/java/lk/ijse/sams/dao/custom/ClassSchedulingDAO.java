/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.dao.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.dao.SuperDAO;
import lk.ijse.sams.dto.ClassSchedulingDTO;

/**
 *
 * @author USER
 */
public interface ClassSchedulingDAO extends SuperDAO {
    
    boolean save(ClassSchedulingDTO dto) throws SQLException;

    boolean update(ClassSchedulingDTO dto) throws SQLException;

    boolean delete(String sessionName) throws SQLException;

    List<ClassSchedulingDTO> getAll() throws SQLException;

    ClassSchedulingDTO searchBySessionName(String sessionName) throws SQLException;
    
}
