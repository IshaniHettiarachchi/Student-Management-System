package lk.ijse.sams.controller;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.sams.dto.AttendanceDTO;
import lk.ijse.sams.model.AttendanceModel;
import lk.ijse.sams.model.StudentModel;

public class AttendanceController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnView;

    @FXML
    private ComboBox<String> cmbAttendance;

    @FXML
    private ComboBox<String> cmbStudentID;

    @FXML
    private TableColumn<AttendanceDTO, String> colAttendance;

    @FXML
    private TableColumn<AttendanceDTO, String> colDate;

    @FXML
    private TableColumn<AttendanceDTO, String> colSessionName;

    @FXML
    private TableColumn<AttendanceDTO, String> colStudentID;

    @FXML
    private Label lblSessionName;

    @FXML
    private Label lbltopic;

    @FXML
    private TableView<AttendanceDTO> tblAttendance;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtSessionName;
    
    @FXML
    public void initialize(){
        
       cmbAttendance.getItems().addAll("Present", "Absent");
       
       colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
       colSessionName.setCellValueFactory(new PropertyValueFactory<>("sessionName"));
       colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       colAttendance.setCellValueFactory(new PropertyValueFactory<>("status"));
          
       loadstudentIds();
       
    
    }
    
    private void loadstudentIds(){
        
        try{
            cmbStudentID.getItems().setAll(StudentModel.getAllStudentIds());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private void showAlert(Alert.AlertType type, String message) {

    Alert alert = new Alert(type);
    alert.setTitle("Attendance");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
    }  
    

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
           
        AttendanceDTO dto = tblAttendance.getSelectionModel().getSelectedItem();
        
        if (dto == null) {
        showAlert(Alert.AlertType.WARNING,
                "Please select an attendance record!");
        return;
        }
        
        String studenId = dto.getStudentId();
        String sessionName = dto.getSessionName();
        
        try{
            boolean deleted = AttendanceModel.deleteAttendance(studenId, sessionName);
            
            if(deleted){
                System.out.println("Attendance deleted successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Attendance deleted  successfully!");
                alert.showAndWait();
                
                 txtSessionName.clear();
                 txtDate.clear();
                 cmbStudentID.setValue(null);
                 cmbAttendance.setValue(null);
                
                
            }else{
                System.out.println("Attendance deletion  failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Delete failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       
    }



    @FXML
    void btnSaveOnAction(ActionEvent event) {
        
        String studentId = cmbStudentID.getValue();
        String sessionName = txtSessionName.getText();
        String date = txtDate.getText();
        String status = cmbAttendance.getValue();
       
        AttendanceDTO dto = new AttendanceDTO(studentId, sessionName, date, status);
        
        try{
            boolean saved = AttendanceModel.saveAttendance(dto);
            
            if(saved){
                System.out.println("Attendance saved successfully!");
                
                txtSessionName.clear();
                cmbStudentID.setValue(null);
                cmbAttendance.setValue(null);
                txtDate.clear();
              
            }else{
                System.out.println("Attendance saved failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Attendance saved failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

         String sessionName = txtSessionName.getText().trim();
         String studentId = cmbStudentID.getValue();
         
        try {
            ObservableList<AttendanceDTO> attendanceList = FXCollections.observableArrayList(AttendanceModel.searchAttendance(sessionName));

            tblAttendance.setItems(attendanceList);

            if (attendanceList.isEmpty()) {
                showAlert(Alert.AlertType.INFORMATION,
                        "No attendance records found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        
        String studentId = cmbStudentID.getValue();
        String sessionName = txtSessionName.getText();
        String date = txtDate.getText();
        String status = cmbAttendance.getValue();
        
        AttendanceDTO dto = new AttendanceDTO( studentId, sessionName, date, status);
        
        try{
            boolean updated = AttendanceModel.updateAttendance(dto);
            
            if(updated){
                System.out.println("Attendance updated successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Attendance updated successfully!");
                alert.showAndWait();
                
                txtSessionName.clear();
                cmbStudentID.setValue(null);
                cmbAttendance.setValue(null);
                txtDate.clear();

          
            }else{
                System.out.println("Attendance update failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Attendance update failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        
        
        try{
            
          ObservableList<AttendanceDTO> attendanceList = FXCollections.observableArrayList(AttendanceModel.getAllAttendance());
          
          tblAttendance.setItems(attendanceList);
          
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
