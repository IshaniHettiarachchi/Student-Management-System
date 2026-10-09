/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author USER
 */
public class ClassSchedulingDTO {
    
    private String sessionName;
    private String courseId;
    private String subject;
    private String lecturerId;
    private String date;
    private String startTime;
    private String endTime; 
    
    public ClassSchedulingDTO(){
    
    }
    
    public ClassSchedulingDTO(String sessionName, String courseId,String subject, String lecturerId, String date, String startTime, String endTime){     
       
        this.sessionName = sessionName;
        this.courseId = courseId;
        this.subject = subject;
        this.lecturerId = lecturerId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        
    }
    
     public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }
    
      public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
}
