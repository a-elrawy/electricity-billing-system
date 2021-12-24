package com.user.electricity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class customerProfileController extends SwitchingController{
    @FXML
    private Button Complaint_button;

    @FXML
    private Button Inbox_button;

    @FXML
    private TextField address_p;

    @FXML
    private Button bills_button;

    @FXML
    private TextField customer_name_p;

    @FXML
    private TextField email_p;

    @FXML
    private TextField government_p;

    @FXML
    private Label logout_button;

    @FXML
    private TextField meter_code_p;

    public void initialize() throws IOException, ClassNotFoundException {
        System.out.println(Utilities.CurrentUserID);
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        assert customer != null;
        customer_name_p.setText(customer.username);
        email_p.setText(customer.getEmail());
        government_p.setText(customer.getRegion());
        meter_code_p.setText(customer.getMeterCode());
        address_p.setText(customer.getAddress());
    }
}
