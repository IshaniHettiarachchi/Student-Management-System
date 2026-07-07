package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginviewController {

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblPswrd;

    @FXML
    private Label lblText;

    @FXML
    private Label lblUser;

    @FXML
    private TextField txtPswrd;

    @FXML
    private TextField txtUser;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String password = txtPswrd.getText();
        String user = txtUser.getText();
        
       
        
        
        
        
        

    }

}
