/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author USER
 */
public class AttendanceDTO {
    
        private String studentId;
        private String sessionName;
        private String date;
        private String status;
        
        public AttendanceDTO(){
        }
        
        public AttendanceDTO(String studentId, String sessionName, String date, String status){     
       
        this.studentId = studentId;
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
