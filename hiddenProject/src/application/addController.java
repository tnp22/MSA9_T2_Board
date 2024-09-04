package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class addController {

    @FXML
    private Button back;

    @FXML
    private Button btnAdd;

    @FXML
    private TextArea contentInput;

    @FXML
    private TextField titleInput;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
    	Main.setRoot("Board");

    }

}
