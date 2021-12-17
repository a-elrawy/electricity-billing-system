module com.user.electricity {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.user.electricity to javafx.fxml;
    exports com.user.electricity;
}