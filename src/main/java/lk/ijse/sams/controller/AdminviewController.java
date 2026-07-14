package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminviewController {

    @FXML
    private Button btnAttendance;

    @FXML
    private Button btnClass;

    @FXML
    private Button btnCourseManage;

    @FXML
    private Button btnLectureManage;

    @FXML
    private Button btnReporting;

    @FXML
    private Button btnStudentManage;

    @FXML
    private Label lblAdmin;

    @FXML
    void btnAttendanceOnAction(ActionEvent event) {
        
        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/sams/view/attendance.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Attendance Management");
        stage.setScene(new Scene(root));
        
        stage.setWidth(895);
        stage.setHeight(656);
        
        stage.show();

        } catch (IOException e) {
        e.printStackTrace();
        }

    }

    @FXML
    void btnClassOnAction(ActionEvent event) {
        
        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/sams/view/classsheduling_1.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Class Sheduling");
        stage.setScene(new Scene(root));
        
        stage.setWidth(900);
        stage.setHeight(700);
        
        stage.show();

        } catch (IOException e) {
        e.printStackTrace();
        }
    

    }

    @FXML
    void btnCourseOnAction(ActionEvent event) {
        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/sams/view/coursemanage.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Course Management");
        stage.setScene(new Scene(root));
        
        stage.setWidth(1000);
        stage.setHeight(700);
        
        stage.show();

        } catch (IOException e) {
        e.printStackTrace();
        }
    
    }

    @FXML
    void btnLectureOnAction(ActionEvent event) {
        
        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/sams/view/lecturemanage.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Lecture Management");
        stage.setScene(new Scene(root));
        
        stage.setWidth(887);
        stage.setHeight(700);
        
        stage.show();

        } catch (IOException e) {
        e.printStackTrace();
        }

    }
    
    @FXML
    void btnReportingOnAction(ActionEvent event) {
        
        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/sams/view/reports.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Reports Management");
        stage.setScene(new Scene(root));
        
        stage.setWidth(700);
        stage.setHeight(600);
        
        stage.show();

        } catch (IOException e) {
        e.printStackTrace();
        }

    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {

        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/sams/view/studentmanage.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Student Management");
        stage.setScene(new Scene(root));
        
        stage.setWidth(1000);
        stage.setHeight(700);
        
        stage.show();

        } catch (IOException e) {
        e.printStackTrace();
        }
    }

}
