package com.user.electricity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class customerComplaintController extends SwitchingController{
    @FXML
    private Button Complaint_button;

    @FXML
    private Button Inbox_button;

    @FXML
    private Button bills_button;

    @FXML
    private TextArea comText;

    @FXML
    private Label logout_button;

    @FXML
    private Button sendBut;

    public void sendComplaint(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = Customer.read_customer(Utilities.CurrentUserID);
        String complaintText = comText.getText();
        assert customer != null;
        Complaint complaint = new Complaint(customer.username,customer.getAddress(),customer.getRegion(),complaintText);
        Utilities.write(complaint,Utilities.ComplaintsFilename);
        switchToCustomerProfile(event);
    }


}
