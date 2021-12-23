package com.user.electricity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class BillController {
@FXML
private TextField MeterCodef;
@FXML
private Label Billview ;
@FXML
private TextField RKeyField;

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
    private TableView<billsData> table;
    ObservableList<billsData> list = FXCollections.observableArrayList();

    public void setColumnNames(){
        regionController.set(billC, nameC, addressC, valueC, comC);
        table.setItems(list);
    }

    public void initialize() throws IOException, ClassNotFoundException {
        list =  FXCollections.observableArrayList();
        ArrayList<Customer> customers = Customer.getCustomersByRegion(RKeyField.getText());
        for(Customer c : customers){
            list.add(new billsData(c.getId(),c.getUsername(),c.getAddress(),c.getAmount(),c.getRealConsumption()));
        }
        setColumnNames();
    }
public void printBill(ActionEvent E) throws IOException, ClassNotFoundException {
    String MeterCode = MeterCodef.getText();
    Customer C = Customer.read_customer(MeterCode);
    Bill B = new Bill(MeterCode , C.getUsername(), 0.14 , 0.14*C.getAmount() ,C.getAmount() );
    Billview.setText(B.toString());
    }
    public void Cancel_Subscription (ActionEvent E) throws IOException, ClassNotFoundException {
        String MeterCode = MeterCodef.getText();
        Customer.remove_customer(MeterCode);
    }
    public void validate (ActionEvent E) throws  IOException, ClassNotFoundException{
        String MeterCode = MeterCodef.getText();
        Customer C = Customer.read_customer(MeterCode);
        if (C.getAmount() == C.getRealConsumption()){
            System.out.println("Right");
        }
    }
    public void ViewRegion(ActionEvent event) throws IOException, ClassNotFoundException {
        String region = RKeyField.getText();
        ArrayList<Customer> customers = Customer.getCustomersByRegion(region);

    }
}


