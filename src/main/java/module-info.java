module com.example.projetovelocity {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetovelocity to javafx.fxml;
    exports com.example.projetovelocity;
}