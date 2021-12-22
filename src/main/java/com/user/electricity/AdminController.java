package com.user.electricity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController {

    public void switchToRegions(ActionEvent event) throws IOException{
        SwitchingController.switchToRegions(event);
    }
    public void switchToAllStatistics(ActionEvent event) throws IOException{
       SwitchingController.switchToAllStatistics(event);
    }
}