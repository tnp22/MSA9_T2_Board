package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class editController {

    @FXML
    private Button btnCancle;

    @FXML
    private Button btnEdit;

    @FXML
    private TextArea contentEdit;

    @FXML
    private TextField titleEdit;

    @FXML
    void edit(ActionEvent event) throws IOException {
    	// 정보를 그대로 Board 로 전달
    	
    	Main.setRoot("Board");
    }

    @FXML
    void toCancle(ActionEvent event) throws IOException {
    	Main.setRoot("View");
    }

	public void passContent(String content) {
		contentEdit.setText(content);
		
	}
	public void passTitle(String title) {
		contentEdit.setText(title);
		
	}

		

}
