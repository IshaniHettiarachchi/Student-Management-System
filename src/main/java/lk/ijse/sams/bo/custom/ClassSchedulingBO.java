/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.SuperBO;
import lk.ijse.sams.dto.ClassSchedulingDTO;

/**
 *
 * @author USER
 */
public interface ClassSchedulingBO extends SuperBO {
    
    boolean saveClassScheduling(ClassSchedulingDTO dto) throws SQLException;

    boolean updateClassScheduling(ClassSchedulingDTO dto) throws SQLException;

    boolean deleteClassScheduling(String sessionName) throws SQLException;

    List<ClassSchedulingDTO> getAllClassScheduling() throws SQLException;

    ClassSchedulingDTO searchClassSchedule(String sessionName) throws SQLException;

   
    
}
