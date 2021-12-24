package com.user.electricity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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

    public void sendComplaint(){
        String complaint = comText.getText();
        // take complaint and send it to the file
    }


}
