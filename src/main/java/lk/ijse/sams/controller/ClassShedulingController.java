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
import lk.ijse.sams.dto.ClassSchedulingDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.sams.bo.custom.ClassSchedulingBO;
import lk.ijse.sams.bo.custom.CourseBO;
import lk.ijse.sams.bo.custom.LecturerBO;
import lk.ijse.sams.bo.custom.impl.ClassSchedulingBOImpl;
import lk.ijse.sams.bo.custom.impl.CourseBOImpl;
import lk.ijse.sams.bo.custom.impl.LecturerBOImpl;


public class ClassShedulingController {

private final ClassSchedulingBO classSchedulingBO = new ClassSchedulingBOImpl();

private final CourseBO courseBO = new CourseBOImpl();

private final LecturerBO lecturerBO = new LecturerBOImpl();
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbCourseID;

    @FXML
    private ComboBox<String> cmbSubject;

    @FXML
    private ComboBox<String> cmblecturerID;

    @FXML
    private TableColumn<ClassSchedulingDTO, String> colEndtime;

    @FXML
    private TableColumn<ClassSchedulingDTO, String> colSession;

    @FXML
    private TableColumn<ClassSchedulingDTO, String> colStarttime;

    @FXML
    private TableColumn<ClassSchedulingDTO, String> colSubject;

    @FXML
    private TableColumn<ClassSchedulingDTO, String> colcourse;

    @FXML
    private TableColumn<ClassSchedulingDTO, String> coldate;

    @FXML
    private TableColumn<ClassSchedulingDTO, String> collecturer;

    @FXML
    private Label lblClass;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSubject;

    @FXML
    private Label lblcourse;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblend;

    @FXML
    private Label lbllecturere;

    @FXML
    private Label lblstart;

    @FXML
    private TableView<ClassSchedulingDTO> tblClass;

    @FXML
    private TextField txtEtime;

    @FXML
    private TextField txtSessionName;

    @FXML
    private TextField txtStime;

    @FXML
    private TextField txtdate;
    
    @FXML
    public void initialize(){
        
        loadcourseIds();
        loadLecturerIds();
        loadsubject();
    }
    
    private void loadcourseIds(){
        
        try{
            cmbCourseID.getItems().setAll(courseBO.getAllCourseIds());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private void loadLecturerIds(){
        
        try{
            cmblecturerID.getItems().setAll(lecturerBO.getAllLecturerIds());
        }catch (SQLException e){
            e.printStackTrace();
        }
    
    }
     
    private void loadsubject(){
        
        try{
            cmbSubject.getItems().addAll(courseBO.getAllSubjects());
        } catch (SQLException e){
           e.printStackTrace();
        }
    }
    
    
    private void loadAllClassScheduling(){
    
         try{
            
          ObservableList<ClassSchedulingDTO> classList = FXCollections.observableArrayList(classSchedulingBO.getAllClassScheduling());
          
          colSession.setCellValueFactory(new PropertyValueFactory<>("sessionName"));
          colcourse.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
          colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
          collecturer.setCellValueFactory(new PropertyValueFactory<>("lecturerId"));
          coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
          colStarttime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
          colEndtime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
          
          
          tblClass.setItems(classList);
          
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        
        String sessionName = txtSessionName.getText();
        
        try{
            boolean deleted = classSchedulingBO.deleteClassScheduling(sessionName);
            
            if(deleted){
                System.out.println("Class schedule deleted successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Class schedule deleted successfully!");
                alert.showAndWait();
          
            }else{
                System.out.println("Class scheduling detele failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Class scheduling delete failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        loadAllClassScheduling();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        
        String sessionName = txtSessionName.getText();
        String courseId = cmbCourseID.getValue();
        String subject = cmbSubject.getValue();
        String lecturerId = cmblecturerID.getValue();
        String date = txtdate.getText();
        String startTime = txtStime.getText();
        String endTime = txtEtime.getText();
        
        ClassSchedulingDTO dto = new ClassSchedulingDTO(sessionName, courseId, subject, lecturerId, date, startTime, endTime);
        
        try{
            boolean saved = classSchedulingBO.saveClassScheduling(dto);
            
            if(saved){
                System.out.println("Class scheduled successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Class scheduled successfully!");
                alert.showAndWait();
                
                txtSessionName.clear();
                cmbCourseID.setValue(null);
                cmbSubject.setValue(null);
                cmblecturerID.setValue(null);
                txtdate.clear();
                txtStime.clear();
                txtEtime.clear(); 

          
            }else{
                System.out.println("Class scheduled failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Class scheduled failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        loadAllClassScheduling();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        
        String sessionName = txtSessionName.getText();
        
        try {

        ClassSchedulingDTO dto = classSchedulingBO.searchClassSchedule(sessionName);

        if (dto != null) {

            txtSessionName.setText(dto.getSessionName());
            cmbCourseID.setValue(dto.getCourseId());
            cmbSubject.setValue(dto.getSubject());
            cmblecturerID.setValue(dto.getLecturerId());
            txtdate.setText(dto.getDate());
            txtStime.setText(dto.getStartTime());
            txtEtime.setText(dto.getEndTime());

           
            ObservableList<ClassSchedulingDTO> searcheList = FXCollections.observableArrayList();

            searcheList.add(dto);

            tblClass.setItems(searcheList);

            System.out.println("Class schedule found!");

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Class schedule not found!");
            alert.showAndWait();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
               
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        
        String sessionName = txtSessionName.getText();
        String courseId = cmbCourseID.getValue();
        String subject = cmbSubject.getValue();
        String lecturerId = cmblecturerID.getValue();
        String date = txtdate.getText();
        String startTime = txtStime.getText();
        String endTime = txtEtime.getText();
        
        ClassSchedulingDTO dto = new ClassSchedulingDTO(sessionName, courseId, subject, lecturerId, date, startTime, endTime);
        
        try{
            boolean updated = classSchedulingBO.updateClassScheduling(dto);
            
            if(updated){
                System.out.println("Class scheduled updated successfully!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Class scheduled updated successfully!");
                alert.showAndWait();
                
                txtSessionName.clear();
                cmbCourseID.setValue(null);
                cmbSubject.setValue(null);
                cmblecturerID.setValue(null);
                txtdate.clear();
                txtStime.clear();
                txtEtime.clear(); 

          
            }else{
                System.out.println("Class schedule update failed!");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Class schedule update failed!");
                alert.showAndWait();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        loadAllClassScheduling();
    }
    

}
