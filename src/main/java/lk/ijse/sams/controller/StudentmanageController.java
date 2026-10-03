package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.sams.dto.StudentDTO;
import java.sql.SQLException;
import lk.ijse.sams.model.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;


public class StudentmanageController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnView;

    @FXML
    private TableColumn<StudentDTO, String> colCourse;

    @FXML
    private TableColumn<StudentDTO, String> colEmail;

    @FXML
    private TableColumn<StudentDTO, String> colID;

    @FXML
    private TableColumn<StudentDTO, String> colName;

    @FXML
    private TableColumn<StudentDTO, String> colcontact;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblStudent;

    @FXML
    private TableView<StudentDTO> tblStudent;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtCourse;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        
        String studentid = txtID.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String courseid = txtCourse.getText();
        String contact = txtContact.getText();
        
        StudentDTO dto = new StudentDTO(studentid, name, email, courseid, contact);
        
        try{
            boolean saved = StudentModel.saveStudent(dto);
            if(saved){
                System.out.println("Student saved successfully!");
                
                 txtID.clear();
                 txtName.clear();
                 txtEmail.clear();
                 txtCourse.clear();
                 txtContact.clear();
            }else{
                System.out.println("Student saved failed!");
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
                
                 txtID.clear();
                 txtName.clear();
                 txtEmail.clear();
                 txtCourse.clear();
                 txtContact.clear();
            }else{
                System.out.println("Student updated failed!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        
        try{
            
          ObservableList<StudentDTO> studentList = FXCollections.observableArrayList(StudentModel.getAllStudents());
          
          colID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
          colName.setCellValueFactory(new PropertyValueFactory<>("name"));
          colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
          colCourse.setCellValueFactory(new PropertyValueFactory<>("courseId"));
          colcontact.setCellValueFactory(new PropertyValueFactory<>("contact"));
          
          tblStudent.setItems(studentList);
          
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
