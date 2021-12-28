package com.user.electricity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ComplaintController extends SwitchingController {
    @FXML
    private TableColumn<Complaint, String> addressC;
    @FXML
    private TableColumn<Complaint, Integer> ComplaintNoC;
    @FXML
    private TableColumn<Complaint, Double> comC;
    @FXML
    private TableColumn<Complaint, String> nameC;

        @FXML
    private TableColumn<Complaint, String> address1;
    @FXML
    private TableColumn<Complaint, Integer> ComplaintNo1;
    @FXML
    private TableColumn<Complaint, Double> com1;
    @FXML
    private TableColumn<Complaint, String> name1;

        @FXML
    private TableColumn<Complaint, String> address2;
    @FXML
    private TableColumn<Complaint, Integer> ComplaintNo2;
    @FXML
    private TableColumn<Complaint, Double> com2;
    @FXML
    private TableColumn<Complaint, String> name2;

        @FXML
    private TableColumn<Complaint, String> address3;
    @FXML
    private TableColumn<Complaint, Integer> ComplaintNo3;
    @FXML
    private TableColumn<Complaint, Double> com3;
    @FXML
    private TableColumn<Complaint, String> name3;
        @FXML
    private TableView<Complaint> table1;
    @FXML
    private TableView<Complaint> table2;
    @FXML
    private TableView<Complaint> table3;
    @FXML
    private TableView<Complaint> table4;

    ArrayList<ObservableList<Complaint>> lists = new ArrayList<>(3);

    public void setColumnNames(){
        set(ComplaintNoC, nameC, addressC, comC);
        set(ComplaintNo1, name1, address1, com1);
        set(ComplaintNo2, name2, address2, com2);
        set(ComplaintNo3, name3, address3, com3);
        table1.setItems(lists.get(0));
        table2.setItems(lists.get(1));
        table3.setItems(lists.get(2));
        table4.setItems(lists.get(3));
    }

    static void set(TableColumn<Complaint, Integer> ComplaintNo, TableColumn<Complaint, String> name, TableColumn<Complaint, String> address, TableColumn<Complaint, Double> com) {
        ComplaintNo.setCellValueFactory(new PropertyValueFactory<>("number"));
        name.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        com.setCellValueFactory(new PropertyValueFactory<>("complaint"));
    }

    public void initialize() {
        try {
            String[] regions = {"Cairo", "Giza", "Alex"};
            ObservableList<Complaint> list;
            for (int i = 0; i < regions.length; i++) {
                list = FXCollections.observableArrayList();
                ArrayList<Complaint> complaints = Complaint.getComplaintsByRegion(regions[i]);
                list.addAll(complaints);
                lists.add(list);
            }
            list = FXCollections.observableArrayList();
            for (ObservableList<Complaint> l : lists) {
                list.addAll(l);
            }
            lists.add(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
        setColumnNames();
    }



}
