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
    private  TextField meterCodeF;
    @FXML
    private Text error;
    @FXML
    void submit(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = new Customer(id,name.getText(),email.getText(),password.getText(),address.getText(),region.getText(),meterCode,path);
        Customer.update_customer(customer);
        switchToRegions(event);
    }
    public  void initialize() throws IOException, ClassNotFoundException {
        try {
            meterCodeLabel.setText(meterCode);
            Customer customer = Customer.read_customer(meterCode);
            id = customer.id;
            path = customer.getPathToContract();
            name.setText(customer.username);
            address.setText(customer.getAddress());
            email.setText(customer.getEmail());
            region.setText(customer.getRegion());
        } catch (Exception e){
            error.setVisible(false);
        }

    }

    public void add(ActionEvent e) throws IOException {
        switchToAdd(e);
    }
    public void delete(ActionEvent e) throws IOException, ClassNotFoundException {
        try {
            String metercode =meterCodeF.getText();
            Customer.remove_customer(metercode);
            error.setVisible(false);
            switchToRegions(e);
        }catch (Exception exception){
            error.setVisible(true);
        }
    }
    public void modify(ActionEvent e) throws IOException {
        try {
            String metercode =meterCodeF.getText();
            Customer.read_customer(metercode);
            UpdateController.meterCode =meterCodeF.getText();
            error.setVisible(false);
            switchToUpdate(e);
        }catch (Exception exception){
            error.setVisible(true);
        }
    }

}
