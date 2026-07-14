/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LecturerviewController {

    @FXML
    private Button btnAttendance;

    @FXML
    private Button btnClass;

    @FXML
    private Label lbltext;

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

}
