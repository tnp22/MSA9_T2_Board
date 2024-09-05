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

public class addController {
	
	

    @FXML
    private Button back;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField personInput;
    
    @FXML
    private TextArea contentInput;

    @FXML
    private TextField titleInput;

    @FXML
    void add(ActionEvent event) throws IOException {
    	
    	//System.out.print("제목 : ");
		//String title = sc.nextLine();
		String title = titleInput.getText();
		//System.out.print("작성자 : ");
		String writer = personInput.getText();
		//System.out.print("내용 : ");
		String content = contentInput.getText();
		Board board = new Board(title, writer, content);
		// 게시글 등록 요청
		int result = ListController.boardService.insert(board);
		if (result > 0) {
			System.out.println("★ 게시글이 등록되었습니다.");
		} else {
			System.err.println("★ 게시글이 등록에 실패하였습니다.");
		}
    	// B.fxml을 읽기
    	FXMLLoader listFXML = new FXMLLoader(getClass().getResource("Board.fxml"));
		// B 화면
    	Parent listRoot = listFXML.load();
    	
    	// B.fxml 에 연결되 컨트롤러 bControllor 가져오기
    	//ListController listController = listFXML.getController();
    	// B 화면으로 data 전달 (bController 메소드 호출하면서 data 전달)
    	//Controller.passData(data); // A화면에서 B화면으로 데이터 전달
    	
    	// B 화면으로 이동
    	Main.setRoot(listRoot);
    	
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
    	Main.setRoot("Board");
    }
	
    

}
