package com.user.electricity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class Admin extends SwitchingController {
    @FXML
    private  TextField meterCode;
    @FXML
    private Text error;
    public void initialize(){
        error.setVisible(false);
    }
    public void add(ActionEvent e) throws IOException {
       switchToAdd(e);
    }
    public void delete(ActionEvent e) throws IOException, ClassNotFoundException {
        try {
            String metercode =meterCode.getText();
            Customer.remove_customer(metercode);
            error.setVisible(false);
        }catch (Exception exception){
            error.setVisible(true);
        }
    }
    public void modify(ActionEvent e) throws IOException {
        try {
            String metercode =meterCode.getText();
            Customer.read_customer(metercode);
            UpdateController.meterCode =meterCode.getText();
            error.setVisible(false);
            switchToUpdate(e);
        }catch (Exception exception){
            error.setVisible(true);
        }
    }


}
