package application;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button btnBoard;

    @FXML
    private Button btnClose;

    @FXML
    void close(ActionEvent event) {
    	Main.exit();
    }

    @FXML
    void toBoard(ActionEvent event) throws IOException {
    	Main.setRoot("Board");

    }
}
