package com.user.electricity;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //    public void switchToLogin(ActionEvent event) throws IOException {
//        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
//        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
//        stage.setScene(scene);
//        stage.show();
//    }
    public void switchToSignup(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}