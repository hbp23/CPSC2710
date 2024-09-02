package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.time.LocalDate;

public class SeatReservationApplication extends Application implements EventHandler<ActionEvent> {

    private SeatReservation seatReservation;
    private TextField flightDesignatorText;
    private DatePicker flightDatePicker;
    private TextField firstNameText;
    private TextField lastNameText;
    private TextField bagsText;
    private CheckBox flyingWithInfantCheckBox;
    private TextField numOfPassengersText;

    private Button cancelButton;
    private Button saveButton;




    @Override
    public void start(Stage stage) throws IOException {
        seatReservation = new SeatReservation("DL1331", LocalDate.parse("2024-09-02"), "Harsh", "Patel", 2, false);

        HBox bottomButtons = createHBox();
        GridPane infoPane = createGridPane();
        Background backgroundColor = createBackgroundColor();

        BorderPane root = new BorderPane(infoPane, null, null, bottomButtons, null);
        root.setBackground(backgroundColor);

        Scene scene = new Scene(root, 300, 210);
        stage.setScene(scene);
        stage.setTitle("Seat Reservation Editor");

        updateUI();

        flyingWithInfantCheckBox.addEventHandler(ActionEvent.ACTION, this);
        saveButton.setOnAction(event -> saveButtonPressed());
        cancelButton.setOnAction(event -> cancelButtonPressed());

        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (flyingWithInfantCheckBox.isSelected()) {
            numOfPassengersText.setText("2");
        } else {
            numOfPassengersText.setText("1");
        }
    }

    private void cancelButtonPressed() {
        System.out.println("Cancel clicked");
        Platform.exit();
    }

    private void saveButtonPressed() {
        try {
            seatReservation.setFlightDesignator(flightDesignatorText.getText());
            seatReservation.setFlightDate(flightDatePicker.getValue());
            seatReservation.setFirstName(firstNameText.getText());
            seatReservation.setLastName(lastNameText.getText());
            seatReservation.setNumberOfBags(Integer.parseInt(bagsText.getText()));
            if (Integer.parseInt(numOfPassengersText.getText()) > 1) {
                seatReservation.makeFlyingWithInfant();
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }
        finally {
            System.out.println(seatReservation);
            Platform.exit();
        }
    }

    private void updateUI() {
        flightDesignatorText.setText(seatReservation.getFlightDesignator());
        flightDesignatorText.setAlignment(Pos.CENTER_RIGHT);
        flightDatePicker.setValue(seatReservation.getFlightDate());
        firstNameText.setText(seatReservation.getFirstName());
        firstNameText.setAlignment(Pos.CENTER_RIGHT);
        lastNameText.setText(seatReservation.getLastName());
        lastNameText.setAlignment(Pos.CENTER_RIGHT);
        bagsText.setText(String.valueOf(seatReservation.getNumberOfBags()));
        bagsText.setAlignment(Pos.CENTER_RIGHT);

    }

    private Background createBackgroundColor() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, null, null);
        return new Background(backgroundFill);
    }

    private HBox createHBox() {
        HBox bottomButtons = new HBox();
        cancelButton = new Button("Cancel");
        saveButton = new Button("Save");
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

        flightDesignatorText = new TextField();
        infoPane.add(flightDesignatorText, 1, 0);
        flightDatePicker = new DatePicker();
        infoPane.add(flightDatePicker, 1, 1);
        firstNameText = new TextField();
        infoPane.add(firstNameText, 1, 2);
        lastNameText = new TextField();
        infoPane.add(lastNameText, 1, 3);
        bagsText = new TextField();
        infoPane.add(bagsText, 1, 4);
        flyingWithInfantCheckBox = new CheckBox();
        infoPane.add(flyingWithInfantCheckBox, 1, 5);
        numOfPassengersText = new TextField("1");
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