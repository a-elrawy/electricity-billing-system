package com.user.electricity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SwitchingController {
    private static Stage stage;
    private static Scene scene;
    private  static Parent root;
    public static int index = 0;

    @FXML
    private Button admin;
    @FXML
    private Button operator;
    @FXML
    private Button customer;

    public void setAdmin(ActionEvent event) throws IOException {
        index=2;switchToLogin(event);
    }
    public void setCustomer(ActionEvent event) throws IOException {
        index=0;switchToLogin(event);
    }
    public void setOperator(ActionEvent event) throws IOException {
        index=1;switchToLogin(event);
    }

    public static void switchToLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(SwitchingController.class.getResource("login.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setHeight(437);stage.setWidth(600);
        scene = new Scene(root);
        if (index != 0){
            Node node = root.lookup("#sign");
            node.setVisible(false);
            node = root.lookup("#log");
            node.setLayoutX(390);
        }
        scene.getStylesheets().add(SwitchingController.class.getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToSignup(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(SwitchingController.class.getResource("SignUp.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        Node node = root.lookup("#supLabel");node.setVisible(false);
        scene = new Scene(root);
        stage.setWidth(625);stage.setHeight(525);
        scene.getStylesheets().add(SwitchingController.class.getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToOperator(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(SwitchingController.class.getResource("OperatorProfile.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(625);stage.setHeight(525);
        scene.getStylesheets().add(SwitchingController.class.getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToAdd(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(SwitchingController.class.getResource("SignUp.fxml")));
        Node node = root.lookup("#sup"); node.setVisible(false);
        node = root.lookup("#sup1"); node.setVisible(false);
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(625);stage.setHeight(525);
        scene.getStylesheets().add(SwitchingController.class.getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
