package com.user.electricity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class customerProfileController extends SwitchingController{


    @FXML
    private TextField address_p;

    @FXML
    private TextField customer_name_p;

    @FXML
    private TextField email_p;

    @FXML
    private TextField government_p;

    @FXML
    private TextField meter_code_p;
    @FXML
    private TextArea comText;
    private final static double chargeConstant = 5.5;

    @FXML
    private TextField address_2;

    @FXML
    private TextField charges_p;

    @FXML
    private TextField customer_name_2;

    @FXML
    private TextField government_2;

    @FXML
    private TextField MonthlyRead;

    @FXML
    private TextField real_comsuption_p;

    public void initialize() throws IOException, ClassNotFoundException {
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        assert customer != null;
        try {
            customer_name_p.setText(customer.username);
            email_p.setText(customer.getEmail());
            government_p.setText(customer.getRegion());
            meter_code_p.setText(customer.getMeterCode());
            address_p.setText(customer.getAddress());
        } catch (Exception ignored){

        }

    }
    public void sendComplaint(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        String complaintText = comText.getText();
        assert customer != null;
        Complaint complaint = new Complaint(customer.username,customer.getAddress(),customer.getRegion(),complaintText);
        Utilities.write(complaint,Utilities.ComplaintsFilename);
        switchToCustomerProfile(event);
    }

    public void PrintBillDetails() throws IOException, ClassNotFoundException {
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        assert customer != null;
        customer_name_2.setText(customer.username);
        government_2.setText(customer.getRegion());
        address_2.setText(customer.getAddress());
        real_comsuption_p.setText(customer.getRealConsumption()+"");
        double monthlyReading = Double.parseDouble(MonthlyRead.getText());
        double charges = monthlyReading * chargeConstant;
        charges_p.setText(charges + "");
    }


}
