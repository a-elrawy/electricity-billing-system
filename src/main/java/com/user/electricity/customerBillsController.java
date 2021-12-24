package com.user.electricity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class customerBillsController extends SwitchingController {
    private final static double chargeConstant = 5.5;
    @FXML
    private Button Complaint_button;

    @FXML
    private Button Inbox_button;

    @FXML
    private TextField addtess_p;

    @FXML
    private Button bills_button;

    @FXML
    private TextField charges_p;

    @FXML
    private TextField custeomer_name_p;

    @FXML
    private TextField government_p;

    @FXML
    private Label logout_button;

    @FXML
    private TextField MonthlyRead;

    @FXML
    private TextField real_comsuption_p;

    @FXML
    private Button sendMonth;


    public void PrintBillDetails() throws IOException, ClassNotFoundException {
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        assert customer != null;
        custeomer_name_p.setText(customer.username);
        government_p.setText(customer.getRegion());
        addtess_p.setText(customer.getAddress());
        real_comsuption_p.setText(customer.getRealConsumption()+"");
        double monthlyReading = Double.parseDouble(MonthlyRead.getText());
        double charges = monthlyReading * chargeConstant;
        charges_p.setText(charges + "");
    }

}
