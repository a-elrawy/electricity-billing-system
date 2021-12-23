package com.user.electricity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class regionController extends SwitchingController implements Initializable {
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
    private TableColumn<billsData, String> address1;
    @FXML
    private TableColumn<billsData, Integer> bill1;
    @FXML
    private TableColumn<billsData, Double> com1;
    @FXML
    private TableColumn<billsData, String> name1;
    @FXML
    private TableColumn<billsData, Double> value1;
        @FXML
    private TableColumn<billsData, String> address2;
    @FXML
    private TableColumn<billsData, Integer> bill2;
    @FXML
    private TableColumn<billsData, Double> com2;
    @FXML
    private TableColumn<billsData, String> name2;
    @FXML
    private TableColumn<billsData, Double> value2;



    @FXML
    private TableView<billsData> table1;
    @FXML
    private TableView<billsData> table2;
    @FXML
    private TableView<billsData> table3;

    ArrayList<ObservableList<billsData>> lists = new ArrayList<>(3);

    public void setColumnNames(){
        set(billC, nameC, addressC, valueC, comC);
        set(bill1, name1, address1, value1, com1);
        set(bill2, name2, address2, value2, com2);
        table1.setItems(lists.get(0));
        table2.setItems(lists.get(1));
        table3.setItems(lists.get(2));
    }

    static void set(TableColumn<billsData, Integer> bill, TableColumn<billsData, String> name, TableColumn<billsData, String> address, TableColumn<billsData, Double> value, TableColumn<billsData, Double> com) {
        bill.setCellValueFactory(new PropertyValueFactory<>("billNo"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        com.setCellValueFactory(new PropertyValueFactory<>("consumption"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String[] regions = {"Cairo", "Giza", "Alex"};
            for (int i = 0; i < regions.length; i++) {
                ArrayList<Customer> customers = Customer.getCustomersByRegion(regions[i]);
                ObservableList<billsData> list = FXCollections.observableArrayList();
                for(Customer c : customers){
                    list.add(new billsData(c.getId(),c.getUsername(),c.getAddress(),c.getAmount(),c.getRealConsumption()));
                }
                lists.add(list);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        setColumnNames();
    }



}
