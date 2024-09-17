package edu.au.cpsc.module4.controller;

import edu.au.cpsc.module4.model.ScheduledFlight;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class FlightScheduleTableViewController {

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorColumn, departureAirportIdentColumn, arrivalAirportIdentColumn, daysOfWeekColumn;

    @FXML
    private TableView<ScheduledFlight> flightScheduleTableView;

    public void initialize() {
        flightDesignatorColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("flightDesignator"));
        departureAirportIdentColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("departureAirportIdent"));
        arrivalAirportIdentColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("arrivalAirportIdent"));
        daysOfWeekColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("daysOfWeekFormatted"));
        flightScheduleTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());
    }

    public void showScheduledFlights(List<ScheduledFlight> scheduledFlights) {
        SortedList<ScheduledFlight> sortedList = new SortedList<>(FXCollections.observableList(scheduledFlights));
        flightScheduleTableView.setItems(sortedList);
        sortedList.comparatorProperty().bind(flightScheduleTableView.comparatorProperty());
        flightScheduleTableView.refresh();
    }

    public void onScheduledFlightSelectionChanged(EventHandler<ScheduledFlightTableEvent> handler) {
        flightScheduleTableView.addEventHandler(ScheduledFlightTableEvent.FLIGHT_SELECTED, handler);
    }

    private void tableSelectionChanged() {
        ScheduledFlight selectedScheduledFlight = flightScheduleTableView.getSelectionModel().getSelectedItem();
        ScheduledFlightTableEvent event = new ScheduledFlightTableEvent(ScheduledFlightTableEvent.FLIGHT_SELECTED, selectedScheduledFlight);
        flightScheduleTableView.fireEvent(event);
    }

    public void select(ScheduledFlight sf) {
        flightScheduleTableView.getSelectionModel().select(sf);
    }

    public static class ScheduledFlightTableEvent extends Event {

        public static final EventType<ScheduledFlightTableEvent> ANY = new EventType<>(Event.ANY, "ANY");

        public static final EventType<ScheduledFlightTableEvent> FLIGHT_SELECTED = new EventType<>(ANY, "FLIGHT_SELECTED");

        private ScheduledFlight sf;

        public ScheduledFlightTableEvent(EventType<? extends Event> eventType, ScheduledFlight sf) {
            super(eventType);
            this.sf = sf;
        }

        public ScheduledFlight getSelectedScheduledFlight() {
            return sf;
        }
    }

}
