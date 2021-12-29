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

public class BillController extends SwitchingController{
@FXML
private TextField MeterCodef;
@FXML
private Label Billview ;
@FXML
private TextField RKeyField;
    @FXML
    private TextField MeterCodeF;
    @FXML
    private TextField realConsumption;
    @FXML
    private TextField tariff;

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
    assert C != null;
    double charges = Utilities.calculateCharge(C.getAmount());
    String billdata = "Your Bill Details \n" +
            "-------------------------- \n" +
            "\n Your MeterCode is : " + MeterCode +
            "\n Your Monthly Reading is : " + C.getAmount() +
            "\n Your Tariff is : " + Utilities.tarrif +
            "\n You Have To Pay : " + charges;
    Billview.setText(billdata);
    }
    public void Cancel_Subscription (ActionEvent E) throws IOException, ClassNotFoundException {
        String MeterCode = MeterCodef.getText();
        Customer.remove_customer(MeterCode);
    }
    public void validate (ActionEvent E) throws  IOException, ClassNotFoundException{
        String MeterCode = MeterCodef.getText();
        Customer C = Customer.read_customer(MeterCode);
        assert C != null;
        if (C.getAmount() == C.getRealConsumption()){
            System.out.println("Right");
        }
    }
    public void defineRealConsumption(ActionEvent event) throws IOException, ClassNotFoundException {
        String meterCode = MeterCodeF.getText();
        Customer customer = Customer.read_customer(meterCode);
        assert customer != null;
        customer.setRealConsumption(Double.parseDouble(realConsumption.getText()));
        try{Utilities.tarrif = Double.parseDouble(tariff.getText());}catch (Exception ignored){}
        Customer.update_customer(customer);
    }

}


