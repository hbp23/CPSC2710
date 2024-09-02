package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SeatReservationApplication extends Application {

    private SeatReservation seatReservation;

    @Override
    public void start(Stage stage) throws IOException {
        seatReservation = new SeatReservation();

        HBox bottomButtons = createHBox();
        GridPane infoPane = createGridPane();
        Background backgroundColor = createBackgroundColor();

        BorderPane root = new BorderPane(infoPane, null, null, bottomButtons, null);
        root.setBackground(backgroundColor);

        Scene scene = new Scene(root, 300, 210);
        stage.setScene(scene);
        stage.setTitle("Seat Reservation Editor");
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
        bottomButtons.setAlignment(Pos.CENTER_RIGHT);
        bottomButtons.setSpacing(10);
        bottomButtons.setPadding(new Insets(10, 10, 20, 10));
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

        TextField flightDesignatorText = new TextField();
        infoPane.add(flightDesignatorText, 1, 0);
        DatePicker flightDatePicker = new DatePicker();
        infoPane.add(flightDatePicker, 1, 1);
        TextField firstNameText = new TextField();
        infoPane.add(firstNameText, 1, 2);
        TextField lastNameText = new TextField();
        infoPane.add(lastNameText, 1, 3);
        TextField bagsText = new TextField();
        infoPane.add(bagsText, 1, 4);
        CheckBox flyingWithInfantCheckBox = new CheckBox();
        infoPane.add(flyingWithInfantCheckBox, 1, 5);
        TextField numOfPassengersText = new TextField("1");
        numOfPassengersText.setEditable(false);
        numOfPassengersText.setAlignment(Pos.CENTER_RIGHT);
        infoPane.add(numOfPassengersText, 1, 6);

        ColumnConstraints column0 = new ColumnConstraints(150,150,Double. MAX_VALUE);
        column0.setHgrow(Priority. ALWAYS);
        ColumnConstraints column1 = new ColumnConstraints(150,150,Double. MAX_VALUE);
        infoPane.getColumnConstraints().addAll(column0,column1);

        return  infoPane;
    }

}