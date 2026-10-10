module lk.ijse.sams {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
   

    opens lk.ijse.sams to javafx.fxml;
    opens lk.ijse.sams.controller to javafx.fxml;
    opens lk.ijse.sams.dto to javafx.base;
    
    
    exports lk.ijse.sams;
}
