package com.user.electricity;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class stateController extends AdminController implements Initializable  {
    @FXML
    private BarChart<?, ?> bar;

    private void inBarChart(String month, double y1, double y2, double y3){
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Region 1", y1));
        series.getData().add(new XYChart.Data("Region 2", y2));
        series.getData().add(new XYChart.Data("Region 3 ", y3));
        series.setName(month);
        bar.getData().addAll(series);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inBarChart("September", 75.2, 85.1, 91.1);
        inBarChart("October",84.5, 54.7, 63.4);
        inBarChart("November", 65, 74.2,85);
        inBarChart("December",67.2, 51.3, 75.4);
    }
}
