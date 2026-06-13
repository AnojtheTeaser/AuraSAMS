module lk.ijse.aurasams {
    requires javafx.controls;
    requires javafx.fxml;

    opens lk.ijse.aurasams to javafx.fxml;
    exports lk.ijse.aurasams;
}
