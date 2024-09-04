package application;

import java.io.IOException;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mainService.DTO.Board;
import mainService.Service.BoardService;
import mainService.Service.BoardServiceImpl;

public class ListController {

	
    @FXML
    private TableView<Board> boardTableView;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<Board, Integer> colNo;

    @FXML
    private TableColumn<Board, String> colRegDate;

    @FXML
    private TableColumn<Board, String> colTitle;

    @FXML
    private TableColumn<Board, Integer> colView;

    @FXML
    private TableColumn<Board, String> colWriter;

    @FXML
    private TextField searchTable;
    
    Board currentboard = new Board();

    static List<Board> boardList = null;
    
    public static BoardService boardService = new BoardServiceImpl();
   
    
    @FXML
    public void initialize() {
    	
    	boardList = boardService.list();
    	
    	// * TableColumn 에 Board 객체의 속성 매핑하기
    	colNo.setCellValueFactory( new PropertyValueFactory<>("No") );
    	colTitle.setCellValueFactory( new PropertyValueFactory<>("Title") );
    	colWriter.setCellValueFactory( new PropertyValueFactory<>("Writer") );
    	colRegDate.setCellValueFactory( new PropertyValueFactory<>("RegDate") );
    	colView.setCellValueFactory( new PropertyValueFactory<>("View") );
    	// (코드 설명)
    	// * new PropertyValueFactory("게터이름")		: 값으로 들어갈 객체의 게터 이름을 지정
    	// ex) new PropertyValueFactory("Title") --> getTitle() 게터 메소드의 get을 제외한 "Title"과 일치
    	// * setCellValueFactory()					: 셀의 값을 지정하는 메소드
    	// ** module-info.java 에 java.base 모듈 추가해야 사용 가능
    	
    	// 테이블뷰에 데이터 추가하기
    	ObservableList<Board> list = FXCollections.observableArrayList(boardList);
    	boardTableView.setItems(list);
    	
    	// 리스트뷰의 항목 선택 이벤트
    	boardTableView.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Board>() {

    		// 선택한 항복이 변경됐을 때 실행되는 메소드
			@Override
			public void changed(ObservableValue<? extends Board> arg0, Board arg1, Board arg2) {
				// 선택한 항목을 currentFood 에 지정
				currentboard = boardTableView.getSelectionModel().getSelectedItem();	// 선택된 항목
				// 선택된 항목 라벨에 텍스트 지정
				//myLabel.setText(currentFood);
			}
    		
		});
    	
    	
    	// 리스트뷰의 클릭 이벤트
    	boardTableView.setOnMouseClicked( new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// 더블 클릭
				if( event.getClickCount() == 2 ) {
					System.out.println("더블 클릭!");
					
					
					// 상세 화면으로 이동 - Detail.fxml 화면으로 이동
					try {
						currentboard = boardTableView.getSelectionModel().getSelectedItem();
						System.out.println("선택된 아이템 : " + currentboard);
						FXMLLoader fxmlLoader = Main.getFXML("View");
						Parent root = fxmlLoader.load();
						viewController detailController = (viewController) fxmlLoader.getController();
						// 데이터 전달
						currentboard.setView(currentboard.getView()+1);
						boardService.update(currentboard);
						detailController.passData(currentboard);
						// 화면 이동
						Main.setRoot(root);
						
						// 화면 이동만
						// Main.setRoot("Detail");			
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
    		
		});
    	
    	
    }
    
    @FXML
    void Search(ActionEvent event) {

    }

    public void resetUI() {
        // Clear the TableView's items
        boardTableView.getItems().clear();
        
        // Optionally reset other UI elements (e.g., labels, input fields)
        // myLabel.setText("");
        
        // Reload data
        loadDataFromDatabase();
    }
    
    private void loadDataFromDatabase() {
        // Clear the existing data
        boardList = boardService.list();
        
    }
    @FXML
    void add(ActionEvent event) throws IOException {
    	Main.setRoot("Add");
    }

    @FXML
    void delete(ActionEvent event) {
    	System.out.println("[삭제] 버튼 클릭!");
    	if( currentboard == null ) {
    		System.err.println("선택된 항목이 없습니다.");
    		return;
    	}
    	int result = boardService.delete(currentboard.getNo());
		if (result > 0) {
			System.out.println("게시글을 삭제하였습니다.");
		} else {
			System.err.println("게시글 삭제에 실패하였습니다.");
		}
    	boardTableView.getItems().remove(currentboard);
    	currentboard = null;
    }

}
