module com.user.electricity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;


    opens com.user.electricity to javafx.fxml;
    exports com.user.electricity;
}