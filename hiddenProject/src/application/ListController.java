package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ListController {

    @FXML
    private TableView<?> boardTableView;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<?, ?> colNo;

    @FXML
    private TableColumn<?, ?> colRegDate;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colView;

    @FXML
    private TableColumn<?, ?> colWriter;

    @FXML
    private TextField searchTable;

    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void add(ActionEvent event) throws IOException {
    	Main.setRoot("Add");
    }

    @FXML
    void delete(ActionEvent event) {

    }

}
