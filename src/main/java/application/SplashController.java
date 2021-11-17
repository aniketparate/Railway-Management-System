package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    public AnchorPane mainpane;
    @FXML
    private AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        splash();
    }

    private void splash() {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception exception) {
                    System.out.println(exception);
                }
                Platform.runLater(new Runnable() {
                    public void run() {
                        try {
                            mainpane = FXMLLoader.load(getClass().getResource("Splash.fxml"));
                            Stage stage = new Stage();
                            Scene scene = new Scene(mainpane);
                            stage.setScene(scene);
                            stage.show();
                            pane.getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }.start();
    }
}