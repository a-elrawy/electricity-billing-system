package com.user.electricity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Admin extends SwitchingController {
    @FXML
    private  TextField meterCode;


    public void add(ActionEvent e) throws IOException {
       switchToAdd(e);
    }
    public void delete(ActionEvent e) throws IOException, ClassNotFoundException {
        String metercode =meterCode.getText();
        Customer.remove_customer(metercode);
    }
    public void modify(ActionEvent e) throws IOException {
        UpdateController.meterCode =meterCode.getText();
        switchToUpdate(e);
    }


}
