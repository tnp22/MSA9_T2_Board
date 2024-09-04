package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class viewController {

    @FXML
    private Button back;

    @FXML
    private Button btnEdit;

    @FXML
    private TextArea contentView;

    @FXML
    private TextField titleView;

    @FXML
    void toBack(ActionEvent event) throws IOException {
    	Main.setRoot("Board");
    }

    @FXML
    void toEdit(ActionEvent event) throws IOException {
    	//정보를 그대로 view로 전달
    	String title = titleView.getText();
    	String content = contentView.getText();
    	
    	FXMLLoader editFXML= new FXMLLoader(getClass().getResource("Edit.fxml"));
    	
    	editController editcontroller = editFXML.getController();
    	
    	editcontroller.passTitle(title);
    	editcontroller.passContent(content);
    	
    	Parent editRoot = editFXML.load();
    	
    	Main.setRoot("Edit.fxml");

    }

}
