module lk.ijse.aurasams {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens lk.ijse.aurasams to javafx.fxml;
    exports lk.ijse.aurasams;
    
    exports lk.ijse.aurasams.controller;
    opens lk.ijse.aurasams.controller to javafx.fxml;
}
