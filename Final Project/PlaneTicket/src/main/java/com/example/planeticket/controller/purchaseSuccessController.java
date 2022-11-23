package com.example.planeticket.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class purchaseSuccessController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnTicketPageButton;

    @FXML
    void initialize() {

        returnTicketPageButton.setOnAction(actionEvent -> {
            returnTicketPageButton.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/menu.fxml"));

            try {

                fxmlLoader.load();

            } catch(IOException e){
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            menuController MenuController = fxmlLoader.getController();



            stage.show();
        });

    }
}
