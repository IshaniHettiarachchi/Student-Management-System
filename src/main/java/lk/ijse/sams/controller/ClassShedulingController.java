package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ClassShedulingController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<?> cmbCourse;

    @FXML
    private ComboBox<?> cmbSubject;

    @FXML
    private ComboBox<?> cmblecturer;

    @FXML
    private TableColumn<?, ?> colEndtime;

    @FXML
    private TableColumn<?, ?> colSession;

    @FXML
    private TableColumn<?, ?> colStarttime;

    @FXML
    private TableColumn<?, ?> colSubject;

    @FXML
    private TableColumn<?, ?> colcourse;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> collecturer;

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
    private TableView<?> tblClass;

    @FXML
    private AnchorPane txtEtime;

    @FXML
    private TextField txtSessionName;

    @FXML
    private TextField txtStime;

    @FXML
    private TextField txtdate;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
