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

    @FXML
    private Button pay;
    @FXML
    private TextField LastMonth;
    @FXML
    private Label error;
    @FXML
    private Label errorm;
    public void initialize() throws IOException, ClassNotFoundException {
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        assert customer != null;
        try {
            customer_name_p.setText(customer.username);
            email_p.setText(customer.getEmail());
            government_p.setText(customer.getRegion());
            meter_code_p.setText(customer.getMeterCode());
            address_p.setText(customer.getAddress());
        } catch (Exception e){
            try {
                errorm.setVisible(false);
                error.setVisible(false);
                pay.setVisible(false);
            }catch (Exception ignored){}
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
        if (customer.getRealConsumption() == 0) {
            error.setVisible(true);
            return;
        }
        error.setVisible(false);
        double monthlyRead;
        int lastMonth;
        try {
            monthlyRead = Double.parseDouble(MonthlyRead.getText());
            lastMonth = Integer.parseInt(LastMonth.getText());
            errorm.setVisible(false);
        } catch (Exception e) {
            errorm.setVisible(true);
            return;
        }

        if (customer.getRealConsumption() - monthlyRead < 50) {
            customer_name_2.setText(customer.username);
            government_2.setText(customer.getRegion());
            address_2.setText(customer.getAddress());
            real_comsuption_p.setText(customer.getRealConsumption() + "");
            double monthlyReading = monthlyRead;
            if (lastMonth - customer.getLastMonth() > 3 && customer.getLastMonth() != 0)
                Utilities.sendEmail(customer, "Warning\n you Haven't paid a bill for the last three months");
            double charges = Utilities.calculateCharge(monthlyReading);
            charges_p.setText(charges + "");
            pay.setVisible(true);
            customer.setAmount(monthlyRead);
            customer.setLastMonth(lastMonth);
            Customer.update_customer(customer);
        } else
            pay.setVisible(false);
    }
    public void Pay(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        double monthlyRead = Double.parseDouble(MonthlyRead.getText());
        double charges = monthlyRead * Utilities.chargeConstant;
        charges += Utilities.tarrif*charges;
        assert customer != null;
        Utilities.write(new billsData(Utilities.getNumberOfObjects(Utilities.BillsFilename),customer.getUsername(),customer.getAddress(),
                charges,monthlyRead),Utilities.BillsFilename);
        switchToCustomerProfile(event);
    }

}
