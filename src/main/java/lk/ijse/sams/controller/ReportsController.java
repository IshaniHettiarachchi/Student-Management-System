package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReportsController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSearch;

    @FXML
    private ComboBox<?> cmbCourse;

    @FXML
    private ComboBox<?> cmbStudentID;

    @FXML
    private TableColumn<?, ?> colCourse;

    @FXML
    private TableColumn<?, ?> colEnddate;

    @FXML
    private TableColumn<?, ?> colStartdate;

    @FXML
    private TableColumn<?, ?> colStudentID;

    @FXML
    private Label lblCourse;

    @FXML
    private Label lblEnddate;

    @FXML
    private Label lblStartdate;

    @FXML
    private Label lblStudentID;

    @FXML
    private TableView<?> tblAttendance;

    @FXML
    private TextField txtEnddate;

    @FXML
    private TextField txtStartdate;

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

}
