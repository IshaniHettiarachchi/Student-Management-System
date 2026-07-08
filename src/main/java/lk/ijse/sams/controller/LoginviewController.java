package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import lk.ijse.sams.dto.UserDTO;
import lk.ijse.sams.model.UserModel;
import lk.ijse.sams.App;
import java.io.IOException;



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
        
        UserDTO dto  = new UserDTO(user,password);
        
        UserModel model =new UserModel();
        
        try {

          boolean isValid = model.checkLogin(dto);

          if (isValid) {

           System.out.println("Login Success");

           App.setRoot("view/adminview");

         } else {

           System.out.println("Invalid Username or Password");

         }

        } catch (SQLException | IOException e) {

       e.printStackTrace();

  }
 }
        
        
        
       
        
        
        
        
        

    }


