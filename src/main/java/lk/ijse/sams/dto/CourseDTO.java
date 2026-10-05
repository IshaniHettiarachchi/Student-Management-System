/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author USER
 */
public class CourseDTO {
    
    private String courseid;
    private String name;
    private String subject;
    private String duration;
    
    
    public CourseDTO (){
    }
    
    public CourseDTO(String courseid, String name, String subject, String duration, String string4){
           this.courseid =courseid;
           this.name = name;
           this.subject = subject;
           this.duration = duration;
    
    }
    public String getCourseId() {
        return courseid;
    }

    public void setCourseId(String courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    
}

    

