package lk.ijse.sams.controller;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.sams.dto.CourseDTO;
import lk.ijse.sams.model.CourseModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;


public class CoursemanageController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<CourseDTO, String> colDuration;

    @FXML
    private TableColumn<CourseDTO, String> colID;

    @FXML
    private TableColumn<CourseDTO, String> colName;

    @FXML
    private TableColumn<CourseDTO, String> colSubject;

    @FXML
    private Label lblCourse;

    @FXML
    private Label lblID;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSubject;

    @FXML
    private Label lblduration;

    @FXML
    private TableView<CourseDTO> tblCourse;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSubject;
    
    private void loadAllCourses(){
        
        try{
            
          ObservableList<CourseDTO> courseList = FXCollections.observableArrayList(CourseModel.getAllCourses());
          
          colID.setCellValueFactory(new PropertyValueFactory<>("courseId"));
          colName.setCellValueFactory(new PropertyValueFactory<>("name"));
          colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
          colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
          
          tblCourse.setItems(courseList);
          
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        
        String courseId = txtID.getText();
        
        try{
            boolean deleted = CourseModel.deleteCourse(courseId);
            
            if(deleted){
                System.out.println("Course deleted successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Course deleted successfully!");
                alert.showAndWait();
          
            }else{
                System.out.println("Course deleted failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Course deleted failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        loadAllCourses();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        
        txtID.clear();
        txtName.clear();
        txtSubject.clear();
        txtDuration.clear();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        
        String courseid = txtID.getText();
        String name = txtName.getText();
        String subject = txtSubject.getText();
        String duration = txtDuration.getText();
        
        CourseDTO dto = new CourseDTO(courseid, name, subject, duration);
        
        try{
            boolean saved = CourseModel.saveCourse(dto);
            if(saved){
                System.out.println("Course saved successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Course saved successfully!");
                alert.showAndWait();
             
               loadAllCourses();
               
            }else{
                System.out.println("Course saved failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Course saved failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        
        String courseid = txtID.getText();
        String name = txtName.getText();
        String subject = txtSubject.getText();
        String duration = txtDuration.getText();
        
        CourseDTO dto = new CourseDTO(courseid, name, subject, duration);
        
        try{
            boolean updated = CourseModel.updateCourse(dto);
            if(updated){
                System.out.println("Course saved successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Course saved successfully!");
                alert.showAndWait();
                
                loadAllCourses();
                
            }else{
                System.out.println("Course saved failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Course saved failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
