module com.example.filesort {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.filesort to javafx.fxml;
    exports com.example.filesort;
}