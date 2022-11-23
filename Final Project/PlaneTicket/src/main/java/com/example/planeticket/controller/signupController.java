package com.example.planeticket.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.planeticket.database.DBHandler;
import com.example.planeticket.model.users;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstNameSignUpTextField;

    @FXML
    private TextField lastNameSignUpTextField;

    @FXML
    private TextField usernameSignUpTextField;

    @FXML
    private TextField passwordSignUpTextField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button backSignUpButton;

    @FXML
    private Label successfulSignUpPopUpLabel;

    @FXML
    void initialize() {

        DBHandler dbHandler = new DBHandler();

        successfulSignUpPopUpLabel.setVisible(false);

        signUpButton.setOnAction(actionEvent -> {
            String firstname = firstNameSignUpTextField.getText().trim();
            String lastname = lastNameSignUpTextField.getText().trim();
            String username = usernameSignUpTextField.getText().trim();
            String password = passwordSignUpTextField.getText().trim();


            users user = new users(firstname, lastname, username, password);

            if(!firstname.equals("") || !lastname.equals("") || !username.equals("") || !password.equals("") ){

                successfulSignUpPopUpLabel.setVisible(true);
                firstNameSignUpTextField.clear();
                lastNameSignUpTextField.clear();
                usernameSignUpTextField.clear();
                passwordSignUpTextField.clear();

                dbHandler.signingUp(user);

            } else {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/signupError.fxml"));

                try {

                    fxmlLoader.load(); // must put a try catch exception here because load might load the wrong file.

                } catch(IOException e){
                    e.printStackTrace(); // gives errors with more details.
                }

                Parent root = fxmlLoader.getRoot();
                Stage stage = new Stage();

                Scene scene = new Scene(root);
                stage.setScene(scene);

                signupErrorController signupErrorController = fxmlLoader.getController();



                stage.show();

            }


        });

        backSignUpButton.setOnAction(actionEvent -> {

            backSignUpButton.getScene().getWindow().hide(); // this hides the window that the backSIgnUpButton is in.

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/planeticket/login.fxml"));

            try {

                fxmlLoader.load(); // must put a try catch exception here because load might load the wrong file.

            } catch(IOException e){
                e.printStackTrace(); // gives errors with more details.
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

