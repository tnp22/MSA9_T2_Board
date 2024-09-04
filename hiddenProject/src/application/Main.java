package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene scene;
	private static Stage ExitStage;
	
	@Override
	public void start(Stage stage) throws IOException {
			ExitStage = stage;
			scene = new Scene(loadFXML("Main"));
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
	}
	public static void exit() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("프로그램 종료");
		alert.setHeaderText("프로그램을 종료하시겠습니까?");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("프로그램을 종료합니다.");
			ExitStage.close();
		}
		
	}
	
	/**
	 * Scene 의 컨테이너를 불러온 FXML 로 지정하는 메소드
	 * @param fxml
	 * @throws IOException
	 */
	public static void setRoot(String fxml) throws IOException{
		scene.setRoot(loadFXML(fxml));
	}
	
	/**
	 * FXML 파일 읽어오는 메소드
	 * @param fxml
	 * @return
	 * @throws IOException
	 */
	private static Parent loadFXML(String fxml) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml+".fxml"));
		return fxmlLoader.load();
	}
	
	static FXMLLoader getFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader;
	}
	
	public static void setRoot(Parent root) throws IOException{
		scene.setRoot(root);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
		
		
}
