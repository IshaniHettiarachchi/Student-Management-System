package lk.ijse.sams.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.sams.bo.custom.CourseBO;
import lk.ijse.sams.bo.custom.ReportBO;
import lk.ijse.sams.bo.custom.StudentBO;
import lk.ijse.sams.bo.custom.impl.CourseBOImpl;
import lk.ijse.sams.bo.custom.impl.ReportBOImpl;
import lk.ijse.sams.bo.custom.impl.StudentBOImpl;
import lk.ijse.sams.dto.AttendanceReportDTO;


public class ReportsController implements Initializable {
    
private final ReportBO reportBO = new ReportBOImpl(); 
private final StudentBO studentBO = new StudentBOImpl(); 
private final CourseBO courseBO = new CourseBOImpl();

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnReset;

    @FXML
    private ComboBox<String> cmbCourse;

    @FXML
    private ComboBox<String> cmbStudentID;

    @FXML
    private TableColumn<AttendanceReportDTO, String> colCourse;

    @FXML
    private TableColumn<AttendanceReportDTO, String> colDate;

    @FXML
    private TableColumn<AttendanceReportDTO, String> colSessionName;

    @FXML
    private TableColumn<AttendanceReportDTO, String> colStatus;

    @FXML
    private TableColumn<AttendanceReportDTO, String> colStudentID;

    @FXML
    private TableColumn<AttendanceReportDTO, String> colStudentName;

    @FXML
    private Label lblCourse;

    @FXML
    private Label lblEnddate;

    @FXML
    private Label lblStartdate;

    @FXML
    private Label lblStudentID;

    @FXML
    private TableView<AttendanceReportDTO> tblReport;

    @FXML
    private TextField txtEnddate;

    @FXML
    private TextField txtStartdate;
    
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        
       colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
       colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
       colCourse.setCellValueFactory(new PropertyValueFactory<>("courseName"));
       colSessionName.setCellValueFactory(new PropertyValueFactory<>("sessionName"));
       colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
       
       try{
            cmbStudentID.setItems(FXCollections.observableArrayList(studentBO.getAllStudentIds()));
            cmbCourse.setItems(FXCollections.observableArrayList(courseBO.getAllCourseNames()));
            
        }catch (SQLException e){
            e.printStackTrace();
        }
      
    }

    @FXML
    void btnCreateOnAction(ActionEvent event) {
        
        String studentId = cmbStudentID.getValue();
        String courseName = cmbCourse.getValue();
        String startDate = txtStartdate.getText().trim();
        String endDate = txtEnddate.getText().trim();
        
        if (startDate.isEmpty()) { startDate = null; } 
        if (endDate.isEmpty()) { endDate = null; }
        
        try {
            
            List<AttendanceReportDTO> reportList = reportBO.getAttendanceReport(studentId, courseName, startDate, endDate);
            
            ObservableList<AttendanceReportDTO> data = FXCollections.observableArrayList(reportList);
            
            tblReport.setItems(data);
            
            if(data.isEmpty()){
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No attendance records found!");
                alert.showAndWait();
                
            }
                
            
            
        
        }  catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        
        cmbStudentID.setValue(null);
        cmbCourse.setValue(null);
        txtStartdate.clear();
        txtEnddate.clear();
        
        tblReport.getItems().clear();

    }

}
