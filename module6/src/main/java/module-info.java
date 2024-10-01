module edu.au.cpsc {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;

    opens edu.au.cpsc.part1 to javafx.fxml;
    exports edu.au.cpsc.part1;

    opens edu.au.cpsc.module6 to javafx.fxml;
    exports edu.au.cpsc.module6;
    opens edu.au.cpsc.module6.model to javafx.fxml;
    exports edu.au.cpsc.module6.model;
    opens edu.au.cpsc.module6.controller to javafx.fxml;
    exports edu.au.cpsc.module6.controller;
    opens edu.au.cpsc.module6.uimodel to javafx.fxml;
    exports edu.au.cpsc.module6.uimodel;
}