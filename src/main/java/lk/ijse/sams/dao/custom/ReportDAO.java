/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.dao.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.sams.dao.SuperDAO;
import lk.ijse.sams.dto.AttendanceReportDTO;

/**
 *
 * @author USER
 */
public interface ReportDAO extends SuperDAO {
    
     List<AttendanceReportDTO> getAttendanceReport(
            String studentId,
            String courseName,
            String startDate,
            String endDate
    ) throws SQLException;
    
}
