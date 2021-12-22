package com.user.electricity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Admin  {
    @FXML
    private  TextField meterCode;
    public  void add (ActionEvent e) throws IOException {
       SwitchingController.switchToAdd(e);
    }
    public  void delete  (ActionEvent e) throws IOException, ClassNotFoundException {
        String metercode =meterCode.getText();
        Customer.remove_customer(metercode);
    }


}
