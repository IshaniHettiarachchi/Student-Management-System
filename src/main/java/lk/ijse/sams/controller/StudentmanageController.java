package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.sams.dto.StudentDTO;

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
    private TableColumn<?, ?> colCourse;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colcontact;

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
    private TableView<?> tblStudent;

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
        
        String id = txtID.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String course = txtCourse.getText();
        String contact = txtContact.getText();
        
        StudentDTO dto = new StudentDTO(Integer.parseInt(id), name, email, course, contact);
        
        
       

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnACtion(ActionEvent event) {

    }

}
