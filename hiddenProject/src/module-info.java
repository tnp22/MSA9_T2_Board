module hiddenProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires lombok;
	requires java.sql;
	requires javafx.base;
	
	opens application to javafx.base, javafx.graphics, javafx.fxml;
	// 리플렉션을 위한 패키지 공개
    opens mainService.DTO to javafx.base;
}
