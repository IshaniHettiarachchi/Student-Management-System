/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author USER
 */
public class LecturerDTO {
    
    private String lecturerid;
    private String name;
    private String email;
    private String subject;
    
   
    
    public LecturerDTO  (){
    }

    public LecturerDTO (String lecturerid, String name, String email, String subject){
           this.lecturerid =lecturerid;
           this.name = name;
           this.email = email;
           this.subject = subject;
          
    
    }
    public String getLecturerId() {
        return lecturerid;
    }

    public void setLecturerId(String lecturerid) {
        this.lecturerid = lecturerid;
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
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

   
}

