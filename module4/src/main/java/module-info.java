module edu.au.cpsc.module4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;


    opens edu.au.cpsc.module4 to javafx.fxml;
    exports edu.au.cpsc.module4;
    exports edu.au.cpsc.module4.model;
    opens edu.au.cpsc.module4.model to javafx.fxml;
    exports edu.au.cpsc.module4.controller;
    opens edu.au.cpsc.module4.controller to javafx.fxml;
}