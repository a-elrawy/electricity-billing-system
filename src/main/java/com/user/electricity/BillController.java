package com.user.electricity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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


