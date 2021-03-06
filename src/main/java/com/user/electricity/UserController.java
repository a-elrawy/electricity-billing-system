package com.user.electricity;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class UserController extends SwitchingController {
    private final String[] files = {Utilities.CustomersFilename,Utilities.OperatorsFilename,Utilities.AdminFilename};
    ObservableList<String> governments = FXCollections.observableArrayList("Cairo","Giza","Alex","Sharm EL Sheikh");
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField address;
    @FXML
    private ChoiceBox<String> government;
    @FXML
    private TextField path;
    @FXML
    private Label wrongCombination;
    @FXML
    private Label errorm;
    @FXML

    private void initialize(){
        try {
            errorm.setVisible(false);
            government.setItems(governments);
        }catch (Exception ignored){}
    }

    public void uploadChooser(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif","*.jpeg"));
        File f = fc.showOpenDialog(null);
        if (f != null){
            path.setText(f.getAbsolutePath());
        }
    }
    // Sign UP
    public void signup(ActionEvent event) throws IOException {
        try {
            String region = government.getSelectionModel().getSelectedItem();
            Customer  customer= new Customer(username.getText(),email.getText(),password.getText(),address.getText(),region,path.getText());
            customer.setMeterCode(region.charAt(0)+ String.valueOf(Utilities.UserCount));
            FileHandler.write(customer,Utilities.CustomersFilename);
            switchToLogin(event);
            Utilities.sendEmail(customer,"Signup Confirmation your username is "+ customer.username + " Your Meter code is " + customer.getMeterCode());
        }catch (Exception e ){
            errorm.setVisible(true);
        }

    }
    public void add(ActionEvent event) throws IOException {
        try {
            String region = government.getSelectionModel().getSelectedItem();
            Customer  customer= new Customer(username.getText(),email.getText(),password.getText(),address.getText(),region,path.getText());
            customer.setMeterCode(region.charAt(0)+ String.valueOf(Utilities.UserCount));
            FileHandler.write(customer,Utilities.CustomersFilename);
            switchToRegions(event);
            Utilities.sendEmail(customer,"Signup Confirmation your username is "+ customer.username + " Your Meter code is " + customer.getMeterCode());
        }catch (Exception e ){
            errorm.setVisible(true);
        }
    }

    // Login and Validation
    public void login(ActionEvent event) throws IOException, ClassNotFoundException {
        Person person = new Person(username.getText(),password.getText());
            if(!Files.exists(Path.of(files[SwitchingController.index])))
                wrongCombination.setText("There must be Users");
            if(Utilities.validate_login(person, files[SwitchingController.index])) {
                if(SwitchingController.index == 1)
                    switchToOperator(event);
                else if(SwitchingController.index == 2){
                    switchToRegions(event);
                }
                else if (SwitchingController.index == 0) {
                    switchToCustomerProfile(event);
                }
            }
            else
                wrongCombination.setText("Wrong Username/password");
        }



}