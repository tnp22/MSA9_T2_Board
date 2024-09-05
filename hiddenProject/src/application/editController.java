package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mainService.DTO.Board;

public class editController {

    @FXML
    private Button btnCancle;

    @FXML
    private Button btnEdit;

    @FXML
    private TextArea contentEdit;

    @FXML
    private TextField titleEdit;
    
    Board board = new Board();

    @FXML
    void edit(ActionEvent event) throws IOException {
    	// 정보를 그대로 Board 로 전달
    	
    	String title = titleEdit.getText();
		//System.out.print("작성자 : ");
		String content = contentEdit.getText();
		//System.out.print("내용 : ");
		board.setTitle(title);
		board.setContent(content);
    	ListController.boardService.update(board);
    	
    	FXMLLoader fxmlLoader = Main.getFXML("View");
		Parent root = fxmlLoader.load();
		viewController detailController = (viewController) fxmlLoader.getController();
		// 데이터 전달
		detailController.passData(this.board);
		// 화면 이동
		Main.setRoot(root);
    }

    @FXML
    void toCancle(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = Main.getFXML("View");
		Parent root = fxmlLoader.load();
		viewController detailController = (viewController) fxmlLoader.getController();
		// 데이터 전달
		detailController.passData(this.board);
		// 화면 이동
		Main.setRoot(root);
    }

	public void passData(Board currentboard) {
		this.board=currentboard;
		titleEdit.setText(currentboard.getTitle());
    	contentEdit.setText(currentboard.getContent());
	}

		

}
