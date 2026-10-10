/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.dto.AttendanceReportDTO;
import lk.ijse.sams.bo.SuperBO;


/**
 *
 * @author USER
 */
public interface ReportBO extends SuperBO{
    
    List<AttendanceReportDTO> getAttendanceReport( String studentId, String courseName, String startDate, String endDate ) throws SQLException;
    
}
