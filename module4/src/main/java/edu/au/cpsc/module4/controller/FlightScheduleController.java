package edu.au.cpsc.module4.controller;

import edu.au.cpsc.module4.data.dbManager;
import edu.au.cpsc.module4.model.ScheduledFlight;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.event.Event;
import javafx.event.EventType;

import java.util.HashSet;
import java.util.List;

public class FlightScheduleController {

    @FXML
    private FlightScheduleTableViewController flightScheduleTableViewController;

    @FXML
    private FlightScheduleDetailViewController flightScheduleDetailViewController;

    @FXML
    private Button updateButton;

    @FXML
    private MenuItem updateMenuItem;

    private ScheduledFlight scheduledFlightBeingEdited;

    private boolean scheduledFlightBeingEditedIsNew;

    public void initialize() {
        flightScheduleTableViewController.showScheduledFlights(dbManager.getDataBase().getScheduledFlights());
        flightScheduleTableViewController.onScheduledFlightSelectionChanged( event -> showFlight(event.getSelectedScheduledFlight()));
        showFlight(null);
    }

    private void showFlight(ScheduledFlight sf) {
        flightScheduleDetailViewController.showScheduledFlight(sf);
        scheduledFlightBeingEdited = sf == null ? new ScheduledFlight("", "", LocalTime.now(), "", LocalTime.now(), new HashSet<String>()) : sf;
        scheduledFlightBeingEditedIsNew = sf == null;
        String buttonLabel = scheduledFlightBeingEditedIsNew ? "Add" : "Update";
        updateButton.setText(buttonLabel);
        updateMenuItem.setText(buttonLabel);
    }

    @FXML
    protected void updateButtonAction() {
        flightScheduleDetailViewController.updateScheduledFlight(scheduledFlightBeingEdited);
        if (scheduledFlightBeingEditedIsNew) {
            dbManager.getDataBase().addScheduledFlight(scheduledFlightBeingEdited);
        } else {
            dbManager.getDataBase().updateScheduledFlight(scheduledFlightBeingEdited);
        }
        dbManager.saveDatabase();
        flightScheduleTableViewController.showScheduledFlights(dbManager.getDataBase().getScheduledFlights());
        flightScheduleTableViewController.select(scheduledFlightBeingEdited);
    }

    @FXML
    protected void newButtonAction() {
        flightScheduleTableViewController.select(null);
    }

    @FXML
    protected void deleteButtonAction() {
        if(scheduledFlightBeingEditedIsNew) {
            flightScheduleTableViewController.select(null);
        } else {
            dbManager.getDataBase().removeScheduledFlight(scheduledFlightBeingEdited);
            dbManager.saveDatabase();
            flightScheduleTableViewController.showScheduledFlights(dbManager.getDataBase().getScheduledFlights());
        }
    }

    @FXML
    protected void updateMenuAction() {
        updateButtonAction();
    }

    @FXML
    protected void newMenuAction() {
        newButtonAction();
    }

    @FXML
    protected void deleteMenuAction() {
        deleteButtonAction();
    }

    @FXML
    protected void closeMenuAction() {
        Platform.exit();
    }
}