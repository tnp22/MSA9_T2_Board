package application;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mainService.DTO.Board;

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
    private Label upd_date;

    @FXML
    private Label writer_id;
    
    @FXML
    private Label red_date;
    
    @FXML
    private Label view_su;

    Board board = new Board();
    
    @FXML
    void toBack(ActionEvent event) throws IOException {
    	FXMLLoader listFXML = new FXMLLoader(getClass().getResource("Board.fxml"));
    	// B 화면
    	Parent root = listFXML.load();
    	//MainController maincontroller = listFXML.getController();
    	
    	//maincontroller.passData(this.board);
    	//ListController ls = new ListController();
    	//ls.restart();
    	Main.setRoot(root);
    }
    

    @FXML
    void toEdit(ActionEvent event) throws IOException {
    	//정보를 그대로 view로 전달
    	String title = titleView.getText();
    	String content = contentView.getText();
    	
    	FXMLLoader editFXML= new FXMLLoader(getClass().getResource("Edit.fxml"));
    	
    	Parent editRoot = editFXML.load();
    	editController editcontroller = editFXML.getController();
    	
    	editcontroller.passData(this.board);
    	
    	Main.setRoot(editRoot);
    }

	public void passData(Board currentboard) {
		// TODO Auto-generated method stub
		this.board = currentboard;
		titleView.setText(currentboard.getTitle());
    	contentView.setText(currentboard.getContent());
    	writer_id.setText(currentboard.getWriter());
    	view_su.setText(Integer.toString(currentboard.getView()));
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	red_date.setText(dateFormat.format(currentboard.getRegDate()));
        if(currentboard.getUpdDate()==null) {
        	upd_date.setText("수정일 없음");
        }
        else {
        	upd_date.setText(dateFormat.format(currentboard.getUpdDate()));
        }
    	
	}

}
