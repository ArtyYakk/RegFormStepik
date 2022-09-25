module com.example.regformstepik {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regformstepik to javafx.fxml;
    exports com.example.regformstepik;
}