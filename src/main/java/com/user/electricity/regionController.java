package com.user.electricity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class regionController extends AdminController implements Initializable {
    @FXML
    private TableColumn<billsData, String> addressC;

    @FXML
    private TableColumn<billsData, Integer> billC;

    @FXML
    private TableColumn<billsData, Double> comC;

    @FXML
    private TableColumn<billsData, String> nameC;

    @FXML
    private TableColumn<billsData, Double> valueC;
    @FXML
    private TableView<billsData> table1;

    ObservableList<billsData> list = FXCollections.observableArrayList(
            new billsData(1, "mona","10 st", 325.5,36.2),
            new billsData(2, "omar","56 st", 215,18.5),
            new billsData(3, "ali","41 st",415.6,12.3),
            new billsData(4, "nada","2 st",125,41.2)
    );
    public void setColumnNames(){
            billC.setCellValueFactory(new PropertyValueFactory<billsData,Integer>("billNo"));
            nameC.setCellValueFactory(new PropertyValueFactory<billsData,String>("name"));
            addressC.setCellValueFactory(new PropertyValueFactory<billsData,String>("address"));
            valueC.setCellValueFactory(new PropertyValueFactory<billsData,Double>("value"));
            comC.setCellValueFactory(new PropertyValueFactory<billsData,Double>("comsuption"));
            table1.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumnNames();
    }
}
