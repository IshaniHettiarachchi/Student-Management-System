/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author USER
 */
public class AttendanceReportDTO {
    
    private String studentId;
    private String studentName;
    private String courseName;
    private String sessionName;
    private String date;
    private String status;
    
    public AttendanceReportDTO(String studentId, String studentName, String courseName, String sessionName, String date, String status){
        
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.sessionName = sessionName;
        this.date = date;
        this.status = status;
    }    

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
  
}
