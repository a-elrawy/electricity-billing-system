package com.user.electricity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class UpdateController extends SwitchingController {
    public static String meterCode;
    public static String path;
    public static int id;
    public static int tempPassword;
    @FXML
    private TextField name;

    @FXML
    private TextField region;

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Label meterCodeLabel;

    @FXML
    void submit(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = new Customer(id,name.getText(),email.getText(),password.getText(),address.getText(),region.getText(),meterCode,path);
        Customer.update_customer(customer);
    }
    public  void initialize() throws IOException, ClassNotFoundException {
        meterCodeLabel.setText(meterCode);
        Customer customer = Customer.read_customer(meterCode);
        assert customer != null;
        id = customer.id;
        path = customer.getPathToContract();
        name.setText(customer.username);
        address.setText(customer.getAddress());
        email.setText(customer.getEmail());
        region.setText(customer.getRegion());
    }

}
