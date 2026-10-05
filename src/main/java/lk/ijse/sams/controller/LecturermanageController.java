package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import lk.ijse.sams.dto.LecturerDTO;
import lk.ijse.sams.dto.StudentDTO;
import lk.ijse.sams.model.CourseModel;
import lk.ijse.sams.model.StudentModel;

public class LecturermanageController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbSubject;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSubject;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblID;

    @FXML
    private Label lblLecture;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSubject;

    @FXML
    private TableView<?> tblLecturer;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;
    
    @FXML
    public void initialize(){
        
        try{
            
            cmbSubject.getItems().addAll(
                    CourseModel.getAllSubjects()
            );
        } catch (SQLException e){
           e.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        
        String name = txtName.getText();
        String lecturerid = txtID.getText();
        String email = txtEmail.getText();
        String subject = cmbSubject.getValue();
        
        LecturerDTO dto = new LecturerDTO(lecturerid, name, email, subject);
        
        try{
            boolean saved = StudentModel.saveStudent(dto);
            if(saved){
                System.out.println("Lecturer saved successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Lecturersaved successfully!");
                alert.showAndWait();
                
                 
            }else{
                System.out.println("Lecturer saved failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Lecturer saved failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        
        String studentid = txtID.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String courseid = txtCourse.getText();
        String contact = txtContact.getText();
        
        StudentDTO dto = new StudentDTO(studentid, name, email, courseid, contact);
        
        try{
            boolean updated = StudentModel.updateStudent(dto);
            if(updated){
                System.out.println("Student updated successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Student updated successfully!");
                alert.showAndWait();
                
                 txtID.clear();
                 txtName.clear();
                 txtEmail.clear();
                 txtCourse.clear();
                 txtContact.clear();
            }else{
                System.out.println("Student updated failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Student deleted failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       

    }

    @FXML
    void cmbSubjectOnAction(ActionEvent event) {

    }

}