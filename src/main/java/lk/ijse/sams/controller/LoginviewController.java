package lk.ijse.sams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import lk.ijse.sams.dto.UserDTO;
import lk.ijse.sams.App;
import java.io.IOException;
import javafx.scene.control.Alert;
import lk.ijse.sams.bo.custom.UserBO;
import lk.ijse.sams.bo.custom.impl.UserBOImpl;



public class LoginviewController {
    
private final UserBO userBO = new UserBOImpl();

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
        
        
        try {

          UserDTO loggedUser = userBO.checkLogin(dto);

          if (loggedUser != null) {

             System.out.println("Login Success");
             
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(" Login successfully!");
                alert.showAndWait();

          if (loggedUser.getRole().equals("ADMIN")) {

             App.setRoot("view/adminview");

           } else if (loggedUser.getRole().equals("LECTURER")) {

             App.setRoot("view/lecturerview");
 
         }

        } else {

             System.out.println("Invalid Username or Password");
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Login failed!");
                alert.showAndWait();

          }

         } catch (SQLException | IOException e) {

        e.printStackTrace();

  }
   
    }
}
 
        
       
        
        
        
        
        

    


