package lk.ijse.sams;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import lk.ijse.sams.db.DBConnection;
import java.sql.SQLException;

import java.io.IOException;
import java.sql.Connection;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override

 
public void start(Stage stage) throws IOException {

    try {
        Connection connection = DBConnection.getInstance().getConnection();

        if (connection != null) {
            System.out.println("Database Connected Successfully!");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    scene = new Scene(loadFXML("view/loginview"), 640, 480);
    stage.setScene(scene);
    stage.show();
}
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}