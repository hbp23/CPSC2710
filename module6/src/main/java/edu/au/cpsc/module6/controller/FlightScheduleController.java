package edu.au.cpsc.module6.controller;

import edu.au.cpsc.module6.data.dbManager;
import edu.au.cpsc.module6.model.ScheduledFlight;
import edu.au.cpsc.module6.uimodel.ScheduledFlightDetailModel;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import java.time.LocalTime;
import java.util.HashSet;

public class FlightScheduleController {

    @FXML
    private FlightScheduleTableViewController flightScheduleTableViewController;

    @FXML
    private FlightScheduleDetailViewController flightScheduleDetailViewController;

    @FXML
    private Button updateButton, newButton, deleteButton;

    @FXML
    private MenuItem updateMenuItem, newMenuItem, deleteMenuItem;
    
    public void initialize() {
        flightScheduleTableViewController.showScheduledFlights(dbManager.getDataBase().getScheduledFlights());
        flightScheduleTableViewController.onScheduledFlightSelectionChanged(event -> showFlight(event.getSelectedScheduledFlight()));
        ScheduledFlightDetailModel uiModel = flightScheduleDetailViewController.getModel();
        bindButtonMenuEnable(uiModel);
        bindButtonMenuLabel(uiModel);
        showFlight(null);
    }

    private void bindButtonMenuLabel(ScheduledFlightDetailModel uiModel) {
        StringBinding labelProperty = Bindings.when(uiModel.newProperty()).then("Add").otherwise("Update");
        updateButton.textProperty().bind(labelProperty);
        updateMenuItem.textProperty().bind(labelProperty);
    }

    private void bindButtonMenuEnable(ScheduledFlightDetailModel uiModel) {
        updateButton.disableProperty().bind(uiModel.modifiedProperty().not());
        updateMenuItem.disableProperty().bind(uiModel.modifiedProperty().not());
        newButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        newMenuItem.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        deleteButton.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
        deleteMenuItem.disableProperty().bind(uiModel.modifiedProperty().or(uiModel.newProperty()));
    }

    private void showFlight(ScheduledFlight sf) {
        flightScheduleDetailViewController.showScheduledFlight(sf);
    }

    @FXML
    protected void updateButtonAction() {
        if (flightScheduleDetailViewController.getModel().isNew()) {
            addScheduledFlight();
        } else {
            updateScheduledFlight();
        }
    }

    private void addScheduledFlight() {
        ScheduledFlight sf = new ScheduledFlight("", "", LocalTime.now(), "", LocalTime.now(), new HashSet<String>());
        if (!flightScheduleDetailViewController.updateScheduledFlight(sf)) { return; }
        dbManager.getDataBase().addScheduledFlight(sf);
        saveDatabaseAndUpdateTable(sf);
    }

    private void updateScheduledFlight() {
        ScheduledFlight sf = getScheduledFlightBeingEdited();
        if (!flightScheduleDetailViewController.updateScheduledFlight(sf)) { return; }
        dbManager.getDataBase().updateScheduledFlight(sf);
        saveDatabaseAndUpdateTable(sf);
    }

    private void saveDatabaseAndUpdateTable(ScheduledFlight sf) {
        dbManager.saveDatabase();
        flightScheduleTableViewController.showScheduledFlights(dbManager.getDataBase().getScheduledFlights());
        flightScheduleTableViewController.select(sf);
    }

    @FXML
    protected void newButtonAction() {
        flightScheduleTableViewController.select(null);
    }

    @FXML
    protected void deleteButtonAction() {
        if (flightScheduleDetailViewController.getModel().isNew()) {
            flightScheduleTableViewController.select(null);
        } else {
            dbManager.getDataBase().removeScheduledFlight(getScheduledFlightBeingEdited());
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

    public ScheduledFlight getScheduledFlightBeingEdited() {
        return flightScheduleTableViewController.getSelectedScheduledFlight();
    }
}