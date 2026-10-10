
package lk.ijse.sams.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.AttendanceReportDTO;

public class ReportModel {

    public static List<AttendanceReportDTO> getAttendanceReport(
            String studentId,
            String courseName,
            String startDate,
            String endDate) throws SQLException {

        List<AttendanceReportDTO> reportList = new ArrayList<>();

        StringBuilder sql = new StringBuilder(
                "SELECT a.student_id, s.name AS student_name, " +
                "c.name AS course_name, a.session_name, " +
                "a.date, a.status " +
                "FROM attendance a " +
                "JOIN student s ON a.student_id = s.student_id " +
                "LEFT JOIN course c ON s.course_id = c.course_id " +
                "WHERE 1=1 "
        );

        List<Object> parameters = new ArrayList<>();

        if (studentId != null && !studentId.trim().isEmpty()) {
            sql.append("AND a.student_id = ? ");
            parameters.add(studentId.trim());
        }

        if (courseName != null && !courseName.trim().isEmpty()) {
            sql.append("AND c.name = ? ");
            parameters.add(courseName.trim());
        }

        if (startDate != null && !startDate.trim().isEmpty()) {
            sql.append("AND a.date >= ? ");
            parameters.add(java.sql.Date.valueOf(startDate.trim()));
        }

        if (endDate != null && !endDate.trim().isEmpty()) {
            sql.append("AND a.date <= ? ");
            parameters.add(java.sql.Date.valueOf(endDate.trim()));
        }

        sql.append("ORDER BY a.date ASC");

        Connection connection =
                DBConnection.getInstance().getConnection();

        try (PreparedStatement pstm =
                     connection.prepareStatement(sql.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                pstm.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {

                    AttendanceReportDTO dto =
                            new AttendanceReportDTO(
                                    rs.getString("student_id"),
                                    rs.getString("student_name"),
                                    rs.getString("course_name"),
                                    rs.getString("session_name"),
                                    rs.getString("date"),
                                    rs.getString("status")
                            );

                    reportList.add(dto);
                }
            }
        }

        return reportList;
    }
}