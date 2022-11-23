package com.example.planeticket.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.planeticket.database.DBHandler;
import com.example.planeticket.model.contact;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class contactController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userContactTextField;

    @FXML
    private TextArea questionContactTextFIeld;

    @FXML
    private Button enterContactButton;

    @FXML
    private Button backContactButton;

    @FXML
    private Label contactPopupLabel;

    @FXML
    void initialize() {

        DBHandler dbHandler = new DBHandler();

        contactPopupLabel.setVisible(false);

        enterContactButton.setOnAction(actionEvent -> {
            String userContact = userContactTextField.getText().trim();
            String questionContact = questionContactTextFIeld.getText().trim();

            contact contacts = new contact(userContact, questionContact);

            if(!userContact.equals("") || !questionContact.equals("")) {

                contactPopupLabel.setVisible(true);
                userContactTextField.clear();
                questionContactTextFIeld.clear();

                dbHandler.contactUp(contacts);

            } else {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/contactError.fxml"));

                try {

                    fxmlLoader.load();

                } catch(IOException e){
                    e.printStackTrace();
                }

                Parent root = fxmlLoader.getRoot();
                Stage stage = new Stage();

                Scene scene = new Scene(root);
                stage.setScene(scene);

                contactErrorController ContactErrorController = fxmlLoader.getController();



                stage.show();

            }
        });

        backContactButton.setOnAction(actionEvent -> {

            backContactButton.getScene().getWindow().hide(); // this hides the window that the backSIgnUpButton is in.

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


    }
}
