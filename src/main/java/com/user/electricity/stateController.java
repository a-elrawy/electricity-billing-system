package com.user.electricity;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class stateController extends SwitchingController implements Initializable  {
    @FXML
    private BarChart<?, ?> bar;
    String[] regions = {"Cairo", "Giza", "Alex"};

    private void inBarChart(String month, double y1, double y2, double y3){
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(regions[0], y1));
        series.getData().add(new XYChart.Data(regions[1], y2));
        series.getData().add(new XYChart.Data(regions[2], y3));
        series.setName(month);
        bar.getData().addAll(series);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            inBarChart("Dec",Customer.getTotal(Customer.getCustomersByRegion(regions[0])),
                                    Customer.getTotal(Customer.getCustomersByRegion(regions[1])),
                                    Customer.getTotal(Customer.getCustomersByRegion(regions[2])));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        inBarChart("September", 75.2, 85.1, 91.1);
//        inBarChart("October",84.5, 54.7, 63.4);
//        inBarChart("November", 65, 74.2,85);
//        inBarChart("December",67.2, 51.3, 75.4);
    }
}
