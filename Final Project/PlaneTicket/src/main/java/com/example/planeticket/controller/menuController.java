package com.example.planeticket.controller;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import com.example.planeticket.database.DBHandler;
import com.example.planeticket.model.tickets;
import com.example.planeticket.model.users;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class menuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button philippinesPlusButton;

    @FXML
    private Button philippinesMinusButton;

    @FXML
    private Button chinaPlusButton;

    @FXML
    private Button chinaMinusButton;

    @FXML
    private Button japanPlusButton;

    @FXML
    private Button japanMinusButton;

    @FXML
    private Label totalCounterLabel;

    @FXML
    private Button backMenuButton;

    @FXML
    private Button confirmMenuButton;


    @FXML
    void initialize() {

        DBHandler dbHandler = new DBHandler();
        totalCounterLabel.setVisible(false);

        // Philippines
        philippinesPlusButton.setOnAction(actionEvent -> {
            dbHandler.addPhilippineTicket(loginController.userId); //putting the assigned userId appropriate to the one that logged in.
            totalCounterLabel.setVisible(true);
            totalCounterLabel.setText("Total: " + dbHandler.countingTotalTickets(loginController.userId));


        });

        philippinesMinusButton.setOnAction(actionEvent -> {
            dbHandler.removePhilippineTicket(loginController.userId); //putting the assigned userId appropriate to the one that logged in.
            totalCounterLabel.setVisible(true);
            totalCounterLabel.setText("Total: " + dbHandler.countingTotalTickets(loginController.userId));
        });

        // China
        chinaPlusButton.setOnAction(actionEvent -> {
            dbHandler.addChinaTicket(loginController.userId); //putting the assigned userId appropriate to the one that logged in.
            totalCounterLabel.setVisible(true);
            totalCounterLabel.setText("Total: " + dbHandler.countingTotalTickets(loginController.userId));


        });

        chinaMinusButton.setOnAction(actionEvent -> {
            dbHandler.removeChinaTicket(loginController.userId); //putting the assigned userId appropriate to the one that logged in.
            totalCounterLabel.setVisible(true);
            totalCounterLabel.setText("Total Tickets: " + dbHandler.countingTotalTickets(loginController.userId));
        });

        // Japan
        japanPlusButton.setOnAction(actionEvent -> {
            dbHandler.addJapanTicket(loginController.userId); //putting the assigned userId appropriate to the one that logged in.
            totalCounterLabel.setVisible(true);
            totalCounterLabel.setText("Total: " + dbHandler.countingTotalTickets(loginController.userId));


        });

        japanMinusButton.setOnAction(actionEvent -> {
            dbHandler.removeJapanTicket(loginController.userId); //putting the assigned userId appropriate to the one that logged in.
            totalCounterLabel.setVisible(true);
            totalCounterLabel.setText("Total Tickets: " + dbHandler.countingTotalTickets(loginController.userId));
        });









        backMenuButton.setOnAction(actionEvent -> {
            backMenuButton.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/login.fxml"));

            try {

                fxmlLoader.load();

            } catch(IOException e){
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            loginController LoginController = fxmlLoader.getController();



            stage.show();

        });

        confirmMenuButton.setOnAction(actionEvent -> {

            confirmMenuButton.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/purchaseSuccess.fxml"));

            try {

                fxmlLoader.load();

            } catch(IOException e){
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            purchaseSuccessController PurchasesuccessController = fxmlLoader.getController();



            stage.show();


        });
    }

    public void setUsernameLabel(users user){ //this is for wanting to display the used username to log in on the menuController label (usernameLabel)
        usernameLabel.setText("Welcome" + " " + user.getUsername() + "!" + " " + "Select your ticket(s).");


    }


}
