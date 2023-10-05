package cs211.project.controllers;

import cs211.project.models.*;
import cs211.project.services.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class JoinedEventController {
    @FXML private TableView joinedEventTable;
    @FXML private TableView joinedTeamTable;

    private EventUserList eventUserList;
    private EventsList eventsList;
    private TeamUserList teamUserList;
    private TeamList teamList;
    private Datasource<EventUserList> eventUserListDatasource;
    private Datasource<EventsList> eventsListDatasource;
    private Datasource<TeamUserList> teamUserListDatasource;
    private Datasource<TeamList> teamListDatasource;
    private String currentUser;
    @FXML
    public void initialize(){
        currentUser = (String) FXRouter.getData();
        eventUserListDatasource = new EventUserFileDatasource("data", "event-user-list.csv");
        eventUserList = eventUserListDatasource.readData();
        eventsListDatasource = new EventsListFileDatasource("data", "events-list.csv");
        eventsList = eventsListDatasource.readData();
        teamUserListDatasource = new TeamUserListFileDatasource("data", "team-user-list.csv");
        teamUserList = teamUserListDatasource.readData();
        teamListDatasource = new TeamListFileDatasource("data", "team-list.csv");
        teamList = teamListDatasource.readData();
        showEventTable(eventsList);
        showTeamTable(teamList);

        joinedEventTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Events>() {
            @Override
            public void changed(ObservableValue observable, Events oldValue, Events newValue) {
                if (newValue != null) {
                    try {
                        // FXRouter.goTo สามารถส่งข้อมูลไปยังหน้าที่ต้องการได้ โดยกำหนดเป็น parameter ที่สอง

                        EventUser eventUser = new EventUser(newValue.getEventName(), currentUser);
                        FXRouter.goTo("event-schedule", eventUser);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        joinedTeamTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Team>() {
            @Override
            public void changed(ObservableValue observable, Team oldValue, Team newValue) {
                if (newValue != null) {
                    try {
                        // FXRouter.goTo สามารถส่งข้อมูลไปยังหน้าที่ต้องการได้ โดยกำหนดเป็น parameter ที่สอง

                        TeamUser teamUser = new TeamUser(newValue.getTeamInEvent(), newValue.getTeamName(), currentUser);
                        FXRouter.goTo("team-table", teamUser);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
    @FXML
    private void showEventTable(EventsList eventsList) {
        TableColumn<Events, String> eventNameColumn = new TableColumn<>("Event Name");
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));

        TableColumn<Events, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        joinedEventTable.getColumns().clear();
        joinedEventTable.getColumns().add(eventNameColumn);
        joinedEventTable.getColumns().add(statusColumn);
        joinedEventTable.getItems().clear();

        // Get the list of events that the current user is joined in from the eventUserList
        ArrayList<String> userJoinedEvents = getUserJoinedEvents(currentUser);

        for (Events event : eventsList.getEvents()) {
            // Check if the event's name is in the list of events that the user has joined
            if (userJoinedEvents.contains(event.getEventName()) && event.getStatus().equals("active")) {
                joinedEventTable.getItems().add(event);
            }
        }
        for (Events event : eventsList.getEvents()) {
            // Check if the event's name is in the list of events that the user has joined
            if (userJoinedEvents.contains(event.getEventName()) && event.getStatus().equals("finish")) {
                joinedEventTable.getItems().add(event);
            }
        }
    }

    @FXML
    private void showTeamTable(TeamList teamList) {
        TableColumn<Team, String> teamNameColumn = new TableColumn<>("Team Name");
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));

        TableColumn<Team, String> eventNameColumn = new TableColumn<>("Event Name");
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamInEvent"));

        joinedTeamTable.getColumns().clear();
        joinedTeamTable.getColumns().add(teamNameColumn);
        joinedTeamTable.getColumns().add(eventNameColumn);
        joinedTeamTable.getItems().clear();

        // Get the list of events that the current user is joined in from the eventUserList
        ArrayList<String> userJoinedEvents = getUserJoinedEvents(currentUser);

        for (Team team : teamList.getTeams()) {
            // Check if the team's associated event is in the list of events that the user has joined
            if (userJoinedEvents.contains(team.getTeamInEvent())) {
                joinedTeamTable.getItems().add(team);
            }
        }
    }


    private ArrayList<String> getUserJoinedEvents(String currentUser) {
        ArrayList<String> userJoinedEvents = new ArrayList<>();

        for (EventUser eventUser : eventUserList.getEventUser()) {
            if (eventUser.isUser(currentUser)) {
                userJoinedEvents.add(eventUser.getEvent());
            }
        }

        return userJoinedEvents;
    }

    @FXML
    private void onBackBtnClick(){
        try {
            FXRouter.goTo("user-profile", currentUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
