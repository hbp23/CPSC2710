package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SeatReservationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox bottomButtons = createHBox();
        GridPane infoPane = createGridPane();
        Background backgroundColor = createBackgroundColor();

        BorderPane root = new BorderPane(infoPane, null, null, bottomButtons, null);
        root.setBackground(backgroundColor);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Seat Reservation Application");
        stage.show();
    }

    private Background createBackgroundColor() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, null, null);
        return new Background(backgroundFill);
    }

    private HBox createHBox() {
        HBox bottomButtons = new HBox();
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");
        bottomButtons.getChildren().addAll(cancelButton, saveButton);
        return bottomButtons;
    }

    private GridPane createGridPane() {
        GridPane infoPane = new GridPane();

        Label flightDesignatorLabel = new Label("Flight Designator:");
        infoPane.add(flightDesignatorLabel, 0, 0);
        Label flightDateLabel = new Label("Flight Date:");
        infoPane.add(flightDateLabel, 0, 1);
        Label firstNameLabel = new Label("First Name:");
        infoPane.add(firstNameLabel, 0, 2);
        Label lastNameLabel = new Label("Last Name:");
        infoPane.add(lastNameLabel, 0, 3);
        Label bagsLabel = new Label("Bags:");
        infoPane.add(bagsLabel, 0, 4);
        Label flyingWithInfantLabel = new Label("Flying with infant?");
        infoPane.add(flyingWithInfantLabel, 0, 5);
        Label numOfPassengers = new Label("Number of passengers:");
        infoPane.add(numOfPassengers, 0, 6);



        return  infoPane;
    }

}