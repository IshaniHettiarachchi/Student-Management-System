/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;



/**
 *
 * @author USER
 */
public class StudentDTO {
    
    private String studentid;
    private String name;
    private String email;
    private String courseid;
    private String contact;
    
    
    

public StudentDTO (){
}

public StudentDTO(String studentid, String name, String email, String courseid,  String contact ){
    this.studentid =studentid;
    this.name = name;
    this.email = email;
    this.courseid = courseid;
    this.contact = contact;
    
}
 public String getStudentid() {
        return studentid;
    }

    public void setStudentId(String studentId) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCourseId() {
        return courseid;
    }

    public void setCourseId(String courseId) {
        this.courseid = courseid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

   
}
