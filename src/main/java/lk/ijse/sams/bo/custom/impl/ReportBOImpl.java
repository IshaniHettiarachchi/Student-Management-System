/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.custom.impl;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.bo.custom.ReportBO;
import lk.ijse.sams.dao.custom.ReportDAO;
import lk.ijse.sams.dao.custom.impl.ReportDAOImpl;
import lk.ijse.sams.dto.AttendanceReportDTO;

/**
 *
 * @author USER
 */
public class ReportBOImpl implements ReportBO{
    
    private final ReportDAO reportDAO = new ReportDAOImpl(); 

@Override 
public List<AttendanceReportDTO> getAttendanceReport( String studentId, String courseName, String startDate, String endDate) throws SQLException { 
    return reportDAO.getAttendanceReport( studentId, courseName, startDate, endDate ); }
    
}
