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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.sams.dto.LecturerDTO;
import lk.ijse.sams.model.CourseModel;
import lk.ijse.sams.model.LecturerModel;


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
    private TableColumn<LecturerDTO, String> colEmail;

    @FXML
    private TableColumn<LecturerDTO, String> colId;

    @FXML
    private TableColumn<LecturerDTO, String> colName;

    @FXML
    private TableColumn<LecturerDTO, String> colSubject;

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
    private TableView<LecturerDTO> tblLecturer;

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
    
     private void loadAllLecturer(){
        
        try{
            
          ObservableList<LecturerDTO> lecturerList = FXCollections.observableArrayList(LecturerModel.getAllLecturer());
          
          colId.setCellValueFactory(new PropertyValueFactory<>("lecturerId"));
          colName.setCellValueFactory(new PropertyValueFactory<>("name"));
          colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
          colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
          
          tblLecturer.setItems(lecturerList);
          
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        
        String lecturerId = txtID.getText();
        
        try{
            boolean deleted = LecturerModel.deleteLecturer(lecturerId);
            
            if(deleted){
                System.out.println("Lecturer deleted successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Lecturerdeleted successfully!");
                alert.showAndWait();
          
            }else{
                System.out.println("Lecturer deleted failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Lecturer deleted failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        loadAllLecturer();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        
        txtID.clear();
        txtName.clear();
        txtEmail.clear();
        cmbSubject.setValue(null);


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        
        String name = txtName.getText();
        String lecturerid = txtID.getText();
        String email = txtEmail.getText();
        String subject = cmbSubject.getValue();
        
        LecturerDTO dto = new LecturerDTO(lecturerid, name, email, subject);
        
        try{
            boolean saved = LecturerModel.saveLecturer(dto);
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
       
        loadAllLecturer();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        
        String lecturerid = txtID.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String subject = cmbSubject.getValue();
       
        
        LecturerDTO dto = new LecturerDTO(lecturerid, name, email, subject);
        
        try{
            boolean updated = LecturerModel.updateLecturer(dto);
            
            if(updated){
                System.out.println("Lecturer updated successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Lecturer updated successfully!");
                alert.showAndWait();
                
                
            }else{
                System.out.println("Lecturer updated failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Lecturer deleted failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       
        loadAllLecturer();
    }

    @FXML
    void cmbSubjectOnAction(ActionEvent event) {

    }

}